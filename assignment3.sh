#! /bin/bash 

# Compile NodeType.java
javac -d bin src/NodeType.java

# Compile BinarySearchTree.java
javac -d bin -cp bin src/BinarySearchTree.java

# Compile BinarySearchTreeDriver.java
javac -d bin -cp bin src/BinarySearchTreeDriver.java

# Run BinarySearchTreeDriver
java -cp bin BinarySearchTreeDriver

# Clean up compiled files
rm -rf bin