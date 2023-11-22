class Solution {
    public boolean lemonadeChange(int[] bill) {
        int cnt5=0,cnt10=0;
        for(int i=0;i<bill.length;i++){
            if(bill[i]==5){
                cnt5++;
            }else if(bill[i]==10){
                cnt10++;
                if(cnt5<1) return false;
                cnt5--;
            }else if(bill[i]==20){
                if(cnt5<1) return false;
                if(cnt5<3 && cnt10<1) return false;
                if(cnt10<1 && cnt5>3){
                    cnt5=cnt5-3;
                }else{
                    cnt10--;
                    cnt5--;
                }
            }
        }
        return true;
    }
}