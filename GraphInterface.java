public interface GraphInterface<E> {

    public E getLabel(int vertex);

    public boolean isEdge(int source, int target);

    public void addEdge(int source, int target);

    public int getIndex(E label);

    public int[] neighbors(int current);

    public void removeEdge(int source, int target);

    public void setLabel(int vertex, E newLabel);

    public int size();

    public void depthFirstSearch(E originVertex) throws Exception;

    public void breathFirstSearch(E originVertex) throws Exception;
    
}
