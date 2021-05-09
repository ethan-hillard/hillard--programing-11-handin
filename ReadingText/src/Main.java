import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        String FileToSearch = "ProgrammingHistory.txt";
        String WordToFind= "By";

        ArrayList<String> lines = convertFileToLines(FileToSearch);
        ArrayList<ArrayList<Integer>> WordToFindLocations = findLocations(lines, WordToFind);
        printResults(WordToFind, WordToFindLocations);
    }

        public static ArrayList<String> convertFileToLines(String FileToSearch) throws IOException{
        ArrayList<String> lines = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(FileToSearch));

        int ReadLineInTxt;
        String lineStorage = "";
        while((ReadLineInTxt = br.read()) != -1) {
            char character = (char) ReadLineInTxt;

            String line = Character.toString(character);
            lineStorage += line;

            if (ReadLineInTxt == '\n') {
                lines.add(lineStorage);
                lineStorage = null;
            }
        }
        br.close();

        return lines;
    }

    public static ArrayList<ArrayList<Integer>> findLocations(ArrayList<String> lines, String WordToFind){
        ArrayList<ArrayList<Integer>> locations = new ArrayList<>();

        for (int lineIndex = 0; lineIndex < lines.size(); lineIndex++) {
            String line = lines.get(lineIndex);
            // search for WordToFind in line.
            int Start = 0;
            int PlaceInLine;
            while ((PlaceInLine = line.indexOf(WordToFind, Start)) != -1) {
                //found a match
                ArrayList<Integer> location = new ArrayList<>();
                location.add(lineIndex+1);  // the line # of match
                location.add(PlaceInLine+1);  // position in the line
                locations.add(location); // save the location
                Start = PlaceInLine+1;
            }
        }

        return locations;
    }

    public static void printResults(String WordToFind, ArrayList<ArrayList<Integer>> WordToFindLocations){
        for(ArrayList<Integer> location: WordToFindLocations){
            System.out.println("line # =\t" + location.get(0));
            System.out.println("PlaceInLine =\t" + location.get(1));
            System.out.println("==========================");
        }
    }
}