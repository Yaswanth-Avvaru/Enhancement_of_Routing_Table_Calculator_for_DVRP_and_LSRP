import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.lang.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import java.time.Duration;
import java.time.Instant;

public class LSRouting{
    
    JTextArea ta;

    //Constructor , GUI code
    LSRouting(){
        JFrame frame = new JFrame("Link State Routing ");
        ta = new JTextArea();

        JLabel h0 = new JLabel("Link State Routing Protocol(LSRP)");
        h0.setBounds(250, 10, 650, 25);
        Font font1 = new Font("ComicSams", Font.BOLD | Font.ITALIC, 22);
        h0.setFont(font1);
        h0.setForeground(Color.RED);

        JScrollPane TAS = new JScrollPane(ta);
        JLabel h1 = new JLabel("Routing Tables Display Area");
        Font fonts = new Font("TimesNewRoman", 1, 18);
        h1.setFont(fonts);

        h1.setForeground(Color.ORANGE);
        h1.setBounds(100, 40, 450, 50);
        TAS.setBounds(100, 85, 600, 650);
        ta.setEditable(false);
        Font font = new Font("TimesNewRoman", 1, 12);
        ta.setFont(font);

        String dev = "Developed By  ";
        String name = "Avvaru Yaswanth";
        String RegNum = "124157078";
        String branch = "B.Tech CSE(CSBT)";

        JLabel devs = new JLabel(dev);
        JLabel names = new JLabel(name);
        JLabel regnum = new JLabel(RegNum);
        JLabel branchs = new JLabel(branch);

        devs.setBounds(650, 750, 170, 20);
        names.setBounds(650, 775, 170, 20);
        regnum.setBounds(650, 800, 170, 20);
        branchs.setBounds(650, 825, 170, 20);

        devs.setFont(fonts);
        devs.setForeground(Color.BLUE);
        names.setFont(fonts);
        names.setForeground(Color.BLUE);
        regnum.setFont(fonts);
        regnum.setForeground(Color.BLUE);
        branchs.setFont(fonts);
        branchs.setForeground(Color.BLUE);

        frame.add(h0);
        frame.add(h1);
        frame.add(TAS);
        frame.add(devs);
        frame.add(names);
        frame.add(regnum);
        frame.add(branchs);

        frame.setSize(900, 1000);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    //Function to Display Routing Table Calculator.
    public void display(String s){
        ta.append(s);
    }


    //Function to calculate Routing Tables Using Modified Dijkstras ALgorithm.
    public static String routingcal(int[][] graph, int source){
        StringBuilder sb = new StringBuilder();
        int count = graph.length;

        //Modifies Dijkstra's Algorithm Code
        boolean[] visitedVertex = new boolean[count];
        int[] distance = new int[count];

        for(int i = 0; i < count; i++){
            visitedVertex[i] = false;
            distance[i] = Integer.MAX_VALUE;
        }

        distance[source] = 0;
        for (int i = 0; i < count; i++){
            int u = findMinDistance(distance, visitedVertex);
            visitedVertex[u] = true;

            for (int v = 0; v < count; v++) {
                if (!visitedVertex[v] && graph[u][v] != 0){
                    if(distance[u] + graph[u][v] < distance[v]) {
                        distance[v] = distance[u] + graph[u][v];
                    }
                }
            }
        }

        for(int i = 0; i < distance.length; i++){
            if(i == 0){
                sb.append(String.format("ROUTING TABLE FOR NODE %s\n\n", source));
                sb.append("Source Node    Destination Node    Least Cost\n");
            }
            sb.append(String.format("     %s                          %s                                %s\n", source, i, distance[i]));
            if(i == distance.length - 1){
                return sb.toString();
            }
        }
        
        return sb.toString();
    }

    //Function to find minimum distance.
    private static int findMinDistance(int[] distance, boolean[] visitedVertex){
        int minDistance = Integer.MAX_VALUE;
        int minDistanceVertex = -1;
        for(int i = 0; i < distance.length; i++){
            if(!visitedVertex[i] && distance[i] < minDistance){
                minDistance = distance[i];
                minDistanceVertex = i;
            }
        }
        return minDistanceVertex;
    }

    //Main Function
    public static void main(String[] args) {
        int graph[][] = new int[][]{{ 0, 0, 1, 2, 0, 0, 0 }, 
                                    { 0, 0, 2, 0, 0, 3, 0 }, 
                                    { 1, 2, 0, 1, 3, 0, 0 },
                                    { 2, 0, 1, 0, 0, 0, 1 }, 
                                    { 0, 0, 3, 0, 0, 2, 0 }, 
                                    { 0, 3, 0, 0, 2, 0, 1 }, 
                                    { 0, 0, 0, 1, 0, 1, 0 }}; //Initalizing the Graph

        LSRouting T = new LSRouting(); //Instantiating the object.

        String str = new String();
        long start1 = System.currentTimeMillis();
        for(int m = 0; m < graph.length; m++){
            str+=T.routingcal(graph, m);
            str += ("\n------------------------------------------------------------------------\n");
        }
        long endtime1 = System.currentTimeMillis();
        System.out.println("Elapsed Time in milli seconds: "+ (endtime1-start1));
        T.display(str); //Calling Display Function
    }
}
