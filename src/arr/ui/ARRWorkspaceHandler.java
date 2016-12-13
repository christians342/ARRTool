package arr.ui;

import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;

import arr.algorithms.Algorithm;
import arr.util.ProjectUtilities;


public class ARRWorkspaceHandler extends AbstractHandler{

	public ARRWorkspaceHandler() {
	}

	public Object execute(ExecutionEvent event) throws ExecutionException {

		ArrayList<IProject> projects = new ArrayList<IProject>();
        projects.addAll(Arrays.asList(ProjectUtilities.getProjectsFromWorkspace()));
        
        // Shows a message that tells that the code already finished
        if(Algorithm.run(projects))
        {
        	MessageSystem.sucessfullyFinished();
        	return true;
        }
        
		return false;
	}
}
