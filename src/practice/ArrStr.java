package practice;

import java.util.Scanner;

public class ArrStr {

    public static int[] takeArrayInput(){
        Scanner scanner = new Scanner(System.in);
        int numOfElements = scanner.nextInt();
        int[] array = new int[numOfElements];
        for(int i=0; i<numOfElements; i++){
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static int arrSum(int[] arr){
        int sum=0;
        for(int ele : arr){
            sum+=ele;
        }
        return sum;
    }

    public static int arrMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int ele : arr){
            if(ele>max) max = ele;
        }
        return max;
    }

    public static double arrAvg(int[] arr){
        int sum = arrSum(arr);
        return (double) sum/ arr.length;
    }

    public static int countDistinctNaive(int[] arr){
        if(arr.length==0) return 0;
        int count = 0;
        for(int i=0; i<arr.length; i++){
            boolean isDistinct = true;
            for(int j=0; j<i; j++){
                if(arr[j]==arr[i]){
                    isDistinct = false;
                    break;
                }
            }
            if(isDistinct) count++;
        }
        return count;
    }

    public static boolean isArraySorted(int[] arr){
        for(int i=0; i<arr.length-1; i++){
            if(arr[i]>arr[i+1]) return false;
        }
        return true;
    }

    public static String takeStringInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void searchPattern(String text, String pattern){
        int position = text.indexOf(pattern);
        while(position>=0 && position<text.length()){
            System.out.print(position + " ");
            position = text.indexOf(pattern, position + 1);
        }
    }

    public static void printDigitsAfterPoint(String decimal){
        int position = decimal.indexOf(".");
        if(position<0) System.out.print("No Decimal Point");
        else System.out.print(decimal.substring(position+1));
    }

    public static void stringReverseFunction(String text){
        System.out.println(new StringBuilder(text).reverse());
    }

    public static void stringReverseBasic(String text){
        String reversed = "";
        int index = text.length()-1;
        while (index >= 0) {
            reversed = reversed.concat(String.valueOf(text.charAt(index)));
            index--;
        }
        System.out.println(reversed);
    }

    public static void checkPalindromeBasic(String text){
        boolean isPalindrome = true;
        int indexStart = 0;
        int indexEnd = text.length()-1;
        while(indexEnd>indexStart){
            if(text.charAt(indexStart)==text.charAt(indexEnd)){
                indexEnd--;
                indexStart++;
            }
            else{
                isPalindrome = false;
                break;
            }
        }
        System.out.println(isPalindrome);
    }

    public static void decimalToBinary(String text){
        int number = Integer.parseInt(text);
        StringBuilder binary = new StringBuilder();
        while(number>0){
            binary.insert(0, (number % 2));
            number/=2;
        }
        System.out.println(binary);
    }

    public static int binaryToDecimal(String text){
        int index = text.length()-1;
        int decimal = 0;
        int powerOf2 = 1;
        while(index>=0){
            int binaryDigit = text.charAt(index)=='0'?0:1;
            decimal += powerOf2*binaryDigit;
            powerOf2*=2;
            index--;
        }
        return decimal;
    }
}
