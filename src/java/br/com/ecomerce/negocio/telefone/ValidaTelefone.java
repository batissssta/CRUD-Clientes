/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ecomerce.negocio.telefone;

import br.com.ecomerce.dominio.EntidadeDominio;
import br.com.ecomerce.dominio.Telefone;
import br.com.ecomerce.negocio.IStrategy;

/**
 *
 * @author Marcelo Vilas Boas Correa Filho
 */
public class ValidaTelefone implements IStrategy{

    @Override
    public String processar(EntidadeDominio entidade) {
        Telefone telefone = (Telefone) entidade;
        StringBuilder msg = new StringBuilder();
        
        if(telefone.getDdd().trim().equals("")){
            msg.append("O DDD do telefone é obrigatório.");
        }
        
        if(telefone.getNumeroTelefone().trim().equals("")){
            msg.append("O número do telefone é obrigatório.");
        }
        
        if(telefone.getTipo().trim().equals("")){
            msg.append("O tipo do telefone é obrigatório.");
        }
        
        return msg.toString();
    }
}
