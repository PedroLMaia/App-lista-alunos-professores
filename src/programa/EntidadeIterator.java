package programa;

import entidades.Entidade;

import java.util.ArrayList;
import java.util.Iterator;

public class EntidadeIterator implements Iterator<Entidade> {

    private final ArrayList<Entidade> entidades;
    private int index = 0;

    public EntidadeIterator(ArrayList<Entidade> lista) {
        this.entidades = lista;
    }

    public ArrayList<Entidade> get() {
        return this.entidades;
    }

    public Entidade get(int index) {
        return entidades.get(index);
    }

    public int getIndex() {
        return this.index;
    }

    @Override
    public boolean hasNext() {
        if (this.index < entidades.size() && this.entidades.get(index) != null) {
            return true;
        }
        this.index = 0;
        return false;
    }

    @Override
    public Entidade next() {
        Entidade entidade = entidades.get(index);
        this.index++;
        return entidade;
    }
}
