/**
 * Name: Sheba Philip
 * Class ID: 233
 * Assignment 1
 * Description: The SimpleList class contains a constructor, add method, remove method, count method, toString method,
 * and search method. In this class, the variable list is an array with the maximum size of 10 and count keeps track of 
 * the total amount of elements in the array. The add method adds an element to the array and remove removes an
 * element from the array. We can search for an element, know how much elements are in an array, and print out the 
 * array.
 * 
 */
package cse360assign2;

public class SimpleList {
	private int [] list;
	private int count;
	
/**
 * This is a constructor for the class SimpleList. The purpose of the constructor is to instantiate the array list
 * and count. The class constructor instantiates the array size to 10 and count to 0. Count is 0 because no element is 
 * added in initially. There's no return value for constructors.
 */
	public SimpleList() {
		list = new int[10];
		count = 0;		
	}
	
/**
 * Adds a number to the beginning of the array, list. If there is 10 elements in the array, the last element falls off
 * and a number is added to the beginning of the array. 
 * 
 * @param number 	the integer that is added to the array, list
 */
	public void add(int number) {
		
		if(count < 10) {
			
			for(int index = count-1; index >= 0; index--) {
			
				list[index + 1] = list[index];
				
			}
			count ++;
		} 
		else{
			
			for(int index = count-2; index >= 0; index--) {
				
				list[index + 1] = list[index];
				
			}

		}
		
		list[0] = number;
		
	}

/**
 * Removes the first occurrence of the number from the array, list. If the number to be removed is in the list, 
 * the right element takes the index of the number to be removed. Then everything is shifted to the left.
 * 
 * @param number	the number to delete from the array, list.  If number at the end of the list, the 
 * 					number of elements is subtracted by 1, so when the array is displayed the last integer 
 * 					won't be displayed.
 */

	public void remove(int number) {
		int target = search(number); 
		
		for(int index = 0; index < count; index++) {
			if(target == index) {
				
				//if the number is the last integer, reduce count by 1 so then when the string is printed
				//the last integer will not show
				if(index != count - 1) { 
					list[index] = list[index + 1];
					
					for(int index1 = index + 1; index1 < list.length - 1 ; index1++) {
							list[index1] = list[index1 + 1];
					}
					count--;
					
				} else {
				count--;
				}
			}
		}	
	}
	
/**
 * Returns the number of elements in the array, list.
 * 
 * @return		the number of elements in the array, list.
 */
	
	public int count() {
		return count;
	}
	
/**
 * Concatenates the elements with a space in the array, list to a string. At the very end, the 
 * the last element is printed without adding a space.
 * 
 * @return		the elements in the array, list. The elements are separated by a space.
 */
	public String toString() {
		String result = "";
		
		for(int index = 0; index < count; index++) {
			
			if(index == 0) {
				result = list[index]+"";
			}
			
			else {
			result = result + " " +list[index] ;
			}
		}
		
		return result;
	}

/**
 * Returns the index of the number in the array, list. If the number doesn't exist in list,
 * the integer returned is -1 meaning the number is not in the array.
 * 
 * @param number		the number to be found in the array, list. 
 * @return				the index of the number in the array, list.	
 */
	public int search(int number) {
		
		for (int index = 0; index < count; index++) {
			
			if (list[index] == number) {
				return index;
			}
		}
		return -1;
	}
	
}
