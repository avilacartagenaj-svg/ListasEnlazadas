import java.util.Iterator;

public class MiLista implements ListInterface{
    ListNode cabeza = null;

    @Override
    public boolean isEmpty() {
        return cabeza == null;
    }


    @Override
    public int getSize() {

        ListNode iterador = cabeza;

        int contador = 0;

        while (iterador != null) {
            contador++;
            iterador = iterador.siguiente;
        }
        return contador;
    }

    @Override
    public void clear() {
        this.cabeza = null;
    }

    @Override
    public Object getHead() {
        return this.cabeza.dato;
    }

    @Override
    public Object getTail() {

        if (cabeza == null) {
            return null;
        }
        ListNode iterador = cabeza;

        while (iterador.siguiente != null) {
            iterador = iterador.siguiente;
        }
        return iterador.dato;
    }

    @Override
    public Object get(ListNode node) {
        return null;
    }

    @Override
    public Object search(Object object) {
        return null;
    }

    @Override
    public boolean add(Object object) {
        return false;
    }

    @Override
    public boolean insert(ListNode node, Object object) {
        return false;
    }

    @Override
    public boolean insert(Object ob, Object object) {
        return false;
    }

    @Override
    public boolean insertHead(Object object) {
        try {
            ListNode nuevaCabeza = new ListNode(object);
            ListNode viejaCabeza = this.cabeza;
            this.cabeza = nuevaCabeza;
            nuevaCabeza.siguiente = viejaCabeza;
            return true;

        } catch (Exception e){
            System.out.println("Ocuurió un error");
            System.out.println(e);
            return false;
        }

    }

    @Override
    public boolean insertTail(Object object) {
        ListNode nuevaCola = new ListNode(object);
        ListNode i = this.cabeza;

        while (i.siguiente != null) {
            i = i.siguiente;
        }

        i.siguiente = nuevaCola;

        return false;
    }

    @Override
    public boolean set(ListNode node, Object object) {
        return false;
    }

    @Override
    public boolean remove(ListNode node) {
        return false;
    }

    @Override
    public boolean contains(Object object) {
        return false;
    }


    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] object) {
        return new Object[0];
    }


    @Override
    public Object getBeforeTo(ListNode node) {
        return null;
    }
    

    @Override
    public Object getNextTo(ListNode node) {
        return null;
    }

    @Override
    public MiLista subList(ListNode from, ListNode to) {
        return null;
    }

    @Override
    public MiLista sortList() {
        return null;
    }

    @Override
    public String toString() {
        return "MiLista{" +
                "cabeza=" + cabeza +
                '}';
    }
}
