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

    public List<Item> parseItemList(String valueToParse) {
        List<Item> itemList = new ArrayList<>();
        String[] values = valueToParse.split("##");
        int countException = 0;
            for (String s :values) {
                try {
                    itemList.add(parseSingleItem(s));
                } catch (Exception ex) {
                    countException++;
                    System.out.println(ex.getMessage());

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
            Match nameMatch = matchGroup.get(1);
            String nameString = nameMatch.getValue().toLowerCase(Locale.ROOT); //changed
            Match priceMatch1 = matchGroup.get(3);
            String priceMatch1String = priceMatch1.getValue();
            Match priceMatch2 = matchGroup.get(4);
            String priceMatch2String = priceMatch2.getValue();
            Match valueMatch = matchGroup.get(6);
            String valueString = valueMatch.getValue().toLowerCase();
            Match ex1 = matchGroup.get(8);
            String ex1String = ex1.getValue();
            Match ex2 = matchGroup.get(9);
            String ex2String = ex2.getValue();
            Match ex3 = matchGroup.get(10);
            String ex3String = ex3.getValue();

            String decimalString = priceMatch1String + "." + priceMatch2String;
            double decimal = Double.parseDouble(decimalString);


            return new Item(nameString, decimal, valueString, ex1String + "/" + ex2String + "/" + ex3String); //Todo: change params

        } catch(Exception ex) {
            System.out.println(ex.getMessage());
            throw new ItemParseException();
        }
        }

    }


    //original
//    public List<Item> parseItemList(String valueToParse) {
//        return null;
//    }
//
//    public Item parseSingleItem(String singleItem) throws ItemParseException {
//        return null;
//    }



