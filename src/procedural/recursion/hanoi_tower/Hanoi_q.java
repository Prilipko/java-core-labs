package procedural.recursion.hanoi_tower;

/**
 * Created with IntelliJ IDEA.
 * User: Prilipko
 * Date: 13.08.13
 * Time: 15:35
 * To change this template use File | Settings | File Templates.
 */
import java.util.Arrays;
import java.util.Stack;

public class Hanoi_q {

    public static void main(String[] args) {
        Stack<Integer> from = new Stack<>();
        Stack<Integer> help = new Stack<>();
        Stack<Integer> to = new Stack<>();
        from.push(3);
        from.push(2);
        from.push(1);

        System.out.println("From ->" + Arrays.toString(from.toArray()));
        System.out.println("Help ->" + Arrays.toString(help.toArray()));
        System.out.println("To   ->" + Arrays.toString(to.toArray()));

        exchange(from, help, to, from.size());
        System.out.println();

        System.out.println("From ->" + Arrays.toString(from.toArray()));
        System.out.println("Help ->" + Arrays.toString(help.toArray()));
        System.out.println("To   ->" + Arrays.toString(to.toArray()));

    }
//    public static void exchange(
//            Stack<Integer> from, Stack<Integer> help,
//            Stack<Integer> to, int count) {
//        if (count > 0) {
//            exchange(?, ?, ?, ?);
//            int biggest = from.pop();
//            to.push(biggest);
//            exchange(?, ?, ?, ?);
//        }
//    }
//Проставьте правильные аргументы методов в рекурсивных вызовах
//exchange (выделены жирным). Итоговый код должен корректно
//решать задачу о Ханойской башне.

    public static void exchange(
            Stack<Integer> from, Stack<Integer> help,
            Stack<Integer> to, int count) {
        if (count > 0) {
            exchange(from, to, help, count-1);
            int biggest = from.pop();
            to.push(biggest);
            exchange(help, from, to, count-1);
        }
    }


}