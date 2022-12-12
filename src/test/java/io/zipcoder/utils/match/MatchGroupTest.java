package io.zipcoder.utils.match;

import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchGroupTest {
    @Test
    public void toStringTest() {
        String text = "The Quick Brown Fox";
        String patternString = "\\w+";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text);
        MatchGroup matchGroup = new MatchGroup(matcher);
        String expected = new StringBuilder()
                .append("[Match{value='The', matchNumber=0, startingIndex=0, endingIndex=3}, ")
                .append("Match{value='Quick', matchNumber=1, startingIndex=4, endingIndex=9}, ")
                .append("Match{value='Brown', matchNumber=2, startingIndex=10, endingIndex=15}, ")
                .append("Match{value='Fox', matchNumber=3, startingIndex=16, endingIndex=19}]")
                .toString();

        // when
        String actual = matchGroup.toString();
        System.out.println(actual);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void myTest_toString() {
        String text = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##";
        String patternString = "\\w+";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text);
        MatchGroup matchGroup = new MatchGroup(matcher);

        // when
        String actual = matchGroup.toString();
        System.out.println(actual);

    }

    @Test
    public void getTest0() {
        String expected = "The";
        String text = "The Quick Brown Fox";
        String patternString = "\\w+";

        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text);
        MatchGroup matchGroup = new MatchGroup(matcher);

        // when
        Match actualMatch = matchGroup.get(0);
        String actualString = actualMatch.getValue();
        System.out.println(actualString);

        Assert.assertEquals(expected, actualString);
    }


    @Test
    public void getTest1() {
        String expected = "Quick";
        String text = "The Quick Brown Fox";
        String patternString = "\\w+";

        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text);
        MatchGroup matchGroup = new MatchGroup(matcher);

        // when
        Match actualMatch = matchGroup.get(1);
        String actualString = actualMatch.getValue();
        System.out.println(actualString);

        Assert.assertEquals(expected, actualString);
    }




    @Test
    public void getTest2() {
        String expected = "Brown";
        String text = "The Quick Brown Fox";
        String patternString = "\\w+";

        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text);
        MatchGroup matchGroup = new MatchGroup(matcher);

        // when
        Match actualMatch = matchGroup.get(2);
        String actualString = actualMatch.getValue();
        System.out.println(actualString);

        Assert.assertEquals(expected, actualString);
    }

    @Test
    public void myTest_JerkSon() {
        String expected = "price";
        String text = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##";
        String patternString = "\\w+";

        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text);
        MatchGroup matchGroup = new MatchGroup(matcher);

        // when
        Match actualMatch = matchGroup.get(2);
        String actualString = actualMatch.getValue();
        System.out.println(actualString);

        Assert.assertEquals(expected, actualString);
    }

    @Test
    public void generateStringBuilderTest() {
        String expected = "Brown";
        String text = "The Quick Brown Fox";
        String patternString = "\\w+";

        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text);
        MatchGroup matchGroup = new MatchGroup(matcher);

        String test = generateStringBuilder(matchGroup);
        System.out.println(test);

        // when
        Match actualMatch = matchGroup.get(2);
        String actualString = actualMatch.getValue();
        System.out.println(actualString);

        Assert.assertEquals(expected, actualString);
    }

    private String generateStringBuilder(Iterable<Match> matchGroup) {
        StringBuilder sb = new StringBuilder("StringBuilder sb = new StringBuilder()\n");
        for (Match match : matchGroup) {
            sb
                    .append("\t.append(\"")
                    .append(match.toString())
                    .append(", \")\n");
        }
        return sb.toString();
    }
}
