import java.util.List;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Grafo grafo = verificarVertices();
        System.out.println(grafo);
    }

    public static Vertice crearVertice() {
        Scanner entrada = new Scanner(System.in);
        int opc;
        do {
            System.out.println("Ingresa el valor del vértice (debe ser múltiplo de 4 y mayor a 0):");
            while (!entrada.hasNextInt()) {
                System.out.println("ingrese un número");
                entrada.next();
            }
            opc = entrada.nextInt();
        } while (!validarVertice(opc) || opc <= 0);
        return new Vertice(opc);
    }

    public static Grafo verificarVertices() {
        Scanner entrada = new Scanner(System.in);
        int cantidad = 0;
        do {
            System.out.println("Indica la cantidad de vértices del grafo (debe ser mayor a 0):");
            while (!entrada.hasNextInt()) {
                System.out.println("ingrese un número");
                entrada.next();
            }
            cantidad = entrada.nextInt();
        } while (cantidad <= 0);

        Grafo grafo = new Grafo();
        int verticesAgregados = 0;

        while (verticesAgregados < cantidad) {
            Vertice verticeNuevo = crearVertice();
            boolean duplicado = false;

            List<Vertice> listaVertices = grafo.getVertices();
            for (int i = 0; i < listaVertices.size(); i++) {
                Vertice v = listaVertices.get(i);
                if (v.getDato() == verticeNuevo.getDato()) {
                    duplicado = true;
                }
            }

            if (duplicado == false) {
                grafo.agregarNodo(verticeNuevo);
                verticesAgregados++;
            } else {
                System.out.println("El valor ingresado ya está presente en un vértice existente.");
            }
        }

        grafo.agregarAristas();
        return grafo;
    }

    public static boolean validarVertice(int opc) {
        int r = 4;
        if (opc % r == 0) {
            return true;
        } else {
            System.out.println(" ERROR --ingrese un múltiplo de 4 -- ");
            return false;
        }
    }
}
