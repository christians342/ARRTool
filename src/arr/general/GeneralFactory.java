/**
 */
package arr.general;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see general.GeneralPackage
 * @generated
 */
public interface GeneralFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GeneralFactory eINSTANCE = (GeneralFactory) arr.general.impl.GeneralFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Architectural Dependency</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Architectural Dependency</em>'.
	 * @generated
	 */
	ArchitecturalDependency createArchitecturalDependency();

	/**
	 * Returns a new object of class '<em>ARR Java Package</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ARR Java Package</em>'.
	 * @generated
	 */
	ARRJavaPackage createARRJavaPackage();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	GeneralPackage getGeneralPackage();

} //GeneralFactory
