import java.util.Comparator;

public class Pessoa implements Comparable<Pessoa>{
	
	// atributos
	private int codigo;
	private String nome;
	private int idade;
	private float vlHora;
	private float horasTrab;

	
	// construtores
	public Pessoa() {		
	}
	
	public Pessoa(int codigo) {		
		this.codigo = codigo;
		
	}
	
	public Pessoa(int codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}

	public Pessoa(String codigo) {
		this.codigo = Integer.valueOf(codigo);
	}
	
	public Pessoa(int codigo, String nome, int idade, float vlHora, float horasTrab) {	
		this.codigo = codigo;
		this.nome = nome;
		this.idade = idade;
		this.vlHora = vlHora;
		this.horasTrab = horasTrab;
	}


	// métodos
	public float calcSalario(){
		return vlHora*horasTrab;
	}


	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public float getVlHora() {
		return vlHora;
	}

	public void setVlHora(float vlHora) {
		this.vlHora = vlHora;
	}

	public float getHorasTrab() {
		return horasTrab;
	}

	public void setHorasTrab(float horasTrab) {
		this.horasTrab = horasTrab;
	}

	@Override
	public String toString() {
		return "Pessoa [codigo=" + codigo + ", nome=" + nome + ", idade=" + idade + ", vlHora=" + vlHora
				+ ", horasTrab=" + horasTrab + "]";
	}
	
	// destructor
	// é executado no momento em que o objeto é desalocado
	
	public Pessoa clone() {
		Pessoa pclone = new Pessoa(this.codigo, this.nome);
		pclone.setIdade(idade);
		pclone.setVlHora(vlHora);
		pclone.setHorasTrab(horasTrab);
		return pclone;
	}

	@Override
	public int compareTo(Pessoa p) {
		return this.nome.compareTo(p.getNome());		
	}

}

class ComparatorPessoaCodigoDec implements Comparator<Pessoa>{
	@Override
	public int compare(Pessoa p1, Pessoa p2) {
		if (p1.getCodigo() > p2.getCodigo()) {
			return -1;
		} else if (p1.getCodigo() < p2.getCodigo()) {
			return 1;
		} else {
			return 0;
		}				
	}
}

class ComparatorPessoaNomeCre implements Comparator<Pessoa>{
	@Override
	public int compare(Pessoa p1, Pessoa p2) {
		return p1.getNome().compareTo(p2.getNome());
	}
}

