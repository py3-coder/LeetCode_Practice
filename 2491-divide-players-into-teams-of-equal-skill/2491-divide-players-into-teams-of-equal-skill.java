class Solution {
    public long dividePlayers(int[] skill) {
          Arrays.sort(skill);
        int l = 0, r = skill.length - 1;
        long ans = 0;
        long set = skill[l] + skill[r];
        while ( l < r ){
            long diff = skill[l] + skill[r];
            ans += skill[l] * skill[r];
            l++; r--;
            if ( set != diff ) return -1;
        }
        return ans;
    }
}