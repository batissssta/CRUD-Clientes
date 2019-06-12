package br.com.ecomerce.dao;

import br.com.ecomerce.dominio.Bairro;
import br.com.ecomerce.dominio.Cidade;
import br.com.ecomerce.dominio.Cliente;
import br.com.ecomerce.dominio.Endereco;
import br.com.ecomerce.dominio.EntidadeDominio;
import br.com.ecomerce.dominio.Estado;
import br.com.ecomerce.dominio.Pais;
import br.com.ecomerce.dominio.TipoEndereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcelo Vilas Boas Correa Filho
 */

public class EnderecoDAO extends AbstractDAO{

    public EnderecoDAO(Connection connection, String table, String idTable) {
        super(connection, table, idTable);
    }

    public EnderecoDAO(String table, String idTable) {
        super(table, idTable);
    }

    public EnderecoDAO() {
        super("tb_endereco", "end_id");
    }

    // Recebe uma EntidadeDominio cria um Cliente e salva todos os enderecos que esse Cliente tem
    @Override
    public void salvar(EntidadeDominio entidadeDominio) {
        Endereco endereco = (Endereco)entidadeDominio;
        /*if(connection == null){
            openConnection();
        }*/
        openConnection();
        
        PreparedStatement pst = null;
        StringBuilder sql = new StringBuilder();

        sql.append("INSERT INTO " + table + "(end_logradouro, end_numero, end_cep,");
        sql.append(" end_tipo_logradouro, end_tipo_residencia, end_tipo_endereco,");
        sql.append(" end_bairro, end_cidade, end_estado, end_pais, end_cli_id) ");
        sql.append(" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");	
        try {
            pst = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

            pst.setString(1, endereco.getLogradouro());
            pst.setString(2, endereco.getNumeroEndereco());
            pst.setString(3, endereco.getCep());
            pst.setString(4, endereco.getTipoLogradouro());
            pst.setString(5, endereco.getTipoResidencia());
            pst.setString(6, endereco.getTipoEndereco().getDescricaoTipo());
            pst.setString(7, endereco.getBairro().getNome());
            pst.setString(8, endereco.getBairro().getCidade().getNome());
            pst.setString(9, endereco.getBairro().getCidade().getEstado().getSigla());
            pst.setString(10, endereco.getBairro().getCidade().getEstado().getPais().getNome());
            pst.setInt(11, endereco.getCliente().getId());
            pst.executeUpdate();		

            ResultSet rs = pst.getGeneratedKeys();
            int idEndereco = 0;
            if(rs.next()){
                idEndereco = rs.getInt(1);
            }
            endereco.setId(idEndereco);
            connection.close();
            
            connection = null;
        } catch (SQLException ex) {
            ex.printStackTrace();	
        }
    }

    // Altera um endereco com base no endereco recebido por parametro
    @Override
    public void alterar(EntidadeDominio entidadeDominio) {
        Endereco endereco = (Endereco) entidadeDominio;
        
        openConnection();
        
        PreparedStatement pst = null;
        StringBuilder sql = new StringBuilder();

        sql.append("UPDATE " + table + " SET end_logradouro = ?, end_numero = ?, end_cep = ?,");
        sql.append(" end_tipo_logradouro = ?, end_tipo_residencia = ?, end_tipo_endereco = ?,");
        sql.append(" end_bairro = ?, end_cidade = ?, end_estado = ?, end_pais = ?");
        sql.append(" WHERE " + idtable + " = " + endereco.getId() + ";");
        try {
            pst = connection.prepareStatement(sql.toString());

            pst.setString(1, endereco.getLogradouro());
            pst.setString(2, endereco.getNumeroEndereco());
            pst.setString(3, endereco.getCep());
            pst.setString(4, endereco.getTipoLogradouro());
            pst.setString(5, endereco.getTipoResidencia());
            pst.setString(6, endereco.getTipoEndereco().getDescricaoTipo());
            pst.setString(7, endereco.getBairro().getNome());
            pst.setString(8, endereco.getBairro().getCidade().getNome());
            pst.setString(9, endereco.getBairro().getCidade().getEstado().getSigla());
            pst.setString(10, endereco.getBairro().getCidade().getEstado().getPais().getNome());
            
            pst.executeUpdate();		

            connection.close();					
        } catch (SQLException ex) {
                ex.printStackTrace();	
        }
    }

    // Consulta enderecos
    @Override
    public List<EntidadeDominio> consultar(EntidadeDominio entidadeDominio) {
        Endereco end = (Endereco) entidadeDominio;
        List<EntidadeDominio> enderecos = new ArrayList<EntidadeDominio>();
        Endereco endereco;
        Bairro bairro;
        TipoEndereco tipoEndereco;
        ResultSet rs;
        
        openConnection();
        
        PreparedStatement pst = null;
        StringBuilder sql = new StringBuilder();
        
        if(end.getId() == 0 && end.getCliente().getId() == 0){
            sql.append("SELECT * ");
            sql.append("FROM " + table);
        }else if(end.getId() != 0 && end.getCliente().getId() == 0){
            sql.append("SELECT * ");
            sql.append("FROM " + table);
            sql.append(" WHERE " + idtable + " = " + end.getId());
        }else if(end.getId() == 0 && end.getCliente().getId() != 0){
            sql.append("SELECT * ");
            sql.append("FROM " + table);
            sql.append(" WHERE end_cli_id = " + end.getCliente().getId());
        }else if(end.getId() != 0 && end.getCliente().getId() != 0){
            sql.append("SELECT * ");
            sql.append("FROM " + table);
            sql.append(" WHERE " + idtable + " = " + end.getId());
        }
        
        try {
            pst = connection.prepareStatement(sql.toString());
            
            rs = pst.executeQuery();		

            while(rs.next()){
                bairro = new Bairro(rs.getString("end_bairro"), new Cidade(rs.getString("end_cidade"), new Estado(rs.getString("end_estado"), new Pais(rs.getString("end_pais")))));
                tipoEndereco = new TipoEndereco(rs.getString("end_tipo_endereco"));
                endereco = new Endereco(rs.getString("end_logradouro"), rs.getString("end_numero"), rs.getString("end_cep"), rs.getString("end_tipo_logradouro"), rs.getString("end_tipo_residencia"), bairro, tipoEndereco);
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("end_cli_id"));
                endereco.setCliente(cliente);
                endereco.setId(rs.getInt("end_id"));
                enderecos.add(endereco);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();	
        }
        return enderecos;
    }
}
