import java.util.Arrays;
import java.util.Stack;

public class Reverse {

   
    
    public static void reverseArray (Integer [] array)
    {

        Stack<Integer> stk = new Stack<Integer>(); 
        int i = array.length-1; 
        Integer [] newArr = new Integer[array.length]; 
        int count = 0; 
        

        while (i >= 0){
            newArr[count] = stk.push(array[i]);
            count++; 
            i--; 
        }
        
        System.out.print(Arrays.toString(newArr)); 

    }


    public static void main (String[] args )
    {
        
        Integer[] array = new Integer [] {1, 2, 3, 4, 5, 6, 7, 8, 9,}; 
        reverseArray(array); 
    }
    
}
