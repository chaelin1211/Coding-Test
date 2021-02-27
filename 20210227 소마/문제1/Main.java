
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input  =  br.readLine();
        int numOfSkill = input.split(" ").length;

        HashMap<String, Vertex> Skills = new HashMap<String, Vertex>();
        for (int i = 0; i < numOfSkill; i++) {
            String skill = input.split(" ")[i];
            Skills.put(skill, new Vertex(skill));
        }

        int N = Integer.parseInt(br.readLine());
        String V1, V2;
        
        for (int i = 0; i < N; i++) {
            input = br.readLine();
            V1 = input.split(" ")[0];
            V2 = input.split(" ")[1];
            Vertex ver1 = Skills.get(V1);
            Vertex ver2 = Skills.get(V2);
            ver2.root = false;
            ver1.inciSkill.add(new Edge(ver1,ver2));
        }

        for (String key : Skills.keySet()) {
            if(Skills.get(key).root){
                function("", Skills.get(key));
            }
        }
    }
    public static void function(String out, Vertex ver){
        if(ver.inciSkill.size()!=0){
            out+=ver.name;
            out+=" ";
            for(Edge tmp:ver.inciSkill){
                if(tmp.flag) 
                    continue;
                tmp.flag = true;
                function(out, tmp.v2);
            }
        }else{
            System.out.println(out+ver.name);
        }
    }
}

class Vertex {
    String name;
    boolean root;
    ArrayList<Edge> inciSkill;
    public Vertex(String name){
        this.name=name;
        inciSkill = new ArrayList<Edge>();
        root = true;
    }
}
class Edge{
    Vertex v1,v2;
    boolean flag;
    public Edge(Vertex v1, Vertex v2){
        this.v1 = v1;
        this.v2 = v2;
        this.flag = false;
    }
}