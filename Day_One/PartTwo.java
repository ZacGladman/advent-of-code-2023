package Day_One;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Dictionary;
import java.util.Hashtable;

public class PartTwo {

    public int getCalibrationValues () throws IOException {
        int result = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("./Day_One/words.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                result += parseLine(line);
            }
            return result;
        }
    }
    private int parseLine(String line) {
        String lowercaseLine = line.toLowerCase();
        int firstDigit = 0;
        int secondDigit = 0;
        StringBuilder currentString = new StringBuilder();
        for(int i=0; i<lowercaseLine.length(); i++) {
            char thisChar = lowercaseLine.charAt(i);
            if(Character.isDigit(thisChar)) {
                int thisDigit = Character.getNumericValue(thisChar);
                if(firstDigit == 0) {
                    firstDigit = thisDigit;
                }
                secondDigit = thisDigit;
            } else {
                currentString.append(thisChar);
                Integer stringAsNum = stringIsWrittenNumber(currentString);
                if(stringAsNum != null) {
                    if(firstDigit == 0) {
                        firstDigit = stringAsNum;
                    }
                    secondDigit = stringAsNum;
                    currentString = new StringBuilder();
                    currentString.append(thisChar);
                }
            }
        }
        return (firstDigit*10) + secondDigit;
    }

    private Integer stringIsWrittenNumber(StringBuilder s) {
        String sAsString = s.toString();
        String[] stringNums = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        Dictionary<String, Integer> numsDict = new Hashtable<>();
        for(int i=0; i<9; i++) {
            numsDict.put((String) Array.get(stringNums, i), i+1);
        }
        for(String el : stringNums) {
            if(sAsString.contains(el)) {
                return numsDict.get(el);
            }
        }
        return null;
    }
}

// eightwothree