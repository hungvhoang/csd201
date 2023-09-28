package recursion;

public class IndirectRecursionTest {
    static void funcA(int n){
        if(n>0){
            System.out.println(n+" ");
            funcB(n-1);
        }
    }

    static void  funcB(int n) {
        if(n>0){
            System.out.println(n+" ");
            funcA(n-1);
        }
    }
    public static void main(String[] args) {
        funcA(5);
    }
}
