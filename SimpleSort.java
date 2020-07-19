import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
* SimpleSort Class, all sorts that are O(n^2)
*/
public final class SimpleSort{  //why need final here to acess from other class?

    /**
    * insertionSort
    * O(n^2)
    */
    public static <AnyType extends Comparable<? super AnyType>> 
        void insertionSort(AnyType arr[])
    {
        
        int count = 0;
        for (int p = 1; p < arr.length ; p++){

            AnyType temp = arr[p];
            int j = 0; // j is the hole

            for (j = p;  j > 0 && temp.compareTo(arr[j-1]) < 0; j--){
                arr[j] = arr[j-1];
                count += 1;
            }
            arr[j] = temp;
        }
        //System.out.println("Numer of swaps using insertion sort: " + count);
    }

    /**
    * shellsort
    * O(n^2)
    */
    public static <AnyType extends Comparable<? super AnyType>>
        void shellsort(AnyType arr[])
    {
        int count = 0;
        for (int gap = arr.length/2; gap>0; gap/=2){

            for (int p = gap; p < arr.length; p++){

                AnyType temp = arr[p];
                int j = 0; // hole

                for (j = p; j >= gap && temp.compareTo(arr[j-gap]) < 0; j-= gap){
                    arr[j] = arr[j-gap];
                    count += 1;
                }
                arr[j] = temp;
            }
        } 
        //System.out.println("Numer of swaps using shellsort: " + count);
    }

    /**
    * main
    */
    public static void main(String[] args){
        
        int items = Integer.parseInt(args[0]);
        Integer [] array1 = new Integer[items];
        
        // randomly assign array
        for (int i = 0; i < array1.length; i++){
            array1[i] = ThreadLocalRandom.current().nextInt(-100, 100);
        }
        
        // assign array items to 1
    //    for (int i = 0; i < items; i++){
    //        array1[i] = items - i;
    //    }


        Integer [] array2 = array1.clone();
            
        System.out.println("Insertion Sort: ");
        System.out.println(Arrays.toString(array1));
        insertionSort(array1); 
        System.out.println(Arrays.toString(array1));

        System.out.println("\nShellSort: ");
        System.out.println(Arrays.toString(array2));
        shellsort(array2);
        System.out.println(Arrays.toString(array2));
    }        
}

