JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES =  AVLOrRedBlack.java AVLTNavigableSet.java AVLTree.java BinarySearchTree.java BinarySearchTreeWithRotate.java BinaryTree.java BTree.java RedBlackTree.java SkipList.java SLNavigableSet.java Driver.java

default: classes

classes: $(CLASSES:.java=.class)
	java Driver

clean:
	$(RM) *.class
