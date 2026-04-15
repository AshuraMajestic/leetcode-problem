/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Stack<ListNode> st=new Stack<>();
        ListNode temp=head;
        while(temp!=null){
            st.push(temp);
            temp=temp.next;
        }
        while(n>0){
            st.pop();
            n--;
        }
        if (st.isEmpty()) {
            return head.next;
        }
        
        ListNode prev = st.peek();
        prev.next = prev.next.next;
        
        return head;
    }
}
