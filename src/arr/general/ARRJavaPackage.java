/**
 */
package arr.general;

import org.eclipse.emf.ecore.EObject;

import jdepend.framework.JavaPackage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ARR Java Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link general.ARRJavaPackage#isSpecialPackage <em>Special Package</em>}</li>
 *   <li>{@link general.ARRJavaPackage#getJavaPackage <em>Java Package</em>}</li>
 *   <li>{@link general.ARRJavaPackage#getPackageProject <em>Package Project</em>}</li>
 * </ul>
 *
 * @see general.GeneralPackage#getARRJavaPackage()
 * @model
 * @generated
 */
public interface ARRJavaPackage extends EObject {
	/**
	 * Returns the value of the '<em><b>Special Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Special Package</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Special Package</em>' attribute.
	 * @see #setSpecialPackage(boolean)
	 * @see general.GeneralPackage#getARRJavaPackage_SpecialPackage()
	 * @model
	 * @generated
	 */
	boolean isSpecialPackage();

	/**
	 * Sets the value of the '{@link general.ARRJavaPackage#isSpecialPackage <em>Special Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Special Package</em>' attribute.
	 * @see #isSpecialPackage()
	 * @generated
	 */
	void setSpecialPackage(boolean value);

	/**
	 * Returns the value of the '<em><b>Java Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Java Package</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Java Package</em>' attribute.
	 * @see #setJavaPackage(Object)
	 * @see general.GeneralPackage#getARRJavaPackage_JavaPackage()
	 * @model
	 * @generated
	 */
	JavaPackage getJavaPackage();
	
	/**
	 * Returns the value of the name of the '<em><b>Java Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Java Package</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Java Package</em>' attribute.
	 * @see #setJavaPackage(Object)
	 * @see general.GeneralPackage#getARRJavaPackage_JavaPackage()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link general.ARRJavaPackage#getJavaPackage <em>Java Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Java Package</em>' attribute.
	 * @see #getJavaPackage()
	 * @generated
	 */
	void setJavaPackage(JavaPackage value);

	/**
	 * Returns the value of the '<em><b>Package Project</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package Project</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package Project</em>' attribute.
	 * @see #setPackageProject(Object)
	 * @see general.GeneralPackage#getARRJavaPackage_PackageProject()
	 * @model
	 * @generated
	 */
	String getPackageProjectName();

	/**
	 * Sets the value of the '{@link general.ARRJavaPackage#getPackageProject <em>Package Project</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Package Project</em>' attribute.
	 * @see #getPackageProject()
	 * @generated
	 */
	void setPackageProjectName(String value);

} // ARRJavaPackage
