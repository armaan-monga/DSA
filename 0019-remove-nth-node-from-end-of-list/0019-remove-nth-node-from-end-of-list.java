class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp=head;
        int size=0;
        while(temp!=null){
            temp=temp.next;
            size++;
        }
        temp=head;
        if(size==1)return null;
        if(size==n)return head.next;
        for(int i=1;i<size-n;i++){
            temp=temp.next;
        }
        temp.next=temp.next.next;
        return head;
    }
}