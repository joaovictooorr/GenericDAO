import DAO.ClienteDaoMock;
import DAO.IClienteDao;
import Model.Cliente;
import exception.TipoChaveNaoEncontradoException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteDAOTest {

    private IClienteDao clienteDao;
    private Cliente cliente;

    public ClienteDAOTest(){
        clienteDao = new ClienteDaoMock();
    }

    @Before
    public void init(){
        cliente = new Cliente();
        cliente.setNome("João");
        cliente.setCpf(12345678912L);
        cliente.setCidade("Joaboatão dos guararapes");
        cliente.setEnd("rua violetas");
        cliente.setEstado("PE");
        cliente.setNumero(1145);
        cliente.setTelefone(81978953651L);

    }


    @Test
    public void pesquisarCliente(){
        Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);

    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradoException {
        Boolean retorno = clienteDao.cadastrar(cliente);
        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente(){
        clienteDao.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradoException {
        cliente.setNome("beatriz");
        clienteDao.alterar(cliente);

        Assert.assertEquals("beatriz",cliente.getNome());

    }
}
