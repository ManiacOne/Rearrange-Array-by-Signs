import java.util.Arrays;

class Rearrange {
    public static void main(String[] args) {
        int[] nums = { 9, 4, -2, -1, 5, 0, -5, -3, 2 };

        int[] ans = rearrangeArray(nums);
        System.out.println(Arrays.toString(ans));
    }

    static public int[] rearrangeArray(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[0] < 0) {
                j = 1;
                while (nums[j] < 0)
                    j++;
                reverse(nums, i, j);
            }

            if (i + 1 < nums.length && nums[i] >= 0 && nums[i + 1] >= 0) {
                j = i + 1;
                while (nums[j] >= 0)
                    j++;
                reverse(nums, i + 1, j);
            } else if (i + 1 < nums.length && nums[i] < 0 && nums[i + 1] < 0) {
                j = i + 1;
                while (nums[j] < 0)
                    j++;
                reverse(nums, i + 1, j);
            }
        }
        return nums;
    }

    static public void reverse(int[] nums, int start, int end) {
        while (end > start) {
            swap(nums, end, end - 1);
            end--;
        }
    }

    static public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}