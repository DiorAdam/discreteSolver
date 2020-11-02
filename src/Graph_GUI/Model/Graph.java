package Graph_GUI.Model;


import java.util.HashMap;
import java.util.Vector;

public class Graph {
    HashMap<Vector<Integer>, Integer> name;
    Vector<Vector<Integer>> adj;

    public Graph(Vector<Vector<Integer>> vertices, Vector<Vector<Integer>> edges){
        name = new HashMap<Vector<Integer>, Integer>();
        for (int i=0; i<vertices.size(); i++){
            name.put(vertices.get(i), i);
        }

        adj = new Vector<Vector<Integer>>();
        for (int i = 0; i<vertices.size(); i++) adj.add(new Vector<Integer>());



        for (Vector<Integer> ed : edges){
            Vector<Integer> start = new Vector<Integer>(); start.add(ed.get(0)); start.add(ed.get(1));
            Vector<Integer> end = new Vector<Integer>(); end.add(ed.get(2)); end.add(ed.get(3));
            Vector<Integer> adjSt = adj.get(name.get(start)); adjSt.add(name.get(end));
            Vector<Integer> adjEnd = adj.get(name.get(end)); adjEnd.add(name.get(start));
            adj.set(name.get(start), adjSt);
            adj.set(name.get(end), adjEnd);
        }
    }

    @Override
    public String toString(){
        String ans = "\n Vertices              Neighbors\n\n";
        for (int i=0; i<adj.size(); i++){
            ans += "    V" + i + "        :       ";
            for (Integer j:adj.get(i)){
                ans += "V"+j + "  ";
            }
            ans += "\n";
        }
        return ans;
    }
}
