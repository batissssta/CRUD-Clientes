/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ecomerce.controladora;

import br.com.ecomerce.dao.*;
import br.com.ecomerce.dominio.*;
import br.com.ecomerce.web.command.AlterarCommand;
import br.com.ecomerce.web.command.ConsultarCommand;
import br.com.ecomerce.web.command.ExcluirCommand;
import br.com.ecomerce.web.command.ICommand;
import br.com.ecomerce.web.command.SalvarCommand;
import br.com.ecomerce.web.command.VisualizarCommand;
import br.com.ecomerce.web.viewHelper.CartaoVH;
import br.com.ecomerce.web.viewHelper.ClienteVH;
import br.com.ecomerce.web.viewHelper.EnderecoVH;
import br.com.ecomerce.web.viewHelper.IViewHelper;
import br.com.ecomerce.web.viewHelper.TelefoneVH;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author marce
 */

public class Servlet extends HttpServlet {
    private Map<String, ICommand> commands;
    private Map<String, IViewHelper> vhs;
    
    public Servlet() {
        super();
        // adicionando commands ao mapa
        commands = new HashMap<String, ICommand>();
        commands.put("SALVAR", new SalvarCommand());
        commands.put("ALTERAR", new AlterarCommand());
        commands.put("CONSULTAR", new ConsultarCommand());
        commands.put("EXCLUIR", new ExcluirCommand());
        commands.put("VISUALIZAR", new VisualizarCommand());
        
        
        // adicionando vhs ao mapa
        vhs = new HashMap<String, IViewHelper>();
        // Cliente
        vhs.put("/projeto-engenharia-iii/SalvarCliente", new ClienteVH());
        vhs.put("/projeto-engenharia-iii/AlterarCliente", new ClienteVH());
        vhs.put("/projeto-engenharia-iii/ConsultarCliente", new ClienteVH());
        vhs.put("/projeto-engenharia-iii/ExcluirCliente", new ClienteVH());
        vhs.put("/projeto-engenharia-iii/VisualizarCliente", new ClienteVH());
        
        // Endereco
        vhs.put("/projeto-engenharia-iii/SalvarEndereco", new EnderecoVH());
        vhs.put("/projeto-engenharia-iii/AlterarEndereco", new EnderecoVH());
        vhs.put("/projeto-engenharia-iii/ConsultarEndereco", new EnderecoVH());
        vhs.put("/projeto-engenharia-iii/ExcluirEndereco", new EnderecoVH());
        vhs.put("/projeto-engenharia-iii/VisualizarEndereco", new EnderecoVH());
        
        // Cartão
        vhs.put("/projeto-engenharia-iii/SalvarCartao", new CartaoVH());
        vhs.put("/projeto-engenharia-iii/AlterarCartao", new CartaoVH());
        vhs.put("/projeto-engenharia-iii/ConsultarCartao", new CartaoVH());
        vhs.put("/projeto-engenharia-iii/ExcluirCartao", new CartaoVH());
        vhs.put("/projeto-engenharia-iii/VisualizarCartao", new CartaoVH());
        
        // Telefone
        vhs.put("/projeto-engenharia-iii/SalvarTelefone", new TelefoneVH());
        vhs.put("/projeto-engenharia-iii/AlterarTelefone", new TelefoneVH());
        vhs.put("/projeto-engenharia-iii/ConsultarTelefone", new TelefoneVH());
        vhs.put("/projeto-engenharia-iii/ExcluirTelefone", new TelefoneVH());
        vhs.put("/projeto-engenharia-iii/VisualizarTelefone", new TelefoneVH());
        
    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServeletCliente</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServeletCliente at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getRequestURI();
		
        String OPERACAO = request.getParameter("OPERACAO");

        Resultado resultado = null;

        IViewHelper vh = vhs.get(uri);

        EntidadeDominio entidade = vh.getEntidade(request);

        resultado = commands.get(OPERACAO).executar(entidade);

        vh.setView(resultado, request, response);
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
