package hackerrank;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

import org.junit.Test;

/**
 * https://www.hackerrank.com/challenges/bfsshortreach
 * 
 * @author felipereis
 *
 */
public class BreadthFirstSearchList {
	@Test
	public void testExampleProcessResults() {
		assertEquals("6 6 -1", new BreadthFirstSearchList().processResult(4, new int[][] { { 1, 2 }, { 1, 3 } }, 1));
	}

	@Test
	public void testTwoLegsProcessResults() {
		assertEquals("6 6 12",
				new BreadthFirstSearchList().processResult(4, new int[][] { { 1, 2 }, { 1, 3 }, { 3, 4 } }, 1));
	}

	@Test
	public void testFourLegsProcess() {
		assertEquals("12 18 6 12", new BreadthFirstSearchList().processResult(5,
				new int[][] { { 1, 4 }, { 2, 4 }, { 2, 3 }, { 3, 5 }, { 4, 5 } }, 1));
	}

	@Test
	public void testElevenNodes() {
		assertEquals("18 18 6 12 6 24 6 12 18 12",
				new BreadthFirstSearchList().processResult(11, new int[][] { { 1, 4 }, { 1, 6 }, { 1, 8 }, { 4, 9 },
						{ 9, 3 }, { 9, 10 }, { 10, 7 }, { 7, 2 }, { 8, 11 }, { 8, 5 }, { 11, 2 }, }, 1));
	}

	// @Test
	// public void testBSF() {
	// int[][] adjacencyMatrix = new int[][] { { 0, 0, 0, 1, 0 }, { 0, 0, 1, 1,
	// 0 }, { 0, 1, 0, 0, 1 },
	// { 1, 1, 0, 0, 1 }, { 0, 0, 1, 1, 0 } };
	//
	// System.out.println(new
	// BreadthFirstSearchList().breadthSearch(adjacencyMatrix, 0));
	// }

	@Test
	public void testVeryBigInput() throws FileNotFoundException {

		Scanner scan = new Scanner(new File(this.getClass().getResource("input05.txt").getFile()));

		int q = scan.nextInt();

		for (int i = 0; i < q; i++) {
			int n = scan.nextInt();
			int m = scan.nextInt();

			Set<String> edgesSet = new HashSet<>();

			for (int j = 0; j < m; j++) {
				edgesSet.add(scan.nextInt() + "," + scan.nextInt());
			}

			int uniqueEdges = edgesSet.size();

			System.out.println(String.format("m X unique: %d %d", m, uniqueEdges));

			String[] edgesArray = edgesSet.toArray(new String[uniqueEdges]);

			int[][] edges = new int[uniqueEdges][2];

			for (int j = 0; j < uniqueEdges; j++) {
				String[] parts = edgesArray[j].split(",");
				edges[j] = new int[] { Integer.valueOf(parts[0]), Integer.valueOf(parts[1]) };
			}

			int start = scan.nextInt();

			System.out.println(new BreadthFirstSearchList().processResult(n, edges, start));
		}

		scan.close();
	}

	public String processResult(int n, int[][] edges, int start) {
		List<Item> results = this.solve(n, edges, start - 1);

		results.remove(start - 1);

		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < results.size(); j++) {
			sb.append(results.get(j).steps).append(" ");
		}

		String str = sb.toString();

		return str.substring(0, str.length() - 1);
	}

	public List<Item> solve(int n, int[][] edges, int start) {
		final Map<Integer, List<Integer>> adjacencyMap = this.createAdjacencyMap(n, edges);

		return this.breadthSearch(adjacencyMap, start);
	}

	public Map<Integer, List<Integer>> createAdjacencyMap(int nodeCount, int[][] edges) {
		final Map<Integer, List<Integer>> map = new HashMap<>();

		for (int i = 0; i < edges.length; i++) {
			int[] edge = edges[i];
			if (!map.containsKey(edge[0] - 1)) {
				map.put(edge[0] - 1, new ArrayList<Integer>());
			}
			if (!map.containsKey(edge[1] - 1)) {
				map.put(edge[1] - 1, new ArrayList<Integer>());
			}

			map.get(edge[0] - 1).add(edge[1] - 1);
			map.get(edge[1] - 1).add(edge[0] - 1);
		}

		for (int i = 0; i < nodeCount; i++) {
			if (!map.containsKey(i)) {
				map.put(i, new ArrayList<Integer>());
			}
		}

		// System.out.println(map);

		return map;
	}

	class Item implements Comparable<Item> {
		final int node;
		final int steps;

		public Item(int node, int steps) {
			super();
			this.node = node;
			this.steps = steps;
		}

		public Item(int node) {
			super();
			this.node = node;
			this.steps = 0;
		}

		@Override
		public boolean equals(Object obj) {
			return node == ((Item) obj).node;
		}

		@Override
		public int hashCode() {
			return node;
		}

		@Override
		public String toString() {
			return node + " :: " + steps;
		}

		@Override
		public int compareTo(Item o) {
			return Integer.valueOf(node).compareTo(o.node);
		}
	}

	public List<Item> breadthSearch(Map<Integer, List<Integer>> adjacencyMap, int startNode) {
		Queue<Item> queue = new LinkedList<>();
		List<Item> result = new LinkedList<>();

		queue.add(new Item(startNode, 0));

		System.out.println("\n\n");
		while (!queue.isEmpty()) {
			Item item = queue.poll();

			System.out.println(item);

			if (!result.contains(item) || result.get(result.indexOf(item)).steps > item.steps)
				result.add(item);

			// if (adjacencyMap.containsKey(item.node)) {
			List<Integer> edges = adjacencyMap.get(item.node);

			for (int i = 0; i < edges.size(); i++) {
				int n = edges.get(i);

				Item newItem = new Item(n, item.steps + 6);

				if (!result.contains(new Item(n)) && !queue.contains(newItem)) {
					queue.add(newItem);
				}
			}
			// }
		}

		// Add Items for nodes that were not in the result list
		for (Integer k : adjacencyMap.keySet()) {
			Item item = new Item(k, -1);
			if (!result.contains(item)) {
				result.add(item);
			}
		}

		Collections.sort(result);

		// System.out.println(result);

		return result;
	}
}
