package Graph_GUI.Model;
import java.awt.Graphics;

public class Vertex {
    public int xLeft, yTop, radius;
    public Vertex(int xl, int yt, int rad){
        this.xLeft = xl; this.yTop = yt; this.radius = rad;
    }

    public void draw(Graphics g){
        g.fillOval(this.xLeft, this.yTop, this.radius, this.radius);
    }
}
