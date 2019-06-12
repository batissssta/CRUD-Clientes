package br.com.ecomerce.negocio.cliente;

import br.com.ecomerce.dominio.Cliente;
import br.com.ecomerce.dominio.EntidadeDominio;
import br.com.ecomerce.negocio.IStrategy;

/**
 *
 * @author Marcelo Vilas Boas Correa Filho
 */
public class ValidaSenha implements IStrategy {

    @Override
    public String processar(EntidadeDominio entidade) {
        Cliente cliente = (Cliente) entidade;
        StringBuilder msg = new StringBuilder();
        
        if(cliente.getSenha().trim().equals("") || cliente.getSenha() == null){
            msg.append("A senha é obrigatória.");
        }
        
        if(cliente.getConfirmarSenha().trim().equals("") || cliente.getConfirmarSenha() == null){
            msg.append("A confirmação da senha é obrigatória.");
        }
        
        return msg.toString();
    }

}
