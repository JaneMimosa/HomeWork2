package HomeWork3;

import java.util.HashMap;

public class TextArray {
    public static void main(String[] args) {
        String[] array = new String[]{"A", "B", "C", "A", "B", "D", "E", "B", "F", "G", "C", "C", "G", "F", "G"};
        analyzeText(array);
    }

    public static void analyzeText(String[] array) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : array) {
                if(!map.containsKey(word)) {
                    map.put(word, 1);
                } else {
                    map.put(word, (map.get(word) + 1));
                }
        }
        System.out.println("Уникальные слова в массиве " + map.keySet());
        System.out.println("Сколько раз слово появляется в массиве " + map);
    }
}
