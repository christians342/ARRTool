package arr.graphiti.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;

import arr.general.impl.ARRJavaPackageImpl;
import arr.general.ARRJavaPackage;

public class CreateJavaPackageFeature extends AbstractCreateFeature {
	public CreateJavaPackageFeature(IFeatureProvider fp) {
		// set name and description of the creation feature
		super(fp, "Java Package", "Create Java Package");
	}

	public boolean canCreate(ICreateContext context) {
		return context.getTargetContainer() instanceof Diagram;
	}

	public Object[] create(ICreateContext context) {
		// create JavaPackage
		ARRJavaPackage newPackage = new ARRJavaPackageImpl("Test package");
		
		// Add model element to resource.
		getDiagram().eResource().getContents().add(newPackage);
		
		/*
		if (newPackage.eResource() == null) {
				try {
				FileUtilities.saveToModelFile(newPackage, getDiagram());
			} catch (CoreException e) {
				System.out.println("deu estranho");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("deu estranho 2");
				e.printStackTrace();
			}
		}
		 */
		//		Use the following instead of the above line to store the model
		//		data in a seperate file parallel to the diagram file
		//		try {
		//			try {
		//				TutorialUtil.saveToModelFile(newClass, getDiagram());
		//			} catch (IOException e) {
		//				e.printStackTrace();
		//			}
		//		} catch (CoreException e) {
		//			e.printStackTrace();
		//		}

		// do the add
		addGraphicalRepresentation(context, newPackage);

		// activate direct editing after object creation
		getFeatureProvider().getDirectEditingInfo().setActive(true);
		// return newly created business object(s)
		return new Object[] { newPackage };
	}
}
