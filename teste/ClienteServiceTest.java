import DAO.ClienteDaoMock;
import DAO.IClienteDao;
import Model.Cliente;
import Service.ClienteService;
import Service.IClienteService;
import exception.TipoChaveNaoEncontradoException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteServiceTest {

    private IClienteService clienteService;
    private Cliente cliente;

    public ClienteServiceTest(){
        IClienteDao dao = new ClienteDaoMock();
        clienteService = new ClienteService(dao);
    }

    @Before
    public void init(){
        cliente = new Cliente();
        cliente.setNome("João");
        cliente.setCpf(12345678912L);
        cliente.setCidade("Joaboatão dos guararapes");
        cliente.setEnd("rua violetas");
        cliente.setEstado("PE");
        cliente.setNumero(35);
        cliente.setTelefone(81978953651L);

    }

    @Test
    public void pesquisarCliente(){
        Cliente clienteConsultado = clienteService.buscarPorCpf(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradoException {
        Boolean retorno = clienteService.salvar(cliente);
        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente(){
        clienteService.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradoException {
        cliente.setNome("beatriz");
        clienteService.alterar(cliente);

        Assert.assertEquals("beatriz",cliente.getNome());

    }

}
