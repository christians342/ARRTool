package arr.apriori;

import java.util.ArrayList;

import arr.general.ARRJavaPackage;

public class AprioriOutput {
	ArrayList<ARRJavaPackage> basePackages;
	ArrayList<ARRJavaPackage> usedPackages;
	double suport = 0.0;

	public AprioriOutput(ArrayList<ARRJavaPackage> basePackages, ArrayList<ARRJavaPackage> jPackages, double suport)
	{
		this.basePackages = basePackages;
		this.usedPackages = jPackages;
		this.suport = suport;
	}

	public ArrayList<ARRJavaPackage> getBasePackages() {
		return basePackages;
	}

	public ArrayList<ARRJavaPackage> getUsedPackages() {
		return usedPackages;
	}

	public Double getSuport() {
		return suport;
	}
	
	public void setSuport(double value)
	{
		this.suport = value;
	}

}
