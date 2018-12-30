import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	int[][] A = new int[8][8];
	public static void main(String[] args) throws IOException {
		//Load File
		Scanner reader = new Scanner(System.in);
		System.out.println("Please input the file name:");
		String filename = reader.nextLine();
		File input = new File (filename);

		// Input
		int[][] A = new int[8][8];
		int y = 0;
		int x = 0;
		
		Scanner filereader = new Scanner(new File(filename));
		
		while(x !=9) {
			if(y==8) {
				x=9;
			}
			while(filereader.hasNextInt()) {
				int temp = filereader.nextInt();
				A[y][x] = temp;
				x++;
				if(x==8) {
					y++;
					x=0;
				}
				
			}
		}
			
		// Print Matrix and Relations
		printRelation(A);
		printMatrix(A);
		isreflexive(A);
		issymmetric(A);
		istransitive(A);
		isantisymmetric(A);
	}

	public static void printMatrix(int[][] A) {
		// This Function reads the 2d array and will output it 
		System.out.println("\n\nPrint Matrix:");
		// r = row, c = col
		for(int r=0; r<A.length; r++) {
		       for(int c=0; c<A[r].length; c++)
		           System.out.print(A[r][c] + " ");
		       System.out.println();
		    }
	}
	
	public static void printRelation(int[][] A){
		System.out.println("\nPrint Relations:");
		for(int r=0; r<A.length; r++) {
		       for(int c=0; c<A[r].length; c++)
		    	   if(A[r][c] == 1) {
		    		   System.out.print("(" + r + "," + c + ") ");
		    	   }
		}
	}
	
	public static boolean isreflexive(int[][] A) { //If diag follows through as 1 = true
		int r = 0;
		int c = 0;
		while(A[r][c] == 1) {
			r++;
			c++;
			if(r == 8) {
				System.out.println("\nis reflexive");
				return true;
			}
		}
		System.out.println("\nis not reflexive");
		return false;
	}
	
	public static boolean issymmetric(int[][] A) { // if a 1 is found, flip the r,c and see if it exists
		for(int r=0; r<A.length; r++) {
		       for(int c=0; c<A[r].length; c++) {
		    	   if(A[r][c] != A[c][r]) {
		    		   System.out.println("is not symmetric");
		    		   return false;
		    	   }
			}
		}
		System.out.println("is symmetric");
		return true;
	}
	
	
	
	public static boolean istransitive(int[][] A) {
		for(int r=0; r<A.length; r++) {
			for(int c=0; c<A[r].length; c++) 
				if (A[r][c] == 1){
					for (int t = 0; t < A.length; t++){
						if (A[c][t]==1 && A[r][t] == 0)	
							System.out.println("Is not transitive");
							return false;	
					}
				}
			}
		System.out.println("Is transitive");
		return true;
	}
		    

	static boolean isantisymmetric(int [][] A) {
		for(int r=0; r<A.length; r++) {
			for(int c=0; c<A[r].length; c++) {
		    	   if(A[r][c]==1 && r !=c) {
		    		   if(A[r][c] != A[c][r]) {
		    			   System.out.println("Is antisymmetric");
		    			   return true;
		    		   }
		    	   }
			}
		 }
		System.out.println("Is not antisymmetric");
	    return false;		
	}
	
	public boolean isequivalencerelation() {
		return false;
	}
}
