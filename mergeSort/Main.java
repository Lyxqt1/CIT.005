// Merge sort in Java

class MergeSort {
    String sideL = "left side";
    String sideR = "right side";

    // Merge two subarrays R and L into arr
    void merge(int[] arr, int p, int q, int r, String side, String indent) {
        System.out.println("\n");
        System.out.println("" + indent + side + "");
        // Create R ← A[p..q] and L ← A[q+1..r]
        int n1 = q - p + 1;
        int n2 = r - q;

        int R[] = new int[n1];
        int L[] = new int[n2];

        for (int i = 0; i < n1; i++)
            R[i] = arr[p + i];
        for (int j = 0; j < n2; j++)
            L[j] = arr[q + 1 + j];

        System.out.print(indent + "division L:");
        printArray(L);
        System.out.print(indent + "division R: ");
        printArray(R);
        // Maintain current index of sub-arrays and main array
        int i, j, k;
        i = 0;
        j = 0;
        k = p;

        // Until we reach either end of either R or L, pick larger among
        // elements R and L and place them in the correct position at A[p..r]

        while (i < n1 && j < n2) {
            if (R[i] <= L[j]) {
                System.out.println(indent + "R[i]=" + R[i] + " insert to arr[k] where k is " + k);
                arr[k] = R[i];
                i++;
            } else {
                arr[k] = L[j];
                System.out.println(indent + "L[j]=" + L[j] + " insert to arr[k] where k is " + k);
                j++;
            }
            k++;
        }
        // When we run out of elements in either R or L,
        // pick up the remaining elements and put in A[p..r]
        while (i < n1) {
            System.out.println(indent + "R[i]=" + R[i] + " insert to arr[k] where k is " + k);
            arr[k] = R[i];
            i++;
            k++;
        }

        while (j < n2) {
            System.out.println(indent + "L[j]=" + L[j] + " insert to arr[k] where k is " + k);
            arr[k] = L[j];
            j++;
            k++;
        }


    }

    // Divide the array into two subarrays, sort them and merge them
    void mergeSort(int[] arr, int l, int r, String side, String indent) {
        if (l < r) {
            // m is the point where the array is divided into two subarrays
            int m = (l + r) / 2;
            indent = indent + indent;
            mergeSort(arr, l, m, sideR, indent);
            mergeSort(arr, m + 1, r, sideL, indent);
            // Merge the sorted subarrays

            merge(arr, l, m, r, side, indent);
            System.out.print(indent+"current arr[]: ");
            printArray(arr);
        }
    }

    // Print the array
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver program
    public static void main(String args[]) {
        int arr[] = {5, 6, 8, 7, 9, 2, 3, 1};
        MergeSort ob = new MergeSort();
        ob.mergeSort(arr, 0, arr.length - 1, "", "\t");

        System.out.println("Sorted array:");
        printArray(arr);
        System.out.println("since it is using recursion, it will show the last division,\nthe program sorts then inserts them to the array");
        System.out.println("""
                
                
                submitted by: Austria
                recursion is hard to wrap around my head
                hahahaahahahh
                """);
    }
}