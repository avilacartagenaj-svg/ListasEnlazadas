//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MiLista miLista = new MiLista();

        System.out.println("--- Insertar ---");
        miLista.insertHead("Ana");
        System.out.println(miLista.toString());
        miLista.insertTail(2);
        miLista.insertTail(true);
        miLista.insertTail("Juan");
        miLista.insertTail("Pedro");
        miLista.insertTail(false);
        System.out.println(miLista.toString());
        System.out.println("Tamaño: " + miLista.getSize());

        System.out.println("\n--- Head / Tail ---");
        System.out.println("Head: " + miLista.getHead());
        System.out.println("Tail: " + miLista.getTail());

        System.out.println("\n--- Search / Contains ---");
        Object nodoEncontrado = miLista.search(true);
        System.out.println("Search(true): " + nodoEncontrado);
        System.out.println("Contains('Juan'): " + miLista.contains("Juan"));
        System.out.println("Contains(999): " + miLista.contains(999));

        System.out.println("\n--- Get / Insert / Set usando un nodo ---");
        ListNode nodoJuan = (ListNode) miLista.search("Juan");
        System.out.println("Get(nodoJuan): " + miLista.get(nodoJuan));

        miLista.insert(nodoJuan, "Luis"); // inserta "Luis" después de "Juan"
        System.out.println("Tras insert(nodoJuan, \"Luis\"): " + miLista.toString());

        miLista.insert("Pedro", "Marta"); // inserta "Marta" después de "Pedro"
        System.out.println("Tras insert(\"Pedro\", \"Marta\"): " + miLista.toString());

        miLista.set(nodoJuan, "JUAN_MODIFICADO");
        System.out.println("Tras set(nodoJuan, ...): " + miLista.toString());

        System.out.println("\n--- GetBeforeTo / GetNextTo ---");
        System.out.println("Antes de nodoJuan: " + miLista.getBeforeTo(nodoJuan));
        System.out.println("Después de nodoJuan: " + miLista.getNextTo(nodoJuan));

        System.out.println("\n--- Add ---");
        miLista.add("Al final");
        System.out.println("Tras add: " + miLista.toString());

        System.out.println("\n--- ToArray ---");
        Object[] arreglo = miLista.toArray();
        System.out.println("toArray(): " + java.util.Arrays.toString(arreglo));

        System.out.println("\n--- SubList ---");
        ListNode desde = (ListNode) miLista.search("Ana");
        ListNode hasta = nodoJuan;
        MiLista sub = miLista.subList(desde, hasta);
        System.out.println("SubList(Ana -> Juan_modificado): " + (sub != null ? sub.toString() : "null"));

        System.out.println("\n--- Remove ---");
        miLista.remove(nodoJuan);
        System.out.println("Tras remove(nodoJuan): " + miLista.toString());
        System.out.println("Tamaño: " + miLista.getSize());

        System.out.println("\n--- SortList (lista aparte, mismo tipo) ---");
        MiLista listaNumeros = new MiLista();
        listaNumeros.insertTail(5);
        listaNumeros.insertTail(1);
        listaNumeros.insertTail(9);
        listaNumeros.insertTail(3);
        System.out.println("Antes de ordenar: " + listaNumeros.toString());
        MiLista ordenada = listaNumeros.sortList();
        System.out.println("Ordenada: " + ordenada.toString());

        System.out.println("\n--- Clear ---");
        miLista.clear();
        System.out.println(miLista.toString());
        System.out.println("Tamaño: " + miLista.getSize());
        System.out.println("isEmpty: " + miLista.isEmpty());
    }
}


