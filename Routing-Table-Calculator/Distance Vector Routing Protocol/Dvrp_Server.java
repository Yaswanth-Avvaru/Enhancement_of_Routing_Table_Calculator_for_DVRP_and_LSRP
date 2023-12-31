//imports necessary for the code
import java.net.Socket;
import java.io.ObjectInputStream;
import java.io.DataInputStream;
import java.net.ServerSocket;
import java.io.ObjectOutputStream;


public class Dvrp_Server{
    //Initilisation of variables
    static int graph[][];
    static int nh[][];
    static int altpath[][];
    static int v;
    static int e;

    //Main function
    public static void main(String args[]) throws Exception{
        while(true){
            ServerSocket ss = new ServerSocket(5000);
            System.out.println("Socket with port 5000 created");
            Socket s = ss.accept();

            DataInputStream din1 = new DataInputStream(s.getInputStream());
            v = Integer.parseInt(din1.readUTF());
            
            DataInputStream din2 = new DataInputStream(s.getInputStream());
            e = Integer.parseInt(din2.readUTF());
            
            graph = new int[v][v];
            nh = new int[v][v];
            altpath = new int[v][v];

            ObjectInputStream is = new ObjectInputStream(s.getInputStream());
            graph = (int[][]) is.readObject();

            display();
            
            ObjectOutputStream os1 = new ObjectOutputStream(s.getOutputStream());
            os1.writeObject(altpath);
            
            ObjectOutputStream os2 = new ObjectOutputStream(s.getOutputStream());
            os2.writeObject(nh);
            
            ss.close();
        }

    }

    //function to display tables
    static void display(){
        System.out.println();
        initalize_tables();
        tables_calc();
        System.out.println();
    }

    //BFA Algorithm
    static void tab_update(int source){
        for (int i = 0; i < v; i++){
            if (graph[source][i] != 9999){
                int dist = graph[source][i];
                for (int j = 0; j < v; j++){
                    int inter_dist = altpath[i][j];
                    if (nh[i][j] == source)
                        inter_dist = 9999;
                    if (altpath[source][j] > dist + inter_dist){
                        altpath[source][j] = dist + inter_dist;
                        nh[source][j] = i;
                    }
                }
            }
        }
    }

    static void tables_calc(){
        int k = 0;
        for (int i = 0; i < 2 * v; i++){
            tab_update(k);
            k++;
            if (k == v)
                k = 0;
        }
    }

static void initalize_tables(){
        for (int i = 0; i < v; i++){
            for (int j = 0; j < v; j++){
                if (i == j){
                    altpath[i][j] = 0;
                    nh[i][j] = i;
                } else{
                    altpath[i][j] = 9999;
                    nh[i][j] = 100;
                }
            }
        }
    }
}
