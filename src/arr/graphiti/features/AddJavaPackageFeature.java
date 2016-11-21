package arr.graphiti.features;

import org.eclipse.graphiti.examples.tutorial.StyleUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddShapeFeature;
import org.eclipse.graphiti.mm.algorithms.Ellipse;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.BoxRelativeAnchor;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;

import arr.general.ARRJavaPackage;

public class AddJavaPackageFeature extends AbstractAddShapeFeature {

	// the additional size of the invisible rectangle at the right border
	// (this also equals the half width of the anchor to paint there)
	public static final int INVISIBLE_RECT_RIGHT = 6;

	public AddJavaPackageFeature(IFeatureProvider fp) {
		super(fp);
	}

	public boolean canAdd(IAddContext context) {
		// check if user wants to add a ARRJavaPackage
		final Object newObject = context.getNewObject();
		if (newObject instanceof ARRJavaPackage) {
			// check if user wants to add to a diagram
			if (context.getTargetContainer() instanceof Diagram) {
				System.out.println("De fato estou adicionando uma coisa que é instanceof ARRJavaPackage");
				return true;
			}
		}
		return false;
	}

	public PictogramElement add(IAddContext context) {
		ARRJavaPackage addedPackage = (ARRJavaPackage) context.getNewObject();
        Diagram targetDiagram = (Diagram) context.getTargetContainer();
               
        // CONTAINER SHAPE WITH ROUNDED RECTANGLE
 		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
 		final ContainerShape containerShape = peCreateService.createContainerShape(targetDiagram, true);

 		// check whether the context has a size (e.g. from a create feature)
 		// otherwise define a default size for the shape
 		final int width = context.getWidth() <= 0 ? 100 : context.getWidth();
 		final int height = context.getHeight() <= 0 ? 50 : context.getHeight();

 		final IGaService gaService = Graphiti.getGaService();
 		RoundedRectangle roundedRectangle; // need to access it later
 		{
 			// create invisible outer rectangle expanded by
 			// the width needed for the anchor
 			final Rectangle invisibleRectangle = gaService.createInvisibleRectangle(containerShape);
 			gaService.setLocationAndSize(invisibleRectangle, context.getX(), context.getY(), width + INVISIBLE_RECT_RIGHT, height);

 			// create and set visible rectangle inside invisible rectangle
 			roundedRectangle = gaService.createPlainRoundedRectangle(invisibleRectangle, 5, 5);
 			roundedRectangle.setStyle(StyleUtil.getStyleForEClass(targetDiagram));
 			gaService.setLocationAndSize(roundedRectangle, 0, 0, width, height);

 			// if addedClass has no resource we add it to the resource of the diagram
 			// in a real scenario the business model would have its own resource
 			if (addedPackage.eResource() == null) {
 				getDiagram().eResource().getContents().add(addedPackage);
			}
 			
 			// create link and wire it
 			link(containerShape, addedPackage);
 		}
 		

		// SHAPE WITH TEXT
		{
			// create shape for text
			final Shape shape = peCreateService.createShape(containerShape, false);

			// create and set text graphics algorithm
			final Text text = gaService.createPlainText(shape, addedPackage.getName());
			text.setStyle(StyleUtil.getStyleForEClassText(targetDiagram));
			gaService.setLocationAndSize(text, 0, 0, width, 20);

			// create link and wire it
			link(shape, addedPackage);
		}

		// add a chopbox anchor to the shape
		peCreateService.createChopboxAnchor(containerShape);

		// create an additional box relative anchor at middle-right
		final BoxRelativeAnchor boxAnchor = peCreateService.createBoxRelativeAnchor(containerShape);
		boxAnchor.setRelativeWidth(1.0);
		boxAnchor.setRelativeHeight(0.38); // Use golden section

		// anchor references visible rectangle instead of invisible rectangle
		boxAnchor.setReferencedGraphicsAlgorithm(roundedRectangle);

		// assign a graphics algorithm for the box relative anchor
		final Ellipse ellipse = gaService.createPlainEllipse(boxAnchor);

		// anchor is located on the right border of the visible rectangle
		// and touches the border of the invisible rectangle
		final int w = INVISIBLE_RECT_RIGHT;
		gaService.setLocationAndSize(ellipse, -w, -w, 2 * w, 2 * w);
		ellipse.setStyle(StyleUtil.getStyleForEClass(targetDiagram));


 		// call the layout feature
 		layoutPictogramElement(containerShape);
 		return containerShape;

    }
}

