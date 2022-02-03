import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;




 class Edges {
	String start;
	String end;
	int value;
    
	public Edges(String start,String end,int value) {
		this.start=start;
		this.end=end;
		this.value=value;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	

}
 


public class MinimumSpanningTree {
	

	
	public static int find(int parent[], int i) {
	        if (parent[i] == -1)
	            return i;
	        return find(parent, parent[i]);
	    }
	 
	public static void Union(int parent[], int x, int y) {
	        parent[x] = y;
	    }
	 
	 
	 
	 static int isCycle(Edges edgeToAdd) {

	 	solution.add(edgeToAdd);
	 
	
	        int root[] = new int[countVertices()+1];
	 

	        for (int i=0; i<countVertices(); ++i) {
	            root[i]=-1;
	        }
	 
	        for (int i = 0; i < solution.size(); ++i)
	        {
	            int set1 = find(root, Integer.parseInt(solution.get(i).getStart().substring(1)));
	            int set2 = find(root, Integer.parseInt(solution.get(i).getEnd().substring(1)));
	 
	            if (set1 == set2) {
	            	solution.remove(solution.size()-1);
	                return 1;
	            }
	            Union(root, set1, set2);
	        }
	        return 0;
	    
	 }
	 

	    static ArrayList<Edges> edges;
		static ArrayList<Edges> solution ;
		
	public static String minimumConnections (String network){
		 edges = new ArrayList<Edges>(); 
		 solution=new ArrayList<>();
	
	createEdges(network);
	int vertices=countVertices();
    int counter = 0;
	for(int i=0;i<edges.size()-1;i++) {
		//check if it may make cycle
		//if it doesn't add it to the solution
		Edges edgeToAdd=new Edges(edges.get(i).getStart(), edges.get(i).getEnd(), edges.get(i).getValue());
		if(isCycle(edgeToAdd)==0) {
			counter++;
		}
		if(counter==vertices-1)
			break;
	}
	 return printSolutions();
	}
	
	
	
	public static String printSolutions() {
		
		String solutionString="";
		String counter=Integer.toString(getTotal());
		for(int i=0;i<solution.size();i++) {
			solutionString=solutionString+solution.get(i).getStart()+","+solution.get(i).getEnd()+","+solution.get(i).getValue()+";";
			
		}
		solutionString=solutionString+counter;
		return solutionString;
	}
	

	public static int getTotal() {
		int counter=0;
		for(int i=0;i<solution.size();i++) {
			counter=counter+solution.get(i).getValue();
		}
		return counter;
	}
	
	
	public static int countVertices() {
		ArrayList<String> nodes=new ArrayList<>();
		for(int i=0;i<edges.size();i++) {
			if( !nodes.contains(edges.get(i).getStart()) ) {
				nodes.add(edges.get(i).getStart());
			}
			if( !nodes.contains(edges.get(i).getEnd()) ) {
				nodes.add(edges.get(i).getEnd());
			}
		}
		return nodes.size();
		
	}
	
	
	//Created edges and added it to an arrayList named edges
	public static void createEdges(String graph) {
		String[] splittedEdges=graph.split(";");
		for(int i=0;i<splittedEdges.length;i++) {
			String[] value=splittedEdges[i].split(",");
			String source=value[0];
			
			String destination=value[1];
			int cost=Integer.parseInt(value[2]);
			Edges edgeToAdd=new Edges(source, destination, cost);
			edges.add(edgeToAdd);
			
		}
		 Sort(edges);
	}
	
	
	public static void Sort(ArrayList<Edges> edges) {
		Collections.sort(edges, new Comparator<Edges>() {
		    @Override
		    public int compare(Edges z1, Edges z2) {
		        if (z1.getValue() > z2.getValue())
		            return 1;
		        if (z1.getValue() < z2.getValue())
		            return -1;
		        return 0;
		    }
		});
	}
	
	
	public static void main(String[] args) {
		System.out.println(minimumConnections("T1,T2,4;T1,T3,9;T1,T4,9;T1,T5,4;T1,T6,10;T1,T7,7;T1,T8,6;T1,T9,3;T1,T10,3;T1,T11,9;T1,T12,1;T2,T3,2;T2,T4,4;T2,T5,4;T2,T6,7;T2,T7,1;T2,T8,9;T2,T9,1;T2,T10,2;T2,T11,10;T2,T12,6;T3,T4,1;T3,T5,6;T3,T6,6;T3,T7,2;T3,T8,8;T3,T9,3;T3,T10,3;T3,T11,2;T3,T12,6;T4,T5,10;T4,T6,4;T4,T7,9;T4,T8,4;T4,T9,10;T4,T10,4;T4,T11,7;T4,T12,2;T5,T6,10;T5,T7,10;T5,T8,8;T5,T9,1;T5,T10,10;T5,T11,7;T5,T12,7;T6,T7,8;T6,T8,9;T6,T9,6;T6,T10,2;T6,T11,4;T6,T12,2;T7,T8,4;T7,T9,3;T7,T10,3;T7,T11,9;T7,T12,1;T8,T9,6;T8,T10,8;T8,T11,1;T8,T12,1;T9,T10,3;T9,T11,7;T9,T12,6;T10,T11,3;T10,T12,10;T11,T12,4;"));
	}

}