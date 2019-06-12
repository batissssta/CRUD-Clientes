/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ecomerce.negocio.endereco;

import br.com.ecomerce.dominio.Endereco;
import br.com.ecomerce.dominio.EntidadeDominio;
import br.com.ecomerce.negocio.IStrategy;

/**
 *
 * @author Lucas
 */
public class ValidaDadosEndereco implements IStrategy {

    @Override
    public String processar(EntidadeDominio entidade) {
        Endereco endereco = (Endereco)entidade;
        if(endereco.getLogradouro().trim().equals("") || endereco.getLogradouro() == null) {
            return "Logradouro do endereço inválido";
        }
        if(endereco.getNumeroEndereco().trim().equals("") || endereco.getNumeroEndereco() == null) {
            return "Número do endereço inválido";
        }
        if(endereco.getTipoEndereco().getDescricaoTipo().trim().equals("S") || endereco.getTipoEndereco().getDescricaoTipo()== null){
            return ("O tipo do endereço precisa ser selecionada.\n");
        }
        if(endereco.getTipoResidencia().trim().equals("S") || endereco.getTipoResidencia() == null) {
            return "O tipo de residência do endereço precisa ser selecionado.";
        }
        if(endereco.getBairro().getNome().trim().equals("") || endereco.getBairro().getNome() == null) {
            return "Bairro do endereço inválido";
        }
        if(endereco
                .getBairro()
                .getCidade()
                .getNome()
                .trim().equals("") 
                || 
            endereco
                .getBairro()
                .getCidade()
                .getNome() == null) {
            return "Cidade do endereço inválido";
        }
        if(endereco
                .getBairro()
                .getCidade()
                .getEstado()
                .getSigla()
                .trim().equals("S") 
                || 
            endereco
                .getBairro()
                .getCidade()
                .getEstado()
                .getSigla() == null) {
            return "Estado do endereço inválido";
        }
        if(endereco
                .getBairro()
                .getCidade()
                .getEstado()
                .getPais()
                .getNome()
                .trim().equals("") 
                || 
            endereco
                .getBairro()
                .getCidade()
                .getEstado()
                .getPais()
                .getNome() == null) {
            return "País do endereço inválido";
        }
        if(endereco.getTipoEndereco().getDescricaoTipo().trim().equals("S") || endereco.getTipoEndereco().getDescricaoTipo() == null) {
            return "O tipo do endereço precisa ser selecionado.";
        }
        return null;
        
    }
    
}
