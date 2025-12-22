package study4_x;

import java.util.*;

public class DesignTwitter_355 {
    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        System.out.println(twitter.getNewsFeed(1));

        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        System.out.println(twitter.getNewsFeed(1));

        twitter.unfollow(1, 2);
        System.out.println(twitter.getNewsFeed(1));
    }

    // not my solution, coded for practicing
    static class Twitter{
        private static int timestamp = 0;

        private static class Tweet {
            int id;
            int time;

            Tweet(int id, int time){
                this.id = id;
                this.time = time;
            }
        }
        private Twitter(){
            followersMap = new HashMap<>();
            tweetsMap = new HashMap<>();
        }

        private Map<Integer, Set<Integer>> followersMap;
        private Map<Integer, List<Tweet>> tweetsMap;

        public void postTweet(int userId, int tweetId){
            if(!tweetsMap.containsKey(userId)){
                tweetsMap.put(userId, new ArrayList<>());
            }
            tweetsMap.get(userId).add(new Tweet(tweetId, timestamp++));
        }

        public void follow(int followerId, int followeeId){
            if(!followersMap.containsKey(followeeId)){
                followersMap.put(followerId, new HashSet<>());
            }
            followersMap.get(followerId).add(followeeId);
        }

        public void unfollow(int followerId, int followeeId){
            if(followerId == followeeId){
                return; // cant unfollow self
            }
            Set<Integer> followees = followersMap.get(followerId);
            if(followees != null){
                followees.remove(followeeId);
            }
        }

        public List<Integer> getNewsFeed(int userId){
            PriorityQueue<Tweet> pq = new PriorityQueue<>(10, new Comparator<Tweet>() {
                @Override
                public int compare(Tweet o1, Tweet o2) {
                    return o1.time - o2.time;
                }
            });

            Set<Integer> followees = followersMap.getOrDefault(userId, new HashSet<>());
            followees.add(userId); // include self

            for(int followeeId: followees){
                List<Tweet> tweets = tweetsMap.get(followeeId);
                if(tweets != null){
                    for(Tweet tweet: tweets){
                        pq.offer(tweet);
                    }
                }
            }

            List<Integer> feed = new ArrayList<>();
            int count = 0;
            while(!pq.isEmpty() && count < 10){
                feed.add(pq.poll().id);
                count++;
            }
            return feed;
        }
    }



}
