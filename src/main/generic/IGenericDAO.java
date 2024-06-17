package generic;

import exception.TipoChaveNaoEncontradoException;
import persistence.Persistence;

import java.util.Collection;

public interface IGenericDAO <T extends Persistence>{

    public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradoException;

    public void excluir(Long valor);

    public void alterar(T entity) throws TipoChaveNaoEncontradoException;

    public T consultar(Long valor);

    public Collection<T> buscarTodos();

}
