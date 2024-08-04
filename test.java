public class test {
    public static void main(String[] args) {

        int[][] trips = new int[][]{{2,1,5},{3,3,7}};
        int capacity = 4;
        boolean flag = carPooling(trips, capacity);

        System.out.println("Leetcode 每日一题");
    }
    public static boolean carPooling(int[][] trips, int capacity) {
        int far = 0;
        int len = trips.length;
        for(int i = 0; i < len; i++){
            int[] j = trips[i];
            far = Math.max(j[2], far);
        }
        int[] p = new int[far + 1];
        for(int i = 0; i < len; i++){
            int[] k = trips[i];
            for(int from = k[1]; from < k[2]; from++){
                if(p[from] + k[0] <= capacity){
                    p[from] += k[0];
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}
