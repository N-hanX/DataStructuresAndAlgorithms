package graph;

import java.util.*;

public class FriendlyGroups {
    public static void main(String[] args) {
        ArrayList<Integer> dislike1 = new ArrayList<>(Arrays.asList(0, 0, 0, 1, 2));
        ArrayList<Integer> dislike2 = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 3));

//        ArrayList<Integer> dislike1 = new ArrayList<>(Arrays.asList(0, 1, 1, 2, 3));
//        ArrayList<Integer> dislike2 = new ArrayList<>(Arrays.asList(2, 2, 4, 3, 4));

//        ArrayList<Integer> dislike1 = new ArrayList<>(Arrays.asList(6, 6, 4, 4, 0));
//        ArrayList<Integer> dislike2 = new ArrayList<>(Arrays.asList(5, 3, 3, 5, 5));

        Integer num_of_people = 4;

        Boolean result = can_be_divided(num_of_people, dislike1, dislike2);

        int a = 5;
    }

    static Boolean result = true;
    static Boolean can_be_divided(Integer num_of_people, ArrayList<Integer> dislike1, ArrayList<Integer> dislike2) {

        Map<Integer, ArrayList<Integer>> dislikeSet = new HashMap<>();

        for(int i = 0; i < dislike1.size(); i++){
            if(dislikeSet.containsKey(dislike1.get(i))){
                ArrayList<Integer> likeList = dislikeSet.get(dislike1.get(i));
                likeList.add(dislike2.get(i));
            }else{
                ArrayList<Integer> likeList = new ArrayList<>();
                likeList.add(dislike2.get(i));
                dislikeSet.put(dislike1.get(i), likeList);
            }

            if(dislikeSet.containsKey(dislike2.get(i))){
                ArrayList<Integer> likeList = dislikeSet.get(dislike2.get(i));
                likeList.add(dislike1.get(i));
            }else{
                ArrayList<Integer> likeList = new ArrayList<>();
                likeList.add(dislike1.get(i));
                dislikeSet.put(dislike2.get(i), likeList);
            }
        }

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        int key; // set1 0,set2 1

        for(int i = 0; i < dislike1.size(); i++){
            int friendNo = dislike1.get(i);
            if(set1.contains(friendNo)){
                continue;
            }
            if(set2.contains(friendNo)){
                continue;
            }
            set1.add(friendNo);
            key = 2;

            traverseDislikes(dislikeSet, friendNo, set1, set2, key);
        }

        return result;
    }

    static void traverseDislikes(Map<Integer, ArrayList<Integer>> dislikeSet, int friendNo, Set<Integer> set1,
                                 Set<Integer> set2, int key ){
        if(!dislikeSet.containsKey(friendNo))
            return;

        // if key == 1 curr person belongs the group set1, curr person belongs the group key == 2, set2

        ArrayList<Integer> dislikes = dislikeSet.get(friendNo);
        for(int j = 0; j < dislikes.size(); j++){
            int theOpposite = dislikes.get(j);

            if(key == 2){
                if(set1.contains(theOpposite)){
                    result = false;
                    return;
                }

                if(set2.contains(theOpposite)){
                    continue;
                } else{
                    set2.add(theOpposite);
                }

                traverseDislikes(dislikeSet, theOpposite, set1, set2, 1);
                continue;
            }

            if(key == 1){
                if(set2.contains(theOpposite)){
                    result = false;
                    return;
                }

                if(set1.contains(theOpposite)){
                    continue;
                } else{
                    set1.add(theOpposite);
                }
                traverseDislikes(dislikeSet, theOpposite, set1, set2, 2);
                continue;
            }
        }
        return;
    }
}