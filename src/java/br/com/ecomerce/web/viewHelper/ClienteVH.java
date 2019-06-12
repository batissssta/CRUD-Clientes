package br.com.ecomerce.web.viewHelper;

import br.com.ecomerce.controladora.Servlet;
import br.com.ecomerce.dominio.Bairro;
import br.com.ecomerce.dominio.BandeiraCartao;
import br.com.ecomerce.dominio.CartaoCredito;
import br.com.ecomerce.dominio.Cidade;
import br.com.ecomerce.dominio.Cliente;
import br.com.ecomerce.dominio.Endereco;
import br.com.ecomerce.dominio.EntidadeDominio;
import br.com.ecomerce.dominio.Estado;
import br.com.ecomerce.dominio.Pais;
import br.com.ecomerce.dominio.Resultado;
import br.com.ecomerce.dominio.Telefone;
import br.com.ecomerce.dominio.TipoEndereco;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Marcelo Vilas Boas Correa Filho
 */
public class ClienteVH implements IViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        if (request.getParameter("OPERACAO").trim().equals("SALVAR")) {
            String sPais = request.getParameter("selectPaisUm");
            String sEstado = request.getParameter("selectEstadoUm");
            String sCidade = request.getParameter("txtCidadeUm");
            String sBairro = request.getParameter("txtBairroUm");
            String logradouro = request.getParameter("txtLogradouroUm");
            String numeroEndereco = request.getParameter("txtNumeroEnderecoUm");
            String cep = request.getParameter("txtCepUm");
            String tipoLogradouro = request.getParameter("selectTipoLogradouroUm");
            String tipoResidencia = request.getParameter("selectTipoResidenciaUm");
            String sTipoEndereco = request.getParameter("selectTipoEnderecoUm");

            // Criando ArrayList de Endereco
            ArrayList enderecos = new ArrayList<Endereco>();
            Cliente cliente = new Cliente();

            // Criando Endereço Um
            // Cria Pais
            Pais pais;
            if (!sPais.trim().equals("") || sPais != null) {
                pais = new Pais(sPais);
            } else {
                pais = new Pais("");
            }

            // Cria estado
            Estado estado;
            if (!sEstado.trim().equals("S") || sEstado != null) {
                estado = new Estado(sEstado, pais);
            } else {
                estado = new Estado("", pais);
            }

            // Cria Cidade
            Cidade cidade;
            if (!sCidade.trim().equals("") || sCidade != null) {
                cidade = new Cidade(sCidade, estado);
            } else {
                cidade = new Cidade("", estado);
            }

            // Cria Bairro
            Bairro bairro;
            if (!sBairro.trim().equals("") || sBairro != null) {
                bairro = new Bairro(sBairro, cidade);
            } else {
                bairro = new Bairro("", cidade);
            }

            // Cria tipo endereco
            TipoEndereco tipoEndereco;
            if (!sTipoEndereco.trim().equals("S") || sTipoEndereco != null) {
                tipoEndereco = new TipoEndereco(sTipoEndereco);
            } else {
                tipoEndereco = new TipoEndereco("");
            }

            // Criando demais dados de endereço
            if (logradouro.trim().equals("") || logradouro == null) {
                logradouro = "";
            }

            if (numeroEndereco.trim().equals("") || numeroEndereco == null) {
                numeroEndereco = "";
            }

            if (cep.trim().equals("") || cep == null) {
                cep = "";
            }

            if (tipoLogradouro.trim().equals("S") || tipoLogradouro == null) {
                tipoLogradouro = "";
            }

            if (tipoResidencia.trim().equals("S") || tipoResidencia == null) {
                tipoResidencia = "";
            }
            Endereco endereco = new Endereco(logradouro, numeroEndereco, cep, tipoLogradouro, tipoResidencia, bairro, tipoEndereco);
            enderecos.add(endereco);

            sPais = request.getParameter("selectPaisDois");
            sEstado = request.getParameter("selectEstadoDois");
            sCidade = request.getParameter("txtCidadeDois");
            sBairro = request.getParameter("txtBairroDois");
            logradouro = request.getParameter("txtLogradouroDois");
            numeroEndereco = request.getParameter("txtNumeroEnderecoDois");
            cep = request.getParameter("txtCepDois");
            tipoLogradouro = request.getParameter("selectTipoLogradouroDois");
            tipoResidencia = request.getParameter("selectTipoResidenciaDois");
            sTipoEndereco = request.getParameter("selectTipoEnderecoDois");

            // Criando Endereço Dois
            // Cria Pais
            if (!sPais.trim().equals("") || sPais != null) {
                pais = new Pais(sPais);
            } else {
                pais = new Pais("");
            }

            // Cria estado
            if (!sEstado.trim().equals("S") || sEstado != null) {
                estado = new Estado(sEstado, pais);
            } else {
                estado = new Estado("", pais);
            }

            // Cria Cidade
            if (!sCidade.trim().equals("") || sCidade != null) {
                cidade = new Cidade(sCidade, estado);
            } else {
                cidade = new Cidade("", estado);
            }

            // Cria Bairro
            if (!sBairro.trim().equals("") || sBairro != null) {
                bairro = new Bairro(sBairro, cidade);
            } else {
                bairro = new Bairro("", cidade);
            }

            // Cria tipo endereco
            if (!sTipoEndereco.trim().equals("S") || sTipoEndereco != null) {
                tipoEndereco = new TipoEndereco(sTipoEndereco);
            } else {
                tipoEndereco = new TipoEndereco("");
            }

            // Criando demais dados de endereço
            if (logradouro.trim().equals("") || logradouro == null) {
                logradouro = "";
            }

            if (numeroEndereco.trim().equals("") || numeroEndereco == null) {
                numeroEndereco = "";
            }

            if (cep.trim().equals("") || cep == null) {
                cep = "";
            }

            if (tipoLogradouro.trim().equals("S") || tipoLogradouro == null) {
                tipoLogradouro = "";
            }

            if (tipoResidencia.trim().equals("S") || tipoResidencia == null) {
                tipoResidencia = "";
            }

            endereco = new Endereco(logradouro, numeroEndereco, cep, tipoLogradouro, tipoResidencia, bairro, tipoEndereco);
            enderecos.add(endereco);

            String tipoTelefone = request.getParameter("selectTipoTelefone");
            String ddd = request.getParameter("txtDdd");
            String numeroTelefone = request.getParameter("txtNumeroTelefone");

            if (tipoTelefone.trim().equals("") || tipoTelefone == null) {
                tipoTelefone = "";
            }

            if (ddd.trim().equals("") || ddd == null) {
                ddd = "";
            }

            if (numeroTelefone.trim().equals("") || numeroTelefone == null) {
                numeroTelefone = "";
            }

            // Criando ArrayList de Telefones
            ArrayList<Telefone> telefones = new ArrayList<Telefone>();

            // Criando Telefone
            Telefone telefone = new Telefone(tipoTelefone, ddd, numeroTelefone);
            telefones.add(telefone);

            String bandeiraCartao = request.getParameter("selectBandeiraCartao");
            String codigoSeguranca = request.getParameter("txtCodigoSegurancaCartao");
            String numeroCartao = request.getParameter("txtNumeroCartao");
            String validadeCartao = request.getParameter("dateValidadeCartao");
            String nomeImpresso = request.getParameter("txtNomeImpressoCartao");
            Date validade = new Date();

            try {
                validade = sdf.parse(validadeCartao);
            } catch (ParseException ex) {
                validade.setTime(0);
            }
            boolean preferido;
            if (request.getParameter("checkPreferidoCartao") == null) {
                preferido = false;
            } else {
                preferido = true;
            }

            if (request.getParameter("checkPreferidoCartao") == null) {
                preferido = false;
            } else {
                preferido = true;
            }

            if (bandeiraCartao.trim().equals("") || bandeiraCartao == null) {
                bandeiraCartao = "";
            }

            if (codigoSeguranca.trim().equals("") || codigoSeguranca == null) {
                codigoSeguranca = "";
            }

            if (numeroCartao.trim().equals("") || numeroCartao == null) {
                numeroCartao = "";
            }

            if (nomeImpresso.trim().equals("") || nomeImpresso == null) {
                nomeImpresso = "";
            }

            // Criando Arraylist de CartaoCredito
            ArrayList<CartaoCredito> cartoes = new ArrayList<CartaoCredito>();

            // Criando Cartão de Crédito
            BandeiraCartao bandeira = new BandeiraCartao(bandeiraCartao);
            CartaoCredito cartao = new CartaoCredito(codigoSeguranca, numeroCartao, validade, true, nomeImpresso, bandeira);
            cartoes.add(cartao);

            // Criando Cliente
            String nome = request.getParameter("txtNome");
            Date dataNascimento = new Date();
            try {
                dataNascimento = sdf.parse(request.getParameter("dateDataNascimento"));
            } catch (ParseException ex) {
                dataNascimento.setTime(0);
            }
            String email = request.getParameter("txtEmail");

            String genero = request.getParameter("selectGenero");
            String cpf = request.getParameter("txtCpf");
            String senha = request.getParameter("txtSenha");
            String senhaConfirma = request.getParameter("txtConfirmaSenha");

            if (dataNascimento != null) {
                cliente.setDataNascimento(dataNascimento);
            }

            if (!nome.trim().equals("") || nome != null) {
                cliente.setNome(nome);
            } else {
                cliente.setNome("");
            }

            if (!email.trim().equals("") || email != null) {
                cliente.setEmail(email);
            } else {
                cliente.setEmail("");
            }

            if (!genero.trim().equals("S") || genero != null) {
                cliente.setGenero(genero);
            } else {
                cliente.setGenero("");
            }

            if (!cpf.trim().equals("") || cpf != null) {
                cliente.setCpf(cpf);
            } else {
                cliente.setCpf("");
            }

            if (!senha.trim().equals("") || senha != null) {
                cliente.setSenha(senha);
            } else {
                cliente.setSenha("");
            }

            if (!senhaConfirma.equals("") || senhaConfirma != null) {
                cliente.setConfirmarSenha(senhaConfirma);
            } else {
                cliente.setConfirmarSenha("");
            }

            if (cartoes != null || cartoes.size() == 0) {
                cliente.setCartoesCredito(cartoes);
            }

            if (telefones != null || telefones.size() == 0) {
                cliente.setTelefones(telefones);
            }

            if (enderecos != null || enderecos.size() == 0) {
                cliente.setEnderecos(enderecos);
            }
            String status = "ATIVO";
            cliente.setStatus(status);

            return cliente;
        }

        if (request.getParameter("OPERACAO").trim().equals("ALTERAR")) {
            Cliente cliente = new Cliente();

            // Criando Cliente
            String nome = request.getParameter("txtNome");
            Date dataNascimento = new Date();
            if(request.getParameter("dateDataNascimento") == null){
                dataNascimento.setTime(0);
            }else{
                try {
                    dataNascimento = sdf.parse(request.getParameter("dateDataNascimento"));
                } catch (ParseException ex) {
                    dataNascimento.setTime(0);
                }
            }
            String email = request.getParameter("txtEmail");

            String status = "ATIVO";
            cliente.setStatus(status);

            String genero = request.getParameter("selectGenero");
            String cpf = request.getParameter("txtCpf");
            String senha = request.getParameter("txtSenha");
            String senhaConfirma = request.getParameter("txtConfirmaSenha");
            int idCliente = Integer.valueOf(request.getParameter("idCliente"));

            if (dataNascimento != null) {
                cliente.setDataNascimento(dataNascimento);
            }

            if (!nome.trim().equals("") || nome != null) {
                cliente.setNome(nome);
            } else {
                cliente.setNome("");
            }

            if (!email.trim().equals("") || email != null) {
                cliente.setEmail(email);
            } else {
                cliente.setEmail("");
            }

            if (!genero.trim().equals("S") || genero != null) {
                cliente.setGenero(genero);
            } else {
                cliente.setGenero("");
            }

            if (!cpf.trim().equals("") || cpf != null) {
                cliente.setCpf(cpf);
            } else {
                cliente.setCpf("");
            }

            cliente.setId(idCliente);

            return cliente;
        }

        if (request.getParameter("OPERACAO").trim().equals("EXCLUIR")) {
            Cliente cliente = new Cliente();
            cliente.setId(Integer.valueOf(request.getParameter("idCliente")));
            cliente.setNome("");
            return cliente;
        }

        if (request.getParameter("OPERACAO").trim().equals("CONSULTAR")) {
            String nome = request.getParameter("txtNome");
            Cliente cliente = new Cliente();

            if (nome.trim().equals("") || nome == null) {
                cliente.setNome("");
            } else {
                cliente.setNome(nome);
            }
            return cliente;
        }

        if (request.getParameter("OPERACAO").trim().equals("VISUALIZAR")) {
            Cliente cliente = new Cliente();
            cliente.setId(Integer.valueOf(request.getParameter("idCliente")));
            cliente.setNome("");
            return cliente;
        }
        return null;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws IOException {

        Cliente cliente = (Cliente) resultado.getEntidades().get(0);
        RequestDispatcher d = null;
        PrintWriter out = response.getWriter();
        String operacao = request.getParameter("OPERACAO");
        if (operacao.equals("CONSULTAR")) {
            request.setAttribute("resultado", resultado);
            d = request.getRequestDispatcher("Consultar/consultarCliente.jsp");
            try {
                d.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(ClienteVH.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (operacao.equals("SALVAR")) {
            request.setAttribute("resultado", resultado);
            request.setAttribute("operacao", "SALVAR");
            request.setAttribute("entidade", "CLIENTE");

            if (resultado.getMsg() == null) {
                resultado.setMsg("<h1> Cliente: " + cliente.getNome() + " salvo com sucesso!!!</h1>");
            } else {
                resultado.setMsg("<h1>" + resultado.getMsg() + "</h1>");
            }

            d = request.getRequestDispatcher("resultado.jsp");
            try {
                d.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(ClienteVH.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (operacao.equals("ALTERAR")) {
            request.setAttribute("resultado", resultado);
            request.setAttribute("entidade", "CLIENTE");

            if (resultado.getMsg() == null) {
                resultado.setMsg("<h1> Cliente: " + cliente.getNome() + " alterado com sucesso!!!</h1>");
            } else {
                resultado.setMsg("<h1>" + resultado.getMsg() + "</h1>");
            }

            d = request.getRequestDispatcher("resultado.jsp");
            try {
                d.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(ClienteVH.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (resultado.getMsg() == null && operacao.equals("EXCLUIR")) {
            request.setAttribute("resultado", resultado);
            request.setAttribute("operacao", "EXCLUIR");
            request.setAttribute("entidade", "CLIENTE");

            if (resultado.getMsg() == null) {
                resultado.setMsg("<h1> Cliente: " + cliente.getNome() + " desativado com sucesso!</h1>");
            } else {
                resultado.setMsg("<h1>" + resultado.getMsg() + "</h1>");
            }

            d = request.getRequestDispatcher("resultado.jsp");
            try {
                d.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(ClienteVH.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (resultado.getMsg() == null && operacao.equals("VISUALIZAR")) {
            if(request.getParameter("PAGINA").trim().equals("ALTERAR")){
                request.setAttribute("resultado", resultado);
                d = request.getRequestDispatcher("Alterar/alterarCliente.jsp");
                try {
                    d.forward(request, response);
                } catch (ServletException ex) {
                    Logger.getLogger(ClienteVH.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(request.getParameter("PAGINA").trim().equals("PERFIL")){
                request.setAttribute("resultado", resultado);
                d = request.getRequestDispatcher("perfil.jsp");
                try {
                    d.forward(request, response);
                } catch (ServletException ex) {
                    Logger.getLogger(ClienteVH.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(request.getParameter("PAGINA").trim().equals("SENHA")){
                request.setAttribute("resultado", resultado);
                d = request.getRequestDispatcher("Alterar/alterarSenha.jsp");
                try {
                    d.forward(request, response);
                } catch (ServletException ex) {
                    Logger.getLogger(ClienteVH.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
