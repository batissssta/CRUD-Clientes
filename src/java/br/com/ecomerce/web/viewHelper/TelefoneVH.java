package br.com.ecomerce.web.viewHelper;

import br.com.ecomerce.dominio.Cliente;
import br.com.ecomerce.dominio.EntidadeDominio;
import br.com.ecomerce.dominio.Resultado;
import br.com.ecomerce.dominio.Telefone;
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
public class TelefoneVH implements IViewHelper{

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {
        
        if(request.getParameter("OPERACAO").trim().equals("SALVAR")){
            String tipoTelefone = request.getParameter("selectTipoTelefone");
            String ddd = request.getParameter("txtDdd");
            String numeroTelefone = request.getParameter("txtNumeroTelefone");
            
            if(tipoTelefone.trim().equals("S") || tipoTelefone == null){
                tipoTelefone = "";
            }
            
            if(ddd.trim().equals("") || ddd == null){
                ddd = "";
            }
            
            if(numeroTelefone.trim().equals("") || numeroTelefone == null){
                numeroTelefone = "";
            }
            
            Telefone telefone = new Telefone(tipoTelefone, ddd, numeroTelefone);
            Cliente cliente = new Cliente();
            cliente.setId(Integer.valueOf(request.getParameter("idCliente")));
            telefone.setCliente(cliente);
            telefone.setId(0);
            return telefone;
        }
        
        if(request.getParameter("OPERACAO").trim().equals("ALTERAR")){
            String tipoTelefone = request.getParameter("selectTipoTelefone");
            String ddd = request.getParameter("txtDdd");
            String numeroTelefone = request.getParameter("txtNumeroTelefone");
            
            if(tipoTelefone.trim().equals("S") || tipoTelefone == null){
                tipoTelefone = "";
            }
            
            if(ddd.trim().equals("") || ddd == null){
                ddd = "";
            }
            
            if(numeroTelefone.trim().equals("") || numeroTelefone == null){
                numeroTelefone = "";
            }
            
            Telefone telefone = new Telefone(tipoTelefone, ddd, numeroTelefone);
            Cliente cliente = new Cliente();
            cliente.setId(Integer.valueOf(request.getParameter("idCliente")));
            telefone.setCliente(cliente);
            telefone.setId(Integer.valueOf(request.getParameter("idTelefone")));
            return telefone;
        }
        
        if(request.getParameter("OPERACAO").trim().equals("EXCLUIR")){
            Telefone telefone = new Telefone();
            Cliente cliente = new Cliente();
            cliente.setId(Integer.valueOf(request.getParameter("idCliente")));
            telefone.setCliente(cliente);
            telefone.setId(Integer.valueOf(request.getParameter("idTelefone")));
            return telefone;
        }
        
        if(request.getParameter("OPERACAO").trim().equals("VISUALIZAR")){
            Telefone telefone = new Telefone();
            Cliente cliente = new Cliente();
            cliente.setId(0);
            telefone.setCliente(cliente);
            telefone.setId(Integer.valueOf(request.getParameter("idTelefone")));
            return telefone;
        }
        
        return null;
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Telefone telefone = (Telefone) resultado.getEntidades().get(0);
        RequestDispatcher d = null;
        PrintWriter out = response.getWriter();
        String operacao = request.getParameter("OPERACAO");

        if (operacao.equals("SALVAR")) {
            request.setAttribute("resultado", resultado);
            request.setAttribute("operacao", "SALVAR");
            request.setAttribute("entidade", "TELEFONE");
            
            if (resultado.getMsg() == null) {
                resultado.setMsg("<h1> Telefone com número: " + telefone.getNumeroTelefone() + " salvo com sucesso!!!</h1>");
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
            request.setAttribute("entidade", "TELEFONE");
            
            if (resultado.getMsg() == null) {
                resultado.setMsg("<h1> Telefone com número: " + telefone.getNumeroTelefone() + " alterado com sucesso!!!</h1>");
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
            request.setAttribute("entidade", "TELEFONE");
            d = request.getRequestDispatcher("resultado.jsp");
            try {
                d.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(ClienteVH.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (resultado.getMsg() == null && operacao.equals("VISUALIZAR")) {
            request.setAttribute("resultado", resultado);
            d = request.getRequestDispatcher("Alterar/alterarTelefone.jsp");
            try {
                d.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(ClienteVH.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
