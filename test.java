public class test {
    public static void main(String[] args) {
//        String s = "sfadf";
//        System.out.println(s.charAt(2));
//        String s = "2,3,3";
//        String[] parts = s.split(",");
//        int n = (int)(f(32)/f(16));
//        System.out.println(n);
        System.out.println(f(33));
    }
    public static double f(int n){
        if(n == 1 ){
            return 1;
        }else{
            return f(n-1) *n;
        }
    }
}
