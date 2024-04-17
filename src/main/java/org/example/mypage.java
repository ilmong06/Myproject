package org.example;

import java.util.ArrayList;
import java.util.Scanner;


import static org.example.menu.domenu;
import static org.example.menu.loggedInUserId;

class mypage {

    static void show(String loggedInUserId) {
        System.out.printf("작성자 : %s %n", loggedInUserId);
        System.out.printf("===================================%n");
        Member.viewMemo(loggedInUserId);

        System.out.printf("===================================%n");
        Member.viewDiary(loggedInUserId);
    }


    static void finish(){
        System.out.printf("체크 할 항목을 선택하세요:");
        Scanner finishscanner = new Scanner(System.in);
        int check = finishscanner.nextInt();

        // 로그인된 사용자의 메모리스트를 가져옴
        ArrayList<String> memoList = Member.getMemoList(loggedInUserId);

        // 입력된 번호가 유효한지 검증
        if (memoList.size() > check) {
            memoList.remove(check - 1);
            Member.viewMemo(loggedInUserId);
        }
        else if (check == 0) {
            domenu();

        }
        else {
            System.out.println("해당 번호가 존재하지 않습니다.");
        }

    }

}

