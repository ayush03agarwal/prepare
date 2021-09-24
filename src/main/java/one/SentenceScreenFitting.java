package one;

public class SentenceScreenFitting {
    public static void main(String[] args) {

        String[] s = {"a", "bcd", "e"};
        System.out.println(wordsTyping(s, 3, 6));
    }


    public static int wordsTyping(String[] sentence, int rows, int cols) {

        int times = 0;
        int index = 0;


        for (int r = 0; r < rows; r++) {
            int words = 0;

            for (int c = 0; c + words < cols; c++) {
                if (sentence[index].length() > cols) {
                    return 0;
                }
                if (c + sentence[index].length() + words <= cols) {
                    words++;
                    c += sentence[index].length() - 1;
                    index++;
                    if (index == sentence.length) {
                        index = 0;
                        times++;
                    }
                } else {
                    break;
                }

            }
        }

        return times;
    }
}
