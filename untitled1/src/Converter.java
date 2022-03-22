import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Converter {
    public static ArrayList<String> getRim(ArrayList<Integer> test) { //метод который возвращает массив из строк, на вход принимает инт
        ArrayList <String> convert = new ArrayList<>();
        Collections.reverse(test);
        for (int i = 0; i < test.size(); i++) { // size размер массива
            String s = "";
            int x = test.get(test.size() - i - 1); // возвращаешь последний элемент массива
            while(i==0) {
                s = switch(x) {
                    case 1 -> "I"; // case "II" -> 2
                    case 2 -> "II";
                    case 3 -> "III";
                    case 4 -> "IV";
                    case 5 -> "V";
                    case 6 -> "VI";
                    case 7 -> "VII";
                    case 8 -> "VIII";
                    case 9 -> "IX";
                    case 10 -> "X";
                    default -> "";
                };
                convert.add(s); // ложит число внутри конверта
                break;
            }
            while(i== 1) {
                s = switch (x) {
                case 1 -> "X";
                case 2 -> "XX";
                case 3 -> "XXX";
                case 4 -> "XL";
                case 5 -> "L";
                case 6 -> "LX";
                case 7 -> "LXX";
                case 8 -> "LXXX";
                case 9 -> "XC";
                case 0 -> "";
                default -> "";
            };
                convert.add(s);
                break;
            }

                while (i== 2) {
                    s = switch (x) {
                        case 1 -> "C";
                        default -> "";
                    };
                    convert.add(s);
                    break;
                }

            }
        Collections.reverse(convert); // Разворачивает конверт
        return convert;
        }
    }

