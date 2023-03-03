package org.example;

import java.util.ArrayList;
import java.util.List;

public class Mapper {
    private List<Pair<String, Integer>> pairs;

    public Mapper() {
        pairs = new ArrayList<>();
    }
    public Mapper(List<String> tokens) {
        pairs = new ArrayList<>();
        map(tokens);
    }

    public List<Pair<String, Integer>> getPairs() {
        return pairs;
    }

    public void map(List<String> tokens) {
        for (String token : tokens)
            pairs.add(new Pair(token.toLowerCase(), 1));
    }

    @Override
    public String toString(){
        return pairs.toString();
    }

    public void printMapperOutput(){
        System.out.println("MAPPER OUTPUT\n");
        System.out.println(pairs.toString());
    }
}
