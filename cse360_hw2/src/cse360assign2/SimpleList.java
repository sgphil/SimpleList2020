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
 * Adds a number to the beginning of the array, list. If the array is full, then the array size is increased by 50%.
 * 
 * @param number 	the integer that is added to the array, list
 */
	public void add(int number) {
		
		if(count < list.length) {
			
			for(int index = count-1; index >= 0; index--) {
			
				list[index + 1] = list[index];
				
			}
			count ++;
			list[0] = number;
		} 
		else{

			count++;
			int newSize = (int) (count * 0.5) + list.length;
			int[] newlist = new int[newSize];
			
			for(int index = 0; index < list.length; index++) {
				
				newlist[index]=list[index];
			}
			
			for(int index = count-1; index >= 0; index--) {
				
				newlist[index + 1] = newlist[index];
				
			}
			newlist[0]=number;
			
			list = new int[newSize];
			
			for(int index = 0; index < list.length; index++) {
				
				list[index]=newlist[index];
				
			}
		}
		
	}

/**
 * Removes the first occurrence of the number from the array, list. If the number to be removed is in the list, 
 * the right element takes the index of the number to be removed. Then everything is shifted to the left. If more than
 * 25% of the array is empty then the array size is decreased by 25%.
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
		
		if((list.length-count) > (list.length * 0.25)) {
			
			int newSize = (int) (list.length - (int) (list.length * 0.25));
			
			int [] newlist = new int[newSize];
			
			for(int index = 0; index < newlist.length; index++) {
				newlist[index]=list[index];
			}
			
			list = new int[newSize];
			
			for(int index = 0; index < newlist.length; index++) {
				
				list[index]=newlist[index];
				
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
