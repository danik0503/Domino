import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    static ArrayList<Integer> g [] [] = new ArrayList[7][7];
    static boolean[] visited;
    static int[] ans;
    static int total;

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                g[i][j] = new ArrayList<Integer>();

            }
        }
        int[] count = new int[7];

        for (int i = 0; i < n; i++) {

            int p = in.nextInt();
            int q = in.nextInt();
            g[p][q].add(i + 1);
            g[q][p].add(-i - 1);
            count[p]++;
            count[q]++;
        }
        visited = new boolean[n + 1];
        ans = new int[n + 1];

        int odds = 0;
        int start = 0;

        for (int i = 6; i >= 0; i--) {
            if (count[i] % 2 != 0) {
                start = i;
                odds++;
            }
        }
        if (odds == 2 || odds == 0) {
            while (count[start] == 0) start++;
            dfs(start);
            if (total < n) {
                System.out.println("Нет решения");
                return;
            }
            for (int i = 0; i < n; i++) {
                System.out.print(Math.abs(ans[i]) + " ");
                if (ans[i] > 0) System.out.println("-");

                else System.out.println("+");
            }
        } else {
            System.out.println("Нет решения");
        }
    }
            public static void dfs(int s){
                for(int j = 0; j < 7; j++){
                    for(int p : g[s][j]){
                        if (visited[Math.abs(p)])continue;
                        visited [Math.abs(p)]=true;
                        dfs(j);
                        ans[total++]= p;

                        }
                    }
                }
            }



