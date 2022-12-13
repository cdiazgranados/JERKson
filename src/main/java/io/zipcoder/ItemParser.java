package io.zipcoder;

import io.zipcoder.utils.Item;
import io.zipcoder.utils.ItemParseException;
import io.zipcoder.utils.match.Match;
import io.zipcoder.utils.match.MatchGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemParser {
    int countException = 0;
    public List<Item> parseItemList(String valueToParse) {
        List<Item> itemList = new ArrayList<>();
        String[] values = valueToParse.split("##");

            for (String s :values) {
                try {
                    itemList.add(parseSingleItem(s));
                } catch (Exception ex) {
                    countException++;
//                    System.out.println(ex.getMessage());

                }
        }
return itemList;

    }

    public Item parseSingleItem(String singleItem) throws ItemParseException {
//        "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##"

        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(singleItem);
        MatchGroup matchGroup = new MatchGroup(matcher);

        try {
            String nameString = matchGroup.get(1).getValue().toLowerCase();
            String priceMatch1 = matchGroup.get(3).getValue();
            String priceMatch2 = matchGroup.get(4).getValue();
            String valueMatch = matchGroup.get(6).getValue().toLowerCase();
            String ex1 = matchGroup.get(8).getValue();
            String ex2 = matchGroup.get(9).getValue();
            String ex3 = matchGroup.get(10).getValue();

            double decimal = Double.parseDouble(priceMatch1 + "." + priceMatch2);

            return new Item(nameString, decimal, valueMatch, ex1 + "/" + ex2 + "/" + ex3);

        } catch(Exception ex) {
//            System.out.println(ex.getMessage());
            throw new ItemParseException();
        }
        }

    }





