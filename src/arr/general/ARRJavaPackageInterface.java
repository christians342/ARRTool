package arr.general;

import java.util.Collection;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EObject;

import jdepend.framework.JavaClass;
import jdepend.framework.JavaPackage;

public interface ARRJavaPackageInterface extends EObject {
	
	public IProject getPackageProject();

	public void setPackageProject(IProject packageProject);
	
	public String getName();

	public Collection<JavaClass> getClasses();
	
	public JavaPackage getJavaPackage();
}
