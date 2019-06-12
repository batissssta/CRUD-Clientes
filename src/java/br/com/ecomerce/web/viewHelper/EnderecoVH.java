package br.com.ecomerce.web.viewHelper;

import br.com.ecomerce.dominio.Bairro;
import br.com.ecomerce.dominio.Cidade;
import br.com.ecomerce.dominio.Cliente;
import br.com.ecomerce.dominio.Endereco;
import br.com.ecomerce.dominio.EntidadeDominio;
import br.com.ecomerce.dominio.Estado;
import br.com.ecomerce.dominio.Pais;
import br.com.ecomerce.dominio.Resultado;
import br.com.ecomerce.dominio.TipoEndereco;
import java.io.IOException;
import java.io.PrintWriter;
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
public class EnderecoVH implements IViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {

        // Construindo Endereço para salvar
        if (request.getParameter("OPERACAO").trim().equals("SALVAR")) {
            String sPais = request.getParameter("selectPais");
            String sEstado = request.getParameter("selectEstado");
            String sCidade = request.getParameter("txtCidade");
            String sBairro = request.getParameter("txtBairro");
            String logradouro = request.getParameter("txtLogradouro");
            String numeroEndereco = request.getParameter("txtNumeroEndereco");
            String cep = request.getParameter("txtCep");
            String tipoLogradouro = request.getParameter("selectTipoLogradouro");
            String tipoResidencia = request.getParameter("selectTipoResidencia");
            String sTipoEndereco = request.getParameter("selectTipoEndereco");

            Cliente cliente = new Cliente();

            // Criando Endereço 
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
            cliente.setId(Integer.valueOf(request.getParameter("idCliente")));
            endereco.setCliente(cliente);
            endereco.setId(0);
            return endereco;
        }

        // Construindo Endereço para alterar
        if (request.getParameter("OPERACAO").trim().equals("ALTERAR")) {
            // Criando Endereço 
            String sPais = request.getParameter("selectPais");
            String sEstado = request.getParameter("selectEstado");
            String sCidade = request.getParameter("txtCidade");
            String sBairro = request.getParameter("txtBairro");
            String logradouro = request.getParameter("txtLogradouro");
            String numeroEndereco = request.getParameter("txtNumeroEndereco");
            String cep = request.getParameter("txtCep");
            String tipoLogradouro = request.getParameter("selectTipoLogradouro");
            String tipoResidencia = request.getParameter("selectTipoResidencia");
            String sTipoEndereco = request.getParameter("selectTipoEndereco");

            Cliente cliente = new Cliente();

            // Criando Endereço
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
            cliente.setId(Integer.valueOf(request.getParameter("idCliente")));
            endereco.setCliente(cliente);
            endereco.setId(Integer.valueOf(request.getParameter("idEndereco")));
            return endereco;
        }

        // Contruindo Endereço para visualizar
        if (request.getParameter("OPERACAO").trim().equals("VISUALIZAR")) {
            // Criando Endereço 
            Endereco endereco = new Endereco();
            Cliente cliente = new Cliente();
            cliente.setId(0);
            endereco.setCliente(cliente);
            endereco.setId(Integer.valueOf(request.getParameter("idEndereco")));
            return endereco;
        }

        // Contruindo Endereço para visualizar
        if (request.getParameter("OPERACAO").trim().equals("EXCLUIR")) {
            // Criando Endereço 
            Endereco endereco = new Endereco();
            Cliente cliente = new Cliente();
            cliente.setId(Integer.valueOf(request.getParameter("idCliente")));
            endereco.setCliente(cliente);
            endereco.setId(Integer.valueOf(request.getParameter("idEndereco")));
            return endereco;
        }

        return null;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Endereco endereco = (Endereco) resultado.getEntidades().get(0);
        RequestDispatcher d = null;
        PrintWriter out = response.getWriter();
        String operacao = request.getParameter("OPERACAO");

        if (operacao.equals("SALVAR")) {
            request.setAttribute("resultado", resultado);
            request.setAttribute("operacao", "SALVAR");
            request.setAttribute("entidade", "ENDERECO");

            if (resultado.getMsg() == null) {

                resultado.setMsg("<h1> Endereco com CEP: " + endereco.getCep() + " salvo com sucesso!!!</h1>");
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
            request.setAttribute("entidade", "ENDERECO");

            if (resultado.getMsg() == null) {
                resultado.setMsg("<h1> Endereco com CEP: " + endereco.getCep() + " alterado com sucesso!!!</h1>");
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
            request.setAttribute("resultado", resultado);
            d = request.getRequestDispatcher("Alterar/alterarEndereco.jsp");
            try {
                d.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(ClienteVH.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (operacao.equals("EXCLUIR")) {
            resultado.setMsg("Exclusão realizada com sucesso.");
            request.setAttribute("resultado", resultado);
            request.setAttribute("operacao", "EXCLUIR");
            request.setAttribute("entidade", "ENDERECO");
            d = request.getRequestDispatcher("resultado.jsp");
            try {
                d.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(ClienteVH.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
