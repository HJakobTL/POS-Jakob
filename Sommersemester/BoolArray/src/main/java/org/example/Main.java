package org.example;

public class Main {
    static void main() {

        boolean[][] b1 = new boolean[][]{
                {true,true,false,false},
                {true,false,true,true},
                {true,true,false,true},
                {false,false,false,true},
                {true,true,false,false}
        };

        // 5 ist das größte Feld

        BArray test = new BArray(b1);
        IO.println(test.GebieteFinder());



    }
}
