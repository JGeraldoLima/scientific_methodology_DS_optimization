package com.implementations.bst;

public class BSTNode {
	protected String data;
	protected BSTNode left;
	protected BSTNode right;
	protected BSTNode parent;

	public boolean isEmpty() {
		return this.data == null;
	}

	@Override
	public String toString() {
		String resp = "NIL";
		if (!isEmpty()) {
			resp = data.toString();
		}
		return resp;
	}

	@Override
	public boolean equals(Object obj) {
		boolean resp = false;
		if (obj instanceof BSTNode) {
			resp = (this.isEmpty() && ((BSTNode) obj).isEmpty())
					|| this.data.equals((((BSTNode) obj).data));
		}
		return resp;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public BSTNode getLeft() {
		return left;
	}

	public void setLeft(BSTNode left) {
		this.left = left;
	}

	public BSTNode getRight() {
		return right;
	}

	public void setRight(BSTNode right) {
		this.right = right;
	}

	public BSTNode getParent() {
		return parent;
	}

	public void setParent(BSTNode parent) {
		this.parent = parent;
	}
}
