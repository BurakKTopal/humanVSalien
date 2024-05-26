import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException, ExecutionException {
        Creature human = new Human("Burak", 19, "Hasselt");
        Creature alien = new Alien("Bralien", 91, "Mars");
        human.marry(alien);
        Alien.BossAlien bossAlien = new Alien.BossAlien("Babus Topalus", 100, "Everywhere");
        bossAlien.saveAlienBoss();
        CompletableFuture<Alien.BossAlien> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5); // Simulate delay
                return Alien.BossAlien.readBossAlien();
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        // Continue performing other actions in the main thread
        System.out.println("Main thread is doing other work...");

        Alien.BossAlien newBoss = future.get();
        System.out.println(STR."The aura of the boss is: \{newBoss.getAura()}");
        // Prevent the main thread from exiting immediately
    }
}