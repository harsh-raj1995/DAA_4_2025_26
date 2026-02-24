// User function Template for Java
class kruskal {
    static class mst {
        int[] p, r;
        mst(int n) {
            p = new int[n];
            r = new int[n];
            for (int i = 0; i < n; i++)
                p[i] = i;
        }
        int f(int x) {
            if (p[x] != x)
                p[x] = f(p[x]);  
            return p[x];
        }
        void u(int x, int y) {
            int px = f(x);
            int py = f(y);
            if (px == py) return;
            if (r[px] < r[py])
                p[px] = py;
            else if (r[px] > r[py])
                p[py] = px;
            else {
                p[py] = px;
                r[px]++;
            }
        }
    }
    static int kruskalsMST(int V, int[][] edges) {
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);  
        mst t = new mst(V);
        int s = 0;
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            if (t.f(u) != t.f(v)) {
                s += w;
                t.u(u, v);
            }
        }

        return s;
    }
}