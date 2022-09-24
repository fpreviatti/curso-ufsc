import java.util.Locale;

public class PessoaJuridica extends Pessoa{

    //cnpj, nome, cidade, estado

    private String cnpj;
    private String cidade;
    private String estado;
    private String nome;

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public PessoaJuridica(String cnpj, String nome, String cidade, String estado){
    this.cnpj = cnpj;
    this.nome = nome;
    this.cidade = cidade;
    this.estado = estado;
    }

    @Override
    public String toString() {
        return "PessoaJuridica [" +
                "cnpj=" + cnpj +
                ", cidade=" + cidade +
                ", estado=" + estado +
                ", nome=" + nome+
                ']';
    }
}
