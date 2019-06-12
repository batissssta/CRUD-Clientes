<%-- 
    Document   : atualizarEndereco
    Created on : 29/11/2018, 09:17:30
    Author     : Marcelo Vilas Boas Correa Filho
--%>

<%@page import="br.com.ecomerce.dominio.Endereco"%>
<%@page import="br.com.ecomerce.dominio.Resultado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <!-- biblioteca da semantic ui -->
        <link rel="stylesheet" type="text/css" href="estilo/css/semantic.min.css">

        <title>Atualizar Endereço</title>
    </head>
    <body>
        <!-- Recebe o Endereco contido na request -->
        <%
            Resultado resultado = (Resultado) request.getAttribute("resultado");
            Endereco endereco = (Endereco) resultado.getEntidades().get(0);
        %>
        <!-- FORMULÁRIO DE CADASTRO -->
        <form class="ui form" style="width: 80%; margin-left: 10%; margin-top: 40px; margin-bottom: 100px;" action="AlterarEndereco"  method="POST">
            <h4 class="ui dividing header">Endereço</h4>
            <div class="four fields">
                <div class="eight wide field">
                    <label>Logradouro</label>
                    <input type="text" name="txtLogradouro" id="txtLogradouro" value="<%out.print(endereco.getLogradouro());%>">
                </div>
                <div class="field">
                    <label>Numero</label>
                    <input type="text" name="txtNumeroEndereco" id="txtNumeroEndereco" value="<%out.print(endereco.getNumeroEndereco());%>">
                </div>
                <div class="field">
                    <label>Tipo de Logradouro</label>
                    <select name="selectTipoLogradouro" id="selectTipoLogradouro">
                        <option value="S">Selecione...</option>
                        <%
                            if (endereco.getTipoLogradouro().equals("CONDOMINIO")) {
                                out.print("<option value='CONDOMINIO' selected='true'>Condomínio</option>");
                                out.print("<option value='PREDIO'>Prédio</option>");
                                out.print("<option value='OUTRO'>Outro</option>");
                            } else if (endereco.getTipoLogradouro().equals("PREDIO")) {
                                out.print("<option value='CONDOMINIO'>Condomínio</option>");
                                out.print("<option value='PREDIO' selected='true'>Prédio</option>");
                                out.print("<option value='OUTRO'>Outro</option>");
                            } else if (endereco.getTipoLogradouro().equals("OUTRO")) {
                                out.print("<option value='CONDOMINIO'>Condomínio</option>");
                                out.print("<option value='PREDIO'>Prédio</option>");
                                out.print("<option value='OUTRO' value='true'>Outro</option>");
                            } else {
                                out.print("<option value='CONDOMINIO'>Condomínio</option>");
                                out.print("<option value='PREDIO'>Prédio</option>");
                                out.print("<option value='OUTRO'>Outro</option>");
                            }
                        %>
                    </select>
                </div>
                <div class="field">
                    <label>Tipo de Residência</label>
                    <select name="selectTipoResidencia" id="selectTipoResidencia">
                        <option value="S">Selecione...</option>
                        <%
                            if (endereco.getTipoResidencia().equals("APARTAMENTO")) {
                                out.print("<option value='APARTAMENTO' selected='true'>Apartamento</option>");
                                out.print("<option value='CASA'>Casa</option>");
                                out.print("<option value='OUTRO'>Outro</option>");
                            } else if (endereco.getTipoResidencia().equals("CASA")) {
                                out.print("<option value='APARTAMENTO'>Apartamento</option>");
                                out.print("<option value='CASA' selected='true'>Casa</option>");
                                out.print("<option value='OUTRO'>Outro</option>");
                            } else if (endereco.getTipoResidencia().equals("OUTRO")) {
                                out.print("<option value='APARTAMENTO'>Apartamento</option>");
                                out.print("<option value='CASA'>Casa</option>");
                                out.print("<option value='OUTRO' selected='true'>Outro</option>");
                            } else {
                                out.print("<option value='APARTAMENTO'>Apartamento</option>");
                                out.print("<option value='CASA'>Casa</option>");
                                out.print("<option value='OUTRO'>Outro</option>");
                            }
                        %>
                    </select>
                </div>
            </div>
            <div class="three fields">
                <div class="field">
                    <label>CEP</label>
                    <input type="text" name="txtCep" id="txtCep" value="<%out.print(endereco.getCep());%>">
                </div>
                <div class="field">
                    <label>Bairro</label>
                    <input type="text" name="txtBairro" id="txtBairro" value="<%out.println(endereco.getBairro().getNome());%>">
                </div>
                <div class="field">
                    <label>Cidade</label>
                    <input type="text" name="txtCidade" id="txtCidade" value="<%out.print(endereco.getBairro().getCidade().getNome());%>">
                </div>
            </div>
            <div class="three fields">
                <div class="field">
                    <label>Estado</label>
                    <select class="ui fluid dropdown" name="selectEstado" id="selectEstado">
                        <%out.println("<option value='" + endereco.getBairro().getCidade().getEstado().getSigla() + "' selected='true'>" + endereco.getBairro().getCidade().getEstado().getSigla() + "</option>");%>
                        <option value="AC">Acre</option>
                        <option value="AL">Alagoas</option>
                        <option value="AP">Amapá</option>
                        <option value="AM">Amazonas</option>
                        <option value="BA">Bahia</option>
                        <option value="CE">Ceará</option>
                        <option value="DF">Distrito Federal</option>
                        <option value="ES">Espírito Santo</option>
                        <option value="GO">Goiás</option>
                        <option value="MA">Maranhão</option>
                        <option value="MT">Mato Grosso</option>
                        <option value="MS">Mato Grosso do Sul</option>
                        <option value="MG">Minas Gerais</option>
                        <option value="PA">Pará</option>
                        <option value="PB">Paraíba</option>
                        <option value="PR">Paraná</option>
                        <option value="PE">Pernambuco</option>
                        <option value="PI">Piauí</option>
                        <option value="RJ">Rio de Janeiro</option>
                        <option value="RN">Rio Grande do Norte</option>
                        <option value="RS">Rio Grande do Sul</option>
                        <option value="RO">Rondônia</option>
                        <option value="RR">Roraima</option>
                        <option value="SC">Santa Catarina</option>
                        <option value="SP">São Paulo</option>
                        <option value="SE">Sergipe</option>
                        <option value="TO">Tocantins</option>
                    </select>
                </div>
                <div class="field">
                    <label>País</label>
                    <select class="ui fluid dropdown" name="selectPais" id="selectPais">
                        <%out.println("<option value='" + endereco.getBairro().getCidade().getEstado().getPais().getNome() + "' selected='true'>" + endereco.getBairro().getCidade().getEstado().getPais().getNome() + "</option>");%>
                        <option value="África do Sul">África do Sul</option>
                        <option value="Albânia">Albânia</option>
                        <option value="Alemanha">Alemanha</option>
                        <option value="Andorra">Andorra</option>
                        <option value="Angola">Angola</option>
                        <option value="Anguilla">Anguilla</option>
                        <option value="Antigua">Antigua</option>
                        <option value="Arábia Saudita">Arábia Saudita</option>
                        <option value="Argentina">Argentina</option>
                        <option value="Armênia">Armênia</option>
                        <option value="Aruba">Aruba</option>
                        <option value="Austrália">Austrália</option>
                        <option value="Áustria">Áustria</option>
                        <option value="Azerbaijão">Azerbaijão</option>
                        <option value="Bahamas">Bahamas</option>
                        <option value="Bahrein">Bahrein</option>
                        <option value="Bangladesh">Bangladesh</option>
                        <option value="Barbados">Barbados</option>
                        <option value="Bélgica">Bélgica</option>
                        <option value="Benin">Benin</option>
                        <option value="Bermudas">Bermudas</option>
                        <option value="Botsuana">Botsuana</option>
                        <option value="Brasil" selected>Brasil</option>
                        <option value="Brunei">Brunei</option>
                        <option value="Bulgária">Bulgária</option>
                        <option value="Burkina Fasso">Burkina Fasso</option>
                        <option value="botão">botão</option>
                        <option value="Cabo Verde">Cabo Verde</option>
                        <option value="Camarões">Camarões</option>
                        <option value="Camboja">Camboja</option>
                        <option value="Canadá">Canadá</option>
                        <option value="Cazaquistão">Cazaquistão</option>
                        <option value="Chade">Chade</option>
                        <option value="Chile">Chile</option>
                        <option value="China">China</option>
                        <option value="Cidade do Vaticano">Cidade do Vaticano</option>
                        <option value="Colômbia">Colômbia</option>
                        <option value="Congo">Congo</option>
                        <option value="Coréia do Sul">Coréia do Sul</option>
                        <option value="Costa do Marfim">Costa do Marfim</option>
                        <option value="Costa Rica">Costa Rica</option>
                        <option value="Croácia">Croácia</option>
                        <option value="Dinamarca">Dinamarca</option>
                        <option value="Djibuti">Djibuti</option>
                        <option value="Dominica">Dominica</option>
                        <option value="EUA">EUA</option>
                        <option value="Egito">Egito</option>
                        <option value="El Salvador">El Salvador</option>
                        <option value="Emirados Árabes">Emirados Árabes</option>
                        <option value="Equador">Equador</option>
                        <option value="Eritréia">Eritréia</option>
                        <option value="Escócia">Escócia</option>
                        <option value="Eslováquia">Eslováquia</option>
                        <option value="Eslovênia">Eslovênia</option>
                        <option value="Espanha">Espanha</option>
                        <option value="Estônia">Estônia</option>
                        <option value="Etiópia">Etiópia</option>
                        <option value="Fiji">Fiji</option>
                        <option value="Filipinas">Filipinas</option>
                        <option value="Finlândia">Finlândia</option>
                        <option value="França">França</option>
                        <option value="Gabão">Gabão</option>
                        <option value="Gâmbia">Gâmbia</option>
                        <option value="Gana">Gana</option>
                        <option value="Geórgia">Geórgia</option>
                        <option value="Gibraltar">Gibraltar</option>
                        <option value="Granada">Granada</option>
                        <option value="Grécia">Grécia</option>
                        <option value="Guadalupe">Guadalupe</option>
                        <option value="Guam">Guam</option>
                        <option value="Guatemala">Guatemala</option>
                        <option value="Guiana">Guiana</option>
                        <option value="Guiana Francesa">Guiana Francesa</option>
                        <option value="Guiné-bissau">Guiné-bissau</option>
                        <option value="Haiti">Haiti</option>
                        <option value="Holanda">Holanda</option>
                        <option value="Honduras">Honduras</option>
                        <option value="Hong Kong">Hong Kong</option>
                        <option value="Hungria">Hungria</option>
                        <option value="Iêmen">Iêmen</option>
                        <option value="Ilhas Cayman">Ilhas Cayman</option>
                        <option value="Ilhas Cook">Ilhas Cook</option>
                        <option value="Ilhas Curaçao">Ilhas Curaçao</option>
                        <option value="Ilhas Marshall">Ilhas Marshall</option>
                        <option value="Ilhas Turks & Caicos">Ilhas Turks & Caicos</option>
                        <option value="Ilhas Virgens (brit.)">Ilhas Virgens (brit.)</option>
                        <option value="Ilhas Virgens(amer.)">Ilhas Virgens(amer.)</option>
                        <option value="Ilhas Wallis e Futuna">Ilhas Wallis e Futuna</option>
                        <option value="Índia">Índia</option>
                        <option value="Indonésia">Indonésia</option>
                        <option value="Inglaterra">Inglaterra</option>
                        <option value="Irlanda">Irlanda</option>
                        <option value="Islândia">Islândia</option>
                        <option value="Israel">Israel</option>
                        <option value="Itália">Itália</option>
                        <option value="Jamaica">Jamaica</option>
                        <option value="Japão">Japão</option>
                        <option value="Jordânia">Jordânia</option>
                        <option value="Kuwait">Kuwait</option>
                        <option value="Latvia">Latvia</option>
                        <option value="Líbano">Líbano</option>
                        <option value="Liechtenstein">Liechtenstein</option>
                        <option value="Lituânia">Lituânia</option>
                        <option value="Luxemburgo">Luxemburgo</option>
                        <option value="Macau">Macau</option>
                        <option value="Macedônia">Macedônia</option>
                        <option value="Madagascar">Madagascar</option>
                        <option value="Malásia">Malásia</option>
                        <option value="Malaui">Malaui</option>
                        <option value="Mali">Mali</option>
                        <option value="Malta">Malta</option>
                        <option value="Marrocos">Marrocos</option>
                        <option value="Martinica">Martinica</option>
                        <option value="Mauritânia">Mauritânia</option>
                        <option value="Mauritius">Mauritius</option>
                        <option value="México">México</option>
                        <option value="Moldova">Moldova</option>
                        <option value="Mônaco">Mônaco</option>
                        <option value="Montserrat">Montserrat</option>
                        <option value="Nepal">Nepal</option>
                        <option value="Nicarágua">Nicarágua</option>
                        <option value="Niger">Niger</option>
                        <option value="Nigéria">Nigéria</option>
                        <option value="Noruega">Noruega</option>
                        <option value="Nova Caledônia">Nova Caledônia</option>
                        <option value="Nova Zelândia">Nova Zelândia</option>
                        <option value="Omã">Omã</option>
                        <option value="Palau">Palau</option>
                        <option value="Panamá">Panamá</option>
                        <option value="Papua-nova Guiné">Papua-nova Guiné</option>
                        <option value="Paquistão">Paquistão</option>
                        <option value="Peru">Peru</option>
                        <option value="Polinésia Francesa">Polinésia Francesa</option>
                        <option value="Polônia">Polônia</option>
                        <option value="Porto Rico">Porto Rico</option>
                        <option value="Portugal">Portugal</option>
                        <option value="Qatar">Qatar</option>
                        <option value="Quênia">Quênia</option>
                        <option value="Rep. Dominicana">Rep. Dominicana</option>
                        <option value="Rep. Tcheca">Rep. Tcheca</option>
                        <option value="Reunion">Reunion</option>
                        <option value="Romênia">Romênia</option>
                        <option value="Ruanda">Ruanda</option>
                        <option value="Rússia">Rússia</option>
                        <option value="Saipan">Saipan</option>
                        <option value="Samoa Americana">Samoa Americana</option>
                        <option value="Senegal">Senegal</option>
                        <option value="Serra Leone">Serra Leone</option>
                        <option value="Seychelles">Seychelles</option>
                        <option value="Singapura">Singapura</option>
                        <option value="Síria">Síria</option>
                        <option value="Sri Lanka">Sri Lanka</option>
                        <option value="St. Kitts & Nevis">St. Kitts & Nevis</option>
                        <option value="St. Lúcia">St. Lúcia</option>
                        <option value="St. Vincent">St. Vincent</option>
                        <option value="Sudão">Sudão</option>
                        <option value="Suécia">Suécia</option>
                        <option value="Suiça">Suiça</option>
                        <option value="Suriname">Suriname</option>
                        <option value="Tailândia">Tailândia</option>
                        <option value="Taiwan">Taiwan</option>
                        <option value="Tanzânia">Tanzânia</option>
                        <option value="Togo">Togo</option>
                        <option value="Trinidad & Tobago">Trinidad & Tobago</option>
                        <option value="Tunísia">Tunísia</option>
                        <option value="Turquia">Turquia</option>
                        <option value="Ucrânia">Ucrânia</option>
                        <option value="Uganda">Uganda</option>
                        <option value="Uruguai">Uruguai</option>
                        <option value="Venezuela">Venezuela</option>
                        <option value="Vietnã">Vietnã</option>
                        <option value="Zaire">Zaire</option>
                        <option value="Zâmbia">Zâmbia</option>
                        <option value="Zimbábue">Zimbábue</option>
                    </select>
                </div>
                <div class="field">
                    <label for="selectTipoEndereco">Tipo de Endereço</label>
                    <select name="selectTipoEndereco" id="selectTipoEndereco">
                        <%
                            if (endereco.getTipoEndereco().getDescricaoTipo().equals("COBRANCA")) {
                                out.println("<option value='COBRANCA' selected='true'>Cobrança</option>");
                                out.println("<option value='ENTREGA'>Entrega</option>");
                            } else if (endereco.getTipoEndereco().getDescricaoTipo().equals("ENTREGA")) {
                                out.println("<option value='COBRANCA'>Cobrança</option>");
                                out.println("<option value='ENTREGA' selected='true'>Entrega</option>");
                            } else {
                                out.println("<option value='COBRANCA'>Cobrança</option>");
                                out.println("<option value='ENTREGA'>Entrega</option>");
                            }
                        %>
                    </select>
                </div>
            </div>
            <input type="hidden" name="idCliente" id="idCliente" value="<%out.print(endereco.getCliente().getId());%>"/>
            <input type="hidden" name="idEndereco" id="idEndereco" value="<%out.print(endereco.getId());%>"/>
            <input type="submit" id="OPERACAO" name="OPERACAO" value="ALTERAR" class="ui primary button right floated"/>
        </form>
    </body>
</html>
