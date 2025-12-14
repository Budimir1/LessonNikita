package wordCounter;

import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String input = scanner.nextLine();
        input = input.toLowerCase();
        String[] word = input.split("\\W+");

        Map<String, Integer> wordCount = new HashMap<>();

        for (String Word : word) {
            if (wordCount.containsKey(Word)) {
                wordCount.put(Word, wordCount.get(Word) + 1);
            }else {
                wordCount.put(Word, 1);
            }
        }

        System.out.println("Результат подсчёта слов:");
        System.out.println(wordCount);

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}
