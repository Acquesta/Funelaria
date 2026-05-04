package br.com.funilaria.exceptions;

public class RegraDeNegocioException extends RuntimeException {

    private String campo;

    public RegraDeNegocioException(String campo, String mensagem) {
        super(mensagem); // O 'super' envia a mensagem para a classe mãe (RuntimeException)
        this.campo = campo;
    }

    public String getCampo() {
        return campo;
    }
}
