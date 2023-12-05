package Day_One;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        PartOne partOne = new PartOne();
        PartTwo partTwo = new PartTwo();
        System.out.println(partOne.getCalibrationValues());
        System.out.println(partTwo.getCalibrationValues());
    }
}
