package katas.exercises;

import java.util.Formatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SemanticVersionComparator {

    /**
     * Compares two semantic version strings to determine their relative order.
     *
     * @param version1 the first version string (e.g., "MAJOR.MINOR.PATCH")
     * @param version2 the second version string (e.g., "MAJOR.MINOR.PATCH")
     * @return -1 if version1 < version2, 1 if version1 > version2, 0 if they are equal
     */
    public static int compareVersions(String version1, String version2)
    {
        int num1=0,num2=0;
        Pattern pattern = Pattern.compile("(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})");
        Matcher matcher1 = pattern.matcher(version1);
        Matcher matcher2 = pattern.matcher(version2);

        if(matcher1.matches() && matcher2.matches()){
            num1 = 100*Integer.parseInt(matcher1.group(1));
            num1 += 10*Integer.parseInt(matcher1.group(2));
            num1 += Integer.parseInt(matcher1.group(3));

            num2 = 100*Integer.parseInt(matcher2.group(1));
            num2 += 10*Integer.parseInt(matcher2.group(2));
            num2 += Integer.parseInt(matcher2.group(3));}
        if(num1>num2)
            return 1;
        else if(num1<num2)
            return -1;

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compareVersions("1.0.0", "1.0.1")); // Expected: -1
        System.out.println(compareVersions("2.1.0", "1.9.9")); // Expected: 1
        System.out.println(compareVersions("1.2.3", "1.2.3")); // Expected: 0
    }
}
