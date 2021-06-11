package multiclass;

public class AddTwoNumbers2 {

	public static void main(String[] args) {

		ListNode2 last = new ListNode2(3);
		ListNode2 mid = new ListNode2(4, last);
		ListNode2 first = new ListNode2(2, mid);
		ListNode2 last2 = new ListNode2(8);
		ListNode2 mid2 = new ListNode2(6, last2);
		ListNode2 first2 = new ListNode2(5, mid2);
		ListNode2 l3 = addTwoNumbers(first, first2);
		while (l3 != null) {
			System.out.println(l3.val);
			l3 = l3.next;
		}
	}

	// leetcode provided solution.
	// I can't solve this.
	public static ListNode2 addTwoNumbers(ListNode2 l1, ListNode2 l2) {
		ListNode2 temp = new ListNode2(0);
		ListNode2 l3;
		l3 = temp;
		int carry = 0;
		int sum = 0;
		while (l1 != null || l2 != null) {
			if (l1 != null) {
				sum = l1.val + carry;
				carry = 0;
			}
			if (l2 != null) {
				sum = sum + l2.val + carry;
			}
			temp.next = new ListNode2(sum % 10);
			carry = sum / 10;
			temp = temp.next;
			l1 = l1.next;
			l2 = l2.next;
		}

		if (carry > 0) {
			temp.next = new ListNode2(carry);
		}
		return l3.next;

	}
}
