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
