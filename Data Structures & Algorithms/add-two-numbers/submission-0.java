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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans=new ListNode(0);
        ListNode dummy=ans;
        boolean carry=false;
        while(l1!=null && l2!=null){
            int c=carry?1:0;
            int sum=l1.val+l2.val+c;
            if(sum>9){
                carry=true;
                dummy.next=new ListNode(sum%10);
                dummy=dummy.next;
            }else{
                carry=false;
                dummy.next=new ListNode(sum);
                dummy=dummy.next;
            }
            l2=l2.next;
            l1=l1.next;
        }
        while(l1!=null){
            int c=carry?1:0;
            int sum=l1.val+c;
            if(sum>9){
                carry=true;
                dummy.next=new ListNode(sum%10);
                dummy=dummy.next;
            }else{
                carry=false;
                dummy.next=new ListNode(sum);
                dummy=dummy.next;
            }
            l1=l1.next;
        }
        while(l2!=null){
            int c=carry?1:0;
            int sum=l2.val+c;
            if(sum>9){
                carry=true;
                dummy.next=new ListNode(sum%10);
                dummy=dummy.next;
            }else{
                carry=false;
                dummy.next=new ListNode(sum);
                dummy=dummy.next;
            }
            l2=l2.next;
        }
        if(carry){
            dummy.next=new ListNode(1);
        }
        return ans.next;
    }
}
