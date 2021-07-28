package br.com.zupacademy.breno.casadocodigo.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ErroValidacao extends ErroPadrao {

    private List<CampoMensagem> erros = new ArrayList<>();

    public List<CampoMensagem> getErros() {
        return erros;
    }

    public void addErros(String campoErro, String mensagem) {
        erros.add(new CampoMensagem(campoErro, mensagem));
    }
}
