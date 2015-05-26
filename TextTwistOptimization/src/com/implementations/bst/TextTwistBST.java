package com.implementations.bst;

import com.implementations.TextTwist;

public class TextTwistBST implements TextTwist, BST {

	protected BSTNode root;

	public TextTwistBST() {
		root = new BSTNode();
	}

	public BSTNode getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return heightAux(root);
	}

	public int heightAux(BSTNode node) {
		int auxLeft = 0, auxRight = 0;

		if (node.isEmpty()) {
			return -1;
		}

		auxLeft = heightAux(node.left);
		auxRight = heightAux(node.right);

		if (auxLeft > auxRight) {
			return auxLeft + 1;
		} else {
			return auxRight + 1;
		}
	}

	protected BSTNode findNode(BSTNode treeNode, BSTNode node) {

		BSTNode result = null;

		if (!treeNode.isEmpty() && !node.isEmpty()) {

			if (treeNode.equals(node)) {

				result = treeNode;

			} else if (node.data.compareTo(treeNode.data) < 0) {

				result = findNode(treeNode.left, node);

			} else if (node.data.compareTo(treeNode.data) > 0) {

				result = findNode(treeNode.right, node);

			}

		}

		return result;

	}

	@Override
	public BSTNode search(String data) {
		return search(root, data);
	}

	protected BSTNode search(BSTNode node, String data) {
		BSTNode result = node;
		if (data != null) {
			if (!node.isEmpty()) {
				if (data.compareTo(node.data) == 0) {
					result = node;
				} else if (data.compareTo(node.data) < 0) {
					result = search(node.left, data);
				} else {
					result = search(node.right, data);
				}
			}
		}

		return result;
	}

	@Override
	public void insert(String data) {

		BSTNode aux = this.root;
		if (isEmpty()) {
			aux.setData(data);
			aux.setLeft(new BSTNode());
			aux.setRight(new BSTNode());
			aux.left.parent = aux;
			aux.right.parent = aux;
		} else {

			while (!aux.isEmpty()) {
				if (data.compareTo(aux.getData()) > 0) {
					aux = aux.getRight();
				} else {
					aux = aux.getLeft();
				}
			}

			aux.setData(data);
			aux.left = new BSTNode();
			aux.right = new BSTNode();
			aux.left.parent = aux;
			aux.right.parent = aux;
		}
	}

	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode node) {
		int result = 0;
		if (!node.isEmpty()) {
			result = 1 + size(node.left) + size(node.right);
		}
		return result;
	}

	@Override
	public void insertInDictionary(String input) {
		insert(input);
	}

	@Override
	public boolean searchWord(String word) {
		BSTNode result = search(word);
		return !result.isEmpty();
	}
}
