/**
 * COMP-10205 - Starting code for Assignment # 4
 * @author Young Sang Kwon, 000847777
 *
 * Performance Summary:
 *
 * - Adding Items:
 *   SortedLinkedList: 1,182,707 us
 *   ArrayList: 3,304,738 us
 *   : SortedLinkedList is faster for additions. It inserts in O(n),
 *     while ArrayList sorts after each addition, taking O(n log n).
 *
 * - Removing Items:
 *   SortedLinkedList: 587,537 us
 *   ArrayList: 443,140 us
 *   - ArrayList is slightly faster for removals. Both have similar complexity,
 *     but ArrayList benefits from its internal array structure.
 *
 * Conclusion:
 * - SortedLinkedList is preferable for frequent sorted insertions.
 * - ArrayList is slightly more efficient for removals.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Assignment4
{
  public static void main(String[] args)
  {
    final int NUMBER_OF_NAMES = 18756;
    final String filename = "resources/bnames.txt";
    final String[] names = new String[NUMBER_OF_NAMES];
    
     // May be useful for selecting random words to remove
    Random random = new Random(); 
    
    // Read in all of the names 
    try {
      Scanner fin = new Scanner(new File(filename));
      for (int i=0; i<NUMBER_OF_NAMES; i++)
          names[i] = fin.next();
      fin.close();
    } catch (FileNotFoundException e) {
      System.out.println("Exception caught: " + e.getMessage());
      System.exit(-1);
    }
 
    // Use the system to build the linked List
    
    // 1. Create the linkedList and add all items in Array
    SortedLinkedList<String> linkedList_String = new SortedLinkedList<>();
    long start = System.nanoTime();
    for (String name : names)
      linkedList_String.add(name);
    long end = System.nanoTime();
    System.out.println(linkedList_String);
    System.out.printf("1) Time to add to SortedLinkedList: %d us\n", (end - start) / 1000);
    
    // 2. Remove half the items and time the code.
    start = System.nanoTime();
    for (int i = 0; i < NUMBER_OF_NAMES / 2; i++) {
      linkedList_String.remove(names[random.nextInt(NUMBER_OF_NAMES)]);
    }
    end = System.nanoTime();
    System.out.printf("2) Time to remove from SortedLinkedList: %d us\n", (end - start) / 1000);

    // 4. Build a standard ArrayList of String - Remember to sort list after each element is added
    //    Time this code.
    //    Use this timing data to compare add against SortedLinkedList in discussion
    //    Remove the half the elements and time again.  
    //    Use this timing data to compare remove against SortedLinkedList in discussion

    ArrayList<String> arrayList_String = new ArrayList<>();
    start = System.nanoTime();
    for (String name : names) {
      arrayList_String.add(name);
      Collections.sort(arrayList_String);
    }
    end = System.nanoTime();
    System.out.printf("3) Time to add to ArrayList: %d us\n", (end - start) / 1000);

    // Removing half the items from ArrayList
    start = System.nanoTime();
    for (int i = 0; i < NUMBER_OF_NAMES / 2; i++) {
      arrayList_String.remove(names[random.nextInt(NUMBER_OF_NAMES)]);
    }
    end = System.nanoTime();
    System.out.printf("4) Time to remove from ArrayList: %d us\n", (end - start) / 1000);

    // 3. Create a SortedLinkedList of another data type and demonstrate
    SortedLinkedList<Integer> linkedList_Integer = new SortedLinkedList<>();
    // Adding random integers to the list and demonstrating
    for (int i = 0; i < 100; i++) {
      int randomNumber = random.nextInt(1000); // Generate a random number
      linkedList_Integer.add(randomNumber);
    }
    System.out.println("5) SortedLinkedList with Integers: " + linkedList_Integer.toString());

    // Remove some elements from the list
    for (int i = 0; i < 50; i++) {
      int randomNumber = random.nextInt(1000);
      linkedList_Integer.remove(randomNumber);
    }
    System.out.println("After removal: " + linkedList_Integer.toString());
  }   
}
