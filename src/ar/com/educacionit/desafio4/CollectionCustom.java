package ar.com.educacionit.desafio4;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CollectionCustom<T> {
	private T[] array;
	
	public CollectionCustom() {
		int size = 0;
        this.array = (T[]) Array.newInstance(Object.class, size);
    }
	
	public int size() {
		return this.array.length;
	}
	public boolean empty() {
		return this.array.length == 0;
	}
	
	public void addFirst(T element) {
		T[] array2 = (T[]) Array.newInstance(Object.class, this.size()+1);
		array2[0] = element;
		for (int i = 0; i < this.size(); i++) {
			array2[i+1] = array[i];
		}
		this.array = array2.clone();
	}
	public void addLast(T element) {
		this.add(element);
	}
	public void add(T element) {
		T[] array2 = (T[]) Array.newInstance(Object.class, this.size()+1);
		for (int i = 0; i < this.size(); i++) {
			array2[i] = array[i];
		}
		array2[this.size()] = element;
		this.array = array2.clone();
	}
	public T remove(T element) {
		T[] array2 = (T[]) Array.newInstance(Object.class, this.size()-1);
		int index = 0;
		T removed = null;
		
		for (int i = 0; i < this.size(); i++) {
			if(array[i] != element) {
				array2[index] = array[i];
				index++;
			}else{
				removed = array[i];
			}
		}
		this.array = array2.clone();
		return removed;
	}
	public void removeAll() {
		int size = 0;
        this.array = (T[]) Array.newInstance(Object.class, size);
	}
	@Override
	public String toString() {
		return "CollectionCustom " + Arrays.toString(array);
	}
}
