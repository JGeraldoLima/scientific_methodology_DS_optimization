package com.implementations.bst;

public interface BST {
	/**
	 * Returns the root of the tree.
	 * 
	 * @return
	 */
	public BSTNode getRoot();

	/**
	 * Say if a BST is empty (NIL).
	 */
	public boolean isEmpty();

	/**
	 * The height of a BST. An empty BST has height -1 (there is no root
	 * element).
	 */
	public int height();

	/**
	 * Searches a key in a BST. The search starts at the root node.If the key
	 * does not exist the methods returns a NIL (empty) node.
	 */
	public BSTNode search(String data);

	/**
	 * Inserts a key in a a BST.
	 */
	public void insert(String data);

	/**
	 * Returns the number of nodes (not NIL) in a BST.
	 */
	public int size();
}
