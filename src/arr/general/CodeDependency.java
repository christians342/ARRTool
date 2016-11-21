package arr.general;

import org.eclipse.core.resources.IProject;

import jdepend.framework.JavaClass;

public class CodeDependency {
	
	private JavaClass jClass;
	private String baseClassPackageName;
	private ARRJavaPackage jPackage;
	private IProject iProject;
	
	public CodeDependency(JavaClass jClass, ARRJavaPackage jPackage, IProject project)
	{
		this.jClass = jClass;
		this.baseClassPackageName = jClass.getPackageName();
		this.jPackage = jPackage;
		this.iProject = project;
	}

	public JavaClass getjClass() {
		return jClass;
	}

	public void setjClass(JavaClass jClass) {
		this.jClass = jClass;
	}

	public ARRJavaPackage getjPackage() {
		return jPackage;
	}

	public void setjPackage(ARRJavaPackage jPackage) {
		this.jPackage = jPackage;
	}

	public IProject getiProject() {
		return iProject;
	}

	public String getTargetClassPackageName() {
		return baseClassPackageName;
	}
}
