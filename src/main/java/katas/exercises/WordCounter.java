package katas.exercises;

public class WordCounter {

    /**
     * Counts the number of words in a given sentence.
     *
     * @param sentence the input string (a sentence)
     * @return the number of words in the sentence
     */
    public static int countWords(String sentence)
    {
        if(sentence.isEmpty())
            return 0;
        int cnt=1;
        for (char c : sentence.toCharArray())
        {
            if(c==' ')
            {
                cnt+=1;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        String sentence = "This is a sample sentence for counting words.";
        int wordCount = countWords(sentence);
        System.out.println(wordCount);
    }
}

