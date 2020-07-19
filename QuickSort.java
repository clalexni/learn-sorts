import java.util.Arrays;

public class QuickSort{

    public static <AnyType extends Comparable<? super AnyType>> void 
        quickSort(AnyType[] array)
    {
        
    }

    private static <AnyType extends Comparable<? super AnyType>> void 
        quickSort(AnyType[] array, int left, int right)
    {
        
    }

    public static void main(String[] args){
        Integer[] array = {46, 96, 55, 68, 12, 64, 32, 79, 83, 67};
        System.out.println(Arrays.toString(array));
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
