package lesson5;

import lesson5.stages.*;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 *Организуем гонки:
 * Все участники должны стартовать одновременно, несмотря на то,
 * что на подготовку у каждого из них уходит разное время.
 * В туннель не может заехать одновременно больше половины участников (условность).
 * Попробуйте всё это синхронизировать.
 * Только после того как все завершат гонку, нужно выдать объявление об окончании.
 */

public class MainClass {
    public static final int CARS_COUNT = 4;
    public static Car firstPlace;
    public static CountDownLatch cd1;
    public static CountDownLatch cd2;
    public static CountDownLatch cd3;

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Semaphore semaphore = new Semaphore(2, true);
        Race race = new Race(new Road(60), new Tunnel(semaphore), new Road(40));
        Car[] cars = new Car[CARS_COUNT];

        cd1 = new CountDownLatch(CARS_COUNT);
        cd2 = new CountDownLatch(1);
        cd3 = new CountDownLatch(CARS_COUNT);

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        cd1.await();
        cd2.countDown();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        cd3.await();
        System.out.println("Победитель: " + firstPlace.getName());
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}