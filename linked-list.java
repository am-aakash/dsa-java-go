/*
    Top 20 Coding Interview Questions on Linked Lists in Java

    1. Reverse a linked list
    2. Find the middle element of a linked list
    3. Detect a cycle in a linked list
    4. Merge two sorted linked lists
    5. Remove Nth node from the end of a linked list
    6. Remove duplicates from a sorted linked list
    7. Check if a linked list is palindrome
    8. Find the intersection point of two linked lists
    9. Add two numbers represented by linked lists
    10. Sort a linked list using merge sort
    11. Find the kth node from the end of a linked list
    12. Reverse a linked list in groups of size k
    13. Reverse a linked list from position m to n
    14. Rotate a linked list
    15. Check if a linked list has a loop
    16. Find the length of a linked list
    17. Swap nodes in pairs in a linked list
    18. Remove duplicates from an unsorted linked list
    19. Find the nth node from the end of a linked list
    20. Reverse alternate k nodes in a linked list
*/

// linked list node class
class ListNode {
    int val;
    ListNode next;
    
    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class ListUtil {
    // Method to print the elements of a linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Method to get the length of a linked list
    public static int getLength(ListNode head) {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    // Method to check if a linked list is empty
    public static boolean isEmpty(ListNode head) {
        return head == null;
    }

    public static ListNode reverseLinkedList(ListNode head) {
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;

        while (current != null) {
            next = current.next; // Store the next node
            current.next = previous; // Reverse the link

            // Move the pointers one step forward
            previous = current;
            current = next;
        }

        // Update the head of the reversed linked list
        head = previous;

        return head;
    }
}

public class Runner {
    public static void main(String[] args) {
        // Create a linked list
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);

        // Connect the nodes
        head.next = second;
        second.next = third;

        // Print the linked list
        ListUtil.printList(head);

        // Get the length of the linked list
        int length = ListUtil.getLength(head);
        System.out.println("Length of the linked list: " + length);

        // Check if the linked list is empty
        boolean isEmpty = ListUtil.isEmpty(head);
        System.out.println("Is the linked list empty? " + isEmpty);

        
    }
    
    // Reverse the linked list
    head = ListUtil.reverseLinkedList(head);

    // Print the reversed linked list
    System.out.println("Reversed linked list:");
    ListUtil.printList(head);
}
