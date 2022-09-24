public class ContaPoupanca extends Conta{

    private int diaAniversario;

    @Override
    public String toString() {
        return "ContaPoupanca{" +
                "diaAniversario=" + diaAniversario +
                ", numero=" + super.getNumero() +
                ", dataAbertura='" + super.getData() + '\'' +
                ", status=" + super.isStatus() +
                ", senha='" + super.getSenha() + '\'' +
                ", saldo=" + super.getSaldo() +
                ", donoDaConta=" + super.getTitularDaConta() +
                ", rendimentos=" + rendimentos +
                '}';
    }

    public int getDiaAniversario() {
        return diaAniversario;
    }

    private float rendimentos=0f;

    public float getRendimentos() {
        return rendimentos;
    }

    public void setRendimentos(float rendimentos) {
        this.rendimentos = rendimentos;
    }

    public void setDiaAniversario(int diaAniversario) {
        this.diaAniversario = diaAniversario;
    }

    public void atualizaTaxa(){
        float saldoAnterior = getSaldo();
        float saldoComRendimento = getSaldo()*1.005f;
        super.setSaldo(saldoComRendimento);

        float resultado = saldoComRendimento - saldoAnterior;

        MovimentoConta movimento = new MovimentoConta();
        movimento.setTipoMovimentacao("Juros");
        movimento.setValorMovimentado(resultado);
        rendimentos = rendimentos +resultado;
        super.adicionaMovimento(movimento);

    }

    public ContaPoupanca(int numero, String dataAbertura, boolean status, String senha, float saldo, int diaAniversario, Pessoa donoDaConta){
        super.setNumero(numero);
        super.setData(dataAbertura);
        super.setStatus(status);
        super.setSenha(senha);
        super.setSaldo(saldo);
        this.diaAniversario = diaAniversario;
        super.setTitularDaConta(donoDaConta);
    }


}
