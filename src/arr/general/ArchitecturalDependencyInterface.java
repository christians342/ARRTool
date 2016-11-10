package arr.general;

import org.eclipse.emf.ecore.EObject;

public interface ArchitecturalDependencyInterface extends EObject {
	
	public ARRJavaPackage getSource();
	
	public ARRJavaPackage getTarget();
	
	public double getSupport();
}
