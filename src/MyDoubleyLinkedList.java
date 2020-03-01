import java.math.BigDecimal;

public class MyDoubleyLinkedList {
 public class Node<T>{
		public Node() {
			
		}
		public Node(T data) {
			this.data=data;
			this.next=null;
			this.prev=null;
		}
		T data;
		Node<T> next;
		Node<T>prev;
	}
	public class LinkedList<T>{
		Node<T> head;
		Node<T>tail;
		int size;
	public void add(T data) {
		if(tail==null && head==null) {
			tail=head=new Node<T>(data);
			size++;
			
		}else {
			Node<T> temp=new Node<T>(data);
			tail.next=temp;
			temp.prev=tail;
			tail=temp;
			size++;
		}
	}

	public void remove(T data) {
		Node<T> temp=head;
		Node<T>prev=null;

		while(temp!=null) {
			
			if(temp.data instanceof String  &&  temp.data==data) {
				remove(temp, prev);
				size--;
				return;
			}else 	if(temp.data instanceof Double  &&  new BigDecimal(""+temp.data+"").compareTo(new BigDecimal(""+data+""))==0) {
				remove(temp, prev);
				size--;

				return;
			}else if(temp.data==data){
				remove(temp, prev);
				size--;

	            return;
			}
			prev=temp;
			temp=temp.next;

		}
	}

	private void remove(Node<T> temp, Node<T> prev) {
		if(prev==null) {
			head=temp.next;
			head.prev=null;
			return;
		}else if(temp==tail) {
		    prev.next=temp.next;	
		   tail=prev;
		   return;
		}
		prev.next=temp.next;
		return;
	}

	public void printFromHead() {
		Node<T> temp=head;
		while(temp!=null) {
			System.out.println(temp.data);
			temp=temp.next;
		}
	}
	public void printFromTail() {
		Node<T> temp=tail;
		while(temp!=null) {
			System.out.println(temp.data);
			temp=temp.prev;
		}
	}
		
	}
	
	public static void main(String[] args){
		MyDoubleyLinkedList outerClass=new MyDoubleyLinkedList();
		MyDoubleyLinkedList.LinkedList<Object> list=outerClass.new LinkedList<>();
		list.add("1");
		list.add(2);
		list.add(3);
		list.add(4.5);
		System.out.println("Size of  list");
		System.out.println(list.size);
		System.out.println("Print from  start");
		list.printFromHead();
		System.out.println("Print from  end");
		list.printFromTail();
		
		list.remove("1");
		list.remove(3);
		list.remove(4.5);
		System.out.println("After removing =Size of  list");
		System.out.println(list.size);
		System.out.println("After removing =Print from  start");
		list.printFromHead();
		System.out.println("After removing =Print from  end");
		list.printFromTail();


	}

}
