package one;

public class Hermoine {

    private int minimalSteps(String ingredients) {
        int init = 0;
        int start = -1;
        int finalLen = 1;
        for (int i = 1; i < ingredients.length(); i++) {
            if (ingredients.charAt(i) == ingredients.charAt(init)) {
                if (start == -1) {
                    start = i;
                }
                init++;

                if (init == start) {
                    finalLen++;
                    init = 0;
                    start = -1;
                }
            } else {
                if (start != -1) {
                    finalLen += i - start + 1;
                    init = 0;
                    start = -1;
                } else {
                    finalLen++;
                }

            }
        }
        System.out.println(finalLen);
        return finalLen;
    }

    /**
     * Returns true if the tests pass. Otherwise, false.
     */
    private boolean doTestsPass() {
        return minimalSteps("ABABCABABCDABABCABABCDE") == 8 && minimalSteps("ABABCABABCD") == 6 && minimalSteps("ABCDABCE") == 8 && minimalSteps("ABCABCE") == 5;
    }

    /**
     * Execution entry point.
     */
    public static void main(String[] args) {
        Hermoine solution = new Hermoine();
        if (solution.doTestsPass()) {
            System.out.println("All tests passed");
        } else {
            System.out.println("Tests failed");
        }
    }

}
