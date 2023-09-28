package recursion;

public class FibonacciGood {
    static long[] fibonacciGood(int n){
        if (n <= 1){
            long[] answer = {n,0};
            return answer;
        }
        else{
            long temp[] = fibonacciGood(n-1);
            long answer[] = {temp[0]+temp[1],temp[0]};
            return answer;
        }
    }

public static void main(String[] args) {
    long[] a = fibonacciGood(5);
    for (int i = 0; i < a.length; i++) {
        System.out.print(a[i]);
    }
}

}
