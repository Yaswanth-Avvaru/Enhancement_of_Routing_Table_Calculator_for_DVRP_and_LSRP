# Enhancement_of_Routing_Table_Calculator_for_DVRP_and_LSRP

DVRP - Distance Vector Routing Protocol

LSRP - Link State Routing Protocol

A packet is routed from its source to destination with the help of Routing tables/Forwarding tables in a routing process. Routing a packet from its source to its destination means routing the packet from the source router to the destination router. A packet needs to visit the source and destination routers. The Routing table provides information about the topology of the network in the immediate vicinity. There are many routes that a packet can travel from source to destination. The main probe here is in which route the packet should be taken.

In Distance Vector Routing Protocol (DVRP), each node creates its least-cost tree with the information it has about its immediate neighbors. The incomplete trees are exchanged between immediate neighbors. This makes the trees more and more complete and to represent the whole internet. To implement DVRP the core concepts that should be known are Bellman Ford Algorithm (BFA) or Ford-Fulkerson Algorithm (FFA). The BFA is used to find the shortest path between the source router and the destination router through some intermediary routers given the costs between these routers.

In Link State Routing Protocol (LSRP), a method in which each node (router) shares its neighbor's data with every other router on the inter network. Each router in the network understands the network topology and then makes a routing table depending on this topology. The core concept to be understood to implement LSRP is Dijkstra’s Algorithm. By using Dijkstra’s Algorithm, we can find the shortest path from the source to all vertices in the graph given and also the cost between these routers.

**KEYWORDS**: Distance Vector Routing Protocol (DVRP), Link State Routing Protocol (LSRP), Bellman Ford Algorithm (BFA), Dijkstra’s Algorithm, Forwarding/ Routing Table.
