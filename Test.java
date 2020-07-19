public class Test{

    public static void main(String[] args){

        Integer[] array = new Integer[10];

        for (int i = 0; i < array.length; i++){
            array[i] = 9 - i;
        }
        SimpleSort.insertionSort(array);
    }
}
