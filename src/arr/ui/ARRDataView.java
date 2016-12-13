package arr.ui;


import java.io.File;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.examples.tutorial.Messages;
import org.eclipse.graphiti.ui.editor.DiagramEditor;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ViewPart;

import arr.algorithms.Algorithm;
import arr.algorithms.AlgorithmOutput;
import arr.util.FileUtilities;
import arr.util.ProjectUtilities;


public class ARRDataView extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "architecture_rules_recovery.views.ARRDataView";

	private TableViewer viewer;
	
	private Action actionRunProject;
	private Action actionRunWorkspace;
	private Action actionExportDependencies;
	private Action actionExportSPMF;
	private Action actionOpenProperties;
	private Action actionCreateDiagram;
	private Action actionOpenDiagramProperties;

	static DecimalFormat df = new DecimalFormat("#.###");
	
	/**
	 * The constructor.
	 */
	public ARRDataView() {
	}

	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	public void createPartControl(Composite parent) {
		// Instantiates the tableViewer with the properties:
		// SCROLL H AND V, FULL SELECTION (can only select a whole row, with all columns)
		viewer = new TableViewer(parent, SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION );
		createColumns(parent);
		final Table table = viewer.getTable();
		// Creates the form table
	    final FormData fd_table = new FormData();
		fd_table.bottom = new FormAttachment(100, -1);
		fd_table.top = new FormAttachment(0, -5);
		fd_table.right = new FormAttachment(100, -1);
		fd_table.left = new FormAttachment(0, 1);
		table.setLayoutData(fd_table);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
	    table.setLayoutData(new GridData(GridData.FILL_BOTH));

		// Sets the viewContentProvider that will take care of contents of the table
	    viewer.setContentProvider(new ArrayContentProvider());
	    viewer.setInput(ProjectUtilities.getaOuts());


		
		PlatformUI.getWorkbench().getHelpSystem().setHelp(viewer.getControl(), "Architecture_Rules_Recovery.viewer");
		makeActions();
		hookContextMenu();
		contributeToActionBars();	
	}
	
	private void createColumns(Composite parent)
	{
		df.setRoundingMode(RoundingMode.CEILING);
		
		TableViewerColumn targetPackageColumn = new TableViewerColumn (viewer, SWT.NONE);
		targetPackageColumn.getColumn().setWidth(300);
		targetPackageColumn.getColumn().setText("Base Packages");
		targetPackageColumn.setLabelProvider(new ColumnLabelProvider() {
			  @Override
			  public String getText(Object element) {
			    AlgorithmOutput p = (AlgorithmOutput) element;
			    String output = "";
			    for(int i = 0; i < p.getBasePackages().size(); i++)
			    {
			    	output = output + p.getBasePackages().get(i).getName();
			    	if(i != (p.getBasePackages().size() - 1))
			    		output+= ", ";
			    }
			    return output;
			  }
			});
		TableViewerColumn usedPackagesColumn = new TableViewerColumn (viewer, SWT.NONE);
		usedPackagesColumn.getColumn().setWidth(300);
		usedPackagesColumn.getColumn().setText("Used Packages");
		usedPackagesColumn.setLabelProvider(new ColumnLabelProvider() {
			  @Override
			  public String getText(Object element) {
			    AlgorithmOutput e = (AlgorithmOutput) element;
			    String output = "";
			    for(int i = 0; i < e.getUsedPackages().size(); i++)
			    {
			    	output = output + e.getUsedPackages().get(i).getName();
			    	if(i != (e.getUsedPackages().size() - 1))
			    		output+= ", ";
			    }
			    return output;
			  }
			});
		
		TableViewerColumn suportColumn = new TableViewerColumn (viewer, SWT.NONE);
		suportColumn.getColumn().setWidth(100);
		suportColumn.getColumn().setText("Support");
		suportColumn.setLabelProvider(new ColumnLabelProvider() {
			  @Override
			  public String getText(Object element) {
			    AlgorithmOutput e = (AlgorithmOutput) element;
			    return df.format(e.getSuport());
			  }
			});
	}
	
	public void refresh() 
	{
		viewer.refresh();
	}
	
	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				ARRDataView.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(actionRunProject);
		//manager.add(new Separator());
		manager.add(actionRunWorkspace);
		manager.add(new Separator());
		manager.add(actionExportDependencies);
		manager.add(actionExportSPMF);
		manager.add(actionCreateDiagram);
		manager.add(new Separator());
		manager.add(actionOpenProperties);
		manager.add(actionOpenDiagramProperties);
	}

	private void fillContextMenu(IMenuManager manager) {
		manager.add(actionRunProject);
		manager.add(actionRunWorkspace);
		manager.add(new Separator());
		manager.add(actionExportDependencies);
		manager.add(actionExportSPMF);
		manager.add(actionCreateDiagram);
		manager.add(new Separator());
		manager.add(actionOpenProperties);
		manager.add(actionOpenDiagramProperties);
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}
	
	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(actionRunProject);
		manager.add(actionRunWorkspace);
		manager.add(new Separator());
		manager.add(actionExportDependencies);
		manager.add(actionExportSPMF);
		manager.add(actionCreateDiagram);
		manager.add(new Separator());
		manager.add(actionOpenProperties);
		manager.add(actionOpenDiagramProperties);
	}

	@SuppressWarnings("deprecation")
	private void makeActions() {
		actionRunProject = new Action() {
			public void run() {
				
				ArrayList<IProject> projects = new ArrayList<IProject>();
				projects.add(ProjectUtilities.getCurrentProject());
				
				if(projects.size() == 0)
				{
					MessageSystem.runProjectFirst();
					return;
				}
				projects.add(0, null);
				if(Algorithm.run(projects))
					MessageSystem.sucessfullyFinished();
				
				return;
			}
		};
		actionRunProject.setText("Project Architecture Recovery");
		actionRunProject.setToolTipText("Run ARR plugin on the selected project in the Eclipse Package Explorer view. (This doesn't fetch the other possible projects in the workspace)");
		actionRunProject.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
			getImageDescriptor(ISharedImages.IMG_OBJ_PROJECT_CLOSED));
		
		actionRunWorkspace = new Action() {
			public void run() {
				ArrayList<IProject> projects = new ArrayList<IProject>();
		        projects.addAll(Arrays.asList(ProjectUtilities.getProjectsFromWorkspace()));
		        
		        // Shows a message that tells that the code already finished
		        if(Algorithm.run(projects))
				MessageSystem.sucessfullyFinished();
				
		        return;
			}
		};
		actionRunWorkspace.setText("Workspace Architecture Recovery");
		actionRunWorkspace.setToolTipText("Runs Architecture Rules Recovery plugin using as input all projects in the current workspace.");
		actionRunWorkspace.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
				getImageDescriptor(ISharedImages.IMG_OBJ_PROJECT));
		
		actionExportDependencies = new Action() {
			public void run()
			{
				// If ARR was not run yet
				if(!ProjectUtilities.getDependencyMatrixStatus())
				{
					MessageSystem.runPluginFirst();
					return;
				}
			    FileDialog dialog = new FileDialog(Display.getCurrent().getActiveShell(), SWT.SAVE);
			    dialog.setOverwrite(true);
			    dialog.setFilterExtensions(new String[] { "*.csv" });
			    String csvFile = dialog.open();
			    if (csvFile != null) {
			    	File selectedFile = new File(csvFile);
				    try {
						FileUtilities.createCSVFileForDependencies(ProjectUtilities.getDependencyMatrix(), selectedFile);
					} catch (IOException e) {
						MessageSystem.fileProblem();
						e.printStackTrace();
					}
			    }
			    
			}
		};
		actionExportDependencies.setText("Export Dependencies");
		actionExportDependencies.setToolTipText("Export all dependencies that were used as input to the machine learning algorithm to a CSV file.");
		actionExportDependencies.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
				getImageDescriptor(ISharedImages.IMG_ETOOL_SAVE_EDIT));
		
		actionExportSPMF = new Action() {
			public void run()
			{
				// If ARR was not run yet
				if(!ProjectUtilities.getDependencyMatrixStatus())
				{
					MessageSystem.runProjectFirst();
					return;
				}
			    FileDialog dialog = new FileDialog(Display.getCurrent().getActiveShell(), SWT.SAVE);
			    dialog.setOverwrite(true);
			    dialog.setFilterExtensions(new String[] { "*.csv" });
			    String csvFile = dialog.open();
			    if (csvFile != null) {
			    	File selectedFile = new File(csvFile);
				    try {
						FileUtilities.createCSVFileForAlgorithms(ProjectUtilities.getaOuts(), selectedFile);
					} catch (IOException e) {
						MessageSystem.fileProblem();
						e.printStackTrace();
					}
			    }
			    
			}
		};
		actionExportSPMF.setText("Export Calculated Values");
		actionExportSPMF.setToolTipText("Export all found itemsets by the algorithm to a CSV file.");
		actionExportSPMF.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
				getImageDescriptor(ISharedImages.IMG_ETOOL_SAVEALL_EDIT));
		
		actionCreateDiagram = new Action() {
			public void run()
			{		
				// If ARR was not run yet
				if(!ProjectUtilities.getDependencyMatrixStatus())
				{
					MessageSystem.runProjectFirst();
					return;
				}
				
				// Ask for the name of the new diagram
				InputDialog dialog = new InputDialog(Display.getCurrent().getActiveShell(), "ARR Diagram", "Enter a name to the diagram that will be generated:", null, null);
				if (dialog.open() != Dialog.OK) {
					return;
				}
				String diagramName = DiagramOptionsView.diagramName;

				// Get the default resource set to hold the new resource
				ResourceSet resourceSet = new ResourceSetImpl();
				TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(resourceSet);
				if (editingDomain == null) {
					// Not yet existing, create one
					editingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(resourceSet);
				}

				// Create the data within a command and save (must not happen inside
				// the command since finishing the command will trigger setting the 
				// modification flag on the resource which will be used by the save
				// operation to determine which resources need to be saved)
				CreateDiagramCommand operation = new CreateDiagramCommand(editingDomain, diagramName);
				editingDomain.getCommandStack().execute(operation);
				
				try {
					operation.getCreatedResource().save(null);
				} catch (IOException e) {
					IStatus status = new Status(IStatus.ERROR, "org.eclipse.graphiti", e.getMessage(), e); //$NON-NLS-1$
					ErrorDialog.openError(Display.getCurrent().getActiveShell(), Messages.CreateDiagramWithAllClassesHandler_ErrorTitle, e.getMessage(), status);
					return;
				}

				// Dispose the editing domain to eliminate memory leak
				editingDomain.dispose();

				// Open the editor
				String platformString = operation.getCreatedResource().getURI().toPlatformString(true);
				IFile file = ProjectUtilities.getCurrentProject().getParent().getFile(new Path(platformString));
				IFileEditorInput input = new FileEditorInput(file);
				try {
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(input, DiagramEditor.DIAGRAM_EDITOR_ID);
				} catch (PartInitException e) {
					return;
				}

				return;
				
			}
		};
		actionCreateDiagram.setText("Create Diagram with the selected values from the table");
		actionCreateDiagram.setToolTipText("Create diagram with all values selected, if no value is selected it will use the full table as input.");
		actionCreateDiagram.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
				getImageDescriptor(ISharedImages.IMG_DEF_VIEW));
		
		actionOpenProperties = new Action() {
			public void run()
			{
				AlgorithmOptionsView oView = new AlgorithmOptionsView(Display.getCurrent());
				oView.open();
			}
		};
		actionOpenProperties.setText("Open Algorithm Options");
		actionOpenProperties.setToolTipText("Open algorithm selection options and it's parameters.");
		actionOpenProperties.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
				getImageDescriptor(ISharedImages.IMG_OBJS_TASK_TSK));
		
		actionOpenDiagramProperties = new Action() {
			public void run()
			{
				DiagramOptionsView dView = new DiagramOptionsView(Display.getCurrent());
				dView.open();
			}
		};
		
		actionOpenDiagramProperties.setText("Open Diagram Options");
		actionOpenDiagramProperties.setToolTipText("Open Diagram Generation options and it's parameters.");
		actionOpenDiagramProperties.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
				getImageDescriptor(ISharedImages.IMG_OBJS_TASK_TSK));
		
		
		
	}
	
	public TableViewer getViewer()
	{
		return viewer;
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}
}