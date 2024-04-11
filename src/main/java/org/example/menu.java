package org.example;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

import static org.example.Main.main;

public class menu {

    static  void domenu() {
        Scanner cmd = new Scanner(System.in);

        System.out.println("write");
        System.out.println("modify");
        System.out.println("detail");
        System.out.println("delete");
        System.out.println("logout");
        mypage page = new mypage("nickname", "id", "pw", "name");

        while (true) {
            System.out.print("메뉴검색:");
            String input = cmd.nextLine();

            if (input.length() == 0) {
                continue;
            }

            if (input.equals("exit")) {
                break;
            }

            if (input.equals("write")) {
                write.memo(cmd);
                write.diary(cmd);
            }

            if (input.equals("modify")) {
                // Modify logic here
            }

            if (input.equals("detail")) {
                // Detail logic here
            }

            if (input.equals("show")) {
                // Show logic here
            }

            if (input.equals("mypage")) {
                page.show();

            }

            if (input.equals("logout")){
                String id;
                String pw;

                System.out.println("로그아웃 완료");
                main(new String[] {});
            }
        }

        cmd.close();
    }
}


class mypage{
    public static String nickname;
    static ArrayList<String> id = new ArrayList<>();
    public String pw;
    public String name;

    public mypage (String nickname, String id, String pw, String name) {
        this.nickname = member.nickname;
        this.id = member.id;
        this.pw = member.pw;
        this.name = member.name;
    }

   static void show() {
        System.out.printf("작성자 : %s %n",  nickname);
    }
}