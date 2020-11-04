package Graph_GUI.Model;
import java.awt.*;
import java.util.Vector;

public class drawAdm {
    public Vector<Edge> edges;
    public Vector<Vertex> vertices;

    public drawAdm(){
        edges = new Vector<>();
        vertices = new Vector<>();
    }

    public void drawAll(Graphics g){
        for (Edge e : edges){
            e.draw(g);
        }
        int c = 0;
        for (Vertex v : vertices){
            v.draw(g);
            g.drawString("V" + c, v.xLeft+6, v.yTop+18);
            c++;
        }
    }
}
