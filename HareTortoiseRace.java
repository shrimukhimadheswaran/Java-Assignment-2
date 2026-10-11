
class Racer extends Thread {
    static volatile boolean raceOver = false;
    static String winner = "";

    int distance = 0;
    boolean isHare;
    boolean makeHareSleep;

    Racer(String name, boolean isHare,
          boolean makeHareSleep) {
        super(name);
        this.isHare = isHare;
        this.makeHareSleep = makeHareSleep;
    }

    public void run() {
        try {
            while (distance < 100 && !raceOver) {
                distance++;

                System.out.println(getName()
                        + " ran " + distance + " meters");

                if (isHare && makeHareSleep
                        && distance == 60) {
                    System.out.println(
                            "Hare is sleeping for 1000 ms");
                    Thread.sleep(1000);
                }

                Thread.sleep(10);
            }

            if (distance >= 100) {
                synchronized (Racer.class) {
                    if (!raceOver) {
                        raceOver = true;
                        winner = getName();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println(getName()
                    + " thread interrupted");
        }
    }
}

public class HareTortoiseRace {
    public static void main(String[] args)
            throws InterruptedException {

        // Change to true for part (c)
        boolean makeHareSleep = false;

        Racer.raceOver = false;
        Racer.winner = "";

        Racer hare = new Racer(
                "Hare", true, makeHareSleep);

        Racer tortoise = new Racer(
                "Tortoise", false, makeHareSleep);

        // Part (b): give Hare higher priority
        hare.setPriority(Thread.MAX_PRIORITY);
        tortoise.setPriority(Thread.MIN_PRIORITY);

        hare.start();
        tortoise.start();

        hare.join();
        tortoise.join();

        System.out.println("Winner is: " + Racer.winner);
    }
}
