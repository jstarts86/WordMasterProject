package com.mycom.word;

import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD{
    ArrayList<Word> list;
    Scanner s;
    WordCRUD(Scanner s) {
        list = new ArrayList<>();
        this.s = s;
    }
    @Override
    public Object add() {
        System.out.print("Level (1,2,3) & New word registry : ");
        int level = s.nextInt();
        String word = s.nextLine();


        System.out.print("Added meaning :");
        String meaning = s.nextLine();
        return new Word(0, level, word, meaning);
    }

    public void addItem() {
        Word one = (Word)add();
        list.add(one);
        System.out.println(" A new Word has been added");
    }

    @Override
    public int update(Object obj) {
        return 0;
    }

    @Override
    public int delete(Object obj) {
        return 0;
    }

    @Override
    public void selectOne(int id) {

    }
    public ArrayList<Integer> listAll(String keyword) {

        ArrayList<Integer> idlist = new ArrayList<>();
        int j = 0;
        System.out.println("-----------------------------");
        for(int i = 0; i < list.size(); i++) {
            String word = list.get(i).getWord();
            if(!word.contains(keyword)) continue;
            System.out.print((i+1) + " ");
            System.out.println(list.get(i).toString());
            idlist.add(i);
            j++;
        }
        System.out.println("-----------------------------");
        return idlist;
    }

    public void listAll() {
        System.out.println("-----------------------------");
        for(int i = 0; i < list.size(); i++) {
            System.out.print((i+1) + " ");
            System.out.println(list.get(i).toString());
        }
        System.out.println("-----------------------------");
    }


    public void updateItem() {
        System.out.print(" => The word you are updating : ");
        String keyword = s.next();
        ArrayList<Integer> idlist = this.listAll(keyword);
        System.out.print(" => The number you want to update : ");
        int id = s.nextInt(); // must add next line so the enter does not get entered with the meaning
        s.nextLine();
        System.out.print(" => enter the meaning: ");
        String meaning = s.nextLine();
        Word word = list.get(idlist.get(id-1));
        word.setMeaning(meaning);
        System.out.println("Word has sucessfully updates");
    }

    public void deleteItem() {
        System.out.print(" => The word you are deleting : ");
        String keyword = s.next();
        ArrayList<Integer> idlist = this.listAll(keyword);
        System.out.print(" => The number you want to delete : ");
        int id = s.nextInt(); // must add next line so the enter does not get entered with the meaning
        s.nextLine();
        System.out.print("=> Are you sure you want to deletse?(Y/n) ");

        String ans = s.next();
        if(ans.equalsIgnoreCase("y")) {
            list.remove((int)idlist.get(id-1));
            System.out.println("Sucessfully Deleted");
        } else
            System.out.println("Canceled Successfully");
    }
}
