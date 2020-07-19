import java.util.Arrays;

public class QuickSort{

    public static <AnyType extends Comparable<? super AnyType>> void 
        quickSort(AnyType[] array)
    {
        quickSort(array, 0, array.length-1 );
    }

    private static <AnyType extends Comparable<? super AnyType>> void 
        quickSort(AnyType[] array, int left, int right)
    {
        if (left < right){
            // median of three, return pivot
            AnyType pivot = findPivot(array, left, right);

            // set up i, j pointer, loop and swap
            int i = left; 
            int j = right - 1;
            
            while(i<j){
                //while (array[i].compareTo(pivot) < 0){ i++;}
                //while (array[j].compareTo(pivot) > 0){ j--;}

                while (array[++i].compareTo(pivot) < 0){}
                while (array[--j].compareTo(pivot) > 0){}

                if (i>=j){ break;}
                
                System.out.println("i: " + i + ", j: " + j + ", pivot: " + pivot);
                System.out.println(Arrays.toString(array));
                swapIndex(array, i, j);
            }

            // swap the pivot back to index i
            swapIndex(array, i, right-1);

            // recursive call
            quickSort(array, left, i-1); // left sub array
            quickSort(array, i+1, right); // right sub array
        }
    }

    /**
    /* use median of three to find pivot,
    /* arrange the three value in ascendent order
    /* and put the pivot at index right-1 and return it
    */
    private static <AnyType extends Comparable<? super AnyType>> 
        AnyType findPivot(AnyType[] array, int left, int right)
    {
        int center = (left + right) / 2;

        if (array[left].compareTo(array[center]) > 0){
            swapIndex(array,left, center);
        }
        if (array[center].compareTo(array[right]) > 0){
            swapIndex(array, center, right);
        }
        if (array[left].compareTo(array[center]) > 0){
            swapIndex(array, left, center);
        }

        // swap pivot to index right-1
        swapIndex(array, center, right-1);
        
        // return pivot
        return array[right-1];
    }
    
    /**
    /* swap items of 2 index in an array,
    */
    private static <AnyType> void swapIndex(AnyType[] array, int index1, int index2)
    {
        try{
            AnyType temp = array[index1];
            array[index1] = array[index2];
            array[index2] = temp;
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args){
        Integer[] array = {46, 96, 55, 68, 12, 64, 32, 79, 83, 67};
        System.out.println(Arrays.toString(array));
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
