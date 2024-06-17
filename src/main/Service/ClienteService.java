package Service;

import DAO.ClienteDao;
import DAO.IClienteDao;
import Model.Cliente;
import exception.TipoChaveNaoEncontradoException;

public class ClienteService implements IClienteService{

    private IClienteDao clienteDao;

    public ClienteService(IClienteDao clienteDao){
        this.clienteDao = clienteDao;
    }


    @Override
    public Boolean salvar(Cliente cliente) throws TipoChaveNaoEncontradoException {
        return clienteDao.cadastrar(cliente);
    }

    @Override
    public Cliente buscarPorCpf(Long cpf) {
        return clienteDao.consultar(cpf);
    }

    @Override
    public void excluir(Long cpf) {
        clienteDao.excluir(cpf);
    }

    @Override
    public void alterar(Cliente cliente) throws TipoChaveNaoEncontradoException {
        clienteDao.alterar(cliente);

    }
}
