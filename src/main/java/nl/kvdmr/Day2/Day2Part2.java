package nl.kvdmr.Day2;

import nl.kvdmr.Utils.FilterUtils;
import nl.kvdmr.Utils.QuickReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day2Part2 {
    public static void main() {
        try {
            List<String> regels = QuickReader.read("Day2/input.txt");
            List<List<Integer>> reports = regels.stream()
                    .map(regel -> Arrays.stream(regel.split("\\s+"))
                            .map(Integer::parseInt).collect(Collectors.toList()))
                    .filter(FilterUtils::isSequentialWithRemoval)
                    .collect(Collectors.toList());

            System.out.println(reports.size());
        } catch (Exception e) {}
    }
}
