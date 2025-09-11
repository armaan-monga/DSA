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
    public ListNode deleteDuplicates(ListNode head) {
        
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;                 
        ListNode temp = head; 
        if(head==null || head.next==null)return head;
            while(temp!=null){
            boolean isduplicate=false;
            while(temp.next!=null && temp.val==temp.next.val){
                temp=temp.next;
                isduplicate=true;
            }
            if(isduplicate){
                prev.next=temp.next;
            }
            else{
                prev=prev.next;
            }
            temp=temp.next;
        }
        return dummy.next;

    }
}