//imports necessary for the code
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.lang.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import java.time.Duration;
import java.time.Instant;


class Result extends JFrame{
	JTextArea ta;
    JScrollPane TAS;	
	JLabel jl;
	
	public Result(String sb){
		Font fonts = new Font("TimesRoman", 1, 18);
		ta = new JTextArea();
		TAS = new JScrollPane(ta);

		jl=new JLabel("Routing table Calculator : ");
		this.add(jl);
		jl.setBounds(30, 5, 350, 50);
		jl.setFont(fonts);

		this.setSize(450, 450);
        this.setLayout(null);
		this.setTitle("Routing table ");
		this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.add(TAS);

		TAS.setBounds(30,50, 380, 330); 
		ta.setEditable(false);
		ta.setText(sb);
        this.setVisible(true);
	}
}

public class Dvrp_Client{
    static int graph[][];
    static int nh[][];
    static int altpath[][];
    static int v;
    static int e;
    static int sn = 1;

    public static void main(String args[]) throws IOException{

        JTextField t1, t2;
        JLabel l0, l1, l2;
        JButton jb;
        Font fonts = new Font("TimesRoman", 1, 18);

        JFrame f = new JFrame("Distance Vector Routing Table Calculator");
        JFrame f1 = new JFrame("DVRP Routing Table ");

        l0 = new JLabel("Distance Vector Routing Protocol(DVRP)");
        l0.setBounds(250, 30, 370, 30);
        Font font1 = new Font("ComicSams", Font.BOLD | Font.ITALIC, 18);
        l0.setFont(font1);
        l0.setForeground(Color.RED);

        l1 = new JLabel("Enter no of vertices: ");
        l1.setBounds(120, 80, 250, 25);
        l1.setFont(fonts);
        t1 = new JTextField();
        t1.setBounds(120, 115, 200, 25);

        l2 = new JLabel("Enter no of Edges: ");
        l2.setBounds(120, 160, 250, 25);
        l2.setFont(fonts);
        t2 = new JTextField();
        t2.setBounds(120, 195, 200, 25);

        jb = new JButton("Calculate");
        jb.setBounds(315, 615, 100, 25);
        jb.setForeground(Color.BLUE);

        JLabel h2 = new JLabel("Network Topology Table: ");
        JTextArea ta = new JTextArea();
        JScrollPane TAS = new JScrollPane(ta);
        JLabel h1 = new JLabel("Routing Tables Display Area: ");
        h1.setBounds(90, 280, 500, 100);
        TAS.setBounds(90, 350, 600, 400);
        h2.setBounds(120, 370, 250, 25);
        h2.setFont(fonts);

        JTable table = new JTable();
        Object[] columns = {
        "Source Vertex",
        "Destination Vertex",
        "Link Cost"
        };

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        table.setModel(model);

        table.setBackground(Color.WHITE);
        table.setForeground(Color.GRAY);
        Font font = new Font("", 1, 22);
        table.setFont(font);
        table.setRowHeight(20);

        JLabel l3 = new JLabel("Enter Source Vertex: ");
        l3.setBounds(480, 80, 250, 25);
        l3.setFont(fonts);
        JTextField src = new JTextField();
        src.setBounds(480, 115, 200, 25);

        JLabel l4 = new JLabel("Enter Destination Vertex: ");
        l4.setBounds(480, 160, 250, 25);
        l4.setFont(fonts);
        JTextField dest = new JTextField();
        dest.setBounds(480, 195, 200, 25);

        JLabel l5 = new JLabel("Enter Link Cost: ");
        l5.setBounds(480, 235, 200, 25);
        l5.setFont(fonts);
        JTextField ct = new JTextField();
        ct.setBounds(480, 270, 200, 25);

        JButton addbtn = new JButton("Add Row");
        JButton delbtn = new JButton("Delete Row");

        addbtn.setBounds(480, 315, 90, 25);
        addbtn.setForeground(Color.BLUE);
        delbtn.setBounds(580, 315, 100, 25);
        delbtn.setForeground(Color.BLUE);

        String dev = "Developed By  ";
        String name = "Avvaru Yaswanth";
        String RegNum = "124157078";
        String branch = "B.Tech CSE(CSBT)";

        JLabel devs = new JLabel(dev);
        JLabel names = new JLabel(name);
        JLabel regnum = new JLabel(RegNum);
        JLabel branchs = new JLabel(branch);

        devs.setBounds(650, 620, 170, 20);
        names.setBounds(650, 645, 170, 20);
        regnum.setBounds(650, 670, 170, 20);
        branchs.setBounds(650, 695, 170, 20);

        devs.setFont(fonts);
        devs.setForeground(Color.BLUE);

        names.setFont(fonts);
        names.setForeground(Color.BLUE);

        regnum.setFont(fonts);
        regnum.setForeground(Color.BLUE);
        
        branchs.setFont(fonts);
        branchs.setForeground(Color.BLUE);


        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(120, 400, 500, 200);
        f.add(l0);
        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(l5);
        f1.add(h1);
        f.add(h2);
        f1.add(TAS);
        f.add(t1);
        f.add(t2);
        f.add(jb);
        f.add(pane);
        f.add(src);
        f.add(dest);
        f.add(ct);
        f.add(addbtn);
        f.add(delbtn);
        f.add(devs);
        f.add(names);
        f.add(regnum);
        f.add(branchs);

        Object row[] = new Object[3];

        addbtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ace){
                row[0] = src.getText();
                row[1] = dest.getText();
                row[2] = ct.getText();
                model.addRow(row);
            }
        });

        delbtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae2){
                int i = table.getSelectedRow();
                if (i >= 0){
                    model.removeRow(i);
                }else{
                    System.out.println("Delete Error");
                }
            }
        });

        table.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent me) {
            int i = table.getSelectedRow();
            src.setText(model.getValueAt(i, 0).toString());
            dest.setText(model.getValueAt(i, 1).toString());
            ct.setText(model.getValueAt(i, 2).toString());
        }
        });

        jb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae3){
                long start1 = System.currentTimeMillis();
                String s1 = t1.getText();
                String s2 = t2.getText();
                v = Integer.parseInt(s1);
                e = Integer.parseInt(s2);
                graph = new int[v][v];
                nh = new int[v][v];
                altpath = new int[v][v];
                for (int i = 0; i < v; i++)
                    for (int j = 0; j < v; j++){
                        if (i == j)
                            graph[i][j] = 0;
                        else
                            graph[i][j] = 9999;
                    }
                try{
                    int x = 0, y = 0;
                    for (int i = 0; i < e; i++){
                        Object ob1 = table.getModel().getValueAt(x, y);
                        int s = Integer.parseInt(ob1.toString());
                        s--;
                        Object ob2 = table.getModel().getValueAt(x, y + 1);
                        int d = Integer.parseInt(ob2.toString());
                        d--;
                        Object ob3 = table.getModel().getValueAt(x, y + 2);
                        int c = Integer.parseInt(ob3.toString());
                        x = x + 1;
                        graph[s][d] = c;
                        graph[d][s] = c;
                    }
                    Socket s = new Socket("localhost", 5000);       //Universal Plug and Play (UPnP) uses two ports, 5000 TCP and 1900 UDP.
                    System.out.println("Connection established with server..");
                    DataOutputStream dout = new DataOutputStream(s.getOutputStream());
                    dout.writeUTF(t1.getText());
                    DataOutputStream dout1 = new DataOutputStream(s.getOutputStream());
                    dout1.writeUTF(t2.getText());
                    ObjectOutputStream os = new ObjectOutputStream(s.getOutputStream());
                    os.writeObject(graph);
                    ObjectInputStream is1 = new ObjectInputStream(s.getInputStream());
                    altpath = (int[][]) is1.readObject();
                    ObjectInputStream is2 = new ObjectInputStream(s.getInputStream());
                    nh = (int[][]) is2.readObject();
                    s.close();
                } 
                catch (Exception e){
                    System.out.println(e);
                }
                String sb = new String();
                sb = display_rt();
                new Result(sb);
                long endtime1 = System.currentTimeMillis();
                System.out.println("Elapsed Time in milli seconds: "+ (endtime1-start1));
            }
        });
        f.setSize(900, 800);
        f.setLayout(null);
        f.setBackground(Color.GREEN);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
    static String display_rt(){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < v; i++){
            str.append("ROUTING TABLE FOR ROUTER" + (i + 1) + "\n");
            str.append("\n" + "Nodes" + "\t" + "Distance" + "\t" + "Next Hop/ Via" + "\n");
            for (int j = 0; j < v; j++){
                str.append("" + (j + 1) + "\t" + altpath[i][j] + "\t" + (nh[i][j] + 1) + "\n");
            }
	        str.append("----------------------------------------------------------------");
            str.append("\n");
        }
	
        return str.toString();
    }
}
