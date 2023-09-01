package com.mycom.word;

import java.util.Scanner;

public class WordManager {
    Scanner s = new Scanner(System.in);
    WordCRUD wordCRUD;
    public int selectMenu() {
        System.out.print(" MENU! ");
        return s.nextInt();
    }
    WordManager() {
        wordCRUD = new WordCRUD(s);
    }

    public void start() {
        while(true) {
            int menu = selectMenu();
            if(menu == 0) break;
            if(menu == 4) {
                wordCRUD.addWord();
            }
            else if(menu == 1) {
                wordCRUD.listAll();
            }

        }
    }


}
