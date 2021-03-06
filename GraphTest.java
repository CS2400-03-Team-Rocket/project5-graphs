import static org.junit.Assert.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class GraphTest{
    
    @Test 
    public void testDepthFirstSearch() throws Exception{

        Graph<Character> graph1 = new Graph<>(9);

        //setting node labels
        graph1.setLabel(0, 'A');
        graph1.setLabel(1, 'B');
        graph1.setLabel(2, 'C');
        graph1.setLabel(3, 'D');
        graph1.setLabel(4, 'E');
        graph1.setLabel(5, 'F');
        graph1.setLabel(6, 'G');
        graph1.setLabel(7, 'H');
        graph1.setLabel(8, 'I');

        //setting 'A' paths 
        graph1.addEdge(0, 1);
        graph1.addEdge(0,3);
        graph1.addEdge(0, 4);

        //setting 'B' paths
        graph1.addEdge(1, 4);

        //setting 'C' paths
        graph1.addEdge(2, 1);

        //setting 'D' paths
        graph1.addEdge(3, 6);

        //setting 'E' paths
        graph1.addEdge(4, 5);
        graph1.addEdge(4, 7);

        //setting 'F' paths
        graph1.addEdge(5, 2);
        graph1.addEdge(5, 7);

        //setting 'G' paths
        graph1.addEdge(6, 7);

        //setting 'H' paths
        graph1.addEdge(7, 8);

        //setting 'I' paths
        graph1.addEdge(8, 5);

        //depth first search
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        graph1.depthFirstSearch('A');
        //"A E H I F C B D G "
        assertEquals("A E H I F C B D G ", outContent.toString());
    }

    @Test 
    public void testBreadthFirstSearch() throws Exception{

        Graph<Character> graph1 = new Graph<>(9);

        //setting node labels
        graph1.setLabel(0, 'A');
        graph1.setLabel(1, 'B');
        graph1.setLabel(2, 'C');
        graph1.setLabel(3, 'D');
        graph1.setLabel(4, 'E');
        graph1.setLabel(5, 'F');
        graph1.setLabel(6, 'G');
        graph1.setLabel(7, 'H');
        graph1.setLabel(8, 'I');

        //setting 'A' paths 
        graph1.addEdge(0, 1);
        graph1.addEdge(0,3);
        graph1.addEdge(0, 4);

        //setting 'B' paths
        graph1.addEdge(1, 4);

        //setting 'C' paths
        graph1.addEdge(2, 1);

        //setting 'D' paths
        graph1.addEdge(3, 6);

        //setting 'E' paths
        graph1.addEdge(4, 5);
        graph1.addEdge(4, 7);

        //setting 'F' paths
        graph1.addEdge(5, 2);
        graph1.addEdge(5, 7);

        //setting 'G' paths
        graph1.addEdge(6, 7);

        //setting 'H' paths
        graph1.addEdge(7, 8);

        //setting 'I' paths
        graph1.addEdge(8, 5);

        //breadth first search
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        graph1.breadthFirstSearch('A');
        //"A B D E G F H C I "
        assertEquals("A B D E G F H C I ", outContent.toString());
    }
}
