package study_program.problemSet.graph;

import java.util.*;

public class CriticalConnections {
    public static void main(String[] args) {
//        Integer number_of_servers = 5;
//        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(0, 1));
//        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(0, 2));
//        ArrayList<Integer> arr3 = new ArrayList<>(Arrays.asList(0, 4));
//        ArrayList<Integer> arr4 = new ArrayList<>(Arrays.asList(1, 2));
//        ArrayList<Integer> arr5 = new ArrayList<>(Arrays.asList(1, 3));
//
//        ArrayList<ArrayList<Integer>> connections = new ArrayList<>();
//        connections.add(arr1);
//        connections.add(arr2);
//        connections.add(arr3);
//        connections.add(arr4);
//        connections.add(arr5);

        Integer number_of_servers = 5;
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(0, 4));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(0, 1));
        ArrayList<Integer> arr3 = new ArrayList<>(Arrays.asList(1, 4));
        ArrayList<Integer> arr4 = new ArrayList<>(Arrays.asList(1, 2));
        ArrayList<Integer> arr5 = new ArrayList<>(Arrays.asList(2, 3));

        ArrayList<ArrayList<Integer>> connections = new ArrayList<>();
        connections.add(arr1);
        connections.add(arr2);
        connections.add(arr3);
        connections.add(arr4);
        connections.add(arr5);

//        Integer number_of_servers = 4;
//        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(0, 1));
//        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(0, 2));
//        ArrayList<Integer> arr3 = new ArrayList<>(Arrays.asList(0, 3));
//        ArrayList<Integer> arr4 = new ArrayList<>(Arrays.asList(1, 2));
//        ArrayList<Integer> arr5 = new ArrayList<>(Arrays.asList(2, 3));
//
//        ArrayList<ArrayList<Integer>> connections = new ArrayList<>();
//        connections.add(arr1);
//        connections.add(arr2);
//        connections.add(arr3);
//        connections.add(arr4);
//        connections.add(arr5);

        ArrayList<ArrayList<Integer>> result = find_critical_connections(number_of_servers, connections);

        int a;
    }


    static Map<Integer, ArrayList<Integer>> getConnectionMap(Integer number_of_servers,
                                                             ArrayList<ArrayList<Integer>> connections){

        Map<Integer, ArrayList<Integer>> connectionMap = new HashMap<>();

        for(int i = 0; i < number_of_servers; i++){
            connectionMap.put(i, new ArrayList<>());
        }

        for(int i = 0; i < connections.size(); i++){
            int conn1 = connections.get(i).get(0);
            int conn2 = connections.get(i).get(1);

            ArrayList<Integer> connectionList = connectionMap.get(conn1);
            connectionList.add(conn2);
            connectionMap.put(conn1, connectionList);

            connectionList = connectionMap.get(conn2);
            connectionList.add(conn1);
            connectionMap.put(conn2, connectionList);
        }

        return connectionMap;
    }

    static ArrayList<ArrayList<Integer>> find_critical_connections(Integer number_of_servers,
                                                                   ArrayList<ArrayList<Integer>> connections) {

        Map<Integer, ArrayList<Integer>> connectionMap = getConnectionMap(number_of_servers, connections);

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        Set<Integer> visited = new HashSet<>();
        for(int i = 0; i < connections.size(); i++){
            ArrayList<Integer> curr_conn = connections.get(i);

            moving_without_a_connection(number_of_servers, connectionMap, visited,curr_conn, 0);

            if(visited.size() != number_of_servers){
                result.add(curr_conn);
            }
            visited = new HashSet<>();
        }

        if(result.size() == 0){
            result.add(new ArrayList<>(Arrays.asList(-1, -1)));
        }
        return result;
    }

    static boolean checkTheCurrConnection(int conn1, int conn2, ArrayList<Integer> curr_conn){
        int otherConn1 = curr_conn.get(0);
        int otherConn2 = curr_conn.get(1);

        if(otherConn1 == conn1 && otherConn2 == conn2 || otherConn1 == conn2 && otherConn2 == conn1)
            return true;

        return false;
    }

    static void moving_without_a_connection(Integer number_of_servers, Map<Integer, ArrayList<Integer>> connectionMap,
                                            Set<Integer> visited, ArrayList<Integer> curr_conn, int curr_corner){
        if(visited.contains(curr_corner)){
            return;
        }

        if(visited.size() == number_of_servers){
            return;
        }

        ArrayList<Integer> its_connections = connectionMap.get(curr_corner);

        for(int j = 0; j < its_connections.size(); j++){
            int conn2 = its_connections.get(j);

            if(!checkTheCurrConnection(curr_corner, conn2, curr_conn)){
                visited.add(curr_corner);
                moving_without_a_connection(number_of_servers, connectionMap, visited, curr_conn, conn2);
            }
        }
    }
}
