package com.kakaoexample.winter2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

public class ex3 {

    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String REMOVE = "C";
    private static final String UNDO = "Z";

    private int currentRow;
    private int currentSize;
    private Stack<Integer> removed = new Stack<>();


    public String solution(int n, int k, String[] cmd) {
        currentRow = k;
        currentSize = n;

        for (String input : cmd) {
            String command = input.substring(0, 1);

            switch (command) {
                case UP:
                    up(Integer.parseInt(input.substring(2)));
                    break;
                case DOWN:
                    down(Integer.parseInt(input.substring(2)));
                case REMOVE:
                    remove();
                    break;
                case UNDO:
                    undo();
                    break;

            }


        }


        String answer = "";

        return answer;
    }

    private void up(int count) {
        currentRow -= count;
    }

    private void down(int count) {
        currentRow += count;
    }

    private void remove() {
        removed.push(currentRow);
        currentSize--;
        if (currentRow == currentSize) {
            currentRow--;
        }
    }

    private void undo() {
        int row = removed.pop();
        currentSize++;
        if (row <= currentRow) {
            currentRow++;
        }

    }

    private String buildAnswer() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<currentSize;i++){
            sb.append("0");
        }
        // 이렇게 하는이유 0을 현재 남은 사이즈에 추가한다음에
        while(!removed.isEmpty()){
            sb.insert(removed.pop(),"X");
        }

        // stack에 있는 숫자들로 sb.insert()를 이용해서 그 위치에 X 를 넣기위함임.
        return sb.toString();
    }


}


