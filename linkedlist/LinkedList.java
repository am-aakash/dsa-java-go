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

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class ListUtil {
    private ListUtil() {
    }

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

    // Problem 1
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

    // Problem 2
    public static ListNode findMiddleListNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Problem 3
    public static boolean detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

    // Problem 4
    public static ListNode mergeTwoSortedLists(ListNode headA, ListNode headB) {
        ListNode head = new ListNode();
        ListNode temp = head;
        while (headA != null && headB != null) {
            if (headA.val > headB.val) {
                temp.next = headB;
                headB = headB.next;
            } else {
                temp.next = headA;
                headA = headA.next;
            }
            System.out.println(temp.val);
            temp = temp.next;
        }

        temp.next = (headA != null) ? headA : headB;

        return head.next;
    }

    // Problem 5 : Remove Nth node from the end of a linked list
    public static ListNode removeNthNodeFromTheEnd(ListNode head, int n) {
        // Create a dummy node to handle edge cases like removing the first node
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Initialize two pointers, both starting from dummy node
        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move the fast pointer 'n' steps ahead
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // Move both fast and slow pointers until the fast pointer reaches the end of
        // the list
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Now slow.next is the node to be removed, so bypass it
        slow.next = slow.next.next;

        // Return the head of the modified list, which is dummy.next
        return dummy.next;
    }

    // Problem 6 : Remove duplicates from a sorted linked list
    public static ListNode removeDupicates(ListNode head) {
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }
            if (cur.next != null)
                cur = cur.next;
        }
        return head;
    }

    // Problem 7 : Check if a linked list is palindrome
    public static boolean checkPalindromeLinkedList(ListNode head) {
        if (head == null || head.next == null)
            return true; // if empty or single element

        ListNode fast = head, slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 1-2-3-3-2-1
        // slow = 3-2-1

        // 1-2-3-2-1
        // slow = 3-2-1

        // reverse the slow ll -> 3-2-1 -> 1-2-3
        ListNode secondHalfList = reverseLinkedList(slow), firstHalfList = head;
        ListNode secondHalfListCopy = secondHalfList;

        while (secondHalfList != null) {
            if (firstHalfList.val != secondHalfList.val) {
                return false;
            }
            firstHalfList = firstHalfList.next;
            secondHalfList = secondHalfList.next;
        }

        // optional: reverse second half
        reverseLinkedList(secondHalfListCopy);

        return true;
    }
}

public class LinkedList {
    public static void main(String[] args) {
        // Create a linked list
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode forth = new ListNode(5);
        ListNode fifth = new ListNode(6);

        // Connect the nodes
        head.next = second;
        second.next = third;
        third.next = forth;
        forth.next = fifth;

        // Get the length of the linked list
        // int length = ListUtil.getLength(head);
        // System.out.println("Length of the linked list: " + length);

        // // Check if the linked list is empty
        // boolean isEmpty = ListUtil.isEmpty(head);
        // System.out.println("Is the linked list empty? " + isEmpty);

        // Reverse the linked list
        head = ListUtil.reverseLinkedList(head);
        // Print the reversed linked list
        System.out.print("Reversed linked list: ");
        ListUtil.printList(head);
        head = ListUtil.reverseLinkedList(head);

        // System.out.println("Middle node is " +
        // ListUtil.findMiddleListNode(head).val);

        // System.out.println("LinkedList has cycle? " + ListUtil.detectCycle(head));
        ListNode merged = ListUtil.mergeTwoSortedLists(head, new ListNode(4));
        ListUtil.printList(merged);

        // ListNode editedNode = ListUtil.removeDupicates(head);
        // ListUtil.printList(editedNode);
    }
}