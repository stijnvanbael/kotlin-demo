package demo.java;

import static demo.java.Functions.println;

public class StringFormatting {
    public static void main(String[] args) {
        final String greeting = "Hello";
        // greeting = goodbye;
        println(greeting + " " + args[0] + "!");
        println("%s %s!".formatted(greeting, args[0]));
    }
}
