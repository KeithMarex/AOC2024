package nl.kvdmr.Day1;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Day1Part2 {
    public static void main() throws IOException {
        List<List<Integer>> input = Day1.getInput();

        Map<Integer, Integer> frequencyMap = input.get(1).stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));

        int sum = input.getFirst().stream()
                .filter(frequencyMap::containsKey)
                .map((frequency) -> frequencyMap.get(frequency) * frequency).mapToInt(Integer::intValue).sum();

        System.out.println(sum);
    }
}
