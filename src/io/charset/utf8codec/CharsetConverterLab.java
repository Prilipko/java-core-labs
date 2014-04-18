
/**
 * Created by Worker on 17.04.14.
 */
/*

ЗАДАНИЕ
Необходимо реализовать методы
public static byte[] convertCodepointToUTF8(int[] codePoint) и
public static int[] convertUTF8toCodepoint(byte[] utf8)
которые преобразуют массив "номеров символов" (codepoint[])
в Unicode в byte[]
ПРОВЕРКА
:
Ваша реализация корректна, если
выводит
>>"OK: CodePoint-> UTF8"
>>"OK: UTF8-> CodePoint"
ЗАМЕЧАНИЯ:-
В районе 55000 <= codePoints <= 58000 наблюдается странное поведение,
этот диапазон в тесте не учитывается-
В режиме разработки рекомендуется начать с малых номеров константы
public static final int MAX_CODE_POINT
, скажем 100, потом 1000 , потом ...
КОД:
import java.util.Arrays;
import
java.util.Random;
import static java.nio.charset.StandardCharsets.UTF_8;
pu
blic class CharsetConverterLab
{
public static final int TEST_COUNT = 1_000_000;
public static final int MIN_STR_LEN = 3;
public static final int MAX_STR_LEN = 10;
public static final int MAX_CODE_POINT = Character.MAX_CODE_POINT;
public static void main(String[] args) {
testCodepointToUTF8();
testUTF8toCodepoint();
}
public static void testUTF8toCodepoint() {
Random rnd = new
Random(0);
for (int k = 0; k < TEST_COUNT; k++) {
int len = MIN_STR_LEN + rnd.nextInt(MAX_STR_LEN
-
MIN_STR_LEN + 1);
int[] codePoints = new int[len];
for (int i = 0; i < len; i++) {
do {
codePoints[i] = rnd.nextInt(MAX_CODE_POINT + 1);
}
while (55000 <= codePoints[i] && codePoints[i] <= 58000);
}
String str = new String(codePoints, 0, codePoints.length);
byte[] utf8 = str.getBytes(UTF_8);
int[] actualCodepoint = convertUTF8toCodepoint(utf8);
if (!Arrays.equals(actualCodepoint, codePoints)) {
throw new AssertionError("actualCodepoint=" + Arrays.toString(actualCodepo
int) +
" is not equal expectedCodepoint=" + Arrays.toString(codePoints));
}
}
System.out.println("OK: UTF8
-
> CodePoint");
}
public static int[] convertUTF8toCodepoint(byte[] utf8) {
throw new UnsupportedOperati
onException("Realize me!");
}
public static void testCodepointToUTF8() {
Random rnd = new Random(0);
for (int k = 0; k < TEST_COUNT; k++) {
int len = MIN_STR_LEN + rnd.nextInt(MAX_STR_LEN
-
MIN_STR_LEN + 1);
int[] codePoints = new int[len];
for (int i = 0; i < len; i++) {
do {
codePoints[i] = rnd.nextInt(MAX_CODE_POINT + 1);
}
while (55000 <= codePoints[i] && codePoints[i] <= 5800
0);
}
String str = new String(codePoints, 0, codePoints.length);
byte[] utf8 = str.getBytes(UTF_8);
byte[] actualUFT8 = convertCodepointToUTF8(codePoints);
if (!Arrays.equals(actualUFT8, utf8)) {
throw new AssertionError("actualUFT8=" + Arrays.toString(actualUFT8) + " is not
equal utf8=" + Arrays.toString(utf8));
}
}
System.out.println("OK: CodePoint
-
> UTF8");
}

 */

package io.charset.utf8codec;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Random;

import static java.nio.charset.StandardCharsets.UTF_8;

public class CharsetConverterLab {
    public static final int TEST_COUNT = 1_000_000;
    public static final int MIN_STR_LEN = 3;
    public static final int MAX_STR_LEN = 10;
    public static final int MAX_CODE_POINT = Character.MAX_CODE_POINT;

    public static void main(String[] args) {
        testCodepointToUTF8();
        testUTF8toCodepoint();
    }

    public static void testUTF8toCodepoint() {
        Random rnd = new Random(0);
        for (int k = 0; k < TEST_COUNT; k++) {
            int len = MIN_STR_LEN + rnd.nextInt(MAX_STR_LEN - MIN_STR_LEN + 1);
            int[] codePoints = new int[len];
            for (int i = 0; i < len; i++) {
                do {
                    codePoints[i] = rnd.nextInt(MAX_CODE_POINT + 1);
                }
                while (55000 <= codePoints[i] && codePoints[i] <= 58000);
            }
            String str = new String(codePoints, 0, codePoints.length);
            byte[] utf8 = str.getBytes(UTF_8);
            int[] actualCodepoint = convertUTF8toCodepoint(utf8);
            if (!Arrays.equals(actualCodepoint, codePoints)) {
                throw new AssertionError("actualCodepoint=" + Arrays.toString(actualCodepoint) +
                        " is not equal expectedCodepoint=" + Arrays.toString(codePoints));
            }
        }
        System.out.println("OK: UTF8 -> CodePoint");
    }

    public static int[] convertUTF8toCodepoint(byte[] utf8) {
        int[] maxCodepointArray = new int[utf8.length];
        int indexCodepoint = 0;
        int indexUtf8 = 0;
        for (; indexCodepoint < maxCodepointArray.length && indexUtf8 < utf8.length ; indexCodepoint++) {
            byte startUTF8Byte = utf8[indexUtf8];
            int resultCodepoint;
            if ((startUTF8Byte & 0b10000000) == 0) {//1 byte
                resultCodepoint = startUTF8Byte;
                indexUtf8++;
            } else if ((startUTF8Byte & 0b11100000) == 0b11000000) {//2 bytes
                resultCodepoint = utf8[indexUtf8 + 1] & 0b00111111;
                resultCodepoint |= (startUTF8Byte & 0b00011111) << 6;
                indexUtf8 += 2;
            } else if ((startUTF8Byte & 0b11110000) == 0b11100000) {//3 bytes
                resultCodepoint = utf8[indexUtf8 + 2] & 0b00111111;
                resultCodepoint |= (utf8[indexUtf8 + 1] & 0b00111111) << 6;
                resultCodepoint |= (startUTF8Byte & 0b00001111) << 12;
                indexUtf8 += 3;
            } else if ((startUTF8Byte & 0b11111000) == 0b11110000) {//4 bytes
                resultCodepoint = utf8[indexUtf8 + 3] & 0b00111111;
                resultCodepoint |= (utf8[indexUtf8 + 2] & 0b00111111) << 6;
                resultCodepoint |= (utf8[indexUtf8 + 1] & 0b00111111) << 12;
                resultCodepoint |= (startUTF8Byte & 0b00000111) << 18;
                indexUtf8 += 4;
            } else if ((startUTF8Byte & 0b11111100) == 0b11111000) {//5 bytes
                resultCodepoint = utf8[indexUtf8 + 4] & 0b00111111;
                resultCodepoint |= (utf8[indexUtf8 + 3] & 0b00111111) << 6;
                resultCodepoint |= (utf8[indexUtf8 + 2] & 0b00111111) << 12;
                resultCodepoint |= (utf8[indexUtf8 + 1] & 0b00111111) << 18;
                resultCodepoint |= (startUTF8Byte & 0b00000011) << 24;
                indexUtf8 += 5;
            } else if ((startUTF8Byte & 0b11111110) == 0b11111100) {//6 bytes
                resultCodepoint = utf8[indexUtf8 + 5] & 0b00111111;
                resultCodepoint |= (utf8[indexUtf8 + 4] & 0b00111111) << 6;
                resultCodepoint |= (utf8[indexUtf8 + 3] & 0b00111111) << 12;
                resultCodepoint |= (utf8[indexUtf8 + 2] & 0b00111111) << 18;
                resultCodepoint |= (utf8[indexUtf8 + 1] & 0b00111111) << 24;
                resultCodepoint |= (startUTF8Byte & 0b00000001) << 30;
                indexUtf8 += 6;
            } else {
                resultCodepoint = 0;
            }
            maxCodepointArray[indexCodepoint] = resultCodepoint;
        }
        if (maxCodepointArray.length != indexCodepoint) {
            return Arrays.copyOf(maxCodepointArray, indexCodepoint );
        } else {
            return maxCodepointArray;
        }
    }

    public static void testCodepointToUTF8() {
        Random rnd = new Random(0);
        for (int k = 0; k < TEST_COUNT; k++) {
            int len = MIN_STR_LEN + rnd.nextInt(MAX_STR_LEN
                    -
                    MIN_STR_LEN + 1);
            int[] codePoints = new int[len];
            for (int i = 0; i < len; i++) {
                do {
                    codePoints[i] = rnd.nextInt(MAX_CODE_POINT + 1);
                }
                while (55000 <= codePoints[i] && codePoints[i] <= 58000);
            }
            String str = new String(codePoints, 0, codePoints.length);
            byte[] utf8 = str.getBytes(UTF_8);
            byte[] actualUFT8 = convertCodepointToUTF8(codePoints);
            if (!Arrays.equals(actualUFT8, utf8)) {
                throw new AssertionError("actualUFT8=" + Arrays.toString(actualUFT8) +
                        " is notequal utf8=" + Arrays.toString(utf8));
            }
        }
        System.out.println("OK: CodePoint -> UTF8");
    }

    public static byte[] convertCodepointToUTF8(int[] codePoint) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            for (int code : codePoint) {
                CodePointToUTF8(baos, code);
            }
            baos.flush();
            return baos.toByteArray();
        } catch (IOException e) {
            //NOP
        }
        return new byte[]{};
    }

    private static void CodePointToUTF8(OutputStream os, int code) throws IOException {
        if ((code & 0b01111111) == code) { // 1 byte
            os.write(code);
        } else if ((code & 0b0111_11111111) == code) {// 2 byte
            os.write(0b11000000 | code >>> 6);
            os.write(code & 0b00111111 | 0b10000000);
        } else if ((code & 0b11111111_11111111) == code) {// 3 byte
            os.write(0b11100000 | code >>> 12);
            os.write(code >>> 6 & 0b00111111 | 0b10000000);
            os.write(code & 0b00111111 | 0b10000000);
        } else if ((code & 0b00011111_11111111_11111111) == code) {// 4 byte
            os.write(0b11110000 | code >>> 18);
            os.write(code >>> 12 & 0b00111111 | 0b10000000);
            os.write(code >>> 6 & 0b00111111 | 0b10000000);
            os.write(code & 0b00111111 | 0b10000000);
        } else if ((code & 0b00000011_11111111_11111111_11111111) == code) {// 5 byte
            os.write(0b11111000 | code >>> 24);
            os.write(code >>> 18 & 0b00111111 | 0b10000000);
            os.write(code >>> 12 & 0b00111111 | 0b10000000);
            os.write(code >>> 6 & 0b00111111 | 0b10000000);
            os.write(code & 0b00111111 | 0b10000000);
        } else if ((code & 0b01111111_11111111_11111111_11111111) == code) {// 6 byte
            os.write(0b11111100 | code >>> 30);
            os.write(code >>> 26 & 0b00111111 | 0b10000000);
            os.write(code >>> 18 & 0b00111111 | 0b10000000);
            os.write(code >>> 12 & 0b00111111 | 0b10000000);
            os.write(code >>> 6 & 0b00111111 | 0b10000000);
            os.write(code & 0b00111111 | 0b10000000);
        }
    }
}