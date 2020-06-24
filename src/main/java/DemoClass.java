import org.apache.log4j.Logger;

import java.io.PrintStream;

public class DemoClass {
    Logger log = Logger.getLogger("devpinoyLogger");
    public static void main(String[] args) {
        print(System.out);
    }

    public static void print(PrintStream out) {
        out.print("Hello");
    }
}