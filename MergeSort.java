import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class MergeSort{
    
    public static <AnyType extends Comparable<? super AnyType>>
        void mergeSort(AnyType [] array)
    {
        // sqaure can implement the comparable from its super class of shape?
         // uncheck warning?
         //AnyType [] temp = new AnyType [array.length];
         AnyType [] temp = (AnyType[]) new Comparable[array.length];
         mergeSort(array, temp, 0, array.length - 1);

    }

    private static <AnyType extends Comparable<? super AnyType>>
        void mergeSort(AnyType [] array, AnyType[] temp, int left, int right)
    {
        
        // when there is more than one item, keep recurrsive call
        // right == left is the base case
        if (right > left){
            int center = (left + right)/2;
            mergeSort(array, temp, left, center);
            mergeSort(array, temp, center + 1, right);
            merge(array, temp, left, center + 1, right);
        }        
    }

    private static <AnyType extends Comparable<? super AnyType>>
        void merge(AnyType[] array, AnyType[] temp, int leftPtr, int rightPtr, int rightEnd)
    {
        
        int leftEnd = rightPtr - 1;
        int numberOfElements = rightEnd - leftPtr + 1;
        // int tempLeftPtr = 0;
        int tempLeftPtr = leftPtr;

        while( leftPtr <= leftEnd && rightPtr <= rightEnd){
            if (array[leftPtr].compareTo(array[rightPtr]) <= 0){
                temp[tempLeftPtr ++] = array[leftPtr++];
            }
            else{
                temp[tempLeftPtr++] = array[rightPtr++];
            }
        }
        // if left subarray is exhausted
        // note: only need the 2nd condition
        while(leftPtr> leftEnd && rightPtr <= rightEnd){
             temp[tempLeftPtr++] = array[rightPtr++];
        }

        // if right subarray is exhausted
        // note: only need the 2nd condition
        while (rightPtr > rightEnd && leftPtr <= leftEnd){
            temp[tempLeftPtr++] = array[leftPtr++];
        }

        // copy items in temp back to array
        //for (int i = 0; i < numberOfElements; i++){
        //    array[i] = temp[i];
        // }
        for ( int i = 0; i < numberOfElements; i++, rightEnd--){
            array[rightEnd] = temp[rightEnd];
        }

    }

    public static void main(String[] args){

        Integer [] array = new Integer[Integer.parseInt(args[0])];

        for (int i = 0; i < array.length; i++){
            array[i] = ThreadLocalRandom.current().nextInt(-100, 100);
        }
        System.out.println(Arrays.toString(array));
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
