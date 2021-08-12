import java.util.*;

public class Inversions {
    private static long merge(int[] arr, int left,int ave, int right){
        int n1 = ave-left+1;
        int n2 = right - ave;
        int [] temp1 = new int[n1];
        int [] temp2 = new int[n2];
        long numberOfInversions = 0;
        System.arraycopy(arr, left, temp1, 0, n1);
//        System.out.println("");
//        System.out.print("temp1[x] -->");
//        for (int x=0;x<n1;x++)
//            System.out.print(","+temp1[x]);
//
//
//        System.out.println("");
//        System.out.print("temp2[x] -->");
        System.arraycopy(arr, ave+1, temp2, 0, n2);
//        for (int x=0;x<n2;x++)
//            System.out.print(","+temp2[x]);
        int k = left;
        int i=0, j=0;
        while(i<n1 && j<n2){
            if (temp1[i] <= temp2[j])
            {
//                System.out.println("");
//                System.out.println(temp1[i]+ " <= " +temp2[j]);
                arr[k] = temp1[i];
                i++;
            }
            else
            {
//                System.out.println("");
//                System.out.println(temp1[i]+ " > " +temp2[j]);
                arr[k] = temp2[j];
                j++;
                numberOfInversions = numberOfInversions + (n1 - i);
//                System.out.println("n1="+n1+" i="+i+" "+(n1 - i) );


            }
            k++;
        }
        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = temp1[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = temp2[j];
            j++;
            k++;
        }
//        System.out.println("numberOfInversions-->"+numberOfInversions);
        return numberOfInversions;
    }

    private static long getNumberOfInversions(int[] arr, int left, int right) {
        long numberOfInversions = 0;
        if (right > left) {
            int ave = (left + right) / 2;
//            System.out.println("");
//        System.out.println("(left + right) / 2 is -->("+left+"+"+right+")/2");
//        System.out.println("middle is -->"+ave);

//        if (right <= left) {
//            return numberOfInversions;
//        }
        numberOfInversions += getNumberOfInversions(arr, left, ave);
//        System.out.println("numberOfInversions from Left-->"+numberOfInversions);

//        System.out.println("second");
        numberOfInversions += getNumberOfInversions(arr, ave+1, right);
//        System.out.println("numberOfInversions from Right-->"+numberOfInversions);

        //write your code here

        numberOfInversions += merge(arr,left,ave,right);
//            System.out.println("numberOfInversions from merge-->"+numberOfInversions);
        }else{
//            System.out.println("single element -->"+arr[left]);
        }
        return numberOfInversions;


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        System.out.println(getNumberOfInversions(a, 0, a.length-1));
//        for (int i = 0; i < n; i++) {
//            System.out.print(a[i]+" ");
//        }
    }
}

