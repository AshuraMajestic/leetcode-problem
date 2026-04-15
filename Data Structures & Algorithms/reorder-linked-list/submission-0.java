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
    public void reorderList(ListNode head) {
        List<Integer> list=new ArrayList<>();
        ListNode temp=head;
        while(temp!=null){
            list.add(temp.val);
            temp=temp.next;
        }
        int i=0;
        int j=list.size()-1;
        temp=head;
        while(i<j){
            temp.val=list.get(i);
            temp=temp.next;
            temp.val=list.get(j);
            temp=temp.next;
            i++;
            j--;
        }
        if(i==j){
            ListNode l1=new ListNode(list.get(i));
            temp.val=list.get(j);
            temp=temp.next;
        }
    }
}
