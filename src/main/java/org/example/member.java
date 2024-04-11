package org.example;

import java.util.ArrayList;
import java.util.Scanner;
import org.example.menu;
import static org.example.Main.main;


public class member {
    static Scanner cmd = new Scanner(System.in);

    static ArrayList<String> id = new ArrayList<>();
    static String pw;
    static String name;
    static String nickname;
    String loginIdinput;
    String loginPwinput;


    static void login() {

        while (true){

            System.out.print("아이디 :");
            String loginIdinput = cmd.nextLine();

            if (id.contains(loginIdinput)){

                System.out.print("비밀번호:");
                String loginPwinput = cmd.nextLine();

                if(loginPwinput.equals(pw)){

                    System.out.println("로그인 성공!");
                    menu.domenu();
                }
                else {
                    System.out.print("존재하지 않는 비밀번호");
                }


            }
            else {
                System.out.println("존재하지 않는 아이디");

                main(new String[] {});

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
}

