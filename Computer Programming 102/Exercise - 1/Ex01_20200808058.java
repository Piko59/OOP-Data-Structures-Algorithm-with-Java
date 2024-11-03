import java.util.Random;
import java.util.Scanner;

public class Ex01_20200808058 {
    public static void main(String[] args) {
        System.out.print("Enter dimensions of matrix to create: ");
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        int n = scanner.nextInt();

        double[][] matrix = makeMatrix(m, n);

        System.out.println();
        printMatrix(matrix);
        System.out.println();

        Locate location1 = locateMax(matrix);
        System.out.println("maxValue: " + location1.maxValue + " is at (" + location1.row + ", " + location1.column + ")");

        System.out.println("-------------------------------------------------------");
        matrix = getMatrix(m, n);

        System.out.println();
        printMatrix(matrix);
        System.out.println();

        Locate location2 = locateMax(matrix);
        System.out.println("maxValue: " + location2.maxValue + " is at (" + location2.row + ", " + location2.column + ")");

    }

    public static Locate locateMax(double[][] matrix) {
        double maxElement = Integer.MIN_VALUE;
        int row = 0;
        int column = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > maxElement) {
                    maxElement = matrix[i][j];
                    row = i;
                    column = j;
                }
            }
        }
        Locate locate = new Locate(row,column,maxElement);
        return locate;
    }

    public static double[][] makeMatrix(int rows, int columns) {
        double[][] newArray = new double[rows][columns];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                newArray[i][j] = -5 + (Math.random() * 10);
            }
        }
        return newArray;
    }

    public static double[][] getMatrix(int rows, int columns) {
        double[][] newArray = new double[rows][columns];
        Scanner scanner = new Scanner(System.in);
        String s;
        for(int i = 0; i < rows; i++){
            if ((i + 1) % 10 == 1 && !(i == 11))
                s = "st";
            else if ((i + 1) % 10 == 2 && !(i == 12))
                s = "nd";
            else if ((i + 1) % 10 == 3 && !(i == 13))
                s = "rd";
            else
                s = "th";
            System.out.print((i + 1) + s + " row: ");
            for(int j = 0; j < columns; j++){
                newArray[i][j] = scanner.nextDouble();
            }
        }
        return newArray;
    }

    public static void printMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%8.2f",matrix[i][j]);
            }
            System.out.println();
        }
    }
}

class Locate {
    public int row = 0;
    public int column = 0;
    public double maxValue = 0;
    Locate(){
    }
    Locate(int row,int column,double maxValue){
        this.row = row;
        this.column = column;
        this.maxValue = maxValue;
    }
}