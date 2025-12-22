package study4_x;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ProcessTasksUsingServers_1882 {
    // practicing a solution, not my solution

    public static void main(String[] args) {
//        int[] servers = new int[]{3,3,2};
//        int[] tasks = new int[]{1, 2, 3, 2, 1, 2};

        //  servers = [5,1,4,3,2], tasks = [2,1,2,4,5,2,1]
        int[] servers = new int[]{5,1,4,3,2};
        int[] tasks = new int[]{2,1,2,4,5,2,1};

        int[] result = assignTasks(servers, tasks);
        int a = 4;
    }

    public static int[] assignTasks(int[] servers, int[] tasks){
        int n = servers.length;
        int m = tasks.length;
        int[] result = new int[m];

        // pq for free servers (by weight, then index)
        PriorityQueue<int[]> free = new PriorityQueue<>(
            new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]) return o1[0] - o2[0]; //by weight
                return o1[1] - o2[1];
            }
        });

        // pq for busy servers(by time, then weight, then index)
        PriorityQueue<int[]> busy = new PriorityQueue<>(
                new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        if(o1[0] != - o2[0]) return o1[0] - o2[0]; // by free time
                        if(o1[1] != o2[1]) return o1[1] - o2[1]; // by weight
                        return o1[2] - o2[2]; // by index
                    }
                }
        );

        // initialize free servers queue
        for(int i = 0; i < n; i++){
            free.offer(new int[]{servers[i],i});
        }

        int time = 0;
        for(int i = 0; i < m; i++){
            time = Math.max(time, i); // move time forward if needed

            // free up busy servers that finished their task
            while(!busy.isEmpty() && busy.peek()[0] <= time){
                int[] server = busy.poll();
                free.offer(new int[]{server[1], server[2]});
            }

            // if no free servers, fast forward time to next available
            if(free.isEmpty()){
                time = busy.peek()[0];
                while(!busy.isEmpty() && busy.peek()[0] <= time){
                    int[]server = busy.poll();
                    free.offer(new int[]{server[1], server[2]});
                }
            }

            int[] server = free.poll();
            result[i] = server[1]; // assign this server
            busy.offer(new int[]{time + tasks[i], server[0], server[1]});

        }
        return result;
    }
}
