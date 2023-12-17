class FoodRatings {
    Map<String,node1>FtoC; //food to cuisine and rating;
    Map<String,TreeSet<node>>food; //CtoF
    int n1;
    int n2;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        n1=foods.length;
        n2=cuisines.length;

        FtoC=new HashMap<>();
        for(int i=0;i<n1;++i){
            FtoC.put(foods[i],new node1(cuisines[i],ratings[i]));
        }

        food=new HashMap<>();
        for(int i=0;i<n1;++i){
            food.computeIfAbsent(cuisines[i],k->new TreeSet<>(new com())).add(new node(foods[i],ratings[i]));
        }
    }

    public void changeRating(String food, int newRating) {
        node1 k=FtoC.get(food);
        String cuis=k.cuis;
        int rating=k.rat;
        this.food.get(cuis).remove(new node(food,rating));
        this.food.get(cuis).add(new node(food,newRating));
        k.rat=newRating;
    }

    public String highestRated(String cuisine) {
        return food.get(cuisine).first().f;
    }

    private static class node{
        String f;
        int rat;

        node(String f,int rat){
            this.f=f;
            this.rat=rat;
        }
    }

    private static class node1{
        String cuis;
        int rat;

        node1(String cuis,int rat){
            this.cuis=cuis;
            this.rat=rat;
        }
    }

    private class com implements Comparator<node>{

        @Override
        public int compare(node o1, node o2) {
            if(o1.rat==o2.rat)
                return o1.f.compareTo(o2.f);

            return o2.rat-o1.rat;
        }
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */