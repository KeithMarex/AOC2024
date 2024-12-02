package nl.kvdmr.Utils;

import java.util.List;
import java.util.stream.Collectors;

public class FilterUtils {
    public static boolean isSequential(List<Integer> list) {
        if (list.size() < 2) return true; // A list with less than 2 elements is considered sequential

        boolean increasing = list.get(1) > list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if ((increasing && list.get(i) <= list.get(i - 1)) ||
                    (!increasing && list.get(i) >= list.get(i - 1))) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasCorrectAdjacentDifferences(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            int difference = Math.abs(list.get(i) - list.get(i - 1));
            if (difference < 1 || difference > 3) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSequentialWithRemoval(List<Integer> list) {
        return isSequential(list) || canBecomeSequentialByRemovingOneElement(list);
    }

    private static boolean canBecomeSequentialByRemovingOneElement(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            List<Integer> modifiedList = removeElementAt(list, i);
            if (isSequential(modifiedList) && hasCorrectAdjacentDifferences(modifiedList)) {
                return true;
            }
        }
        return false;
    }

    private static List<Integer> removeElementAt(List<Integer> list, int index) {
        return list.stream()
                .filter(e -> list.indexOf(e) != index)
                .collect(Collectors.toList());
    }
}
