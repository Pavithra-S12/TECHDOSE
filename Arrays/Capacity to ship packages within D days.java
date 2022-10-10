class Solution {

public static boolean check(int[]arr, int days, int mid){
    
    int dCount = 1;
    int loadNum = 0;
    
    for(int i=0; i<arr.length; i++){
        if(loadNum + arr[i] <=mid){
            loadNum += arr[i];
        }
        else{
            loadNum = arr[i];
            dCount++;
        }
    }
    if(dCount <= days){
        return true;
    }
    else{
        return false;
    }
}




public int shipWithinDays(int[] arr, int days) {
    
    int n = arr.length;
    int low = arr[0];
    int high = 0;
    
    for(int i=0; i<n; i++){
        low = Math.max(arr[i], low);
        high +=arr[i];
    }
    int ans=-1;
    while(high>=low){
        int mid =(low+high)/2;
        
        if(check(arr, days, mid)){
            ans = mid;
            high= mid-1;
        }
        else{
            low= mid+1;
        }
    }
    
    return ans;
}
}
