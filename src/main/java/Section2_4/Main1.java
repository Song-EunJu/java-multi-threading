package Section2_4;
/*
 * Copyright (c) 2019-2023. Michael Pogrebinsky - Top Developer Academy
 * https://topdeveloperacademy.com
 * All rights reserved
 */

/**
 *  Threads Creation - Part 1, Thread Capabilities & Debugging
 * https://www.udemy.com/java-multithreading-concurrency-performance-optimization
 */
public class Main1 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            // 새로운 스레드에서 실행되는 코드
            System.out.println("we are now in thread "+Thread.currentThread().getName());
            System.out.println("Current thread priority is " + Thread.currentThread().getPriority());
        });

        thread.setName("New Worker Thread");
        thread.setPriority(Thread.MAX_PRIORITY);
        System.out.println("We are in thread: " + Thread.currentThread().getName()+ " before starting a new thread");

        // JVM 이 스레드 생성하여 OS 에 전달
        thread.start();
        System.out.println("We are in thread: " + Thread.currentThread().getName()+ " after starting a new thread");

        /*
            OS 에게 지정한 시간만큼, 현재 스레드를 스케줄링 하지말라고 지시하는 것
            정해진 시간동안 CPU 를 사용하지 않는 것
         */
        Thread.sleep(10000);
    }
}
