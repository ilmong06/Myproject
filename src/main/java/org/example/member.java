package org.example;

import java.util.ArrayList;
import java.util.Scanner;

import static org.example.Main.main;
import static org.example.Main.memoList;
import static org.example.member.*;

public class member {
    static Scanner cmd = new Scanner(System.in);

    static ArrayList<String> id = new ArrayList<>();
    public static String pw;
    public static String name;
    public static String nickname;
    String loginIdinput;
    String loginPwinput;





    static void login() {
        while (true) {
            System.out.print("아이디 :");
            String loginIdinput = cmd.nextLine();

            if (id.contains(loginIdinput)) {
                System.out.print("비밀번호:");
                String loginPwinput = cmd.nextLine();
                if (loginPwinput.equals(pw)) {
                    System.out.println("로그인 성공!");
                    menu.domenu();
                } else {
                    System.out.print("존재하지 않는 비밀번호");
                }
            } else {
                System.out.println("존재하지 않는 아이디");
                main(new String[]{});
            }
        }
    }

    static void join() {
        System.out.print("아이디 생성: ");
        String joinIdinput = cmd.nextLine();

        if (id.contains(joinIdinput)) {
            System.out.println("이미 존재하는 아이디입니다.");
            main(new String[]{});
        } else {
            id.add(joinIdinput);
            System.out.print("비밀번호 생성: ");
            String joinPwinput = cmd.nextLine();
            pw = joinPwinput;

            System.out.print("이름: ");
            String nameinput = cmd.nextLine();
            name = nameinput;

            System.out.print("닉네임: ");
            String nicknameinput = cmd.nextLine();
            nickname = nicknameinput;

            System.out.println("------로그인 페이지로 이동-------");
            login();
        }
    }


    class write {

        static String diaryy;

        static void memo(Scanner cmd) {



            while (true) {
                System.out.print("(종료 버튼 end)/할 일 입력:");
                String userInput = cmd.nextLine();
                memoList.add(userInput);

                if (userInput.equals("end")) {
                    memoList.remove(memoList.size() - 1); // 맨 마지막 요소 삭제


                    member.write.diary(cmd);
                    break; // 종료 버튼 입력 시 메모 입력 종료
                }
            }
        }

        public static ArrayList<String> getMemoList() {


           //int lastId = id.size();(mypage겁색했을때 aa작성자와 bb작성자가
            //동일한 글이 나옴

            for(int i = 0; i < memoList.size(); i++) {
                System.out.printf("%d.%s%n", i + 1, memoList.get(i));
            }
            return memoList;

        }

        static void diary(Scanner cmd) {

            ArrayList<Integer> writenumber = new ArrayList<>();


            System.out.print("(종료 버튼 end)/일기:");
            String diaryInput = cmd.nextLine();
            diaryy = diaryInput;

            if (diaryInput.equals("end")) {

            }

            for (int i = 0; i < memoList.size(); i++) {
                System.out.printf("%d.%s%n", i + 1, memoList.get(i));
            }
            System.out.println(diaryy);

            menu.domenu();


        }


        static void getdiaryList() {

            System.out.println(diaryy);


        }


    }

}