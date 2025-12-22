package study_program.problemSet.graph;

import java.util.*;

public class ZombieClusters {
    public static void main(String[] args) {
        ArrayList<String> zombies = new ArrayList<>(Arrays.asList("1100", "1110","0110","0001"));
        Integer result = zombie_cluster(zombies);
        int a;

    }

    static Integer zombie_cluster(ArrayList<String> zombies) {
        int total_num_of_zombies = zombies.size();
        Map<Integer, ArrayList<Integer>> zombieMap = new HashMap();

        for(int i = 0; i < total_num_of_zombies; i++){
            ArrayList<Integer> zombieFriends = new ArrayList<>();
            zombieMap.put(i, zombieFriends);
        }

        // create zombie map
        for(int i = 0; i < total_num_of_zombies; i++){
            for(int j = 0; j < total_num_of_zombies; j++){
                if(i != j){
                    if(zombies.get(i).charAt(j) == '1'){
                        ArrayList<Integer> zombieFriends = zombieMap.get(i);
                        zombieFriends.add(j);
                    }
                }
            }
        }

        Set<Integer> visitedZombie = new HashSet<>();

        int count_zombie_cluster = 0;
        int zombie_counter = 0;

        while(zombie_counter < total_num_of_zombies){
            if(!visitedZombie.contains(zombie_counter)){
                count_zombie_cluster++;
                findZombieFriends(visitedZombie, zombieMap, zombie_counter);
            }
            zombie_counter++;
        }

        return count_zombie_cluster;
    }

    static void findZombieFriends(Set<Integer> visitedZombies, Map<Integer, ArrayList<Integer>> zombieMap,
                                    int currZombie){
        if(visitedZombies.contains(currZombie)){
            return;
        }

        visitedZombies.add(currZombie);
        ArrayList<Integer> friends_of_curr_zombie = zombieMap.get(currZombie);

        for(int i = 0; i < friends_of_curr_zombie.size(); i++){
            findZombieFriends(visitedZombies, zombieMap, friends_of_curr_zombie.get(i));
        }
    }
}
