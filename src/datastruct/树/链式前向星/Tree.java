package datastruct.树.链式前向星;

public class Tree {

    int nodeSum;
    int edgeSum;


    Tree(int nodeSum,int edgeSum) {
       this.nodeSum = nodeSum;
       this.edgeSum = edgeSum;
    }

    static class Edge {
        int fo,to,next;

    }

}
