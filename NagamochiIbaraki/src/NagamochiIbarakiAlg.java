
public class NagamochiIbarakiAlg {

	private static int res;

	public NagamochiIbarakiAlg(int res) {
		this.res=res;
	}


	public static int NIAlg(int[][] adj,int n){
		
		if(n==2){
			int r=0;
			int i=0;
			for(int j=0;j<n;j++){
				r+=adj[i][j];
			}
			return r;
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
		
		if(flag==1){
			return 0;
		}
		int[] a=MAOrdering(adj,n);
		
		int[][] adj1=Merge(adj,a[0],a[1],n);      //Merge completed n tested
		
		res=Min(NIAlg(adj1,n-1),a[2]);
		return(res);
		//System.out.println(a);
		//return 0;
	}
	public static int Min(int n1, int n2){
		if(n1<n2){
			return n1;
		}
		else{
			return n2;
		}
	}
	public static int[] MAOrdering(int[][] adj,int node){
		int[] a = new int[3];
		int[] q=new int[node];
		int i=0;
		q[i]=0;
		
		while(i<node-1){
			//int[] c=null;
			
			
			int[] c=count(adj,q,node);
			int m=max(c,node);
			q[++i]=m;	
		}	
		a[0]=q[node-2];
		a[1]=q[node-1];
		i=a[1];
		for(int j=0;j<node;j++){
			a[2]+=adj[i][j];
		}
		return a;
	}
	
	public static int[] count(int[][] adj,int[] q,int node){
		int[] c=new int[node];
		
		for(int j=0;j<node;j++)
		{
			int flag=0;
			for(int i=0;i<q.length;i++){
				if(q[i]==j){
					flag=1;
					break;
				}
			}
			if(flag==1)
				continue;
			else{
				for(int i=0;i<q.length;i++){
					c[j]+=adj[i][j];
				}
			}
				//c[j]+=adj;
		}
		return c;
	}
	
	public static int max(int[] c,int node){
		int a=c[0];
		int ret=0;
		for(int i=1;i<node;i++){
			if(a<c[i]){
				a=c[i];
				ret=i;
			}
		}
		return ret;
	}
	
	
	public static int[][] Merge(int[][] adj,int x,int y, int node){
		int[][] a =new int[node-1][node-1];

		
		for(int i=0;i<node;i++){
			if(i==x){
				for(int j=0;j<node;j++){
					int k=adj[x][j];
					adj[x][j]=k+adj[y][j];
					adj[y][j]=k+adj[y][j];
				}
				break;
			}
			
		}
		/*
		System.out.println("Adjacency test");
		for(int i=0;i<node;i++){
			for(int j=0;j<node;j++){
				System.out.print(adj[i][j]);
			}
			System.out.println();
		}
		*/
		for(int j=0;j<node;j++){
			if(j==x){
				for(int i=0;i<node;i++){
					int k=adj[i][x];
					adj[i][x]=k+adj[i][y];
					adj[i][y]=k+adj[i][y];
				}
			}
		}
		/*
		System.out.println("Adjacency test2");
		for(int i=0;i<node;i++){
			for(int j=0;j<node;j++){
				System.out.print(adj[i][j]);
			}
			System.out.println();
		}
		*/
		//new adjacency list creation
		int p=0,q;
		for(int i=0;i<node;i++){
			q=0;
			if(i==y)
				continue;
			for(int j=0;j<node;j++){
				if(j==y)
					continue;
				if(p==q)
					a[p][q++]=0;
				else
					a[p][q++]=adj[i][j];
			}
			p++;
		}
		/*
		int flag=0;
		//System.out.println("New Adjacency test");
		for(int i=0;i<node-1;i++){
			for(int j=0;j<node-1;j++){
				//System.out.print(a[i][j]);
			}
			//System.out.println();
		}
		*/
		return a;
	}
}

