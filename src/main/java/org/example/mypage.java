package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


import static org.example.menu.loggedInUserId;

class mypage {
    static String b;
    static HashMap<String, ArrayList<String>> blist = new HashMap<>(); // blist를 HashMap으로 변경

    static void show(String loggedInUserId) {
        System.out.printf("작성자 : %s %n", loggedInUserId);
        System.out.printf("===================================%n");
        Member.viewMemo(loggedInUserId,blist);

        System.out.printf("===================================%n");
        Member.viewDiary(loggedInUserId);
    }


    static void finish() {
        System.out.printf("체크 할 항목을 선택하세요:");
        Scanner finishscanner = new Scanner(System.in);
        int check = finishscanner.nextInt();

        ArrayList<String> memoList = Member.getMemoList(loggedInUserId);

        if (memoList.size() > check) {
            b = memoList.get(check - 1);
            ArrayList<String> userBlist = blist.getOrDefault(loggedInUserId, new ArrayList<>());
            userBlist.add(b);
            blist.put(loggedInUserId, userBlist);
            memoList.remove(check - 1);
            Member.viewMemo(loggedInUserId, blist);
        } else {
            System.out.println("해당 번호가 존재하지 않습니다.");
        }
    }
}

