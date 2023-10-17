class Solution {
    public int longestStrChain(String[] words) {
        //edge case ::
        if(words.length==1){
            return 1;
        }
        // Alogo ::
        //1.Sort the based on length::
        
        Arrays.sort(words,Comparator.comparing(s->s.length()));
        System.out.println(words[0]);
        return solveLIS(words);

    }
    public static int solveLIS(String[] words){
        int n=words.length;
        int len[] = new int[n];
        Arrays.fill(len,1);

        int max=0;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(check(words[i],words[j]) && len[j]+1>len[i]){
                    len[i] =1+len[j];                    
                }
            }
            max =Math.max(len[i],max);
        }
        return max;

    }
    public static boolean check(String a,String b){
        if(a.length()!=b.length()+1) return false;

        int first=0;
        int sec=0;

        while(first<a.length()){
            if(sec<b.length() && a.charAt(first)==b.charAt(sec)){
                first++;
                sec++;
            }else{
                first++;
            }
        }
        return first==a.length() && sec==b.length();
    }
}