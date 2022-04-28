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


    public static <T> T[][] multiplication(T array[][]) {
        System.out.print("На какое число умножить матрицу?\n");
        x = sc.nextInt();
        if (array[0][0] instanceof Integer) {
            Integer[][] array1 = new Integer[array.length][array[0].length];
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    array1[i][j] = (Integer) (array[i][j]) * x;
                }
            }
            return (T[][]) array1;
        } else if (array[0][0] instanceof Double) {
            Double[][] array2 = new Double[array.length][array[0].length];
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    array2[i][j] = (Double) (array[i][j]) * x;
                }
            }
            return (T[][]) array2;
        }
        throw new IllegalArgumentException("Error");
    }

    public static <T> T[][] addition(T array[][]) {
        System.out.print("Какое число прибавить к элементам матрицы?\n");
        x = sc.nextInt();
        if (array[0][0] instanceof Integer) {
            Integer[][] array1 = new Integer[array.length][array[0].length];
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    array1[i][j] = (Integer) (array[i][j]) + x;
                }
            }
            return (T[][]) array1;
        } else if (array[0][0] instanceof Double) {
            Double[][] array2 = new Double[array.length][array[0].length];
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    array2[i][j] = (Double) (array[i][j]) + x;
                }
            }
            return (T[][]) array2;
        }
        throw new IllegalArgumentException("Error");
    }
}
