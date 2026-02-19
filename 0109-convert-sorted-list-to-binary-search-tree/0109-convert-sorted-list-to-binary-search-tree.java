class Solution {
    public TreeNode bst(int[] nums,int low,int high){
        if(low>high)return null;
        int mid=low+(high-low)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=bst(nums,low,mid-1);
        root.right=bst(nums,mid+1,high);
        return root;
    }
    public TreeNode sortedListToBST(ListNode head) {
        ListNode temp=head;
        int n=0;
        while(temp!=null){
            temp=temp.next;
            n++;
        }
        int[] arr=new int[n];
        int i=0;
        while(head!=null){
            arr[i]=head.val;
            i++;
            head=head.next;
        }
       return bst(arr,0,arr.length-1);
    }
}






