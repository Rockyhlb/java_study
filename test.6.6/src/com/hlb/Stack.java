package com.hlb;

import java.util.LinkedList;

public class Stack {

    LinkedList<String> linkedList = new LinkedList<>();

    void push(String str){
        linkedList.addLast(str);
    }

    String pop(){
        return linkedList.removeLast();
    }
}
