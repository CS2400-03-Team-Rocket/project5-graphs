import bag.ResizableArrayBag;
import queue.ArrayQueue;
import stack.ResizableArrayStack;

public class Graph<E>{
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

    public void depthFirstSearch(E label) throws Exception{
        ResizableArrayStack<E> stack = new ResizableArrayStack<>();
        ResizableArrayBag<E> visited = new ResizableArrayBag<>();

        stack.push(label);

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

    public void breathFirstSearch(E label) throws Exception{
        ArrayQueue<E> queue = new ArrayQueue<>();
        ResizableArrayBag<E> visited = new ResizableArrayBag<>();

        queue.enqueue(label);

        while(!queue.isEmpty()){
            //set starting point
            E current = queue.dequeue();

            //get the indexes of the neighbors
            int adjacent[] = neighbors(getIndex(current));
            
            if(!visited.contains(current)){
                visited.add(current);
                System.out.print(current + " ");
            }

            for(int i = 0; i < adjacent.length; i++){
                if(!visited.contains(getLabel(adjacent[i]))){
                    queue.enqueue(getLabel(adjacent[i]));
                }
            }
        }
    }
}