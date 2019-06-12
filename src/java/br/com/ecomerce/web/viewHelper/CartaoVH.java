package br.com.ecomerce.web.viewHelper;

import br.com.ecomerce.controladora.Servlet;
import br.com.ecomerce.dominio.BandeiraCartao;
import br.com.ecomerce.dominio.CartaoCredito;
import br.com.ecomerce.dominio.Cliente;
import br.com.ecomerce.dominio.EntidadeDominio;
import br.com.ecomerce.dominio.Resultado;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class CartaoVH implements IViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        if (request.getParameter("OPERACAO").trim().equals("SALVAR")) {
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
            
            if(bandeiraCartao.trim().equals("S") || bandeiraCartao == null){
                bandeiraCartao = "";
            }
            
            if(codigoSeguranca.trim().equals("") || codigoSeguranca == null){
                codigoSeguranca = "";
            }
            
            if(numeroCartao.trim().equals("") || numeroCartao == null){
                numeroCartao = "";
            }
            
            if(nomeImpresso.trim().equals("") || nomeImpresso == null){
                nomeImpresso = "";
            }

            // Criando Cartão de Crédito
            BandeiraCartao bandeira = new BandeiraCartao(bandeiraCartao);
            CartaoCredito cartao = new CartaoCredito(codigoSeguranca, numeroCartao, validade, preferido, nomeImpresso, bandeira);
            Cliente cliente = new Cliente();
            cliente.setId(Integer.valueOf(request.getParameter("idCliente")));
            cartao.setCliente(cliente);
            cartao.setId(0);
            
            return cartao;
        }
        
        if(request.getParameter("OPERACAO").trim().equals("ALTERAR")){
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

            if(bandeiraCartao.trim().equals("S") || bandeiraCartao == null){
                bandeiraCartao = "";
            }
            
            if(codigoSeguranca.trim().equals("") || codigoSeguranca == null){
                codigoSeguranca = "";
            }
            
            if(numeroCartao.trim().equals("") || numeroCartao == null){
                numeroCartao = "";
            }
            
            if(nomeImpresso.trim().equals("") || nomeImpresso == null){
                nomeImpresso = "";
            }
            // Criando Cartão de Crédito
            BandeiraCartao bandeira = new BandeiraCartao(bandeiraCartao);
            CartaoCredito cartao = new CartaoCredito(codigoSeguranca, numeroCartao, validade, preferido, nomeImpresso, bandeira);
            Cliente cliente = new Cliente();
            cliente.setId(Integer.valueOf(request.getParameter("idCliente")));
            cartao.setCliente(cliente);
            cartao.setId(Integer.valueOf(request.getParameter("idCartao")));
            
            return cartao;
        }
        
        if(request.getParameter("OPERACAO").trim().equals("EXCLUIR")){
            CartaoCredito cartao = new CartaoCredito();
            Cliente cliente = new Cliente();
            cliente.setId(Integer.valueOf(request.getParameter("idCliente")));
            cartao.setCliente(cliente);
            cartao.setId(Integer.valueOf(request.getParameter("idCartao")));
            return cartao;
        }
        
        if(request.getParameter("OPERACAO").trim().equals("VISUALIZAR")){
            // Criando cartão
            CartaoCredito cartao = new CartaoCredito();
            Cliente cliente = new Cliente();
            cliente.setId(0);
            cartao.setCliente(cliente);
            cartao.setId(Integer.valueOf(request.getParameter("idCartao")));
            return cartao;
        }
        return null;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws IOException {
        CartaoCredito cartao = (CartaoCredito) resultado.getEntidades().get(0);
        RequestDispatcher d = null;
        PrintWriter out = response.getWriter();
        String operacao = request.getParameter("OPERACAO");

        if (operacao.equals("SALVAR")) {
            request.setAttribute("resultado", resultado);
            request.setAttribute("operacao", "SALVAR");
            request.setAttribute("entidade", "CARTAO");
            
            if (resultado.getMsg() == null) {
                resultado.setMsg("<h1> Cartao com número: " + cartao.getNumeroCartao() + "</h1><br/><h1>e Nome: " + cartao.getNomeImpresso() + " salvo com sucesso!!!</h1>");
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
            request.setAttribute("entidade", "CARTAO");
            
            if (resultado.getMsg() == null) {
                resultado.setMsg("<h1> Cartao com número: " + cartao.getNumeroCartao()+ "</h1><br/><h1>e Nome: " + cartao.getNomeImpresso() + " alterado com sucesso!!!</h1>");
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
        
        if (operacao.equals("EXCLUIR")) {
            resultado.setMsg("Exclusão realizada com sucesso.");
            request.setAttribute("resultado", resultado);
            request.setAttribute("operacao", "EXCLUIR");
            request.setAttribute("entidade", "CARTAO");
            d = request.getRequestDispatcher("resultado.jsp");
            try {
                d.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(ClienteVH.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (resultado.getMsg() == null && operacao.equals("VISUALIZAR")) {
            request.setAttribute("resultado", resultado);
            d = request.getRequestDispatcher("Alterar/alterarCartao.jsp");
            try {
                d.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(ClienteVH.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
