/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ecomerce.negocio.cartao;

import br.com.ecomerce.dominio.CartaoCredito;
import br.com.ecomerce.dominio.EntidadeDominio;
import br.com.ecomerce.negocio.IStrategy;

/**
 *
 * @author Marcelo Vilas Boas Correa Filho
 */
public class ValidaCartao implements IStrategy{

    @Override
    public String processar(EntidadeDominio entidade) {
        CartaoCredito cartao = (CartaoCredito) entidade;
        StringBuilder msg = new StringBuilder();
        
        if(cartao.getBandeira().getNome().trim().equals("")){
            msg.append("A bandeira do cartão é obrigatório.");
        }
        
        if(cartao.getCodigoSeguranca().trim().equals("")){
            msg.append("O código de segurança é obrigatório.");
        }
        
        if(cartao.getNomeImpresso().trim().equals("")){
            msg.append("O nome impresso no cartão é obrigatório.");
        }
        
        if(cartao.getNumeroCartao().trim().equals("")){
            msg.append("O número do cartão é obrigatório.");
        }
        
        if(cartao.getValidade().toString().trim().equals("")){
            msg.append("A data de validade é obrigatória");
        }
        
        return msg.toString();
    }
    
}
