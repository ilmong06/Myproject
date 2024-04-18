package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


import static org.example.Main.main;


public class Member {
 // private static  ArrayList<String> memoList = new ArrayList<>();
  private static HashMap<String, ArrayList<String>> userMemo = new HashMap<>();

    static ArrayList<String> id = new ArrayList<>();

    static Scanner cmd = new Scanner(System.in);

    //static HashMap<String, ArrayList<String>> userMemo = new HashMap<>(); // 회원의 메모를 저장하는 HashMap
    // static HashMap<String, String> userDiary = new HashMap<>(); // 회원의 일기를 저장하는 HashMap
    //private static HashMap<String, ArrayList<String>> userMemo = new HashMap<>(); // 회원의 메모를 저장하는 HashMap
    private static HashMap<String, String> userDiary = new HashMap<>(); // 회원의 일기를 저장하는 HashMap
    public static String pw;
    public static String name;
    public static String nickname;
    static String loginIdinput;
    static String loginPwinput;
    static void resetLoginPwinput() {
        loginPwinput = null;
    }

    static String lastId;
    static String diaryy;
    static String userInput = cmd.nextLine();
    private static HashMap<String, String> credentials = new HashMap<>(); // 회원 정보를 저장하는 HashMap
    private static HashMap<String, ArrayList<String>> userPosts = new HashMap<>(); // 회원이 작성한 글을 저장하는 HashMap

    static void login() {
        while (true) {
            System.out.print("아이디: ");
            loginIdinput = cmd.nextLine();
            System.out.print("비밀번호: ");
            loginPwinput = cmd.nextLine();

            if (credentials.containsKey(loginIdinput)) {
                String storedPw = credentials.get(loginIdinput);
                if (storedPw.equals(loginPwinput)) {
                    System.out.println("\u001B[31m로그인 성공!\u001B[0m");
                    menu.setLoggedInUserId(loginIdinput);
                    menu.domenu();
                    break;
                } else {
                    System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
                }
            } else {
                System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
            }
        }
    }

    static void join() {
        System.out.print("아이디 생성: ");
        String joinIdinput = cmd.nextLine();

        if (credentials.containsKey(joinIdinput)) {
            System.out.println("이미 존재하는 아이디입니다.");
            main(new String[]{});
        } else {
            // 아이디가 중복되지 않으면 회원가입 진행
            System.out.print("비밀번호 생성: ");
            String joinPwinput = cmd.nextLine();
            pw = joinPwinput;

            System.out.print("이름: ");
            String nameinput = cmd.nextLine();
            name = nameinput;

            System.out.print("닉네임: ");
            String nicknameinput = cmd.nextLine();
            nickname = nicknameinput;

            credentials.put(joinIdinput, joinPwinput); // 회원 정보 저장
            userPosts.put(joinIdinput, new ArrayList<>()); // 회원의 글 목록 초기화
            userMemo.put(joinIdinput, new ArrayList<>()); // 회원의 메모 목록 초기화
            userDiary.put(joinIdinput, ""); // 회원의 일기 초기화

            System.out.println("----------회원가입 완료----------");
            System.out.println("------로그인 페이지로 이동-------");
            login(); // 회원가입 완료 후 바로 로그인 페이지로 이동
        }
    }


    static void writeMemo(String loggedInUserId) {
        while (true) {
            System.out.print("메모 작성: ");
            String userInput = cmd.nextLine(); // 사용자 입력 받기
            ArrayList<String> memoList = userMemo.getOrDefault(loggedInUserId, new ArrayList<>());
            memoList.add(userInput); // 해당 회원의 메모 목록에 추가
            userMemo.put(loggedInUserId, memoList);

            if (userInput.equals("end")) {
                memoList.remove(memoList.size() - 1);
                System.out.println("메모가 작성되었습니다.");
                break;
            }
        }
    }

    static void viewMemo(String loggedInUserId, ArrayList<String> blist) {
        ArrayList<String> memoList = userMemo.getOrDefault(loggedInUserId, new ArrayList<>());
        if (memoList.isEmpty()) {
            System.out.println("작성된 메모가 없습니다.");
        } else {
            System.out.println("===== 작성된 메모 목록 =====");
            for (int i = 0; i < memoList.size(); i++) {
                System.out.printf("%d. %s%n", i + 1, memoList.get(i));
            }

            System.out.print("\u001B[31m" +"(완료)"+"\u001B[0m");
            System.out.println("\u001B[31m" +mypage.blist +"\u001B[0m");

        }
    }


    static void writeDiary(String loggedInUserId) {
        System.out.print("일기: ");
        String diaryInput = cmd.nextLine();
        userDiary.put(loggedInUserId, diaryInput);
        menu.domenu();
    }

    static void viewDiary(String loggedInUserId) {
        String diary = userDiary.getOrDefault(loggedInUserId, "");
        if (diary.isEmpty()) {
            System.out.println("작성된 일기가 없습니다.");
        } else {
            System.out.println("===== 작성된 일기 =====");
            System.out.println(diary);
        }
    }
    public static ArrayList<String> getMemoList(String loggedInUserId) {
        return userMemo.getOrDefault(loggedInUserId, new ArrayList<>());
    }
}