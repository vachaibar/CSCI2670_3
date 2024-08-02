// Purpose: Driver class for the BinarySearchTree class. The driver class reads input. 
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BinarySearchTreeDriver {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        String inputType;
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter list type (i - int, d - double, s - string): ");
        inputType = keyboard.next();

        BinarySearchTree<?> tree = null;

        String inputFile;
        switch (inputType) {
            case "i":
                BinarySearchTree<Integer> intTree = new BinarySearchTree<Integer>();
                tree = intTree;
                inputFile = "int-input.txt";
                break;
            case "d":
                BinarySearchTree<Double> doubleTree = new BinarySearchTree<Double>();
                tree = doubleTree;
                inputFile = "double-input.txt";
                break;
            case "s":
                BinarySearchTree<String> stringTree = new BinarySearchTree<String>();
                tree = stringTree;
                inputFile = "string-input.txt";
                break;
            default:
                System.out.println("Invalid input type. Choose i (int), d (double), or s (string).");
                keyboard.close();
                return;
        }

        try (Scanner fileScanner = new Scanner(new File(inputFile))) {
            while (fileScanner.hasNext()) {
                if (inputType.equals("i")) {
                    int value = fileScanner.nextInt();
                    ((BinarySearchTree<Integer>) tree).insert(value);
                } else if (inputType.equals("d")) {
                    double value = fileScanner.nextDouble();
                    ((BinarySearchTree<Double>) tree).insert(value);
                } else if (inputType.equals("s")) {
                    String value = fileScanner.next();
                    ((BinarySearchTree<String>) tree).insert(value);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + inputFile);
            keyboard.close();
            return;
        }

        System.out.println("Commands:\n" +
                "(i) - Insert Item\n" +
                "(d) - Delete Item\n" +
                "(p) - Print Tree\n" +
                "(r) - Retrieve Item\n" +
                "(l) - Count Leaf Nodes\n" +
                "(s) - Find Single Parents\n" +
                "(c) - Find Cousins\n" +
                "(q) - Quit program");

        char command;
        do {
            System.out.print("Enter command: ");
            command = keyboard.next().charAt(0);

            switch (command) {
                case 'p':
                    System.out.print("In-order: ");
                    tree.inOrder();
                    System.out.println();
                    break;
                case 'i':
                    System.out.print("In-order: ");
                    tree.inOrder();
                    System.out.println();
                    if (inputType.equals("i")) {
                        System.out.print("Enter a number to insert: ");
                        int value = keyboard.nextInt();
                        if (((BinarySearchTree<Integer>) tree).retrieve(value)) {
                            System.out.println("The item already exists in the tree.");
                            tree.inOrder();
                            System.out.println();
                        } else {
                            ((BinarySearchTree<Integer>) tree).insert(value);
                            System.out.print("In-order: ");
                            tree.inOrder();
                            System.out.println();
                        }
                    } else if (inputType.equals("d")) {
                        System.out.print("Enter a number to insert: ");
                        double value = keyboard.nextDouble();
                        if (((BinarySearchTree<Double>) tree).retrieve(value)) {
                            System.out.println("The item already exists in the tree.");
                            tree.inOrder();
                            System.out.println();
                        } else {
                            ((BinarySearchTree<Double>) tree).insert(value);
                            System.out.print("In-order: ");
                            tree.inOrder();
                            System.out.println();
                        }
                    } else if (inputType.equals("s")) {
                        System.out.print("Enter a string to insert: ");
                        String value = keyboard.next();
                        if (((BinarySearchTree<String>) tree).retrieve(value)) {
                            System.out.println("The item already exists in the tree.");
                            tree.inOrder();
                            System.out.println();
                        } else {
                            ((BinarySearchTree<String>) tree).insert(value);
                            System.out.print("In-order: ");
                            tree.inOrder();
                            System.out.println();
                        }
                    }
                    break;
                case 'r':
                    System.out.print("In-order: ");
                    tree.inOrder();
                    System.out.println();
                    if (inputType.equals("i")) {
                        System.out.print("Enter a number to search: ");
                        int value = keyboard.nextInt();
                        if (((BinarySearchTree<Integer>) tree).retrieve(value)) {
                            System.out.println("The item is present in the tree.");
                        } else {
                            System.out.println("Item is not present in the tree.");
                        }
                    } else if (inputType.equals("d")) {
                        System.out.print("Enter a number to search: ");
                        double value = keyboard.nextDouble();
                        if (((BinarySearchTree<Double>) tree).retrieve(value)) {
                            System.out.println("The item is present in the tree.");
                        } else {
                            System.out.println("Item is not present in the tree.");
                        }
                    } else if (inputType.equals("s")) {
                        System.out.print("Enter a string to search: ");
                        String value = keyboard.next();
                        if (((BinarySearchTree<String>) tree).retrieve(value)) {
                            System.out.println("The item is present in the tree.");
                        } else {
                            System.out.println("Item is not present in the tree.");
                        }
                    }
                    break;
                case 'd':
                    System.out.print("In-Order: ");
                    tree.inOrder();
                    System.out.println();
                    if (inputType.equals("i")) {
                        System.out.print("Enter a number to delete: ");
                        int value = keyboard.nextInt();
                        if (((BinarySearchTree<Integer>) tree).retrieve(value)) {
                            ((BinarySearchTree<Integer>) tree).delete(value);
                            System.out.print("In-order: ");
                            tree.inOrder();
                            System.out.println();
                        } else {
                            System.out.println("The number is not present in the tree.");
                        }
                    } else if (inputType.equals("d")) {
                        System.out.print("Enter a number to delete: ");
                        double value = keyboard.nextDouble();
                        if (((BinarySearchTree<Double>) tree).retrieve(value)) {
                            ((BinarySearchTree<Double>) tree).delete(value);
                            System.out.print("In-order: ");
                            tree.inOrder();
                            System.out.println();
                        } else {
                            System.out.println("The number is not present in the tree.");
                        }
                    } else if (inputType.equals("s")) {
                        System.out.print("Enter a string to delete: ");
                        String value = keyboard.next();
                        if (((BinarySearchTree<String>) tree).retrieve(value)) {
                            ((BinarySearchTree<String>) tree).delete(value);
                            System.out.print("In-order: ");
                            tree.inOrder();
                            System.out.println();
                        } else {
                            System.out.println("Item is not present in the tree.");
                        }
                    }
                    break;
                case 'l':
                    System.out.println("The number of leaf nodes are " + tree.getNumLeafNode());
                    break;
                case 's':
                    System.out.print("Single Parents: ");
                    tree.getSingleParent();
                    System.out.println();
                    break;
                case 'c':
                    System.out.print("In-Order: ");
                    tree.inOrder();
                    System.out.println();
                    if (inputType.equals("i")) {
                        System.out.print("Enter a number: ");
                        int value = keyboard.nextInt();
                        System.out.print(value + " cousins: ");
                        ((BinarySearchTree<Integer>) tree).getCousins(value);
                        System.out.println();
                    } else if (inputType.equals("d")) {
                        System.out.print("Enter a number: ");
                        double value = keyboard.nextDouble();
                        System.out.print(value + " cousins: ");
                        ((BinarySearchTree<Double>) tree).getCousins(value);
                        System.out.println();
                    } else if (inputType.equals("s")) {
                        System.out.print("Enter a string: ");
                        String value = keyboard.next();
                        System.out.print(value + " cousins: ");
                        ((BinarySearchTree<String>) tree).getCousins(value);
                        System.out.println();
                    }
                    break;
            }
        } while (command != 'q');
        System.out.println("Exiting the program...");
        keyboard.close();
    }
}