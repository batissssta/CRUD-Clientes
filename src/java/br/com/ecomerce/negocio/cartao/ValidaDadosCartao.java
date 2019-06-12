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
 * @author Lucas
 */
public class ValidaDadosCartao implements IStrategy {
    
    @Override
    public String processar(EntidadeDominio entidade) {
        CartaoCredito cartao = (CartaoCredito) entidade;
        StringBuilder msg = new StringBuilder();
        if(cartao.getNumeroCartao().equals("") || cartao.getNumeroCartao()== null) {
            msg.append("Número do cartão inválido.\n");
        }
        if(cartao.getBandeira().getNome().trim().equals("S") || cartao.getBandeira().getNome() == null){
            msg.append("A bandeira do cartão precisa ser selecionada.\n");
        }
        if(cartao.getNomeImpresso().equals("") || cartao.getNomeImpresso() == null) {
            msg.append("Nome impresso do cartão inválido.\n");
        }
        if(cartao.getCodigoSeguranca().equals("") || cartao.getCodigoSeguranca()== null) {
            msg.append("Código de segurança do cartão do cartão inválido.\n");
        }
        return msg.toString();
    }
}
