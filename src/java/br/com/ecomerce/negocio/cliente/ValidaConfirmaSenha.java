/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ecomerce.negocio.cliente;

import br.com.ecomerce.dominio.Cliente;
import br.com.ecomerce.dominio.EntidadeDominio;
import br.com.ecomerce.negocio.IStrategy;

/**
 *
 * @author Lucas
 */
public class ValidaConfirmaSenha implements IStrategy {

    @Override
    public String processar(EntidadeDominio entidade) {
        Cliente cliente = (Cliente)entidade;
        if(!(cliente.getSenha().equals(cliente.getConfirmarSenha()))) {
             return "As duas senhas devem coincidir";
        }
        return null;
    }
    
}
