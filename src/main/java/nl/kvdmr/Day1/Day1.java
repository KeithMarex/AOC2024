package nl.kvdmr.Day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Day1{
    public static void main() throws IOException {
        try {
            List<List<Integer>> input = getInput();

            int sum = IntStream.range(0, input.getFirst().size())
                    .map((index) -> Math.abs(input.get(1).get(index) - input.getFirst().get(index)))
                    .sum();

            System.out.println(sum);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static List<List<Integer>> getInput() throws IOException {
        List<Integer> listLeft = new ArrayList<>();
        List<Integer> listRight = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get("F:\\GITHUB\\AOC2024\\src\\main\\java\\nl\\kvdmr\\Day1\\input.txt"));

        for (String line : lines) {
            // Splits iedere regel op spatie en voeg toe aan respectievelijke lijsten
            String[] parts = line.trim().split("\\s+");
            if (parts.length == 2) {
                listLeft.add(Integer.parseInt(parts[0]));
                listRight.add(Integer.parseInt(parts[1]));
            }
        }

        Collections.sort(listLeft);
        Collections.sort(listRight);

        return List.of(listLeft, listRight);
    }
}

