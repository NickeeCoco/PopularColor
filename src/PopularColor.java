import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class PopularColor {
    public static void main(String[] args) {
        ArrayList<String> votes1 = new ArrayList<String>(
                Arrays.asList("blue", "red", "Red", "Orange", "yellow", "red")
        );

        ArrayList<String> votes2 = new ArrayList<String>(
                Arrays.asList("red", "red", "yellow", "yellow")
        );

        System.out.println(findPopularColor(votes1));
        System.out.println(findPopularColor(votes2));
    }

    static ArrayList<String> findPopularColor(ArrayList<String> votes) {

        // create an ArrayList containing all values to lowercase
        ArrayList<String> lowerCaseVotes = new ArrayList<String>();
        for(String color : votes) {
            lowerCaseVotes.add(color.toLowerCase());
        }

        // create a HashMap to store the values and their frequencies
        Map<String, Integer> frequencies = new HashMap<String, Integer>();
        for(String color : lowerCaseVotes) {
            String key = color;
            if(frequencies.containsKey(key)) { // if the frequencies hashmap already contains the color
                int frequency = frequencies.get(color); // get the current frequency of the color
                frequency++; // increment it
                frequencies.put(color, frequency); // add the color and its new frequency to the hashmap
            } else { // if the color is not in the hashmap
                frequencies.put(color, 1); // add the color to the hashmap with a frequency of 1
            }
        }

        ArrayList<String> mostPopularColors = new ArrayList<String>();
        int highestFrequency = 0; // keep track of highest frequency

        for(Map.Entry<String, Integer> entry : frequencies.entrySet()) {
            String color = entry.getKey(); // store color name
            int frequency = entry.getValue(); // store frequency

            if(frequency > highestFrequency) { // if the current frequency is higher than the frequency stored
                mostPopularColors.clear(); // empty the mostPopularColors ArrayList
                highestFrequency = frequency; // change the value of highestFrequency to current color's frequency
                mostPopularColors.add(color); // add the current color to the mostPopularColors ArrayList
            } else if (frequency == highestFrequency) { // if the current frequency is the same as the highest frequency
                mostPopularColors.add(color); // add the color to the mostPopularColors ArrayList
            }
        }

        return mostPopularColors;
    }
}