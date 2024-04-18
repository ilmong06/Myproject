package org.example;

import java.util.Scanner;

public class menu {
    static String loggedInUserId;

    static void domenu() {
        Scanner cmd = new Scanner(System.in);

        System.out.println("*******************menu*******************");
        System.out.println("*         write | modify | show        *");
        System.out.println("*        delete | logout | mypage        *");
        System.out.println("******************************************");

        while (true) {
            System.out.print("메뉴검색:");
            String input = cmd.nextLine();

            if (input.equals("exit")) {
                break;
            }

            if (input.equals("write")) {
                Member.writeMemo(loggedInUserId);
                Member.writeDiary(loggedInUserId);
            }

            if (input.equals("modify")) {
                // modify 기능 호출
            }

            if (input.equals("detail")) {
                // detail 기능 호출
            }

            if (input.equals("show")) {
                // show 기능 호출
            }

            if (input.equals("mypage")) {
                mypage.show(loggedInUserId);
                mypage.finish();
            }

            if (input.equals("logout")) {
                System.out.println("로그아웃 완료");
                loggedInUserId = null;
                Main.main(new String[] {});
            }
        }

        cmd.close();
    }

    static void setLoggedInUserId(String userId) {
        loggedInUserId = userId;
    }


}