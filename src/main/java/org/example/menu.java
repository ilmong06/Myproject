package org.example;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

import static org.example.Main.main;

public class menu {

    static  void domenu() {
        Scanner cmd = new Scanner(System.in);

        System.out.println("\u001B[44m\u001B[30m*******************menu*******************\u001B[0m");
        System.out.println("\u001B[44m\u001B[30m*      write | modify | detail           *\u001B[0m");
        System.out.println("\u001B[44m\u001B[30m*       show | logout | delate           *\u001B[0m");
        System.out.println("\u001B[44m\u001B[30m******************************************\u001B[0m\u001B[0m");



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
                member.write.memo(cmd);
                member.write.diary(cmd);
            }

            if (input.equals("modify")) {

            }

            if (input.equals("detail")) {

            }

            if (input.equals("show")) {

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


