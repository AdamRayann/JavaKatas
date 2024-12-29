package katas.exercises;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RequirementsCoverage {


//    public static List<Integer> selectMinimalTestCases(List<List<Integer>> testCases) {
//
//        Set<Integer> allRequirements = new HashSet<>();
//        for (List<Integer> testCase : testCases) {
//            allRequirements.addAll(testCase);
//        }
//
//        List<Integer> arr = new ArrayList<Integer>();
//
//
//        System.out.println(allRequirements);()
//
//        return null;
//    }
public static List<Integer> selectMinimalTestCases(List<List<Integer>> testCases) {
    Set<Integer> allRequirements = new HashSet<>();
    for (List<Integer> testCase : testCases) {
        allRequirements.addAll(testCase);
    }
    List<Integer> result = findMinimalSet(testCases, allRequirements, new HashSet<>(), 0);
    return result != null ? result : new ArrayList<>();

}

private static List<Integer> findMinimalSet(List<List<Integer>> testCases, Set<Integer> allRequirements,
                                            Set<Integer> coveredRequirements, int index)  {
    if (coveredRequirements.containsAll(allRequirements)) {
        return new ArrayList<>();
    }

    if (index >= testCases.size()) {
        return null;
    }

    List<Integer> excludeCurrent = findMinimalSet(testCases, allRequirements, new HashSet<>(coveredRequirements), index + 1);

    Set<Integer> newCovered = new HashSet<>(coveredRequirements);
    newCovered.addAll(testCases.get(index));
    List<Integer> includeCurrent = findMinimalSet(testCases, allRequirements, newCovered, index + 1);

    if (includeCurrent != null) {
        includeCurrent.add(0, index);
    }

    if (excludeCurrent == null)
        return includeCurrent;
    if (includeCurrent == null)
        return excludeCurrent;

    return excludeCurrent.size() <= includeCurrent.size() ? excludeCurrent : includeCurrent;
}

    public static void main(String[] args) {
        List<List<Integer>> testCases = List.of(
                List.of(1, 2, 3),
                List.of(1, 4),
                List.of(2, 3, 4),
                List.of(1, 5),
                List.of(3, 5)
        );

        List<Integer> result = selectMinimalTestCases(testCases);
        System.out.println(result); // Expected output: [2, 3]
    }
}
