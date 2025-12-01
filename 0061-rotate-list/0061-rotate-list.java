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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null)return head;
        ListNode temp=head;
        int n=1;
        while(temp.next!=null){
            n++;
            temp=temp.next;
        }
        temp.next=head;
        k=k%n;
        int jump=n-k;
        for(int i=1;i<=jump;i++){
            temp=temp.next;
        }
        ListNode returnhead=temp.next;
        temp.next=null;
        return returnhead;
    }
}