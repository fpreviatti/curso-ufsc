public class PessoaFisica extends Pessoa{

    private String cpf;
    private String dataNasc;
    private String rg;
    private float renda;
    private String nome;

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public float getRenda() {
        return renda;
    }

    public void setRenda(float renda) {
        this.renda = renda;
    }

    public PessoaFisica(String cpf, String nome, String dataNasc, String rg, float renda){
        this.cpf = cpf;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.rg = rg;
        this.renda = renda;
    }

    @Override
    public String toString() {
        return "PessoaFisica [" +
                "cpf=" + cpf +
                ", dataNascimento=" + dataNasc +
                ", rg=" + rg +
                ", renda=" + renda +
                ", nome=" + nome+
                ']';
    }
}
