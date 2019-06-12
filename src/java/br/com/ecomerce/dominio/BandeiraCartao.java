package br.com.ecomerce.dominio;

/**
 * 
 * @author Marcelo Vilas Boas Correa Filho
 */

public class BandeiraCartao extends EntidadeDominio{

    private String nome;

    public BandeiraCartao(String nome) {
        this.nome = nome;
    }

    public BandeiraCartao() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
