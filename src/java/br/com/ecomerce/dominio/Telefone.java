package br.com.ecomerce.dominio;

/**
 * 
 * @author Marcelo Vilas Boas Correa Filho
 */

public class Telefone extends EntidadeDominio{

    private String tipo;
    private String ddd;
    private String numeroTelefone;
    private Cliente cliente;

    public Telefone(String tipo, String ddd, String numeroTelefone) {
        this.tipo = tipo;
        this.ddd = ddd;
        this.numeroTelefone = numeroTelefone;
    }

    public Telefone() {
        
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
