package Day_One;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PartOne {

    public int getCalibrationValues () throws FileNotFoundException, IOException {
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
        int firstDigit = 0;
        int secondDigit = 0;
        for(int i=0; i<line.length(); i++) {
            char thisChar = line.charAt(i);
            if(Character.isDigit(thisChar)) {
                int thisDigit = Character.getNumericValue(thisChar);
                if(firstDigit == 0) {
                    firstDigit = thisDigit;
                }
                secondDigit = thisDigit;
            }
        }
        return (firstDigit*10) + secondDigit;
    }
}
