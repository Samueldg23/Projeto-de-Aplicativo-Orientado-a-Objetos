public class ValidadorDados {
    private static final String EMAIL_REGEX = "^[\\w.-]+@[\\w.-]+\\.\\w{2,}$";
    private static final String SENHA_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
    private static final String CPF_REGEX = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$";
    
    public static boolean validarEmail(String email) {
        return email != null && email.matches(EMAIL_REGEX);
    }

    public static boolean validarSenha(String senha) {
        return senha != null && senha.matches(SENHA_REGEX);
    }

    public static boolean validarCPF(String cpf) {
        return cpf != null && cpf.matches(CPF_REGEX);
    }

    // Implemente os outros validadores
}