import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class AnagramApp {
    /**
     * Class used to run the app and complete assignment 3 - ENSF 594
     * O(n*klogk) time complexity, where n is the number of words and k is number of letters in a word
     * O(n) space complexity
     */

    public static void main(String[] args) throws IOException {
        ArrayList<LinkedList> arrayOfLists = new ArrayList<>(); // arraylist to keep LinkedLists in
        HashMap<String, Integer> all_words = new HashMap<>(); // keep track of words already seen so to skip duplicates
        HashMap<String, Integer> sorted_words = new HashMap<>(); // store sorted words for anagram checking
        String input = "input.txt";
        String output = "output.txt";
        int index = 0;

        // Read the file and process words. This would be better to split into multiple functions.
        try (BufferedReader br = new BufferedReader(new FileReader(input))) {
            String word;
            // O(n)
            while ((word = br.readLine()) != null) {
                word = word.trim();
                // O(klogk)
                String sorted_word = Node.sortString(word); // used when checking for anagrams
                boolean has_anagram = false; // to keep track if an anagram has been found from the existing words

                // if the word is not in the hash map (meaning it is not a duplicate)
                // O(1) constant look up time
                if (!all_words.containsKey(word)) {
                    // if the sorted word is already a key in teh sorted_words hashmap it means it has an anagram
                    if (sorted_words.containsKey(sorted_word)) {
                        has_anagram = true;

                        // sorted_words.get(sorted_word) gets the arraylist index at which the linked list of the
                        // anagram is stored. then arrayOfLists.get(index) gets the linked list pointer and then
                        // .add(word) adds the word to the linked list
                        arrayOfLists.get(sorted_words.get(sorted_word)).add(word);
                    }
                    // If the word has anagram it's already been added to the linked list so don't add the word
                    // to a new linked list and just continue to the next word
                    if (has_anagram) { continue; }

                    // If the word does not have anagram, then make a new linked list with the word and add it to the
                    // array list
                    LinkedList new_list = new LinkedList();
                    sorted_words.put(sorted_word, index);
                    all_words.put(word, index); // put the word and the array index in hashmap for duplicate tracking
                    new_list.add(word); // add the word to the new linked list
                    arrayOfLists.add(new_list); // add the new linked list to the array of linked lists
                    index++;
                } else {
                    // If word has already been added before (meaning it is a duplicate) skip it
                    continue;
                }
            }
        } catch (Exception e) {
            // If input.txt is not found. Could be it does not exists or wrong path
            System.out.println(e);
        }

        // O(n)
        FileWriter fw = new FileWriter(output);
        for (LinkedList list : arrayOfLists) {
            fw.write(list.toString());
            fw.write("\n");
        }
        fw.close();
    }
}
