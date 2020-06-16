package entidadePrinciap;


import java.util.*;


public class Dijkstra {
	
    private static final int UNDEFINED = -1;
    private int Vertice[][];

    public Dijkstra(int nV) {
        Vertice = new int[nV][nV];
    }

    
    public void dis(int ver1, int ver2, int dis) {
        Vertice[ver1][ver2] = dis;
        Vertice[ver2][ver1] = dis;
    }

    
    public void remove(int ver1, int ver2) {
        Vertice[ver1][ver2] = 0;
        Vertice[ver2][ver1] = 0;
    }

    
    public int custo(int ver1, int ver2) {
        return Vertice[ver1][ver2];
    }

    public List<Integer> viz(int ver) {
        List<Integer> viz = new ArrayList<>();
        for (int i = 0; i < Vertice[ver].length; i++)
            if (Vertice[ver][i] > 0) {
                viz.add(i);
            }
        return viz;
    }

    public List<Integer> cam(int from, int to) {

        int cust[] = new int[Vertice.length];
        int prev[] = new int[Vertice.length];
        Set<Integer> Nvis = new HashSet<>();

        cust[from] = 0;

        for (int v = 0; v < Vertice.length; v++) {
            if (v != from) {
                cust[v] = Integer.MAX_VALUE;
            }
            prev[v] = UNDEFINED;
            Nvis.add(v);
        }

        while (!Nvis.isEmpty()) {
            int perto = Mperto(cust, Nvis);
            Nvis.remove(perto);

            for (Integer viz : viz(perto)) {
                int totalCust = cust[perto] + custo(perto, viz);
                if (totalCust < cust[viz]) {
                    cust[viz] = totalCust;
                    prev[viz] = perto;
                }
            }

            if (perto == to) {
                return FazerCam(prev, perto);
            }
        }

        return Collections.emptyList();
    }

    private int Mperto(int[] dist, Set<Integer> Nvisitado) {
        double minDist = Integer.MAX_VALUE;
        int minIndex = 0;
        for (Integer i : Nvisitado) {
            if (dist[i] < minDist) {
                minDist = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    private List<Integer> FazerCam(int[] prev, int u) {
        List<Integer> cam = new ArrayList<>();
        cam.add(u);
        while (prev[u] != UNDEFINED) {
            cam.add(prev[u]);
            u = prev[u];
        }
        Collections.reverse(cam);
        return cam;
    }
}