class Node { int data; Node left, right;

public Node(int item) {
    data = item;
    left = right = null;
}

}

class BinaryTree { Node root;

// Insert a new node in the tree
public Node insert(Node root, int data) {
    if (root == null) {
        return new Node(data);
    }
    if (data < root.data) {
        root.left = insert(root.left, data);
    } else {
        root.right = insert(root.right, data);
    }
    return root;
}

// In-order Traversal (Left, Root, Right)
void inorder(Node root) {
    if (root != null) {
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

// Pre-order Traversal (Root, Left, Right)
void preorder(Node root) {
    if (root != null) {
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
}

// Post-order Traversal (Left, Right, Root)
void postorder(Node root) {
    if (root != null) {
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }
}

// Search for a value in the tree
boolean search(Node root, int key) {
    if (root == null) {
        return false;
    }
    if (root.data == key) {
        return true;
    }
    return key < root.data ? search(root.left, key) : search(root.right, key);
}

}

public class BinaryTreeDemo { public static void main(String[] args) { BinaryTree tree = new BinaryTree();

int[] values = {50, 30, 70, 20, 40, 60, 80};
    for (int val : values) {
        tree.root = tree.insert(tree.root, val);
    }
    
    System.out.print("In-order Traversal: ");
    tree.inorder(tree.root);
    System.out.println();
    
    System.out.print("Pre-order Traversal: ");
    tree.preorder(tree.root);
    System.out.println();
    
    System.out.print("Post-order Traversal: ");
    tree.postorder(tree.root);
    System.out.println();
    
    int searchKey = 40;
    System.out.println("Search " + searchKey + ": " + tree.search(tree.root, searchKey));
}

}
