import com.gpolic.brainfuck.BrainInt;

import java.io.ByteArrayOutputStream;
import java.io.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertTrue;

/**
 * BrainIntTest is a test unit for the interpreter
 * Testing programs can be found at : http://www.hevanet.com/cristofd/brainfuck/tests.b
 */
public class BrainIntTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();
    private ByteArrayOutputStream baos;
    private PrintStream outputStream;           // provide output Stream to the interpreter to store results
    private String memTest, variousIssuesTest, loopTest, variousIssuesTest2;

    @Before
    public void setUp() throws Exception {
        baos = new ByteArrayOutputStream();
        outputStream = new PrintStream(baos);

        memTest = "++++[>++++++<-]>[>+++++>+++++++<<-]>>++++<[[>[[>>+<<-]<]>>>-]>-[>+>+<<-]>]+++++[>+++++++<<++>-]>.<<.";
        variousIssuesTest = "[]++++++++++[>>+>+>++++++[<<+<+++>>>-]<<<<-]\"A*$\";?@![#>>+<<]>[>>]<<<<[>++<[-]]>.>.";
        variousIssuesTest2 = "++++++++[->-[->-[->-[-]<]<]<]>++++++++[<++++++++++>-]<[>+>+<<-]>-.>-----.>";
        loopTest = "+++++[>+++++++>++<<-]>.>.[";
    }

    @Test
    public void verifyMemory() throws Exception {
        BrainInt BfInterpreter;

        BfInterpreter = BrainInt.newProgram(memTest, (BufferedInputStream) System.in, outputStream);
        BfInterpreter.executeBf();
        assertTrue(baos.toString().trim().equals("#"));
    }

    @Test
    public void variousIssues() throws Exception {
        BrainInt BfInterpreter;

        BfInterpreter = BrainInt.newProgram(variousIssuesTest, (BufferedInputStream) System.in, outputStream);
        BfInterpreter.executeBf();
        assertTrue(baos.toString().trim().equals("H"));
    }

    @Test
    public void variousIssues2() throws Exception {
        BrainInt BfInterpreter;

        BfInterpreter = BrainInt.newProgram(variousIssuesTest2, (BufferedInputStream) System.in, outputStream);
        BfInterpreter.executeBf();
        assertTrue(baos.toString().trim().equals("OK"));
    }

    @Test
    public void loopCheck() throws Exception {
        BrainInt BfInterpreter;

        expectedEx.expect(IllegalArgumentException.class);
        BfInterpreter = BrainInt.newProgram(loopTest, (BufferedInputStream) System.in, outputStream);
        BfInterpreter.executeBf();
    }
}