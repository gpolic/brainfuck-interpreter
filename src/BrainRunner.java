import java.io.File;
import java.util.Scanner;

/**
 * Example Brainfuck Interpreter
 * Pass the source code file as a parameter on the command line
 * Usage: java BrainRunner sourcefile.b
 * <p>
 * The interpreter will read the source file into a String, then create the Interpreter object and execute it
 */
public class BrainRunner {
    public static void main(String[] args) {
        String brainFuckCode;
        long startTime;

        if (args.length == 0) {
            System.out.println("Usage: java BrainRunner sourcefile");
            System.exit(1);
        }
        if ((brainFuckCode = readFile(args[0])) == null) {  // read the source code file into a String
            System.exit(2);
        }

        System.out.println("Process and execute: " + args[0]);
        startTime = System.nanoTime();
        try {
            BrainInt.newProgram(brainFuckCode).executeBf();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("\nTime (seconds) taken is " + (System.nanoTime() - startTime) / 1.0e9);
    }

    private static String readFile(String sourceFile) {
        try (Scanner input = new Scanner(new File(sourceFile))) {
            StringBuilder sb = new StringBuilder();
            while (input.hasNext()) { // read all lines and append to String Builder
                sb.append(input.nextLine());
            }
            return sb.toString();
        } catch (Exception ex) {
            // if the file does not exist the exception will be caught here
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
