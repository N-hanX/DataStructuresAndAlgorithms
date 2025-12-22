package study_lc.study4_c;

public class ValidateIpAddress_468 {
    public static void main(String[] args) {
//        String queryIp = "172.16.254.1";
//        String queryIp = "2001:0db8:85a3:0:0:8A2E:0370:7334";
        String queryIp = "256.256.256.256";

        String result = validIPAddress(queryIp);
        int a = 4;
    }

    public static String validIPAddress(String queryIP) {
        if(isIPv4(queryIP) ){
            return "IPv4";
        }

        if(isIPv6(queryIP) ){
            return "IPv6";
        }

        return "Neither";
    }

    public static boolean isIPv4(String queryIp){
        int[] possibleDotIndices = new int[3];
        int dotCounter = 0;

        for(int i = 0; i < queryIp.length(); i++){
            char currChar = queryIp.charAt(i);

            if(currChar == '.'){
                if(dotCounter == 3)
                    return false;

                possibleDotIndices[dotCounter] = i;
                dotCounter++;
                continue;
            }

            if(!Character.isDigit(currChar)){
                return false;
            }
        }

        if(dotCounter < 3)
            return false;

        dotCounter = 0;

        while(dotCounter < 3){
            String currSubString;
            if(dotCounter == 0){
                currSubString = queryIp.substring(0, possibleDotIndices[dotCounter]);
            }else{
                currSubString = queryIp.substring(possibleDotIndices[dotCounter - 1] + 1, possibleDotIndices[dotCounter]);
            }

            boolean subCheck = ipv4ConditionSubCheck(currSubString);
            if(!subCheck)
                return false;

            dotCounter++;

            if(dotCounter == 3){
                currSubString = queryIp.substring(possibleDotIndices[dotCounter - 1] + 1, queryIp.length());

                subCheck = ipv4ConditionSubCheck(currSubString);
                if(!subCheck)
                    return false;
            }
        }
        return true;
    }

    public static boolean ipv4ConditionSubCheck(String currSubString){
        if(currSubString.length() > 1 && currSubString.charAt(0) == '0' ){
            return false;
        }
        if(currSubString.length() == 0)
            return false;

        if(currSubString.length() > 3)
            return false;


        // System.out.println("str:" + currSubString + ":end");
        Integer currInteger = Integer.parseInt(currSubString);
        if(currInteger >= 0 && currInteger <= 255){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isIPv6(String queryIp){
        int[] possibleDoubleDotIndices = new int[7];
        int doubleDotCounter = 0;

        for(int i = 0; i < queryIp.length(); i++){
            char currChar = queryIp.charAt(i);

            if(currChar == ':'){
                if(doubleDotCounter == 7)
                    return false;

                possibleDoubleDotIndices[doubleDotCounter] = i;
                doubleDotCounter++;
                continue;
            }
            if(Character.isAlphabetic(currChar)){
                currChar = Character.toLowerCase(currChar);
            }


            if( Character.isDigit(currChar) || (currChar - 97 >= 0 && currChar - 97 <= 5)){
                continue;
            }else{
                return false;
            }
        }

        doubleDotCounter = 0;

        while(doubleDotCounter < 7){
            String currSubString;
            if(doubleDotCounter == 0){
                currSubString = queryIp.substring(0, possibleDoubleDotIndices[doubleDotCounter]);
            }else{
                currSubString = queryIp.substring(possibleDoubleDotIndices[doubleDotCounter - 1] + 1, possibleDoubleDotIndices[doubleDotCounter]);
            }

            boolean subCheck = ipv6ConditionSubCheck(currSubString);
            if(!subCheck)
                return false;

            doubleDotCounter++;

            if(doubleDotCounter == 7){
                currSubString = queryIp.substring(possibleDoubleDotIndices[doubleDotCounter - 1] + 1, queryIp.length());

                subCheck = ipv6ConditionSubCheck(currSubString);
                if(!subCheck)
                    return false;
            }
        }
        return true;
    }

    public static  boolean ipv6ConditionSubCheck(String currSubString){
        if(currSubString.length() < 1 || currSubString.length() > 4)
            return false;
        return true;
    }
}