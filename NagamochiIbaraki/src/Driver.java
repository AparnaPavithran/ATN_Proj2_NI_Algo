import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Driver {


	public static void main(String args[]) throws FileNotFoundException{
		System.out.println("Enter number of nodes: ");
		Scanner in;
		
		if(args.length>0){
			File inputFile = new File(args[0]);
			in = new Scanner(inputFile);
		}
		else{
			in = new Scanner(System.in);
		}
		
		int n;
		int m1;
		n=in.nextInt();
		if(n<0){
			n=21;
		}
		if(n%2==1){
			m1=n*(n-1)-n+1;
			m1=m1/2;
		}
		else{
			m1=n*(n-1)-n;
			m1=m1/2;
		}
		
		int n1=n-1;
		System.out.println("Enter number of edges between "+n1+" and "+m1+": ");
		int m;
		m=in.nextInt();
		if(m<n-1 || m>m1){
			System.out.println("Invalid input, taking a random number between "+n1+" and "+m1+": ");
			Random r = new Random();
			int Low = n1;
			int High = m1;
			m=r.nextInt(High-Low) + Low;
		}
		
		int[] lamda = new int[5];
		for(int i=0;i<5;i++){
			lamda[i]=Graph.adjacencyListCreation(n, m);
			System.out.println("Lamda value: "+lamda[i]);
		}
		int highlamda=0,smalllamda=Integer.MAX_VALUE;
		float avglamda=0;
		
		for(int i=0;i<lamda.length;i++){
			if(highlamda<lamda[i]){
				highlamda=lamda[i];
			}
			if(smalllamda>lamda[i]){
				smalllamda=lamda[i];
			}
			avglamda+=lamda[i];
		}
		avglamda=avglamda/lamda.length;
		System.out.println("High lamda value: "+highlamda);
		System.out.println("Small lamda value: "+smalllamda);
		System.out.println("Average lamda value: "+avglamda);
	}

	
}
