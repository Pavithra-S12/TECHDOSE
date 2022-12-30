class Solution {
    public Node cloneGraph(Node node) {
        Map<Integer, Node> map = new HashMap<>();
        return create(node, map);
    }

    public Node create(Node node, Map<Integer, Node> map){
        if(node == null)
        return null;
        Node newNode = new Node(node.val, new ArrayList<Node>());
        map.put(newNode.val, newNode);
        for (Node nextNode : node.neighbors){
            if (map.containsKey(nextNode.val))
                newNode.neighbors.add(map.get(nextNode.val));
            else{
                Node cnode = create(nextNode, map);
                newNode.neighbors.add(cnode);
            }
        }
        return newNode;
    }
}
