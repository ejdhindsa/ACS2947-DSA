package AssignmentFour;

// import statements
import java.util.Comparator;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class PartA_Driver
{
    public static void main(String[] args) throws FileNotFoundException
    {
        // creating hashmaps
        ProbeHashMap<String, Integer> wordFrequency = new ProbeHashMap<>();
        ProbeHashMap<Character, Integer> characterFrequency = new ProbeHashMap<>();

        // populating the hashmaps
        readWordFrequency(wordFrequency);
        readCharacterFrequency(characterFrequency);

        // instantiating comparators
        OrderLettersByFrequency<Entry<Character, Integer>> letterComparator = new OrderLettersByFrequency<>();
        OrderWordsByFrequency<Entry<String, Integer>> wordComparator = new OrderWordsByFrequency<>();

        // most and least occurring character
        Entry<Character, Integer> characterHigh = findMaxLeast(characterFrequency, letterComparator, true);
        Entry<Character, Integer> characterLow = findMaxLeast(characterFrequency, letterComparator, false);

        // most and least occurring word
        Entry<String, Integer> wordHigh = findMaxLeast(wordFrequency, wordComparator, true);
        Entry<String, Integer> wordLow = findMaxLeast(wordFrequency, wordComparator, false);

        // creating an array of pronouns
        String[] pronouns = {"i", "you", "he", "she", "it", "we", "they", "them", "us", "him", "her", "his"};

        // most and least used pronouns
        Entry<String, Integer> pronounHigh = findCategoryMaxLeast(wordFrequency, pronouns, wordComparator, true);
        Entry<String, Integer> pronounLow = findCategoryMaxLeast(wordFrequency, pronouns, wordComparator, false);

        // output generating statements
        System.out.println("Text Analyzer: ");
        System.out.println("Total number of distinct words: " + wordFrequency.size());
        System.out.println("Total number of distinct letters: " + characterFrequency.size());
        System.out.println("Most occurring character: " + characterHigh.getKey() + ", " + characterHigh.getValue());
        System.out.println("Least occurring character: " + characterLow.getKey() + ", " + characterLow.getValue());
        System.out.println("Most occurring word: " + wordHigh.getKey() + ", " + wordHigh.getValue());
        System.out.println("Least occurring word: " + wordLow.getKey() + ", " + wordLow.getValue());
        System.out.println("Most occurring pronoun: " + pronounHigh.getKey() + ", " + pronounHigh.getValue());
        System.out.println("Least occurring pronoun: " + pronounLow.getKey() + ", " + pronounLow.getValue());

    } // end of main

    /**
     * Public method that reads the words into the ProbeHashMap, one of the main reason for it to be made is to keep
     * the main method clean.
     * It checks if the word already exists in the hash map and if it does it increase its value (frequency) by one
     * otherwise it adds a new word to the hashmap with the default frequency of one
     * @param wordFrequency the ProbeHashMap for words
     * @throws FileNotFoundException if the file is not found
     */
    public static void readWordFrequency(ProbeHashMap<String, Integer> wordFrequency)
            throws FileNotFoundException
    {
        // creating a scanner
        // using the absolute file path since IDEA was giving me trouble
        String filePath = "C:\\Users\\ejdhi\\OneDrive - University of Winnipeg" +
                "\\GitHub\\ACS2947-DSA\\ACS2947-DSA\\src\\AssignmentFour\\PartA.txt";
        Scanner in = new Scanner(new File(filePath));
        in.useDelimiter("[^a-zA-Z]+");                  // using delimiter to remove all the unwanted characters

        // End-of-File loop that iterates through all the tokens in the file
        while (in.hasNext())
        {
            String word = in.next().toLowerCase();

            if (wordFrequency.get(word) != null)                        // if the word exists
            {
                wordFrequency.put(word, wordFrequency.get(word) + 1);   // add to its frequency
            } // end of if
            else                                                        // if the word does not exist
            {
                wordFrequency.put(word, 1);                             // put it in hashmap with frequency one
            } // end of else

        } // end of while

        in.close();             // close the scanner

    } // end of readWordFrequency

    /**
     * Public method that reads the characters into the ProbeHashMap, one of the main reason for it to be made
     * is to keep the main method clean.
     * It checks if the character already exists in the hash map, and if it does, it increases its value (frequency)
     * by one otherwise it adds a new character to the hashmap with the default frequency of one
     * @param characterFrequency the ProbeHashMap for words
     * @throws FileNotFoundException if the file is not found
     */
    public static void readCharacterFrequency(ProbeHashMap<Character, Integer> characterFrequency)
            throws FileNotFoundException
    {
        // creating a scanner
        // using the absolute file path since IDEA was giving me trouble
        String filePath = "C:\\Users\\ejdhi\\OneDrive - University of Winnipeg" +
                "\\GitHub\\ACS2947-DSA\\ACS2947-DSA\\src\\AssignmentFour\\PartA.txt";
        Scanner in = new Scanner(new File(filePath));

        // End-of-File loop that iterates through all the tokens in the file
        while (in.hasNext())
        {
            String word = in.next().replaceAll("[^a-zA-Z]+", "").toLowerCase();
            char[] chars;
            chars = word.toCharArray();         // split the word into individual characters

            for (char aChar : chars)            // iterate through the individual characters
            {
                if (characterFrequency.get(aChar) != null)                              // if it exists in hashmap
                {
                    characterFrequency.put(aChar, characterFrequency.get(aChar) + 1);   // increase frequency
                } // end of if
                else                                                                    // if it does not exist in hashmap
                {
                    characterFrequency.put(aChar, 1);                                   // set frequency to one
                } // end of else

            } // end of for

        } // end of while

        in.close();         // close the scanner

    } // end of readCharacterFrequency

    /**
     * Public method that returns the key with the highest or the lowest frequency in a hashmap.
     * It takes on a boolean which acts as a switch, where true would return the highest frequency and false would
     * return the least frequency.
     * @param hashmap hashmap with key and frequencies of the key
     * @param comp comparator used to compare two sets of keys
     * @param bool boolean switch true for returning max, false for least
     * @return Entry with maximum or minimum frequency
     * @param <K> key in the hashmap
     * @param <V> value in the hashmap
     */
    public static <K, V> Entry<K, V> findMaxLeast(ProbeHashMap<K, V> hashmap, Comparator<Entry<K, V>> comp, boolean bool)
    {
        Entry<K, V>[] entries = new Entry[hashmap.size()];
        int count = 0;

        // adding all entries of a hashmap into an array
        for (Entry<K, V> entry : hashmap.entrySet())
        {
            entries[count] = entry;
            count++;
        } // end of for-each

        // sorting the array with comparator as provided in the parameter
        MergeSort.mergeSort(entries, comp);
        //System.out.println(Arrays.toString(entries));

        // return maximum or minimum value based on the boolean
        if (bool)
            return entries[count - 1];                  // if true, return the maximum element
        else
            return entries[0];                          // if false, return the minimum element

    } // end of findMaxLeast()

    /**
     * Public method that returns the key with the highest or the lowest frequency based on the list provided.
     * It takes on a boolean which acts as a switch, where true would return the highest frequency and false would
     * return the least frequency.
     * @param hashmap hashmap with key and frequencies of the key
     * @param category array of value which must be found in the hashmap
     * @param comp comparator used to compare two sets of keys
     * @param bool boolean switch true for returning max, false for least
     * @return Entry with maximum or minimum frequency
     * @param <K> key in the hashmap
     * @param <V> value in the hashmap
     */
    public static <K, V> Entry<K, V> findCategoryMaxLeast
            (ProbeHashMap<K, V> hashmap, K[] category, Comparator<Entry<K, V>> comp, boolean bool)
    {
        Entry<K, V>[] entries = new Entry[category.length];
        int count = 0;

        // populating the entries with only the items in category
        for (int i = 0; i < category.length; i++)
        {
            for(Entry<K, V> entry : hashmap.entrySet())
            {
                if (category[i].equals(entry.getKey()))         // check if the entry is a pronoun
                {
                    entries[count] = entry;                     // add to the list if it is
                    count++;                                    // increase count by one

                } //end of if
            } // end of for

        } // end of for

        MergeSort.mergeSort(entries, comp);                     // sort entries using merge sort

        if (bool)
            return entries[count - 1];                          // if true return maximum element
        else
            return entries[0];                                  // if false return minimum element

    } // end of findCategoryMaxLeast()

} // end of class