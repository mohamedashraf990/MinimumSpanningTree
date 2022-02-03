# Minimum Spanning Tree
This is a project that implements Minimum Spanning Tree using Kruskal's Algorithm to solve the problem.

# Project Desciption
In this project, An electricity network can be visualized as a weighted undirected
graph of vertices where each vertex represents an electric tower and the edges connecting
the vertices represent the connections between the towers. Each connection has a positive
operating cost represented by the weight of the edge. Your task is to write an algorithm
to figure out the edges connecting all the towers together with the minimal overall
operating cost.

### In this poject the solution will be computed using MST
 ****minimumconnections:** public static String minimumconnections (String network)**

*that implements Kruskal's Algorithm to solve the problem.*


## Input

minimumconnetctions method takes as input a String representing the electric network and returns a string encoding of the picked edges.

For example, the string *"T1,T2,5;T1,T3,5;T1,T4,7;T2,T3,6;T2,T4,5;T3,T4,5;"* represents the below network. Every egde is represented by the two edges it connects and
its weight all separated by commas. Semicolons separate between the different edges.


## Output

The output is another string formatted as the picked edges represented just like the
input and ends with the total weight of the network.

## Sample Input/Output

**Network** = "T1,T2,5;T1,T3,5;T1,T4,7;T2,T3,6;T2,T4,5;T3,T4,5;"

**Output by Kruskal**: T1,T3,5;T1,T2,5;T2,T4,5;15

 **Network**="T1,T2,4;T1,T3,9;T1,T4,9;T1,T5,4;T1,T6,10;T1,T7,7;T1,T8,6;T1,T9,3;T1,T10,3;T1,T11,9;T1,T12,1;T2,T3,2;T2,T4,4;T2,T5,4;T2,T6,7;T2,T7,1;T2,T8,9;T2,T9,1;T2,T10,2;T2,T11,10;T2,T12,6;T3,T4,1;T3,T5,6;T3,T6,6;T3,T7,2;T3,T8,8;T3,T9,3;T3,T10,3;T3,T11,2;T3,T12,6;T4,T5,10;T4,T6,4;T4,T7,9;T4,T8,4;T4,T9,10;T4,T10,4;T4,T11,7;T4,T12,2;T5,T6,10;T5,T7,10;T5,T8,8;T5,T9,1;T5,T10,10;T5,T11,7;T5,T12,7;T6,T7,8;T6,T8,9;T6,T9,6;T6,T10,2;T6,T11,4;T6,T12,2;T7,T8,4;T7,T9,3;T7,T10,3;T7,T11,9;T7,T12,1;T8,T9,6;T8,T10,8;T8,T11,1;T8,T12,1;T9,T10,3;T9,T11,7;T9,T12,6;T10,T11,3;T10,T12,10;T11,T12,4;""

**Output by Kruskal**: T1,T12,1;T2,T7,1;T2,T9,1;T3,T4,1;T5,T9,1;T7,T12,1;T8,T11,1;T8,T12,1;T2,T3,2;T2,T10,2;T6,T10,2;14
