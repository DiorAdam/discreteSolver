package Graph_GUI.View;

import Graph_GUI.Model.*;

import java.awt.*;
import basicGUI.basicPanel;
import java.util.Vector;
import java.util.Arrays;



public class GraphPanel extends basicPanel{
    drawAdm da;
    int rad;
    public boolean ev;

    public GraphPanel(){
        this.setPreferredSize(new Dimension(500, 300));
        this.da = new drawAdm();
        this.rad = 12;
        this.ev = true;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        da.drawAll(g);
    }

    public void addVertex(int x, int y){
        da.vertices.add(new Vertex(x, y, rad));
        this.repaint();
    }

    public void addEdge(int xs, int ys, int xe, int ye){
        boolean i = false , j = false;
        for (Vertex v : da.vertices){
            if ( Math.pow((v.xLeft+v.radius/2-xs), 2) + Math.pow( v.yTop +v.radius/2-ys, 2) < Math.pow(v.radius/2, 2)){
                xs = v.xLeft+v.radius/2; ys = v.yTop+v.radius/2;
                i = true;
            }
            if ( Math.pow((v.xLeft+v.radius/2-xe), 2) + Math.pow( v.yTop +v.radius/2-ye, 2) < Math.pow(v.radius/2, 2)){
                xe = v.xLeft + v.radius/2; ye = v.yTop + v.radius/2;
                j = true;
            }
            if (i && j) break;
        }
        if (i && j){
            da.edges.add(new Edge(xs, ys, xe, ye));
            repaint();
        }
    }

    public void eraseAll (){
        da = new drawAdm();
        this.repaint();
    }

    public void getGraph(){
        Vector<Vector<Integer>> v_ = new Vector<Vector<Integer>>();
        for (Vertex v : da.vertices){
            Integer[] l = {v.xLeft + v.radius/2, v.yTop + v.radius/2};
            Vector<Integer> l_ = new Vector<Integer>(Arrays.asList(l));
            v_.add(l_);
        }
        Vector<Vector<Integer>> e_ = new Vector<Vector<Integer>>();
        for (Edge e : da.edges ){
            Integer[] l = {e.xe, e.ye, e.xs, e.ys};
            Vector<Integer> l_ = new Vector<Integer>(Arrays.asList(l));
            e_.add(l_);
        }

        Graph G = new Graph(v_, e_);
        System.out.println(G.toString());
    }
}
