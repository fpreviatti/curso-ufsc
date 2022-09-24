import java.util.HashMap;
import java.util.Map;

public class Principal {

	public static void main(String[] args) {
		Map<Integer, Pessoa> mapapessoas = new HashMap<>();
		mapapessoas.put(3, new Pessoa(3, "João"));
		mapapessoas.put(2, new Pessoa(2, "Maria"));
		mapapessoas.put(5, new Pessoa(5, "Ana"));
		mapapessoas.put(7, new Pessoa(7, "Paulo"));
		mapapessoas.put(4, new Pessoa(4, "Carlos"));
		
		if (mapapessoas.containsKey(3)) {			
			System.out.println("achou");
			Pessoa p = mapapessoas.get(3);
			System.out.println(p.toString());
		}
		
		//List<Pessoa> pessoas = mapapessoas.values();
	}

}
