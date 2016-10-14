package arr.apriori;

import java.util.ArrayList;

import arr.general.ARRJavaPackage;

public class AprioriOutput {
	ARRJavaPackage targetPackage;
	ArrayList<ARRJavaPackage> jPackages;
	double suport = 0.0;
	
	public AprioriOutput(ARRJavaPackage targetJPackage, ArrayList<ARRJavaPackage> jPackages, double suport)
	{
		this.targetPackage = targetJPackage;
		this.jPackages = jPackages;
		this.suport = suport;
	}

	public ARRJavaPackage getTargetPackage() {
		return targetPackage;
	}

	public ArrayList<ARRJavaPackage> getjPackages() {
		return jPackages;
	}

	public Double getSuport() {
		return suport;
	}
	
	public void setSuport(double value)
	{
		this.suport = value;
	}

}
