package com.geekshow.linetable;

import java.util.Arrays;

public class ArrayList implements List {
	
	private int size = 0;//数组长度
	
	private Object[] elementData;//数组
	
	public ArrayList() {
		elementData = new Object[10];
	}

	public int size() {
		return size;
	}

	public Object get(int i) {
		
		if(i<0 || i > size) {
			throw new MyArrayIndexOutOfBoundsException("数组索引越界异常:"+i);
		}
		return elementData[i];
	}

	public boolean isEmpty() {
		return size == 0 ? true : false;
	}

	public boolean contains(Object e) {
		
		for(int i = 0; i < size; i++) {
			if(elementData[i].equals(e)) {
				return true;
			}
		}
		return false;
	}

	public int indexOf(Object e) {
		
		for(int i = 0; i < size; i++) {
			if(elementData[i].equals(e)) {
				return i;
			}
		}
		return -1;
	}

	public void add(int i, Object e) {

		if(i<0 || i > size) {
			throw new MyArrayIndexOutOfBoundsException("数组索引越界异常:"+i);
		}
		
		if (size == elementData.length) {
			elementData = Arrays.copyOf(elementData, elementData.length*2);
		}
		
		for (int j = size; j > i; j--) {
			elementData[j+1] = elementData[j];
		}
		
		elementData[i] = e;
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
		for(int i=0;i<size;i++){
			if(i !=size -1){
				builder.append(elementData[i]+",");
			}else{
				builder.append(elementData[i]);
			}
			
		}
		builder.append("]");
		return builder.toString();
	}
	
	

}
