package AssignmentThree.QuestionOne;

import java.util.Scanner;

/**
 * ACS-2947 - Assignment Three
 * @author Ekamjot Singh | 3167888
 * @see <a href="https://github.com/ejdhindsa/ACS2947-DSA/tree/main/src/AssignmentThree">GitHub</a>
 */
public class PartA_Driver
{
    public static void main(String[] args)
    {

        // creating a new tree to put all the elements in
        LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();
        populateTree(tree);

        // printing the tree
        System.out.println("Tree");
        System.out.println("-----");
        System.out.println(tree);
        System.out.println();

        // creating a decision tree
        LinkedBinaryTree<String> decisionTree = new LinkedBinaryTree<>();

        // populating the decision tree
        populateDecisionTree(decisionTree);
        // System.out.println(decisionTree);

        // starting a try-catch to check print the tree
        try {
            treeInteraction(decisionTree);
        } // end of try
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
            System.out.println("Please try again!\n");
            treeInteraction(decisionTree);
        } // end of catch

        // -------- Question Three ---------

        // creating a new arithmeticTree
        LinkedBinaryTree<String> arithmeticTree = new LinkedBinaryTree<>();
        populateArithmeticTree(arithmeticTree);
        // System.out.println(arithmeticTree);

        System.out.println("Arithmetic Tree\n----------------------");
        System.out.println("Inorder: " +arithmeticTree.inorder());
        System.out.println("Postorder: " + arithmeticTree.postorder());
        System.out.println("Tree value: " + evaluateTree(arithmeticTree));

    } // end of main

    public static int evaluateTree(LinkedBinaryTree<String> tree)
    {
        // variables
        LinkedStack<Integer> stack = new LinkedStack<>();        // declaring a stack to hold all the values

        // for loop that pushes all elements in the stack
        for (Position<String> p : tree.postorder())
        {
            String element = p.getElement();            // element in the current position

            if(element.equals("+"))
            {
                int valueOne = stack.pop();
                int valueTwo = stack.pop();
                stack.push(valueTwo + valueOne);
            } // end of if
            else if (element.equals("-"))
            {
                int valueOne = stack.pop();
                int valueTwo = stack.pop();
                stack.push(valueTwo - valueOne);
            } // end of else if
            else if (element.equals("*"))
            {
                int valueOne = stack.pop();
                int valueTwo = stack.pop();
                stack.push(valueTwo * valueOne);
            } // end of else if
            else if (element.equals("/"))
            {
                int valueOne = stack.pop();
                int valueTwo = stack.pop();
                stack.push(valueTwo / valueOne);
            } // end of else if
            else
            {
                stack.push(Integer.parseInt(element));
            } // end of else

        } // end of for

        return stack.top();
    } // end of evaluateTree

    /**
     * Public method that allows user to work through a yes/no decision true.
     * The method has been made to keep them main method clean but also implement a try-catch scenario
     * to avoid user from entering the incorrect input.
     * A while loop could have been used to force user to choose the correct option, but I wanted to
     * only warn the user once and then fail the program (so that the user is prevented from making the same
     * mistake again since program breaking errors are more effective than continually asking for
     * the right input).
     * @param decisionTree decision tree to which the insertion is done
     * @throws IllegalArgumentException if user input an erroneous decision
     */
    public static void treeInteraction(LinkedBinaryTree<String> decisionTree)
            throws IllegalArgumentException
    {
        // importing a scanner for decision-making
        Scanner kb = new Scanner(System.in);
        String userInput;

        System.out.println("Tree Interaction");
        System.out.println("-----");

        // implementing the transversal of the tree based on the input taken by the user
        Position<String> current = decisionTree.root();             // accessing the root of the decision tree

        // a while loop that runs until the current position has children
        while (decisionTree.numChildren(current) > 0)
        {
            // printing the element
            System.out.println(current.getElement() + " (yes/no)");
            userInput = kb.next();

            // getting left or right child based on userInput
            if(userInput.equalsIgnoreCase("yes"))
                current = decisionTree.left(current);
            else if (userInput.equalsIgnoreCase("no"))
                current = decisionTree.right(current);
            else
                throw new IllegalArgumentException("Incorrect input!");

        } // end of while

        // printing the final decision based on user's choices
        System.out.println("Final Decision: " + current.getElement());

    } // end of TreeInteraction

    /**
     * The only reason that this method exists is to simply keep the main method clean.
     * It populates the tree with all the arithmetic values as seen in the question
     * @param arithmeticTree tree that is to bbe populated
     */
    public static void populateArithmeticTree(LinkedBinaryTree<String> arithmeticTree)
    {
        Position<String> root = arithmeticTree.addRoot("-");
        Position<String> pOne = arithmeticTree.addLeft(root, "*");
        Position<String> pTwo = arithmeticTree.addRight(root, "-");
        Position<String> pThree = arithmeticTree.addLeft(pOne, "/");
        Position<String> pFour = arithmeticTree.addRight(pOne, "+");
        Position<String> pFive = arithmeticTree.addLeft(pTwo, "+");
        Position<String> pSix = arithmeticTree.addRight(pTwo, "*");
        Position<String> pSeven = arithmeticTree.addLeft(pThree, "+");
        arithmeticTree.addRight(pThree, "3");
        Position<String> pEight = arithmeticTree.addLeft(pFour, "-");
        Position<String> pNine = arithmeticTree.addRight(pFour, "*");
        Position<String> pTen = arithmeticTree.addLeft(pFive, "*");
        arithmeticTree.addRight(pFive, "3");
        arithmeticTree.addLeft(pSix, "7");
        arithmeticTree.addRight(pSix, "2");
        arithmeticTree.addLeft(pSeven, "7");
        arithmeticTree.addRight(pSeven, "5");
        arithmeticTree.addLeft(pEight, "7");
        arithmeticTree.addRight(pEight, "1");
        arithmeticTree.addLeft(pNine, "8");
        arithmeticTree.addRight(pNine, "2");
        arithmeticTree.addLeft(pTen, "6");
        arithmeticTree.addRight(pTen, "3");

    } // end of populateArithmeticTree

    /**
     * The only reason that this method exists is to simply keep the main method clean.
     * It populates the tree with a decision-based based questions
     * @param tree tree that is to bbe populated
     */
    public static void populateDecisionTree(LinkedBinaryTree<String> tree)
    {
        Position<String> root = tree.addRoot("Is it glowing with a cool aura?");
        Position<String> pOne = tree.addLeft(root, "Is it behind a locked door?");
        Position<String> pTwo = tree.addRight(root, "Just lying there?");
        Position<String> pThree = tree.addLeft(pOne, "Is there a boss?");
        Position<String> pFour = tree.addRight(pOne, "Is it in a chest?");
        Position<String> pFive = tree.addLeft(pTwo, "Is it in a chest?");
        Position<String> pSix = tree.addRight(pTwo, "Too easy to get?");
        Position<String> pSeven = tree.addLeft(pThree, "Fight it!");
        tree.addLeft(pSix, "Is it Fake?");
        tree.addRight(pSix, "Free loot! Yay!");
        tree.addLeft(pSeven, "You can do it!");
        tree.addRight(pSeven, "Womp womp!");
        tree.addLeft(pFour, "Try to open it up!");
        tree.addRight(pFour, "Free Loot! Lets gooooooo!");
        tree.addLeft(pFive, "Show your lock picking skills bruh!");
        tree.addRight(pFive, "Nobody says no to free shit!");


    } // end of populateDecisionTree

    /**
     * The only reason that this method exists is to simply keep the main method clean.
     * It populates the tree with the same elements as lab five
     * @param tree tree which is to be populated
     */
    public static void populateTree(LinkedBinaryTree<String> tree)
    {
        // populating the tree with strings
        // Easter Egg: The names in the tree hierarchy is the lineage of Yakuza Families from
        // Like A Dragon games!
        Position<String> root = tree.addRoot("Tojo Clan");
        Position<String> P1 = tree.addLeft(root, "Dojima Family");
        Position<String> P2 = tree.addLeft(P1, "Kazama Family");
        tree.addLeft(P2, "Shibusuwasa Family");
        tree.addRight(P1, "Nishikiyama Family");
        tree.addRight(P2, "Kuze Clan");
        Position<String> P3 = tree.addRight(root, "Shimano Family");
        Position<String> P4 = tree.addLeft(P3, "Majima Family");
        tree.addLeft(P4, "Majima Construction");
        tree.addRight(P3, "Sagawa Family");
        tree.addRight(P4, "Majima Arena");

    } // end of populateTree()

} // end of PartA_Driver
