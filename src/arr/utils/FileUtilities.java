package arr.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;

import arr.apriori.AprioriOutput;
import arr.general.CodeDependencyMatrix;

public class FileUtilities {
	public static void createCSVFileForDependencies(CodeDependencyMatrix dmatrix, File f) throws IOException
	{
		if(f.exists())
			Files.delete(f.toPath());
		FileWriter fw = new FileWriter(f,false);
		fw.write("Elements,");
		for(int i = 0; i < dmatrix.getPackageElements().size(); i++)
		{
			fw.write(dmatrix.getPackageElements().get(i).getName());
			if(dmatrix.getPackageElements().size() != (i + 1))
				fw.write(",");
		}
		fw.write("\n");
		for(int i = 0; i < dmatrix.getClassElements().size(); i++)
		{
			fw.write(dmatrix.getClassElements().get(i).getName() + ",");
			for(int j = 0; j < dmatrix.getPackageElements().size(); j++)
			{
				if(dmatrix.getMatrix()[i][j] == true)
					fw.write("t");
				else
					fw.write("f");
				if(dmatrix.getPackageElements().size() != (j+1))
					fw.write(",");
				else
					fw.write("\n");
			}
		}
		fw.close();
	}
	
	public static void createCSVFileForApriori(ArrayList<AprioriOutput> aOuts, File f) throws IOException
	{
		if(f.exists())
			Files.delete(f.toPath());
		FileWriter fw = new FileWriter(f,false);
		for(int i = 0; i < aOuts.size(); i++)
		{
			if(aOuts.get(i).getTargetPackage().getPackageProject() != null)
				fw.write(aOuts.get(i).getTargetPackage().getPackageProject().getName() + "." + aOuts.get(i).getTargetPackage().getName());
			else
			{
				fw.write(aOuts.get(i).getTargetPackage().getName());
			}
			fw.write(",");
			for(int j = 0; j < aOuts.get(i).getjPackages().size(); j++)
			{
				fw.write(aOuts.get(i).getjPackages().get(j).getPackageProject().getName() + "." + aOuts.get(i).getjPackages().get(j).getName());
				if((j + 1) != aOuts.get(i).getjPackages().size())
					fw.write(";");
			}
			fw.write(",");
			fw.write(String.valueOf(aOuts.get(i).getSuport()));
			if((i+ 1) != aOuts.size())
			fw.write("\n");
		}
		fw.close();
	}
	
	public static File createSPMFInput(CodeDependencyMatrix dmatrix, String fileName, String projectFolder) throws IOException
	{
		System.out.println("Creating SPMF file for project in folder " + projectFolder);
		File f = new File(new File(projectFolder).getAbsolutePath() + File.separator + fileName + ".arr");
		if(f.exists())
			Files.delete(f.toPath());
		FileWriter fw = new FileWriter(f,false);
		
		boolean classUsed = false;
		for (int i = 0; i < dmatrix.getClassElements().size(); i++)
		{
			for (int j = 0; j < dmatrix.getPackageElements().size(); j++)
			{
				if(dmatrix.getMatrix()[i][j] == true)
				{
					fw.write(Integer.toString(j) + " ");
					classUsed = true;
				}
			}
			//Escrever ID do pacote que contém a classe aqui
			if(classUsed == true)
			{
				for ( int j = 0; j < dmatrix.getPackageElements().size(); j++)
				{
					if (dmatrix.getPackageElements().get(j).getClasses().contains(dmatrix.getClassElements().get(i)))
					{
						fw.write(Integer.toString(j + 10000));
					}
				}
				if(dmatrix.getClassElements().size() != (i+1))
					fw.write(System.lineSeparator());
				//System.out.println(dmatrix.getClassElements().get(i).getPackageName());
			}
			classUsed = false;
		}
		fw.close();
		
		return f;
	}
	
	public static Collection<File> selectFolderList(Collection<File> files)
	{
		Collection<File> folderList = new ArrayList<File>();
		for(File f : files)
		{
			if(f.isDirectory())
				folderList.add(f);
		}
		return folderList;
	}
	
}
