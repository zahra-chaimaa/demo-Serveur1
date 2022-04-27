package demo.demo.jcolibri.server;

import demo.demo.jcolibri.server.test1;
import 	demo.demo.jcolibri.cbrcore.CBRCase;
import 	demo.demo.jcolibri.exception.ExecutionException;

public class main {
    public static void main(String[] args) throws demo.demo.jcolibri.exception.ExecutionException {
        System.out.println("This is the main function is package com.demo.second");
        System.out.println("######################");

        test1 test = new test1();
        test.configure();
        System.out.println("la configuration succée");


        //  try {
        // System.out.println("Running configure()");
        //test.configure();

        //System.out.println("Running preCycle()");
        //test.preCycle();
        //System.out.println(test.mycases);
        //System.out.println("Items of the case a");
        // for(CBRCase c: test.mycases.getCases())
        //    System.out.println(c);
        //The cycle will require a query description, so we'll make it before calling the cycle

        //System.out.println("Running the cycle");
        //} catch (ExecutionException e) {
        //  e.printStackTrace();
        //}

        // }
    }
}
