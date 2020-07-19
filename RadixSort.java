package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author alexni
 */
public class RadixSort{
      
    private int maxDigit = 0;
    final private int BUCKET_SIZE = 10;
    ArrayList<Integer> returnList;
    
    public ArrayList<Integer> sort(ArrayList<Integer> list) throws IOException{
        
        // bucket
        ArrayList<Integer>[] bucket = new ArrayList[BUCKET_SIZE];
        for(int i = 0; i <bucket.length; i++){
            bucket[i] = new ArrayList<Integer>();
        }  
        
        // temporary bucket
        ArrayList<Integer>[] temp = new ArrayList[BUCKET_SIZE];
        for(int i = 0; i <temp.length; i++){
            temp[i] = new ArrayList<Integer>();
        }          
        
        // first loop: loop for the least significant digit, get the maxDigit
        for (Integer i: list){
            
            // get the max digit
            String str = String.valueOf(i);
            if (str.length() > maxDigit){
                maxDigit = str.length();
            }
            
            // place i according to its least significant digit
            int leastSigDigit = i % 10;
            
            if (i >= 0){
                bucket[leastSigDigit].add(i);
            }else{
                System.out.println("Only positvie integer, sorry!");
                // TODO: sort negative integers
                // bucket[-1 * leastSigDigit].add(0, i);
            }
        }
        
        // loop through the bucket (maxDigit - 1) times
        for(int i = 1; i < maxDigit; i++){
            
            // clear temp
            for(int index = 0; index <temp.length; index++){
                temp[index] = new ArrayList<>();
            }
            
            // store bucket to temp
            for(int index = 0; index<bucket.length; index++){
                for (Integer num: bucket[index]){
                    temp[index].add((int)num);    
                }
            }
            
            //clear the bucket
            for(int index = 0; index <bucket.length; index++){
                bucket[index] = new ArrayList<>();
            }    
            
            // loop through temp, calculate the digit value, place it in
            // the bucket according to the digit value
            for(ArrayList<Integer> l: temp){
                for (Integer num: l){

                    int digitValue = (num/(int)Math.pow(10, i)) % 10;
                    
                    
                    bucket[digitValue].add((int)num);
                    // TODO: deal with negative values
                }
            }
        }
       
        returnList = new ArrayList<>();
        for(ArrayList<Integer> l: bucket){
            for (Integer num: l){
                returnList.add(num);
            }    
        }
        return returnList;
    }
    
    /**
     * output list into a file
     * @param fileName
     * @param list 
     */
    public static void outputListToFile(String fileName, ArrayList<Integer> list){
        try {
            FileWriter myWriter = new FileWriter(fileName);
            for(Integer i: list){
                myWriter.write(i + " ");
            }    
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    /**
     * read Integer from file, add them to a list and return the list
     * @param fileName
     * @return 
     */
    public static ArrayList readListFromFile(String fileName){
        
        ArrayList<Integer> list = new ArrayList<>();
        try{
            Scanner sc = new Scanner(new File(fileName));
            
            while(sc.hasNextLine()){   
                
                String str = sc.nextLine();
                list.add(Integer.parseInt(str));
            }
        }
        catch(FileNotFoundException | NumberFormatException e){
            System.out.println(e);
        }
        return list;
    }
    
    /**
     * Test the class
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException{
        
        ArrayList<Integer> list = readListFromFile("input.txt");
        System.out.println("Before");
        System.out.println(list);
        RadixSort rs = new RadixSort();
        list = rs.sort(list);
        System.out.println("After:");
        System.out.println(list);
        outputListToFile("output.txt", list);


    }
}
