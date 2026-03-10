class Solution {
    public ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(maxofk(arr,0,k-1));
        for(int i=k;i<arr.length;i++){
            if(arr[i-k]==ans.get((ans.size())-1)){
                if(arr[i-k]==arr[i]){
                    ans.add(arr[i]);
                    continue;
                }
                ans.add(maxofk(arr,i-k+1,i));
                continue;
            }
            if(arr[i]>ans.get((ans.size())-1)){
                ans.add(arr[i]);
            }else{
                ans.add(maxofk(arr,i-k+1,i-1));
            }
        }
        return ans;
    }
    public int maxofk(int[] arr,int a,int b){
        int max=arr[a];
        for(int i=a+1;i<b+1;i++){
            if(max<arr[i]){
                max=arr[i];
            }
        }
        return max;
    }
}