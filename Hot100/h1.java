package Hot100;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class h1 {
    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;
        int[] res = new Solution1().twoSum(nums,target);
        System.out.println(Arrays.toString(res));
        // System.out.println(res); 这样子返回的是数组的首地址
    }
}



class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
                // get(Object key);
                // Returns:the previous value associated with key
            }
            hashtable.put(nums[i], i);
            // put(K key, V value);
        }
        return new int[0];
    }
}

/*
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        // ++i 是因为i只用到n-2就好了，最后一种情况 [n-2,n-1]
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}
 */


/*
1. 两数之和
给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

你可以按任意顺序返回答案。



示例 1：

输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
示例 2：

输入：nums = [3,2,4], target = 6
输出：[1,2]
示例 3：

输入：nums = [3,3], target = 6
输出：[0,1]


提示：

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
只会存在一个有效答案
 */