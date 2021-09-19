package org.java.sample.tutorials;

import org.java.sample.tutorials.multithreading.ExampleExecutorService;
import org.java.sample.tutorials.multithreading.ExampleMultithreading;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Welcome to Java Tutorials");
        ExampleMultithreading exampleMultithreading = new ExampleExecutorService();
        exampleMultithreading.execute();
    }
}
