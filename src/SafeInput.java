import java.util.Scanner;

public class SafeInput {
    /**
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = "";  // Set this to zero length. Loop runs until it isn’t
        do {
            System.out.print("\n" + prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        } while (retString.length() == 0);

        return retString;

    }

    public static int getInt(Scanner pipe, String prompt) {
        int retInteger = 0;
        boolean done = false;
        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt()) {
                retInteger = pipe.nextInt();
                done = true;
            }
            pipe.nextLine();
        } while (!done);
        return retInteger;

    }

    public static double getDouble(Scanner pipe, String prompt) {
        double retDouble = 0;
        boolean done = false;
        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble()) {
                retDouble = pipe.nextDouble();
                done = true;
            }
            pipe.nextLine();
        } while (!done);
        return retDouble;

    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int retInteger = 0;
        boolean done = false;
        do {
            System.out.print("\n" + prompt + "[" + low + " - " + high + "]: ");
            if (pipe.hasNextInt()) {
                retInteger = pipe.nextInt();
                if (retInteger < low || retInteger > high) {
                    done = false;
                } else {
                    done = true;
                }
            }
            pipe.nextLine();
        } while (!done);
        return retInteger;

    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double retDouble = 0;
        boolean done = false;
        do {
            System.out.print("\n" + prompt + "[" + low + " - " + high + "]: ");
            if (pipe.hasNextDouble()) {
                retDouble = pipe.nextDouble();
                if (retDouble < low || retDouble > high) {
                    done = false;
                } else {
                    done = true;
                }
            }
            pipe.nextLine();
        } while (!done);
        return retDouble;

    }
    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        boolean retBool = false;
        boolean done = false;
        String ynConfirm = "";
        do {
            System.out.print("\n" + prompt + ": ");
            ynConfirm = pipe.next();
            if( ynConfirm.equalsIgnoreCase("Y")){
                retBool = true;
                done = true;
            }
            else if(ynConfirm.equalsIgnoreCase("N")){
                retBool = false;
                done = true;
            }
        } while (!done);

        return retBool;

    }
    public static String getRegExString(Scanner pipe, String prompt, String regExPattern){
        String response = "";
        boolean done = false;
        do {
            System.out.print("\n" + prompt + ": ");
            response = pipe.nextLine();
            if(response.matches(regExPattern)){
                done = true;
            }
        }while(!done);
        return response;
    }
    public static void prettyHeader(String msg) {
        if(msg.length() > 54){
            msg = msg.substring(0,54);
        }
        int halfLength = msg.length() / 2;
        int spacesBefore = 27 - halfLength;
        int spacesAfter = 54 - spacesBefore - msg.length();
        for(int cnt = 1; cnt <= 60; cnt++){
            System.out.print("*");
        }
        System.out.println();
        for(int cnt = 1; cnt <=3; cnt++){
            System.out.print("*");
        }
        for(int cnt = 1; cnt <=spacesBefore; cnt++) {
            System.out.print(" ");
        }
        System.out.print(msg);
        for(int cnt = 1; cnt <=spacesAfter; cnt++) {
            System.out.print(" ");
        }
        for(int cnt = 1; cnt <=3; cnt++) {
            System.out.print("*");
        }
        System.out.println();
        for(int cnt = 1; cnt <= 60; cnt++){
            System.out.print("*");
        }
        System.out.println();
    }
}
