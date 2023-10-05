package ar.com.educacionit.desafio4;

public class MainCollection {
	public static void main(String[] args) {
		CollectionCustom<String> cc = new CollectionCustom<String>();
		
		// Metodo size()
		System.out.println("Se creo el array con " + cc.size() + " elementos.");
		
		// Metodo add(T) - agrego varios elementos
		cc.add("10");
		cc.add("20");
		cc.add("30");
		cc.add("40");
		System.out.println("\nSe agregaron " + cc.size() + " elementos. " + cc);
		
		// Metodo addFirst(T)
		cc.addFirst("1");
		System.out.println("\nAgrego un 1 al comienzo. " + cc);
		
		// Metodo addLast(T)
		cc.addLast("50");
		System.out.println("\nAgrego un 50 al final. " + cc);
				
		// Metodo remove(T)
		cc.remove("20");
		System.out.println("\nSe removio el 20. " + cc);
		
		// Metodo removeAll() - limpio la lista
		cc.removeAll();
		
		// Metodo empty() - compruebo si la lista se limpio
		System.out.println("\nEsta vacia? " + cc.empty());
	}
}
