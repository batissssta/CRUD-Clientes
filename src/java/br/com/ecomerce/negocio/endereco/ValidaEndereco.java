/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ecomerce.negocio.endereco;

import br.com.ecomerce.dominio.Bairro;
import br.com.ecomerce.dominio.Cidade;
import br.com.ecomerce.dominio.Endereco;
import br.com.ecomerce.dominio.EntidadeDominio;
import br.com.ecomerce.dominio.Estado;
import br.com.ecomerce.dominio.Pais;
import br.com.ecomerce.dominio.TipoEndereco;
import br.com.ecomerce.negocio.IStrategy;

/**
 *
 * @author Marcelo Vilas Boas Correa Filho
 */
public class ValidaEndereco implements IStrategy{

    @Override
    public String processar(EntidadeDominio entidade) {
        // Validando Endereço
        Endereco endereco = (Endereco) entidade;
        StringBuilder msg = new StringBuilder();
        // Validando Pais
        if (endereco.getBairro().getCidade().getEstado().getPais().getNome().trim().equals("")) {
            msg.append("O País é obrigatório.");
        }

        // Validando estado
        if (endereco.getBairro().getCidade().getEstado().getSigla().trim().equals("")) {
            msg.append("O Estado é obrigatório.");
        }

        // Validando Cidade
        if (endereco.getBairro().getCidade().getNome().trim().equals("")) {
            msg.append("A Cidade é obrigatório.");
        }

        // Validando Bairro
        if (endereco.getBairro().getNome().trim().equals("")) {
            msg.append("O Bairro é obrigatório.");
        }

        // Validando tipo endereco
        if (endereco.getTipoEndereco().getDescricaoTipo().trim().equals("")) {
            msg.append("O tipo de endereço é obrigatório.");
        }

        // Validando demais dados de endereço
        if (endereco.getLogradouro().trim().equals("")) {
            msg.append("O logradouro é obrigatório.");
        }

        if (endereco.getNumeroEndereco().trim().equals("")) {
            msg.append("O número do endereço é obrigatório.");
        }

        if (endereco.getCep().trim().equals("")) {
            msg.append("O CEP é obrigatório.");
        }
        
        if(endereco.getTipoLogradouro().trim().equals("")){
            msg.append("O tipo de logradouro é obrigatório.");
        }
        
        if(endereco.getTipoResidencia().trim().equals("")){
            msg.append("O tipo de residência é obrigatório.");
        }
        
        return msg.toString();
    }
}
