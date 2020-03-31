package com.geekshow.linetable;

public class Node {

	Object data;
	
	Node nextNode;

	public Node(Object data, Node nextNode) {
		super();
		this.data = data;
		this.nextNode = nextNode;
	}

	public Node() {
		super();
	}
	
}
