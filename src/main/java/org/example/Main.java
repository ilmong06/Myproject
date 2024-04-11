package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner cmd = new Scanner(System.in);
    static  ArrayList<String> memoList = new ArrayList<>();
    public static void main(String[] args) {


        System.out.print("로그인/회원가입 선택:");

        String maininput = cmd.nextLine();

        if(maininput.equals("로그인")){

            member.login();

        } else if (maininput.equals("회원가입")) {
            member.join();

        }
        else {
            cmd.close();
        }


    }






}



