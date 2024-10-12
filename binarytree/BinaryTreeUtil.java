package binarytree;

import binarytree.Node;
import java.util.*;

public class BinaryTreeUtil {
    // Inorder Tree Traversal (recursive)
    public static void inorderRecursive(Node root) {
        if (root == null) {
            return;
        }
        inorderRecursive(root.left); // recursively traverse the left subtree
        System.out.print(root.data + " "); // process the current node
        inorderRecursive(root.right); // recursively traverse the right subtree
    }

    // Inorder Tree Traversal (iterative)
    public static void inorderIterative(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr); // Push the current node onto the stack
                // this might be center-node or left-node
                curr = curr.left; // Move to the left child of the current node
                // until left is null keep going to left
            }
            // when left traversal is done
            // OR nothing there in curr
            // go to top node of stack and use its data and go to right
            curr = stack.pop(); // Pop the top node from the stack
            System.out.print(curr.data + " "); // Process the current node

            curr = curr.right; // Move to the right child of the current node
            // in next iteration, this will be center-node or left-node
        }
    }

    // Preorder Tree Traversal (recursive)
    public static void preorderRecursive(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorderRecursive(root.left);
        preorderRecursive(root.right);
    }

    // Preorder Tree Traversal (iterative)
    public static void preorderIterative(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>(); // Create a stack to store nodes
        stack.push(root); 
        while (!stack.isEmpty()) { 
            Node curr = stack.pop(); // this is center-node, pop it and use its data
            System.out.print(curr.data + " "); 

            if (curr.right != null) { // If the current node has a right child
                stack.push(curr.right); // Push the right child onto the stack
            }
            if (curr.left != null) { // If the current node has a left child
                stack.push(curr.left); // Push the left child onto the stack
            }
            // next time top of the stack will be last inserted, i.e. left child
        }
    }

    // Postorder Tree Traversal (recursive)
    public static void postorderRecursive(Node root) {
        if (root == null) {
            return;
        }
        postorderRecursive(root.left);
        postorderRecursive(root.right);
        System.out.print(root.data + " ");
    }

    // Check if two binary trees are identical or not
    public static boolean isIdentical(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return (root1.data == root2.data) && isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
    }

    // Print bottom view of a binary tree
    public static void printBottomView(Node root) {
        if (root == null) {
            return;
        }
        
        // Create a map to store the horizontal distance (hd) and corresponding node data
        Map<Integer, Integer> map = new TreeMap<>();
        
        // Create two queues: one for storing nodes and another for storing their horizontal distances
        Queue<Node> queue = new LinkedList<>();
        Queue<Integer> hdQueue = new LinkedList<>();
        
        // Add the root node to the queues with horizontal distance 0
        queue.add(root);
        hdQueue.add(0);
        
        // Perform level order traversal of the binary tree
        while (!queue.isEmpty()) {
            // Remove the front node from the queues
            Node curr = queue.poll();
            int hd = hdQueue.poll();
            
            // Update the map with the node data at the current horizontal distance
            map.put(hd, curr.data);
            
            // Process the left child
            if (curr.left != null) {
                queue.add(curr.left);
                hdQueue.add(hd - 1); // Decrease the horizontal distance by 1 for the left child
            }
            
            // Process the right child
            if (curr.right != null) {
                queue.add(curr.right);
                hdQueue.add(hd + 1); // Increase the horizontal distance by 1 for the right child
            }
        }
        
        // Print the bottom view by iterating over the map keys in ascending order
        for (int key : map.keySet()) {
            System.out.print(map.get(key) + " ");
        }
    }


    // Method to print the top view of a binary tree
    public static void printTopView(Node root) {
        if (root == null) {
            return;
        }

        // Create a map to store the horizontal distance (hd) and corresponding node
        Map<Integer, Node> map = new TreeMap<>();

        // Create a queue to perform level order traversal
        Queue<Pair<Node, Integer>> queue = new LinkedList<>();

        // Add the root node with horizontal distance 0 to the queue
        queue.add(new Pair<>(root, 0));

        // Perform level order traversal of the binary tree
        while (!queue.isEmpty()) {
            // Remove the front pair from the queue
            Pair<Node, Integer> pair = queue.poll();
            Node curr = pair.getKey();
            int hd = pair.getValue();

            // If the horizontal distance is not present in the map, add the node to the map
            if (!map.containsKey(hd)) {
                map.put(hd, curr);
            }

            // Process the left child
            if (curr.left != null) {
                queue.add(new Pair<>(curr.left, hd - 1)); // Decrease the horizontal distance by 1 for the left child
            }

            // Process the right child
            if (curr.right != null) {
                queue.add(new Pair<>(curr.right, hd + 1)); // Increase the horizontal distance by 1 for the right child
            }
        }

        // Print the top view by iterating over the map keys in ascending order
        for (int key : map.keySet()) {
            System.out.print(map.get(key).data + " ");
        }
    }

    // method to print the left view of binary tree
    public static void printLeftView(Node root) {
        if (root == null) {
            return;
        }

        // Create a queue to perform level order traversal
        Queue<Node> queue = new LinkedList<>();

        // Add the root node to the queue
        queue.add(root);

        // Perform level order traversal of the binary tree
        while (!queue.isEmpty()) {
            // Get the size of the current level
            int size = queue.size();

            // Traverse all the nodes at the current level
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();

                // Print the first node of the current level
                if (i == 0) {
                    System.out.print(curr.data + " ");
                }

                // Add the left child to the queue
                if (curr.left != null) {
                    queue.add(curr.left);
                }

                // Add the right child to the queue
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }
    }

    // method to print the right view of binary tree
    public static void printRightView(Node root) {
        if (root == null) {
            return;
        }

        // Create a queue to perform level order traversal
        Queue<Node> queue = new LinkedList<>();

        // Add the root node to the queue
        queue.add(root);

        // Perform level order traversal of the binary tree
        while (!queue.isEmpty()) {
            // Get the size of the current level
            int size = queue.size();

            // Traverse all the nodes at the current level
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();

                // Print the last node of the current level
                if (i == size - 1) {
                    System.out.print(curr.data + " ");
                }

                // Add the left child to the queue
                if (curr.left != null) {
                    queue.add(curr.left);
                }

                // Add the right child to the queue
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }
    }

    // method to print the level order traversal of binary tree
    public static void levelOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        // Create a queue to perform level order traversal
        Queue<Node> queue = new LinkedList<>();

        // Add the root node to the queue
        queue.add(root);

        // Perform level order traversal of the binary tree
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            System.out.print(curr.data + " ");

            // Add the left child to the queue
            if (curr.left != null) {
                queue.add(curr.left);
            }

            // Add the right child to the queue
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
    }

    // method to print the level order traversal of binary tree in spiral form
    public static void spiralOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        // Create two stacks to store nodes at odd and even levels
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        // Add the root node to the first stack
        stack1.push(root);

        // Perform level order traversal of the binary tree
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            // Traverse nodes at odd levels
            while (!stack1.isEmpty()) {
                Node curr = stack1.pop();
                System.out.print(curr.data + " ");

                // Add the left child to the second stack
                if (curr.left != null) {
                    stack2.push(curr.left);
                }

                // Add the right child to the second stack
                if (curr.right != null) {
                    stack2.push(curr.right);
                }
            }

            // Traverse nodes at even levels
            while (!stack2.isEmpty()) {
                Node curr = stack2.pop();
                System.out.print(curr.data + " ");

                // Add the right child to the first stack
                if (curr.right != null) {
                    stack1.push(curr.right);
                }

                // Add the left child to the first stack
                if (curr.left != null) {
                    stack1.push(curr.left);
                }
            }
        }
    }

    // method to print vertical order traversal of binary tree
    public static void verticalOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        // Create a map to store the vertical order of nodes
        Map<Integer, List<Integer>> map = new TreeMap<>();

        // Create a queue to perform level order traversal
        Queue<Pair<Node, Integer>> queue = new LinkedList<>();

        // Add the root node with horizontal distance 0 to the queue
        queue.add(new Pair<>(root, 0));

        // Perform level order traversal of the binary tree
        while (!queue.isEmpty()) {
            // Remove the front pair from the queue
            Pair<Node, Integer> pair = queue.poll();
            Node curr = pair.getKey();
            int hd = pair.getValue();

            // Update the map with the node data at the current horizontal distance
            if (!map.containsKey(hd)) {
                map.put(hd, new ArrayList<>());
            }
            map.get(hd).add(curr.data);

            // Process the left child
            if (curr.left != null) {
                queue.add(new Pair<>(curr.left, hd - 1)); // Decrease the horizontal distance by 1 for the left child
            }

            // Process the right child
            if (curr.right != null) {
                queue.add(new Pair<>(curr.right, hd + 1)); // Increase the horizontal distance by 1 for the right child
            }
        }

        // Print the vertical order by iterating over the map keys in ascending order
        for (int key : map.keySet()) {
            for (int data : map.get(key)) {
                System.out.print(data + " ");
            }
            System.out.println();
        }
    }

}

