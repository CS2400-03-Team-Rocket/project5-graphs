import bag.ResizableArrayBag;
import queue.ArrayQueue;
import stack.ResizableArrayStack;

public class Graph<E> implements GraphInterface<E>{
    private boolean[][] edges;
    private E[] labels;

    public Graph(int n){
        edges = new boolean[n][n];
        labels = (E[]) new Object[n];
    }

    public E getLabel(int vertex){
        return labels[vertex];
    }

    public boolean isEdge(int source, int target){
        return edges[source][target];
    }

    public void addEdge(int source, int target){
        edges[source][target] = true;
    }

    public int getIndex(E label){
        int index = -1;
        for(int i = 0; i < this.size(); i++){
            if(labels[i] == label){
                index = i;
            }
        }
        return index;
    }

    public int[] neighbors(int current){
        int count = 0;
        int[] answer;

        for(int i = 0; i < labels.length; i++){
            if(edges[current][i]){
                count++;
            }
        }
        answer = new int[count];
        count = 0;
        for(int i = 0; i < labels.length; i++){
            if(edges[current][i]){
                answer[count++] = i;
            }
        }
        return answer;
    }

    public void removeEdge(int source, int target) {
        edges[source][target] = false;
    }

    // Change the label of a vertex of this Graph
    public void setLabel(int vertex, E newLabel) {
        labels[vertex] = newLabel;
    }

    // Accessor method to determine the number of vertices in this Graph
    public int size() {
        return labels.length;
    }

    public void depthFirstSearch(E originVertex) throws Exception{
        ResizableArrayStack<E> stack = new ResizableArrayStack<>(); //stack holds elements that need to be visited
        ResizableArrayBag<E> visited = new ResizableArrayBag<>(); //bag holds visited elements

        //set starting point
        stack.push(originVertex);
        stack.push(originVertex); //add the origin vertex to stack

        while(!stack.isEmpty()){
            //set starting point
            E current = stack.pop();

            //get the indexes of the neighbors
            int adjacent[] = neighbors(getIndex(current));
            
            //check if we visited the current label
            //if not, add it to visited and print it
            if(!visited.contains(current)){
                visited.add(current);
                System.out.print(current + " ");
            }

            //loops through the neighbors 
            //if not visited push to the stack
            for(int i = 0; i < adjacent.length; i++){
                if(!visited.contains(getLabel(adjacent[i]))){
                    stack.push(getLabel(adjacent[i]));
                }
            }
        }
    }

    public void breathFirstSearch(E originVertex) throws Exception{
        ArrayQueue<E> queue = new ArrayQueue<>(); //queue holds elements that need to be visited
        ResizableArrayBag<E> visited = new ResizableArrayBag<>(); //bag holds visited elements

        queue.enqueue(originVertex); //add the origin vertex to queue

        while(!queue.isEmpty()){

            //set starting point
            E current = queue.dequeue();

            //get the indexes of the neighbors
            int adjacent[] = neighbors(getIndex(current));
            
            //check if we visited the current label
            //if not, add it to visited and print it
            if(!visited.contains(current)){
                visited.add(current);
                System.out.print(current + " ");
            }

            //loops through the neighbors 
            //if not visited then add to back of queue
            for(int i = 0; i < adjacent.length; i++){
                if(!visited.contains(getLabel(adjacent[i]))){
                    queue.enqueue(getLabel(adjacent[i]));
                }
            }
        }
    }
}