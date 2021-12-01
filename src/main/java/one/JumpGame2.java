package one;

public class JumpGame2 {
    public static void main(String[] args) {

        int n[] = {1, 2};
        System.out.println(jump(n));
    }


    static public int jump(int[] nums) {

        int index = 0;
        int maxNode = nums[0];


        int jump = 0;

        while (index < nums.length) {
            if (index + nums[index] > maxNode) {
                maxNode = index + nums[index];
                jump++;
            }
            index++;
        }

        return jump;
    }

}
