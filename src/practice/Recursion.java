package practice;

public class Recursion {
    // Be sure to add termination condition and base case
    // ...function(...){
    //         base cases
    //         ........
    //         recursive call (i.e. call to function(...) with at least one change in input parameters)
    //         ........
    // Solving Problems using recursion is fun
    // base case: situation where problem cannot be broken down further into smaller sub-problems

    public static int logFloor(int n, int b){
        if(n<b) return 0;
        else return 1+logFloor(n/b, b);
    }

    public static void printBinary(int n){
        if(n==0) return;
        printBinary(n/2);
        System.out.print(n%2);
    }

    public static void printNto1(int n){
        if(n==0) return;
        System.out.print(n + " ");
        printNto1(n-1);
    }

    public static void print1toN(int n){
        if(n==0) return;
        print1toN(n-1);
        System.out.print(n + " ");
    }

    public static void print1toNTailRecursive(int n, int k){
        if(n==0) return;
        System.out.print(k + " ");
        print1toNTailRecursive(n-1,k+1);
    }

    // A function is called tail recursive when the parent function has nothing more to do when the child function is
    // finished (i.e. last thing to happen in the function is the recursive call)
    // caller doesn't need to save state (less auxiliary space) in tail recursive call as execution doesn't "resume"
    // modern compilers take less time by doing tail call recursion (func(n-1) replaced by n=n-1; goto start;
    // not every recursive function can be made tail recursive

    // not tail recursive as for each function call n needs to be multiplied by the result and returned
    public static int factorialRecursive(int n){
        if(n==0 || n==1) return 1;
        return n*factorialRecursive(n-1);
    }

    public static int factorialTailRecursive(int n, int k){
        if(n==0 || n==1) return k;
        return factorialTailRecursive(n-1, k*n);
    }

    public static int fibonacci(int n){
        if(n==0) return 0;
        if(n==1 || n==2) return 1;
        return fibonacci(n-1)+fibonacci(n-2);
    }

    // requires Theta(n) auxiliary space for recursive calls in the function call stack
    public static int sumToN(int n){
        if(n==0) return 0;
        return n+sumToN(n-1);
    }

    public static int sumToNTailRecursive(int n, int k){
        if(n==0) return k;
        return sumToNTailRecursive(n-1,n+k);
    }

    // initially start = 0 and end = text.length() - 1
    public static boolean isPalindromeRecursive(String text, int start, int end){
        if(start>=end) return true;
        if(text.charAt(start)==text.charAt(end))
            return isPalindromeRecursive(text, start+1, end-1);
        else return false;
    }

    public static int sumOfDigits(int n){
        if(n<10) return n;
        return n%10+sumOfDigits(n/10);
    }

    public static int numRopeCuts(int n, int a, int b, int c){
        if(n==0) return 0;
        if(n<0) return -1;
        int aRopeCuts = numRopeCuts(n-a, a,b,c);
        int bRopeCuts = numRopeCuts(n-b, a, b, c);
        int cRopeCuts = numRopeCuts( n-c, a, b, c);
        int ab = Math.max(aRopeCuts, bRopeCuts);
        int abc = Math.max(cRopeCuts, ab);
        if(abc == -1) return -1;
        return abc+1;
    }

    public static void generateSubsetsOfString(String text, String current, int index){
        if(index>=text.length()){
            System.out.println(current);
            return;
        }
        generateSubsetsOfString(text, current, index+1);
        current=current.concat(String.valueOf(text.charAt(index)));
        generateSubsetsOfString(text, current, index+1);
    }

    // n is number of discs, a is source tower, b is auxiliary tower, c is destination tower
    public static int toh(int n, char a, char b, char c){
        if(n==1){
            System.out.println("Move 1 from " + a + " to " + c);
            return 1;
        }
        int a2b = toh(n-1, a, c, b); // move n-1 discs from a to b using c as auxiliary tower
        System.out.println("Move " + n + " from " + a + " to " + c); // move nth disc from a to c
        int b2c = toh(n-1, b, a, c); // move n-1 discs from b to c using a as auxiliary tower
        return a2b+b2c+1;
    }

}
