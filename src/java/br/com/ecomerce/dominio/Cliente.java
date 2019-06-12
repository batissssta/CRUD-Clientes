package br.com.ecomerce.dominio;

import java.util.ArrayList;
import java.util.Date;

public class Cliente extends EntidadeDominio {

    private String genero;
    private Date dataNascimento;
    private String email;
    private String status;
    private String confirmarSenha;
    private String cpf;
    private String nome;
    private String senha;
    private ArrayList<Telefone> telefones;    
    private ArrayList<Endereco> enderecos;
    private ArrayList<CartaoCredito> cartoesCredito;

    // Precisa de Telefones, Endereços e cartões para criar cliente
    public Cliente(String genero, Date dataNascimento, String email, String status, String cpf, String nome, String senha, ArrayList<Telefone> telefones, ArrayList<Endereco> enderecos, ArrayList<CartaoCredito> cartoesCredito) {
        this.genero = genero;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.status = status;
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
        this.telefones = telefones;
        this.enderecos = enderecos;
        this.cartoesCredito = cartoesCredito;
    }
    
    public Cliente(String genero, Date dataNascimento, String email, String status, String cpf, String nome, String senha) {
        this.genero = genero;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.status = status;
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
    }

    public Cliente() {
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getConfirmarSenha() {
        return confirmarSenha;
    }

    public void setConfirmarSenha(String confirmarSenha) {
        this.confirmarSenha = confirmarSenha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public ArrayList<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(ArrayList<Telefone> telefones) {
        this.telefones = telefones;
    }

    public ArrayList<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(ArrayList<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public ArrayList<CartaoCredito> getCartoesCredito() {
        return cartoesCredito;
    }

    public void setCartoesCredito(ArrayList<CartaoCredito> cartoesCredito) {
        this.cartoesCredito = cartoesCredito;
    }
}
