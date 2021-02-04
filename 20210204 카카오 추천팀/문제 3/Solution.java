import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'order' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. UNWEIGHTED_INTEGER_GRAPH city
     *  2. INTEGER company
     */

    /*
     * For the unweighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] and <name>To[i].
     *
     */

    public static List<Integer> order(int cityNodes, List<Integer> cityFrom, List<Integer> cityTo, int company) {
        //BFS order
        boolean[] flags = new boolean[cityNodes+1];
        HashMap <Integer, LinkedList<Integer>> hash = new HashMap<Integer, LinkedList<Integer>>();
        
        for(int i=1;i<=cityNodes;i++){
            hash.put(i, new LinkedList<Integer>());
        }
        
        // 각각의 정점의 인접 정점
        for(int i=0;i<cityFrom.size();i++){
            int a = cityFrom.get(i);
            int b = cityTo.get(i);
            if(hash.get(a)!=null)
               hash.get(a).add(b);
            if(hash.get(b)!=null)
                hash.get(b).add(a);
        }
        
        // output
        List<Integer> list = new LinkedList<Integer>();
        
        // level간의 구분을 위한 임시 list
        List<Integer> tmpList = new LinkedList<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        
        // 시작은 company부터
        queue.addAll(hash.get(company));
        flags[company] = true;
        int i = queue.size();
        
        while(true){
            if(queue.isEmpty()){
                break;
            }
            int tmp = queue.remove();
            i--;
            if(flags[tmp]){
                if(i == 0){
                    tmpList.sort(null);
                    list.addAll(tmpList);
                    tmpList.clear();
                    i = queue.size();
                }
                continue;
            }else{
                flags[tmp] = true;
                tmpList.add(tmp);
                queue.addAll(hash.get(tmp));
                if(i == 0){
                    tmpList.sort(null);
                    list.addAll(tmpList);
                    tmpList.clear();
                    i = queue.size();
                }
            }
        }
        return list;
    }
}