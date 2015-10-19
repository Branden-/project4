import java.io.FileNotFoundException;

/**
 * Created by Branden on 10/18/2015.
 */
public class TesterCommandline {
    public static void main(String args[]) throws FileNotFoundException {
        String[] someArgs = {"-a", "hamlet.txt"};

        //test if a proper error message is printed
        WordCount.main(someArgs);

    }

}
