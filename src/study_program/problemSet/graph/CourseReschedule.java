package study_program.problemSet.graph;

import java.util.*;

public class CourseReschedule {
    public static void main(String[] args) {

//        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(1, 0));
//        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(2, 0));
//        ArrayList<Integer> arr3 = new ArrayList<>(Arrays.asList(3, 1));
//        ArrayList<Integer> arr4 = new ArrayList<>(Arrays.asList(3, 2));
//
//        ArrayList<ArrayList<Integer>> prerequisites = new ArrayList<>();
//        prerequisites.add(arr1);
//        prerequisites.add(arr2);
//        prerequisites.add(arr3);
//        prerequisites.add(arr4);

//        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(0, 1));
//
//        ArrayList<ArrayList<Integer>> prerequisites = new ArrayList<>();
//        prerequisites.add(arr1);

        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(0, 1));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(1, 0));

        ArrayList<ArrayList<Integer>> prerequisites = new ArrayList<>();
        prerequisites.add(arr1);
        prerequisites.add(arr2);

        int n = 2;

        ArrayList<Integer> result =  course_schedule(n, prerequisites);

        int a;
    }

    static ArrayList<Integer> course_schedule(Integer n, ArrayList<ArrayList<Integer>> prerequisites) {

        Map<Integer, ArrayList<Integer>> course_and_prerequisites = new HashMap<>();
        Map<Integer, ArrayList<Integer>> course_and_new_opportunities = new HashMap<>();

        for(int i = 0; i < prerequisites.size(); i++){
            int currCourse = prerequisites.get(i).get(0);
            if(course_and_prerequisites.containsKey(currCourse)){
                ArrayList<Integer> curr_prerequisites = course_and_prerequisites.get(currCourse);
                curr_prerequisites.add(prerequisites.get(i).get(1));

            }else{
                ArrayList<Integer> new_prerequisites = new ArrayList<>();
                new_prerequisites.add(prerequisites.get(i).get(1));
                course_and_prerequisites.put(currCourse, new_prerequisites);
            }
        }

        for(int i = 0; i < prerequisites.size(); i++){
            int currCourse = prerequisites.get(i).get(1);
            if(course_and_new_opportunities.containsKey(currCourse)){
                ArrayList<Integer> curr_prerequisites = course_and_new_opportunities.get(currCourse);
                curr_prerequisites.add(prerequisites.get(i).get(0));

            }else{
                ArrayList<Integer> new_prerequisites = new ArrayList<>();
                new_prerequisites.add(prerequisites.get(i).get(0));
                course_and_new_opportunities.put(currCourse, new_prerequisites);
            }
        }

        Set<Integer> visitedLectures = new HashSet<>();
        int curr_course = 0;

        ArrayList<Integer> result = new ArrayList<>();

        while(curr_course < n){
            if(!visitedLectures.contains(curr_course)){
                get_all_new_opportunities(visitedLectures, result, curr_course, course_and_prerequisites,
                        course_and_new_opportunities);
            }
            curr_course++;
        }

        int visited_checker_counter = 0;

        while(visited_checker_counter < n){
            if(!visitedLectures.contains(visited_checker_counter)){
                result = new ArrayList<>();
                result.add(-1);
                return result;
            }
            visited_checker_counter++;
        }

        if(result.isEmpty())
            result.add(-1);

        return result;
    }

    static void get_all_new_opportunities(Set<Integer> visitedLectures, ArrayList<Integer> result, int curr_course,
                                          Map<Integer, ArrayList<Integer>> course_and_prerequisites,
                                          Map<Integer, ArrayList<Integer>> course_and_new_opportunities){
        if(visitedLectures.contains(curr_course)){
            return;
        }

        // is it possible to add this course
        ArrayList<Integer> prerequisites = course_and_prerequisites.get(curr_course);

        if(prerequisites != null) {
            for (int j = 0; j < prerequisites.size(); j++) {
                if (!visitedLectures.contains(prerequisites.get(j))) {
                    return;
                }
            }
        }

        visitedLectures.add(curr_course);
        result.add(curr_course);

        if(course_and_new_opportunities.containsKey(curr_course)){
            ArrayList<Integer> new_opportunities = course_and_new_opportunities.get(curr_course);

            for(int i = 0; i < new_opportunities.size(); i++){
                int the_new_opportunity = new_opportunities.get(i);
                get_all_new_opportunities(visitedLectures, result, the_new_opportunity, course_and_prerequisites,
                            course_and_new_opportunities);
            }
        }
    }
}
