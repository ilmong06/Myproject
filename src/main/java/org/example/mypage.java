package org.example;




import static org.example.menu.loggedInUserId;

class mypage {


    static void show(String loggedInUserId) {
        System.out.printf("작성자 : %s %n", loggedInUserId);
        System.out.printf("===============메모장==============%n");
        Member.viewMemo(loggedInUserId);

        System.out.printf("===============일기장==============%n");
        Member.viewDiary(loggedInUserId);
    }
}
