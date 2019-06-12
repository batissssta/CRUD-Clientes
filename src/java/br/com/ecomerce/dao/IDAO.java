package br.com.ecomerce.dao;

import br.com.ecomerce.dominio.*;
import java.util.List;

public interface IDAO {

    public void salvar(EntidadeDominio entidadeDominio);

    public void alterar(EntidadeDominio entidadeDominio);

    public void excluir(EntidadeDominio entidadeDominio);

    public List<EntidadeDominio> consultar(EntidadeDominio entidadeDominio);

}
