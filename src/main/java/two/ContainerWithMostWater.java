package two;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int height[] = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int max = 0;
        int j = height.length - 1;
        int i = 0;
        while (i < j) {
            int h = height[i] > height[j] ? height[j] : height[i];
            int area = h * (j - i);
            if (area > max) {
                max = area;
            }
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return max;
    }

}
