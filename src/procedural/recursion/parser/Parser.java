package procedural.recursion.parser;

/**
 * Created with IntelliJ IDEA.
 * User: worker
 * Date: 14.08.13
 * Time: 22:47
 * To change this template use File | Settings | File Templates.
 */

//Это пример небольшого и ограниченного по функциональности
//парсера арифметических выражений.
//    Он умеет:
//1) встретив скобки с двух сторон - свести задачу к анализу
//содержимого скобок (пример:"(1+1)" -> "1+1", пример "(1+(2/3))" -> "1+(2/3)");
//2) встретив число-знак-XXX - свести задачу к анализу XXX
//(пример:"1*(10-3)" -> "(10-3)", пример "3+(2/(9+1))" -> "(2/(9+1)");
//
//    Задание: переписать его, что бы он ВМЕСТО пункта 2 дела пункт 2'
//2') встретив XXX-знак-число - сведил задачу к анализу XXX.
//(пример:"(10-3)*1" -> "(10-3)", пример "(2/(9+1))+3" -> "(2/(9+1)");
//
//    Предупреждение #1: это не полноценный парсер арифметических выражений,
//есть множество корректных выражений на которых он "падает" или
//вычисляет некорректно ("(1+1)+(1+1)", "-1", ...).
//
//    Предупреждение #2: в условиях лабораторной ожидается,
//что старые выражения вида число-знак-XXX больше на разбираются.

public class Parser {

    public static void main(String[] args) {
//        System.out.println(eval("123"));
//        System.out.println(eval("2*3"));
//        System.out.println(eval("2*(1+3)"));
//        System.out.println(eval("1+(5-2*(13/6))"));

        System.out.println(">> 123 = " + Parser.eval("123"));
        System.out.println(">> 2*3 = " + Parser.eval("2*3"));
        System.out.println(">> (1+3)*2 = " + Parser.eval("(1+3)*2"));
        System.out.println(">> ((13/6)*2-5)+1 = " + Parser.eval("((13/6)*2-5)+1"));
    }

    private static int eval(String expr) {
        return eval(expr, 0, expr.length());
    }

    private static int eval(String expr, int from, int to) {
        if (expr.charAt(to - 1) == ')') {
            return eval(expr, from + 1, to - 1);
        } else {
            int pos = to - 1;
            while (pos > from) {
                if (Character.isDigit(expr.charAt(pos))) {
                    pos--;
                } else {
                    int rightOperand = Integer.valueOf(expr.substring(pos + 1, to));
                    char operation = expr.charAt(pos);
                    int leftOperand = eval(expr, from, pos);
                    switch (operation) {
                        case '+':
                            return leftOperand + rightOperand;
                        case '-':
                            return leftOperand - rightOperand;
                        case '*':
                            return leftOperand * rightOperand;
                        case '/':
                            return leftOperand / rightOperand;
                    }
                }
            }
            return Integer.valueOf(expr.substring(from, to));
        }
    }
}