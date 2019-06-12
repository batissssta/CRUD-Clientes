<%-- 
    Document   : atualizarTelefone
    Created on : 29/11/2018, 10:23:47
    Author     : Marcelo Vilas Boas Correa Filho
--%>

<%@page import="br.com.ecomerce.dominio.Telefone"%>
<%@page import="br.com.ecomerce.dominio.Resultado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <!-- biblioteca da semantic ui -->
        <link rel="stylesheet" type="text/css" href="estilo/css/semantic.min.css">

        <title>Atualizar Telefone</title>
    </head>
    <body>
        <!-- Recebe o Telefone contido na request -->
        <%
            Resultado resultado = (Resultado) request.getAttribute("resultado");
            Telefone telefone = (Telefone) resultado.getEntidades().get(0);
        %>
        <!-- FORMULÁRIO DE CADASTRO -->
        <form class="ui form" style="width: 80%; margin-left: 10%; margin-top: 40px; margin-bottom: 100px;" action="AlterarTelefone"  method="POST">
            <h5 class="ui dividing header">Telefone</h5>
            <div class="fields">
                <div class="field">
                    <label>Tipo de Telefone</label>
                    <select class="ui fluid dropdown" name="selectTipoTelefone" id="selectTipoTelefone">
                        <%
                            if (telefone.getTipo().equals("FIXO")) {
                                out.println("<option value='S'>Selecione...</option>");
                                out.println("<option value='FIXO' selected='true'>Fixo</option>");
                                out.println("<option value='CELULAR'>Celular</option>");
                            } else if (telefone.getTipo().equals("CELULAR")) {
                                out.println("<option value='S'>Selecione...</option>");
                                out.println("<option value='FIXO'>Fixo</option>");
                                out.println("<option value='CELULAR' selected='true'>Celular</option>");
                            } else {
                                out.println("<option value='S'>Selecione...</option>");
                                out.println("<option value='FIXO'>Fixo</option>");
                                out.println("<option value='CELULAR'>Celular</option>");
                            }
                        %>
                    </select>
                </div>
                <div class="two wide field">
                    <label>DDD</label>
                    <input type="text" name="txtDdd" id="txtDdd" value="<%out.print(telefone.getDdd());%>">
                </div>
                <div class="field">
                    <label>Número</label>
                    <input type="text" name="txtNumeroTelefone" id="txtNumeroTelefone" value="<%out.print(telefone.getNumeroTelefone());%>">
                </div>
            </div>
            <input type="hidden" name="idCliente" id="idCliente" value="<%out.print(telefone.getCliente().getId());%>"/>
            <input type="hidden" name="idTelefone" id="idTelefone" value="<%out.print(telefone.getId());%>">
            <input type="submit" id="OPERACAO" name="OPERACAO" value="ALTERAR" class="ui primary button right floated"/>
        </form>
    </body>
</html>
