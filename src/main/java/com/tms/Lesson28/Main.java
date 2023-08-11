package com.tms.Lesson28;

import com.tms.Lesson28.services.InfoService;
import com.tms.Lesson28.services.RaceService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws InterruptedException {

        ApplicationContext context = new AnnotationConfigApplicationContext("com.tms.Lesson28");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose one of 3 pairs: ");
        int chosenPair = scanner.nextInt();

        InfoService lapInfo = (InfoService) context.getBean("lapInfo");
        lapInfo.showResults();

        RaceService raceService = (RaceService) context.getBean("raceInfo");
        if (raceService.compare() == chosenPair){
            System.out.println("\nYou win!");
        } else{
            System.out.println("\nYou lose, pair " + raceService.compare() + " win");
        }

    }

}
