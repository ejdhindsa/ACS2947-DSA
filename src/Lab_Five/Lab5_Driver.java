package Lab_Five;

/**
 * ACS-2947 - Lab 5
 * Driver as required by the lab question
 *
 * @author Ekamjot Singh | 3167888
 * @see <a href="https://github.com/ejdhindsa/ACS2947-DSA/tree/main/src/Lab_Five">GitHub</a>
 */
public class Lab5_Driver
{
    public static void main(String[] args)
    {
        // creating a new tree to put all the elements in
        LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();

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

        System.out.print("The descendants of Tojo Clan: ");
        allDescendants(tree, root);
        System.out.println();

        System.out.print("The descendants of Dojima Family: ");
        allDescendants(tree, tree.left(root));
        System.out.println();

        System.out.print("The path from I to root(A): ");
        pathToRoot(tree, tree.right(P2));
        System.out.println();

        System.out.println("Tree height: " + tree.height(root));

        System.out.println("Depth of right child of the root (C): " + tree.depth(tree.right(root)));

        System.out.println("Removed Node: " + tree.remove(tree.left(P2)));

        System.out.println("Final tree size: " + tree.size());

    } // end of main

    /**
     * Public static method that prints all the descendants of the given node in a tree
     * @param tree the tree in which the node is present
     * @param position the position of which descendants must be printed
     */
    public static void allDescendants(LinkedBinaryTree<String> tree, Position<String> position)
    {
        for(Position<String> p : tree.children(position))
        {
            System.out.print(p.getElement() + ", ");
            allDescendants(tree, p);
        } // end of for

    } // end of allDescendants

    /**
     * Public static method that prints values from a position p to upwards towards the root
     * @param tree the tree
     * @param position the position from which we move above
     */
    public static void pathToRoot(LinkedBinaryTree<String> tree, Position<String> position)
    {
        int depth = tree.depth(position);

        for(int i = 0; i <= depth; i++)
        {
            System.out.print(position.getElement() + ", ");
            position = tree.parent(position);

        } // end of for

    } // end of pathToRoot

} // end of Lab5_Driver
