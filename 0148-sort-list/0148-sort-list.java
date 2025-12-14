class Solution {
    public ListNode sortList(ListNode head) {
        ListNode temp=head;
        int size=0;
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        temp=head;
       int[] arr=new int[size];
       for(int i=0;i<size;i++){
        arr[i]=temp.val;
        temp=temp.next;
       }
       Arrays.sort(arr);
       temp=head;
       for(int i=0;i<size;i++){
        temp.val=arr[i];
        temp=temp.next;
       }
       return head;
    }
}