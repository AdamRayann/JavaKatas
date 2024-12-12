package katas.exercises;

public class ArrayDifference {

    /**
     * Finds the difference between the largest and smallest numbers in the array.
     *
     * @param numbers the array of integers
     * @return the difference between the largest and smallest numbers
     */
    public static int findDifference(int[] numbers)
    {
        int i, max=0,min=0;
        for( i=0; i< numbers.length ; i++)
        {
            if (i==0){
                max=numbers[i];
                min=max;
            }
            if(numbers[i]>max)
                max=numbers[i];
            if(numbers[i]<min)
                min= numbers[i];

        }
        return max-min;
    }

    public static void main(String[] args) {
        int[] sampleArray = {10, 3, 5, 6, 20, -2};
        int difference = findDifference(sampleArray);
        System.out.println(difference);
    }
}
