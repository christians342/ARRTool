/**
 */
package arr.general;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see general.GeneralFactory
 * @model kind="package"
 * @generated
 */
public interface GeneralPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "general";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://org/arr/general";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.arr.general";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GeneralPackage eINSTANCE = arr.general.impl.GeneralPackageImpl.init();

	/**
	 * The meta object id for the '{@link arr.general.impl.ArchitecturalDependencyImpl <em>Architectural Dependency</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see arr.general.impl.ArchitecturalDependencyImpl
	 * @see arr.general.impl.GeneralPackageImpl#getArchitecturalDependency()
	 * @generated
	 */
	int ARCHITECTURAL_DEPENDENCY = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURAL_DEPENDENCY__ID = 0;

	/**
	 * The feature id for the '<em><b>Support</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURAL_DEPENDENCY__SUPPORT = 1;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURAL_DEPENDENCY__SOURCE = 2;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURAL_DEPENDENCY__TARGET = 3;

	/**
	 * The number of structural features of the '<em>Architectural Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURAL_DEPENDENCY_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Architectural Dependency</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARCHITECTURAL_DEPENDENCY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link arr.general.impl.ARRJavaPackageImpl <em>ARR Java Package</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see arr.general.impl.ARRJavaPackageImpl
	 * @see arr.general.impl.GeneralPackageImpl#getARRJavaPackage()
	 * @generated
	 */
	int ARR_JAVA_PACKAGE = 1;

	/**
	 * The feature id for the '<em><b>Special Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARR_JAVA_PACKAGE__SPECIAL_PACKAGE = 0;

	/**
	 * The feature id for the '<em><b>Java Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARR_JAVA_PACKAGE__JAVA_PACKAGE = 1;

	/**
	 * The feature id for the '<em><b>Package Project</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARR_JAVA_PACKAGE__PACKAGE_PROJECT = 2;

	/**
	 * The number of structural features of the '<em>ARR Java Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARR_JAVA_PACKAGE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>ARR Java Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARR_JAVA_PACKAGE_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link general.ArchitecturalDependency <em>Architectural Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Architectural Dependency</em>'.
	 * @see general.ArchitecturalDependency
	 * @generated
	 */
	EClass getArchitecturalDependency();

	/**
	 * Returns the meta object for the attribute '{@link general.ArchitecturalDependency#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see general.ArchitecturalDependency#getId()
	 * @see #getArchitecturalDependency()
	 * @generated
	 */
	EAttribute getArchitecturalDependency_Id();

	/**
	 * Returns the meta object for the attribute '{@link general.ArchitecturalDependency#getSupport <em>Support</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Support</em>'.
	 * @see general.ArchitecturalDependency#getSupport()
	 * @see #getArchitecturalDependency()
	 * @generated
	 */
	EAttribute getArchitecturalDependency_Support();

	/**
	 * Returns the meta object for the reference '{@link general.ArchitecturalDependency#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see general.ArchitecturalDependency#getSource()
	 * @see #getArchitecturalDependency()
	 * @generated
	 */
	EReference getArchitecturalDependency_Source();

	/**
	 * Returns the meta object for the reference '{@link general.ArchitecturalDependency#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see general.ArchitecturalDependency#getTarget()
	 * @see #getArchitecturalDependency()
	 * @generated
	 */
	EReference getArchitecturalDependency_Target();

	/**
	 * Returns the meta object for class '{@link general.ARRJavaPackage <em>ARR Java Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ARR Java Package</em>'.
	 * @see general.ARRJavaPackage
	 * @generated
	 */
	EClass getARRJavaPackage();

	/**
	 * Returns the meta object for the attribute '{@link general.ARRJavaPackage#isSpecialPackage <em>Special Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Special Package</em>'.
	 * @see general.ARRJavaPackage#isSpecialPackage()
	 * @see #getARRJavaPackage()
	 * @generated
	 */
	EAttribute getARRJavaPackage_SpecialPackage();

	/**
	 * Returns the meta object for the attribute '{@link general.ARRJavaPackage#getJavaPackage <em>Java Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Java Package</em>'.
	 * @see general.ARRJavaPackage#getJavaPackage()
	 * @see #getARRJavaPackage()
	 * @generated
	 */
	EAttribute getARRJavaPackage_JavaPackage();

	/**
	 * Returns the meta object for the attribute '{@link general.ARRJavaPackage#getPackageProject <em>Package Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Package Project</em>'.
	 * @see general.ARRJavaPackage#getPackageProject()
	 * @see #getARRJavaPackage()
	 * @generated
	 */
	EAttribute getARRJavaPackage_PackageProject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GeneralFactory getGeneralFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link arr.general.impl.ArchitecturalDependencyImpl <em>Architectural Dependency</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see arr.general.impl.ArchitecturalDependencyImpl
		 * @see arr.general.impl.GeneralPackageImpl#getArchitecturalDependency()
		 * @generated
		 */
		EClass ARCHITECTURAL_DEPENDENCY = eINSTANCE.getArchitecturalDependency();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARCHITECTURAL_DEPENDENCY__ID = eINSTANCE.getArchitecturalDependency_Id();

		/**
		 * The meta object literal for the '<em><b>Support</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARCHITECTURAL_DEPENDENCY__SUPPORT = eINSTANCE.getArchitecturalDependency_Support();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURAL_DEPENDENCY__SOURCE = eINSTANCE.getArchitecturalDependency_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARCHITECTURAL_DEPENDENCY__TARGET = eINSTANCE.getArchitecturalDependency_Target();

		/**
		 * The meta object literal for the '{@link arr.general.impl.ARRJavaPackageImpl <em>ARR Java Package</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see arr.general.impl.ARRJavaPackageImpl
		 * @see arr.general.impl.GeneralPackageImpl#getARRJavaPackage()
		 * @generated
		 */
		EClass ARR_JAVA_PACKAGE = eINSTANCE.getARRJavaPackage();

		/**
		 * The meta object literal for the '<em><b>Special Package</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARR_JAVA_PACKAGE__SPECIAL_PACKAGE = eINSTANCE.getARRJavaPackage_SpecialPackage();

		/**
		 * The meta object literal for the '<em><b>Java Package</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARR_JAVA_PACKAGE__JAVA_PACKAGE = eINSTANCE.getARRJavaPackage_JavaPackage();

		/**
		 * The meta object literal for the '<em><b>Package Project</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARR_JAVA_PACKAGE__PACKAGE_PROJECT = eINSTANCE.getARRJavaPackage_PackageProject();

	}

} //GeneralPackage
