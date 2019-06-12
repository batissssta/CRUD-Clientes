/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ecomerce.web.command;

import br.com.ecomerce.dominio.EntidadeDominio;
import br.com.ecomerce.dominio.Resultado;
import br.com.ecomerce.web.fachada.IFachada;

/**
 *
 * @author Lucas
 */
public class SalvarCommand extends AbstractCommand {

    @Override
    public Resultado executar(EntidadeDominio entidadeDominio) {
        return fachada.salvar(entidadeDominio);
    }

    
}
