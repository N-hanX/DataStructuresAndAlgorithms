package study_lc.study4_c;

import java.util.Stack;

public class DesignBrowserHistory_1472 {
    static class BrowserHistory {
        Stack<String> history;
        Stack<String> forwardHistory;

        public BrowserHistory(String homepage) {
            history = new Stack<>();
            forwardHistory = new Stack<>();
            history.add(homepage);

            // System.out.println("history top: " + history.peek());
            // System.out.println("history size: " + history.size());
            // System.out.println("forward size: " + forwardHistory.size());
            // System.out.println();
        }

        public void visit(String url) {
            forwardHistory.clear();
            history.add(url);
            // System.out.println("visit: " + url);
            // System.out.println("history top: " + history.peek());
            // System.out.println("history size: " + history.size());
            // System.out.println("forward size: " + forwardHistory.size());
            // System.out.println();
        }

        public String back(int steps) {
            int counter = 0;
            // System.out.println("back");
            while(counter < steps && history.size() > 1){
                String currHistory = history.pop();
                // System.out.println("curr history: " + currHistory);

                forwardHistory.add(currHistory);
                counter++;
            }
            // System.out.println("back end");
            // System.out.println();
            return history.peek();
        }

        public String forward(int steps) {
            int counter = 0;
            String currHistory = null;
            // System.out.println("forward");
            while(counter < steps && !forwardHistory.isEmpty()){
                currHistory = forwardHistory.pop();
                // System.out.println("curr history: " + currHistory);
                history.add(currHistory);
                counter++;
            }
            // System.out.println("forward end");
            // System.out.println();
            if(currHistory == null)
                return history.peek();

            return currHistory;
        }
    }

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
}
