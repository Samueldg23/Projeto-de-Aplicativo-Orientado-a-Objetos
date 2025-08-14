import java.util.Scanner;

public class aula14_08 {
	public static void main(String[] args) {
        double [] notas = new double[5];
        Scanner scanner = new Scanner(System.in);
        double soma = 0;
        System.out.println("Digite as notas do aluno:");

        for (int i = 0; i < notas.length; i++) {
            System.out.print("Nota " + (i + 1) + ": ");
            notas[i] = scanner.nextDouble();
        }
        
        for (double nota : notas) {
            soma += nota;
        }
        double media = soma / notas.length;
        for (int i = 0; i < notas.length; i++) {
            System.out.print(" Notas: " + notas[i]);
        }
        System.out.println("");
        System.out.println("Média do aluno: " + media);

        scanner.close();
    }
}
