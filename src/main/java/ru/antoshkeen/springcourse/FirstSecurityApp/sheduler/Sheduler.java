package ru.antoshkeen.springcourse.FirstSecurityApp.sheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Sheduler {
    @Scheduled(fixedDelay = 1000)
    public void test() {
        System.out.println("Sheduler works!");
    }
}
