
package Day_Two;

        import java.io.BufferedReader;
        import java.io.FileReader;
        import java.io.IOException;
        import java.util.HashMap;
        import java.util.Map;

public class PartTwo {
    public int getResult () throws IOException {
        int res = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("./Day_Two/games.csv"))) {
            String game;
            while ((game = br.readLine()) != null) {
                Integer powerSet = checkGame(game);
                res += powerSet;
            }
            return res;
        }
    }

    private Integer checkGame(String game) {

        Map<String, Integer> colourMinimums = new HashMap<>();
        colourMinimums.put("red", 0);
        colourMinimums.put("green", 0);
        colourMinimums.put("blue", 0);

        String[] rounds = game.split(": ")[1].split("; ");
        for(String round : rounds) {
            String[] cubes = round.split(", ");
            for(String cube : cubes) {
                String[] splitCube = cube.split(" ");
                int quantity = Integer.parseInt(splitCube[0]);
                String colour = splitCube[1];
                if(quantity > colourMinimums.get(colour)) {
                    colourMinimums.replace(colour, quantity);
                }
            }
        }
        return colourMinimums.get("red") * colourMinimums.get("green") * colourMinimums.get("blue");
    }
}