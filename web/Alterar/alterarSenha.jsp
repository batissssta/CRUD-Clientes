<%-- 
    Document   : alterarSenha
    Created on : 04/12/2018, 20:04:31
    Author     : Marcelo Vilas Boas Correa Filho
--%>

<%@page import="br.com.ecomerce.dominio.Cliente"%>
<%@page import="br.com.ecomerce.dominio.Resultado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="estilo/css/semantic.min.css">
        
        <title>Alterar Senha</title>
    </head>
    <body>
        <%
            Resultado resultado = (Resultado) request.getAttribute("resultado");
            Cliente cliente = (Cliente) resultado.getEntidades().get(0);
        %>
        <h1>Cliente: <%out.print(cliente.getNome());%></h1>
        <form action='AlterarCliente' method='POST'>
            <div class="two fields">
                <div class="field">
                    <label>Senha</label>
                    <input type="password" name="txtSenha" id="txtSenha" placeholder="Senha">
                </div>
                <div class="field">
                    <label>Confirmar senha</label>
                    <input type="password" name="txtConfirmaSenha" id="txtConfirmaSenha" placeholder="Confirmar senha">
                </div>
            </div>
            <input type="hidden" name="idCliente" id="idCliente" value="<%out.print(cliente.getId());%>"/>
            <input type="submit" id="OPERACAO" name="OPERACAO" value="ALTERAR" class="ui primary button right floated"/>
        </form>
    </body>
</html>
