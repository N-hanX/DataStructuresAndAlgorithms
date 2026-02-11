package study4_a;

public class TaskScheduler_621 {
    static void main() {
        // TEST 1
//        char[] tasks = new char[]{'A','A','A','B','B','B'};
//        int n = 2;
//        int result = leastInterval(tasks, n);

//        // TEST 2
//        char[] tasks = new char[]{'A','C','A','B','D','B'};
//        int n = 1;
//        int result = leastInterval(tasks, n);

//
//        // TEST 3
        char[] tasks = new char[]{'A','A','A','B','B','B'};
        int n = 3;
        int result = leastInterval(tasks, n);

        int a = 4;

    }
    public static int leastInterval(char[] tasks, int n) {
        // the solution is based on the number of task with max frequency considering intervals
        // and the number of tasks
        // and the num of tasks with max frequency

        int maxFrequency = 0;
        int[] charFreq = new int[26];

        for(int i = 0; i < tasks.length; i++){
            charFreq[tasks[i]-'A']++;
            if(maxFrequency < charFreq[tasks[i]-'A']){
                maxFrequency = charFreq[tasks[i]-'A'];
            }
        }

        int numOfTaskWithMaxFreq = 0;
        int totalNumOfTasks = 0;

        for(int i = 0; i < 26; i++){
            if(charFreq[i] == maxFrequency){
                numOfTaskWithMaxFreq++;
            }
            totalNumOfTasks += charFreq[i];
        }

        return Math.max(totalNumOfTasks, ((maxFrequency - 1) * (n + 1)) + numOfTaskWithMaxFreq);
    }
}
