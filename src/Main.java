//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MiLista miLista = new MiLista();

        miLista.insertHead("Ana");
        System.out.println(miLista.toString());
        miLista.insertTail(2);
        miLista.insertTail(true);
        miLista.insertTail("Juan");
        miLista.insertTail("Pedro");
        miLista.insertTail(false);
        miLista.getSize();

        System.out.println(miLista.toString());
        System.out.println(miLista.getSize());


        System.out.println(miLista.getHead());
        System.out.println(miLista.getTail());

        miLista.clear();

        System.out.println(miLista.toString());
        System.out.println(miLista.getSize());


    }
}


