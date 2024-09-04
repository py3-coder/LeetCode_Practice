class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0, y = 0, j = 0, result = 0;
		int d[][] = {{0,1},{1,0},{0,-1},{-1,0}};
        
        Set<String> ops = new HashSet<>();
        
        for(int[] op : obstacles) {
            ops.add(op[0] + " " + op[1]);
        }
        
        for(int i=0; i<commands.length; i++) {
            if(commands[i]==-1) {// right
               j = (j+1)%4;
            }else if(commands[i]==-2) {// left
                j = (j+3)%4;
            }else {
                while(commands[i]-- >0 && !ops.contains((x+d[j][0])+ " " +(y+d[j][1]))) {
                    x += d[j][0];
                    y += d[j][1];
                }
            }
            result = Math.max(result, x*x + y*y);
        }
        return result;
    }
}