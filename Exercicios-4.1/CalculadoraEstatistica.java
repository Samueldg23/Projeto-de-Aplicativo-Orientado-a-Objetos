public class CalculadoraEstatistica {
    private static int totalCalculos = 0;

    static double calcularMedia(double[] numeros) {
        double soma = 0;
        for (double n : numeros) {
            soma += n;
        }
        totalCalculos++;
        return soma / numeros.length;
    }
    static double calcularMaximo(double[] numeros) {
        double maximo = Double.NEGATIVE_INFINITY;
        for (double n : numeros) {
            if (n > maximo) {
                maximo = n;
            }
        }
        totalCalculos++;
        return maximo;
    }

    static double calcularMinimo(double[] numeros) {
        double minimo = Double.POSITIVE_INFINITY;
        for (double n : numeros) {
            if (n < minimo) {
                minimo = n;
            }
        }
        totalCalculos++;
        return minimo;
    }
    
    public static int getTotalCalculos() {
        return totalCalculos;
    }

    static boolean validarArray(double[] numeros) {
        if (numeros == null || numeros.length == 0) {
            System.out.println("Array inválido.");
            return false;
        }
        return true;
    }
}