// Purpose: Implementation of Binary Search Tree
import java.util.Set;
import java.util.TreeSet;

public class BinarySearchTree<T extends Comparable<T>> {
    private NodeType<T> root;

    // constructor
    public BinarySearchTree() {
        root = null;
    }

    // insert method
    public void insert(T key) {
        root = insertNode(root, key);
    }

    // insertNode method
    private NodeType<T> insertNode(NodeType<T> root, T key) {
        if (root == null) {
            return createNode(key);
        }
        if (key.compareTo(root.info) < 0) {
            root.left = insertNode(root.left, key);
        } else {
            root.right = insertNode(root.right, key);
        }
        return root;
    }

    // createNode method
    private NodeType<T> createNode(T key) {
        NodeType<T> newNode = new NodeType<>();
        newNode.info = key;
        newNode.left = null;
        newNode.right = null;
        return newNode;
    }

    // delete method
    public void delete(T key) {
        root = deleteNode(root, key);
    }

    // deleteNode method
    private NodeType<T> deleteNode(NodeType<T> root, T key) {
        if (root == null) {
            return null;
        }
        int compareResult = key.compareTo(root.info);
        if (compareResult < 0) {
            root.left = deleteNode(root.left, key);
        } else if (compareResult > 0) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.info = minValue(root.right);
            root.right = deleteNode(root.right, root.info);
        }
        return root;
    }

    // minValue method
    private T minValue(NodeType<T> root) {
        T minv = root.info;
        while (root.left != null) {
            minv = root.left.info;
            root = root.left;
        }
        return minv;
    }

    // retrieve method
    public boolean retrieve(T item) {
        return retrieveNode(root, item);
    }

    // retrieveNode method
    private boolean retrieveNode(NodeType<T> root, T item) {
        if (root == null) {
            return false;
        }
        int compareResult = item.compareTo(root.info);
        if (compareResult < 0) {
            return retrieveNode(root.left, item);
        } else if (compareResult > 0) {
            return retrieveNode(root.right, item);
        } else {
            return true;
        }
    }

    // inOrder method
    public void inOrder() {
        inOrderTraversal(root);
    }

    // inOrderTraversal method
    private void inOrderTraversal(NodeType<T> root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.info + " ");
            inOrderTraversal(root.right);
        }
    }

    // getNumLeafNode method
    public int getNumLeafNode() {
        return getNumLeafNode(root);
    }
    
    // getNumLeafNode method
    private int getNumLeafNode(NodeType<T> root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        } else {
            return getNumLeafNode(root.left) + getNumLeafNode(root.right);
        }
    }

    // getSingleParent method
    public void getSingleParent() {
        getSingleParentNode(this.root);
    }
    
    // getSingleParentNode method
    private void getSingleParentNode(NodeType<T> root) {
        if (root != null) {
            if ((root.left == null && root.right != null) || (root.left != null && root.right == null)) {
                System.out.print(root.info + " ");
            }
            getSingleParentNode(root.left);
            getSingleParentNode(root.right);
        }
    }

    // getCousins method
    public void getCousins(T value) {
        Set<T> cousins = new TreeSet<>();
        NodeType<T> parentNode = findParent(root, value);
        
        if (parentNode != null) {
            int level = getLevel(root, value, 1);
            findCousinsAtLevel(root, null, level, cousins, value);
            
            if (cousins.isEmpty()) {
                int parentLevel = getLevel(root, parentNode.info, 1);
                if (parentLevel < 1) {
                    findCousinsAtLevel(root, null, parentLevel, cousins, parentNode.info);
                }
            }
            
            cousins.remove(value);
            
            NodeType<T> sibling = (parentNode.left != null && parentNode.left.info.equals(value)) ? parentNode.right : parentNode.left;
            if (sibling != null) {
                findCousinsAtLevel(sibling, null, 1, cousins, value);
                cousins.remove(sibling.info);
        }

            if (!cousins.isEmpty()) {
                for (T cousin : cousins) {
                    System.out.print(cousin + " ");
                }
            } else {
                NodeType<T> otherSideParent = findOtherSideParent(root, parentNode, 1);
                if (otherSideParent != null) {
                    NodeType<T> cousinNode = (otherSideParent.left != null && !otherSideParent.left.info.equals(parentNode.info)) ? otherSideParent.left : otherSideParent.right;
                    System.out.print(cousinNode.info + " ");
                } else {
                    System.out.print(" ");
                }
            }
        }
    }

    // findOtherSideParent method
    private NodeType<T> findOtherSideParent(NodeType<T> root, NodeType<T> parentNode, int level) {
        if (root == null) {
            return null;
        }
        if (root.left == parentNode || root.right == parentNode) {
            return root.right;
        }
        NodeType<T> left = findOtherSideParent(root.left, parentNode, level - 1);
        if (left != null) {
            return left;
        } else {
            return null;
        }
    }

    // findParent method
    private NodeType<T> findParent(NodeType<T> root, T value) {
        if (root == null || (root.left != null && root.left.info.equals(value)) || (root.right != null && root.right.info.equals(value))) {
            return root;
        }
        NodeType<T> left = findParent(root.left, value);
        if (left != null) {
            return left;
        }
        return findParent(root.right, value);
    }

    // getLevel method
    private int getLevel(NodeType<T> root, T value, int level) {
        if (root == null) {
            return 0;
        }
        if (root.info.equals(value)) {
            return level;
        }
        int downlevel = getLevel(root.left, value, level + 1);
        if (downlevel != 0) {
            return downlevel;
        }
        return getLevel(root.right, value, level + 1);
    }

    // findCousinsAtLevel method
    private void findCousinsAtLevel(NodeType<T> root, NodeType<T> parent, int level, Set<T> cousins, T value) {
        if (root == null || level == 0) {
            return;
        }
    
        if (level == 1) {
            if (parent != null && !parent.info.equals(value)) {
                if (parent.left == root) {
                    if (parent.right != null) {
                        cousins.add(parent.right.info);
                    }
                } else {
                    if (parent.left != null) {
                        cousins.add(parent.left.info);
                    }
                }
            }
            return;
        }
    
        findCousinsAtLevel(root.left, root, level - 1, cousins, value);
        findCousinsAtLevel(root.right, root, level - 1, cousins, value);
    }
}