/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ecomerce.web.fachada;

import br.com.ecomerce.dao.CartaoCreditoDAO;
import br.com.ecomerce.dao.ClienteDAO;
import br.com.ecomerce.dao.EnderecoDAO;
import br.com.ecomerce.dao.IDAO;
import br.com.ecomerce.dao.TelefoneDAO;
import br.com.ecomerce.dominio.CartaoCredito;
import br.com.ecomerce.dominio.Cliente;
import br.com.ecomerce.dominio.Endereco;
import br.com.ecomerce.dominio.EntidadeDominio;
import br.com.ecomerce.dominio.Resultado;
import br.com.ecomerce.dominio.Telefone;
import br.com.ecomerce.negocio.cliente.CriptografaSenha;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import br.com.ecomerce.negocio.*;
import br.com.ecomerce.negocio.IStrategy;
import br.com.ecomerce.negocio.cartao.ValidaCartao;
import br.com.ecomerce.negocio.cliente.ValidaCPF;
import br.com.ecomerce.negocio.cliente.ValidaConfirmaSenha;
import br.com.ecomerce.negocio.cliente.ValidaDadosCliente;
import br.com.ecomerce.negocio.cliente.ValidaExistenciaEndEntregaECorrespondencia;
import br.com.ecomerce.negocio.cliente.ValidaPadraoSenha;
import br.com.ecomerce.negocio.cliente.ValidaSenha;
import br.com.ecomerce.negocio.endereco.ValidaDadosEndereco;
import br.com.ecomerce.negocio.endereco.ValidaEndereco;
import br.com.ecomerce.negocio.telefone.ValidaTelefone;
import java.sql.SQLException;

/**
 *
 * @author Lucas
 */
public class Fachada implements IFachada {

    private Map<String, IDAO> daos;

    // Mapa Macro, com TODAS as regras de negócio
    // Observe: ele é um mapa, de um mapa. E o mapa "menor" tem a lista de strategys
    private Map<String, Map<String, List<IStrategy>>> regrasNegocio;
    private StringBuilder sb = new StringBuilder();
    private Resultado resultado;

    public Fachada() {
        // instanciando mapas de daos e regras de negócio macro
        daos = new HashMap<String, IDAO>();
        // Instanciando o mapa macro;
        regrasNegocio = new HashMap<String, Map<String, List<IStrategy>>>();

        // adicionando todas os daos ao hash de daos
        daos.put(Cliente.class.getName(), new ClienteDAO());
        daos.put(Endereco.class.getName(), new EnderecoDAO());
        daos.put(Telefone.class.getName(), new TelefoneDAO());
        daos.put(CartaoCredito.class.getName(), new CartaoCreditoDAO());

        // Criando RNs de cliente
        ValidaDadosCliente validaDadosCliente = new ValidaDadosCliente();
        ValidaSenha vSenha = new ValidaSenha();
        ValidaCPF validaCpf = new ValidaCPF();
        ValidaPadraoSenha vPadraoSenha = new ValidaPadraoSenha();
        CriptografaSenha criptografaSenha = new CriptografaSenha();
        ValidaConfirmaSenha validaConfirmaSenha = new ValidaConfirmaSenha();
        ValidaExistenciaEndEntregaECorrespondencia validaExistenciaEnd = new ValidaExistenciaEndEntregaECorrespondencia();

        // Criando lista de RNs do Cliente Salvar
        List<IStrategy> rnsClienteSalvar = new ArrayList<IStrategy>();
        rnsClienteSalvar.add(validaDadosCliente);
        rnsClienteSalvar.add(validaCpf);
        rnsClienteSalvar.add(validaExistenciaEnd);
        rnsClienteSalvar.add(vSenha);
        rnsClienteSalvar.add(validaConfirmaSenha);
        rnsClienteSalvar.add(vPadraoSenha);
        rnsClienteSalvar.add(criptografaSenha);

        // Criando lista de RNs do Cliente Alterar
        List<IStrategy> rnsClienteAlterar = new ArrayList<IStrategy>();
        rnsClienteAlterar.add(validaDadosCliente);
        rnsClienteAlterar.add(validaCpf);

        // Criando RNs de endereço
        ValidaEndereco vEndereco = new ValidaEndereco();

        // Criando lista de RNs do endereço Salvar
        List<IStrategy> rnsEnderecoSalvar = new ArrayList<IStrategy>();
        rnsEnderecoSalvar.add(vEndereco);

        // Criando lista de RNs do endereço Alterar
        List<IStrategy> rnsEnderecoAlterar = new ArrayList<IStrategy>();
        rnsEnderecoAlterar.add(vEndereco);

        // Criando RNs de cartão
        ValidaCartao vCartao = new ValidaCartao();

        // Criando lista de RNs de cartao Salvar
        List<IStrategy> rnsCartaoCreditoSalvar = new ArrayList<IStrategy>();
        rnsCartaoCreditoSalvar.add(vCartao);

        // Criando lista de RNs de cartao Alterar
        List<IStrategy> rnsCartaoCreditoAlterar = new ArrayList<IStrategy>();
        rnsCartaoCreditoAlterar.add(vCartao);

        // Criando RNs de telefone
        ValidaTelefone vTelefone = new ValidaTelefone();

        // Criando lista de RNs de telefone Salvar
        List<IStrategy> rnsTelefoneSalvar = new ArrayList<IStrategy>();
        rnsTelefoneSalvar.add(vTelefone);

        // Criando lista de RNs de telefone Alterar
        List<IStrategy> rnsTelefoneAlterar = new ArrayList<IStrategy>();
        rnsTelefoneAlterar.add(vTelefone);

        // Criando mapa de Operação Cliente, RNs da operação de Cliente.
        Map<String, List<IStrategy>> mapaCliente = new HashMap<String, List<IStrategy>>();

        // Adiconando lista de RNs para cada operação de cliente
        mapaCliente.put("SALVAR", rnsClienteSalvar);
        mapaCliente.put("ALTERAR", rnsClienteAlterar);

        regrasNegocio.put(Cliente.class.getName(), mapaCliente);

        // Criando mapa de Operação Endereco, RNs da operação de Endereco.
        Map<String, List<IStrategy>> mapaEndereco = new HashMap<String, List<IStrategy>>();

        // Adiconando lista de RNs para cada operação de Endereco
        mapaEndereco.put("SALVAR", rnsEnderecoSalvar);
        mapaEndereco.put("ALTERAR", rnsEnderecoAlterar);

        regrasNegocio.put(Endereco.class.getName(), mapaEndereco);

        // Criando mapa de Operação CartaoCredito, RNs da operação de CartaoCredito.
        Map<String, List<IStrategy>> mapaCartaoCredito = new HashMap<String, List<IStrategy>>();

        // Adiconando lista de RNs para cada operação de Endereco
        mapaCartaoCredito.put("SALVAR", rnsCartaoCreditoSalvar);
        mapaCartaoCredito.put("ALTERAR", rnsCartaoCreditoAlterar);

        regrasNegocio.put(CartaoCredito.class.getName(), mapaCartaoCredito);

        // Criando mapa de Operação Telefone, RNs da operação de Telefone.
        Map<String, List<IStrategy>> mapaTelefone = new HashMap<String, List<IStrategy>>();

        // Adiconando lista de RNs para cada operação de Endereco
        mapaTelefone.put("SALVAR", rnsTelefoneSalvar);
        mapaTelefone.put("ALTERAR", rnsTelefoneSalvar);

        regrasNegocio.put(Telefone.class.getName(), mapaTelefone);
    }

    private void executarRegras(EntidadeDominio entidade, List<IStrategy> rnsEntidade) {
        for (IStrategy rn : rnsEntidade) {
            String msg = rn.processar(entidade);
            if (msg != null) {
                sb.append(msg);
            }
        }
    }

    @Override
    public Resultado salvar(EntidadeDominio entidade) {
        resultado = new Resultado();
        sb.setLength(0);
        String nmClasse = entidade.getClass().getName();

        Map<String, List<IStrategy>> mapaEntidade = regrasNegocio.get(nmClasse);
        List<IStrategy> rnsEntidade = mapaEntidade.get("SALVAR");

        executarRegras(entidade, rnsEntidade);

        if (sb.length() == 0) {
            IDAO dao = daos.get(nmClasse);
            dao.salvar(entidade);
            resultado.addEntidade(entidade);
        } else {
            resultado.addEntidade(entidade);
            resultado.setMsg(sb.toString());
        }

        return resultado;

    }

    @Override
    public Resultado alterar(EntidadeDominio entidade) {
        resultado = new Resultado();
        sb.setLength(0);
        String nmClasse = entidade.getClass().getName();

        Map<String, List<IStrategy>> mapaEntidade = regrasNegocio.get(nmClasse);
        List<IStrategy> rnsEntidade = mapaEntidade.get("ALTERAR");

        executarRegras(entidade, rnsEntidade);

        if (sb.length() == 0) {
            IDAO dao = daos.get(nmClasse);
            dao.alterar(entidade);
            resultado.addEntidade(entidade);
        } else {
            resultado.addEntidade(entidade);
            resultado.setMsg(sb.toString());
        }

        return resultado;
    }

    @Override
    public Resultado excluir(EntidadeDominio entidade) {
        resultado = new Resultado();
        String nmClasse = entidade.getClass().getName();

            IDAO dao = daos.get(nmClasse);
            resultado.addEntidade(entidade);
            dao.excluir(entidade);
            
        return resultado;
    }

    @Override
    public Resultado consultar(EntidadeDominio entidade) {
        resultado = new Resultado();
        String nmClasse = entidade.getClass().getName();

        IDAO dao = daos.get(nmClasse);
        resultado.setEntidades(dao.consultar(entidade));

        return resultado;

    }

    @Override
    public Resultado visualizar(EntidadeDominio entidade) {
        resultado = new Resultado();
        String nmClasse = entidade.getClass().getName();

        IDAO dao = daos.get(nmClasse);
        resultado.setEntidades(dao.consultar(entidade));
        return resultado;
    }
}
