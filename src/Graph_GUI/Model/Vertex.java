package Graph_GUI.Model;
import java.awt.Graphics;

public class Vertex {
    public int xLeft, yTop, radius;
    public Vertex(int xl, int yt, int rad){
        this.xLeft = xl; this.yTop = yt; this.radius = rad;
    }

    public void draw(Graphics g){
        g.drawOval(this.xLeft, this.yTop, 2*this.radius, 2*this.radius);
    }
}
