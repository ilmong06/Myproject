package org.example;

import java.util.ArrayList;
import java.util.Scanner;

import static org.example.Main.memoList;

class write {

    static String diaryy;

    static void memo(Scanner cmd) {
        while (true) {
            System.out.print("(종료 버튼 end)/할 일 입력:");
            String userInput = cmd.nextLine();
            memoList.add(userInput);

            if (userInput.equals("end")) {
                memoList.remove(memoList.size() - 1); // 맨 마지막 요소 삭제


                write.diary(cmd);
                break; // 종료 버튼 입력 시 메모 입력 종료
            }
        }
    }
    static ArrayList<String> getMemoList() {

        for(int i = 0; i < memoList.size(); i++) {
            System.out.printf("%d.%s%n", i + 1, memoList.get(i));
        }
        return memoList;
    }

    static void diary(Scanner cmd){

        ArrayList<Integer> writenumber = new ArrayList<>();


        System.out.print("(종료 버튼 end)/일기:");
        String diaryInput = cmd.nextLine();
        diaryy = diaryInput;

        if(diaryInput.equals("end")){

        }

        for(int i = 0; i < memoList.size(); i++) {
            System.out.printf("%d.%s%n", i + 1, memoList.get(i));
        }
        System.out.println(diaryy);

        menu.domenu();




    }



    static void getdiaryList() {

        System.out.println(diaryy);


    }






}