package Tree;

import java.util.Iterator;

/**
 * ACS-2947-002 | Data Structures and Algorithms <br>
 * Public Interface that creates a Tree while extending the iterable class to make the trees
 * iterable.
 *
 * @author Ekamjot Singh | 3167888
 */
public interface Tree<E> extends Iterable
{
   /**
    * Returns the root of the tree as a Position
    * @return root of the tree
    */
   Position<E> root();

   /**
    * Returns the parent of the argument that has been passed into the method
    * @param p element of which the parent need needs to be found
    * @return the parent of the passed parameter
    * @throws IllegalArgumentException if the element is root
    */
   Position<E> parent(Position<E> p) throws IllegalArgumentException;

   /**
    * Returns the iterable (of type position) that contains the children of a node
    * @param p element of which children need to be found
    * @return iterable children of the element
    * @throws IllegalArgumentException if the element has no children
    */
   Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException;

   /**
    * Returns the number of children a node has
    * @param p element of which number of children needs to be found
    * @return number of children of parameter p
    * @throws IllegalArgumentException if an error occurs
    */
   int numChildren(Position<E> p) throws IllegalArgumentException;

   /**
    * Return if the passed parameter is an internal, i.e. it has children
    * @param p element to be checked if internal or not
    * @return boolean value true if an element is internal, false otherwise
    * @throws IllegalArgumentException if an argument error occurs
    */
   boolean isInternal(Position<E> p) throws IllegalArgumentException;

   /**
    * Return is the passed parameter is an external, i.e. it has no children
    * @param p element to be checked if external or not
    * @return boolean value true if an element is external, false otherwise
    * @throws IllegalArgumentException if an argument error occurs
    */
   boolean isExternal(Position<E> p) throws IllegalArgumentException;

   /**
    * Returns a boolean value if the passed parameter is the rot of the tree, i.e. it has
    * no parents (it is the only node without parents)
    * @param p element to be checked if it is a root
    * @return boolean value true of element is the root, false otherwise
    * @throws IllegalArgumentException if an error occurs
    */
   boolean isRoot(Position<E> p) throws IllegalArgumentException;

   /**
    * Returns the size of the tree
    * @return int size of the tree
    */
   int size();

   /**
    * Returns if the tree is empty or not
    * @return true if the tree is empty, false otherwise
    */
   boolean isEmpty();

   /**
    * Iterator method that returns an iterator
    * @return returns an iterator
    */
   @Override
   Iterator<E> iterator();

   /**
    * Method that returns an iterable of type position that allows users to iterate through the
    * position list
    * @return iterable of type of Position
    */
   Iterable<Position<E>> positions();

} // end of interface
