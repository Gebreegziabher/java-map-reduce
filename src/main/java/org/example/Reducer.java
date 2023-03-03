package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Reducer {
    private List<Pair<String, List<Integer>>> groupByPair;
    private List<Pair<String, Integer>> reducedPairs;

    public Reducer(List<Pair<String, Integer>> pairs) {
        this.groupByPair = group(pairs);
        this.reducedPairs = reduce(groupByPair);
    }

    public List<Pair<String, List<Integer>>> getGroupByPair() {
        return groupByPair;
    }

    public List<Pair<String, Integer>> getAssembledPairs() {
        return reducedPairs;
    }

    private List<Pair<String, List<Integer>>> group(List<Pair<String, Integer>> pairs) {

        Map<String, List<Pair<String, Integer>>> assembled = pairs.stream().collect(Collectors.groupingBy(f -> f.getKey()));

        List<Pair<String, List<Integer>>> output = new ArrayList<>();
        for (Map.Entry<String, List<Pair<String, Integer>>> entry : assembled.entrySet()) {
            List<Integer> values = new ArrayList<>();
            for (Pair<String, Integer> pair : entry.getValue())
                values.add(pair.getValue());
            output.add(new Pair(entry.getKey(), values));
        }
        return output.stream().sorted(Comparator.comparing(s -> s.getKey())).collect(Collectors.toList());
    }

    private List<Pair<String, Integer>> reduce(List<Pair<String, List<Integer>>> input) {
        List<Pair<String, Integer>> output = new ArrayList<>();
        for (Pair<String, List<Integer>> entry : input)
            output.add(new Pair(entry.getKey(), entry.getValue().stream().mapToInt(m -> m.intValue()).sum()));

        return output.stream().sorted(Comparator.comparing(s -> s.getKey())).collect(Collectors.toList());
    }

    public void printGroupedPairs(){
        System.out.println("\nREDUCER INPUT\n");
        System.out.println(groupByPair.toString());
    }

    public void printReducedPairs(){
        System.out.println("\nREDUCER OUTPUT\n");
        System.out.println(reducedPairs.toString());
    }
}
