/**
 */
package arr.general.impl;

import arr.general.ARRJavaPackage;
import arr.general.ArchitecturalDependency;
import arr.general.GeneralFactory;
import arr.general.GeneralPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GeneralPackageImpl extends EPackageImpl implements GeneralPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass architecturalDependencyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass arrJavaPackageEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see general.GeneralPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private GeneralPackageImpl() {
		super(eNS_URI, GeneralFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link GeneralPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static GeneralPackage init() {
		if (isInited) return (GeneralPackage)EPackage.Registry.INSTANCE.getEPackage(GeneralPackage.eNS_URI);

		// Obtain or create and register package
		GeneralPackageImpl theGeneralPackage = (GeneralPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof GeneralPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new GeneralPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theGeneralPackage.createPackageContents();

		// Initialize created meta-data
		theGeneralPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theGeneralPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(GeneralPackage.eNS_URI, theGeneralPackage);
		return theGeneralPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArchitecturalDependency() {
		return architecturalDependencyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getArchitecturalDependency_Id() {
		return (EAttribute)architecturalDependencyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getArchitecturalDependency_Support() {
		return (EAttribute)architecturalDependencyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitecturalDependency_Source() {
		return (EReference)architecturalDependencyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArchitecturalDependency_Target() {
		return (EReference)architecturalDependencyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getARRJavaPackage() {
		return arrJavaPackageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getARRJavaPackage_SpecialPackage() {
		return (EAttribute)arrJavaPackageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getARRJavaPackage_JavaPackage() {
		return (EAttribute)arrJavaPackageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getARRJavaPackage_PackageProject() {
		return (EAttribute)arrJavaPackageEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneralFactory getGeneralFactory() {
		return (GeneralFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		architecturalDependencyEClass = createEClass(ARCHITECTURAL_DEPENDENCY);
		createEAttribute(architecturalDependencyEClass, ARCHITECTURAL_DEPENDENCY__ID);
		createEAttribute(architecturalDependencyEClass, ARCHITECTURAL_DEPENDENCY__SUPPORT);
		createEReference(architecturalDependencyEClass, ARCHITECTURAL_DEPENDENCY__SOURCE);
		createEReference(architecturalDependencyEClass, ARCHITECTURAL_DEPENDENCY__TARGET);

		arrJavaPackageEClass = createEClass(ARR_JAVA_PACKAGE);
		createEAttribute(arrJavaPackageEClass, ARR_JAVA_PACKAGE__SPECIAL_PACKAGE);
		createEAttribute(arrJavaPackageEClass, ARR_JAVA_PACKAGE__JAVA_PACKAGE);
		createEAttribute(arrJavaPackageEClass, ARR_JAVA_PACKAGE__PACKAGE_PROJECT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(architecturalDependencyEClass, ArchitecturalDependency.class, "ArchitecturalDependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getArchitecturalDependency_Id(), ecorePackage.getEInt(), "id", null, 0, 1, ArchitecturalDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getArchitecturalDependency_Support(), ecorePackage.getEDouble(), "support", null, 0, 1, ArchitecturalDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitecturalDependency_Source(), this.getARRJavaPackage(), null, "source", null, 0, 1, ArchitecturalDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArchitecturalDependency_Target(), this.getARRJavaPackage(), null, "target", null, 0, 1, ArchitecturalDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(arrJavaPackageEClass, ARRJavaPackage.class, "ARRJavaPackage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getARRJavaPackage_SpecialPackage(), ecorePackage.getEBoolean(), "specialPackage", null, 0, 1, ARRJavaPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getARRJavaPackage_JavaPackage(), ecorePackage.getEJavaObject(), "JavaPackage", null, 0, 1, ARRJavaPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getARRJavaPackage_PackageProject(), ecorePackage.getEJavaObject(), "packageProject", null, 0, 1, ARRJavaPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //GeneralPackageImpl
