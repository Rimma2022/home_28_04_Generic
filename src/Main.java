import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static <E> E minVal (E v1, E v2, E v3) {
        E min;
        if (v1 instanceof Integer && v2 instanceof Integer && v3 instanceof Integer ) {
            min = (E) new Integer (Math.min(Math.min((Integer)v1, (Integer)v2), (Integer)v3));
            return min;
        } else if (v1 instanceof String && v2 instanceof String && v3 instanceof String) {
            int lenStr1 = String.valueOf(v1).length();
            int lenStr2 = String.valueOf(v2).length();
            int lenStr3 = String.valueOf(v3).length();
            System.out.println("Длина самой короткой строки " + Math.min(Math.min(lenStr1, lenStr2), lenStr3));
            System.out.println("Самая короткая строка при сравнении по символам: ");
            if (((String) v1).compareTo((String) v2) < 0 && ((String) v1).compareTo((String) v3) < 0) {
                return v1;
            } else if (((String) v2).compareTo((String) v1) < 0 && ((String) v2).compareTo((String) v3) < 0) {
                return v2;
            }
            else {
                return v3;
            }
        }  else if (v1 instanceof Double && v2 instanceof Double && v3 instanceof Double) {
            min = (E) new Double (Math.min(Math.min((double) v1, (double) v2), (double) v3));
            return min;
        }
        throw new IllegalArgumentException("Error");
    }

    public static <E> E maxVal (E[] mass) {
        E max;
        for (int i = 0; i < mass.length; i++) {
            if (mass[i] instanceof Integer) {
                Arrays.sort(mass);
            } else if (mass[i] instanceof Double) {
                Arrays.sort(mass);
            } else if (mass[i] instanceof Character) {
                Arrays.sort(mass);
            } else if (mass[i] instanceof String) {
                Arrays.sort(mass, new Comparator<E>() {
                    @Override
                    public int compare(E o1, E o2) {
                        return ((String)o1).length() == ((String)o2).length() ? 0 : ((String)o1).length() > ((String)o2).length() ? 1 : -1;
                    }
                });
                Arrays.sort(mass, new Comparator<E>() {
                    @Override
                    public int compare(E o1, E o2) {
                        return  ((String)o1).compareTo(((String)o2));
                    }
                });
            }
        }
        max = mass [mass.length-1];
        return max;
    }

    public static void main(String[] args) {
        // Задача 2
        //Напишите общий метод, который возвращает минимальное значение из
        //трех переданных параметров.

        double min1 = Main.minVal(5.6, 6.0, 9.0);
        System.out.println(min1);
        int min2 = Main.minVal(5, 6, 9);
        System.out.println(min2);
        String min3 = Main.minVal("jggh", "bjjmgvg", "n");
        System.out.println(min3);
        // Задача 4
        //Реализуйте общий метод для поиска максимального значение в массиве.
        Integer [] mas = {1, 5, 7, 0, 2, 10};
        int m = maxVal(mas);
        System.out.println(m);
        Double [] mas1 = {1.6, 5.7, 7.9, 0.4, 2.0, 7.5};
        double m1 = maxVal(mas1);
        System.out.println(m1);
        Character[] mas2 = {'o', 'h', 'p', 'z'};
        char m2 = maxVal(mas2);
        System.out.println(m2);
        String [] mas3 = {"Rimmma", "K", "Vict", "oiu", "54"};
        Object m3 = maxVal(mas3);
        System.out.println(m3);

        /**
         * Задача 8
         * Создайте общий класс Matrix. Реализуйте следующее:
         * ■ заполнение матрицы с клавиатуры;
         * ■ заполнение матрицы случайными числами;
         * ■ арифметические операции +, -, *, / по правилам
         * работа с матрицами;
         * ■ поиск максимального и минимального элемента;
         * ■ расчет среднего значения
         */

        Integer [][] array1 = Matrix.createmass();
        Matrix masss1 = new Matrix(array1);
        Integer [][] array11 = (Integer[][]) masss1.multiplicationMatrix();
        System.out.println("Матрица после умножения: \n" + Arrays.deepToString(array11));
        Integer [][] array111 = ( Integer[][]) masss1.additionMatrix();
        System.out.println("Матрица после сложения: \n" + Arrays.deepToString(array111));
        Integer [][] array1111 = ( Integer[][]) masss1.subtractionMatrix();
        System.out.println("Матрица после вычитания: \n" + Arrays.deepToString(array1111));

        Double[][] array2 = Matrix.createmassDouble();
        Matrix masss2 = new Matrix(array2);
        Double [][] array22 = ( Double[][]) masss2.multiplicationMatrix();
        System.out.println("Матрица после умножения: \n" + Arrays.deepToString(array22));
        Double [][] array222 = ( Double[][]) masss2.additionMatrix();
        System.out.println("Матрица после сложения: \n" + Arrays.deepToString(array222));
        Double [][] array2222 = ( Double[][]) masss2.subtractionMatrix();
        System.out.println("Матрица после вычитания: \n" + Arrays.deepToString(array2222));

        masss1.avg();
        masss2.avg();

        masss1.max_min();
        masss2.max_min();





//        Integer[][] array1 = Matrix.multiplication(array);
//        System.out.println(Arrays.deepToString(array1));
//        Integer[][] array01 = Matrix.createmassKeyboard();
//        System.out.println(Arrays.deepToString(array01));
//        Double [][] array2 = Matrix.createmassDouble();
//        System.out.println(Arrays.deepToString(array2));

    }
}
