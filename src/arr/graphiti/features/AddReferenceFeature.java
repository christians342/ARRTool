package arr.graphiti.features;

import java.awt.Color;
import java.math.RoundingMode;
import java.text.DecimalFormat;

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
	
	static DecimalFormat df = new DecimalFormat("#.###");
	
	public AddReferenceFeature(IFeatureProvider fp) {
		super(fp);
		df.setRoundingMode(RoundingMode.CEILING);
	}

	public PictogramElement add(IAddContext context) {
		IAddConnectionContext addConContext = (IAddConnectionContext) context;
		ArchitecturalDependency addedDependency = (ArchitecturalDependency) context.getNewObject();
		IPeCreateService peCreateService = Graphiti.getPeCreateService();

		// CONNECTION WITH POLYLINE
		Connection connection = peCreateService.createFreeFormConnection(getDiagram());
		connection.setStart(addConContext.getSourceAnchor());
		connection.setEnd(addConContext.getTargetAnchor());
		
		ArchitecturalDependency dep = (ArchitecturalDependency) context.getNewObject();
		
		IGaService gaService = Graphiti.getGaService();
		Polyline polyline = gaService.createPlainPolyline(connection);
		polyline.setStyle(StyleUtil.getStyleForEClass(getDiagram()));
		int lineWidht = (int) Math.ceil(dep.getSupport() * 10);
		polyline.setLineWidth(lineWidht);
		
		Color c = arr.util.ColorGenerator.getColor(addedDependency.getId());
		
		polyline.setForeground(gaService.manageColor(getDiagram(), c.getRed(), c.getGreen(), c.getBlue()));

		// create link and wire it
		link(connection, addedDependency);

		// add dynamic text decorator for the reference name
		ConnectionDecorator textDecorator = peCreateService.createConnectionDecorator(connection, true, 0.3, true);
		Text text = gaService.createPlainText(textDecorator);
		text.setStyle(StyleUtil.getStyleForTextDecorator((getDiagram())));
		gaService.setLocation(text, 10, 0);

		// set reference name in the text decorator
		
		text.setValue(df.format(dep.getSupport()));

		// if addedClass has no resource we add it to the resource of the diagram
			if (addedDependency.eResource() == null) {
				getDiagram().eResource().getContents().add(addedDependency);
			}
		
		// add static graphical decorators (composition and navigable)
		ConnectionDecorator cd;
		cd = peCreateService.createConnectionDecorator(connection, false, 1.0, true);
		createArrow(cd, lineWidht, c);
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

	private Polyline createArrow(GraphicsAlgorithmContainer gaContainer, int widht, Color c) {
		Polyline polyline = Graphiti.getGaCreateService().createPlainPolyline(gaContainer,
				new int[] { -15, 10, 0, 0, -15, -10 });
		polyline.setStyle(StyleUtil.getStyleForEClass(getDiagram()));
		polyline.setLineWidth(widht);
		polyline.setForeground(((IGaService) Graphiti.getGaCreateService()).manageColor(getDiagram(), c.getRed(), c.getGreen(), c.getBlue()));
		return polyline;
	}
}