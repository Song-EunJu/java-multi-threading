package Section2_4;/*
 * Copyright (c) 2019-2023. Michael Pogrebinsky - Top Developer Academy
 * https://topdeveloperacademy.com
 * All rights reserved
 */

/**
 * Threads Creation - Part 1, Thread Capabilities & Debugging
 * https://www.udemy.com/java-multithreading-concurrency-performance-optimization
 */
public class Main2 {

    public static void main(String [] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //Code that will run in a new thread
                throw new RuntimeException("Intentional Exception");
            }
        });

        thread.setName("Misbehaving thread");

        /*
            자바의 Uncheked Exception 은 개발자가 직접 catch 하여 처리하지 않으면 전체 스레드를 다운시킴
            따라서 처음부터 전체 스레드에 해당되는 예외 핸들러를 지정할 수도 있음
            스레드 내에서 발생한 예외가 어디서도 catch 되지 않으면 핸들러 호출됨
         */
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("A critical error happened in thread " + t.getName()
                        + " the error is " + e.getMessage());
            }
        });
        thread.start();

    }

}
