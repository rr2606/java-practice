package practice;

public class SearchAndSort {
    // 1. find midpoint (floor of average of lower and upper index)
    // 2. compare element at midpoint with value to be searched
    // 3. if ele is equal then return index of midpoint | if ele smaller then high = mid | if ele larger low = mid
    int binarySearch(int arr[], int n, int x){
        int low=0, high=n-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]==x) return mid;
            else if(arr[mid]>x) high=mid-1;
            else low=mid+1;
        }
        return -1;
    }

    int recursiveBinarySearch(int arr[], int low, int high, int x){
        if(low>high) return -1;
        int mid = (low+high)/2;
        if(arr[mid]==x) return mid;
        else if(arr[mid]>x) return recursiveBinarySearch(arr, low, mid-1, x);
        else return recursiveBinarySearch(arr, mid+1, high, x);
    }

    // stability in sorting algorithms: equal elements preserve order (ex: Bubble, Insertion, and merge sort)
    // unstable sorting algorithms (order equal elements may change) (ex: selection, heap, and quick sort)

}
