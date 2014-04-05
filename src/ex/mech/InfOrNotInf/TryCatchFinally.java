package ex.mech.InfOrNotInf;

/**
 * Created with IntelliJ IDEA.
 * User: Prilipko
 * Date: 27.08.13
 * Time: 15:36
 * To change this template use File | Settings | File Templates.
 */

//ЗАДАНИЕ
//Для каждой из трех программ ниже укажите будет ли количество вызовов метода
//main(...) конечным или бесконечным. В случае конечного количества – предположите,
//что максимальная глубина стека вызовов равна 10 (одиннадцатый вызов приводит к
//StackOverflowError). Для каждой из программ приведите количество вызовов
//public class TryCatch {
//    public static void main(String[] args) {
//        try {
//            main(args);
//        } catch (StackOverflowError e) {
//            main(args);
//        }
//    }
//}
//
//public class TryFinally {
//    public static void main(String[] args) {
//        try {
//            main(args);
//        } finally {
//            main(args);
//        }
//    }
//}
//
//public class TryCatchFinally {
//    public static void main(String[] args) {
//        try {
//            main(args);
//        } catch (StackOverflowError e) {
//            main(args);
//        } finally {
//            main(args);
//        }
//    }
//}
//ПОДСКАЗКА: решение одной из задач содержится в книге “Java Puzzlers: Traps, Pitfalls,
//and Corner Cases” - Puzzle 45 (Exhausting Workout).


public class TryCatchFinally {
}

//n=10;
//TryCatch : (2^(n+1))-1 = 2047
//TryFinally : (2^(n+1))-1 = 2047
//TryCatchFinally : (3^(n+1))-1 = 177146
