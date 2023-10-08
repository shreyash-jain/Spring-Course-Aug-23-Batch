package com.shreyash.demo;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

//    @Scheduled(fixedDelay = 1000)
//    public void scheduleFixedDelayTask() {
//        System.out.println("Fixed delay task - " + System.currentTimeMillis() / 1000);
//    }
//
//    /// <minute> <hour> <day-of-month> <month> <day-of-week> <command>
//
//    @Scheduled(cron = "0 15 10 15 * ?")
//    public void scheduleTaskUsingCronExpression() {
//        long now = System.currentTimeMillis() / 1000;
//        System.out.println(
//                "schedule tasks using cron jobs - " + now);
//    }
}
