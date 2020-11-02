package Graph_GUI.View;

import basicGUI.basicFrame;
import Graph_GUI.Control.ClickListener;

import java.awt.*;

public class GraphFrame extends basicFrame {
    GraphPanel gp;
    menuPanel mP;
    ClickListener cL;
    public GraphFrame(){
        gp = new GraphPanel();
        mP = new menuPanel(gp);
        cL = new ClickListener(gp);

        gp.addMouseListener(cL);

        this.getContentPane().add(gp, BorderLayout.CENTER);
        this.getContentPane().add(mP, BorderLayout.SOUTH);
    }

}
