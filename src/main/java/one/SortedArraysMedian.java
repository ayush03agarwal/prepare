package one;

public class SortedArraysMedian {

    public static void main(String[] args) {
        int nums1[] = new int[]{1, 3};
        int nums2[] = new int[]{2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int k = 0;
        int num3[] = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                num3[k++] = nums1[i++];
            } else {
                num3[k++] = nums2[j++];
            }
        }
        while (i < nums1.length) {
            num3[k++] = nums1[i++];
        }
        while (j < nums2.length) {
            num3[k++] = nums2[j++];
        }
        if (num3.length % 2 == 0) {
            double i1 = num3[num3.length / 2 - 1];
            double i2 = num3[num3.length / 2];
            return (i1 + i2) / 2;
        } else {
            return num3[(num3.length - 1) / 2];
        }
    }
}
