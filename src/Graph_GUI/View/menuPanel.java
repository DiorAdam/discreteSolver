package Graph_GUI.View;

import Graph_GUI.Control.menuListener;
import basicGUI.*;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.*;

public class menuPanel extends JPanel {
    GraphPanel gp;
    JButton erase;
    JButton edge;
    JButton vertex;
    JButton getGraph;
    JLabel filler1;
    JLabel filler2;

    public menuPanel(GraphPanel gp_){
        this.gp = gp_;
        erase = new basicButton("Erase");
        edge = new basicButton("drawEdge");
        vertex = new basicButton("drawVertex");
        getGraph = new basicButton("Print Graph Adjacency");
        filler1 = new basicLabel("");
        filler2 = new basicLabel("");

        menuListener mL = new menuListener(this.gp);

        erase.addActionListener(mL);
        edge.addActionListener(mL);
        vertex.addActionListener(mL);
        getGraph.addActionListener(mL);

        this.setLayout(new GridLayout(2,3));
        this.setBackground(Color.DARK_GRAY);
        this. add(vertex); this.add(edge); this.add(erase);
        this.add(filler1); this.add(getGraph); this.add(filler2);
    }
}
