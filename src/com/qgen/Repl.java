package com.qgen;

import com.qgen.lang.QGenEvaluator;
import com.qgen.lang.QGenProgram;
import com.qgen.sys.QGenContext;
import com.qgen.sys.QGenException;
import com.qgen.lang.*;
import com.qgen.values.QGenValue;

import java.io.*;

/**
 * Created by javon on 06/03/2016.
 */
public class Repl {

    static QGenContext globalEnv;
    static QGenEvaluator interp;

    public static void main(String[] args)
    {
        globalEnv = new QGenContext();
        interp = new QGenEvaluator();
        if (args.length == 0) {
            repl(System.in, globalEnv);
        }
        else {
            try {
                parseEvalShow(args[0],new FileReader(new File(args[0]+".qg")), globalEnv);
            } catch(FileNotFoundException e) {
                System.out.println("Could not find file " + args[0]+".qg");
            }
        }
    }

    /**
     * In an infinite loop: read HPL commands in from standard input,
     evaluate them as a sequence with respect to the given
     environment, and display the lastResult.
     *
     * @param is the input stream of characters encoding the HPL commands
     * @param genv a <code>HPLEnvironment</code> value
     */
    public static void repl(InputStream is, QGenContext genv) {
        final String FIRST_PROMPT = "QGen> ";
        final String NEXT_PROMPT = " > ";
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        try {
            while (true) {
                System.out.print(FIRST_PROMPT);
                StringBuffer input = new StringBuffer();
                String line = reader.readLine();
                while (line != null && !line.equals(".")) {
                    System.out.print(NEXT_PROMPT);
                    input.append("\n");
                    input.append(line);
                    line = reader.readLine();
                }
                StringReader r = new StringReader(new String(input));
                parseEvalShow("tmp", r, genv);
            }
        } catch (IOException ex) {
            System.out.println("Bye bye!");
        }
    }

    public static void parseEvalShow(String arg, Reader r, QGenContext env) {
        QGenLexer lexer;
        QGenParser parser;
        QGenProgram template = null;

        try {
            lexer = new QGenLexer(r);
            parser = new QGenParser(lexer);
            template = (QGenProgram) parser.parse().value;
        } catch (Exception e) {
            System.out.println("Syntax Error: " + e.getMessage());
        }

        QGenValue result = null;
        if (template != null)
            try {
                result = template.visit(interp, env);
                if (result != null) {
                    //System.out.println("\n" + result.getVal().toString());
                    PrintStream out = new PrintStream(new FileOutputStream(arg+".xml"));
                    out.print(result.getVal().toString());
                } else {
                    System.out.println("\nNo result");
                }
            } catch (QGenException e) {
                System.out.println("Runtime Error: " + e.getMessage());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
    }
}
