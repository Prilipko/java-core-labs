package procedural.loop.matrix_mul;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: worker
 * Date: 14.08.13
 * Time: 21:31
 * To change this template use File | Settings | File Templates.
 */
public class MatrixUtils {
    public static void main(String[] args) {
        int[][][][] matrixes = {//all pair
                {//one pair
                        {//matrix
                                {1,3},
                                {2,4},
                        } ,
                        {
                                {0,1},
                                {5,6},
                        }
                },
                {//one pair
                        {//matrix
                                {1},
                                {2},
                                {3},
                        } ,
                        {
                                {1,2,3},
                        }
                },
                {//one pair
                        {//matrix
                                {1,2,3},
                        } ,
                        {
                                {1},
                                {2},
                                {3},
                        }
                },
        };
        for(int[][][] pair : matrixes){
            int[][] result = mul(pair[0], pair[1]);
            for(int[] arr: result)
            System.out.println(Arrays.toString(arr));
            System.out.println();
        }
    }

//Напишите метод, умножающий две 2-мерные квадратные матрицы.
//        Метод должен иметь вид
//public class MatrixUtils {
//    public static int[][] mul(int[][] a, int[][] b) {...}
//}
//
//Произведение двух двумерных квадратных матриц A и B размером
//NxN - это матрица С размером NxN, где каждый элемент
//C[i][j] высчитывается по формуле:
//C[i][j] = A[i][0]*B[0][j] + A[i][1]*B[1][j] + ... + A[i][N-1]*B[N-1][j]
//Пример:
//|1 3|   |0 1|   |15 19|
//|2 4| * |5 6| = |20 26|, так как
//1*0 + 3*5 = 15
//1*1 + 3*6 = 19
//2*0 + 4*5 = 20
//2*1 + 4*6 = 26
//Подсказка: вам необходим тройной вложенный цикл.
//Примечание: задачу предложил Дмитрий Бабак.

    public static int[][] mul(int[][] a, int[][] b) {
        int iMax= a.length;
        int jMax= b[0].length;
        int deep = b.length;
        int[][] result = new int[iMax][jMax];
        for(int i=0;i<iMax;i++){
            for (int j=0;j<jMax;j++){
                for(int k=0;k<deep;k++){
                    result[i][j]+= a[i][k]*b[k][j];
                }
            }
        }
        return result;
    }
}