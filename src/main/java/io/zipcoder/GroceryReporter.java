package io.zipcoder;

import io.zipcoder.utils.FileReader;
import io.zipcoder.utils.Item;
import io.zipcoder.utils.match.Match;

import java.util.List;

public class GroceryReporter {
    private final String originalFileText;

    public GroceryReporter(String jerksonFileName) {
        this.originalFileText = FileReader.readFile(jerksonFileName);
    }

    @Override
    public String toString() {
        ItemParser ip = new ItemParser();
        List<Item> list = ip.parseItemList(originalFileText);
        StringBuilder sb = new StringBuilder();
        int counter = 0;

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))){
                    System.out.println(list.get(i));
                    list.remove(j);
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))){
                    System.out.println(list.get(i));
                    list.remove(j);
                }
            }
        }



        return "counter: " + counter;
    }
}
