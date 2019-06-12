package br.com.ecomerce.dao;

import br.com.ecomerce.dao.AbstractDAO;
import br.com.ecomerce.dominio.*;
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

public class ClienteDAO extends AbstractDAO {

    
    // Contrutor 1: Recebe uma conexão já aberta e os dados da tabela e coluna de banco de dados.
    public ClienteDAO(Connection connection, String table, String idTable) {
        super(connection, table, idTable);
    }

    
    // Contrutor 2: Recebe aoenas os dados da tabela e da coluna do banco de dados.
    public ClienteDAO(String table, String idTable) {
        super(table, idTable);
    }

    public ClienteDAO() {
        super("tb_cliente", "cli_id");
    }
    
    // Salva os dados de cliente.
    @Override
    public void salvar(EntidadeDominio entidadeDominio) {
        /*if(connection == null){
            openConnection();
        }*/
        openConnection();
        
        PreparedStatement pst = null;
        Cliente cliente = (Cliente)entidadeDominio;
        EnderecoDAO enderecosDAO = new EnderecoDAO();
        CartaoCreditoDAO cartoesDAO = new CartaoCreditoDAO();
        TelefoneDAO telefonesDAO = new TelefoneDAO();
        StringBuilder sql = new StringBuilder();

        sql.append("INSERT INTO " + table + "(cli_genero, cli_data_nascimento, ");		// criadno o codigo sql
        sql.append("cli_email, cli_status, cli_cpf, cli_nome, cli_senha) ");
        sql.append("VALUES (?, ?, ?, ?, ?, ?, ?)");

        try{
//            connection.setAutoCommit(false);			
            pst = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);		// retorna as chaves primárias geradas
            pst.setString(1, cliente.getGenero());
            pst.setDate(2, new java.sql.Date(cliente.getDataNascimento().getTime())); 
            pst.setString(3, cliente.getEmail());
            pst.setString(4, cliente.getStatus());
            pst.setString(5, cliente.getCpf());
            pst.setString(6, cliente.getNome());
            pst.setString(7, cliente.getSenha());
            pst.executeUpdate();

            ResultSet rs = pst.getGeneratedKeys();  // Gera os id automaticamente
            int idCliente = 0;
            if(rs.next()){
                idCliente = rs.getInt(1);
            }
            cliente.setId(idCliente);
            
            for (Endereco endereco : cliente.getEnderecos()) {
                endereco.setCliente(cliente);
                enderecosDAO.salvar(endereco);
                
            }
            for (Telefone telefone : cliente.getTelefones()) {
                telefone.setCliente(cliente);
                telefonesDAO.salvar(telefone);
                
            }
            for (CartaoCredito cartao : cliente.getCartoesCredito()) {
                cartao.setCliente(cliente);
                cartoesDAO.salvar(cartao);
                
            }
            
            // Fecha a conexão
            connection.close();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void alterar(EntidadeDominio entidadeDominio) {
        openConnection();
        
        PreparedStatement pst = null;
        Cliente cliente = (Cliente)entidadeDominio;
        StringBuilder sql = new StringBuilder();
        if(cliente.getStatus().trim().equals("INATIVO")){
            sql.append("UPDATE "+table+" SET ");
            sql.append("cli_status = ? ");
            sql.append("WHERE " + idtable + " = " + cliente.getId());
            
            try{
                pst = connection.prepareStatement(sql.toString());
                
                pst.setString(1, cliente.getStatus());
                
                pst.executeUpdate();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }else if(cliente.getSenha() != null){
            sql.append("UPDATE "+table+" SET ");
            sql.append("cli_senha = ? ");
            sql.append("WHERE " + table + " = " + cliente.getId());
            
            try{
                pst = connection.prepareStatement(sql.toString());
                
                pst.setString(1, cliente.getSenha());
                
                pst.executeUpdate();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }else{
            sql.append("UPDATE "+table+" SET ");
            sql.append("cli_genero=?, ");
            sql.append("cli_data_nascimento=?, ");
            sql.append("cli_email=?, ");
            sql.append("cli_status=?, ");
            sql.append("cli_cpf=?, ");
            sql.append("cli_nome=? ");
            sql.append("WHERE " + idtable + " = " + cliente.getId()+";");
            
            try{
                pst = connection.prepareStatement(sql.toString());
                pst.setString(1, cliente.getGenero());
                pst.setDate(2, new java.sql.Date(cliente.getDataNascimento().getTime())); 
                pst.setString(3, cliente.getEmail());
                pst.setString(4, cliente.getStatus());
                pst.setString(5, cliente.getCpf());
                pst.setString(6, cliente.getNome());
                pst.executeUpdate();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }openConnection();
        
        
        
    }

    // Consulta um telefone com base no ID de telefone recebido por parametro
    @Override
    public List<EntidadeDominio> consultar(EntidadeDominio entidadeDominio) {
        List<EntidadeDominio> clientes = new ArrayList<EntidadeDominio>();
        Cliente cliente = (Cliente) entidadeDominio;
        EnderecoDAO enderecosDAO = new EnderecoDAO();
        TelefoneDAO telefonesDAO = new TelefoneDAO();
        CartaoCreditoDAO cartoesDAO = new CartaoCreditoDAO();
       
        ResultSet rs;
        
        openConnection();
        
        PreparedStatement pst = null;
        StringBuilder sql = new StringBuilder();

        if(cliente.getId() == 0 && cliente.getNome().equals("")){
            sql.append("SELECT * ");
            sql.append("FROM " + table);
        }else if(cliente.getId() != 0 && cliente.getNome().equals("")){
            sql.append("SELECT * ");
            sql.append("FROM " + table);
            sql.append(" WHERE " + idtable + " = " + cliente.getId());
        }else if(cliente.getId() == 0 && !cliente.getNome().equals("")){
            sql.append("SELECT * ");
            sql.append("FROM " + table);
            sql.append(" WHERE cli_nome like '%" + cliente.getNome() + "%'");
        }
        try {
            pst = connection.prepareStatement(sql.toString());
            
            rs = pst.executeQuery();

            while(rs.next()){   
                cliente = new Cliente(rs.getString("cli_genero"), new java.util.Date(rs.getDate("cli_data_nascimento").getTime()), rs.getString("cli_email"), rs.getString("cli_status"), rs.getString("cli_cpf"), rs.getString("cli_nome"), rs.getString("cli_senha"));
                cliente.setId(rs.getInt("cli_id"));
                ArrayList<Endereco> enderecos = new ArrayList<Endereco>();
                Endereco endereco = new Endereco();
                endereco.setCliente(cliente);
                for(EntidadeDominio e:enderecosDAO.consultar(endereco)){
                    enderecos.add((Endereco)e);
                }
                
                ArrayList<Telefone> telefones = new ArrayList<Telefone>();
                Telefone telefone = new Telefone();
                telefone.setCliente(cliente);
                for(EntidadeDominio t:telefonesDAO.consultar(telefone)){
                    telefones.add((Telefone)t);
                }
                
                ArrayList<CartaoCredito> cartoes = new ArrayList<CartaoCredito>();
                CartaoCredito cartao = new CartaoCredito();
                cartao.setCliente(cliente);
                for(EntidadeDominio c:cartoesDAO.consultar(cartao)){
                    cartoes.add((CartaoCredito)c);
                }
                
                // Salvando as consultas de enreco, cartao e telefone no cliente
                cliente.setEnderecos(enderecos);
                cliente.setCartoesCredito(cartoes);
                cliente.setTelefones(telefones);
                
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();	
        }
        return clientes;
    }

    @Override
    public void excluir(EntidadeDominio entidadeDominio) {
        Cliente cliente = (Cliente) entidadeDominio;
        cliente.setStatus("INATIVO");
        alterar(cliente);
    }
    
    

}
