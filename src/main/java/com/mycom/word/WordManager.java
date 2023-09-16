package com.mycom.word;

import java.util.Scanner;

public class WordManager {
    Scanner s = new Scanner(System.in);
    WordCRUD wordCRUD;
    public int selectMenu() {
        System.out.print("***************************\n" +
                        "1. 모든 단어 보기 (See all words)\n" +
                        "2. 수준별 단어 보기(Search by level)\n" +
                        "3. 단어 검색 (Word Search)\n" +
                        "4. 단어 추가 (Add a word)\n" +
                        "5. 단어 수정 (Edit a word)\n" +
                        "6. 단어 삭재 (Delete a word)\n" +
                        "7. 파일 저장 (Save a file)\n" +
                        "0. 나가기 (Exit)\n" +
                        "***************************\n" +
                        "=> 원하는 매뉴는?\n"

                );
        return s.nextInt();
    }
    WordManager() {
        wordCRUD = new WordCRUD(s);
    }

    public void start() {
        wordCRUD.loadFile();
        while(true) {
            int menu = selectMenu();
            if(menu == 0) {
                System.out.println("Program finished");
                break;

            }
            else if(menu == 4) {
                wordCRUD.addItem();
            }
            else if(menu == 1) {
                wordCRUD.listAll();
            }
            
            else if(menu == 2) {
                wordCRUD.searchLevel();
            }
            else if(menu == 3) {
                wordCRUD.searchWord();
            }

            else if (menu == 5 ) { // update
                wordCRUD.updateItem();
            }
            else if (menu == 6 ) { // delete
                wordCRUD.deleteItem();

            }
            else if (menu == 7) {
                wordCRUD.saveFile();
            }
        }
    }

}
