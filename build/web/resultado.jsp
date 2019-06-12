<%-- 
    Document   : resultado
    Created on : 03/12/2018, 13:50:50
    Author     : verss
--%>

<%@page import="br.com.ecomerce.dominio.Telefone"%>
<%@page import="br.com.ecomerce.dominio.Endereco"%>
<%@page import="br.com.ecomerce.dominio.Cliente"%>
<%@page import="br.com.ecomerce.dominio.CartaoCredito"%>
<%@page import="br.com.ecomerce.dominio.Resultado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- biblioteca da semantic ui -->
        <link rel="stylesheet" type="text/css" href="estilo/css/semantic.min.css">
        
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Resultado resultado = (Resultado) request.getAttribute("resultado");
            String entidade = (String) request.getAttribute("entidade");
            String operacao = (String) request.getAttribute("operacao");

            // Cria um atributo de acordo com o nome recebido
            if(entidade == null){
                out.println("<h1>Erro objeto não conhecido recebido.</h1>");
            }else if(entidade.trim().equals("CLIENTE")){
                Cliente cliente = (Cliente) resultado.getEntidades().get(0);
                
                out.println("<form class='ui form' style='width: 80%; margin-left: 10%; margin-top: 40px; margin-bottom: 100px;' action='VisualizarCliente'  method='POST'>");
                    out.println("<input type='hidden' name='idCliente' id='idCliente' value='" + cliente.getId() + "'/>");
                    out.println(resultado.getMsg());
                    out.println("<input type='hidden' name='PAGINA' id='PAGINA' value='PERFIL'/>");
                    out.println("<input type='hidden' name='OPERACAO' id='OPERACAO' value='VISUALIZAR'/>");
                    out.println("<input class='ui blue button' type='submit' id='' name='' value='Perfil'/>");
                out.println("</form>");
                
                if(operacao == null){
                    out.println("<form action='VisualizarCliente' method='POST'>");
                        out.println("<input type='hidden' name='PAGINA' id='PAGINA' value='ALTERAR'/>");
                        out.println("<input type='hidden' name='idCliente' id='idCliente' value='" + cliente.getId() + "'/>");
                        out.println("<input type='hidden' name='OPERACAO' id='OPERACAO' value='VISUALIZAR'/>");
                        out.println("<input class='ui red basic button right floated' type='submit' id='' name='' value='Voltar'/>");
                    out.println("</form>");
                }else{
                    if(operacao.trim().equals("SALVAR")){
                        out.print("<a href='Salvar/cadastroCliente.html' class='ui basic button'>Voltar</a>");
                    }
                }
            }else if(entidade.trim().equals("ENDERECO")){
                Endereco endereco = (Endereco) resultado.getEntidades().get(0);
                
                out.println("<form class='ui form' style='width: 80%; margin-left: 10%; margin-top: 40px; margin-bottom: 100px;' action='VisualizarCliente'  method='POST'>");
                    out.println("<input type='hidden' name='idCliente' id='idCliente' value='" + endereco.getCliente().getId() + "'/>");
                    out.println(resultado.getMsg());
                    out.println("<input type='hidden' name='PAGINA' id='PAGINA' value='PERFIL'/>");
                    out.println("<input type='hidden' name='OPERACAO' id='OPERACAO' value='VISUALIZAR'/>");
                    out.println("<input class='ui blue button' type='submit' id='' name='' value='Perfil'/>");
                out.println("</form>");
                
                if(operacao == null){
                    out.println("<form action='VisualizarEndereco' method='POST'>");
                        out.println("<input type='hidden' name='idEndereco' id='idEndereco' value='" + endereco.getId() + "'/>");
                        out.println("<input type='hidden' name='OPERACAO' id='OPERACAO' value='VISUALIZAR'/>");
                        out.println("<input class='ui red basic button' type='submit' id='' name='' value='Voltar'/>");
                    out.println("</form>");
                }
                
            }else if(entidade.trim().equals("TELEFONE")){
                Telefone telefone = (Telefone) resultado.getEntidades().get(0);
                
                out.println("<form class='ui form' style='width: 80%; margin-left: 10%; margin-top: 40px; margin-bottom: 100px;' action='VisualizarCliente'  method='POST'>");
                    out.println("<input type='hidden' name='idCliente' id='idCliente' value='" + telefone.getCliente().getId() + "'/>");
                    out.println(resultado.getMsg());
                    out.println("<input type='hidden' name='PAGINA' id='PAGINA' value='PERFIL'/>");
                    out.println("<input type='hidden' name='OPERACAO' id='OPERACAO' value='VISUALIZAR'/>");
                    out.println("<input class='ui blue button' type='submit' id='' name='' value='Perfil'/>");
                out.println("</form>");
                
                if(operacao == null){
                    out.println("<form action='VisualizarTelefone' method='POST'>");
                        out.println("<input type='hidden' name='idTelefone' id='idTelefone' value='" + telefone.getId() + "'/>");
                        out.println("<input type='hidden' name='OPERACAO' id='OPERACAO' value='VISUALIZAR'/>");
                        out.println("<input class='ui red basic button' type='submit' id='' name='' value='Voltar'/>");
                    out.println("</form>");
                }
            }else if(entidade.trim().equals("CARTAO")){
                CartaoCredito cartao = (CartaoCredito) resultado.getEntidades().get(0);
                
                out.println("<form class='ui form' style='width: 80%; margin-left: 10%; margin-top: 40px; margin-bottom: 100px;' action='VisualizarCliente'  method='POST'>");
                    out.println("<input type='hidden' name='idCliente' id='idCliente' value='" + cartao.getCliente().getId() + "'/>");
                    out.println(resultado.getMsg());
                    out.println("<input type='hidden' name='PAGINA' id='PAGINA' value='PERFIL'/>");
                    out.println("<input type='hidden' name='OPERACAO' id='OPERACAO' value='VISUALIZAR'/>");
                    out.println("<input class='ui blue basic button' type='submit' id='' name='' value='Perfil'/>");
                out.println("</form>");
                
                if(operacao == null){
                    out.println("<form action='VisualizarCartao' method='POST'>");
                        out.println("<input type='hidden' name='idCartao' id='idCartao' value='" + cartao.getId() + "'/>");
                        out.println("<input type='hidden' name='OPERACAO' id='OPERACAO' value='VISUALIZAR'/>");
                        out.println("<input class='ui red basic button' type='submit' id='' name='' value='Voltar'/>");
                    out.println("</form>");
                }
            }
        %>
    </body>
</html>
