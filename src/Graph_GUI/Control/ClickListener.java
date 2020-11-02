package Graph_GUI.Control;

import java.awt.event.*;

import Graph_GUI.View.GraphPanel;

public class ClickListener implements MouseListener {
    GraphPanel gp;
    int[] line;

    public ClickListener(GraphPanel gp_){
        this.gp = gp_;
        line = new int[2];
    }

    public void mouseClicked(MouseEvent evt){
        int x = evt.getX(), y = evt.getY();
        if (this.gp.ev) {
            this.gp.addVertex(x, y);
        }
        else {
            if (line[1] == 0) {
                line[0] = x;
                line[1] = y;
            }
            else{
                this.gp.addEdge(line[0], line[1], x, y);
                line[0] = 0; line[1] = 0;
            }
        }
    }

    public void mouseEntered(MouseEvent evt){}
    public void mouseExited(MouseEvent evt){line[0] = 0; line[1] = 0;}
    public void mousePressed(MouseEvent evt){}
    public void mouseReleased(MouseEvent evt){}
}
