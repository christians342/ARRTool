package arr.graphiti.diagram;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.IResizeShapeFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;

import arr.general.ARRJavaPackage;
import arr.general.ArchitecturalDependency;
import arr.graphiti.features.AddJavaPackageFeature;
import arr.graphiti.features.AddReferenceFeature;
import arr.graphiti.features.CreateDependencyFeature;
import arr.graphiti.features.CreateJavaPackageFeature;
import arr.graphiti.features.LayoutFeature;
import arr.graphiti.features.ResizeJavaPackageFeature;
public class FeatureProvider extends DefaultFeatureProvider {

    public FeatureProvider(IDiagramTypeProvider dtp) {
        super(dtp);
    }
    
	@Override
	public ICreateFeature[] getCreateFeatures() {
		return new ICreateFeature[] { new CreateJavaPackageFeature(this) };
	}
	
	public  IAddFeature getAddFeature(IAddContext context) {
	    // is object for add request a ARRJavaPackage?
	    if (context.getNewObject() instanceof ARRJavaPackage) {
	        return new AddJavaPackageFeature(this);
	    } else if (context.getNewObject() instanceof ArchitecturalDependency) {
	        return new AddReferenceFeature(this);
	    }
	    
	    return super.getAddFeature(context);
	}

	/*
	@Override
	public IUpdateFeature getUpdateFeature(IUpdateContext context) {
	   PictogramElement pictogramElement = context.getPictogramElement();
	   if (pictogramElement  instanceof ContainerShape) {
	       Object bo = getBusinessObjectForPictogramElement(pictogramElement);
	       if (bo instanceof ARRJavaPackage) {
	           return new UpdateJavaPackageFeature(this);
	       }
	   }
	   return super.getUpdateFeature(context);
	 }
	
	*/
	
	@Override
	public IResizeShapeFeature getResizeShapeFeature(
	        IResizeShapeContext context) {
	    Shape shape = context.getShape();
	    Object bo = getBusinessObjectForPictogramElement(shape);

	    if (bo instanceof ARRJavaPackage) {
	    	return new ResizeJavaPackageFeature(this);
	    }	
	    return super.getResizeShapeFeature(context);
	}
	
	@Override
	public ILayoutFeature getLayoutFeature(ILayoutContext context) {
		PictogramElement pictogramElement = context.getPictogramElement();
		Object bo = getBusinessObjectForPictogramElement(pictogramElement);
		if (bo instanceof ARRJavaPackage) {
			return new LayoutFeature(this);
		}
		return super.getLayoutFeature(context);
	}
	
	 @Override
	 public ICreateConnectionFeature[] getCreateConnectionFeatures() {
	    return new ICreateConnectionFeature[] { 
	        new CreateDependencyFeature (this) };
	 }

}
