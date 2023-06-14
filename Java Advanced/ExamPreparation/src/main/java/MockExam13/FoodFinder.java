package MockExam13;

import java.util.*;

public class FoodFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // initialize word maps
        Map<Character, Boolean> pearMap = new LinkedHashMap<>() {{
            put('p', false);
            put('e', false);
            put('a', false);
            put('r', false);
        }};
        Map<Character, Boolean> flourMap = new LinkedHashMap<>() {{
            put('f', false);
            put('l', false);
            put('o', false);
            put('u', false);
            put('r', false);
        }};
        Map<Character, Boolean> porkMap = new LinkedHashMap<>() {{
            put('p', false);
            put('o', false);
            put('r', false);
            put('k', false);
        }};
        Map<Character, Boolean> oliveMap = new LinkedHashMap<>() {{
            put('o', false);
            put('l', false);
            put('i', false);
            put('v', false);
            put('e', false);
        }};
        List<Map<Character, Boolean>> wordMaps = new ArrayList<>();
        wordMaps.add(pearMap);
        wordMaps.add(flourMap);
        wordMaps.add(porkMap);
        wordMaps.add(oliveMap);

        // read input
        char[] line1 = scanner.nextLine().replace(" ", "").toCharArray();
        char[] line2 = scanner.nextLine().replace(" ", "").toCharArray();
        ArrayDeque<Character> allVowels = new ArrayDeque<>();
        ArrayDeque<Character> allConsonants = new ArrayDeque<>();
        for (char v : line1) {
            allVowels.add(v);
        }
        for (char c : line2) {
            allConsonants.push(c);
        }

        // iterate until no vowels
        while (!allConsonants.isEmpty()) {
            char vowel = allVowels.poll();
            char consonant = allConsonants.pop();

            //check each character of each word
            for (Map<Character, Boolean> wordMap : wordMaps) {
                for (char ch : wordMap.keySet()) {
                    if (ch == vowel || ch == consonant) {
                        wordMap.put(ch, true);
                    }
                }
            }

            // finish move
            allVowels.add(vowel);
        }

        // count words found
        int wordsFoundCount = 0;
        for (Map<Character, Boolean> wordMap : wordMaps) {
            if (!wordMap.containsValue(false)) {
                wordsFoundCount++;
            }
        }

        // print output
        System.out.printf("Words found: %d\n", wordsFoundCount);
        for (Map<Character, Boolean> wordMap : wordMaps) {
            if (!wordMap.containsValue(false)) {
                wordMap.keySet().forEach(System.out::print);
                System.out.println();
            }
        }
    }
}
