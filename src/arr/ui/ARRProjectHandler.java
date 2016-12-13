package arr.ui;


import java.util.ArrayList;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import arr.algorithms.Algorithm;
import arr.util.ProjectUtilities;

public class ARRProjectHandler extends AbstractHandler {

	public ARRProjectHandler() {
	}

	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		
        // Get the Selection from the active WorkbenchPage page, extract the resource of the UI selection and get the project from it
        ISelection selection = (IStructuredSelection) window.getSelectionService().getSelection("org.eclipse.jdt.ui.PackageExplorer");
        IResource resource = ProjectUtilities.extractSelection(selection);
        
        if(resource == null)
        {
        	MessageSystem.selectProjectFirst();
        	return false;
        }
        
		ArrayList<IProject> projects = new ArrayList<IProject>();
		projects.add(resource.getProject());
		
		if(projects.size() == 0)
		{
			MessageSystem.selectProjectFirst();
			return false;
		}
		projects.add(0, null);
		if(Algorithm.run(projects))
		{
			MessageSystem.sucessfullyFinished();
			return true;
		}
		
		return false;
	}
	

}
