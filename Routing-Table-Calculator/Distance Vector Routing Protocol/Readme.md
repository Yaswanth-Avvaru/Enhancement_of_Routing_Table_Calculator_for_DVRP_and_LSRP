The Distance Vector Routing Protocol uses Socket Programming. 

There are two files Dvrp_Server.java and Dvrp_Client.java. 

First run the Dvrp_Server.java, then a socket is created with a port number. And then run Dvrp_Client.java and then connection will be established.

After the connection has been successfully established, then the network topology should be input in the java graphical user interface. The following details have to be entered in the Java GUI.

- Number of Vertices.
-	Number of Edges.
-	Source Vertex.
-	Destination Vertex.
-	Link Cost.

After the above details have been entered, click on Add Row button to add the details to the Network Topology Table. 
You can view the entered details in the table rendered beside. If you wish to modify, select the row and click on delete to remove that row. Then add the row freshly to the table. 

On completion of entering the details of all nodes then click on Calculate button below the table. Upon clicking the button all the details will be sent to the server and then the BFA Algorithm implemented will use these details and compute the Routing tables and return it to the client side for displaying it in the Routing table Calculator of new frame Routing Table.


**Procedure and Snap shots :**

1. Compile the Server code first.
   
   ![image](https://github.com/Yaswanth-Avvaru/Enhancement_of_Routing_Table_Calculator_for_DVRP_and_LSRP/assets/88758475/c84cb03c-7599-4e91-b654-9692ba5eb208)

2. Compile the Client Code Next
   
   ![image](https://github.com/Yaswanth-Avvaru/Enhancement_of_Routing_Table_Calculator_for_DVRP_and_LSRP/assets/88758475/c3625ec8-050a-492a-883b-ab7de64bb6e8)

3. After compiling the Client code, the following GUI Window shows up.
   
   ![image](https://github.com/Yaswanth-Avvaru/Enhancement_of_Routing_Table_Calculator_for_DVRP_and_LSRP/assets/88758475/1f83ddf0-6278-4fbc-a547-cd3ee0449cf1)

4. Adding the Nodes
   
   ![image](https://github.com/Yaswanth-Avvaru/Enhancement_of_Routing_Table_Calculator_for_DVRP_and_LSRP/assets/88758475/888ab24a-3c5b-4d63-8083-f36bf19aa002)

5. Deleting the Nodes
   
   ![image](https://github.com/Yaswanth-Avvaru/Enhancement_of_Routing_Table_Calculator_for_DVRP_and_LSRP/assets/88758475/ff113418-ed97-4a8c-a237-31ac0d2fff0e)

6. Adding More Nodes
    
   ![image](https://github.com/Yaswanth-Avvaru/Enhancement_of_Routing_Table_Calculator_for_DVRP_and_LSRP/assets/88758475/8bb11df5-a579-4036-8b5a-9f9fb002d515)

7. Routing Table for the given Nodes
    
   ![image](https://github.com/Yaswanth-Avvaru/Enhancement_of_Routing_Table_Calculator_for_DVRP_and_LSRP/assets/88758475/4ac1efc0-9c21-472f-be49-2270cab529d2)

8. Time Taken for calculating the Routing Table for the given Nodes
    
   ![image](https://github.com/Yaswanth-Avvaru/Enhancement_of_Routing_Table_Calculator_for_DVRP_and_LSRP/assets/88758475/2c1aa5d2-7fe0-4623-974a-ae593978cec6)
