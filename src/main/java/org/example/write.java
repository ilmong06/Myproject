package org.example;

import java.util.ArrayList;
import java.util.Scanner;

class write {



    static void memo(Scanner cmd) {





        while (true) {


            System.out.print("(종료 버튼 end)/할 일 입력:");
            String userInput = cmd.nextLine();
            Main.memoList.add(userInput);


            if (userInput.equals("end")) {
                Main.memoList.remove(Main.memoList.size() - 1); // 맨 마지막 요소 삭제
                for(int i = 0; i < Main.memoList.size(); i++) {
                    System.out.printf("%d.%s%n", i + 1, Main.memoList.get(i));
                }

              write.diary(cmd);
            }

            else {

            }

        }

    }

    static void diary(Scanner cmd){

        ArrayList<Integer> writenumber = new ArrayList<>();
        String diaryy;

        System.out.print("(종료 버튼 end)/일기:");
        String diaryInput = cmd.nextLine();
        diaryy = diaryInput;

        if(diaryInput.equals("end")){

        }

        for(int i = 0; i < Main.memoList.size(); i++) {
            System.out.printf("%d.%s%n", i + 1, Main.memoList.get(i));
        }
        System.out.println(diaryy);



        menu.domenu();

    }








}
