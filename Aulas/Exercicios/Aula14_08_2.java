import java.util.Scanner;

public class Aula14_08_2 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite uma frase: ");

        String fraseUsuario = scanner.nextLine();

        VerificaTamanhoFrase(fraseUsuario);
        
        System.out.println("Digite uma palavra que deseja procurar na frase inserida: ");

        String palavra = scanner.nextLine();

        VerificaPosseDeJavaNaFrase(fraseUsuario, palavra);

        ReverterFraseUsuario(sb, fraseUsuario);

        scanner.close();

    }

    private static void VerificaTamanhoFrase(String fraseUsuario) {

        System.out.println("O tamanho da frase é de: " + fraseUsuario.length() + " caracteres.");

    }

    private static void ReverterFraseUsuario(StringBuilder sb, String fraseUsuario) {

        var fraseBuild = sb.append(fraseUsuario);

        var fraseBuildReverse = fraseBuild.reverse();

        System.out.println("Esse é o texto normal: " + fraseBuild.toString());

        System.out.println("Esse é o texto revertido: " + fraseBuildReverse.toString());
    }

    private static void VerificaPosseDeJavaNaFrase(String fraseUsuario, String palavra) {
        
        Boolean temJavaNaFrase = false;

         temJavaNaFrase = fraseUsuario.toUpperCase().contains(palavra.toUpperCase());

         if (temJavaNaFrase) {

            System.out.println("A frase digitada pelo usuário possui a palavra: " + palavra);

        }
            else {

            System.out.println("A frase digitada pelo usuário não possui a palavra: " + palavra);
            }

    }
}
