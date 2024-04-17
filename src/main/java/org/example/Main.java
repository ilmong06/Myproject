package org.example;

import java.util.Scanner;

public class Main {
    static Scanner cmd = new Scanner(System.in);

    public static void main(String[] args) {


        System.out.print("login/join 선택:");

        String maininput = cmd.nextLine();

        if(maininput.equals("login")){

            Member.login();

        } else if (maininput.equals("join")) {
            Member.join();

        }
        else {
            cmd.close();
        }


    }
}

