package Graph_GUI.Model;
import java.util.Vector;
import java.awt.Graphics;

public class drawAdm {
    public Vector<Edge> edges;
    public Vector<Vertex> vertices;

    public drawAdm(){
        edges = new Vector<Edge>();
        vertices = new Vector<Vertex>();
    }

    public void drawAll(Graphics g){
        for (Vertex v : vertices){
            v.draw(g);
        }
        for (Edge e : edges){
            e.draw(g);
        }
    }
}
