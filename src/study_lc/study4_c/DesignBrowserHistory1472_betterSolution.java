package study_lc.study4_c;

import java.util.ArrayList;
import java.util.Arrays;

public class DesignBrowserHistory1472_betterSolution {
    public static void main(String[] args) {
        ArrayList<String> operations = new ArrayList<>(Arrays.asList("BrowserHistory","visit","visit","visit","back","back",
                "forward","visit","forward","back","back"));
        ArrayList<String> parameters = new ArrayList<>(Arrays.asList("leetcode.com","google.com","facebook.com",
                "youtube.com","1","1","1","linkedin.com","2","2","7"));

        BrowserHistory browserHistory = null;
        for(int i = 0; i < operations.size(); i++) {
            String operation = operations.get(i);
            String parameter = parameters.get(i);

            if (operation.equals("BrowserHistory")) {
                browserHistory = new BrowserHistory(parameter);
            } else if (operation.equals("visit")) {
                browserHistory.visit(parameter);
            } else if (operation.equals("back")) {
                Integer step = Integer.parseInt(parameter);
                System.out.println(browserHistory.back(step));
            } else if (operation.equals("forward")) {
                Integer step = Integer.parseInt(parameter);
                System.out.println(browserHistory.forward(step));
            }
        }
    }

    //not my solution
    static class DLLNode{
        public String data;
        public DLLNode prev, next;

        DLLNode(String url){
            data = url;
            prev = null;
            next = null;
        }
    };
    static class BrowserHistory{
        private DLLNode linkedListHead;
        private DLLNode current;

        public BrowserHistory(String homepage) {
            linkedListHead = new DLLNode(homepage);
            current = linkedListHead;
        }

        public void visit(String url){
            DLLNode newNode = new DLLNode(url);
            current.next = newNode;
            newNode.prev = current;
            current = newNode;
        }

        public String back(int steps){
            while(steps > 0 && current.prev != null ){
                current = current.prev;
                steps--;
            }
            return current.data;
        }

        public String forward(int steps){
            while(steps > 0 && current.next != null){
                current = current.next;
                steps--;
            }
            return current.data;
        }
    }
}
