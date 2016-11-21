package arr.ui;

import java.util.ArrayList;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.services.GraphitiUi;

import arr.apriori.AprioriOutput;
import arr.general.ARRJavaPackage;
import arr.general.ArchitecturalDependency;
import arr.general.impl.ArchitecturalDependencyImpl;
import arr.util.ColorGenerator;
import arr.util.ProjectUtilities;

public class CreateDiagramCommand extends RecordingCommand {

	private TransactionalEditingDomain editingDomain;
	private String diagramName;
	private Resource createdResource;
	public static ArrayList<ARRJavaPackage> allPackages;
	
	public CreateDiagramCommand(TransactionalEditingDomain editingDomain, String diagramName) {
		super(editingDomain);
		this.editingDomain = editingDomain;
		this.diagramName = diagramName;
	}

	@Override
	protected void doExecute() {

		ArrayList<AprioriOutput> aOuts = ProjectUtilities.getaOuts();
		ArrayList<ArchitecturalDependency> archDeps = new ArrayList<ArchitecturalDependency>();
		
		// Get all JavaPackages that will be used
		allPackages = new ArrayList<ARRJavaPackage>();
		
		for(AprioriOutput aOut : aOuts)
		{
			for(ARRJavaPackage a : aOut.getUsedPackages())
			{
				if(!allPackages.contains(a))
				{
					allPackages.add(a);
				}
			}
			for(int i = 0; i < aOut.getBasePackages().size(); i++)
			{
				if(!allPackages.contains(aOut.getBasePackages().get(i)))
				{
					allPackages.add(aOut.getBasePackages().get(i));
				}
			}
		}

		int ID = 0;
		//Para todas as saídas do apriori
		for(AprioriOutput aOut : aOuts)
		{
			//para todos os jpackages dessa regra gerada, se ela existe dentro do meu conjunto de archdeps
			for(ARRJavaPackage innerPackage : aOut.getUsedPackages())
			{
				// cria regra nas archdeps
				for(int i = 0; i < aOut.getBasePackages().size(); i++)
				{
					ArchitecturalDependency ad = new ArchitecturalDependencyImpl(aOut.getBasePackages().get(i), innerPackage,aOut.getSuport(), ID);
					archDeps.add(ad);
				}
				ID++;
			}
			
		}
		

		ColorGenerator.generateRandomColors(ID);
		
		//Agora que tenho todas as dependências preciso só criar eles no diagrama.
		

		// Create the diagram and its file
		Diagram diagram = Graphiti.getPeCreateService().createDiagram("arrdiagram", diagramName, true); //$NON-NLS-1$		
		IFolder diagramFolder = ProjectUtilities.getCurrentProject().getFolder("/diagrams/"); //$NON-NLS-1$
		IFile diagramFile = diagramFolder.getFile(diagramName + ".diagram"); //$NON-NLS-1$
		URI uri = URI.createPlatformResourceURI(diagramFile.getFullPath().toString(), true);
		createdResource = editingDomain.getResourceSet().createResource(uri);
		createdResource.getContents().add(diagram);

		IDiagramTypeProvider dtp = GraphitiUi.getExtensionManager().createDiagramTypeProvider(diagram,
				"arr.graphiti.diagram.DiagramTypeProvider"); //$NON-NLS-1$
		IFeatureProvider featureProvider = dtp.getFeatureProvider();
		
		ArrayList<PictogramElement> peList = new ArrayList<PictogramElement>();
		
		// Add all packages to diagram
		int x = 25;
		int y = 25;
		for (int i = 0; i < allPackages.size(); i++) {
			// Create the context information
			AddContext addContext = new AddContext();
			addContext.setNewObject(allPackages.get(i));
			addContext.setTargetContainer(diagram);
			addContext.setX(x);
			addContext.setY(y);
			x = x + 100;
			y = y + 100;
			IAddFeature addFeature = featureProvider.getAddFeature(addContext);
			if (addFeature.canAdd(addContext)) {
				peList.add(addFeature.add(addContext));
			}
			
		}
		
		//add all references between them
		for(ArchitecturalDependency archDep : archDeps)
		{
			
			for(PictogramElement p1 : peList)
			{
				ARRJavaPackage srcPackage = (ARRJavaPackage) p1.getLink().getBusinessObjects().get(0);
				//System.out.println("SOURCE: " + srcPackage.getName() + " com " + archDep.getSource().getName());
				if(srcPackage.equals(archDep.getSource()))
				{
					for(PictogramElement p2 : peList)
					{
						ARRJavaPackage tgtPackage = (ARRJavaPackage) p2.getLink().getBusinessObjects().get(0);
						//System.out.println("TARGET: " + tgtPackage.getName() + " com " + archDep.getTarget().getName());
						if(tgtPackage.equals(archDep.getTarget()))
						{
							//System.out.print(archDep.getSource().getName() + " " + archDep.getTarget().getName() + " " + String.valueOf(archDep.getSupport()) + "\n");
							Shape shape1 = (Shape) p1;
							Shape shape2 = (Shape) p2;
							// Create the context information
							AddConnectionContext addConContext = new AddConnectionContext(shape1.getAnchors().get(0), shape2.getAnchors().get(0));
							addConContext.setNewObject(archDep);
							
							addConContext.setTargetContainer(diagram);

							IAddFeature addFeature = featureProvider.getAddFeature(addConContext);
							if (addFeature.canAdd(addConContext)) {
								addFeature.add(addConContext);
							}
						}
					}
				}
			}		
		}

	}

	/**
	 * @return the createdResource
	 */
	public Resource getCreatedResource() {
		return createdResource;
	}
}
