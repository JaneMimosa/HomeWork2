package HomeWork3;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    String number;
    String name;
    private HashMap<String, String> phoneBook = new HashMap<>();

    public void add(String number, String name) {
        phoneBook.put(number, name);
    }

    public void get(String name) {
       for(Map.Entry entry: phoneBook.entrySet()) {
          if (name.equals(entry.getValue())) {
             System.out.println(entry.getKey());
          }
       }
    }
}
