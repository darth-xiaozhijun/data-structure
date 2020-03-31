package com.geekshow.linetable;

public class SingleLinkedList implements List{
	
	private int size = 0;
	
	private Node node = new Node();
	
	public int size() {
		return size;
	}

	public Object get(int i) {

		if (i < 0 || i > size) {
			throw new MyArrayIndexOutOfBoundsException("数组索引越界异常:"+i);
		}
		
		Node p = node;
		for (int j = 0; j <= i; j++) {
			p = p.nextNode;
		}
		return p.data;
	}
	
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean contains(Object e) {
		// TODO Auto-generated method stub
		return false;
	}

	public int indexOf(Object e) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void add(int i, Object e) {
		if (i < 0 || i > size) {
			throw new MyArrayIndexOutOfBoundsException("数组索引越界异常:"+i);
		}
		
		Node newNode = new Node(e, null);
		Node p = node;
		for (int j = 0; j < i; j++) {
			p = p.nextNode;
		}
		
		newNode.nextNode = p.nextNode;
		p.nextNode = newNode;
		size++;
	}

	public void add(Object e) {

		add(size, e);
	}

	public boolean addBefore(Object obj, Object e) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addAfter(Object obj, Object e) {
		// TODO Auto-generated method stub
		return false;
	}

	public Object remove(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean remove(Object e) {
		// TODO Auto-generated method stub
		return false;
	}

	public Object replace(int i, Object e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		if(size == 0){
			return "[]";
		}
		StringBuilder builder = new StringBuilder("[");
		Node p = node.nextNode;
		for(int i=0;i<size;i++){
			if(i !=size -1){
				builder.append(p.data+",");
			}else{
				builder.append(p.data);
			}
			//移动指针到下一个结点
			p  = p.nextNode;
			
		}
		builder.append("]");
		return builder.toString();	
	}

}
