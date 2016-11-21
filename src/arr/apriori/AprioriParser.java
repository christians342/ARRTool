package arr.apriori;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import arr.general.ARRJavaPackage;
import arr.general.CodeDependencyMatrix;
import arr.util.ProjectUtilities;

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
		
		int numberOfTargetPackages;
		int numberOfBasePackages;
		
		while(input.hasNext()) {
			numberOfBasePackages = 0;
			numberOfTargetPackages = 0;
			
		    String nextLine = input.nextLine();
		    
		    ArrayList<ARRJavaPackage> targetPackages = new ArrayList<ARRJavaPackage>();
		    ArrayList<ARRJavaPackage> basePackages = new ArrayList<ARRJavaPackage>();;
		    
		    String[] lineTokens = nextLine.split(" #SUP: ");
		    String[] packageTokens = lineTokens[0].split(" ");
		    
		    for(String s : packageTokens)
		    {
		    	if(Integer.parseInt(s) <= matrix.getPackageElements().size())
		    	{
		    		numberOfTargetPackages++;
		    		targetPackages.add(matrix.getPackageElements().get(Integer.parseInt(s)));
		    	}
	    		else
		    	{
	    			numberOfBasePackages++;
		    		basePackages.add(matrix.getPackageElements().get(Integer.parseInt(s) - 10000));
		    	}
		    }
		    
		    int support = Integer.parseInt(lineTokens[1]);
		    if(numberOfBasePackages >= 1 && numberOfTargetPackages >= 1)
		    {
		    	boolean uselessRule = false;
		    	
		    	//Compare all packages to see if it isn't a irrelevant rule
		    	
		    	//If rule contains packages that are children of themselves in the target packages field
		    	for(int i = 0; i < targetPackages.size(); i++)
		    	{
		    		for(int j = 0; j < targetPackages.size(); j++)
		    		{
		    			if(targetPackages.get(i).getName().contains(targetPackages.get(j).getName()) && i != j)
		    			{
		    				uselessRule = true;
		    				break;
		    			}
		    		}
		    	}
		    	
		    	//If rule contains packages that are children of themselves in the base packages field
		    	if(!uselessRule)
			    	for(int i = 0; i < basePackages.size(); i++)
			    	{
				    	for(int j = 0; j < basePackages.size(); j++)
			    		{
			    			if(basePackages.get(i).getName().contains(basePackages.get(j).getName()) && i != j)
			    			{
			    				uselessRule = true;
			    				break;
			    			}
			    		}
			    	}
			    
		    	// Now check if the target and base packages aren't exactly the same
		    	int numberOfSamePackages = 0;
		    	if(!uselessRule)
		    	{
	    			if(basePackages.size() == targetPackages.size())
	    			{
	    				for(int i = 0; i < basePackages.size(); i++)
				    	{
					    	if(targetPackages.contains(basePackages.get(i)))
					    	{
					    		numberOfSamePackages++;
					    	}
				    	}
	    			}
		    	}
		    	
		    	if(targetPackages.size() == numberOfSamePackages)
		    		uselessRule = true;
		    	
		    	if(!uselessRule)
		    	{
		    		//Fix support value for end rules
		    		
		    		double newSupport;
		    		
	    			int numberOfClasses = 0;
		    		for(int j = 0; j < basePackages.size(); j++)
		    			numberOfClasses+= basePackages.get(j).getJavaPackage().getClasses().size();
		    	
		    		newSupport = (double) support/numberOfClasses;
	    			outputData.add(new AprioriOutput(basePackages, targetPackages, newSupport));
		    		totalNumberOfTransactions++;
		    	}
		    }
		}	
		
		
		System.out.println("Debugging basicão: UI.AUTHOR");
		for(AprioriOutput a : outputData)
		{
			if(a.getBasePackages().get(0).getName().contains("br.puc.maspl.ui.author"))
			{
				for(int i = 0; i < a.getUsedPackages().size();i++)
				System.out.println(a.getUsedPackages().get(i).getName());
			}
		}
		
		input.close();
		System.out.println("Total number of Transactions: " + Integer.toString(totalNumberOfTransactions));
		return outputData;
	}
}
