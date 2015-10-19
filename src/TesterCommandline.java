import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Branden on 10/18/2015.
 */
public class TesterCommandline {
    public static void main(String args[]) throws FileNotFoundException {
        String[] argument1 = {"-a", "-b", "h"};
        String[] argument2 = {"-frequency", "-num_unique"};
        String[] argument3 = {"-is", "-qs", "-ms"};
        String filename = "hamlet.txt";
        String[] completeArguments = new String[4];

        //loop through all possible combinations of arguments (18 of them)
        int count = 0;
        String ans = "Y";

        for(int i = 0; i < argument1.length; i++ ) {
            completeArguments[0] = argument1[i];
            for (int j = 0; j < argument2.length; j++) {
                completeArguments[1] = argument2[j];
                for (int k = 0; k < argument3.length; k++) {
                    count++;
                    completeArguments[2] = argument3[k];
                    completeArguments[3] = filename;

                    //arguments are all set up, ready to test
                    System.out.print("(" + count + ")Testing with the arguments ");
                    for (int L = 0; L < completeArguments.length; L++) {
                        System.out.print(completeArguments[L] + " ");
                    }
                    System.out.println();
                    WordCount.main(completeArguments);
                    Scanner reader = new Scanner(System.in);
                    System.out.println("Would you like to run another test (Y/n)? ");
                    ans = reader.nextLine();
                    if (ans.charAt(0) == 'n' || ans.charAt(0) == 'N') {
                        break;
                    }
                }
                if (ans.charAt(0) == 'n' || ans.charAt(0) == 'N') {
                    break;
                }
            }
            if (ans.charAt(0) == 'n' || ans.charAt(0) == 'N') {
                break;
            }
        }

        System.out.println("\nTesting the error output when wrong commandline arguments used \n");


        String[] incompleteArgs = {"-a", "hamlet.txt"};

        //test if a proper error message is printed
        WordCount.main(incompleteArgs);

    }

}
