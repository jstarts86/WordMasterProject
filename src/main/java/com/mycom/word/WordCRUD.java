package com.mycom.word;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD{
    ArrayList<Word> list;
    Scanner s;
    final String fname = "Dictionary.txt";
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
        System.out.print(" => The number you  want to update : ");
        int id = s.nextInt(); // must add next line so the enter does not get entered with the meaning
        s.nextLine();
        System.out.print(" => enter the meaning: ");
        String meaning = s.nextLine();
        Word word = list.get(idlist.get(id-1));
        word.setMeaning(meaning);
        System.out.println("Word has been successfully updates");
    }

    public void deleteItem() {
        System.out.print(" => The word you are deleting : ");
        String keyword = s.next();
        ArrayList<Integer> idlist = this.listAll(keyword);
        System.out.print(" => The number you want to delete : ");
        int id = s.nextInt(); // must add next line so the enter does not get entered with the meaning
        s.nextLine();
        System.out.print("=> Are you sure you want to delete?(Y/n) ");

        String ans = s.next();
        if(ans.equalsIgnoreCase("y")) {
            list.remove((int)idlist.get(id-1));
            System.out.println("Successfully Deleted");
        } else
            System.out.println("Canceled Successfully");
    }

    public void loadFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fname));
            String line;
            int count = 0;
            while(true) {

                line = br.readLine();
                if(line == null) break;

                String data[] = line.split("\\|");
                int level = Integer.parseInt(data[0]);
                String word = data[1];
                String meaning = data[2];
                list.add(new Word(0, level, word, meaning));
                count++;


            }
            br.close();
            System.out.println("==> " + count + " File loading done!");
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public void saveFile() {
        try {
            PrintWriter pr = new PrintWriter(new FileWriter(fname));
            for(Word one : list) {
                pr.write(one.toFileString() + "\n");
            }
            pr.close();
            System.out.println("==> Data saved Correctly!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public ArrayList<Integer> listAll(int level) {
        ArrayList<Integer> idlist = new ArrayList<>();
        int j = 0;
        System.out.println("-----------------------------");
        for(int i = 0; i < list.size(); i++) {
            int ilevel = list.get(i).getLevel();
            if(ilevel != level) continue;
            System.out.print((j+1) + " ");
            System.out.println(list.get(i).toString());
            j++;
        }
        System.out.println("-----------------------------");
        return idlist;
    }
    public void searchLevel() {
        System.out.print("What level? (1-3) ");
        int level = s.nextInt();
        listAll(level);
    }

    public void searchWord() {
        System.out.print("=> What word do you want? ");
        String keyword = s.next();
        listAll(keyword);
    }
}
