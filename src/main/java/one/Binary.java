package one;

import java.io.BufferedReader;
import java.io.FileReader;

public class Binary {
    public static void main(String[] args) {

        System.out.println(1 << 2);

        System.out.println("ayush".substring(0, 0));

        int i = 1;

        try {

            try (BufferedReader br = new BufferedReader(new FileReader("/Users/ayush.agarwal/code/my/src/main/java/one/Decode.java"))) {

                if (i == 1)
                    throw new Exception("ayush1");
            }

            try (BufferedReader br = new BufferedReader(new FileReader("/Users/ayush.agarwal/code/my/src/main/java/one/Decode.java"))) {
                throw new Exception("ayush2");
            }

        } catch (Exception e) {
            System.out.println("fucked " + e.getMessage());
        }

    }
}
