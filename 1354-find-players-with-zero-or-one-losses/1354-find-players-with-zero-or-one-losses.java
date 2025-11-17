class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer,Integer> map1=new HashMap<>();
        Map<Integer,Integer> map2=new HashMap<>();
        List<Integer> zeroloss=new ArrayList<>();
        List<Integer> oneloss=new ArrayList<>();
        List<List<Integer>> result=new ArrayList<>();
        for(int[] winners:matches){
            int key=winners[0];
            map1.put(key,map1.getOrDefault(key,0)+1);
        }
        for(int[] losers:matches){
            int key=losers[1];
            map2.put(key,map2.getOrDefault(key,0)+1);
        }
        for(int key:map1.keySet()){
        if(!map2.containsKey(key)){
            zeroloss.add(key);
        }
        }
        for(int key:map2.keySet()){
            if(map2.get(key)==1){
                oneloss.add(key);
            }
        }
    Collections.sort(zeroloss);
    Collections.sort(oneloss);
    result.add(zeroloss);
    result.add(oneloss);
    return result;
    }
}