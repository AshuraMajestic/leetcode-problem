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
    private ListNode revereseTheList(ListNode currentStart,ListNode currentEnd,ListNode prev,ListNode next){
        ArrayList<Integer> all=new ArrayList<>();
        while(currentStart!=currentEnd){
            all.add(currentStart.val);
            currentStart=currentStart.next;
        }
        all.add(currentEnd.val);
        for(int i=all.size()-1;i>=0;i--){
            prev.next=new ListNode(all.get(i));
            prev=prev.next;
        }
        prev.next=next;
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        ListNode currentStart = null;
        ListNode next = head;
        int j = 0;
        ListNode temp = head;
        while(temp!=null){
            if(currentStart==null){
                currentStart=temp;
            }
            j++;
            if(j==k){
                prev=revereseTheList(currentStart,temp,prev,temp.next);
                currentStart=null;
                j=0;
            }
            temp=temp.next;
        }
        return dummy.next;
    }
}