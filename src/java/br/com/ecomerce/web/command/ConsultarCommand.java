/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ecomerce.web.command;

import br.com.ecomerce.dominio.EntidadeDominio;
import br.com.ecomerce.dominio.Resultado;

/**
 *
 * @author Lucas
 */
public class ConsultarCommand extends AbstractCommand {

    @Override
    public Resultado executar(EntidadeDominio entidadeDominio) {
        return fachada.consultar(entidadeDominio);
    }
    
}
