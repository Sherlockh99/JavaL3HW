package lesson5.stages;

import lesson5.Car;
import lesson5.ConsoleColors;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    Semaphore semaphore;

    public Tunnel(Semaphore semaphore) {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
        this.semaphore = semaphore;
    }
    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + ConsoleColors.RED + description + ConsoleColors.BLACK);
                semaphore.acquire();
                System.out.println(c.getName() + " начал этап: " + ConsoleColors.GREEN + description + ConsoleColors.BLACK);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + ConsoleColors.BLUE + description + ConsoleColors.BLACK);
                semaphore.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
