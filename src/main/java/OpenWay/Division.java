package OpenWay;

import java.util.Scanner;

public class Division {
    public static Double Division(Double x) {return 1/x;}



        public static void main(String[] args){
    Double x;
    Double y;
    Scanner sc = new Scanner(System.in);
    System.out.println("Введите значение");
    x = sc.nextDouble();
    y = Division(x);
    System.out.println("Результат вычисле1ния = " + y);
    }
}
