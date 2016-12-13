package arr.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.graphiti.mm.pictograms.Diagram;

import arr.algorithms.AlgorithmOutput;
import arr.general.ARRJavaPackage;
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
	
	public static void saveToModelFile(final ARRJavaPackage obj, final Diagram d) throws CoreException, IOException {
		URI uri = d.eResource().getURI();
		uri = uri.trimFragment();
		uri = uri.trimFileExtension();
		uri = uri.appendFileExtension("model"); //$NON-NLS-1$
		ResourceSet rSet = d.eResource().getResourceSet();
		final IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		IResource file = workspaceRoot.findMember(uri.toPlatformString(true));
		if (file == null || !file.exists()) {
			Resource createResource = rSet.createResource(uri);
			createResource.save(Collections.emptyMap());
			createResource.setTrackingModification(true);
		}
		final Resource resource = rSet.getResource(uri, true);
		resource.getContents().add(obj);
		
	}
	
	public static void createCSVFileForAlgorithms(ArrayList<AlgorithmOutput> aOuts, File f) throws IOException
	{
		if(f.exists())
			Files.delete(f.toPath());
		FileWriter fw = new FileWriter(f,false);
		for(int i = 0; i < aOuts.size(); i++)
		{
			for(int j = 0; j < aOuts.get(i).getBasePackages().size(); j++)
			{
				if(aOuts.get(i).getBasePackages().get(j).getPackageProjectName() != null)
					fw.write(aOuts.get(i).getBasePackages().get(j).getPackageProjectName() + "." + aOuts.get(i).getBasePackages().get(j).getName());
				else
				{
					fw.write(aOuts.get(i).getBasePackages().get(j).getName());
				}
				if((j + 1) != aOuts.get(i).getBasePackages().size())
					fw.write(";");
			}
			
			fw.write(",");
			for(int j = 0; j < aOuts.get(i).getUsedPackages().size(); j++)
			{
				fw.write(aOuts.get(i).getUsedPackages().get(j).getPackageProjectName() + "." + aOuts.get(i).getUsedPackages().get(j).getName());
				if((j + 1) != aOuts.get(i).getUsedPackages().size())
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
					System.out.println(dmatrix.getPackageElements().get(j).getName() + " " + Integer.toString(j));
					classUsed = true;
				}
			}
			//Escrever ID do pacote que contém a classe aqui
			if(classUsed == true)
			{
				for ( int j = 0; j < dmatrix.getPackageElements().size(); j++)
				{
					if (dmatrix.getPackageElements().get(j).getJavaPackage().getClasses().contains(dmatrix.getClassElements().get(i)))
					{
						fw.write(Integer.toString(j + 10000) + " ");
						System.out.println(dmatrix.getPackageElements().get(j).getName() + " " + Integer.toString(j)+10000);
					}
				}
				if(dmatrix.getClassElements().size() != (i+1))
					fw.write(System.lineSeparator());
				//System.out.println(dmatrix.getClassElements().get(i).getPackageName());
			}
			classUsed = false;
		}
		fw.close();
		System.out.println("Arquivo criado.");
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
