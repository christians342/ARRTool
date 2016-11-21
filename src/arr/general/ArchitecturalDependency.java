/**
 */
package arr.general;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Architectural Dependency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link general.ArchitecturalDependency#getId <em>Id</em>}</li>
 *   <li>{@link general.ArchitecturalDependency#getSupport <em>Support</em>}</li>
 *   <li>{@link general.ArchitecturalDependency#getSource <em>Source</em>}</li>
 *   <li>{@link general.ArchitecturalDependency#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see general.GeneralPackage#getArchitecturalDependency()
 * @model
 * @generated
 */
public interface ArchitecturalDependency extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(int)
	 * @see general.GeneralPackage#getArchitecturalDependency_Id()
	 * @model
	 * @generated
	 */
	int getId();

	/**
	 * Sets the value of the '{@link general.ArchitecturalDependency#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(int value);

	/**
	 * Returns the value of the '<em><b>Support</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Support</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Support</em>' attribute.
	 * @see #setSupport(double)
	 * @see general.GeneralPackage#getArchitecturalDependency_Support()
	 * @model
	 * @generated
	 */
	double getSupport();

	/**
	 * Sets the value of the '{@link general.ArchitecturalDependency#getSupport <em>Support</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Support</em>' attribute.
	 * @see #getSupport()
	 * @generated
	 */
	void setSupport(double value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(ARRJavaPackage)
	 * @see general.GeneralPackage#getArchitecturalDependency_Source()
	 * @model
	 * @generated
	 */
	ARRJavaPackage getSource();

	/**
	 * Sets the value of the '{@link general.ArchitecturalDependency#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(ARRJavaPackage value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(ARRJavaPackage)
	 * @see general.GeneralPackage#getArchitecturalDependency_Target()
	 * @model
	 * @generated
	 */
	ARRJavaPackage getTarget();

	/**
	 * Sets the value of the '{@link general.ArchitecturalDependency#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(ARRJavaPackage value);

} // ArchitecturalDependency
