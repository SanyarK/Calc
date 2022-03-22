import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Арабо-римский калькулятор до 10. Введите пример: 1 + 1 или I + I");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String num1 , operation, num2;
        String []data=reader.readLine().split(" ");
        num1 = data[0];
        operation = data[1];
        num2 = data[2];
        System.out.println(calc(num1, operation, num2));

    }


    private static boolean validate(String num) {
        for (char c : num.toCharArray()) {
            if (!Character.isDigit(c)) return false; // если введеная строка не число выводит фалсе
        }
        return true;
    }


    private static String calc(String num1, String operation, String num2) {
        if (validate(num1) && validate(num2)) { // если ввели в консоль цифру то
            String res = "";
            int result = 0;
            int strnum1 = Integer.parseInt(num1); // меняет на инт со стринг
            int strnum2 = Integer.parseInt(num2);

            if (strnum1 > 0 && strnum1 <= 10 && strnum2 > 0 && strnum2 < 10) {
                if (operation.equals("+")) {
                    result = strnum1 + strnum2;
                    res = String.valueOf(result);
                    return res;
                }
                if (operation.equals("-")) {
                    result = strnum1 - strnum2;
                    res = String.valueOf(result);
                    return res;
                }

                if (operation.equals("*")) {
                    result = strnum1 * strnum2;
                    res = String.valueOf(result);
                    return res;
                }
                if (operation.equals("/")) {
                    result = strnum1 / strnum2;
                    res = String.valueOf(result);
                    return res;
                }
            } else {
                System.out.println("Вы ввели цифру больше 10");
            }
        } else {
            try {
                if (getArab(num1) > 0 && getArab(num1) <= 10 && getArab(num2) > 0 && getArab(num2) <= 10) {
                    String res = "";
                    int result = 0;
                    if (operation.equals("+")) {
                        result = getArab(num1) + getArab(num2);
                        res = getRim(result);
                    }
                    if (operation.equals("-")) {
                        result = getArab(num1) - getArab(num2);
                        res = getRim(result);
                    }

                    if (operation.equals("*")) {
                        result = getArab(num1) * getArab(num2);
                        res = getRim(result);
                    }
                    if (operation.equals("/")) {
                        result = getArab(num1) / getArab(num2);
                        res = getRim(result);
                    }
                    return res;

                } else {
                    System.out.println("Вы ввели цифру больше X или арабскую с римским");
                }
            } catch (InputMismatchException e) {
                System.out.println("Проверьте правильность написания вычесления");
            }
            }

        return "";
    }

    private static String getRim ( int num){ // сюда вводим число который должен конвертировать
        ArrayList<Integer> list = new ArrayList<>(); // список (коллекция)
        String st = "";
        while (num > 0) {
            int x = num % 10;
            list.add(x); // добавил деленный остаток в список под название лист
            num = num / 10;
        }
        for (String s : Converter.getRim(list)) {
            st = st + s; // по одному выводит и прибавляет друг другу
        }
        return st;
    }

    private static int getArab(String num){ // этот метод преобразует из римского в арабское

        int number = 1;
        while (number < 101) {
            if (num.equals(getRim(number))) { // если num = number
                break;
            }
            number++;
        }
        return number;

    }

}







