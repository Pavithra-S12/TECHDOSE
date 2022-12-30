class Solution {
	List<Integer> postorder = new ArrayList<>();
	boolean hasCycle = false;
	boolean[] visited, onPath;

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		List<Integer>[] graph = buildGraph(numCourses, prerequisites);
		visited = new boolean[numCourses];
		onPath = new boolean[numCourses];
		for (int i=0; i<numCourses; i++)
		{
			traverse(graph, i);
		}
		if (hasCycle)
		{
			return new int[]{};
		}

		Collections.reverse(postorder);
		int[] res = new int[numCourses];
		for (int i=0; i<numCourses; i++)
		{
			res[i] = postorder.get(i);
		}
		return res;
	}


	void traverse(List<Integer>[] graph, int s)
	{

		if (onPath[s])
		{
			hasCycle=true;
		}

		if (visited[s] || hasCycle)
		{
			return;
		}

		onPath[s]=true;
		visited[s]=true;
		for(int t: graph[s])
		{
			traverse(graph, t);
		}

		postorder.add(s);
		onPath[s]=false;
	}

	List<Integer>[] buildGraph(int numCourses, int[][] prerequisites)
	{
		List<Integer>[] graph = new LinkedList[numCourses];
		for (int i=0; i<numCourses; i++)
		{
			graph[i]=new LinkedList<>();
		}
		for (int[] edge : prerequisites)
		{
			int from=edge[1], to=edge[0];
			graph[from].add(to);
		}
		return graph;

	}

}
