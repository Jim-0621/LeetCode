package Hot100;

public class h70 {
    public static void main(String[] args) {
//        for (int i = 1; i < 46; i++) {
//            int n = new Solution70().climbStairs(i);
//            System.out.println(i+":"+n);
//        }
            int n = new Solution70().climbStairs(45);
            System.out.println(n);

    }
}

class Solution70 {
    public int climbStairs(int n) {
        int a = 0, b = 1, c = 0; // 默认需要1次
        for (int i = 1; i <= n; i++) {
            c = a + b;          // f(i - 1) + f(n - 2)
            a = b;              // 记录上一轮的值
            b = c;              // 向后步进1个数
        }
        return c;
    }

    // 这个是第一反应的思路，先找出有多少种情况（几个2几个1），然后用组合求出一共有多少不同的排序
    // 但是由于涉及大数阶乘除法的问题，精度不准确，导致很多数据算出来是不对的。
//    public int climbStairs(int n) {
//        int count = 0;
//        for (int i = 0; i < ((n-1)/2+1); i++) {
//            if(i == 0){
//                count++;
//            }else {
//                int n1 = n-i*2;
//                count += (int)(f(i+n1)/(f(i)*f(n1)));
//            }
//        }
//        if(n%2 == 0) return ++count;
//        else return count;
//    }
//    public double f(int n){
//        if(n == 1 ){
//            return 1;
//        }else{
//            return f(n-1) *n;
//        }
//    }

    /*
        25:121392   +1
        28:514229   +1
        30:1346268  +1
        31:2178307  +2
        32:3524577  +1
        33:5702884  +3
        34:9227462  +3
        35:14930350 +2
        36:24157815 +2
        37:39088166 +3
        38:63245984 +2
        39:102334151    +4
        40:165580137    +4
        41:267914289    +7
        42:433494432    +5
        43:701408727    +6
        44:1134903163   +7
        45:1836311895   +8
         */
}

/*
70. 爬楼梯
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？



示例 1：

输入：n = 2
输出：2
解释：有两种方法可以爬到楼顶。
1. 1 阶 + 1 阶
2. 2 阶
示例 2：

输入：n = 3
输出：3
解释：有三种方法可以爬到楼顶。
1. 1 阶 + 1 阶 + 1 阶
2. 1 阶 + 2 阶
3. 2 阶 + 1 阶


提示：

1 <= n <= 45
 */
