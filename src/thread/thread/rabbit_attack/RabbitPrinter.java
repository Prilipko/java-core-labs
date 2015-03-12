package thread.thread.rabbit_attack;

class RabbitPrinter implements Runnable {
    public void run() {
        System.out.println("New rabbit born!");
        int i = 0;
        while (i++<10) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new Thread(new RabbitPrinter()).start();
        }
    }
}