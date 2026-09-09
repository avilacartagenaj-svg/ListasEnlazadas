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
        cabeza = null;
    }

    @Override
    public Object getHead() {
        if (cabeza == null){
            return null;
        }
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
        if (node == null) {
            return null;
        }
        return node.dato;
    }

    @Override
    public Object search(Object object) {
        if (object == null) {
            return null;
        }

        ListNode iterador = cabeza;

        while (iterador != null) {
            if (iterador.dato.equals(object)) {
                return iterador;
            }
            iterador = iterador.siguiente;
        }
        return null;
    }

    @Override
    public boolean add(Object object) {
        if (object == null) return false;

        ListNode nuevo = new ListNode(object);

        if (cabeza == null) {
            cabeza = nuevo;
            return true;
        }

        ListNode actual = cabeza;
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }
        actual.siguiente = nuevo;
        return true;
    }

    @Override
    public boolean insert(ListNode node, Object object) {
        if (node == null || object == null) return false;

        ListNode actual = cabeza;

        while (actual != null) {
            if (actual == node) {
                ListNode nuevo = new ListNode(object);
                nuevo.siguiente = actual.siguiente;
                actual.siguiente = nuevo;
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    @Override
    public boolean insert(Object ob, Object object) {
        ListNode nodoReferencia = (ListNode) search(ob);

        if (nodoReferencia == null) {
            return false;
        }
        return insert(nodoReferencia, object);
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
        if (cabeza == null) {
            cabeza = nuevaCola;
            return true;
        }

        ListNode i = this.cabeza;
        while (i.siguiente != null) {
            i = i.siguiente;
        }
        i.siguiente = nuevaCola;

        return true;
    }

    @Override
    public boolean set(ListNode node, Object object) {
        if (node == null || object == null) return false;

        ListNode actual = cabeza;

        while (actual != null) {
            if (actual == node) {
                actual.dato = object;
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    @Override
    public boolean remove(ListNode node) {
        if (node == null || cabeza == null) return false;

        // Caso especial: el nodo a eliminar es la cabeza
        if (cabeza == node) {
            cabeza = cabeza.siguiente;
            return true;
        }

        ListNode anterior = cabeza;
        while (anterior.siguiente != null) {
            if (anterior.siguiente == node) {
                anterior.siguiente = node.siguiente;
                return true;
            }
            anterior = anterior.siguiente;
        }
        return false;
    }

    @Override
    public boolean contains(Object object) {
        return search(object) != null;
    }


    @Override
    public Object[] toArray() {
        Object[] arreglo = new Object[getSize()];
        ListNode actual = cabeza;
        int i = 0;

        while (actual != null) {
            arreglo[i] = actual.dato;
            i++;
            actual = actual.siguiente;
        }
        return arreglo;
    }

    @Override
    public Object[] toArray(Object[] object) {
        int size = getSize();

        // Si el arreglo recibido no tiene espacio suficiente, se crea uno nuevo
        if (object.length < size) {
            object = new Object[size];
        }

        ListNode actual = cabeza;
        int i = 0;

        while (actual != null) {
            object[i] = actual.dato;
            i++;
            actual = actual.siguiente;
        }

        if (object.length > size) {
            object[size] = null;
        }

        return object;
    }


    @Override
    public Object getBeforeTo(ListNode node) {
        if (node == null || cabeza == null || cabeza == node) {
            return null; // no hay "anterior" si es la cabeza o no existe
        }

        ListNode actual = cabeza;
        while (actual.siguiente != null) {
            if (actual.siguiente == node) {
                return actual.dato;
            }
            actual = actual.siguiente;
        }
        return null;
    }


    @Override
    public Object getNextTo(ListNode node) {
        if (node == null || node.siguiente == null) {
            return null;
        }
        return node.siguiente.dato;
    }

    @Override
    public MiLista subList(ListNode from, ListNode to) {
        if (from == null || to == null) return null;

        MiLista sub = new MiLista();
        ListNode actual = from;
        boolean encontrado = false;

        while (actual != null) {
            sub.insertTail(actual.dato);
            if (actual == to) {
                encontrado = true;
                break;
            }
            actual = actual.siguiente;
        }

        return encontrado ? sub : null;
    }

    @Override
    public MiLista sortList() {
        MiLista ordenada = new MiLista();
        Object[] arreglo = this.toArray();

        for (int i = 0; i < arreglo.length - 1; i++) {
            for (int j = 0; j < arreglo.length - 1 - i; j++) {
                Comparable actual = (Comparable) arreglo[j];
                if (actual.compareTo(arreglo[j + 1]) > 0) {
                    Object temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }

        for (Object dato : arreglo) {
            ordenada.insertTail(dato);
        }

        return ordenada;
    }

    @Override
    public String toString() {
        if (cabeza == null) {
            return "[]";
        }

        String resultado = "[";
        ListNode actual = cabeza;

        while (actual != null) {
            resultado = resultado + actual.dato;
            if (actual.siguiente != null) {
                resultado = resultado + ", ";
            }
            actual = actual.siguiente;
        }
        resultado = resultado + "]";

        return resultado;
    }
}
