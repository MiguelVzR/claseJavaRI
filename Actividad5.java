import java.util.Scanner;

public class Actividad5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce tres números:");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        sc.close();
        HiloAritmetico thread = new HiloAritmetico(a, b, c);
        thread.start();
    }
}

class HiloAritmetico extends Thread {
    private double a, b, c;

    public HiloAritmetico(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public void run() {
        double sum = a + b + c;
        double rest = a - b - c;
        double mult = a * b * c;
        //En el caso de que el resultado sea 0, se dejara como cero y 
        //en la decision de mas adelante se imprimira resultado no valido
        double div = (c != 0 ) ? (a / b / c) : 0.0;

        System.out.println("A + B + C = " + sum);
        System.out.println("A - B - C = " + rest);
        System.out.println("A * B * C = " + mult);

        if (c != 0) {
            System.out.println("A / B / C = " + div);
        } else {
            System.out.println("La división con cero en el denomidor no está permitida.");
        }
    }
}
