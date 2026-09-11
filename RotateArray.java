public class RotateArray {
    public static int[] rotateArray(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return nums;
        k = k % n;
        int[] newArray = new int[n];
        for (int i = 0; i < n; i++) {
            newArray[(i + k) % n] = nums[i];
        }
        return newArray;
    }

    public static void main(String[] args) {
        int[] result = rotateArray(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        System.out.println(java.util.Arrays.toString(result));
    }
}
