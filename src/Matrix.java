import java.awt.geom.Arc2D;
import java.util.Arrays;
import java.util.Scanner;

public class Matrix <T> {
    private T[][] mass;

    public T[][] getMass() {
        return mass;
    }

    public void setMass(T[][] mass) {
        this.mass = mass;
    }

    public Matrix(T[][] mass) {
        this.mass = mass;
    }

    public static Scanner sc = new Scanner(System.in);
    public static Integer x = 0;

    public static Integer[][] createmass() {
        int r, c, index = 0;
        System.out.print("Введите кол-во строк :\n> ");
        r = sc.nextInt();
        System.out.print("Введите кол-во столбцов:\n> ");
        c = sc.nextInt();
        Integer[][] array = new Integer[r][c];
        System.out.println("Двумерный массив:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                array[i][j] = (int) (Math.random() * 10);
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        return array;
    }

    public static Double[][] createmassDouble() {
        int r, c, index = 0;
        System.out.print("Введите кол-во строк :\n> ");
        r = sc.nextInt();
        System.out.print("Введите кол-во столбцов:\n> ");
        c = sc.nextInt();
        Double[][] array = new Double[r][c];
        System.out.println("Двумерный массив:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                array[i][j] = (Math.random() * 10);
                System.out.printf("%2.2f  ",array[i][j]);
            }
            System.out.println();
        }
        return array;
    }

    public static Integer[][] createmassKeyboard() {
        int r, c, index = 0;
        System.out.print("Введите кол-во строк :\n> ");
        r = sc.nextInt();
        System.out.print("Введите кол-во столбцов:\n> ");
        c = sc.nextInt();
        Integer[][] array = new Integer[r][c];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print("Введите число:\n> ");
                array[i][j] = sc.nextInt();
            }
        }
        return array;
    }

    public <T> T[][] multiplicationMatrix() {
        System.out.print("На какое число умножить матрицу?\n");
        x = sc.nextInt();
        if (mass instanceof Integer[][]) {
            Integer[][] multMatrix = new Integer[mass.length][mass[0].length];
            for (int i = 0; i < mass.length; i++) {
                for (int j = 0; j < mass.length; j++) {
                    multMatrix [i][j] = (Integer) mass[i][j] * x;
                }
            }
            return (T[][]) multMatrix;
        } else if (mass instanceof Double[][]) {
            Double[][] multMatrix = new Double [mass.length][mass[0].length];
            for (int i = 0; i < mass.length; i++) {
                for (int j = 0; j < mass.length; j++) {
                    multMatrix [i][j] = (Double) mass[i][j] * x;
                }
            }
            return (T[][]) multMatrix;
        }
        throw new IllegalArgumentException("Error");
    }

    public <T> T[][] additionMatrix() {
        System.out.print("Какое число прибавить к элементам матрицы?\n");
        x = sc.nextInt();
        if (mass instanceof Integer[][]) {
            Integer[][] addMatrix = new Integer[mass.length][mass[0].length];
            for (int i = 0; i < mass.length; i++) {
                for (int j = 0; j < mass.length; j++) {
                    addMatrix [i][j] = (Integer) mass [i][j] + x;
                }
            }
            return (T[][]) addMatrix;
        } else if (mass instanceof Double[][]) {
            Double[][] addMatrix = new Double [mass.length][mass[0].length];
            for (int i = 0; i < mass.length; i++) {
                for (int j = 0; j < mass.length; j++) {
                    addMatrix [i][j] = (Double) mass[i][j] + x;
                }
            }
            return (T[][]) addMatrix;
        }
        throw new IllegalArgumentException("Error");
    }

    public <T> T[][] subtractionMatrix() {
        System.out.print("Какое число отнять от элементов матрицы?\n");
        x = sc.nextInt();
        if (mass instanceof Integer[][]) {
            Integer[][] subMatrix = new Integer[mass.length][mass[0].length];
            for (int i = 0; i < mass.length; i++) {
                for (int j = 0; j < mass.length; j++) {
                    subMatrix [i][j] = (Integer) mass[i][j] - x;
                }
            }
            return (T[][]) subMatrix;
        } else if (mass instanceof Double[][]) {
            Double[][] subMatrix = new Double [mass.length][mass[0].length];
            for (int i = 0; i < mass.length; i++) {
                for (int j = 0; j < mass.length; j++) {
                    subMatrix [i][j] = (Double) mass[i][j] - x;
                }
            }
            return (T[][]) subMatrix;
        }
        throw new IllegalArgumentException("Error");
    }

    @Override
    public String toString() {
        return "Matrix{" +
                "mass=" + Arrays.toString(mass) +
                '}';
    }

    public void avg () {
        double sum = 0;
        double avg;
        if (mass instanceof Integer[][]) {
            for (int i = 0; i < mass.length; i++) {
                for (int j = 0; j < mass.length; j++) {
                    sum += (Integer) mass [i][j];
                }
            }
        } else  if (mass instanceof Double[][]) {
            for (int i = 0; i < mass.length; i++) {
                for (int j = 0; j < mass.length; j++) {
                    sum += (Double) mass [i][j];
                }
            }
        }
        avg = sum / mass.length / mass[0].length;
        System.out.printf("Среднее значение массива: "+"%2.2f  ",avg);
    }

    public void max_min () {
        if (mass instanceof Integer[][]) {
            int y;
            int max = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < mass.length; i++) {
                for (int j = 0; j < mass.length; j++) {
                    y = (Integer) mass [i][j];
                    if (y > max) {
                        max = y;
                    } else if(y < min) {
                        min = y;
                    }
                }
            }
            System.out.println("Максимальное значение: " + max + "\nМинимальное значение: " + min);

        } else  if (mass instanceof Double[][]) {
            double y;
            double max = 0;
            double min = Double.MAX_VALUE;
            for (int i = 0; i < mass.length; i++) {
                for (int j = 0; j < mass.length; j++) {
                    y = (Double) mass [i][j];
                    if (y > max) {
                        max = y;
                    } else if(y < min) {
                        min = y;
                    }
                }
            }
            System.out.printf("Максимальное значение: " + "%2.2f  \n", max);
            System.out.printf("Минимальное значение: " + "%2.2f  ", min);
        }

    }



//    public static <T> T[][] multiplication(T array[][]) {
//        System.out.print("На какое число умножить матрицу?\n");
//        x = sc.nextInt();
//        if (array[0][0] instanceof Integer) {
//            Integer[][] array1 = new Integer[array.length][array[0].length];
//            for (int i = 0; i < array.length; i++) {
//                for (int j = 0; j < array.length; j++) {
//                    array1[i][j] = (Integer) (array[i][j]) * x;
//                }
//            }
//            return (T[][]) array1;
//        } else if (array[0][0] instanceof Double) {
//            Double[][] array2 = new Double[array.length][array[0].length];
//            for (int i = 0; i < array.length; i++) {
//                for (int j = 0; j < array.length; j++) {
//                    array2[i][j] = (Double) (array[i][j]) * x;
//                }
//            }
//            return (T[][]) array2;
//        }
//        throw new IllegalArgumentException("Error");
//    }
//
//    public static <T> T[][] addition(T array[][]) {
//        System.out.print("Какое число прибавить к элементам матрицы?\n");
//        x = sc.nextInt();
//        if (array[0][0] instanceof Integer) {
//            Integer[][] array1 = new Integer[array.length][array[0].length];
//            for (int i = 0; i < array.length; i++) {
//                for (int j = 0; j < array.length; j++) {
//                    array1[i][j] = (Integer) (array[i][j]) + x;
//                }
//            }
//            return (T[][]) array1;
//        } else if (array[0][0] instanceof Double) {
//            Double[][] array2 = new Double[array.length][array[0].length];
//            for (int i = 0; i < array.length; i++) {
//                for (int j = 0; j < array.length; j++) {
//                    array2[i][j] = (Double) (array[i][j]) + x;
//                }
//            }
//            return (T[][]) array2;
//        }
//        throw new IllegalArgumentException("Error");
//    }
}
