package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        boolean successful = true;
        Stack brackets = new Stack();
        Scanner in = new Scanner(System.in);
        char[] s = in.next().toCharArray();
        for (int i = 0; i < s.length; i++){
            if (s[i] == '{' || s[i] == '(' ||  s[i] == '[')
                brackets.add(s[i], i);
            if (s[i] == '}' || s[i] == ')' ||  s[i] == ']'){
                if (brackets.isEmpty() || brackets.getPair() != s[i]){
                    System.out.println(i+1);
                    successful = false;
                    break;
                }else{
                    brackets.delete();
                }
            }
        }
        if (successful && !brackets.isEmpty()){
            System.out.println(brackets.current());
        }else{
            if (successful)
                System.out.println("Success");
        }
    }
}

class Stack{
    List<Character> items;
    List<Integer> indexes;
    int pos;

    public Stack(){
        items = new ArrayList<>();
        indexes = new ArrayList<>();
        pos = -1;
    }

    public void add(char item, int ind){
        items.add(item);
        indexes.add(ind);
        pos++;
    }

    public void delete(){
        items.remove(pos);
        indexes.remove(pos);
        pos--;
    }

    public int current(){
        return indexes.get(pos) + 1;
    }

    public boolean isEmpty(){
        return items.isEmpty();
    }

    public char getPair(){
        switch (items.get(pos)){
            case '{':
                return '}';
            case '[':
                return ']';
            default:
                return ')';
        }
    }
}
