package br.com.ecomerce.dominio;

public class Endereco extends EntidadeDominio{
 
    private String logradouro;
    private String numeroEndereco;
    private String cep;
    private String tipoLogradouro;
    private String tipoResidencia;
    private Bairro bairro;
    private Cliente cliente;
    private TipoEndereco tipoEndereco;

    public Endereco(String logradouro, String numeroEndereco, String cep, String tipoLogradouro, String tipoResidencia, Bairro bairro, TipoEndereco tipoEndereco) {
        this.logradouro = logradouro;
        this.numeroEndereco = numeroEndereco;
        this.cep = cep;
        this.tipoLogradouro = tipoLogradouro;
        this.tipoResidencia = tipoResidencia;
        this.bairro = bairro;
        this.tipoEndereco = tipoEndereco;
    }
    
    public Endereco() {
        
    }

    public void validarEndereco() {

    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumeroEndereco() {
        return numeroEndereco;
    }

    public void setNumeroEndereco(String numeroEndereco) {
        this.numeroEndereco = numeroEndereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(String tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public String getTipoResidencia() {
        return tipoResidencia;
    }

    public void setTipoResidencia(String tipoResidencia) {
        this.tipoResidencia = tipoResidencia;
    }

    public TipoEndereco getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(TipoEndereco tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
