class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result=new ListNode[k];
        if(head==null)return result;
        ListNode temp=head;
        int n=0;
        while(temp!=null){
            n++;
            temp=temp.next;
        }
        ListNode curr=head;
        ListNode prev=null;
        int extranode=n%k;
        int buckets=n/k;
        for(int i=0;i<k;i++){
            result[i]=curr;
        for(int j=1;j<=buckets+(extranode>0?1:0);j++){
            prev=curr;
            curr=curr.next;
        }
        prev.next=null;
        extranode--;
    }
    return result;
}

}