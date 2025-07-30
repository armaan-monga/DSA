class Solution {
public:
    void rotate(vector<int>& arr, int k) {
        int n=arr.size();
        k=k%n;
        int i=0;
        int j=n-k-1;
        while(i<=j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        i++;
        j--;
    }
    i=n-k;
    j=n-1;
    while(i<=j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        i++;
        j--;
    }
    i=0;
    j=n-1;
    while(i<=j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        i++;
        j--;
    }return;
    }
};