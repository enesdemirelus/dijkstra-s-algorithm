package org.example;
import java.util.*;

public class Graph {
    private final Map<String, Vertex> vertices;

    public static class Vertex {
        public String name;
        public List<Vertex> neighbors;

        public Vertex(String name) {
            this.name = name;
            this.neighbors = new ArrayList<>();
        }

        @Override
        public String toString() {
            return this.name;
        }
    }

    public Graph() {
        this.vertices = new HashMap<>();
    }

    public void addVertex(String name) {
        vertices.putIfAbsent(name, new Vertex(name));
    }

    public void addEdge(String from, String to) {
        Vertex v1 = vertices.get(from);
        Vertex v2 = vertices.get(to);
        if (v1 != null && v2 != null && !v1.neighbors.contains(v2)) {
            v1.neighbors.add(v2);
            v2.neighbors.add(v1);
        }
    }

    public void printGraph() {
        for (Vertex v: this.vertices.values()) {
            System.out.print(v.name + " -> ");
            for (Vertex neighbor: v.neighbors) {
                System.out.print(neighbor.name + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");


        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("C", "D");

        graph.printGraph();
    }

}