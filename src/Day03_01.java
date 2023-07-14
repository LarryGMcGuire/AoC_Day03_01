    import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class Day03_01 {

    public static void main(String[] args) throws IOException, FileNotFoundException{
        Path current = Paths.get(".");
        String s = current.toAbsolutePath().toString();
        System.out.println("Path" + s);

        File inputTxt = new File("src/2022/day01/input.txt");
        BufferedReader input = new BufferedReader(new FileReader(inputTxt));
        String string;
        String x, y;
        String[] split;

        ArrayList<String> xyzList = new ArrayList<>();

        while ((string = input.readLine()) != null){
            xyzList.add(string);
        }
        input.close();
        int pointsValue = 0;

        for (String i: xyzList){
            // How long is this line?  Divide it in half
            int points = 0;
            int lineLength = i.length();
            String firstRuck = i.substring(0, lineLength/2);
            String secondRuck = i.substring((lineLength/2), lineLength);
            System.out.println("Ruck1 = " + firstRuck);
            System.out.println("Ruck2 = " + secondRuck);

            // Look through the first Rucksack.  Does anything also appear in the second rucksack?
            for (int j=0; j<firstRuck.length() && points ==0 ; j++) {
                char c = firstRuck.charAt(j);
                //Is this in the second rucksack?
                for (int k=0; k<secondRuck.length(); k++) {
                    if (c == secondRuck.charAt(k)) {
                        System.out.println("We have a match! " + c);
                        // What is that match worth?
                        int castAscii = (int) c;
                        if (castAscii >= 97 && castAscii <=122){
                            points = castAscii - 96;
                        }
                        else {
                            points = castAscii - 38;
                        }
                        System.out.println("    castAScii value: " + castAscii);
                        System.out.println("    points value: " + points);
                        pointsValue += points;

                        break;
                    }
                }

            }


        }

        System.out.println("  POINTS VALUE = " + pointsValue);

    }

}
