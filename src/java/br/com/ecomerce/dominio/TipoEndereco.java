package br.com.ecomerce.dominio;

/**
 * 
 * @author Marcelo Vilas Boas Correa Filho
 */

public class TipoEndereco extends EntidadeDominio{

    private String descricaoTipo;

    public TipoEndereco(String descricaoTipo) {
        this.descricaoTipo = descricaoTipo;
    }

    public TipoEndereco() {
    }

    public String getDescricaoTipo() {
        return descricaoTipo;
    }

    public void setDescricaoTipo(String descricaoTipo) {
        this.descricaoTipo = descricaoTipo;
    }
}
