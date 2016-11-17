package arr.apriori;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import arr.general.ARRJavaPackage;
import arr.general.CodeDependencyMatrix;
import arr.utils.ProjectUtilities;

public class AprioriParser {

	File spmfFile;
	CodeDependencyMatrix matrix;
	
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
		    	boolean uselessRule = false;
		    	//Compare all packages to see if it isn't a irrelevant rule
		    	for(int i = 0; i < jPackages.size(); i++)
		    	{
		    		for(int j = 0; j < jPackages.size(); j++)
		    		{
		    			if(jPackages.get(i).getName().contains(jPackages.get(j).getName()) && i != j)
		    				uselessRule = true;
		    		}
		    	}
		    	
		    	if(!uselessRule)
		    	{
		    		double newSupport;
		    		//TODO: FINISH THIS PROPERLY
		    		int value = 1;
		    		for(int i = 0; i < matrix.getPackageElements().size(); i++)
		    		{
		    			if(targetJPackage.getName().contains(matrix.getPackageElements().get(i).getName())
		    					&& matrix.getPackageElements().get(i).getSpecial())
		    			{
		    				value++;
		    			}
		    		}
		    		
		    		for(int i = 0; i < matrix.getPackageElements().size(); i++)
		    		{
		    			if(matrix.getPackageElements().get(i).getName().contains(targetJPackage.getName()) && 
		    					targetJPackage.getSpecial() && matrix.getPackageElements().get(i).getSpecial())
		    				value--;
		    		}
		    		
		    		
		    		if(value < 1)
		    			value = 1;
		    		
		    		newSupport = (double) support/(targetJPackage.getJavaPackage().getClasses().size() * value);
		    		
		    		
		    		// Still need to understand why sometimes the support value goes beyond 1 for specially created packages
		    		if(newSupport > 1)
		    			newSupport = 1; 
		    		outputData.add(new AprioriOutput(targetJPackage, jPackages, newSupport));
		    		
		    		totalNumberOfTransactions++;
		    	}
		    }
		}	
		
		input.close();
		System.out.println("Total number of Transactions: " + Integer.toString(totalNumberOfTransactions));
		return outputData;
	}
}
