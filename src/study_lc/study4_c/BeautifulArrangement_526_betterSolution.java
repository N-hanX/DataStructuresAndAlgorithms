package study_lc.study4_c;

public class BeautifulArrangement_526_betterSolution {
    public static void main(String[] args) {
        int N = 11;

        countArrangement(N);
        int a = 4;
    }

    // not my solution. leetcode solution.
    static int count;
    public static int countArrangement(int N) {
        count = 0;
        boolean[] visited = new boolean[N + 1];
        countArrangement(N, 1, visited);
        return count;
    }

    public static void countArrangement(int N, int pos, boolean[] visited) {
        if(pos > N){
            count++;
        }
        for(int i = 1; i <= N; i++){
            if (!visited[i] && (pos % i == 0 || i % pos == 0)) {
                visited[i] = true;
                countArrangement(N, pos + 1, visited);
                visited[i] = false;
            }
        }
    }
}
