package DAO;

import Model.Cliente;
import exception.TipoChaveNaoEncontradoException;

import java.util.Collection;

public class ClienteDaoMock implements IClienteDao{
    @Override
    public Boolean cadastrar(Cliente entity) throws TipoChaveNaoEncontradoException {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public void excluir(Long valor) {
        // TODO Auto-generated method stub

    }

    @Override
    public void alterar(Cliente entity) throws TipoChaveNaoEncontradoException {
        // TODO Auto-generated method stub

    }

    @Override
    public Cliente consultar(Long valor) {
        Cliente cliente = new Cliente();
        cliente.setCpf(valor);
        return cliente;
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        // TODO Auto-generated method stub
        return null;
    }
}
