package com.coder.sanam;

import java.util.Arrays;

public class Spreadsheet {

    public static void main(String[] args) {
        Spreadsheet spreadsheet = new Spreadsheet(3);
        spreadsheet.setCell("A0",5);
        spreadsheet.setCell("B0",3);
        int cell = spreadsheet.getCell("A0");
        System.out.println(spreadsheet.getCell("A1"));
        System.out.println(cell);
        int value = spreadsheet.getValue("=A0+B0");
        System.out.println(value);
        System.out.println(spreadsheet.getValue("=5+5"));
    }

    int[][] sheet;
    public Spreadsheet(int rows) {
        sheet  = new int[rows][26];

    }

    public void setCell(String cell, int value) {
        int[] arr = convertToArr(cell);
        sheet[arr[0]][arr[1]] = value;

    }

    private int[] convertToArr(String cell) {
        char ch = cell.toCharArray()[0];
        int col = ch - 'A';
        int row  = Integer.parseInt(cell.substring(1));
        return new int[]{row, col};
    }

    public int getCell(String cell) {
        int[] arr = convertToArr(cell);
        return sheet[arr[0]][arr[1]];

    }


    public void resetCell(String cell) {
        setCell(cell,0);
    }

    public int getValue(String formula) {
        int sum = 0;
        String[] references = formula.replace("=","").split("\\+");
        String firstPart = references[0];

        if(Character.isLetter(firstPart.toCharArray()[0])){
            sum += getCell(firstPart);
        }else{
            sum += Integer.parseInt(firstPart);
        }
        String secondPart = references[1];
        if(Character.isLetter(secondPart.toCharArray()[0])){
            sum += getCell(secondPart);
        }else{
            sum += Integer.parseInt(secondPart);
        }
        return sum;
    }
}
