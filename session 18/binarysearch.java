public class binarysearch{
    public static int lowerbound(int[] a, int t ){
        int l=0,r=a.length-1;
        int k=a.length;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(a[mid]>=t){
                k=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return k;
    }
    public static int upperbound(int[] a, int t ){
        int l=0,r=a.length-1;
        int k=a.length;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(a[mid]>t){
                k=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] a= new int[]{1,2,5,7,10,100,102,104,200,300};
        int t = 5;
        int l=0,r=a.length-1;
        int k=-1;
        int b[]= new int[]{0,1,1,1,1,1,2,2,2,2,4,5,6,7,8};
        while(l<=r){
            int mid = l+(r-l)/2;
            if(a[mid]==t){
                k=mid;
                break;
            }
            else if(a[mid]>t){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        if(k==-1){
            System.out.println("element not found");
        }
        else{
            System.out.println("element found at index= "+k);
        }
        System.out.println("lower bound of 2 is at index= "+lowerbound(b,2));
        System.out.println("lower bound of 1 is at index= "+lowerbound(b,1));
        System.out.println("upper bound of 4 is at index= "+upperbound(b,4));
        System.out.println("upper bound of 7 is at index= "+upperbound(b,7));
    }
}