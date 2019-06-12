/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ecomerce.negocio.cliente;

import br.com.ecomerce.dominio.Cliente;
import br.com.ecomerce.dominio.EntidadeDominio;
import br.com.ecomerce.negocio.IStrategy;
import br.com.ecomerce.negocio.endereco.ValidaEndereco;

/**
 *
 * @author Lucas
 */
public class ValidaExistenciaEndEntregaECorrespondencia implements IStrategy {

    @Override
    public String processar(EntidadeDominio entidade) {
        Cliente cliente = (Cliente) entidade;
        StringBuilder msg = new StringBuilder();
        ValidaEndereco v = new ValidaEndereco();
        if(!v.processar(cliente.getEnderecos().get(0)).trim().equals("")) {
            msg.append("Erros endereço um: ");
            msg.append(v.processar(cliente.getEnderecos().get(0)));
        }
        if(!v.processar(cliente.getEnderecos().get(1)).trim().equals("")) {
            msg.append("Erros endereço dois: ");
            msg.append(v.processar(cliente.getEnderecos().get(1)));
        }
        
        if(msg.toString().equals("")) {
            if(cliente.getEnderecos().get(0).getTipoEndereco().getDescricaoTipo().equals(cliente.getEnderecos().get(1).getTipoEndereco().getDescricaoTipo())){
                msg.append("Deve-se cadastrar ao menos um endereço de correspondência, e ao menos um endereço de entrega");
            }
        }
        return msg.toString();
    }
    
}
