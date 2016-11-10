package arr.graphiti.features;

import org.eclipse.graphiti.examples.tutorial.StyleUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;

import arr.general.ArchitecturalDependency;

public class AddReferenceFeature extends AbstractAddFeature {

	public AddReferenceFeature(IFeatureProvider fp) {
		super(fp);
	}

	public PictogramElement add(IAddContext context) {
		IAddConnectionContext addConContext = (IAddConnectionContext) context;
		ArchitecturalDependency addedDependency = (ArchitecturalDependency) context.getNewObject();
		IPeCreateService peCreateService = Graphiti.getPeCreateService();

		// CONNECTION WITH POLYLINE
		Connection connection = peCreateService.createFreeFormConnection(getDiagram());
		connection.setStart(addConContext.getSourceAnchor());
		connection.setEnd(addConContext.getTargetAnchor());

		IGaService gaService = Graphiti.getGaService();
		Polyline polyline = gaService.createPlainPolyline(connection);
		polyline.setStyle(StyleUtil.getStyleForEClass(getDiagram()));

		// create link and wire it
		link(connection, addedDependency);

		// add dynamic text decorator for the reference name
		ConnectionDecorator textDecorator = peCreateService.createConnectionDecorator(connection, true, 0.3, true);
		Text text = gaService.createPlainText(textDecorator);
		text.setStyle(StyleUtil.getStyleForTextDecorator((getDiagram())));
		gaService.setLocation(text, 10, 0);

		// set reference name in the text decorator
		ArchitecturalDependency dep = (ArchitecturalDependency) context.getNewObject();
		text.setValue(String.valueOf(dep.getSupport()));

		// if addedClass has no resource we add it to the resource of the diagram
			// in a real scenario the business model would have its own resource
			if (addedDependency.eResource() == null) {
				getDiagram().eResource().getContents().add(addedDependency);
			}
		
		// add static graphical decorators (composition and navigable)
		ConnectionDecorator cd;
		cd = peCreateService.createConnectionDecorator(connection, false, 1.0, true);
		createArrow(cd);
		return connection;
	}

	public boolean canAdd(IAddContext context) {
		// return true if given business object is an EReference
		// note, that the context must be an instance of IAddConnectionContext
		if (context instanceof IAddConnectionContext && context.getNewObject() instanceof ArchitecturalDependency) {
			return true;
		}
		return false;
	}

	private Polyline createArrow(GraphicsAlgorithmContainer gaContainer) {
		Polyline polyline = Graphiti.getGaCreateService().createPlainPolyline(gaContainer,
				new int[] { -15, 10, 0, 0, -15, -10 });
		polyline.setStyle(StyleUtil.getStyleForEClass(getDiagram()));
		return polyline;
	}
}