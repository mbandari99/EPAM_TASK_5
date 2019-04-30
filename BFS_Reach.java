import java.util.*;

public class BFS_Reach {
    public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj, int s) {
        LinkedList<Integer> q = new LinkedList<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>(adj.size());
        for (int i = 0; i < adj.size(); i++) {
            result.add(0);
        }
        q.addFirst(s);

        while (q.size() > 0) {
            int current = q.pollLast();
            ArrayList<Integer> tmp = adj.get(current);
            for (int i = 0; i < tmp.size(); i++) {
                int v = tmp.get(i);
                if (result.get(v) == 0) {
                    q.addFirst(v);
                    result.set(v, result.get(current) + 6);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int q = sc.nextInt();
        for(int a0 = 0; a0 < q; a0++){

            int n = sc.nextInt();
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(n);
            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<Integer>());
            }

            int m = sc.nextInt();
            for(int a1 = 0; a1 < m; a1++){
                int u = sc.nextInt() - 1;
                int v = sc.nextInt() - 1;
                
                ArrayList<Integer> tmp = adj.get(u);
                tmp.add(v);
                adj.set(u, tmp);

                tmp = adj.get(v);
                tmp.add(u);
                adj.set(v, tmp);
            }

            int s = sc.nextInt() - 1;

            ArrayList<Integer> result = solution.bfs(adj, s);

            for (int i = 0; i < n; i++) {
                if (i != s) {
                    if (result.get(i) == 0) {
                        System.out.print("-1 ");
                    } else {
                        System.out.print(result.get(i) + " ");
                    }
                }
            }
            System.out.print("\n");
        }
        sc.close();
    }
}