class RandomizedSet {
    Map<Integer,Integer> map;
    List<Integer> list;
    Random rand;
    public RandomizedSet() {
        map=new HashMap<>();
        list=new ArrayList<>();
        rand=new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        int idx=list.size();
        map.put(val,idx);
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int idx=map.get(val);
        int lastidx=list.size()-1;
        int lastele=list.get(list.size()-1);
        list.set(idx,lastele);
        list.remove(list.size()-1);
        map.remove(val);
        if(idx!=lastidx){
        map.put(lastele,idx);
        }
        return true;

    }
    
    public int getRandom() {
        int idx=rand.nextInt(list.size());
        return list.get(idx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */