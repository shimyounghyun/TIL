import java.util.*;

public class Main{
    static class Node {
        String str;
        Node left;
        Node right;

        public Node(String str){
            this.str = str;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
    public static void printPreOrder(Node root) {
        if (root == null) return;
        printPreOrder(root.left);
        System.out.print(root.str);
        printPreOrder(root.right);
    }
    public static void printInOrder(Node root) {
        if (root == null) return;
        System.out.print(root.str);
        printInOrder(root.left);
        printInOrder(root.right);
    }
    public static void printAfterOrder(Node root) {
        if (root == null) return;
        printAfterOrder(root.left);
        printAfterOrder(root.right);
        System.out.print(root.str);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Node[] list = new Node[n];
        for(int i=0; i<n; i++){
            list[i] = new Node((char)('A'+i)+"");
//            System.out.println(list[i].str);
        }
        for (int i=0; i<n; i++){
            String[] info = sc.nextLine().split(" ");
            int root = info[0].charAt(0)-'A';
            int left = info[1].charAt(0)-'A';
            int right = info[2].charAt(0)-'A';
            if (!info[1].equals(".")){
                list[root].setLeft(list[left]);
            }
            if (!info[2].equals(".")){
                list[root].setRight(list[right]);
            }
        }
        printInOrder(list[0]);
        System.out.println();
        printPreOrder(list[0]);
        System.out.println();
        printAfterOrder(list[0]);
    }
}
