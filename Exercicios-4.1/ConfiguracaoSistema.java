public class ConfiguracaoSistema {
    private static ConfiguracaoSistema instance;

    private String urlServidor;
    private int porta;
    private boolean ativo;

    private ConfiguracaoSistema() {
        this.urlServidor = "localhost";
        this.porta = 8080;
        this.ativo = true;
    }

    public static ConfiguracaoSistema getInstance() {
        if (instance == null) {
            instance = new ConfiguracaoSistema();
        }
        return instance;
    }

    public String getUrlServidor() {
        return urlServidor;
    }

    public int getPorta() {
        return porta;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setUrlServidor(String urlServidor) {
        if (urlServidor == null || urlServidor.trim().isEmpty()) {
            throw new IllegalArgumentException("A URL do servidor não pode ser vazia.");
        }
        this.urlServidor = urlServidor;
    }

    public void setPorta(int porta) {
        if (porta < 1024 || porta > 65535) {
            throw new IllegalArgumentException("A porta deve estar entre 1024 e 65535.");
        }
        this.porta = porta;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
