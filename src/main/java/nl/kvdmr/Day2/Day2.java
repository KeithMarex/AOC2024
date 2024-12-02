package nl.kvdmr.Day2;

import nl.kvdmr.Utils.FilterUtils;
import nl.kvdmr.Utils.QuickReader;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day2 {
    public static void main() {
        try {
            List<String> regels = QuickReader.read("Day2/input.txt");
            List<List<Integer>> reports = regels.stream()
                    .map(regel -> Arrays.stream(regel.split("\\s+"))
                            .toList().stream().mapToInt(Integer::parseInt).boxed().collect(Collectors.toList()))
                    .filter(FilterUtils::isSequential)
                    .filter(FilterUtils::hasCorrectAdjacentDifferences)
                    .collect(Collectors.toList());

            System.out.println(reports.size());
        } catch (Exception e) {}
    }
}
