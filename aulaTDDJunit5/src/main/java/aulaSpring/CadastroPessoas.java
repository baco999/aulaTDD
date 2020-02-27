package aulaSpring;



import java.util.ArrayList;
import java.util.List;

public class CadastroPessoas {

    private List<Pessoa> pessoas;

    public CadastroPessoas() {
        this.pessoas = new ArrayList<>();
    }

    public List<Pessoa> getPessoas() {
        return this.pessoas;
    }

    public void adicionar(Pessoa pessoa) throws CadastroException {
        if (pessoa.getNome() == null || pessoa.getNome().isEmpty()){
            throw new CadastroException("Nome nao pode estar vazio ou nulo");
        }
        this.pessoas.add(pessoa);
    }

    public void remover(Pessoa pessoa) throws CadastroException {
        if (this.pessoas.isEmpty()){
            throw new CadastroException("Não existe pessoa cadastrada para deletar");
        }
        this.pessoas.remove(pessoa);
    }
}
