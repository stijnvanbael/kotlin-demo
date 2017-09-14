package eu.ccvlab.java.demo;

import static eu.ccvlab.java.demo.Functions.println;

public class StringFormatting {
    public static void main(String[] args) {
        final String greeting = "Hello";
        // greeting = goodbye;
        println(greeting + " " + args[0] + "!");
        println(String.format("%s %s!", greeting , args[0]));
    }
}
