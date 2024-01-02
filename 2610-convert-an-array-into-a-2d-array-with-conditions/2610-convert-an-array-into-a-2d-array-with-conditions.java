class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int a[]=new int[201];
        for(int i:nums)
        {
            a[i]++;
        }
        List<List<Integer>> kk=new ArrayList<>();
        while(true)
        {
            List<Integer> k=new ArrayList<>();
            int x=0;
            for(int i=0;i<201;i++)
            {
                if(a[i]>0)
                {
                    k.add(i);
                    a[i]-=1;
                }
                else
                {
                    x++;
                }
            }
            if(x==201)
            {
                break;
            }
            kk.add(new ArrayList<>(k));
        }
        return kk;
    }
}