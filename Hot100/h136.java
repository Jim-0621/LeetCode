package Hot100;

import java.util.HashMap;
import java.util.Map;

public class h136 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1,3,3};
        int res = new Solution136().singleNumber(nums);
        System.out.println(res);
    }
}

/** 不需要额外空间的方法，就往位运算上想
 * 将所有数字一起进行异或运算，化简，相同数字异或结果为0，0与唯一数字异或结果为本身
 */
class Solution136 {
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}



/** 利用哈希表（需要额外空间）
 * 第一轮循环添加所有出现（去重）的数字到哈希表里面
 * 重复的对应value设置为2，无重复的对应value设置为1
 * 第二轮循环判断每个数字在哈希表里面的value，返回结果
 * 自己能想起来之前做到过的哈希表也挺好的了，时间复杂度也不高 O(n)
 */
/*class Solution136 {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(map.containsKey(nums[i])) map.put(nums[i],2);
            else map.put(nums[i],1);
        }
        for (int i = 0; i < n; i++) {
            if(map.get(nums[i])==1){
                return nums[i];
            }
        }
        return 0;
    }
}*/

/**
 * 136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */

