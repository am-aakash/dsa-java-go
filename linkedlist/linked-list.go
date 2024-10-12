package main

import "fmt"

// ListNode represents a node in a linked list
type ListNode struct {
	val  int
	next *ListNode
}

// printList prints the elements of a linked list
func printList(head *ListNode) {
	current := head
	for current != nil {
		fmt.Printf("%d ", current.val)
		current = current.next
	}
	fmt.Println()
}

// getLength returns the length of a linked list
func getLength(head *ListNode) int {
	length := 0
	current := head
	for current != nil {
		length++
		current = current.next
	}
	return length
}

// isEmpty checks if a linked list is empty
func isEmpty(head *ListNode) bool {
	return head == nil
}

// reverseLinkedList reverses a linked list
func reverseLinkedList(head *ListNode) *ListNode {
	current := head
	var previous *ListNode
	var next *ListNode

	for current != nil {
		next = current.next // Store the next node
		current.next = previous // Reverse the link

		// Move the pointers one step forward
		previous = current
		current = next
	}

	// Update the head of the reversed linked list
	head = previous

	return head
}

// findMiddle finds the middle element of a linked list
func findMiddle(head *ListNode) *ListNode {
	slow := head
	fast := head

	for fast != nil && fast.next != nil {
		slow = slow.next // Move slow pointer one step
		fast = fast.next.next // Move fast pointer two steps
	}

	return slow
}

// hasCycle checks if a linked list has a cycle
func hasCycle(head *ListNode) bool {
	slow := head
	fast := head

	for fast != nil && fast.next != nil {
		slow = slow.next // Move slow pointer one step
		fast = fast.next.next // Move fast pointer two steps

		// If there is a cycle, the slow and fast pointers will meet
		if slow == fast {
			return true
		}
	}

	return false
}

func main() {
	// Create a linked list
	head := &ListNode{val: 1}
	second := &ListNode{val: 2}
	third := &ListNode{val: 3}

	// Connect the nodes
	head.next = second
	second.next = third

	// Print the linked list
	fmt.Println("Linked list:")
	printList(head)

	// Get the length of the linked list
	length := getLength(head)
	fmt.Println("Length of the linked list:", length)

	// Check if the linked list is empty
	isEmpty := isEmpty(head)
	fmt.Println("Is the linked list empty?", isEmpty)

	// Reverse the linked list
	head = reverseLinkedList(head)

	// Print the reversed linked list
	fmt.Println("Reversed linked list:")
	printList(head)
}
