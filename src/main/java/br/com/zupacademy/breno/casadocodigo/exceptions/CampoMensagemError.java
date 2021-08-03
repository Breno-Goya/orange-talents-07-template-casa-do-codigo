package br.com.zupacademy.breno.casadocodigo.exceptions;

public class CampoMensagemError {

    private String nomeCampo;
    private String mensagem;

    public CampoMensagemError(String nomeCampo, String mensagem) {
        this.nomeCampo = nomeCampo;
        this.mensagem = mensagem;
    }

    public String getNomeCampo() {
        return nomeCampo;
    }

    public void setNomeCampo(String nomeCampo) {
        this.nomeCampo = nomeCampo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
