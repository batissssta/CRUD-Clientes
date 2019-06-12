<%-- 
    Document   : alterarCliente
    Created on : 30/11/2018, 21:10:54
    Author     : Marcelo Vilas Boas Correa Filho
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="br.com.ecomerce.dominio.Cliente"%>
<%@page import="br.com.ecomerce.dominio.Resultado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <!-- biblioteca da semantic ui -->
        <link rel="stylesheet" type="text/css" href="estilo/css/semantic.min.css">
        
        <title>Atualizar Cliente</title>
    </head>
    <body>
        <!-- Recebe o Cliente contido na sessão -->
        <%
		Resultado resultado = (Resultado) request.getAttribute("resultado");
                Cliente cliente = (Cliente)resultado.getEntidades().get(0);
	%>
        <!-- FORMULÁRIO DE CADASTRO -->
        <form class="ui form" style="width: 80%; margin-left: 10%; margin-top: 40px; margin-bottom: 100px;" action="AlterarCliente"  method="POST">
            <h2 class="ui dividing header">Alterar Cliente</h2>
            <h4 class="ui dividing header">Dados pessoais</h4>
            <div class="fields">
                <div class="nine wide field">
                    <label>Nome</label>
                    <input type="text" name="txtNome" id="txtNome" value="<%out.print(cliente.getNome());%>">
                </div>	
                <div class="field">
                    <label>CPF</label>
                    <input type="text" name="txtCpf" id="txtCpf" value="<%out.print(cliente.getCpf());%>">
                </div>
                <div class="field">
                    <label>Data de Nascimento</label>
                    <input type="date" name="dateDataNascimento" id="dateDataNascimento" value="<%DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                        out.print(df.format(cliente.getDataNascimento()));%>">
                </div>
                <div class="field">
                    <label>Gênero</label>
                    <select class="ui fluid dropdown" name="selectGenero" id="selectGenero">
                        <option value="S">Selecione...</option>
                        <%
                            if(cliente.getGenero().equals("Masculino")){
                                out.println("<option value='Masculino' selected='true'>Masculino</option>");
                                out.println("<option value='Feminino'>Feminino</option>");
                                out.println("<option value='Outro'>Outro</option>");
                            }
                            else if(cliente.getGenero().equals("Feminino")){
                                out.println("<option value='Masculino'>Masculino</option>");
                                out.println("<option value='Feminino' selected='true'>Feminino</option>");
                                out.println("<option value='Outro'>Outro</option>");
                            }
                            else if(cliente.getGenero().equals("Outro")){
                                out.println("<option value='Masculino'>Masculino</option>");
                                out.println("<option value='Feminino'>Feminino</option>");
                                out.println("<option value='Outro' selected='true'>Outro</option>");
                            }
                            else{
                                out.println("<option value='Masculino'>Masculino</option>");
                                out.println("<option value='Feminino'>Feminino</option>");
                                out.println("<option value='Outro'>Outro</option>");
                            }
                        %>
                    </select>		
                </div>
            </div>
            <div class="three fields">
                <div class="eight wide field">
                    <label>Email</label>
                    <input type="text" name="txtEmail" id="txtEmail" value="<%out.print(cliente.getEmail());%>"/>
                </div>
                <input type="hidden" name="idCliente" id="idCliente" value="<%out.print(cliente.getId());%>"/>
            </div>
            <input type="submit" id="OPERACAO" name="OPERACAO" value="ALTERAR" class="ui primary button right floated"/>
        </form>
    </body>
</html>
