package Graph_GUI.Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Graph_GUI.View.GraphPanel;

public class menuListener implements ActionListener {
    GraphPanel gp;

    public menuListener(GraphPanel gp_){
        this.gp = gp_;
    }
    public void actionPerformed(ActionEvent evt){
        String cmd = evt.getActionCommand();
        if (cmd.equals("Erase")) this.gp.eraseAll();
        else if (cmd.equals("drawVertex")) this.gp.ev = true;
        else if (cmd.equals("drawEdge")) this.gp.ev = false;
        else if (cmd.equals("Print Graph Adjacency")) this.gp.getGraph();
        else System.err.println("error in menuListener");
    }
}
