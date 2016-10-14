package arr.apriori;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import arr.general.ARRJavaPackage;
import arr.general.DependencyMatrix;
import arr.utils.ProjectUtilities;

public class AprioriParser {

	File spmfFile;
	DependencyMatrix matrix;
	
	public AprioriParser(File f)
	{
		spmfFile = f;
		matrix = ProjectUtilities.getDependencyMatrix();
	}
	
	public ArrayList<AprioriOutput> parse() throws FileNotFoundException
	{
		if(!spmfFile.exists() || !spmfFile.isFile())
			return null;
		
		ArrayList<AprioriOutput> outputData = new ArrayList<AprioriOutput>();
		Scanner input = new Scanner(spmfFile);
		int totalNumberOfTransactions = 0;
		
		int numberOfElements;
		boolean foundTargetPackage;
		boolean multipleTargets;
		while(input.hasNext()) {
			numberOfElements = 0;
			foundTargetPackage = false;
			multipleTargets = false;
			
		    String nextLine = input.nextLine();
		    
		    ArrayList<ARRJavaPackage> jPackages = new ArrayList<ARRJavaPackage>();
		    ARRJavaPackage targetJPackage = null;
		    
		    String[] lineTokens = nextLine.split(" #SUP: ");
		    String[] packageTokens = lineTokens[0].split(" ");
		    
		    for(String s : packageTokens)
		    {
		    	if(Integer.parseInt(s) <= matrix.getPackageElements().size())
		    		jPackages.add(matrix.getPackageElements().get(Integer.parseInt(s)));
		    	else
		    	{
		    		if(foundTargetPackage == true)
	    				multipleTargets = true;
		    		targetJPackage = matrix.getPackageElements().get(Integer.parseInt(s) - 10000);
		    		foundTargetPackage = true;
		    	}
		    	numberOfElements++;
		    }
		    
		    int support = Integer.parseInt(lineTokens[1]);
		    if(foundTargetPackage == true && multipleTargets == false && numberOfElements > 1)
		    {
		    	outputData.add(new AprioriOutput(targetJPackage, jPackages, (double)support/targetJPackage.getJavaPackage().getClassCount()));
		    	totalNumberOfTransactions++;
		    }
		}
		input.close();
		System.out.println("Blablabla " + Integer.toString(totalNumberOfTransactions));
		return outputData;
	}
}
