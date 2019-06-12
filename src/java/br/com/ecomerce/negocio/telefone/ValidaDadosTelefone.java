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
 * @author Lucas
 */
public class ValidaDadosTelefone implements IStrategy {
    
    @Override
    public String processar(EntidadeDominio entidade) {
        Telefone telefone = (Telefone)entidade;
        if(telefone.getTipo().trim().equals("S") || telefone.getTipo() == null) {
            return "Tipo do telefone inválido";
        }
        if(telefone.getDdd().trim().equals("") || telefone.getDdd() == null) {
            return "DDD do telefone inválido";
        }
        if(telefone.getNumeroTelefone().trim().equals("") || telefone.getNumeroTelefone()== null) {
            return "Número do telefone inválido";
        }
        return null;
    }
    
}
