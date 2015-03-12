package thread.thread.rabbit_attack;

public class RabbitLab {
    public static void main(String[] args) {
        new Thread(new RabbitPrinter()).start();
    }
}