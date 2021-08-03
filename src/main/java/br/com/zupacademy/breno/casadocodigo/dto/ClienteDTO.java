package br.com.zupacademy.breno.casadocodigo.dto;

import br.com.zupacademy.breno.casadocodigo.entities.Cliente;
import br.com.zupacademy.breno.casadocodigo.entities.Estado;
import br.com.zupacademy.breno.casadocodigo.entities.Pais;
import br.com.zupacademy.breno.casadocodigo.repositories.EstadoRepository;
import br.com.zupacademy.breno.casadocodigo.repositories.PaisRepository;
import br.com.zupacademy.breno.casadocodigo.validations.annotations.CpfOuCnpj;
import br.com.zupacademy.breno.casadocodigo.validations.annotations.ExistId;
import br.com.zupacademy.breno.casadocodigo.validations.annotations.UniqueValue;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;


public class ClienteDTO {

    @NotBlank @Email @UniqueValue(domainClass = Cliente.class, fieldName = "email")
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank @CpfOuCnpj
    @UniqueValue(domainClass = Cliente.class, fieldName = "documento")
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotNull @ExistId(domainClass = Pais.class, fieldName = "id")
    private Long paisId;

    private Long estadoId;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    public ClienteDTO(String email, String nome, String sobrenome, String documento, String endereco, String complemento, String cidade, Long paisId, Long estadoId, String telefone, String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.paisId = paisId;
        this.estadoId = estadoId;
        this.telefone = telefone;
        this.cep = cep;
    }
    public Long getPaisId() {
        return paisId;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public Cliente toModel(PaisRepository paisRepository, EstadoRepository estadoRepository) {

        Pais pais = paisRepository.findById(getPaisId()).get();
        if(estadoId == null) {
            return new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, pais, telefone, cep);
        }
        Optional<Estado> possivelEstado = estadoRepository.findById(estadoId);
        if(possivelEstado.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Estado não encontrado.");
        }
        Estado estado = possivelEstado.get();

        if (estado.estadoValido(pais)) {
            return new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, pais,
                    estado, telefone, cep);
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Estado não válido.");
    }

}
