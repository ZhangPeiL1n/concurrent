package com.zhangpeilin.concurrent.chapter05;

import java.util.LinkedList;

/**
 * @author ZhangPeiL1n
 * @date 2020/9/14 21:08
 * @Description
 **/
public class EventQueue {
    /**
     * 最大任务量
     */
    private final static int DEFAULT_MAX_EVENT = 10;
    private final int max;
    private final LinkedList<Event> eventQueue = new LinkedList<>();

    public EventQueue() {
        this(DEFAULT_MAX_EVENT);
    }

    public EventQueue(int max) {
        this.max = max;
    }

    /**
     * 提交任务
     *
     * @param event 事件
     */
    public void offer(Event event) {
        // synchronized (eventQueue){
        //     //队列满
        //     if (eventQueue.size() >= max){
        //         try {
        //             console(" the queue is full.");
        //             eventQueue.wait();
        //         } catch (InterruptedException e) {
        //             e.printStackTrace();
        //         }
        //     }
        //
        //     console(" the new event is submitted.");
        //     //加入队尾
        //     eventQueue.addLast(event);
        //     eventQueue.notify();
        // }

        //多线程并发版
        synchronized (eventQueue) {
            //队列满
            while (eventQueue.size() >= max) {
                try {
                    console(" the queue is full.");
                    eventQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            console(" the new event is submitted.");
            //加入队尾
            eventQueue.addLast(event);
            eventQueue.notifyAll();
        }
    }

    /**
     * 取任务
     *
     * @return 任务
     */
    public Event take() {
        // synchronized (eventQueue){
        //     //队列空
        //     if (eventQueue.isEmpty()){
        //         try {
        //             eventQueue.wait();
        //             console(" the queue is empty.");
        //         } catch (InterruptedException e) {
        //             e.printStackTrace();
        //         }
        //     }
        //     //移除队首
        //     Event event = eventQueue.removeFirst();
        //     this.eventQueue.notify();
        //     console(" the event " + event + "is handled.");
        //     return event;
        // }

        synchronized (eventQueue) {
            //队列空
            while (eventQueue.isEmpty()) {
                try {
                    eventQueue.wait();
                    console(" the queue is empty.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //移除队首
            Event event = eventQueue.removeFirst();
            this.eventQueue.notifyAll();
            console(" the event " + event + "is handled.");
            return event;
        }
    }

    private void console(String message) {
        System.out.printf("%s : %s %n", Thread.currentThread().getName(), message);
    }

    static class Event {
    }
}
