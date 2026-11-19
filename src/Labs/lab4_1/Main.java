package Labs.lab4_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in)
        );
        PrintWriter output = new PrintWriter(System.out);
        MinStack<Integer> stack = new MinStackImpl();

        String line;
        while ((line = reader.readLine()) != null) {
            StringTokenizer words = new StringTokenizer(line);
            String command = words.nextToken();

            switch (command) {
                case "push":
                    int value = Integer.parseInt(words.nextToken());
                    stack.push(value);
                    break;
                case "pop":
                    stack.pop();
                    break;
                case "top":
                    output.println(stack.top());
                    break;
                case "min":
                    output.println(stack.min());
                    break;
            }
        }

        output.flush();
    }
}
