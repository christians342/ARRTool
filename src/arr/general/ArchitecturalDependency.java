package arr.general;

import org.eclipse.emf.ecore.impl.EObjectImpl;

public class ArchitecturalDependency extends EObjectImpl implements ArchitecturalDependencyInterface {
	private ARRJavaPackage source;
	private ARRJavaPackage target;
	double support = 0.0;
	int colorIdentifier = 0;
	
	public ArchitecturalDependency(ARRJavaPackage src, ARRJavaPackage target, double sup, int identifier)
	{
		this.source = src;
		this.target = target;
		this.support = sup;
		this.colorIdentifier = identifier;
	}
	
	public ARRJavaPackage getSource()
	{
		return this.source;
	}
	
	public ARRJavaPackage getTarget()
	{
		return this.target;
	}
	
	public double getSupport()
	{
		return this.support;
	}

	public void setSupport(Double support) {
		this.support = support;
		
	}
}
