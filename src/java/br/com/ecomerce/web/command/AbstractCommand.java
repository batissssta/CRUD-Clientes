/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ecomerce.web.command;

import br.com.ecomerce.web.fachada.Fachada;
import br.com.ecomerce.web.fachada.IFachada;

/**
 *
 * @author Lucas
 */
public abstract class AbstractCommand implements ICommand {
    protected IFachada fachada = new Fachada();
}
