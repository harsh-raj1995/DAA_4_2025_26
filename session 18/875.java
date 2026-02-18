class Solution {
    public int minEatingSpeed(int[] p, int h) {
        int max=p[0];
        for(int i=1;i<p.length;i++){
            if(max<p[i]){
                max=p[i];
            }
        }
        int l=1,r=max;
        int m=(l+r)/2;
        int s=0;
        while(l<r){
            for(int i=0;i<p.length;i++){
                s += (p[i] + m - 1) / m;
            }
            if(s<=h){
                r=m;
            }
            if(s>h){
                l=m+1;
            }
            m=(l+r)/2;
            s=0;
        }
        return l;
    }
}