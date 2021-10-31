import java.util.Scanner;
/**
 * @author Steven Taylor
 * @version: 8/14/2020
 * @category CSCI 333 Homework1
 *The purpose of the TrinarySearch class is to break the array search into three segments, starting 
 *with the left most segment. The search method returns the index of the desired value passed.
 *If the array length is smaller than 3 indexes in length then the method performs a routine search
 *without breaking the array into 3 segments to pass through. The main method takes in user input via 
 *the Scanner as option two for this assignment and prompts the user for input until a negative array size
 *is passed into the program. 
 * 
*/
public class TrinarySearch {
	/*
	 * @param arr[] the array to be searched
	 * @param target the value to be searched for 
	 * the first segment of the recursive step which accounts for the arrays length and sets
	 * the left and right values to the appropriate index while a third condition checks for the 
	 * middle segment of the array. 
	 */
    public int trinarySearch(int array[], int target){
        
        int length = array.length;
        int left = length/3;
        int right = length/3 + length/3;
        
        int index = -1; 
                
        if (target <= array[left])
            return trinarySearch(array, 0, left, target, index);
        
        if (target > array[right])
            return trinarySearch(array, right, length-1, target, index);
        
        else 
            return trinarySearch(array, left, right, target, index);
    }
    
	/*
	 * @param arr[] the array to be searched
	 * @param left the leftmost index of the array
	 * @param right the rightmost index of the array
	 * @param target the value to be searched for 
	 * @param index the location of the value in the array
	 * Recursively iterate through the array using three segments, if the array is no larger than 3 indices long
	 * then the routine search function is implemented. If the target value is not found in the array then -1 is 
	 * returned. 
	 */
    public int trinarySearch(int array[], int left, int right, int target, int index){
        int length = right-left;
        if (length <= 2){
            for (int i = left; i <= right; i++){
                if (array[i] == target){
                    index = i;
                    return index;
                }      
            }
            return index;
        }
        if(length >=1) {
        int nextLeft = left + length/3;
        int nextRight = left + length/3 + length/3;     
        if (target <= array[nextLeft])
            return trinarySearch(array, left, nextLeft, target, index);
        
        else if (target > array[nextRight])
            return trinarySearch(array, nextRight, right, target, index);
        
        else 
            return trinarySearch(array, nextLeft, nextRight, target, index);
        }
        else {
        	return -1;
        }
    }
    
    /*
     * The purpose of main is to prompt the user for input. Calls TrinarySearch on the user passed data.
     * entering a value less than or equal to zero exits the program when prompted for the array size.
     */
    public static void main(String[] args) {

        TrinarySearch ts = new TrinarySearch();
         Scanner input = new Scanner(System.in);
       	 System.out.println("Enter a negative number or zero for the array size to exit: ");
	     
           int size = 1;

            while (size > 0) {
            	
                	 System.out.println("How many numbers do you want to enter?");
                      size = input.nextInt();
                      if(size > 0) {
                     int array[] = new int[size];

                     System.out.println("Enter the " + size + " numbers now.");

                     for (int i = 0 ; i < array.length; i++ ) {
                        array[i] = input.nextInt();
                     }
                     System.out.println("Enter the number you would like to know the index of");
                     int target =input.nextInt();
                     int index = ts.trinarySearch(array, target);
                     
                     
                     if(index != -1) {
                     System.out.println("The number " + target + " was found at index: "+ index);
                    }
                    else {
                 	   System.out.println("Error! Value not found, Index of " + target + " is " + index);
                    }
                      }
                      else {
                      System.out.println("Invalid number input for array size program exiting.");
                      }
            }
            input.close();
           
    }



    
}