package org.example;

import java.util.ArrayList;

import static org.example.Main.cmd;

class mypage {
    public static String nickname;
    static ArrayList<String> id = new ArrayList<>();
    public String pw;
    public String name;

    public mypage(String nickname, String id, String pw, String name) {
        this.nickname = member.nickname;
        this.id = member.id;
        this.pw = member.pw;
        this.name = member.name;
    }

    static void show() {
        System.out.printf("작성자 : %s %n", nickname);
       //  System.out.printf("날짜 : %s %n", );
        System.out.printf("===============메모장==============%n");
        member.write.getMemoList();
        System.out.printf("===============일기장==============%n");
        member.write.getdiaryList();

    }

}
