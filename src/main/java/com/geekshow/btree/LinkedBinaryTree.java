package com.geekshow.btree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import com.geekshow.linetable.ArrayList;
import com.geekshow.linetable.List;

public class LinkedBinaryTree implements BinaryTree {
	
	Node root;

	public LinkedBinaryTree(Node node) {
		root = node;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public int size() {
		System.out.println("树结点数量");
		return size(root);
	}
	
	private int size(Node root) {
		if(root == null) {
			return 0;
		}
		//获取左子树长度 + 跟长度（1） + 获取右子树长度
		int left = size(root.leftChild);
		int right = size(root.rightChild);
		return left + 1 + right;
	}

	public int getHeight() {
		System.out.println("获取二叉树的高度");
		return getHeight(root);
	}
	
	private int getHeight(Node root) {
		
		if (root == null) {
			return 0;
		}
		//获取左子树高度和右子树高度的最大值 + 跟高度（1
		int left = getHeight(root.leftChild);
		int right = getHeight(root.rightChild);
		return Math.max(left, right) + 1;
	}

	public Node findKey(int value) {
		System.out.println("查询指定值的结点");
		return findKey(value,root);
	}
	
	private Node findKey(Object value,Node root) {
		
		if(root == null) {
			return null;
		}
		if(root != null && root.value == value) {
			return root;
		}
		Node left = findKey(value,root.leftChild);
		Node right = findKey(value, root.rightChild);
		if (left != null && left.value == value) {
			return left;
		}else if (right != null && right.value == value) {
			return right;
		}else {
			return null;
		}
	}

	public void preOrderTraverse() {

		if (root != null) {
			//中左右
			System.out.print(root.value+" ");
			LinkedBinaryTree left = new LinkedBinaryTree(root.leftChild);
			left.preOrderTraverse();
			LinkedBinaryTree right = new LinkedBinaryTree(root.rightChild);
			right.preOrderTraverse();
		}
		
	}

	public void inOrderTraverse() {
		System.out.println("中序遍历");
		inOrderTraverse(root);
		System.out.println();
	}
	
	private void inOrderTraverse(Node root) {
		//左中右
		if(root != null) {
			inOrderTraverse(root.leftChild);
			System.out.print(root.value+" ");
			inOrderTraverse(root.rightChild);
		}
	}

	public void postOrderTraverse() {
		System.out.println("后序遍历");
		postOrderTraverse(root);
		System.out.println();
	}
	
	public void postOrderTraverse(Node root) {
		//左右中
		if(root != null) {
			postOrderTraverse(root.leftChild);
			postOrderTraverse(root.rightChild);
			System.out.print(root.value+" ");
		}
	}

	public void inOrderByStack() {
		System.out.println("中序遍历非递归操作");
		Deque<Node> stack = new LinkedList<Node>();
		Node current = root;
		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				stack.push(current);
				current = current.leftChild;
			}
			if (!stack.isEmpty()) {
				current = stack.pop();
				System.out.print(current.value + " ");
				current = current.rightChild;
			}
		}
		System.out.println();
	}

	public void preOrderByStack() {
		//中左右
		System.out.println("前序遍历非递归操作");
		Deque<Node> stack = new LinkedList<Node>();
		Node current = root;
		stack.push(current);
		while (!stack.isEmpty()) {
			current = stack.pop();
			System.out.print(current.value + " ");
			if (current.rightChild != null) {
				stack.push(current.rightChild);
			}
			if (current.leftChild != null) {
				stack.push(current.leftChild);
			}
		}
		System.out.println();
	}

	public void postOrderByStack() {
		System.out.println("后序遍历非递归操作");
		Deque<Node> stack = new LinkedList<Node>();
		LinkedList<Node> list = new LinkedList<Node>();
		Node current = root;
		stack.push(current);
		while (!stack.isEmpty()) {
			current = stack.pop();
			list.addFirst(current);
			if (current.leftChild != null) {
				stack.push(current.leftChild);
			}
			if (current.rightChild != null) {
				stack.push(current.rightChild);
			}
		}
		for (Node node : list) {
			System.out.print(node.value + " ");
		}
		System.out.println();
	}

	public void levelOrderByStack() {
		System.out.println("按照层次遍历二叉树");
		levelOrderByStack(root);
		System.out.println();
	}
	
	private void levelOrderByStack(Node root) {
		if (root == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (queue.size() > 0) {
			Node temp = queue.poll();
			System.out.print(temp.value + " ");
			if (temp.leftChild != null) {
				queue.add(temp.leftChild);
			}
			if (temp.rightChild != null) {
				queue.add(temp.rightChild);
			}
		}
	}

}
