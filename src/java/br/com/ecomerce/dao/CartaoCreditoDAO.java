package br.com.ecomerce.dao;

import br.com.ecomerce.dominio.BandeiraCartao;
import br.com.ecomerce.dominio.CartaoCredito;
import br.com.ecomerce.dominio.Cliente;
import br.com.ecomerce.dominio.EntidadeDominio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcelo Vilas Boas Correa FIlho
 */

public class CartaoCreditoDAO extends AbstractDAO{

    public CartaoCreditoDAO(Connection connection, String table, String idTable) {
        super(connection, table, idTable);
    }
    
    public CartaoCreditoDAO(String table, String idTable) {
        super(table, idTable);
    }

    public CartaoCreditoDAO() {
        super("tb_cartao_credito", "crt_id");
    }

    // Consulta cartoes
    @Override
    public void salvar(EntidadeDominio entidadeDominio) {
        CartaoCredito cc = (CartaoCredito)entidadeDominio;
        if(connection == null){
            openConnection();
        }
        PreparedStatement pst = null;
        StringBuilder sql = new StringBuilder();

        sql.append("INSERT INTO " + table + "(crt_codigo_seguranca, crt_numero_cartao,");
        sql.append(" crt_validade, crt_preferido, crt_nome_impresso, crt_bandeira, crt_cli_id) ");
        sql.append(" VALUES (?, ?, ?, ?, ?, ?, ?);");
        try {
            pst = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

            pst.setString(1, cc.getCodigoSeguranca());
            pst.setString(2, cc.getNumeroCartao());
            pst.setDate(3,  new java.sql.Date(cc.getValidade().getTime()));
            pst.setBoolean(4, cc.isPreferido());
            pst.setString(5, cc.getNomeImpresso());
            pst.setString(6, cc.getBandeira().getNome());
            pst.setInt(7, cc.getCliente().getId());
            pst.executeUpdate();		

            ResultSet rs = pst.getGeneratedKeys();
            int idCartaoCredito = 0;
            if(rs.next()){
                idCartaoCredito = rs.getInt(1);
            }
            cc.setId(idCartaoCredito);
            connection.close();	
            
            connection = null;
        } catch (SQLException ex) {
            ex.printStackTrace();	
        }
    }

    // Recebe um Cliente e atualiza todos os telefones que o Cliente possui.
    @Override
    public void alterar(EntidadeDominio entidadeDominio) {
        CartaoCredito cartao = (CartaoCredito) entidadeDominio;
        
        openConnection();
        
        PreparedStatement pst = null;
        StringBuilder sql = new StringBuilder();

        sql.append("UPDATE " + table + " SET crt_codigo_seguranca = ?, crt_numero_cartao = ?,");
        sql.append(" crt_validade = ?, crt_preferido = ?, crt_nome_impresso = ?, crt_bandeira = ?");
        sql.append(" WHERE " + idtable + " = ?;");
        try {
            pst = connection.prepareStatement(sql.toString());

            pst.setString(1, cartao.getCodigoSeguranca());
            pst.setString(2, cartao.getNumeroCartao());
            pst.setDate(3, new java.sql.Date(cartao.getValidade().getTime()));
            pst.setBoolean(4, cartao.isPreferido());
            pst.setString(5, cartao.getNomeImpresso());
            pst.setString(6, cartao.getBandeira().getNome());
            
            pst.setInt(7, cartao.getId());
            pst.executeUpdate();		

            connection.close();					
        } catch (SQLException ex) {
                ex.printStackTrace();	
        }
    }

    // Consulta um cartai com base no ID de cartao recebido por parametro
    @Override
    public List<EntidadeDominio> consultar(EntidadeDominio entidadeDominio) {
        CartaoCredito crt = (CartaoCredito) entidadeDominio;
        List<EntidadeDominio> cartoes = new ArrayList<EntidadeDominio>();
        CartaoCredito cartao;
        BandeiraCartao bandeira;
        ResultSet rs;
        
        openConnection();
        
        PreparedStatement pst = null;
        StringBuilder sql = new StringBuilder();

        if(crt.getId() == 0 && crt.getCliente().getId() == 0){
            sql.append("SELECT * ");
            sql.append("FROM " + table);
        }else if(crt.getId() != 0 && crt.getCliente().getId() == 0){
            sql.append("SELECT * ");
            sql.append("FROM " + table);
            sql.append(" WHERE " + idtable + " = " + crt.getId());
        }else if(crt.getId() == 0 && crt.getCliente().getId() != 0){
            sql.append("SELECT * ");
            sql.append("FROM " + table);
            sql.append(" WHERE crt_cli_id = " + crt.getCliente().getId());
        }else if(crt.getId() != 0 && crt.getCliente().getId() != 0){
            sql.append("SELECT * ");
            sql.append("FROM " + table);
            sql.append(" WHERE " + idtable + " = " + crt.getId());
        }
        
        try {
            pst = connection.prepareStatement(sql.toString());
            
            rs = pst.executeQuery();		

            while(rs.next()){
                bandeira = new BandeiraCartao(rs.getString("crt_bandeira"));
                cartao = new CartaoCredito(rs.getString("crt_codigo_seguranca"), rs.getString("crt_numero_cartao"), new java.util.Date(rs.getDate("crt_validade").getTime()), rs.getBoolean("crt_preferido"), rs.getString("crt_nome_impresso"), bandeira);
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("crt_cli_id"));
                cartao.setCliente(cliente);
                cartao.setId(rs.getInt("crt_id"));
                cartoes.add(cartao);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();	
        }
        return cartoes;
    }
}
