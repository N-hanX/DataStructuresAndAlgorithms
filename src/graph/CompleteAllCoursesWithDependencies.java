package graph;

import java.util.*;

public class CompleteAllCoursesWithDependencies {
    public static void main(String[] args) {
//        ArrayList<Integer> prereqs = new ArrayList<>(Arrays.asList(1, 1, 3));
//        ArrayList<Integer> lectures = new ArrayList<>(Arrays.asList(0, 2, 1));

//        ArrayList<Integer> prereqs = new ArrayList<>(Arrays.asList(1, 1, 3, 0));
//        ArrayList<Integer> lectures = new ArrayList<>(Arrays.asList(0, 2, 1, 3));
        ArrayList<Integer> prereqs = new ArrayList<>(Arrays.asList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1));
        ArrayList<Integer> lectures = new ArrayList<>(Arrays.asList(9, 8, 7, 6, 5, 4, 3, 2, 1, 0));
//
//        ArrayList<Integer> prereqs = new ArrayList<>(Arrays.asList(0, 0, 1, 4, 4));
//        ArrayList<Integer> lectures = new ArrayList<>(Arrays.asList(1, 2, 2, 0, 1));
        int n = 11;

        Boolean result = can_be_completed(n, prereqs, lectures);

        int a = 4;
    }

    static Boolean result = true;

    static Boolean can_be_completed(Integer n, ArrayList<Integer> a, ArrayList<Integer> b) {

        Map<Integer, ArrayList<Integer>> lectureMap = new HashMap<>();
        Set<Integer> allLectures= new HashSet<>();

        for(int i = 0; i < a.size(); i++){
            if(lectureMap.containsKey(a.get(i))) {
                ArrayList<Integer> dependencies = lectureMap.get(a.get(i));
                dependencies.add(b.get(i));
            }else{
                ArrayList<Integer> dependencies = new ArrayList<>();
                dependencies.add(b.get(i));
                lectureMap.put(a.get(i), dependencies);
            }
            allLectures.add(a.get(i));
            allLectures.add(b.get(i));
        }

        int count = 0;
        Set<Integer> visited = new HashSet<>();
        while(count < n){
            if(visited.contains(count)){
                count++;
                continue;
            }

            Set<Integer> setOfLectures = new HashSet<>();
            isAcyclic(lectureMap, count, setOfLectures, visited);
            if(result == false){
                return false;
            }
            count++;
        }

        return result;
    }

    static void isAcyclic(Map<Integer, ArrayList<Integer>> lectureMap, int currLecture, Set<Integer> setOfLectures,
                          Set<Integer> visited){
        if (setOfLectures.contains(currLecture)) {
            result = false;
            return;
        }

        if(visited.contains(currLecture))
            return;

        setOfLectures.add(currLecture);

        visited.add(currLecture);

        if(!lectureMap.containsKey(currLecture)){
            setOfLectures.remove(currLecture);
            return;
        }
        ArrayList<Integer> dependencies = lectureMap.get(currLecture);

        for(int i = 0; i < dependencies.size(); i++){
            isAcyclic(lectureMap, dependencies.get(i), setOfLectures, visited);
        }
        setOfLectures.remove(currLecture);
    }
}
