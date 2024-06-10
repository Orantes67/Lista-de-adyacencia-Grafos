import java.util.*;

public class Grafo {
    private List<Vertice> listaVertices;

    public Grafo() {
        this.listaVertices = new ArrayList<>();
    }

    public void agregarNodo(Vertice verticeNuevo) {
        if (listaVertices == null) {
            listaVertices = new ArrayList<>();
        }
        listaVertices.add(verticeNuevo);
    }

    public List<Vertice> getVertices() {
        return listaVertices;
    }

    public void agregarAristas() {
        int opcion;
        Vertice destino, origen;
        Scanner entrada = new Scanner(System.in);
        boolean aristaExistenteOrigen;
        boolean aristaExistenteDestino;

        do {
            for (int i = 0; i < listaVertices.size(); i++) {
                System.out.println((i + 1) + " " + listaVertices.get(i).getDato());
            }
            do {
                System.out.println("Seleccione el número del vértice origen (debe ser mayor a 0):");
                while (!entrada.hasNextInt()) {
                    System.out.println("Ingrese un número válido.");
                    entrada.next();
                }
                opcion = entrada.nextInt();
                if (opcion <= 0 || opcion > listaVertices.size()) {
                    System.out.println("Número de vértice no válido. Intente de nuevo.");
                }
            } while (opcion <= 0 || opcion > listaVertices.size());
            origen = listaVertices.get(opcion - 1);
            do {
                System.out.println("Indique el número del vértice destino (debe ser mayor a 0):");
                while (!entrada.hasNextInt()) {
                    System.out.println("Ingrese un número válido.");
                    entrada.next();
                }
                opcion = entrada.nextInt();
                if (opcion <= 0 || opcion > listaVertices.size()) {
                    System.out.println("Número de vértice no válido. Intente de nuevo.");
                }
            } while (opcion <= 0 || opcion > listaVertices.size());
            destino = listaVertices.get(opcion - 1);

            int peso;
            boolean pesoValido;
            do {
                System.out.println("Indique el peso (debe ser mayor a 0):");
                while (!entrada.hasNextInt()) {
                    System.out.println("Ingrese un número válido.");
                    entrada.next();
                }
                peso = entrada.nextInt();
                if (peso <= 0) {
                    System.out.println("El peso debe ser mayor a 0. Vuelva a ingresar los datos.");
                    pesoValido = false;
                } else {
                    pesoValido = true;
                    aristaExistenteOrigen = false;
                    aristaExistenteDestino = false;

                    for (int i = 0; i < origen.getAristas().size(); i++) {
                        Arista aristaExistente = origen.getAristas().get(i);
                        if (aristaExistente != null && aristaExistente.getPeso() == peso) {
                            aristaExistenteOrigen = true;
                        }
                    }

                    for (int i = 0; i < destino.getAristas().size(); i++) {
                        Arista aristaExistente = destino.getAristas().get(i);
                        if (aristaExistente != null && aristaExistente.getPeso() == peso) {
                            aristaExistenteDestino = true;
                        }
                    }

                    if (aristaExistenteOrigen || aristaExistenteDestino) {
                        System.out.println("El peso ingresado ya está asociado a otra arista. Vuelva a intentarlo.");
                        pesoValido = false;
                    } else {
                        origen.setAristas(new Arista(origen, destino, peso));
                    }
                }
            } while (!pesoValido);

            System.out.println("Agregar más aristas: 1)SI\t2)NO");
            while (!entrada.hasNextInt()) {
                System.out.println("Ingrese un número válido.");
                entrada.next();
            }
            opcion = entrada.nextInt();
        } while (opcion == 1);
    }
    @Override
    public String toString() {
        return "GRAFO [" + getVertices() + "]\n";
    }
}