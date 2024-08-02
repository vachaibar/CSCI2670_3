Name: Vanessa Achaibar
Email: vda59962@uga.edu

To run instructions in the terminal:
chmod +x assignment3.sh
./assignment3.sh   

Readme.txt Directions: In the readme file give the pseudo code (steps) for the 3 operations. 
Using this pseudo-code to explain the complexity (big O) of your 3 operations. 
To compute the complexity of above functions, write a recurrence relation and 
then solve that recurrence relation using the Master method (as discussed in the lecture).

1. getSingleParent function: This function should print the nodes that have one child.
Steps:
    a. Traverse binary search there
    b. At each node, check for exactly one child
    c. if it does have exactly one child (left or right), print
Complexity: O(log n)
Recurrence Relation: T(n) = 2T (n/2) + O(1)
Master Method: a = 1, b = 2, d = O(1) 

2. getNumLeafNodes function: This function should count the number of leaf nodes in the BST 
(Nodes with no children) and then output the count.
Steps:
    a. If the root is null, there are no nodes in subtree, return 0.
    b. If root does not have leaf nodes, return 1.
    c. If root has both left and right children, it recursively  calls 'getNumLeafNode' on 
        left and right subtrees and sums results. 
Complexity: O(n)
Recurrence Relation: T(n) = 2T (n/2) + 1
Master Method: a = 2, b = 2, d = 1 

3. getCousins function: This function should take in a node as input and prints the cousins 
of the given node.
Steps: 
    a. Find parent node of given value
    b. Determine level of value
    c. Find cousins at same level as parent node
    d. Print cousins found 
Complexity: O(log n)
Recurrence Relation: T(n) = 2T (n/2) + O(1)
Master Method: a = 2, b = 2, d = O(1)