<%-- 
    Document   : cadastroTelefone
    Created on : 03/12/2018, 15:31:54
    Author     : verss
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- biblioteca da semantic ui -->
        <link rel="stylesheet" type="text/css" href="../estilo/css/semantic.min.css">
        
        <title>Cadastrar Telefone</title>
    </head>
    <body>
        <%
            int idCliente = Integer.valueOf(request.getParameter("idCliente"));
        %>
        <!-- FORMULÁRIO DE CADASTRO -->
        <form class="ui form" style="width: 80%; margin-left: 10%; margin-top: 40px; margin-bottom: 100px;" action="../SalvarTelefone"  method="POST">
            <h5 class="ui dividing header">Telefone</h5>
            <div class="fields">
                <div class="field">
                    <label>Tipo de Telefone</label>
                    <select class="ui fluid dropdown" name="selectTipoTelefone" id="selectTipoTelefone">
                        <option value="S">Selecione...</option>
                        <option value="FIXO">Fixo</option>
                        <option value="CELULAR">Celular</option>
                    </select>
                </div>
                <div class="two wide field">
                    <label>DDD</label>
                    <input type="text" name="txtDdd" id="txtDdd" placeholder="(99)">
                </div>
                <div class="two field">
                    <label>Número</label>
                    <input type="text" name="txtNumeroTelefone" id="txtNumeroTelefone" placeholder="99999-9999">
                </div>
                <input type="hidden" name="idCliente" id="idCliente" value="<%out.print(idCliente);%>"/>
                <input type="submit" id="OPERACAO" name="OPERACAO" value="SALVAR" class="ui primary button right floated"/>
        </form>
        <form class='ui form' action='../VisualizarCliente'  method='POST'>
            <input type="hidden" name="idCliente" id="idCliente" value="<%out.print(idCliente);%>"/>
            <input type='hidden' name='PAGINA' id='PAGINA' value='PERFIL'/>
            <input type='hidden' name='OPERACAO' id='OPERACAO' value='VISUALIZAR'/>
            <input class='ui primary button right floated' style='float: right;' type='submit' id='' name='' value='Voltar'/>
        </form>
        </div>
    </body>
</html>
