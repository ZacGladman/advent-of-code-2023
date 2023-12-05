package Day_Two;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PartOne {
    public int getResult () throws IOException {
        int res = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("./Day_Two/games.csv"))) {
            String game;
            while ((game = br.readLine()) != null) {
                Integer validGameID = checkGame(game);
                if(validGameID != null) {
                    res += validGameID;
                }
            }
            return res;
        }
    }

    private Integer checkGame(String game) {
        Map<String, Integer> colourLimits = new HashMap();
        colourLimits.put("red", 12);
        colourLimits.put("green", 13);
        colourLimits.put("blue", 14);
        String[] splitGame = game.split(": ");
        int gameID = Integer.parseInt(splitGame[0].split(" ")[1]);
        String[] rounds = splitGame[1].split("; ");
        for(String round : rounds) {
            String[] cubes = round.split(", ");
            for(String cube : cubes) {
                String[] splitCube = cube.split(" ");
                int quantity = Integer.parseInt(splitCube[0]);
                String colour = splitCube[1];
                if(quantity > colourLimits.get(colour)) {
                    return null;
                }
            }
        }
        return gameID;
    }
}
