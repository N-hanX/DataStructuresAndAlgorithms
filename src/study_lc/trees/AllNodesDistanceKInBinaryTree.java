package study_lc.trees;

import java.util.*;

public class AllNodesDistanceKInBinaryTree {
    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);
        TreeNode node1 = new TreeNode(1);
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);

        node3.left = node5;
        node3.right = node1;
        node5.left = node6;
        node5.right = node2;
        node2.left = node7;
        node2.right = node4;
        node1.left = node0;
        node1.right = node8;

//        List<Integer> result = distanceK(node3, node5, 2);

        List<Integer> result = distanceK(node3, node5, 0);

        int a = 4;
    }

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentNodeMap = new HashMap<>();
        createParentData(root, null, parentNodeMap);

        return findNodesInKDistance(target, parentNodeMap, k);
    }

    public static List<Integer> findNodesInKDistance(TreeNode target, Map<TreeNode, TreeNode> parentNodeMap, int k){
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> currNodesInSuchDistance = new LinkedList<>();
        currNodesInSuchDistance.add(target);

        if(k == 0){
            result.add(target.x);
            return result;
        }

        Set<TreeNode> visited = new HashSet<>();
        int distanceCounter = 0;

        while(!currNodesInSuchDistance.isEmpty()){
            int currQueueSize = currNodesInSuchDistance.size();

            int counterCurrDistanceNodes = 0;

            while(counterCurrDistanceNodes < currQueueSize){
                TreeNode currNode =  currNodesInSuchDistance.poll();

                if( currNode != null && !visited.contains(currNode)){
                    visited.add(currNode);

                    if(currNode.left != null && !visited.contains(currNode.left))
                        currNodesInSuchDistance.add(currNode.left);

                    if(currNode.right != null && !visited.contains(currNode.right))
                        currNodesInSuchDistance.add(currNode.right);

                    if(parentNodeMap.get(currNode) != null && !visited.contains(parentNodeMap.get(currNode)))
                        currNodesInSuchDistance.add(parentNodeMap.get(currNode));

                    counterCurrDistanceNodes++;
                }else{
                    counterCurrDistanceNodes++;
                    continue;
                }
            }
            distanceCounter++;
            if(distanceCounter == k){
                break;
            }
        }



        while(!currNodesInSuchDistance.isEmpty()){
            TreeNode node = currNodesInSuchDistance.poll();
            if(node != null)
                result.add(node.x);
        }
        return result;
    }



    public static void createParentData(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> parentNodeMap){
        if(root == null){
            return;
        }

        parentNodeMap.put(root, parent);
        createParentData(root.left, root, parentNodeMap);
        createParentData(root.right, root, parentNodeMap);
    }

    static class TreeNode {
        int x;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.x = x;
        }
    }
}
