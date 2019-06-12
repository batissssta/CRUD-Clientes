package br.com.ecomerce.dao;

import br.com.ecomerce.dominio.Cliente;
import br.com.ecomerce.dominio.EntidadeDominio;
import br.com.ecomerce.dominio.Telefone;
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
public class TelefoneDAO extends AbstractDAO{

    public TelefoneDAO(Connection connection, String table, String idTable) {
        super(connection, table, idTable);
    }

    public TelefoneDAO(String table, String idTable) {
        super(table, idTable);
    }

    public TelefoneDAO() {
        super("tb_telefone", "tel_id");
    }

    // Recebe uma EntidadeDominio cria um Cliente e salva todos os telefones que esse Cliente tem
    @Override
    public void salvar(EntidadeDominio entidadeDominio) {
        Telefone telefone = (Telefone)entidadeDominio;
        if(connection == null){
            openConnection();
        }
        
        PreparedStatement pst = null;
        StringBuilder sql = new StringBuilder();

        sql.append("INSERT INTO " + table + " (tel_tipo, tel_ddd, tel_numero, tel_cli_id) ");
        sql.append(" VALUES (?, ?, ?, ?)");
        try {
            pst = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

            pst.setString(1, telefone.getTipo());
            pst.setString(2, telefone.getDdd());
            pst.setString(3, telefone.getNumeroTelefone());
            pst.setInt(4, telefone.getCliente().getId());
            pst.executeUpdate();		

            ResultSet rs = pst.getGeneratedKeys();
            int idTelefone = 0;
            if(rs.next()){
                idTelefone = rs.getInt(1);
            }
            telefone.setId(idTelefone);
            connection.close();
            
            connection = null;
        } catch (SQLException ex) {
            ex.printStackTrace();	
        }
    }

    // Recebe um Cliente e atualiza todos os telefones que o Cliente possui.
    @Override
    public void alterar(EntidadeDominio entidadeDominio) {
        Telefone telefone = (Telefone) entidadeDominio;
        
        openConnection();
        
        PreparedStatement pst = null;
        StringBuilder sql = new StringBuilder();

        sql.append("UPDATE " + table + "(tel_tipo, tel_ddd, tel_numero) ");
        sql.append(" VALUES (?, ?, ?)");
        sql.append(" WHERE " + idtable + " = ?");
        try {
            pst = connection.prepareStatement(sql.toString());

            pst.setString(1, telefone.getTipo());
            pst.setString(2, telefone.getDdd());
            pst.setString(3, telefone.getNumeroTelefone());
            pst.setInt(4, telefone.getId());
            pst.executeUpdate();		

            connection.close();					
        } catch (SQLException ex) {
                ex.printStackTrace();	
        }
    }

    // Consulta telefones
    @Override
    public List<EntidadeDominio> consultar(EntidadeDominio entidadeDominio) {
        Telefone tel = (Telefone) entidadeDominio;
        List<EntidadeDominio> telefones = new ArrayList<EntidadeDominio>();
        Telefone telefone;
        ResultSet rs;
        
        openConnection();
        
        PreparedStatement pst = null;
        StringBuilder sql = new StringBuilder();

        if(tel.getId() == 0 && tel.getCliente().getId() == 0){
            sql.append("SELECT * ");
            sql.append("FROM " + table);
        }else if(tel.getId() != 0 && tel.getCliente().getId() == 0){
            sql.append("SELECT * ");
            sql.append("FROM " + table);
            sql.append(" WHERE " + idtable + " = " + tel.getId());
        }else if(tel.getId() == 0 && tel.getCliente().getId() != 0){
            sql.append("SELECT * ");
            sql.append("FROM " + table);
            sql.append(" WHERE tel_cli_id = " + tel.getCliente().getId());
        }else if(tel.getId() != 0 && tel.getCliente().getId() != 0){
            sql.append("SELECT * ");
            sql.append("FROM " + table);
            sql.append(" WHERE " + idtable + " = " + tel.getId());
        }
        try {
            pst = connection.prepareStatement(sql.toString());
            
            rs = pst.executeQuery();		

            while(rs.next()){
                telefone = new Telefone(rs.getString("tel_tipo"), rs.getString("tel_ddd"), rs.getString("tel_numero"));
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("tel_cli_id"));
                telefone.setCliente(cliente);
                telefone.setId(rs.getInt("tel_id"));
                telefones.add(telefone);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();	
        }
        return telefones;
    }
}
