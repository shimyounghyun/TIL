class Solution {
    Map<Integer, Node> map = new HashMap<>();
    
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Node n = new Node(node.val);
        map.put(n.val, n);
        for (Node nei : node.neighbors){
            if (nei == null){
                System.out.println(node.val);
            }
            if (!map.containsKey(nei.val)) cloneGraph(nei);
            n.neighbors.add(map.get(nei.val));
        }
        return n;
    }
}
