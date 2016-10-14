package arr.general;

import java.util.Collection;

import org.eclipse.core.resources.IProject;

import jdepend.framework.JavaClass;
import jdepend.framework.JavaPackage;

public class ARRJavaPackage{
	
	JavaPackage jPackage;
	IProject packageProject;
	
	public IProject getPackageProject() {
		return packageProject;
	}

	public void setPackageProject(IProject packageProject) {
		this.packageProject = packageProject;
	}

	public ARRJavaPackage(String name) {
		jPackage = new JavaPackage(name);
	}
	
	public ARRJavaPackage(String name, int i) {
		jPackage = new JavaPackage(name, i);
	}
	
	public ARRJavaPackage(JavaPackage p) {
		jPackage = p;
	}
	
	public String getName()
	{
		return jPackage.getName();
	}
	
	@SuppressWarnings("unchecked")
	public Collection<JavaClass> getClasses()
	{
		return jPackage.getClasses();
	}
	
	public JavaPackage getJavaPackage()
	{
		return this.jPackage;
	}
}
