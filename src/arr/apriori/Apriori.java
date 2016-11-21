package arr.apriori;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.core.resources.IProject;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import arr.general.CodeDependencyMatrix;
import arr.ui.ARRDataView;
import arr.ui.MessageSystem;
import arr.ui.OptionsView;
import arr.util.FileUtilities;
import arr.util.ProjectUtilities;
import ca.pfv.spmf.algorithms.frequentpatterns.apriori.AlgoApriori;

public class Apriori {

	public static boolean run(ArrayList<IProject> projects)
	{
		
		if(ProjectUtilities.getaOuts() != null)
			ProjectUtilities.clearaOuts();
		try {
			ARRDataView view = (ARRDataView) 
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView( "architecture_rules_recovery.views.ARRDataView");
			view.refresh();
			
		} catch (PartInitException e) {
			// Wasn't able to get the plug-in main view, not a real problem. The data will be in there once the user open the view because it will call view.refresh().
			e.printStackTrace();
		}
		
		File spmfData = null;
		CodeDependencyMatrix matrix = ProjectUtilities.getDependenciesFromProjects(projects);
		ProjectUtilities.setDependencyMatrix(matrix);
		if(matrix != null)
		{
			try {
				spmfData = FileUtilities.createSPMFInput(matrix, "DependencyMatrix", projects.get(0).getLocation().toString());
			} catch (IOException e) {
				MessageSystem.fileProblem();
				e.printStackTrace();
			}
		}
		else
		{
			// Something didn't work properly, tells the user that the software didn't finish the calculation of the matrix
			MessageSystem.matrixError();
			return false;
		}				
		if(spmfData != null)
		{
			double minsup = OptionsView.minsup;
			// Applying the Apriori algorithm
			AlgoApriori apriori = new AlgoApriori();
			try {
				apriori.runAlgorithm(minsup, spmfData.toPath().toString(), projects.get(0).getLocation().toString() + File.separator + "out.spmf");
			} catch (IOException e) {
				MessageSystem.jdependProblem();
				e.printStackTrace();
				return false;
			}
		}
		File aprioriOutFile = new File(projects.get(0).getLocation().toString() + File.separator + "out.spmf");
		if(!aprioriOutFile.exists())
			return false;
		ArrayList<AprioriOutput> aprioriParsedOutputs = new ArrayList<AprioriOutput>();

		AprioriParser aParser = new AprioriParser(aprioriOutFile);
		try {
			aprioriParsedOutputs = aParser.parse();
		} catch (FileNotFoundException e) {
			MessageSystem.unknownError();
			e.printStackTrace();
			return false;
		}
		ProjectUtilities.setaOuts(aprioriParsedOutputs);
		
		try {
			ARRDataView view = (ARRDataView) 
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView( "architecture_rules_recovery.views.ARRDataView");
			for(AprioriOutput a : aprioriParsedOutputs)
				view.getViewer().add(a);
			
		} catch (PartInitException e) {
			// Wasn't able to get the plug-in main view, not a real problem. The data will be in there once the user open the view because it will call view.refresh().
			
			e.printStackTrace();
		}
		
		return true;
		
	}
	
}
