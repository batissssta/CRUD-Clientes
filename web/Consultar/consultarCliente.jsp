<%-- 
    Document   : consultarCliente
    Created on : 30/11/2018, 11:43:21
    Author     : Lucas
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.ecomerce.dominio.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="estilo/css/semantic.min.css">
        <title>Lista de Clientes</title>
        <link href="//cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css" rel="stylesheet">
    </head>
    <body style="margin-left: 10%; margin-right: 10%;">
        <h2 style="margin-top: 40px;" class="ui dividing header">Consulta de Clientes</h2>
        <%
            Resultado resultado = (Resultado) request.getAttribute("resultado");

            if (resultado != null && resultado.getMsg() != null) {
                out.print(resultado.getMsg());
            }
        %>

        <form class="ui form" action="SalvarCliente"  method="POST">
        <!--<label>Nome</label>-->
            <input type="hidden" name="txtNome" id="txtNome" placeholder="Nome"> 
            <input type="submit" class="ui basic button" id="OPERACAO" name="OPERACAO" value="CONSULTAR" style="float: right;"/>
        </form>
        
        <a href = "Salvar/cadastroCliente.html"><button class="ui primary button" style="float: right;">NOVO CLIENTE</button></a>
        
        <br><br><br>
        
        <!-- Essa div é apenas para deixar a consulta bonitinha -->
        <div class ="ui form">
            <table id="listagem-clientes" class="ui single line table" data-page-length='5'>
                <thead>
                <tr>
                    <th>Ações</th>
                    <th>Nome</th>
                    <th>Data Nascimento</th>
                    <th>Genero</th>
                    <th>Email</th>
                    <th>CPF</th>
                </tr>
            </thead>
            <%  if (resultado != null) {
                    List<EntidadeDominio> entidades = resultado.getEntidades();
                    StringBuilder sbRegistro = new StringBuilder();
                    
                        if (entidades != null) {
                            for (EntidadeDominio e : entidades) {
                                Cliente c = (Cliente) e;
                                sbRegistro.setLength(0);

                                if (c.getStatus().trim().equals("INATIVO")) {
                                    sbRegistro.append("<tr style='color: red;'>");
                                    sbRegistro.append("<input type='hidden' name='idCliente' id='idCliente' value='" + c.getId() + "'/>");
                                    sbRegistro.append("<td>");
                                        sbRegistro.append("INATIVO");
                                    sbRegistro.append("</td>");
                                } else {
                                    sbRegistro.append("<tr>");
                                        sbRegistro.append("<td>");
                                            sbRegistro.append("<form action='VisualizarCliente' method='POST'>");
                                                sbRegistro.append("<input type='hidden' name='idCliente' id='idCliente' value='" + c.getId() + "'/>");
                                                sbRegistro.append("<input type='hidden' name='PAGINA' id='PAGINA' value='PERFIL'/>");
                                                sbRegistro.append("<input type='hidden' name='OPERACAO' id='OPERACAO' value='VISUALIZAR'/>");
                                                sbRegistro.append("<input class='ui blue mini button' type='submit' id='' name='' value='Perfil'/>");
                                            sbRegistro.append("</form>");
                                            
                                            sbRegistro.append("<form action='VisualizarCliente' method='POST'>");
                                                sbRegistro.append("<input type='hidden' name='idCliente' id='idCliente' value='" + c.getId() + "'/>");
                                                sbRegistro.append("<input type='hidden' name='OPERACAO' id='OPERACAO' value='EXCLUIR'/>");
                                                sbRegistro.append("<input class='ui red mini button' type='submit' id='' name='' value='Excluir'/>");
                                            sbRegistro.append("</form>");

                                        sbRegistro.append("</td>");
                                }

                                        sbRegistro.append("<td>");
                                            sbRegistro.append(c.getNome());
                                        sbRegistro.append("</td>");

                                        sbRegistro.append("<td>");
                                            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                                            sbRegistro.append(df.format(c.getDataNascimento()));
                                        sbRegistro.append("</td>");

                                        sbRegistro.append("<td>");
                                            sbRegistro.append(c.getGenero());
                                        sbRegistro.append("</td>");

                                        sbRegistro.append("<td>");
                                            sbRegistro.append(c.getEmail());
                                        sbRegistro.append("</td>");

                                        sbRegistro.append("<td>");
                                            sbRegistro.append(c.getCpf());
                                        sbRegistro.append("</td>");

                                    sbRegistro.append("</tr>");

                                out.print(sbRegistro.toString());
                            }
                        }
                    }
                %>
            </table>
        </div>
        <script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
        <script src="//cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
        <script>
            $(document).ready(function(){
                $('#listagem-clientes').DataTable({
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
    </body>
</html>
