package Graph_GUI.Model;
import java.awt.Graphics;

public class Edge {
    public int xs, ys, xe, ye;
    public Edge(int xs_, int ys_, int xe_, int ye_){
        this.xs = xs_; this.ys = ys_; this.xe = xe_; this.ye = ye_;
    }

    public void draw(Graphics g){
        g.drawLine(this.xs, this.ys, this.xe, this.ye);
    }
}
