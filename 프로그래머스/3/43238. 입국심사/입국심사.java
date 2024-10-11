class Solution {
    
    public long solution(int n, int[] times) {
        long start = 0;
        long end = 1000000000*1000000000L;
        while(start < end){
            long temp = (start + end) / 2;
            if(isValidCheck(n, temp, times)){
                end = temp;
            }else{
                start = temp + 1;
            }
        }
        
        return start;
    }
    
    public static boolean isValidCheck(int n, long tempTime, int[] times){
        long cnt = 0;
        for(int time: times){
            cnt += tempTime/time;
        }
        if(cnt >= n){
            return true;
        }else{
            return false;
        }
    }
}