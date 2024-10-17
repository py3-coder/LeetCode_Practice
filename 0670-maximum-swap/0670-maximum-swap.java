class Solution {
    public int maximumSwap(int num) {
        String st = String.valueOf(num);
       
        List<Integer> arr = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int k=0;
        for(char ch : st.toCharArray()){
            map.put(ch-'0',k);
            arr.add(ch-'0');
            k++;
        }
        //System.out.println(map);
        Collections.sort(arr, Collections.reverseOrder());
        //System.out.print(arr);
        for(int i=0;i<arr.size();i++){
            if(st.charAt(i)-'0'<arr.get(i)){
                //swap
                return Integer.valueOf(swap(st,i,map.get(arr.get(i))));
            }
        }
        return Integer.valueOf(st);
        
    }
    public String swap(String st , int indx , int pos){
        char[] ch = st.toCharArray();
        char temp = ch[indx];
        ch[indx] = ch[pos];
        ch[pos] = temp;

        return new String(ch);
        
    }
}