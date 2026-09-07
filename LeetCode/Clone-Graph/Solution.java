1/*
2// Definition for a Node.
3class Node {
4    public int val;
5    public List<Node> neighbors;
6    public Node() {
7        val = 0;
8        neighbors = new ArrayList<Node>();
9    }
10    public Node(int _val) {
11        val = _val;
12        neighbors = new ArrayList<Node>();
13    }
14    public Node(int _val, ArrayList<Node> _neighbors) {
15        val = _val;
16        neighbors = _neighbors;
17    }
18}
19*/
20
21class Solution {
22    public Node cloneGraph(Node node) {
23        if(node==null)return null;
24        Queue<Node> q=new LinkedList<>();
25        Map<Node,Node> map=new HashMap<>();
26        Node clone=new Node(node.val);
27        map.put(node,clone);
28        q.add(node);
29        while(q.size()>0){
30            Node curr=q.remove();
31            for(Node neighbour:curr.neighbors){
32                if(!map.containsKey(neighbour)){
33                    Node newNode=new Node(neighbour.val);
34                    map.put(neighbour,newNode);
35                    q.add(neighbour);
36                }
37                map.get(curr).neighbors.add(map.get(neighbour));
38            }
39        }
40        return clone;
41    }
42}