package thread.thread.play_the_accordion;

import thread.thread.PrintRunnable;

public class Lab_Thread_Thread_Play_The_Accordion {
    public static void main(String[] args) throws InterruptedException {
        Thread threadCoordinator = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int k = 0; k < 10; k++) {
                        // A + B
                        Runnable printerA = new PrintRunnable("A   .", 100);
                        Thread threadA = new Thread(printerA);
                        threadA.start();
                        Runnable printerB = new PrintRunnable(".   B", 99);
                        Thread threadB = new Thread(printerB);
                        threadB.start();
                        threadA.join();
                        threadB.join();
                        // C
                        System.out.println("-----");
                        Runnable printerC = new PrintRunnable("  C", 100);
                        Thread threadC = new Thread(printerC);
                        threadC.start();
                        threadC.join();
                        System.out.println("-----");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadCoordinator.start();
        threadCoordinator.join();
    }
}