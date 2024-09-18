class Solution {
    public String largestNumber(int[] num) {
        String res = Arrays.stream(num)
            .mapToObj(String::valueOf)
            .sorted((a, b) -> (b + a).compareTo(a + b))
            .collect(Collectors.joining(""));
    return res.startsWith("00") ? "0" : res;
    }
}