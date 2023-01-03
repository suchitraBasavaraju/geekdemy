package com.example.geektrust;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileParserTest {

    @Test
    void returnTheLinesAfterParseFile() throws FileNotFoundException {
        FileParser fileParser = new FileParser("/Users/suchitra.basavarajuthoughtworks.com/training/geektrust-solved/geekdemy/java-gradle-starter-kit/sample_input/input1.txt");
        List<String> parse = fileParser.parse();
        assertEquals(5,parse.size());
    }

    @Test
    void parseFileThrowsException() {
        FileParser fileParser = new FileParser("input1.txt");
        assertThrows(FileNotFoundException.class, fileParser::parse);
    }

    @Test
    void returnBillForInput1File() throws FileNotFoundException {
        FileParser fileParser = new FileParser("/Users/suchitra.basavarajuthoughtworks.com/training/geektrust-solved/geekdemy/java-gradle-starter-kit/sample_input/input1.txt");
        List<String> parsedLines = fileParser.parse();
        String actualValue = fileParser.parseLines(parsedLines);
        assertEquals("SUB_TOTAL 13000.00\n" +
                "COUPON_DISCOUNT B4G1 2500.00\n" +
                "TOTAL_PRO_DISCOUNT 0.00\n" +
                "PRO_MEMBERSHIP_FEE 0.00\n" +
                "ENROLLMENT_FEE 0.00\n" +
                "TOTAL 10500.00", actualValue);
    }

    @Test
    void returnBillForInput3File() throws FileNotFoundException {
        FileParser fileParser = new FileParser("/Users/suchitra.basavarajuthoughtworks.com/training/geektrust-solved/geekdemy/java-gradle-starter-kit/sample_input/input3.txt");
        List<String> parsedLines = fileParser.parse();
        String actualValue = fileParser.parseLines(parsedLines);
        assertEquals("SUB_TOTAL 5650.00\n" +
                "COUPON_DISCOUNT DEAL_G5 282.50\n" +
                "TOTAL_PRO_DISCOUNT 50.00\n" +
                "PRO_MEMBERSHIP_FEE 200.00\n" +
                "ENROLLMENT_FEE 500.00\n" +
                "TOTAL 5367.50", actualValue);
    }
}