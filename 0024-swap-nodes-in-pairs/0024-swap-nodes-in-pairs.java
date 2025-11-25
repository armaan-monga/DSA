class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null)return null;
        if(head.next==null)return head;
        int length=0;
        ListNode temp=head;
        while(temp!=null){
            length++;
            temp=temp.next;
        }
        int pairs=length/2;
        ListNode currhead=head;
        ListNode ansnode=null;
        ListNode prevhead=null;
        for(int i=0;i<pairs;i++){
            ListNode curr=currhead;
            ListNode next=null;
            ListNode prev=null;
            for(int j=0;j<2;j++){
                next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }
            if(prevhead==null){
                ansnode=prev;
            }
            else{
                prevhead.next=prev;
            }
            prevhead=currhead;
            currhead=curr;
        }
        prevhead.next=currhead;
        return ansnode;
    }
}