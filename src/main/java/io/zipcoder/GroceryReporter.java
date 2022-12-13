package io.zipcoder;

import io.zipcoder.utils.FileReader;
import io.zipcoder.utils.Item;
import io.zipcoder.utils.match.Match;

import java.util.*;

public class GroceryReporter {
    private final String originalFileText;

    public GroceryReporter(String jerksonFileName) {
        this.originalFileText = FileReader.readFile(jerksonFileName);
    }

    @Override
    public String toString() {
        ItemParser ip = new ItemParser();
        List<Item> list = ip.parseItemList(originalFileText);
        LinkedHashMap<String, List<Item>> map = new LinkedHashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            if (map.containsKey(list.get(i).getName())) {
                map.get(list.get(i).getName()).add(list.get(i));
            } else {
                map.put(list.get(i).getName(), new ArrayList<>());
                map.get(list.get(i).getName()).add(list.get(i));
            }
        }

        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry mapElement = (Map.Entry) it.next();
            String key = (String) mapElement.getKey();
            String capKey = key.substring(0, 1).toUpperCase() + key.substring(1);

            int whiteSpace = 8 - key.length();
            String space = "";
            for (int i = 0; i < whiteSpace; i++) {
                space += " ";
            }
            sb.append("name:" + space + capKey + " \t\t " + "seen: ");

            List<Item> item = (List<Item>) mapElement.getValue();
            sb.append(item.size() + " times\n");
            sb.append("============= \t \t =============\n");

            double price1 = 0;
            double price2 = 0;
            int priceCount1 = 0;
            int priceCount2 = 0;
            double price = item.get(0).getPrice();
            for (int i = 0; i < item.size(); i++) {

                if (price != item.get(i).getPrice() && item.get(i).getPrice() > 0) {
                    price2 = item.get(i).getPrice();
                    priceCount2++;

                } else {
                    price1 = item.get(i).getPrice();
                    priceCount1++;
                }
            }
            sb.append("Price: \t " + price1);
            sb.append("\t\t " + "seen: " + priceCount1 + " times\n");
            sb.append("-------------\t\t -------------\n");
            if(priceCount2 > 1) {
                sb.append("Price: \t " + price2);
                sb.append("\t\t " + "seen: " + priceCount2 + " times\n");

            } else if (priceCount2 == 1) {
                sb.append("Price: \t " + price2);
                sb.append("\t\t " + "seen: " + priceCount2 + " time\n");
            }
            sb.append("\n");
        }

        sb.append("Errors         \t \t " + "seen: " + ip.countException + " times");
        sb.append("\n");


//        System.out.println(map.keySet());


        return sb.toString();
    }
}
