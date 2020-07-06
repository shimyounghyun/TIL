import java.util.*;
import java.io.*;

class Solution {
    public class Node {
        Map<Character, Node> map = new HashMap<Character, Node>();
        int count;
    }
    public void insert(Node node, String word){
        node.count++;
        for (int i=0; i<word.length(); i++){
            node = node.map.computeIfAbsent(word.charAt(i), c->new Node());
            node.count++;
        }
    }
    public int search(Node node, String word){
        int i=0;
        if (word.equals(""))
            return node.count;
        while (node != null && i < word.length()){
            node = node.map.get(word.charAt(i));
            i++;
        }
        if (node == null)
            return 0;
        else
            return node.count;
    }
    public int[] solution(String[] words, String[] queries) {
        Node[] asc = new Node[10001];
        Node[] desc = new Node[10001];
        int[] result = new int[queries.length];
        for (int i=1; i<=10000; i++){
            asc[i] = new Node();
            desc[i] = new Node();
        }
        for (String w : words){
            insert(asc[w.length()], w);
            insert(desc[w.length()], new StringBuffer(w).reverse().toString());
        }
        int i=0;
        for (String q : queries){
            int index = q.indexOf("?");
            int size = q.length();
            String n = q.replaceAll("[?]","");
            int r = 0;
            if (index == 0){
                r = search(desc[size], new StringBuffer(n).reverse().toString());
            }else{
                r = search(asc[size], n);
            }
            result[i]=r;
            i++;
        }
        return result;
    }
}
