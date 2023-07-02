package com.tasks.problem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordAnalyzerService {
	String fileData;

	String[] words;

	Set<String> set = new HashSet<String>();

	Map<String, Long> map = new HashMap<String, Long>();

	List<String> wordList = new ArrayList<>();


	/**
	 * 
	 * @return number of words present in the file words.txt
	 * @throws Exception
	 */
	public long readFileAndReturnNoOfWords() {
		// @todo Use BufferedReader to read the file and store the words into words
		// variable
		// delete the last new line separator
		try (BufferedReader br = new BufferedReader(new FileReader("words.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+"); // Split line into words using whitespace as delimiter
                for (String word : words) {
                    if (word.endsWith("\n")) {
                        word = word.substring(0, word.length() - 1); // Remove the last newline character
                    }
                    wordList.add(word);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return wordList.size();

	}

	/*
	 * 
	 * @return the unique words present in the file. These words should be populated
	 * in the set variable declared above.
	 */
	public long createSetOfUniqueWordsAndReturnUniqueCount() {
		if (words == null) {
			readFileAndReturnNoOfWords();
		}
		// @todo Add words to the collection uniquely
		set = new HashSet<String>(wordList);

		return set.size();
	}


	/**
	 * Populate the map variable with key-value mapping of word-count, count
	 * representing how many times the word appeared in the file.
	 */
	public void createMapOfWord_Count() {
		if (words == null) {
			readFileAndReturnNoOfWords();
		}
		// @todo Populate the map variable by writing appropriate code
		for (String word : wordList) {
            map.put(word, map.getOrDefault(word, 0l) + 1);
        }

	}

	/**
	 * 
	 * @param word - input word
	 * @return the number of times the input word appeared in the file
	 */
	public long getOccurrencesOf(String word) {
		if (map.keySet().size() == 0) {
			createMapOfWord_Count();
		}
		// @todo Get the count
		long count = 0l;

        for (String w : wordList) {
            if (w.equals(word)) {
                count++;
            }
        }
		return count;
	}

	/**
	 * 
	 * @return topp 3 words sorted (desc) by number of occurrences in the file
	 */
	public List<String> findThreeMostCommonWords() {
		List<Map.Entry<String, Long>> sortedEntries = new ArrayList<>(map.entrySet());

        // Sort the entries based on values (frequencies)
        Collections.sort(sortedEntries, Map.Entry.comparingByValue(Comparator.reverseOrder()));

        List<String> topWordsList = new ArrayList<>();
        int count = 0;
        for (Map.Entry<String, Long> entry : sortedEntries) {
            if (count >= 3) {
                break;
            }
            String w = entry.getKey();
            topWordsList.add(w);
            count++;
        }

		return topWordsList;
		// List<String> topWordsList = new ArrayList<>();

		// map.entrySet().stream()
        // .sorted(Map.Entry.<String, Long>comparingByValue()
        //                 .reversed()
        //         .thenComparing(Map.Entry.comparingByKey()))
        // .forEach(v -> {
		// 	topWordsList.add(v.getKey());
		// });

		// if(topWordsList.size() < 3)
		// 	return topWordsList;
		// else
		// 	return topWordsList.subList(0, 3);
		
	}


	/**
	 * Sort the map keys based on key value with most commonly used word at the top.
	 * 
	 * @param hm
	 * @return
	 */
	private static Map<String, Long> sortByValue(Map<String, Long> hm) {
		// @todo Sort the map on the basis of value of the key in the Map.

		// Creating a list from elements of HashMap

		// Sorting the list using Collections.sort() method
		// using Comparator

		// putting the data from sorted list back to hashmap

		// returning the sorted HashMap

		return null;
	}

}
