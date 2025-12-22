package study4_x;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TweetCountsPerFreq_1348 {
    public static void main(String[] args) {
        TweetCounts tweetCounts = new TweetCounts();
        tweetCounts.recordTweet("tweet3", 10);
        tweetCounts.recordTweet("tweet3", 20);
        tweetCounts.recordTweet("tweet3", 70);
        List<Integer> result = tweetCounts.getTweetCoutnsPerFrequency("minute", "tweet3", 0, 120);
        int a = 5;
    }

    // not my solution. it is for practice
    static class TweetCounts{
        private Map<String, List<Integer>> tweetMap;

        public TweetCounts(){
            tweetMap = new HashMap<>();
        }

        public void recordTweet(String tweetName, int time){
            if(!tweetMap.containsKey(tweetName)){
                tweetMap.put(tweetName, new ArrayList<>());
            }
            tweetMap.get(tweetName).add(time);
        }

        public List<Integer> getTweetCoutnsPerFrequency(String freq, String tweetName, int startTime, int endTime){
            List<Integer> result = new ArrayList<>();

            int interval = 60;
            if(freq.equals("hour")){
                interval = 3600;
            }else if(freq.equals("day")){
                interval = 86400;
            }

            // num of intervals needed
            int buckets = (endTime - startTime) / interval + 1;
            int[] counts = new int[buckets];

            List<Integer> times = tweetMap.get(tweetName);
            if(times != null){
                for(int time : times){
                    if(time >= startTime && time <= endTime){
                        int index = (time - startTime) / interval;
                        counts[index]++;
                    }
                }
            }

            for(int count:counts){
                result.add(count);
            }
            return result;
        }
    }
}
