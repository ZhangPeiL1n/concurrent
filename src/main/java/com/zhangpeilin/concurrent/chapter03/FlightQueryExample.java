package com.zhangpeilin.concurrent.chapter03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ZhangPeiL1n
 * @date 2020/9/9 21:22
 * @Description
 **/
public class FlightQueryExample {

    /**
     * 航空公司
     */
    private static final List<String> flightCompany = Arrays.asList("CSA", "CEA", "HNA");

    public static void main(String[] args) {
        List<String> result = search("SH", "Bj");
        System.out.println("===================");
        result.forEach(System.out::println);
    }

    private static List<String> search(String origin, String destination) {
        final List<String> result = new ArrayList<>();
        //创建查询航班信息的线程
        List<FlightQueryTask> tasks = flightCompany.stream().map(f -> createSearchTask(f, origin, destination)).collect(Collectors.toList());
        //启动线程
        tasks.forEach(Thread::start);
        //分别调用每一个线程的 join 方法，阻塞当前线程
        tasks.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {

            }
        });

        //在此之前，当前线程会阻塞住，获取每一个线程的结果，并且加入到 result 中
        tasks.stream().map(FlightQuery::get).forEach(result::addAll);
        return result;
    }


    private static FlightQueryTask createSearchTask(String flight, String origin, String destination) {
        return new FlightQueryTask(flight, origin, destination);
    }


}
