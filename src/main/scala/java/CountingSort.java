class CountingSort
{
    void sort(char arr[])
    {
        int n = arr.length;

        // The output character array that will have sorted arr 
        char output[] = new char[n];

        // Create a count array to store count of inidividul 
        // characters and initialize count array as 0 
        int count[] = new int[256];
        for (int i=0; i<256; ++i)
            count[i] = 0;

        // store count of each character 
        for (int i=0; i<n; ++i)
            ++count[arr[i]];
        System.out.println("here is count array");
        for (int i=0; i<256; ++i)
            System.out.print(count[i]);
        System.out.println("");
        // Change count[i] so that count[i] now contains actual 
        // position of this character in output array 
        for (int i=1; i<=255; ++i)
            count[i] += count[i-1];
        System.out.println("here is count increased");
        for (int i=1; i<=255; ++i)
            System.out.print(count[i]);
        // Build the output character array 
        // To make it stable we are operating in reverse order. 
        for (int i = n-1; i>=0; i--)
        {
            output[count[arr[i]]-1] = arr[i];
            --count[arr[i]];
        }
        System.out.println("");
        for (int i=0; i<arr.length; ++i)
            System.out.print(output[i]);
        System.out.println("");
        // Copy the output array to arr, so that arr now 
        // contains sorted characters 
        for (int i = 0; i<n; ++i)
            arr[i] = output[i];
    }

    // Driver method 
    public static void main(String args[])
    {
        CountingSort ob = new CountingSort();
        char arr[] = {'g', 'e', 'e', 'k', 's', 'f', 'o',
                'r', 'g', 'e', 'e', 'k', 's'
        };

        ob.sort(arr);

        System.out.print("Sorted character array is ");
        for (int i=0; i<arr.length; ++i)
            System.out.print(arr[i]);
    }
} 