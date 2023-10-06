public class BST_AVL_Tree {

    static class Node {
        int data, height;
        Node left, right;
        Node(int data) {
            this.data = data;
            this.height = 1;
            this.left = this.right = null;
        }
    }

    public static Node root;

    public static void preOrder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static int height(Node root) {
        if(root == null) {
            return 0;
        }
        return root.height;
    }

    static int max(int a, int b) {
        return (a>b) ? a : b;
    }

    // Get Balanced Factor of a node
    public static int getBalancedFactor(Node root) {
        if (root == null) {
            return 0;
        }
        return height(root.left) - height(root.right);
    }

    // Left rotate subtree rotated with x
    public static Node leftRotate(Node x) {
        Node y = x.right;
        Node z = y.left;

        // perform rotation
        y.left = x;
        x.right = z;

        // Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        // return new root
        return y;
    }

    // right rotate subtree rotated with y
    public static Node rightRotate(Node y) {
        Node x = y.left;
        Node z = x.right;

        // perform rotation
        x.right = y;
        y.left = z;

        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        // return new root
        return x;
    }

    public static Node insert(Node root, int key) {
        if(root == null) {
            return new Node(key);
        }
        
        if(key < root.data) {
            root.left = insert(root.left, key);
        } else if (key > root.data) {
            root.right = insert(root.right, key);
        } else {
            return root;    // duplicate keys not allowed
        }

        // Update root height
        root.height = 1 + Math.max(height(root.left), height(root.right));

        // Get root's balanced factor
        int bf = getBalancedFactor(root);

        // Left Left case
        if(bf > 1 && key < root.left.data) {
            return rightRotate(root);
        }

        // Right Right case
        if(bf < -1 && key > root.right.data) {
            return leftRotate(root);
        }

        // Left Right case
        if(bf > 1 && key > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Left case
        if(bf < -1 && key < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;    // return if AVL is balanced
    }

    // For non empty BST, return the ode with MIN data
    public static Node getMinNode(Node root) {
        Node curr = root;
        // MIN data is at left-most node
        while(curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    public static Node deleteNode(Node root, int key) {
        // perform usual BST delete
        if(root == null) {
            return root;
        }

        if(key < root.data) {
            root.left = deleteNode(root.left, key);
        } else if(key > root.data) {
            root.right = deleteNode(root.right, key);
        } else {
            // node with only one child or only one child
            if((root.left == null) || (root.right == null)) {
                Node temp = null;
                if(temp == root.left) {
                    temp = root.right;
                } else {
                    temp = root.left;
                }
                // no child case
                if(temp == null) {
                    temp = root;
                    root = null;
                } else {    // one child case
                    root = temp;
                }
            } else {
                // Node with two children: Get the inOrder
                // successor (smallest in the right sub tree)
                Node temp = getMinNode(root.right);
                // copy the inOrder successor's data to this node
                root.data = temp.data;
                // delete the inOrder successor
                root.right = deleteNode(root.right, temp.data);
            }
        }
        // if the tree had only one node then return
        if(root == null) {
            return root;
        }
        // upgrade height of the curr node
        root.height = Math.max(height(root.left), height(root.left)) + 1;
        // get balance factor of this node (to check the balance)
        int bf = getBalancedFactor(root);
        // if this node becomes unbalanced, then there are 4 cases
        // left left case
        if(bf > 1 && getBalancedFactor(root.left) >= 0) {
            return rightRotate(root);
        }
        // left right case
        if(bf > 1 && getBalancedFactor(root) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root); 
        }
        // right right case
        if(bf < -1 && getBalancedFactor(root.right) <= 0) {
            return leftRotate(root);
        }
        // right left case
        if(bf < -1 && getBalancedFactor(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }

    public static void main(String[] args) {
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        preOrder(root);
    }
}
