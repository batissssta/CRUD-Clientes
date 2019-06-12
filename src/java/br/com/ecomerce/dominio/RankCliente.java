package br.com.ecomerce.dominio;

/**
 * 
 * @author Marcelo Vilas Boas Correa Filho
 */

public class RankCliente extends EntidadeDominio{

    private int codigoRank;
    private String nomeRank;
    private Cliente cliente;

    public RankCliente(int codigoRank, String nomeRank) {
        this.codigoRank = codigoRank;
        this.nomeRank = nomeRank;
    }

    public RankCliente() {
    }

    public int getCodigoRank() {
        return codigoRank;
    }

    public void setCodigoRank(int codigoRank) {
        this.codigoRank = codigoRank;
    }

    public String getNomeRank() {
        return nomeRank;
    }

    public void setNomeRank(String nomeRank) {
        this.nomeRank = nomeRank;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
