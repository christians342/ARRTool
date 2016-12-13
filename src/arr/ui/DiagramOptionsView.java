package arr.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

public class DiagramOptionsView extends Shell {
	private Text textName;
	
	private Text textMinS;
	private Text textMaxS;
	private Text textMinT;
	private Text textMaxT;
	
	
	// 0 means no filter will be applied
	public static int profMinS = 0;
	public static int profMaxS = 0;
	public static int profMinT = 0;
	public static int profMaxT = 0;
	
	public static String diagramName = "ARR Diagram";
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			DiagramOptionsView shell = new DiagramOptionsView(display);
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the shell.
	 * @param display
	 */
	public DiagramOptionsView(Display display) {
		super(display, SWT.SHELL_TRIM);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Diagram  Options");
		setSize(335, 340);
		setLayout(null);
		
		Label label = new Label(this, SWT.NONE);
		label.setText("Name of the diagram that will be created:");
		label.setBounds(10, 10, 296, 20);
		
		textName = new Text(this, SWT.BORDER | SWT.CENTER);
		textName.setText("ArR Diagram");
		textName.setBounds(10, 30, 299, 20);
		
		Label label_2 = new Label(this, SWT.NONE);
		label_2.setText("Select the Base Packages Min Depth:");
		label_2.setBounds(10, 60, 299, 20);
		
		textMinS = new Text(this, SWT.BORDER | SWT.CENTER);
		textMinS.setText("0");
		textMinS.setBounds(10, 80, 299, 20);
		
		Label label_3 = new Label(this, SWT.NONE);
		label_3.setText("Select the Base Packages Max Depth:");
		label_3.setBounds(10, 105, 299, 20);
		
		textMaxS = new Text(this, SWT.BORDER | SWT.CENTER);
		textMaxS.setText("0");
		textMaxS.setBounds(10, 125, 299, 20);
		
		Label label_4 = new Label(this, SWT.NONE);
		label_4.setText("Select the Target Packages Min Depth:");
		label_4.setBounds(10, 150, 299, 20);
		
		textMinT = new Text(this, SWT.BORDER | SWT.CENTER);
		textMinT.setText("0");
		textMinT.setBounds(10, 170, 299, 20);
		
		
		Label label_5 = new Label(this, SWT.NONE);
		label_5.setText("Select the Target Packages Max Depth:");
		label_5.setBounds(10, 195, 299, 20);
		
		textMaxT = new Text(this, SWT.BORDER | SWT.CENTER);
		textMaxT.setText("0");
		textMaxT.setBounds(10, 215, 299, 20);
		
		final Button button = new Button(this, SWT.NONE);
		button.setText("Save Settings");
		button.setBounds(100, 245, 109, 46);
		button.addListener(SWT.Selection, new Listener() {
		      public void handleEvent(Event e) {
		        switch (e.type) {
		        case SWT.Selection:
		        	
		          break;
		        }
		      }
		    });

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
