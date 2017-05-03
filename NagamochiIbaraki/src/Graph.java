import java.util.Random;

public class Graph {

	public static int adjacencyListCreation(int n, int m){
		
		Random r = new Random();
		int Low=0;
		int High=n;
		
		//int count=0;
		
		int[][] adj = new int[n][n];
		
		for(int i=0;i<m;i++){
			int from=r.nextInt(High-Low)+Low;
			int to=r.nextInt(High-Low)+Low;
			if(to==from){
				i--;
			} 
			else if(adj[to][from]==1){
				i--;
			}
			else{
				adj[to][from]=1;
				adj[from][to]=1;
				//count++;
			}
			if(i==-1) {
				i++;
			}
		}
		
		int flag=0;
		//System.out.println("Adjacency List Created");
		for(int i=0;i<n;i++){
			int c=0;
			for(int j=0;j<n;j++){
				//System.out.print(adj[i][j]);
				c+=adj[i][j];
			}
			if(c==0){
				flag=1;
			}
			//System.out.println();
		}
		//System.out.println("Count:"+count);
		if(flag==1){
			return 0;
		}
		else{
			NagamochiIbarakiAlg Ni=new NagamochiIbarakiAlg(0);
			int res=Ni.NIAlg(adj,n);
			//System.out.println("Result:"+res);
			return res;
		}
		
		
	}
}
