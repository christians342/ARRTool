package arr.general;

import java.util.ArrayList;

import jdepend.framework.JavaClass;

/*
 * The matrix will be NxM (line x column) and N is the number of classes (classElements)
 * and M will be the number of packages
 */

public class DependencyMatrix {
	private boolean[][] matrix;
	private ArrayList<ARRJavaPackage> packageElements;
	private ArrayList<JavaClass> classElements;
	private ArrayList<Dependency> dependencyList;
	
	public DependencyMatrix( ArrayList<JavaClass> projectClasses, ArrayList<ARRJavaPackage> projectPackages, ArrayList<Dependency> dependencyCollection){
		matrix = new boolean[projectClasses.size()][projectPackages.size()];
		this.classElements = projectClasses;
		this.packageElements = projectPackages;
		this.dependencyList = dependencyCollection;
		matrix = new boolean[projectClasses.size()][projectPackages.size()];
		for(int i = 0; i < projectClasses.size(); i++)
			for(int j = 0; j < projectPackages.size(); j++)
				matrix[i][j] = false;
	}

	public void calculateMatrix(){
		System.out.println("\nCalculando Matriz de dependências para o SPMF:");
		System.out.println("Número de classes: " + classElements.size() + "\nNúmero de Pacotes: "+ packageElements.size() +"\nNúmero de dependências: "+ dependencyList.size());
		
		System.out.println("\nDependências encontradas:\n(Classe, Pacote)");
		for(Dependency d : dependencyList)
			System.out.println(d.getjClass().getName() + ", " + d.getjPackage().getName());
		
		System.out.println("\nClasses encontradas:");
		for(JavaClass jClass : classElements)
			System.out.println(jClass.getName());
		

		System.out.println("\nPacotes encontrados:");
		for(ARRJavaPackage jPackage : packageElements)
			System.out.println(jPackage.getName());
		
		// Need to compare with == and not with .equals because JDepend framework overwrites the .compare method on jClass and JavaPackage.
		for(int i = 0; i < classElements.size(); i++)
			for(int j = 0; j < packageElements.size(); j++)
				for(int z = 0; z < dependencyList.size(); z++)
					if(classElements.get(i) == (dependencyList.get(z).getjClass()) && packageElements.get(j) == (dependencyList.get(z).getjPackage()))
						matrix[i][j] = true;
		printMatrix();
		calculateNumberOfTransactions();
		
		
	}
	public boolean[][] getMatrix() {
		return matrix;
	}
	public void setMatrix(boolean[][] matrix) {
		this.matrix = matrix;
	}
	public ArrayList<ARRJavaPackage> getPackageElements() {
		return packageElements;
	}
	public void setPackageElements(ArrayList<ARRJavaPackage> packageElements) {
		this.packageElements = packageElements;
	}
	public ArrayList<JavaClass> getClassElements() {
		return classElements;
	}
	public void setClassElements(ArrayList<JavaClass> classElements) {
		this.classElements = classElements;
	}
	public ArrayList<Dependency> getDependencyList() {
		return dependencyList;
	}
	public void setDependencyList(ArrayList<Dependency> dependencyList) {
		this.dependencyList = dependencyList;
	}
	
	private void calculateNumberOfTransactions()
	{
		boolean used = false;
		for(int i = 0; i < classElements.size(); i++)
		{
			for(int j = 0; j < packageElements.size(); j++)
			{
				if(matrix[i][j] == true)
				{
					if(used == false)
					{
						used = true;
					}
				}
			}
			used = false;
		}

	}
	
	private void printMatrix()
	{
		for (int i = 0; i < classElements.size(); i++)
		{
			for (int j = 0; j < packageElements.size(); j++)
			{
				System.out.print(Boolean.toString(matrix[i][j]) + " ");
			}
			System.out.println("");
		}

	}
}
