/**
 */
package arr.general.impl;

import arr.general.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GeneralFactoryImpl extends EFactoryImpl implements GeneralFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GeneralFactory init() {
		try {
			GeneralFactory theGeneralFactory = (GeneralFactory)EPackage.Registry.INSTANCE.getEFactory(GeneralPackage.eNS_URI);
			if (theGeneralFactory != null) {
				return theGeneralFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GeneralFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneralFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case GeneralPackage.ARCHITECTURAL_DEPENDENCY: return createArchitecturalDependency();
			case GeneralPackage.ARR_JAVA_PACKAGE: return createARRJavaPackage();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArchitecturalDependency createArchitecturalDependency() {
		ArchitecturalDependencyImpl architecturalDependency = new ArchitecturalDependencyImpl(null, null, 0 ,0);
		return architecturalDependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ARRJavaPackage createARRJavaPackage() {
		ARRJavaPackageImpl arrJavaPackage = new ARRJavaPackageImpl("");
		return arrJavaPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneralPackage getGeneralPackage() {
		return (GeneralPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static GeneralPackage getPackage() {
		return GeneralPackage.eINSTANCE;
	}

} //GeneralFactoryImpl
