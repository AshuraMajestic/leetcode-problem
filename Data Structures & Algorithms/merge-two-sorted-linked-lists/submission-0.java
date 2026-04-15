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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode tempHead=null;
        ListNode current=null;
        while(list1!=null && list2!=null){
            ListNode newNode;
            if(list1.val<=list2.val){
                newNode=list1;
                list1=list1.next;
            }else{
                newNode=list2;
                list2=list2.next;
            }
            if(tempHead==null){
                tempHead=newNode;
                current=tempHead;
            }else{
                current.next=newNode;
                current=current.next;
            }
        }
        if(list1!=null){
            if(tempHead==null){
                tempHead=list1;
                current=tempHead;
            }else{
                current.next=list1;
            }
        }
        if(list2!=null){
            if(tempHead==null){
                tempHead=list2;
                current=tempHead;
            }else{
                current.next=list2;
            }
        }
        return tempHead;
    }
}