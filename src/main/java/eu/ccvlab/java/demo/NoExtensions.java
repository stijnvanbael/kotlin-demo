package eu.ccvlab.java.demo;

import eu.ccvlab.kotlin.demo._04_ExtensionsKt;

import java.util.Arrays;
import java.util.List;

import static eu.ccvlab.java.demo.Functions.println;

public class NoExtensions {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("first", "second", "third");

        println(middle(list));

        // Kotlin interop
        println(_04_ExtensionsKt.middle(list));
    }

    private static <T> T middle(List<T> list) {
        if (list.isEmpty()) return null;
        int middlePos = (int) Math.ceil((double) list.size() / 2) - 1;
        return list.get(middlePos);

    }
}
