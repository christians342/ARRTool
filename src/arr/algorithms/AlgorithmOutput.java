package arr.algorithms;

import java.util.ArrayList;

import arr.general.ARRJavaPackage;

public class AlgorithmOutput {
	ArrayList<ARRJavaPackage> basePackages;
	ArrayList<ARRJavaPackage> usedPackages;
	double suport = 0.0;

	public AlgorithmOutput(ArrayList<ARRJavaPackage> basePackages, ArrayList<ARRJavaPackage> jPackages, double suport)
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
