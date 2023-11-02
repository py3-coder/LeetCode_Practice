class Solution {
    public String frequencySort(String s) {
        int[] counter = new int['z' - '0' + 1];
        for (int i = 0; i < s.length(); i++)
            counter[s.charAt(i) - '0']++;

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < counter.length; i++)
            list.add(new int[]{i, counter[i]});

        Collections.sort(list, (a, b) -> b[1] - a[1]);

        StringBuilder sb = new StringBuilder();
        for(int[] element : list){
            char c = (char)('0' + element[0]);
            for (int i = 0; i < element[1]; i++) sb.append(c);
        }
        return sb.toString();

    }
}