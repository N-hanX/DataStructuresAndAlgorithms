package recursion.problemSet;

public class binarySearchTreeWithNNode {
    public static void main(String[] args) {
        long l = how_many_BSTs(5);
        int a = 5;
    }
    static long how_many_BSTs(int n) {
        if(n==0){
            Long l = 1L;
            return l;
        }
        long sum = 0L;
        for(int numOfLeftNode = 0; numOfLeftNode < n; numOfLeftNode++){
            int numOfRightNode = n - 1 - numOfLeftNode;
            sum = sum + how_many_BSTs(numOfLeftNode) * how_many_BSTs(numOfRightNode);
        }
        return sum;
    }



}
