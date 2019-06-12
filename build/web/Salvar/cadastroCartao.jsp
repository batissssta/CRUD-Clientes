<%-- 
    Document   : cadastroCartao
    Created on : 03/12/2018, 15:43:08
    Author     : verss
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- biblioteca da semantic ui -->
        <link rel="stylesheet" type="text/css" href="../estilo/css/semantic.min.css">

        <title>Cadastrar Cartão</title>
    </head>
    <body>
        <%
            int idCliente = Integer.valueOf(request.getParameter("idCliente"));
        %>
        <!-- FORMULÁRIO DE CADASTRO -->
        <form class="ui form" style="width: 80%; margin-left: 10%; margin-top: 40px; margin-bottom: 100px;" action="../SalvarCartao"  method="POST">
            <h4 class="ui dividing header">Cartão de crédito</h4>
            <div class="three fields">
                <div class="field">
                    <label>Número</label>
                    <input type="text" name="txtNumeroCartao" id="txtNumeroCartao" placeholder="Número">
                </div>
                <div class="field">
                    <label>Bandeira</label>
                    <select name="selectBandeiraCartao" id="selectBandeiraCartao">
                        <option value="S">Selecione...</option>
                        <option value="MASTER">MasterCard</option>
                        <option value="VISA">VISA</option>
                        <option value="AMEX">American Express</option>
                    </select>
                </div>
                <div class="field six wide">
                    <label>Nome impresso no cartão</label>
                    <input type="text" name="txtNomeImpressoCartao" id="txtNomeImpressoCartao" placeholder = "Nome impresso">
                </div>
            </div>
            <div class="three fields">
                <div class="field">
                    <label>Código de segurança</label>
                    <input type="text" name="txtCodigoSegurancaCartao" id="txtCodigoSegurancaCartao" maxlength="16" placeholder="Código de segurança">
                </div>
                <div class="field four wide">
                    <label>Validade do Cartão</label>
                    <input type="date" name="dateValidadeCartao" id="dateValidadeCartao" placeholder="Validade Cartão">
                </div>
                <div class="field">
                    <label>Cartão Preferido</label>
                    <div class="ui checkbox">
                        <input type="checkbox" name="checkPreferidoCartao" id="checkPreferidoCartao" value = "true">
                        <label>Principal</label>
                    </div>
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
