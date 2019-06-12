/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ecomerce.negocio;

import br.com.ecomerce.dominio.EntidadeDominio;

/**
 *
 * @author Lucas
 */
public interface IStrategy {
	public String processar(EntidadeDominio entidade);
}

