import java.util.*;

public class Conta extends ElementosDoBanco{

    private int numero;
    private String data;
    private boolean status;
    private String senha;
    private float saldo;
    private Pessoa titularDaConta;
    private MovimentoConta movimento;
    private  List<MovimentoConta> movimentos = new ArrayList<>();

    public MovimentoConta getMovimento() {
        return movimento;
    }

    public void setMovimento(MovimentoConta movimento) {
        this.movimento = movimento;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public Pessoa getTitularDaConta() {
        return titularDaConta;
    }

    public void setTitularDaConta(Pessoa titularDaConta) {
        this.titularDaConta = titularDaConta;
    }

    public Conta(){

    }

    public Conta(int numero, String data, boolean status, String senha, float saldo, Pessoa titularDaConta){
        this.numero = numero;
        this.data = data;
        this.status = status;
        this.senha = senha;
        this.saldo = saldo;
        this.titularDaConta = titularDaConta;
        movimento = new MovimentoConta();
        movimentos = new ArrayList<>();
    }

    public void deposito(float valor){
        this.saldo = saldo + valor;
        movimento = new MovimentoConta();
        movimento.setTipoMovimentacao("Deposito");
        movimento.setValorMovimentado(valor);
        movimentos.add(movimento);
    }

    public void saque(float valor){
        this.saldo = saldo - valor;
        movimento = new MovimentoConta();
        movimento.setTipoMovimentacao("Saque");
        movimento.setValorMovimentado(valor);
        movimentos.add(movimento);
    }

    public void atualizaTaxa(){
        this.saldo = saldo-20;
            movimento = new MovimentoConta();
            movimento.setTipoMovimentacao("Taxa");
            movimento.setValorMovimentado(20);
            movimentos.add(movimento);

    }

    public void adicionaMovimento(MovimentoConta m){
        movimentos.add(m);
    }

    public void relatorio(){
        System.out.println("Conta : " +this.getNumero());
        if(this.getClass().equals(ContaPoupanca.class)){
            System.out.println("Tipo: Conta Poupanca");
            System.out.println("Dia Aniversario : "+((ContaPoupanca) this).getDiaAniversario());
        }
        if(this.getClass().equals(ContaEspecial.class)){
            System.out.println("Tipo: Conta Especial");
            System.out.println("Limite : "+((ContaEspecial) this).getLimite());
        }
        if(this.getClass().equals(Conta.class)){
            System.out.println("Tipo: Conta Comum");
        }
        System.out.println("Abertura: " +this.data);
        if(this.status==true){
            System.out.println("Status : " +"Ativa");
        }
        if(this.status==false){
            System.out.println("Status : " +"Inativa");
        }
        System.out.println("Titular : " +this.titularDaConta);
        System.out.println("Movimentos: ");

        for(int i=0; i<movimentos.size();i++){
            System.out.println(i+1 +" " +movimentos.get(i).getTipoMovimentacao() +" " + movimentos.get(i).getValorMovimentado());
        }

        System.out.println("Saldo: " +this.saldo);

        if(this.getClass().equals(ContaPoupanca.class)){
            System.out.println("Rendimentos: " +((ContaPoupanca) this).getRendimentos());
        }

        System.out.println("-------------------------------");

    }


    @Override
    public String toString() {
        return "Conta{" +
                "numero=" + numero +
                ", data='" + data + '\'' +
                ", status=" + status +
                ", senha='" + senha + '\'' +
                ", saldo=" + saldo +
                ", titularDaConta=" + titularDaConta +
                '}';
    }
}
