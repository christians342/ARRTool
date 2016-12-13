package arr.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

public class AlgorithmOptionsView extends Shell {
	private Text text;
	public static int alg = 0;
	public static float minsup = 0.000001f;
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			AlgorithmOptionsView shell = new AlgorithmOptionsView(display);
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
	public AlgorithmOptionsView(Display display) {
		super(display, SWT.SHELL_TRIM);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("ARR Options");
		setSize(450, 300);
		setLayout(null);
		
		Label label = new Label(this, SWT.NONE);
		label.setText("Select the algorithm to run for the architecture recovery\r\ndata mining phase:");
		label.setBounds(10, 10, 296, 30);
		
		
		final Label labelExpl = new Label(this, SWT.BORDER | SWT.WRAP);
		labelExpl.setBounds(10, 97, 414, 100);
		
		
		final Combo combo = new Combo(this, SWT.READ_ONLY);
		combo.setBounds(10, 47, 299, 23);
		combo.add("Apriori");
		combo.add("Apriori2");
	    combo.addModifyListener(new ModifyListener(){

	        public void modifyText(ModifyEvent arg0) {
	        	labelExpl.setText("Apriori is an algorithm for frequent item set mining and association rule learning over transactional databases. It proceeds by identifying the frequent individual items in the database and extending them to larger and larger item sets as long as those item sets appear sufficiently often in the database");
	        }});
	    
		Label label_2 = new Label(this, SWT.NONE);
		label_2.setText("Select the desired minsup:");
		label_2.setBounds(10, 209, 138, 15);
		
		text = new Text(this, SWT.BORDER | SWT.CENTER);
		text.setText("0.04");
		text.setBounds(10, 230, 299, 21);
		
		final Button button = new Button(this, SWT.NONE);
		button.setText("Save Settings");
		button.setBounds(315, 205, 109, 46);
		button.addListener(SWT.Selection, new Listener() {
		      public void handleEvent(Event e) {
		        switch (e.type) {
		        case SWT.Selection:
		        	alg = combo.getSelectionIndex();
		        	try
		        	{
		        		minsup = Float.parseFloat(text.getText());
		        		button.getParent().getShell().close();
		        	}
		        	catch(NumberFormatException n)
		        	{
		        		MessageSystem.invalidFormat();
		        	}
		        	//
		          break;
		        }
		      }
		    });
		
		
		Label lblExplainingTheSelected = new Label(this, SWT.NONE);
		lblExplainingTheSelected.setBounds(10, 76, 185, 15);
		lblExplainingTheSelected.setText("Explaining the selected Algorithm:");
		

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
