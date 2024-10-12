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

    // The maximum width of a Binary Tree is the maximum diameter among all its levels. 
    // The width or diameter of a level is the number of nodes between the leftmost and rightmost nodes.
    public int widthOfBinaryTree(Node root) {
        // If the root is null,
        // the width is zero
        if (root == null) {
            return 0;
        }

        // Initialize a variable 'ans'
        // to store the maximum width
        int ans = 0;

        // Create a queue to perform level-order
        // traversal, where each element is a pair
        // of Node and its position in the level
        Queue<Pair<Node, Integer>> q = new LinkedList<>();
        // Push the root node and its
        // position (0) into the queue
        q.add(new Pair<>(root, 0));

        // Perform level-order traversal
        while (!q.isEmpty()) {
            // Get the number of
            // nodes at the current level
            int size = q.size();
            // Get the position of the front
            // node in the current level
            int mmin = q.peek().getValue();

            // Store the first and last positions
            // of nodes in the current level
            int first = 0, last = 0;

            // Process each node
            // in the current level
            for (int i = 0; i < size; i++) {
                // Calculate current position relative
                // to the minimum position in the level
                int cur_id = q.peek().getValue() - mmin;
                // Get the current node
                Node node = q.peek().getKey();
                // Poll the front node from the queue
                q.poll();

                // If this is the first node in the level,
                // update the 'first' variable
                if (i == 0) {
                    first = cur_id;
                }

                // If this is the last node in the level,
                // update the 'last' variable
                if (i == size - 1) {
                    last = cur_id;
                }

                // Enqueue the left child of the
                // current node with its position
                if (node.left != null) {
                    q.add(new Pair<>(node.left, cur_id * 2 + 1));
                }

                // Enqueue the right child of the
                // current node with its position
                if (node.right != null) {
                    q.add(new Pair<>(node.right, cur_id * 2 + 2));
                }
            }

            // Update the maximum width by calculating
            // the difference between the first and last
            // positions, and adding 1
            ans = Math.max(ans, last - first + 1);
        }

        // Return the maximum
        // width of the binary tree
        return ans;
        // The time complexity of this method is O(n), where n is the number of nodes in the binary tree. 
        // This is because the method performs a level-order traversal of the tree, visiting each node once.
        // The space complexity of this method is O(w), where w is the maximum width of the binary tree. 
        // This is because the method uses a queue to perform the level-order traversal, 
        // and the maximum number of nodes in the queue at any given time is equal to the width of the tree.
    }
    

    // Method to get diameter of binary tree
    public static int diameterOfBinaryTree(Node root) {
        if (root == null) {
            return 0;
        }
        
        // Calculate the height of the left and right subtrees
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        
        // Calculate the diameter recursively for the left and right subtrees
        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);
        
        // Return the maximum of the following:
        // 1. Diameter of the left subtree
        // 2. Diameter of the right subtree
        // 3. Height of the left subtree + Height of the right subtree + 1 (for the current node)
        return Math.max(leftHeight + rightHeight + 1, Math.max(leftDiameter, rightDiameter));
    }

    // method to calculate the height of a binary tree
    private static int height(Node node) {
        if (node == null) {
            return 0;
        }
        
        // Calculate the height recursively for the left and right subtrees
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        
        // Return the maximum height of the left and right subtrees + 1 (for the current node)
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Method to check if a binary tree is height-balanced
    // height diffrence should be <= 1
    public static boolean isHeightBalanced(Node root) {
        if (root == null) {
            return true;
        }
        
        // Calculate the height of the left and right subtrees
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        
        // Check if the absolute difference between the heights of the left and right subtrees is less than or equal to 1
        if (Math.abs(leftHeight - rightHeight) <= 1) {
            // Recursively check if the left and right subtrees are height-balanced
            boolean isLeftBalanced = isHeightBalanced(root.left);
            boolean isRightBalanced = isHeightBalanced(root.right);
            
            // Return true if both subtrees are height-balanced, otherwise return false
            return isLeftBalanced && isRightBalanced;
        }
        
        // If the absolute difference between the heights of the left and right subtrees is greater than 1, the tree is not height-balanced
        return false;
    }

    // Method to find the lowest common ancestor (LCA) of two nodes in a binary tree
    public static Node findLCA(Node root, Node node1, Node node2) {
        if (root == null || root == node1 || root == node2) {
            return root;
        }

        // Recursively search for the LCA in the left and right subtrees
        Node leftLCA = findLCA(root.left, node1, node2);
        Node rightLCA = findLCA(root.right, node1, node2);

        // If both nodes are found in different subtrees, then the current node is the LCA
        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        // If only one node is found, return that node as the LCA
        if (leftLCA != null) {
            return leftLCA;
        }
        if (rightLCA != null) {
            return rightLCA;
        }

        // If neither node is found, return null
        return null;
    }

    // Method to check if a binary tree is symmetric
    public static boolean isSymmetric(Node root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    // method to check if two trees are mirror images of each other
    private static boolean isMirror(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return (node1.data == node2.data) && isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
    }

    // method to check if binary tree is mirror of itself or not
    public static boolean isMirrorOfItself(Node root) {
        if (root == null) {
            return true;
        }
        
        // Create two stacks to store nodes
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        
        // Push the root node twice onto the stacks
        stack1.push(root);
        stack2.push(root);
        
        // Perform iterative preorder traversal
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            Node node1 = stack1.pop();
            Node node2 = stack2.pop();
            
            if (node1 == null && node2 == null) {
                continue;
            }
            if (node1 == null || node2 == null) {
                return false;
            }
            if (node1.data != node2.data) {
                return false;
            }
            
            // Push the left and right child nodes onto stack1 in reverse order
            stack1.push(node1.left);
            stack1.push(node1.right);
            
            // Push the right and left child nodes onto stack2 in reverse order
            stack2.push(node2.right);
            stack2.push(node2.left);
        }
        
        // Return true if the tree is symmetric
        return true;
    }
}