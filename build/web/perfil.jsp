<%-- 
    Document   : teste
    Created on : 01/12/2018, 04:27:03
    Author     : Lucas
--%>

<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.com.ecomerce.dominio.CartaoCredito"%>
<%@page import="br.com.ecomerce.dominio.Telefone"%>
<%@page import="br.com.ecomerce.dominio.Endereco"%>
<%@page import="br.com.ecomerce.dominio.Cliente"%>
<%@page import="br.com.ecomerce.dominio.Resultado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- biblioteca da semantic ui -->
        <link rel="stylesheet" type="text/css" href="estilo/css/semantic.min.css">

        <title>Perfil</title>
        <link href="//cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css" rel="stylesheet">
        
        <script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
        <script src="//cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
        <script>
            $(document).ready(function(){
                $('#listagem-enderecos').DataTable({
                    "language": {
                          "lengthMenu": "Mostrando _MENU_ registros por página",
                          "zeroRecords": "Nada encontrado",
                          "info": "Mostrando página _PAGE_ de _PAGES_",
                          "infoEmpty": "Nenhum registro disponível",
                          "infoFiltered": "(filtrado de _MAX_ registros no total)",
                          "search": "Pesquisar: ",
                          "paginate" : {
                              "first": "Primeira",
                              "next": "Próxima",
                              "previous": "Anterior",
                          }
                      }
                  });
            });
            </script>
            <script>
            $(document).ready(function(){
                $('#listagem-cartoes').DataTable({
                    "language": {
                          "lengthMenu": "Mostrando _MENU_ registros por página",
                          "zeroRecords": "Nada encontrado",
                          "info": "Mostrando página _PAGE_ de _PAGES_",
                          "infoEmpty": "Nenhum registro disponível",
                          "infoFiltered": "(filtrado de _MAX_ registros no total)",
                          "search": "Pesquisar: ",
                          "paginate" : {
                              "first": "Primeira",
                              "next": "Próxima",
                              "previous": "Anterior",
                          }
                      }
                  });
            });
            </script>
            <script>
            $(document).ready(function(){
                $('#listagem-telefones').DataTable({
                    "language": {
                          "lengthMenu": "Mostrando _MENU_ registros por página",
                          "zeroRecords": "Nada encontrado",
                          "info": "Mostrando página _PAGE_ de _PAGES_",
                          "infoEmpty": "Nenhum registro disponível",
                          "infoFiltered": "(filtrado de _MAX_ registros no total)",
                          "search": "Pesquisar: ",
                          "paginate" : {
                              "first": "Primeira",
                              "next": "Próxima",
                              "previous": "Anterior",
                          }
                      }
                  });
            });
        </script>
        
    </head>
    <body style="margin-left: 10%; margin-right: 10%; margin-top: 40px; margin-bottom: 40px;">
        <!-- Recebe o Cliente contido na sessão -->
        <%
            Resultado resultado = (Resultado) request.getAttribute("resultado");
            Cliente cliente = (Cliente) resultado.getEntidades().get(0);
        %>
        <h2>Cliente: <%out.println(cliente.getNome());%></h2>
        <form action='VisualizarCliente' method='POST'>
            <input type='hidden' name='idCliente' id='idCliente' value='<%out.print(cliente.getId());%>'/>
            <input type='hidden' name='PAGINA' id='PAGINA' value='ALTERAR'/>
            <input type='hidden' name='OPERACAO' id='OPERACAO' value='VISUALIZAR'/>
            <input class='ui blue mini button' type='submit' id='' name='' value='Alterar Dados Cliente' style='float:right;'/>
        </form>
        <form action='VisualizarCliente' method='POST'>
            <input type='hidden' name='idCliente' id='idCliente' value='<%out.print(cliente.getId());%>'/>
            <input type='hidden' name='PAGINA' id='PAGINA' value='SENHA'/>
            <input type='hidden' name='OPERACAO' id='OPERACAO' value='VISUALIZAR'/>
            <input class='ui blue mini button' type='submit' id='' name='' value='Alterar Senha' style='float:right;'/>
        </form>
        <br/>
        <h3>Endereços Cadastrados</h3>
        <a class="ui mini basic button" href="Salvar/cadastroEndereco.jsp?idCliente=<%out.print(cliente.getId());%>">Adicionar Endereço</a>
        <div class ="ui form">
            <table class="ui align center table" id="listagem-enderecos" data-page-length='5'>
                <thead>
                <tr class="ui table header">
                    <th>Ações</th>
                    <th>CEP</th>
                    <th>Número</th>
                    <th>Logradouro</th>
                    <th>Bairro</th>
                    <th>Cidade</th>
                    <th>Estado</th>
                    <th>País</th>
                </tr>
                </thead>
                <% for (Endereco end : cliente.getEnderecos()) {

                        //Form para alterar ou excluir um endereco
                        out.println("<tr>");
                            out.println("<td>");
                                out.println("<form action='VisualizarEndereco' method='POST'>");
                                    out.println("<input type='hidden' name='idEndereco' id='idEndereco' value='" + end.getId() + "'/>");
                                    out.println("<input type='hidden' id='OPERACAO' name='OPERACAO' value='VISUALIZAR'/>");
                                    out.println("<input class='ui blue mini button' type='submit' id='' name='' value='Alterar'/>");
                                out.println("</form>");
                                out.println("<form action='VisualizarEndereco' method='POST'>");
                                    out.println("<input type='hidden' name='idEndereco' id='idEndereco' value='" + end.getId() + "'/>");
                                    out.println("<input type='hidden' name='idCliente' id='idCliente' value='" + cliente.getId() + "'/>");
                                    out.println("<input type='hidden' id='OPERACAO' name='OPERACAO' value='EXCLUIR'/>");
                                    out.println("<input class='ui red mini button' type='submit' id='' name='' value='Excluir'/>");
                                out.println("</form>");
                            out.println("</td>");

                            out.println("<td>" + end.getCep() + "</td>");
                            out.println("<td>" + end.getNumeroEndereco() + "</td>");
                            out.println("<td>" + end.getLogradouro() + "</td>");
                            out.println("<td>" + end.getBairro().getNome() + "</td>");
                            out.println("<td>" + end.getBairro().getCidade().getNome() + "</td>");
                            out.println("<td>" + end.getBairro().getCidade().getEstado().getSigla() + "</td>");
                            out.println("<td>" + end.getBairro().getCidade().getEstado().getPais().getNome() + "</td>");
                        out.println("</tr>");
                    }%>
            </table>
        </div>
        <br/>
        <h3>Telefones Cadastrados</h3>
        <a class="ui mini basic  button" href="Salvar/cadastroTelefone.jsp?idCliente=<%out.print(cliente.getId());%>">Adicionar Telefone</a>
        <div class="ui form">
            <table class="ui align center table" id="listagem-telefones" data-page-length='5'>
                <thead>
                <tr class="ui table header">
                    <th>Ações</th>
                    <th>DDD</th>
                    <th>Número</th>
                    <th>Tipo</th>
                </tr>
                </thead>
                <%  out.println("");
                    for (Telefone tel : cliente.getTelefones()) {
                        //Form para alterar ou excluir um telefone
                        out.println("<tr>");
                            out.println("<td>");
                                out.println("<form action='VisualizarTelefone' method='POST'>");
                                    out.println("<input type='hidden' name='idTelefone' id='idTelefone' value='" + tel.getId() + "'/>");
                                    out.println("<input type='hidden' id='OPERACAO' name='OPERACAO' value='VISUALIZAR'/>");
                                    out.println("<input class='ui blue mini button' type='submit' id='' name='' value='Alterar'/>");
                                out.println("</form>");
                                out.println("<form action='VisualizarTelefone' method='POST'>");
                                    out.println("<input type='hidden' name='idTelefone' id='idTelefone' value='" + tel.getId() + "'/>");
                                    out.println("<input type='hidden' name='idCliente' id='idCliente' value='" + cliente.getId() + "'/>");
                                    out.println("<input type='hidden' id='OPERACAO' name='OPERACAO' value='EXCLUIR'/>");
                                    out.println("<input class='ui red mini button' type='submit' id='' name='' value='Excluir'/>");
                                out.println("</form>");
                            out.println("</td>");

                        out.println("</form>");
                        out.println("<td>" + tel.getDdd() + "</td>");
                        out.println("<td>" + tel.getNumeroTelefone() + "</td>");
                        out.println("<td>" + tel.getTipo() + "</td>");
                        out.println("</tr>");
                    }%>
            </table>
        </div>
        <br/>
        <div class ="ui form">
            <h3>Cartões Cadastrados</h3>
            <a class="ui mini basic  button" href="Salvar/cadastroCartao.jsp?idCliente=<%out.print(cliente.getId());%>">Adicionar Cartão de Crédito</a>
            <table class="ui align center table" id="listagem-cartoes" data-page-length='5'>
                <thead>
                <tr class="ui table header">
                    <th>Ações</th>
                    <th>Número</th>
                    <th>Código</th>
                    <th>Bandeira</th>
                    <th>Validade</th>
                    <th>Preferido</th>
                </tr>
                </thead>
                <% DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                    for (CartaoCredito crt : cliente.getCartoesCredito()) {
                        //Form para alterar ou excluir um cartão
                        out.println("<tr>");
                            out.println("<td>");
                                out.println("<form action='VisualizarCartao' method='POST'>");
                                    out.println("<input type='hidden' name='idCartao' id='idCartao' value='" + crt.getId() + "'/>");
                                    out.println("<input type='hidden' id='OPERACAO' name='OPERACAO' value='VISUALIZAR'/>");
                                    out.println("<input class='ui blue mini button' type='submit' id='' name='' value='Alterar'/>");
                                out.println("</form>");
                                out.println("<form action='VisualizarCartao' method='POST'>");
                                    out.println("<input type='hidden' name='idCartao' id='idCartao' value='" + crt.getId() + "'/>");
                                    out.println("<input type='hidden' name='idCliente' id='idCliente' value='" + cliente.getId() + "'/>");
                                    out.println("<input type='hidden' id='OPERACAO' name='OPERACAO' value='EXCLUIR'/>");
                                    out.println("<input class='ui red mini button' type='submit' id='' name='' value='Excluir'/>");
                                out.println("</form>");
                            out.println("</td>");

                        out.println("</form>");
                        out.println("<td>" + crt.getNumeroCartao() + "</td>");
                        out.println("<td>" + crt.getCodigoSeguranca() + "</td>");
                        out.println("<td>" + crt.getBandeira().getNome() + "</td>");
                        out.println("<td>" + df.format(crt.getValidade())+"</td>");
                        if (crt.isPreferido()) {
                            out.println("<td>X</td>");
                        } else {
                            out.println("<td></td>");
                        }
                        out.println("</tr>");
                    }%>
            </table> 
            </div>
</body>
</html>
