package arr.ui;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

public class MessageSystem {
	private static String title = "ARR Tool";
	private static IWorkbenchWindow activeWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
	
	// Something didn't work properly, tells the user that the software didn't finish the calculation of the matrix
	public static void matrixError()
	{
			MessageDialog.openError(
					activeWindow.getShell(),
					title,
					"Plugin wasn't able to finish calculating the dependency matrix.");
	}
	
	// Shows a message that tells that the code already finished
	public static void sucessfullyFinished()
	{
		MessageDialog.openInformation(
				activeWindow.getShell(),
				title,
				"Plugin has finished it's work.");
	}
	
	public static void runPluginFirst()
	{
		MessageDialog.openInformation(
				activeWindow.getShell(),
				title,
				"Before exporting rules you need to run ARRTool.");
	}
	
	public static void runProjectFirst()
	{
		MessageDialog.openInformation(
				activeWindow.getShell(),
				title,
				"You need to first have an active project in Eclipse, make sure to run it or select it in the Package Explorer view.");
	}
	
	public static void fileProblem()
	{
		MessageDialog.openError(
				activeWindow.getShell(),
				title,
				"Plugin was not able to create files in project folder, please make sure Eclipse have write permission to the Project folder.");
	}
	
	public static void jdependProblem()
	{
		MessageDialog.openError(
				activeWindow.getShell(),
				title,
				"One of the extensions could not finish its processing (JDEPEND).");
	}
	
	public static void unknownError()
	{
		MessageDialog.openError(
				activeWindow.getShell(),
				title,
				"Created files were deleted or moved during processing.");
	}

	public static void selectProjectFirst() {
		MessageDialog.openWarning(
				activeWindow.getShell(),
				title,
				"Select the desired project in the Package Explorer.");
	}

	public static void invalidFormat() {
		MessageDialog.openError(
				activeWindow.getShell(),
				title,
				"Please enter a valid float for minsup value (Ex: 0.04 which means a minsup of 2 transactions).");
		
	}

	

}
