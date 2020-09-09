package com.zhangpeilin.concurrent.chapter01;

/**
 * @author ZhangPeiL1n
 * @date 2020/8/2 21:42
 * @Description 模拟叫号机程序
 **/
public class TicketWindow extends Thread {
    /**
     * 最多受理 50 笔业务
     */
    private static final int MAX = 50;
    /**
     * 柜台名称
     */
    private final String name;
    private int index = 1;

    public TicketWindow(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        TicketWindow ticketWindow1 = new TicketWindow("一号出号机");
        ticketWindow1.start();
        TicketWindow ticketWindow2 = new TicketWindow("二号出号机");
        ticketWindow2.start();
        TicketWindow ticketWindow3 = new TicketWindow("三号出号机");
        ticketWindow3.start();
        TicketWindow ticketWindow4 = new TicketWindow("四号出号机");
        ticketWindow4.start();
    }

    @Override
    public void run() {
        while (index <= MAX) {
            System.out.println("柜台：" + name + "当前叫到的号码是：" + (index++));
        }
    }
}
