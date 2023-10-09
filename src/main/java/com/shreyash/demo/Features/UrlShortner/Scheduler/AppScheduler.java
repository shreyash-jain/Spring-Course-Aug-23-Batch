package com.shreyash.demo.Features.UrlShortner.Scheduler;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AppScheduler {

//    @Scheduled(cron = "0 0 10 ? * *")
// // 0 10
// // ? -> any
// // * -> all
// // - -> from this to that
// // / -> from start with interval
//
//   // at 12 midnight starting from 5th at regular
//        //  interval of 5 days till 23rd as well as from 28 to 30 of every month
//            // 5, 10, 15, 20, 28, 29, 30
//
//            // 0 0 0 5-23/5,28-30 * ?
//
//    // sec, min, hr, day-of-month, month, day-of-week
//    void run(){
//        System.out.println("Say hi from run : AppScheduler");
//        // after every fixedRate time
//
//    }
//
//    @Scheduled(fixedDelay = 1000, initialDelay = 1000)
//    void runOther(){
//        System.out.println("Say hi from run other : AppScheduler");
//        // As soon as you complete it -> after time : fixedDelay, will start the next one
//    }
}
