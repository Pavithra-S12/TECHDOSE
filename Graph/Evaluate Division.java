class Solution {    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result = new double[queries.size()];
        QuickUnion qu = new QuickUnion();
        
        for (int i = 0; i < equations.size(); i++) {
            String e1 = equations.get(i).get(0);
            String e2 = equations.get(i).get(1);
            
            qu.union(e1,e2,values[i]);
        }
        
        for (int i = 0; i < queries.size(); i++) {
            if (!qu.exists(queries.get(i).get(0)) || !qu.exists(queries.get(i).get(1))) {
                result[i] = -1.0;
                continue;
            }
            
            if (!qu.isConnected(queries.get(i).get(0), queries.get(i).get(1))) {
                result[i] = -1.0;
                continue;
            }
            
            result[i] = qu.getDist(queries.get(i).get(0)) / qu.getDist(queries.get(i).get(1));
        }
        
        return result;
    }
}

class QuickUnion {
    Map<String, String> parents = new HashMap<>();
    Map<String, Double> dist = new HashMap<>();
    
    public QuickUnion(){}
    
    public String root(String i) {
        if (!parents.containsKey(i)) {
            parents.put(i,i);
            dist.put(i, 1.0);
            return i;
        }
        
        if (parents.get(i).equals(i)) return i;
        
        String lastP = parents.get(i);
        String p = root(lastP);
        parents.put(i, p);
        dist.put(i, dist.get(i) * dist.get(lastP));
        
        return p;
    }
    
    public void union(String i, String j, double v) {
        String rooti = root(i);
        String rootj = root(j);
        
        parents.put(rooti, rootj);
        dist.put(rooti, dist.get(j)/dist.get(i) * v);
    }
    
    public boolean isConnected(String i, String j) {
        return root(i).equals(root(j));
    }
    
    public boolean exists(String i) {
        return parents.containsKey(i);
    }
    
    public double getDist(String s) {
        return dist.get(s);
    }
}
