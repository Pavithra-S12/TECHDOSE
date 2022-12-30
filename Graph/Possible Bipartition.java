class Solution {
    static final int UNASSIGNED = 0;
    static final int GROUP_A = 1;
    static final int GROUP_B = 2;
    public boolean possibleBipartition(int n, int[][] dislikes) {
        //create dislike lists for each person from edges
        List<Integer>[] graph = new List[n];
        for(int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();
        for(int[] dislike: dislikes) {
            graph[dislike[0] - 1].add(dislike[1] - 1);
            graph[dislike[1] - 1].add(dislike[0] - 1);
        }
        //create array containing group assignment for each person
        int[] groups = new int[n];
        //for every person who is not assigned to a group
        for(int i = 0; i < n; i++) if(groups[i] == UNASSIGNED) {
            //put that person in group a
            groups[i] = GROUP_A;
            //recursively attempt to sort people into groups
            if(!canMerge(graph, groups, i))
                return false;
        }
        //all people were sorted into groups without issue
        return true;
    }
    
    //attempt to put all dislikes of person into the enemy group
    boolean canMerge(List<Integer>[] graph, int[] groups, int person) {
        int group = groups[person];
        int enemyGroup = group == GROUP_A? GROUP_B: GROUP_A;
        //for every enemy of the person
        for(Integer enemy: graph[person]) {
            //if the enemy is already in the same group, then there is no way
            //to partition the people into two groups
            if(groups[enemy] == group)
                return false;
            //if the enemy is unassigned, add them to the enemy group
            if(groups[enemy] == UNASSIGNED) {
                groups[enemy] = enemyGroup;
                //check if enemy can partition.
                if(!canMerge(graph, groups, enemy))
                    return false;
            }
        }
        //all enemies like each other
        return true;
    }
}
