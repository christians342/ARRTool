package arr.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaModel;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.Workbench;

import arr.apriori.AprioriOutput;
import arr.general.impl.ARRJavaPackageImpl;
import arr.general.ARRJavaPackage;
import arr.general.CodeDependency;
import arr.general.CodeDependencyMatrix;
import arr.ui.MessageSystem;
import jdepend.framework.JDepend;
import jdepend.framework.JavaClass;
import jdepend.framework.JavaPackage;


@SuppressWarnings("restriction")
public class ProjectUtilities {
	private static CodeDependencyMatrix dependencyMatrix;
	private static boolean dependencyMatrixStatus = false;
	private static ArrayList<AprioriOutput> aOuts;
	
	// Returns true if the dependency matrix was set at least one time while the project was running (aka the program was run at least one time)
	public static boolean getDependencyMatrixStatus()
	{
		return dependencyMatrixStatus;
	}
	
	public static CodeDependencyMatrix getDependencyMatrix()
	{
		return dependencyMatrix;
	}
	
	public static void setDependencyMatrix(CodeDependencyMatrix d)
	{
		dependencyMatrixStatus = true;
		dependencyMatrix = d;
	}
	
	public static IProject getCurrentProject(){    
        ISelectionService service = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService();  
        IStructuredSelection structured = (IStructuredSelection) service
    			.getSelection("org.eclipse.jdt.ui.PackageExplorer");
        IResource resource = ProjectUtilities.extractSelection(structured);
        if(resource == null)
        {
        	System.out.println("ResourceNULL");
        	return null;
        }
        return resource.getProject();
    }
	
	
	public static IProject getCurrentProjectFromPackageExplorer(){    
        ISelectionService selectionService =     
            Workbench.getInstance().getActiveWorkbenchWindow().getSelectionService();    

        ISelection selection = selectionService.getSelection("org.eclipse.jdt.ui.PackageExplorer");    

        IProject project = null;    
        if(selection instanceof IStructuredSelection) {    
            Object element = ((IStructuredSelection)selection).getFirstElement();    

            if (element instanceof IResource) {    
                project= ((IResource)element).getProject();    
            } else if (element instanceof IPackageFragmentRoot) {    
                IJavaProject jProject =     
                    ((IPackageFragmentRoot)element).getJavaProject();    
                project = jProject.getProject();    
            } else if (element instanceof IJavaElement) {    
                IJavaProject jProject= ((IJavaElement)element).getJavaProject();    
                project = jProject.getProject();    
            }    
        }     
        return project;    
    }
	public static IProject[] getProjectsFromWorkspace(){
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		return projects;
		}
	
	public static IJavaModel getJavaModel() {
	    IWorkspace workspace = ResourcesPlugin.getWorkspace();
	    IWorkspaceRoot workspaceRoot = workspace.getRoot();
	    IJavaModel javaModel = JavaCore.create(workspaceRoot);
	    return javaModel;
	}
	
	public static IPath getDirectoryOfProject(IProject project)
	{
		IPath path = project.getFullPath();
        System.out.println(path);
		return path;
	}
	
	public static IResource extractSelection(ISelection sel) {
	      if (!(sel instanceof IStructuredSelection))
	         return null;
	      IStructuredSelection ss = (IStructuredSelection) sel;
	      Object element = ss.getFirstElement();
	      if (element instanceof IResource)
	         return (IResource) element;
	      if (!(element instanceof IAdaptable))
	         return null;
	      IAdaptable adaptable = (IAdaptable)element;
	      Object adapter = adaptable.getAdapter(IResource.class);
	      return (IResource) adapter;
	}
	
	public static void sampleGetSelectedProject() {
        ISelectionService ss=PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService();
        String projExpID = "org.eclipse.ui.navigator.ProjectExplorer";
        
        ISelection sel = ss.getSelection(projExpID);
        Object selectedObject=sel;
        if(sel instanceof IStructuredSelection) {
              selectedObject=((IStructuredSelection)sel).getFirstElement();
        }
        if (selectedObject instanceof IAdaptable) {
              IResource res = (IResource) ((IAdaptable) selectedObject)
                          .getAdapter(IResource.class);
              IProject project = res.getProject();
              System.out.println("Project found: "+project.getName());
        }
	}

	@SuppressWarnings("unchecked")
	public static CodeDependencyMatrix getDependenciesFromProjects(ArrayList<IProject> projects)
	{
		if(projects.isEmpty()){
			System.out.println("ProjectNULL");
			return null;
		}
		ArrayList<String> projectsSrcPath = new ArrayList<String>();
		ArrayList<String> projectsClassPath = new ArrayList<String>();
		//TODO : check the reason why I need to remove the first project (RemoteSystemsTempFiles)
		projects.remove(0);
		
		for(IProject p : projects)
		{
			projectsSrcPath.add(p.getLocation().toString() + "/src");
			projectsClassPath.add(p.getLocation().toString() + "/bin");
		}
		
		ArrayList<File> srcFolders = new ArrayList<File>();
		ArrayList<File> classFolders = new ArrayList<File>();
		
		System.out.println("\nFound Projects:");
		for(String path : projectsSrcPath)
		{
			System.out.println(path);
			srcFolders.add(new File(path));
		}
		
		for(String path : projectsClassPath)
		{
			System.out.println(path);
			classFolders.add(new File(path));
		}
		
		Collection<File> srcFilesFromProjects = new ArrayList<File>();
		for(File folder : srcFolders)
		{
			System.out.println("Source Folder " + folder.getAbsolutePath() );
			srcFilesFromProjects.addAll(FileUtils.listFilesAndDirs(folder, TrueFileFilter.TRUE, TrueFileFilter.INSTANCE));
		}
		Collection<File> classFilesFromProjects = new ArrayList<File>();
		for(File folder : classFolders)
			classFilesFromProjects.addAll(FileUtils.listFilesAndDirs(folder, TrueFileFilter.TRUE, TrueFileFilter.INSTANCE));
		
		
		Collection<File> classpathFolders = FileUtilities.selectFolderList(srcFilesFromProjects);
		Collection<File> classesFolders = FileUtilities.selectFolderList(classFilesFromProjects);
		
		System.out.println("\nClasspath folders found:");
		for(File f : classpathFolders)
			System.out.println(f.getAbsolutePath());
		
		
		// JDepend library call code
		//System.out.println("\nPaths para o jDepend analizar:");
		JDepend jdepend = new JDepend();
		try {
			for(File f : classesFolders)
			{
				String fp = f.getAbsolutePath().replace('\\', '/');
				//System.out.println(fp);
				jdepend.addDirectory(fp);
			}
		} catch (IOException e) {
			MessageSystem.jdependProblem();
			e.printStackTrace();
		}
		
		//Using jDepend to analyze the selected files
		ArrayList<JavaPackage> importedJPackages = new ArrayList<JavaPackage>(jdepend.analyze());
		
		ArrayList<ARRJavaPackage> importedPackages = new ArrayList<ARRJavaPackage>();
		for(int i = 0; i < importedJPackages.size(); i++)
		{
			System.out.println("Pacote do JDepend: " + importedJPackages.get(i).getName());
			importedPackages.add(new ARRJavaPackageImpl(importedJPackages.get(i)));
		}
		
		fixHigherPackages(importedPackages);
		
		//Uses the JavaCore.create method to get all the packages within the selected projects
		ArrayList<IJavaProject> jProjects = new ArrayList<IJavaProject>();
		
		for(IProject p : projects)
			jProjects.add(JavaCore.create(p));
		
		ArrayList<IPackageFragment> filteredClasspathPackages = new ArrayList<IPackageFragment>();
		
		//System.out.println("\nPaths relativos:");
		try {
			IPackageFragment[] classpathPackages;
			for(IJavaProject p : jProjects)
			{
				String projectPath = (p.getProject().getLocation().toString() + "/src").replace('/', '\\');
				classpathPackages = p.getPackageFragments();
				for(IPackageFragment tempPackage : classpathPackages)
				{
					//System.out.print(tempPackage.getElementName());
					for (File folder : classpathFolders)
					{
						String path = folder.getCanonicalPath();
						//System.out.println("\nComparação: (Se A contém B)");
						//System.out.println("A : " + projectPath);
						//System.out.println("B : " + path);
						
						if(path.contains(projectPath))
						{
							//System.out.println("A continha B.");
							String relativePath = path.substring(projectPath.length());
							relativePath = relativePath.replace('\\', '.');
							if(relativePath.length()>= 1)
								relativePath = relativePath.substring(1);
							//System.out.println("RelativePath:");
							//System.out.println(relativePath);
							if(tempPackage.getElementName().equals(relativePath) && tempPackage.getElementName().length() >= 1)
							{
								//System.out.println("Adding something to filteredClasspathPackages");
								filteredClasspathPackages.add(tempPackage);
							}
						}
						
					}
				}
			}

			//Compare the imported packages name with the found packages name, if the name is the same we keep the data, otherwise it is a library input (.jar or system lib)
			Iterator<ARRJavaPackage> i = importedPackages.iterator();
			ArrayList<CodeDependency> dependencies = new ArrayList<CodeDependency>();
			ArrayList<JavaClass> projectClasses = new ArrayList<JavaClass>();
			ArrayList<ARRJavaPackage> projectPackages = new ArrayList<ARRJavaPackage>();
			
			// Stores all the project(s) packages first, then run for the classes within them
			while (i.hasNext()) 
			{
				ARRJavaPackage jPackage = (ARRJavaPackage) i.next();
				 for (IPackageFragment mypackage : filteredClasspathPackages) 
				 {
					if(jPackage.getName().equals(mypackage.getElementName()))
				    {
						 jPackage.setPackageProjectName(mypackage.getJavaProject().getProject().getName());
						 System.out.println("Found similar ->\njPackage name: " + jPackage.getName() + " \nfilteredClasspathPackages: " + mypackage.getElementName());
						 projectPackages.add(jPackage);
				    }
				 }
			}
			
			i = importedPackages.iterator();
			
			while (i.hasNext()) 
			{
				ARRJavaPackage jPackage = (ARRJavaPackage) i.next();
				 for (IPackageFragment mypackage : filteredClasspathPackages) 
				 {
					if(jPackage.getName().equals(mypackage.getElementName()))
				    {
						 
						 Collection<?> classes = jPackage.getJavaPackage().getClasses();
					     for (Iterator<?> j = classes.iterator(); j.hasNext();) 
					     {
					            JavaClass jClass = (JavaClass)j.next();

					            if(!projectClasses.contains(jClass))
					            	projectClasses.add(jClass);
					            ArrayList<JavaPackage> classJImports = new ArrayList<JavaPackage>(jClass.getImportedPackages());
					            
					            ArrayList<ARRJavaPackage> classImports = new ArrayList<ARRJavaPackage>();
					            
					            for(int l = 0; l < classJImports.size(); l++)
					            	for (int m = 0; m < projectPackages.size(); m++)
					            		if(projectPackages.get(m).getJavaPackage().equals(classJImports.get(l)))
					            			classImports.add(projectPackages.get(m));
					            
					            for (Iterator<?> k = classImports.iterator(); k.hasNext();) 
					            {
					            	ARRJavaPackage importedPackageFromClass = (ARRJavaPackage) k.next();
					            	for (IPackageFragment mypackage2 : filteredClasspathPackages)
					            		if(importedPackageFromClass.getName().equals(mypackage2.getElementName()))
					            		{
					            			dependencies.add(new CodeDependency(jClass,importedPackageFromClass,mypackage2.getJavaProject().getProject()));
					            		}
					            }
					     }
			        }
			     }
			}
			CodeDependencyMatrix fullDependencyMatrix = new CodeDependencyMatrix(projectClasses, projectPackages, dependencies);
			fullDependencyMatrix.calculateMatrix();
			
			ProjectUtilities.setDependencyMatrix(fullDependencyMatrix);
			
			return fullDependencyMatrix;
		} catch (JavaModelException | IOException e) {
			// Shouldn't get here... Unless there isn't permission to write/read in folder or projects are completely bugged?
			MessageSystem.unknownError();
			e.printStackTrace();
		}
		return null;
		
	}
	private static void fixHigherPackages(ArrayList<ARRJavaPackage> importedJPackages) {
		
		//Para cada pacote existente dentro de importedJPackages
		for(int i = 0; i < importedJPackages.size(); i++)
		{
			// Se existe um pai
			if(getUpperPackageName(importedJPackages.get(i)) != null)
			{
				int packageId = -1;
				boolean existsInList = false;
				//Verificar se já tenho o pacote "pai" dentro da lista
				for(int j = 0; j < importedJPackages.size(); j++)
				{
					if(importedJPackages.get(j).getName().equals(getUpperPackageName(importedJPackages.get(i))))
					{
						existsInList = true;
						packageId = j;
					}
				}
				//Caso não tenha, cria ele (caso necessário)
				ARRJavaPackage upperPackage;
				if(!existsInList)
					upperPackage = new ARRJavaPackageImpl(getUpperPackageName(importedJPackages.get(i)));
				else
					upperPackage = importedJPackages.get(packageId);
				
				int oldNClass = upperPackage.getJavaPackage().getClasses().size();
				
				//passa por todos os pacotes da lista e 
				for(int j = 0; j < importedJPackages.size(); j++)
				{
					
					//Adiciona, para todos os que importam os filhos dele, ele mesmo como import;
					for (int k = 0; k < importedJPackages.get(j).getJavaPackage().getClasses().size(); k ++) 
				    {
						boolean alreadyAdd = false;
						JavaClass jClass = (JavaClass) importedJPackages.get(j).getJavaPackage().getClasses().toArray()[k];
			            
						for (int l = 0; l < jClass.getImportedPackages().size(); l++) 
			            {
							
			            	JavaPackage importedPackageFromClass = (JavaPackage) jClass.getImportedPackages().toArray()[l];
							if(importedPackageFromClass.getName().equals(upperPackage.getName()) && !alreadyAdd)
							{
								alreadyAdd = true;
								jClass.addImportedPackage(upperPackage.getJavaPackage());
							}
						}
				     }
					
				}
				
				for(int j = 0; j < importedJPackages.size(); j++)
				{
					//vê se são parentes
					if(importedJPackages.get(j).getName().contains(upperPackage.getName()))
					{
						System.out.println("Pacote: " + upperPackage.getName() + " contém: " + importedJPackages.get(j).getName());
						//Adiciona todos as classes do pacote que contém o nome dele, caso não existam ainda;
						
						for(int k = 0; k < importedJPackages.get(j).getJavaPackage().getClasses().size(); k++)
						{
							if(!upperPackage.getJavaPackage().getClasses().contains(importedJPackages.get(j).getJavaPackage().getClasses().toArray()[k]))
								upperPackage.getJavaPackage().addClass((JavaClass) importedJPackages.get(j).getJavaPackage().getClasses().toArray()[k]);
						}

					}
				}
				
				if(!existsInList)
				{
					System.out.println("Adicionando pacote extra de nome: " + upperPackage.getName());
					System.out.println("Com " + upperPackage.getJavaPackage().getClasses().size() + " classes;");
					upperPackage.setSpecialPackage(true);
					importedJPackages.add(upperPackage);
				}
				else
				{
					System.out.println("Editado pacote extra de nome: " + upperPackage.getName());
					System.out.println("Número de classes antes: " + oldNClass);
					System.out.println("Agora com " + upperPackage.getJavaPackage().getClasses().size() + " classes;");
				}
				
			}
		}
		return;
		
	}
	
	private static String getUpperPackageName(ARRJavaPackage p)
	{
		boolean isEmpty = true;
		
		String[] nameArray = p.getName().split("\\.");
		StringBuilder stringBuilder = new StringBuilder();
		
		if(nameArray.length != 0)
			for(int i = 0; i < (nameArray.length - 1); i++)
			{
				isEmpty = false;
				stringBuilder.append(nameArray[i]);
				if(i != nameArray.length - 2)
					stringBuilder.append(".");
			}
		
		if(!isEmpty)
			return new String(stringBuilder.toString());
		return null;
	}
	
	public static CodeDependencyMatrix getDependenciesFromProject(IProject project)
	{
		ArrayList<IProject> projectsList = new ArrayList<IProject>();
		projectsList.add(project);
		projectsList.add(project);
		return getDependenciesFromProjects(projectsList);
	}

	public static ArrayList<AprioriOutput> getaOuts() {
		return aOuts;
	}
	
	public static void clearaOuts(){
		aOuts.clear();
	}

	public static void setaOuts(ArrayList<AprioriOutput> aOuts) {
		ProjectUtilities.aOuts = aOuts;
	}
}
