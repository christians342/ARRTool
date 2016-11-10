package arr.graphiti.diagram;

import org.eclipse.emf.common.util.EList;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;

import arr.general.ARRJavaPackageInterface;

public class ToolBehaviorProvider extends DefaultToolBehaviorProvider {
    
	public ToolBehaviorProvider(IDiagramTypeProvider dtp) {
        super(dtp);
    }
	
	@Override
	public GraphicsAlgorithm[] getClickArea(PictogramElement pe) {
	    IFeatureProvider featureProvider = getFeatureProvider();
	    Object bo = featureProvider.getBusinessObjectForPictogramElement(pe);
	    if (bo instanceof ARRJavaPackageInterface) {
	        GraphicsAlgorithm invisible = pe.getGraphicsAlgorithm();
	        GraphicsAlgorithm rectangle =
	            invisible.getGraphicsAlgorithmChildren().get(0);
	        return new GraphicsAlgorithm[] { rectangle };
	    }
	    return super.getClickArea(pe);
	}

	@Override
	public GraphicsAlgorithm getSelectionBorder(PictogramElement pe) {
	    if (pe instanceof ContainerShape) {
	        GraphicsAlgorithm invisible = pe.getGraphicsAlgorithm();
	        if (!invisible.getLineVisible()) {
	            EList<GraphicsAlgorithm> graphicsAlgorithmChildren =
	                invisible.getGraphicsAlgorithmChildren();
	            if (!graphicsAlgorithmChildren.isEmpty()) {
	                return graphicsAlgorithmChildren.get(0);
	            }
	         }
	    }
	    return super.getSelectionBorder(pe);
	}
}
