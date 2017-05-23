/*
 * UVG
 * Hoja de trabajo 8
 * Daniel Morales 15526
 * Rodrigo Corona 15102
 * Fernando Hernandez 15476
*/	

public interface Graph<T extends Comparable<T>> {
        boolean  addVertex(Vertex<T> v);
        boolean addEdge(Vertex<T> v1, Vertex<T> v2);
        int size();
        boolean removeEdge(Vertex<T> v1, Vertex<T> v2);
        boolean hasEdge(Vertex<T> v1, Vertex<T> v2);

    }

    class Vertex<E extends Comparable<E>> {
      E vertex;
    }