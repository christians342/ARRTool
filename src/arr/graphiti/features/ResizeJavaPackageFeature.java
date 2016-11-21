package arr.graphiti.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.impl.DefaultResizeShapeFeature;
import org.eclipse.graphiti.mm.pictograms.Shape;

import arr.general.ARRJavaPackage;

public class ResizeJavaPackageFeature extends DefaultResizeShapeFeature {

	public ResizeJavaPackageFeature(IFeatureProvider fp) {
        super(fp);
    }
 
    @Override
    public boolean canResizeShape(IResizeShapeContext context) {
        boolean canResize = super.canResizeShape(context);
 
        // perform further check only if move allowed by default feature
        if (canResize) {
            // don't allow resize if the package name has the length of less than or equal to 1
            Shape shape = context.getShape();
            Object bo = getBusinessObjectForPictogramElement(shape);
            if (bo instanceof ARRJavaPackage) {
            	ARRJavaPackage p = (ARRJavaPackage) bo;
                if (p.getName() != null && p.getName().length() <= 1) {
                    canResize = false;
                }
            }
        }
        return canResize;
    }
	
}
