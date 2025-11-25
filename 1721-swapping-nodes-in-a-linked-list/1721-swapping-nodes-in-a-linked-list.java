class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode temp=head;
        ListNode left=head;
        ListNode right=head;
        int count=0;
        while(temp!=null){
            temp=temp.next;
            count++;
        }
        int j=count-k;
        for(int i=1;i<k;i++){
            left=left.next;
        }
        for(int i=1;i<j+1;i++){
            right=right.next;
        }
        int val=left.val;
        left.val=right.val;
        right.val=val;
        return head;
    }
}