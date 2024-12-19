
/* 
 * In this code, custom add() and iterate() methods are implemented
 * for adding and iterating over elements in an array-based list
 */
import java.util.NoSuchElementException;

class ArrayListCustomExample {

	private int[] elements; // declare array of integers
	private int size; // track the current number of elements

	// Constructor to initialise the ArrayList with a capacity
	public ArrayListCustomExample(int capacity) {
		elements = new int[capacity];
		size = 0;
	}

	// Method to add elements to the ArrayList
	public void add(int value) {
		if (size >= elements.length) {
			throw new ArrayIndexOutOfBoundsException("Array is full, cannot add more elements");
		}
		elements[size++] = value; // Add the value to the array and increment size
	}

	// Iterator class
	public class Iterator {
		private int index; // Declare index

		public Iterator() { // Constructor to initialise the index
			index = 0;
		}

		public boolean hasNext() { // Checks if there are more elements to iterate over
			return index < size;
		}

		public int next() { // Returns the next element
			if (!hasNext()) {
				throw new NoSuchElementException("No more elements");
			}
			return elements[index++];
		}
	}

	// Method to get an iterator instance
	public Iterator iterator() {
		return new Iterator();
	}

	// Main method
	public static void main(String[] args) {
		ArrayListCustomExample list = new ArrayListCustomExample(10); //

		// Add some elements to the list
		list.add(10);
		list.add(25);
		list.add(50);
		list.add(60);
		list.add(40);
		list.add(30); // This will trigger resizing

		// Create an iterator to traverse through the list
		ArrayListCustomExample.Iterator iterator = list.iterator();

		System.out.println("Elements in the ArrayList up to 50: ");
		while (iterator.hasNext()) {
			int value = iterator.next(); // Retrieve the next value
			if (value <= 50) {
				System.out.print(value + " ");
			}
		}
	}
}