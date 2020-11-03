package Graph_GUI.Model;
import java.awt.*;
import java.util.Vector;

public class drawAdm {
    public Vector<Edge> edges;
    public Vector<Vertex> vertices;

    public drawAdm(){
        edges = new Vector<Edge>();
        vertices = new Vector<Vertex>();
    }

    public void drawAll(Graphics g){
        int c = 0;
        for (Vertex v : vertices){
            v.draw(g);
            g.drawString("V" + c, v.xLeft+6, v.yTop+18);
            c++;
        }
        for (Edge e : edges){
            e.draw(g);
        }
    }
}
