public class ContaEspecial extends Conta{

    private float limite;

    public float getLimite() {
        return limite;
    }

    public void setLimite(float limite) {
        this.limite = limite;
    }

    public void atualizaTaxa(){

        super.setSaldo(getSaldo()-30);
        MovimentoConta movimento = new MovimentoConta();
        movimento.setTipoMovimentacao("Taxa");
        movimento.setValorMovimentado(30f);
        super.adicionaMovimento(movimento);

    }

    public ContaEspecial(int numero, String data, boolean status, String senha, float saldo, float limite, Pessoa titularDaConta){

        super.setNumero(numero);
        super.setData(data);
        super.setStatus(status);
        super.setSenha(senha);
        super.setSaldo(saldo);
        this.limite = limite;

        super.setTitularDaConta(titularDaConta);

    }

    @Override
    public String toString() {
        return "ContaEspecial{" +
                " limite=" + this.getLimite() +
                ", numero=" + super.getNumero() +
                ", data='" + super.getData() + '\'' +
                ", status=" + super.isStatus() +
                ", senha='" + super.getSenha() + '\'' +
                ", saldo=" + super.getSaldo() +
                ", titularDaConta=" + super.getTitularDaConta() +

                '}';
    }
}
