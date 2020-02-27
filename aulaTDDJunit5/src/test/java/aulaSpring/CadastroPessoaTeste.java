package aulaSpring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CadastroPessoaTeste {

    CadastroPessoas cadastro;
    Pessoa pessoa;

    /*
    @BeforeEach Executa antes de cada teste
    @BeforeAll Executa Uma vez antes de todos os testes
     */
    @BeforeEach
    public void setUp(){
        cadastro = new CadastroPessoas();
        pessoa = new Pessoa();
    }

    @Test
    @DisplayName("Deve criar o cadastro de pessoas")
    public void deveCriarCadastroDePessoas(){
        //Cenario

        //Execuçãao

        //Validação
        Assertions.assertThat(cadastro.getPessoas()).isEmpty();

    }

    @Test
    @DisplayName("Deve adicionar uma pessoa ao cadastro")
    public void deveAdicionarUmaPessoa() throws CadastroException {
        //Cenario
        pessoa.setNome("Wilson");

        //execução
        cadastro.adicionar(pessoa);

        //validação
        Assertions.assertThat(cadastro.getPessoas())
                .isNotEmpty()//Valida para nao estar vazio
                .hasSize(1)//Deve conter 1 elemente
                .contains(pessoa);//O valor que ira conter no cadastro ou seja "Pessoa"

    }

    @Test//(expected = CadastroException.class) Junit4
    @DisplayName("Não deve adicionar uma pessoa com nome vazio ou nulo")
    public void naoDeveAdicionarPessoaComNomeVazioOuNulo() throws CadastroException {

        //Cenario
        pessoa.setNome(null);

        //Execução
        org.junit.jupiter.api.Assertions.assertThrows(
                CadastroException.class, () -> cadastro.adicionar(pessoa));

        //validacao
    }

    @Test
    @DisplayName("Deve deletar uma pessoa cadastrada")
    public void deveRemoverUmaPessoa() throws CadastroException {
        //cenario
        pessoa.setNome("Wilson");
        cadastro.adicionar(pessoa);

        //execução
        cadastro.remover(pessoa);

        //validação
        Assertions.assertThat(cadastro.getPessoas()).isEmpty();
    }

    @Test//(expected = CadastroException.class) Junit4
    @DisplayName("Deve retornar erro caso tente deletar uma pessoa que nao existe")
    public void deveRetornarErroAoRemoverPessoaInexistente() throws CadastroException {

        //cenario

        //execução Aplicando exception com Junit5
        org.junit.jupiter.api.Assertions.assertThrows(
                CadastroException.class, () -> cadastro.remover(pessoa));
        //validação
    }
}
