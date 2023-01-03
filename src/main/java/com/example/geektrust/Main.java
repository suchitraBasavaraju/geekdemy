package com.example.geektrust;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        try {
            String fileName = args[0];
            FileParser fileParser = new FileParser(fileName);
            List<String> parsedLines = fileParser.parse();

            String bill = fileParser.parseLines(parsedLines);
            System.out.println(bill);
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        }
    }

}

