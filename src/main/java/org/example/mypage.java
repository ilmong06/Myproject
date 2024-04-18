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

        // 회원별 날짜별 메모 출력
        HashMap<String, HashMap<String, ArrayList<String>>> memoByDate = Member.getMemoByDate();
        HashMap<String, ArrayList<String>> userMemoByDate = memoByDate.getOrDefault(loggedInUserId, new HashMap<>());

        for (String date : userMemoByDate.keySet()) {
            System.out.println("날짜: " + date);
            ArrayList<String> memoList = userMemoByDate.get(date);
            for (int i = 0; i < memoList.size(); i++) {
                System.out.printf("%d. %s%n", i + 1, memoList.get(i));
            }
            System.out.println(); // 각 날짜의 메모 출력 후 한 줄 띄기
        }

        System.out.printf("===================================%n");
        Member.viewDiary(loggedInUserId);
    }
    static void viewMemoByDate(String loggedInUserId) {
        HashMap<String, HashMap<String, ArrayList<String>>> memoByDate = Member.getMemoByDate();
        HashMap<String, ArrayList<String>> userMemoByDate = memoByDate.getOrDefault(loggedInUserId, new HashMap<>());

        if (userMemoByDate.isEmpty()) {
            System.out.println("작성된 메모가 없습니다.");
        } else {
            System.out.println("===== 작성된 메모 목록 =====");
            for (String date : userMemoByDate.keySet()) {
                System.out.printf("[%s]%n", date);
                ArrayList<String> memoList = userMemoByDate.get(date);
                for (int i = 0; i < memoList.size(); i++) {
                    System.out.printf("%d. %s%n", i + 1, memoList.get(i));
                }
            }
        }
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