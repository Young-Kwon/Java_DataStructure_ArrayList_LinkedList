
/**
 * Generic Linked List class that always keeps the elements in order
 *
 * COMP-10205 - Starting code for Assignment # 4
 * @author Young Sang Kwon, 000847777
 */
public class SortedLinkedList<T extends Comparable>
{
  /**
   * The Node class stores a list element and a reference to the next node.
   */
  private final class Node<T extends Comparable>
  {
    T value;
    Node next;

    /**
     * Constructor.
     * @param val The element to store in the node.
     * @param n The reference to the successor node.
     */
    Node(T val, Node n)
    {
      value = val;
      next = n;
    }

    /**
     * Constructor.
     *
     * @param val The element to store in the node.
     */
    Node(T val)
    {
      // Call the other (sister) constructor.
      this(val, null);
    }
  }
  private Node first;  // list head

  /**
   * Constructor.
   */
  public SortedLinkedList()
  {
    first = null;
  }

  /**
   * The isEmpty method checks to see if the list is empty.
   *
   * @return true if list is empty, false otherwise.
   */
  public boolean isEmpty()
  {
    return first == null;
  }

  /**
   * The size method returns the length of the list.
   * @return The number of elements in the list.
   */
  public int size()
  {
    int count = 0;
    Node p = first;
    while (p != null) {
      // There is an element at p
      count++;
      p = p.next;
    }
    return count;
  }

  /**
   * The add method adds an element at a position.
   * @param element The element to add to the list in sorted order.
   */
  public void add(T element)
  {
    Node newNode = new Node(element);

    if (first == null || first.value.compareTo(element) > 0) {
      newNode.next = first;
      first = newNode;
    } else {
      Node current = first;
      while (current.next != null && current.next.value.compareTo(element) < 0) {
        current = current.next;
      }
      newNode.next = current.next;
      current.next = newNode;
    }
  }

  /**
   * The remove method removes an element.
   * @param element The element to remove.
   * @return true if the remove succeeded, false otherwise.
   */
  public boolean remove(T element)
  {
    if (first == null) {
      return false;
    }

    if (first.value.equals(element)) {
      first = first.next;
      return true;
    }

    Node current = first;
    while (current.next != null && !current.next.value.equals(element)) {
      current = current.next;
    }

    if (current.next == null) {
      return false;
    }

    current.next = current.next.next;
    return true;
  }

  /**
   * The toString method computes the string representation of the list.
   * @return The string form of the list.
   */
  public String toString()
  {
    String listOfItems = "";

    Node current = first;
    while (current != null) {
      listOfItems += current.value.toString();
      if (current.next != null) {
        listOfItems += ", ";
      }
      current = current.next;
    }

    return listOfItems;
  }

}