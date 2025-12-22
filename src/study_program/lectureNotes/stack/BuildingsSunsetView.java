package study_program.lectureNotes.stack;

import java.util.Stack;

public class BuildingsSunsetView {
    public static void main(String[] args) {
//        You are given with a series of buildings that have windows facing west.
//        The buildings are in a straight line,
//        and any building which is to the east of a building of equal or greater height cannot view the sunset.
//        Design an algorithm that processes buildings in east-to-west order and returns the set of buildings
//        which view the sunset. Each building is specified by its height.

        int[] buildings = new int[]{6, 5, 4, 3, 4, 6, 4, 3};
        int[] result = buildingsViewingBuildings(buildings);
        int a = 4;
    }

    public static int[] buildingsViewingBuildings(int[] buildings){
        Stack<Integer> buildingStack = new Stack<>();

        for(int i = 0; i < buildings.length; i++){
            int buildingHeight = buildings[i];

            if(!buildingStack.isEmpty() && buildingStack.peek() > buildingHeight){
                buildingStack.push(buildingHeight);
            }else{
                while(!buildingStack.isEmpty() && buildingStack.peek() <= buildingHeight){
                    buildingStack.pop();
                }
                buildingStack.push(buildingHeight);
            }
        }

        int[] result = new int[buildingStack.size()];
        for(int i = buildingStack.size() - 1; i >=0; i-- ){
            result[i] = buildingStack.pop();
        }
        return result;
    }
}
