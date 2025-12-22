package study_lc.study4_m;

import java.util.*;

public class AccountsMerge_721 {
    public static void main(String[] args) {
        List<List<String>> accountList = new ArrayList<>();
        List<String> list1 = new ArrayList<>(Arrays.asList("David","David0@m.co","David4@m.co","David3@m.co"));
        List<String> list2 = new ArrayList<>(Arrays.asList("David","David5@m.co","David5@m.co","David0@m.co"));
        List<String> list3 = new ArrayList<>(Arrays.asList("David","David1@m.co","David4@m.co","David0@m.co"));
        List<String> list4 = new ArrayList<>(Arrays.asList("David","David0@m.co","David1@m.co","David3@m.co"));
        List<String> list5 = new ArrayList<>(Arrays.asList("David","David4@m.co","David1@m.co","David3@m.co"));
        accountList.add(list1);
        accountList.add(list2);
        accountList.add(list3);
        accountList.add(list4);
        accountList.add(list5);

        List<List<String>> result = accountsMerge(accountList);
        int a = 4;
    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        createEmailRepresentativeGraph(accounts);
        return traverseTheList();
    }

    public static List<List<String>> traverseTheList(){
        visitedRepresentative = new HashSet<>();
        visitedEmailAddresses = new HashSet<>();

        List<List<String>> result = new ArrayList<>();

        for(Representative currRepresentative: allRepresentatives){
            if(visitedRepresentative.contains(currRepresentative))
                continue;

            visitedRepresentative.add(currRepresentative);
            List<EmailAddress> emailAddresses = currRepresentative.emails;

            List<String> currEmails = new ArrayList<>();
            for(int i = 0; i < emailAddresses.size(); i++){
                EmailAddress currEmailAddr = emailAddresses.get(i);
                dfs(currEmailAddr.emailAddress, currEmails);
            }
            Collections.sort(currEmails);

            if(currEmails.size() > 0){
                List<String> currResult = new ArrayList<>();
                currResult.add(currRepresentative.name);
                currResult.addAll(currEmails);
                result.add(currResult);
            }
        }
        return result;
    }

    public static void dfs(String currEmailAddr, List<String> currEmails){
        if(visitedEmailAddresses.contains(currEmailAddr)){
            return;
        }else{
            currEmails.add(currEmailAddr);
            visitedEmailAddresses.add(currEmailAddr);

            EmailAddress currEmail = emailAddresses.get(currEmailAddr);
            List<Representative> representativeList = currEmail.representatives;

            for(int i = 0; i < representativeList.size(); i++){
                Representative currRepresentative = representativeList.get(i);

                if(visitedRepresentative.contains(currRepresentative)){
                    continue;
                }else{
                    List<EmailAddress> associatedEmails = currRepresentative.emails;
                    for(int j = 0; j < associatedEmails.size(); j++){
                        dfs(associatedEmails.get(j).emailAddress, currEmails);
                    }
                }
            }
        }
    }

    static Map<String, EmailAddress> emailAddresses;
    static Set<Representative> allRepresentatives;
    static Map<String, ArrayList<Representative>> representativeMap;

    static Set<Representative> visitedRepresentative;
    static Set<String> visitedEmailAddresses;

    public static void createEmailRepresentativeGraph(List<List<String>> accounts){
        allRepresentatives = new HashSet<>();
        representativeMap = new HashMap<>();
        emailAddresses = new HashMap<>();

        for(int i = 0; i < accounts.size(); i++){
            // get whole list
            List<String> currAccount = accounts.get(i);

            // get the name which is the 0. element
            String currName = currAccount.get(0);
            Representative currRepresentative = new Representative(currName, i);
            allRepresentatives.add(currRepresentative);
            List<EmailAddress> currEmailList = new ArrayList<>();

            // get the emails which are the rest of the list
            for(int j = 1; j < currAccount.size(); j++){
                // System.out.println("email: " + currAccount.get(j));
                String currEmail = currAccount.get(j);

                if(emailAddresses.containsKey(currEmail)){
                    EmailAddress currEmailAddress = emailAddresses.get(currEmail);
                    List<Representative> reprList = currEmailAddress.representatives;
                    reprList.add(currRepresentative);
                    currEmailList.add(currEmailAddress);
                }else{
                    EmailAddress newEmailAddress = new EmailAddress(currEmail);
                    newEmailAddress.addRepresentative(currRepresentative);
                    emailAddresses.put(currEmail, newEmailAddress);
                    currEmailList.add(newEmailAddress);
                }
            }
            // lets put them into current account
            currRepresentative.emails = currEmailList;
        }
    }

    static class Representative{
        int id;
        String name;
        List<EmailAddress> emails;

        public Representative(String name, int id){
            this.id = id;
            this.name = name;
            emails = new ArrayList<>();
        }
    }

    static class EmailAddress{
        String emailAddress;
        List<Representative> representatives;

        public EmailAddress(String emailAddress){
            this.emailAddress = emailAddress;
            representatives = new ArrayList<>();
        }

        public void addRepresentative(Representative representative){
            representatives.add(representative);
        }

        public boolean equals(Object otherObj){
            EmailAddress otherEmailAddr = (EmailAddress) otherObj;

            if(this.emailAddress.equals(otherEmailAddr.emailAddress)){
                return true;
            }
            return false;
        }
    }
}
