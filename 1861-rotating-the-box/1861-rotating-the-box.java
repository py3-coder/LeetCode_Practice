class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        
        // 1.Rotate
        // 2. Gravity fall
       
        char[][] res = new char[n][m];
        
        //rotate
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                res[j][i] = box[m-1-i][j];
            }
        }
       
        //gravity fall :
        for(int i=0;i<m;i++){
            int last = n-1;
            for(int j=n-1;j>=0;j--){
                char ch = res[j][i];
                if(ch=='.') continue;
                if(ch=='#'){
                    res[j][i] = '.';
                    res[last][i]='#';
                    last--;
                }
                if(ch=='*') last =j-1;
                
            }
        }
        return res;
    }
}