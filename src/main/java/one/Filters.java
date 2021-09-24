package one;

import java.util.Arrays;

public class Filters {


    public static void main(String[] args) {
        int a[] = {10, 10};
        System.out.println(solution(a));
    }


    static int solution(int arr[]) {

        double[] doubles = Arrays.stream(arr).asDoubleStream().toArray();

        double sum = 0;
        for (int i = 0; i < doubles.length; i++) {
            sum += doubles[i];
        }
        double half = sum / 2;
        Arrays.sort(doubles);

        int filter = 0;
        double newsum = sum;
        while (newsum >= half) {
            double temp = doubles[doubles.length - 1];
            doubles[doubles.length - 1] = temp / 2;
            newsum = newsum - temp / 2;
            Arrays.sort(doubles);
            filter++;
        }
        return filter;
    }


}
