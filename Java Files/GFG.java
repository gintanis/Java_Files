
// Java program to check whether a given array
// represents a max-heap or not
class GFG
{
 
    // Returns true if arr[i..n-1]
    // represents a max-heap
    static boolean isHeap(int arr[],
                          int i, int n)
    {
        // If a leaf node
        if (i >= (n - 2) / 2)
        {
            return true;
        }
 
        // If an internal node and
        // is greater than its
        // children, and same is
        // recursively true for the
        // children
        if (arr[i] >= arr[2 * i + 1]
            && arr[i] >= arr[2 * i + 2]
            && isHeap(arr, 2 * i + 1, n)
            && isHeap(arr, 2 * i + 2, n))
        {
            return true;
        }
 
        return false;
    }
    
    public static void main(String[] args)
    {
        int arr[] = { 1, 8, 27, 10, 45, 83, 91, 31, 12, 52, 51};
        int n = arr.length - 1;
        if (isHeap(arr, 0, n)) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}