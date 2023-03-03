package org.example;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        File file = new File("testDataForW1D1.txt");

        var tokens = Util.getValidTokens(file);

        /**
         LAB 2 - part A
         */

        System.out.println("\nLAB2 - PART A\n________________\n");

        Mapper mapper = new Mapper(tokens);
        mapper.printMapperOutput();

        Reducer reducer = new Reducer(mapper.getPairs());
        reducer.printGroupedPairs();
        reducer.printReducedPairs();

        /**
         LAB 2 - part B
         */
        WordCount wordCount = new WordCount(3, 4);

        System.out.println("\n\nLAB2 - PART B\n________________\n");

        wordCount.setMappers(Util.getSubLists(tokens, wordCount.getMappers().length));
        wordCount.printMapperOutputs();

        wordCount.setReducers(wordCount.getMappers());
        wordCount.printReducersInputs();
        wordCount.printReducersOutputs();
    }
}