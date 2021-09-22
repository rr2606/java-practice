package practice;

public class Arrays {
    // All elements are stored at contiguous memory locations (Advantages: Random Access and Cache Friendliness)
    // arr[0] first element (address of array, address of subsequent elements can be found with this and data size)
    // Cache: memory closest to CPU, items accessed by the program in cache increases program execution speed
    // Therefore in Arrays Items can be prefetched to cache before they are accessed by the program

    //Types of Arrays: Fixed Size Arrays (int arr[n];) and Dynamic Sized Arrays (ArrayList in Java, Vector in C++)
    //In Java arrays are always allocated on Heap

    //Operations on Array:
    //Searching (linear search, can try binary search of O(log(n)) complexity for sorted arrays)
    static int search(int arr[], int size, int ele){
        for(int i=0; i<size; i++)
            if(arr[i]==ele)
                return i;
        return -1;
    }

    //Insert (Complexity: O(n). Best case when item is to be inserted at the end as no array elements need to be moved)
    static int insert(int arr[], int n, int x, int cap, int pos){
        if(n==cap)
            return n;
        int index = pos - 1;
        for(int i=n-1; i>=index; i--)
            arr[i+1]=arr[i];
        arr[index]=x;
        return (n+1);
    }

    //Delete (Complexity: O(n). Best case if last element is to be deleted, can add check to avoid looking for element)
    static int delete(int arr[], int n, int x){
        int i;
        for(i=0; i<n; i++){
            if(arr[i]==x)
                break;
        }
        if(i==n) return n;
        for(int j=i; j<n-1; j++){
            arr[j]=arr[j+1];
        }
        return n-1;
    }

    //Find index of largest element in an array. Time Complexity Theta(n)
    public static int arrMaxIndex(int[] arr){
        int index = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>arr[index]){
                index = i;
            }
        }
        return index;
    }

    public static int secondLargestNaive(int[] arr){
        int largest = arrMaxIndex(arr);
        int secondLargest = -1;
        for(int i=0; i<arr.length; i++){
            if(arr[i]!=arr[largest]){
                if(secondLargest == -1){
                    secondLargest = i;
                } else if(arr[secondLargest]<arr[i]){
                    secondLargest = i;
                }
            }
        }
        return secondLargest;
    }

    public static int secondLargest(int[] arr){
        int largest = arr[0]>arr[1]?0:1;
        int secondLargest = arr[1]>arr[0]?0:1;
        for(int i=2; i<arr.length; i++){
            if(arr[i]>arr[largest]){
                secondLargest = largest;
                largest = i;
            }
            else if(arr[i]>arr[secondLargest] || arr[largest]==arr[secondLargest]){
                secondLargest = i;
            }
        }
        if(arr[largest]==arr[secondLargest]) return -1;
        return secondLargest;
    }

    public static int secondLargestEfficient(int[] arr){
        int largest = 0;
        int secondLargest = -1;
        for(int i=0; i<arr.length; i++){
            if(arr[i]>arr[largest]){
                secondLargest = largest;
                largest = i;
            }
            else if(arr[i]<arr[largest]){
                if(secondLargest==-1) secondLargest = i;
                if(arr[i]>arr[secondLargest]) secondLargest = i;
            }
        }
        return secondLargest;
    }

    public static int[] reverseArray(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++; end--;
        }
        return arr;
    }

    public static int removeDuplicatesFromSortedNaive(int[] arr){
        int[] temp = new int[arr.length];
        temp[0]=arr[0];
        int num = 1;
        for(int i=1; i<arr.length; i++){
            if(temp[num-1]!=arr[i]){
                temp[num]=arr[i];
                num++;
            }
        }
        for(int i=0; i<num; i++) arr[i]=temp[i];
        return num;
    }

    public static int removeDuplicates(int[] arr){
        int index=1;
        for(int i=0; i<arr.length; i++){
            if(arr[i]!=arr[index-1]){
                arr[index]=arr[i];
                index++;
            }
        }
        return index;
    }

    public static void leftRotateArray(int[] arr){
        int first = arr[0];
        int i=0;
        while(i<arr.length-1){
            arr[i]=arr[i+1];
            i++;
        }
        arr[arr.length-1] = first;
        System.out.println(java.util.Arrays.toString(arr));
    }
}
