class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        //return solveRec(sx,sy,fx,fy,t);
        int xDist = Math.abs(sx-fx);
        int yDist =Math.abs(sy-fy);

        int minDist =Math.min(xDist,yDist) +Math.abs(yDist-xDist);

        if(minDist==0){
            return t!=1;
        }
        return t>=minDist;
        
    }
    public static boolean solveRec(int x,int y,int fx,int fy,int t){
        //Base Case ::
        if(x==fx && y==fy && t>=0){
            return true;
        }
        if(x==fx || y==fy || t==0){
            return false;
        }
        if(isPossible(x+1,y+1,fx,fy)){
            return solveRec(x+1,y+1,fx,fy,t-1);
        }else if(isPossible(x+1,y,fx,fy)){
            return solveRec(x+1,y,fx,fy,t-1);
        }else if(isPossible(x,y+1,fx,fy)){
            return solveRec(x,y+1,fx,fy,t-1);
        }else if(isPossible(x-1,y+1,fx,fy)){
            return solveRec(x-1,y+1,fx,fy,t-1);
        }else if(isPossible(x-1,y,fx,fy)){
            return solveRec(x-1,y,fx,fy,t-1);
        }else if(isPossible(x-1,y-1,fx,fy)){
            return solveRec(x-1,y-1,fx,fy,t-1);
        }else if(isPossible(x,y-1,fx,fy)){
            return solveRec(x,y-1,fx,fy,t-1);
        }else if(isPossible(x+1,y-1,fx,fy)){
            return solveRec(x+1,y-1,fx,fy,t-1);
        } 
        return false;
    }
    public static boolean isPossible(int x,int y,int fx,int fy){
        if((x>=1 && x<fx) &&(y>=1 && y<fy)) return true;
        return false;
    }
}