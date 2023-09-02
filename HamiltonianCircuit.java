import java.util.*;

public class HamiltonianCircuit {

    private int[][] adjMatrix;
    private int nVertices;
    private boolean[] visited;
    private int[] path;

    public HamiltonianCircuit(int[][] adjMatrix) {
        this.adjMatrix = adjMatrix;
        this.nVertices = adjMatrix.length;
        this.visited = new boolean[nVertices];
        this.path = new int[nVertices];
    }

    public boolean hamiltonianCircuit(int vertex) {
        if (vertex == nVertices - 1) {
            if (adjMatrix[vertex][0] == 1) {
                path[nVertices - 1] = 0;
                return true;
            } else {
                return false;
            }
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the next vertex: ");
        int nextVertex = scanner.nextInt();

        visited[vertex] = true;
        for (int i = 0; i < nVertices; i++) {
            if (!visited[i] && adjMatrix[vertex][i] == 1 && i == nextVertex) {
                path[vertex] = i;
                if (hamiltonianCircuit(i)) {
                    return true;
                }
            }
        }

        visited[vertex] = false;
        return false;
    }

    public void printHamiltonianCircuit() {
        if (path[0] == 0) {
            System.out.println("Hamiltonian circuit exists");
            for (int i = 0; i < nVertices; i++) {
                System.out.print(path[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("Hamiltonian circuit does not exist");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of vertices: ");
        int nVertices = scanner.nextInt();

        adjMatrix = new int[nVertices][nVertices];
        for (int i = 0; i < nVertices; i++) {
            for (int j = 0; j < nVertices; j++) {
                //System.out.println("Enter the edge weight between " + i + " and " + j + ": ");
                adjMatrix[i][j] = scanner.nextInt();
            }
        }

        HamiltonianCircuit hc = new HamiltonianCircuit(adjMatrix);
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Enter the starting vertex: ");
        int startVertex = scanner2.nextInt();
        if (hc.hamiltonianCircuit(startVertex)) {
            hc.printHamiltonianCircuit();
        } else {
            System.out.println("Hamiltonian circuit does not exist");
        }
    }
}
