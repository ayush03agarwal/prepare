package one;

public class LongestAbsoluteFilePath {

    public static void main(String[] args) {
        System.out.println(lengthLongestPath("file1.txt\nfile2.txt\nlongfile.txt"));
    }

    public static int lengthLongestPath(String input) {
        String[] arr = input.split("\\n");

        int maxLen = 0;
        int i = 0;

        int[] paths = new int[1000];

        while (i < arr.length) {
            String s = arr[i];
            int count = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '\t')
                    count++;
            }

            int path = s.replace("\t", "").length();
            if (count != 0) {
                path = paths[count - 1] + 1 + path;
            }
            paths[count] = path;
            if (s.contains(".")) {
                maxLen = Math.max(maxLen, path);
            }

            i++;
        }
        return maxLen;
    }
}
