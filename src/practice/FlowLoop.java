package practice;

import java.util.Scanner;

public class FlowLoop {

    public static void divide(){
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<5; i++)
        {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(y==0)
                continue; 
            System.out.println(x/y);
        }
    }

    public static void countDigits(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int div = 10;
        while(n%div != n){
            div*=10;
        }
        System.out.println((int) Math.log10(div));
    }

    public static void numTable(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int times = sc.nextInt();
        int i = 1;
        while(i<=times){
            System.out.print(n*i + " ");
            i++;
        }
    }

    public static void squarePattern(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print("$");
            }
            System.out.println();
        }
    }

    public static void gcd(){
        Scanner sc = new Scanner(System.in);
         int x = sc.nextInt();
         int y = sc.nextInt();
        System.out.println(gcdFetch(x,y));
    }

    public static int gcdFetch(int x, int y){
        int gcd_var = x<y ? x : y;
        int dividend = x>y ? x:y;
        while(dividend%gcd_var!=0){
            int temp = gcd_var;
            gcd_var = dividend%temp;
            dividend = temp;
        }
        return gcd_var;
    }

    public static void lcm(){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println(x*y/gcdFetch(x,y));
    }

    public static void pyramidPattern(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=1; i<=n; i++){
            for(int j=1; j<=2*n-1; j++){
                if(j<=(n-i)) System.out.print("*");
                else if(j<=(n+i-1)) System.out.print("$");
                else if(j<=(2*n-1)) System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void factorial(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int factorial = 1;
        for(int i=1;i<=n;i++){
            factorial*=i;
        }
        System.out.println(factorial);
    }

    public static void divisorsNaive(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int div=1; div<=n; div++){
            if(n%div==0) System.out.print(div + " ");
        }
    }

    public static void divisorsEfficient(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int div;
        for(div =1;div*div<n;div++){
            if(n%div==0) System.out.print(div + " ");
        }
        for(;div>=1;div--){
            if(n%div==0) System.out.print(n/div + " ");
        }
    }

    public static void checkPrimeNaive(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n==1) System.out.println(false);
        int i;
        for(i=2;i<n;i++){
            if(n%i==0) {
                System.out.println(false);
                break;
            }
        }
        if(i==n) System.out.println(true);
    }

    public static void checkPrimeEfficient(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n==1) System.out.println(false);
        int div;
        for(div=2; div*div<=n; div++){
            if(n%div==0) {
                System.out.println(false);
                break;
            }
        }
        if(div*div>n) System.out.println(true);
    }

    public static void fibonacci(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        n--;
        int fib_0 = 1;
        int fib_1 = 1;
        if(n==0 || n==1) System.out.println(1);
        if(n>=2){
            for(int i=2;i<=n;i++){
                int temp = fib_1;
                fib_1+=fib_0;
                fib_0=temp;
            }
            System.out.println(fib_1);
        }
    }

    public static void utility(int a, int b, int operator) {
        switch (operator) {
            case (1):
                System.out.println(a + b);
                break;
            case (2):
                System.out.println(a - b);
                break;
            case (3):
                System.out.println(a * b);
                break;
            default:
                System.out.println("Invalid Input");
        }
    }
}
