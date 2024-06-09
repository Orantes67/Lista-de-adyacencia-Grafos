import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Vertice {
    private int dato;
    private List<Arista> listaAristas;

    public Vertice(int opc) {
        this.dato = opc;
        this.listaAristas = new ArrayList<>();
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public int getDato() {
        return dato;
    }

    public List<Arista> getAristas() {
        return listaAristas;
    }

    public void setAristas(Arista arista) {
        if (listaAristas == null) {
            listaAristas = new ArrayList<>();
        }
        listaAristas.add(arista);
    }

    @Override
    public String toString() {
        return "\n\tVertice=" + getDato() + ", Aristas=" + getAristas();
    }
}