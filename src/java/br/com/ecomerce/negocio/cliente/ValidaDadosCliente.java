/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ecomerce.negocio.cliente;

import br.com.ecomerce.dominio.Cliente;
import br.com.ecomerce.dominio.EntidadeDominio;
import br.com.ecomerce.negocio.IStrategy;
import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author Marcelo Vilas Boas Correa Filho
 */
public class ValidaDadosCliente implements IStrategy{

    @Override
    public String processar(EntidadeDominio entidade) {
        Cliente cliente = (Cliente) entidade;
        StringBuilder msg = new StringBuilder();

        if(cliente.getDataNascimento() == new Date(0L) || cliente.getDataNascimento() == null) {
            msg.append("Data inválida.\n");
        }

        if(cliente.getNome().trim().equals("") || cliente.getNome() == null){
            msg.append("O Nome precisa ser preenchido.\n");
        }

        if(cliente.getEmail().trim().equals("") || cliente.getEmail() == null){
            msg.append("O E-mail precisa ser preenchido.\n");
        }

        if(cliente.getGenero().trim().equals("S") || cliente.getGenero() == null){
            msg.append("O Gênero precisa ser selecionado.\n");
        }

        if(cliente.getCpf().trim().equals("") || cliente.getCpf() == null){
            msg.append("O CPF precisa ser preenchido.\n");
        }   
        
        return msg.toString();
    }
    
}
