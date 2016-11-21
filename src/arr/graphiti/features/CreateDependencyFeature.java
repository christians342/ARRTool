package arr.graphiti.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import arr.general.ArchitecturalDependency;
import arr.general.impl.ArchitecturalDependencyImpl;
import arr.general.ARRJavaPackage;

public class CreateDependencyFeature extends AbstractCreateConnectionFeature  {
	public CreateDependencyFeature(IFeatureProvider fp) {
		// provide name and description for the UI, e.g. the palette
		super(fp, "Dependency", "Create Dependency"); //$NON-NLS-1$ //$NON-NLS-2$
	}

	public boolean canCreate(ICreateConnectionContext context) {
		PictogramElement sourcePictogramElement = context.getSourcePictogramElement();
		PictogramElement targetPictogramElement = context.getTargetPictogramElement();

		if (sourcePictogramElement == null || targetPictogramElement == null) {
			return false;
		}

		Object source = getBusinessObjectForPictogramElement(sourcePictogramElement);
		Object target = getBusinessObjectForPictogramElement(targetPictogramElement);
		
		if (source != null && target != null && source != target) {
			return true;
		}
		return false;
	}

	public boolean canStartConnection(ICreateConnectionContext context) {
		Object src = (getBusinessObjectForPictogramElement(context.getSourcePictogramElement()));
		// return true if start anchor belongs to a JavaPackage
		if (src != null && src instanceof ARRJavaPackage) {
			return true;
		}
		return false;
	}

	public Connection create(ICreateConnectionContext context) {
		Connection newConnection = null;

		// get Packages which should be connected
		Object source = getBusinessObjectForPictogramElement(context.getSourcePictogramElement());
		Object target = getBusinessObjectForPictogramElement(context.getTargetPictogramElement());

		if (source != null && target != null &&
				source instanceof ARRJavaPackage && 
				target instanceof ARRJavaPackage){
			// create new business object
			ArchitecturalDependency dep = new ArchitecturalDependencyImpl((ARRJavaPackage)source, (ARRJavaPackage)target, 0.5f,0);

			// add connection for business object
			AddConnectionContext addContext = new AddConnectionContext(context.getSourceAnchor(), context.getTargetAnchor());
			addContext.setNewObject(dep);
			newConnection = (Connection) getFeatureProvider().addIfPossible(addContext);
		}

		return newConnection;
	}

}
