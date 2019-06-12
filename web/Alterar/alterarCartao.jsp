<%-- 
    Document   : alterarCartao
    Created on : 29/11/2018, 15:21:44
    Author     : marce
--%>

<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.com.ecomerce.dominio.Resultado"%>
<%@page import="br.com.ecomerce.dominio.CartaoCredito"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- biblioteca da semantic ui -->
        <link rel="stylesheet" type="text/css" href="estilo/css/semantic.min.css">

        <title>Alterar Cartão</title>
    </head>
    <body>
        <!-- Recebe o Cliente contido na request -->
        <%
            Resultado resultado = (Resultado) request.getAttribute("resultado");
            CartaoCredito cartao = (CartaoCredito) resultado.getEntidades().get(0);
        %>
        <!-- FORMULÁRIO DE CADASTRO -->
        <form class="ui form" style="width: 80%; margin-left: 10%; margin-top: 40px; margin-bottom: 100px;" action="AlterarCartao"  method="POST">
            <h4 class="ui dividing header">Cartão de crédito</h4>
            <div class="three fields">
                <div class="field">
                    <label>Número</label>
                    <input type="text" name="txtNumeroCartao" id="txtNumeroCartao" value="<%out.print(cartao.getNumeroCartao());%>">
                </div>
                <div class="field">
                    <label>Bandeira</label>
                    <select name="selectBandeiraCartao" id="selectBandeiraCartao">
                        <%
                            if (cartao.getBandeira().getNome().equals("MASTER")) {
                                out.println("<option value='S'>Selecione...</option>");
                                out.println("<option value='MASTER' selected='true'>MasterCard</option>");
                                out.println("<option value='VISA'>VISA</option>");
                                out.println("<option value='AMEX'>American Express</option>");
                            } else if (cartao.getBandeira().getNome().equals("VISA")) {
                                out.println("<option value='S'>Selecione...</option>");
                                out.println("<option value='MASTER'>MasterCard</option>");
                                out.println("<option value='VISA' selected='true'>VISA</option>");
                                out.println("<option value='AMEX'>American Express</option>");
                            } else if (cartao.getBandeira().getNome().equals("AMEX")) {
                                out.println("<option value='S'>Selecione...</option>");
                                out.println("<option value='MASTER'>MasterCard</option>");
                                out.println("<option value='VISA'>VISA</option>");
                                out.println("<option value='AMEX' selected='true'>American Express</option>");
                            } else {
                                out.println("<option value='S'>Selecione...</option>");
                                out.println("<option value='MASTER'>MasterCard</option>");
                                out.println("<option value='VISA'>VISA</option>");
                                out.println("<option value='AMEX'>American Express</option>");
                            }
                        %>
                    </select>
                </div>
                <div class="field six wide">
                    <label>Nome impresso no cartão</label>
                    <input type="text" name="txtNomeImpressoCartao" id="txtNomeImpressoCartao" value="<%out.print(cartao.getNomeImpresso());%>">
                </div>
            </div>
            <div class="three fields">
                <div class="field">
                    <label>Código de segurança</label>
                    <input type="text" name="txtCodigoSegurancaCartao" id="txtCodigoSegurancaCartao" maxlength="16" value="<%out.print(cartao.getCodigoSeguranca());%>">
                </div>
                <div class="field four wide">
                    <label>Validade do Cartão</label>
                           <input type="date" name="dateValidadeCartao" id="dateValidadeCartao" value="<%DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                        out.print(df.format(cartao.getValidade()));%>">
                </div>
                <div class="field">
                    <label>Cartão Preferido</label>
                    <div class="ui checkbox">
                        <%
                            if (cartao.isPreferido()) {
                                out.println("<input type='checkbox' name='checkPreferidoCartao' id='checkPreferidoCartao' checked>");
                            } else {
                                out.println("<input type='checkbox' name='checkPreferidoCartao' id='checkPreferidoCartao'>");
                            }
                        %>
                        <label>Principal</label>
                    </div>
                </div>
            </div>
            <input type="hidden" name="idCliente" id="idCliente" value="<%out.print(cartao.getCliente().getId());%>"/>
            <input type="hidden" name="idCartao" id="idCartao" value="<%out.print(cartao.getId());%>"/>
            <input type="submit" id="OPERACAO" name="OPERACAO" value="ALTERAR" class="ui primary button right floated"/>
        </form>
    </body>
</html>
