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
        this.rad = 15;
        this.ev = true;
    }

    @Override
    public void paintComponent(Graphics g){
        g.setFont(new Font("", Font.BOLD,12));
        super.paintComponent(g);
        da.drawAll(g);
    }

    public void addVertex(int x, int y){
        da.vertices.add(new Vertex(x, y, rad));
        this.repaint();
    }

    public int[] cleanOval(int xs, int ys, int xe, int ye){
        int[] ans = new int[4];
        int p = 1;
        try{
            p = Math.abs((ye-ys)/(xe-xs));
        }
        catch(Exception e){
            System.err.println("An edge must be between 2 different vertices");
        }

        int r;
        r = (int) (rad/(Math.sqrt(1+p*p)));
        ans[0] = (xs<xe)? xs + r : xs-r;
        ans[1] = (ys<ye)? ys + p*r : ys - p*r;
        ans[2] = (xe < xs)? xe + r : xe - r;
        ans[3] = (ye < ys)? ye + p*r : ye -p*r;

        return ans;
    }

    public void addEdge(int xs, int ys, int xe, int ye){
        boolean i = false , j = false;
        for (Vertex v : da.vertices){
            if ( Math.pow((v.xLeft+v.radius-xs), 2) + Math.pow( v.yTop +v.radius-ys, 2) < Math.pow(v.radius, 2)){
                xs = v.xLeft+v.radius; ys = v.yTop+v.radius;
                i = true;
            }
            if ( Math.pow((v.xLeft+v.radius-xe), 2) + Math.pow( v.yTop +v.radius-ye, 2) < Math.pow(v.radius, 2)){
                xe = v.xLeft + v.radius; ye = v.yTop + v.radius;
                j = true;
            }
            if (i && j) break;
        }
        if (i && j){
            int[] p = cleanOval(xs, ys, xe, ye);
            da.edges.add(new Edge(p[0], p[1], p[2], p[3]));
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
        Vector<Vector<Integer>> e_ = new Vector<>();
        for (Edge e : da.edges ){
            Integer[] l = {e.xe, e.ye, e.xs, e.ys};
            Vector<Integer> l_ = new Vector<Integer>(Arrays.asList(l));
            e_.add(l_);
        }

        Graph G = new Graph(v_, e_);
        System.out.println(G.toString());
    }
}
