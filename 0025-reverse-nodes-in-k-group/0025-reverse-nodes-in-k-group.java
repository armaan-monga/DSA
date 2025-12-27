class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count=0;
        int size=0;
        ListNode temp=head;
        ListNode curr=head;
        ListNode next=null;
        ListNode prev=null;
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        if(size<k)return head;
        while(curr!=null && count<k){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            count++;
        }
        if(head!=null){
            head.next=curr;
        }
        if(curr!=null){
            head.next=reverseKGroup(curr,k);
        }
        return prev;
    }  
}