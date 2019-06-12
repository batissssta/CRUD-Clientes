package br.com.ecomerce.dominio;

import java.util.Date;

/**
 * 
 * @author Marcelo Vilas Boas Correa Filho
 */

public class CartaoCredito extends EntidadeDominio{

    private String codigoSeguranca;
    private String numeroCartao;
    private Date validade;
    private boolean preferido;
    private String nomeImpresso;
    private Cliente cliente;
    private BandeiraCartao bandeira;

    public CartaoCredito(String codigoSeguranca, String numeroCartao, Date validade, boolean preferido, String nomeImpresso, BandeiraCartao bandeira) {
        this.codigoSeguranca = codigoSeguranca;
        this.numeroCartao = numeroCartao;
        this.validade = validade;
        this.preferido = preferido;
        this.nomeImpresso = nomeImpresso;
        this.bandeira = bandeira;
    }
    
    public CartaoCredito() {
        
    }

    public String getCodigoSeguranca() {
        return codigoSeguranca;
    }

    public void setCodigoSeguranca(String codigoSeguranca) {
        this.codigoSeguranca = codigoSeguranca;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public boolean isPreferido() {
        return preferido;
    }

    public void setPreferido(boolean preferido) {
        this.preferido = preferido;
    }

    public String getNomeImpresso() {
        return nomeImpresso;
    }

    public void setNomeImpresso(String nomeImpresso) {
        this.nomeImpresso = nomeImpresso;
    }

    public BandeiraCartao getBandeira() {
        return bandeira;
    }

    public void setBandeira(BandeiraCartao bandeira) {
        this.bandeira = bandeira;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
