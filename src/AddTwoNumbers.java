import java.math.BigInteger;

public class AddTwoNumbers {

public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

    public void add(ListNode head,int x) {
    	ListNode temp=head;
    	while(temp.next!=null)temp=temp.next;
    	temp.next=new ListNode(x);
    }
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode prev = null;
		ListNode head = null;
		BigInteger sum=BigInteger.valueOf(0);
		BigInteger i=BigInteger.valueOf(1);
		BigInteger ten=BigInteger.valueOf(10);
		BigInteger zero=BigInteger.valueOf(0);
		while(l1!=null) {
	        BigInteger bigInteger = BigInteger.valueOf(l1.val);
	        bigInteger=bigInteger.multiply(i);
			sum=sum.add(bigInteger);
			i=i.multiply(ten);
			l1=l1.next;
		}
		i=BigInteger.valueOf(1);
		while(l2!=null) {
		       BigInteger bigInteger = BigInteger.valueOf(l2.val);
		        bigInteger=bigInteger.multiply(i);
				sum=sum.add(bigInteger);
				i=i.multiply(ten);
			    l2=l2.next;
		}
		 if(sum.equals(zero)) {
			 return new ListNode(0);
		 }
		 BigInteger rem=BigInteger.valueOf(0);
		 while(!sum.equals(zero)) {
			 rem=sum.remainder(ten);
			 if(head==null) {
				 head=prev=new ListNode(rem.intValue());
			 }else {
				 prev.next=new ListNode(rem.intValue()); 
				 prev=prev.next;
			 }
			 sum=sum.divide(ten);
		 }
		
		return head;

	}
	
	
	public static void main(String args[]) {
		AddTwoNumbers obj=new AddTwoNumbers();
		AddTwoNumbers.ListNode l1=obj.new ListNode(9);
	       obj.add(l1, 8);

		AddTwoNumbers.ListNode l2=obj.new ListNode(1);
		AddTwoNumbers.ListNode head=obj.addTwoNumbers1(l1,l2);
		while(head!=null) {
			System.out.println(head.val);
			head=head.next;
		}
		
		
	}
}