/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ecomerce.dominio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class Resultado {
private String msg;
    
    private List<EntidadeDominio> entidades;
    public String getMsg() {
            return msg;
    }
    public void setMsg(String msg) {
            this.msg = msg;
    }
    public List<EntidadeDominio> getEntidades() {
            return entidades;
    }
    public void setEntidades(List<EntidadeDominio> entidades) {
            this.entidades = entidades;
    }

    public void addEntidade(EntidadeDominio entidade) {
            if(entidades == null) {
                    entidades = new ArrayList<EntidadeDominio>();
            }
            entidades.add(entidade);
    }    

}
