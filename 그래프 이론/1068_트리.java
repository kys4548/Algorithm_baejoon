import java.io.*;
import java.util.*;

class Main {
	static int answer;
	static Node root;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Map<Integer, Node> map1 = new HashMap<Integer, Node>();
		Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		Node parent = null;
		
		for(int i=0; i<n; i++) {
			map1.put(i,new Node());
			map2.put(i, Integer.parseInt(st.nextToken()));
		}
		
		int remove = Integer.parseInt(br.readLine());
		map2.put(remove, -2);
		
		for(int i=0; i<n; i++) {
			int p = map2.get(i);
			if(p == -1) {
				root = map1.get(i);
			} else if(p != -2) {
				parent = map1.get(p);
				parent.addChild(map1.get(i));
			}
		}
		if(root == null ){
			System.out.println(0);
			return;
		}
		solve(root);
		System.out.println(answer);
		
	}
	
	public static void solve(Node node) {
		if(node.isEmptyChild()) {
			answer++;
			return;
		}
		
		List<Node> list = node.getChild();
		for(Node n : list) {
			solve(n);
		}
	}
}

class Node {
	private List<Node> list;
	
	Node() {
		list = new ArrayList<Node>();
	}
	
	public void addChild(Node node) {
		list.add(node);
	}
	
	public boolean isEmptyChild() {
		return list.isEmpty();
	}
	
	public List<Node> getChild() {
		return list;
	}
}