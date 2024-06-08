import java.util.*;

public class Grafo {
    private List<Vertice> listaVertices;

    public void agregarNodo(Vertice verticeNuevo) {
        if (listaVertices == null) {
            listaVertices = new ArrayList<>();
        }
        listaVertices.add(verticeNuevo);
    }

    public List<Vertice> getVertices() {
        return listaVertices;
    }
    public void verificarvertice(){
        
    }
    public void agregarAristas() {
        int opcion;
        int peso = 0;
        Vertice destino, origen;
        Scanner entrada = new Scanner(System.in);
        do {
            for (int i = 0; i < listaVertices.size(); i++)
                System.out.println((i + 1) + " " + listaVertices.get(i).getDato());
            System.out.println("Seleccione el numero del vertice origen");
            opcion = entrada.nextInt();
            origen = listaVertices.get(opcion - 1);
            System.out.println("Indique el numero del vertice destino");
            opcion = entrada.nextInt();
            destino = listaVertices.get(opcion - 1);
            System.out.println("Indique el peso");
            do {
                peso = entrada.nextInt();
                if (peso > 0) {
                    origen.setAristas(new Arista(origen, destino, peso));
                }else{
                    System.out.println("Vuelva a ingresar los datos,el peso es debe de ser mayor a 0");
                }
            } while (peso <= 0);
            System.out.println("Agregar más aristas: 1)SI\t2)NO");
            opcion = entrada.nextInt();
        } while (opcion == 1);
    }

    @Override
    public String toString() {
        return "GRAFO [" + getVertices() + "]\n";
    }
}