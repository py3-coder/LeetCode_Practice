class Solution {
    // public int[] findArray(int[] pref) {
    //     int prev =pref[0];
    //     int res[] =new int[pref.length];
    //     res[0] =prev;
    //     for(int i=1;i<pref.length;i++){
    //         res[i] =prev^pref[i];
    //         prev = pref[i];
    //     }
    //     return res;
    // }
    public int[] findArray(int[] pref) {
        int prev =pref[0];
        for(int i=1;i<pref.length;i++){
            pref[i] =pref[i]^prev;
            prev ^= pref[i];
        }
        return pref;
    }
}