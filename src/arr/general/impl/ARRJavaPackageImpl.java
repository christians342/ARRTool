/**
 */
package arr.general.impl;

import arr.general.ARRJavaPackage;
import arr.general.GeneralPackage;
import jdepend.framework.JavaPackage;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ARR Java Package</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link arr.general.impl.ARRJavaPackageImpl#isSpecialPackage <em>Special Package</em>}</li>
 *   <li>{@link arr.general.impl.ARRJavaPackageImpl#getJavaPackage <em>Java Package</em>}</li>
 *   <li>{@link arr.general.impl.ARRJavaPackageImpl#getPackageProject <em>Package Project</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ARRJavaPackageImpl extends MinimalEObjectImpl.Container implements ARRJavaPackage {
	/**
	 * The default value of the '{@link #isSpecialPackage() <em>Special Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSpecialPackage()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SPECIAL_PACKAGE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSpecialPackage() <em>Special Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSpecialPackage()
	 * @generated
	 * @ordered
	 */
	protected boolean specialPackage = SPECIAL_PACKAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getJavaPackage() <em>Java Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJavaPackage()
	 * @generated
	 * @ordered
	 */
	protected static final Object JAVA_PACKAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getJavaPackage() <em>Java Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJavaPackage()
	 * @generated
	 * @ordered
	 */
	protected JavaPackage javaPackage = (JavaPackage) JAVA_PACKAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPackageProject() <em>Package Project</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackageProject()
	 * @generated
	 * @ordered
	 */
	protected static final String PACKAGE_PROJECT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPackageProject() <em>Package Project</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackageProject()
	 * @generated
	 * @ordered
	 */
	protected String packageProjectName = PACKAGE_PROJECT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ARRJavaPackageImpl(JavaPackage j) {
		super();
		this.javaPackage = j;
	}
	
	public ARRJavaPackageImpl(String s) {
		super();
		this.javaPackage = new JavaPackage(s);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneralPackage.Literals.ARR_JAVA_PACKAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSpecialPackage() {
		return specialPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecialPackage(boolean newSpecialPackage) {
		boolean oldSpecialPackage = specialPackage;
		specialPackage = newSpecialPackage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.ARR_JAVA_PACKAGE__SPECIAL_PACKAGE, oldSpecialPackage, specialPackage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaPackage getJavaPackage() {
		return (JavaPackage) javaPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setJavaPackage(JavaPackage newJavaPackage) {
		Object oldJavaPackage = javaPackage;
		javaPackage = (JavaPackage) newJavaPackage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.ARR_JAVA_PACKAGE__JAVA_PACKAGE, oldJavaPackage, javaPackage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPackageProjectName() {
		return packageProjectName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return javaPackage.getName();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPackageProjectName(String newPackageProjectName) {
		String oldPackageProject = packageProjectName;
		packageProjectName = newPackageProjectName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.ARR_JAVA_PACKAGE__PACKAGE_PROJECT, oldPackageProject, newPackageProjectName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GeneralPackage.ARR_JAVA_PACKAGE__SPECIAL_PACKAGE:
				return isSpecialPackage();
			case GeneralPackage.ARR_JAVA_PACKAGE__JAVA_PACKAGE:
				return getJavaPackage();
			case GeneralPackage.ARR_JAVA_PACKAGE__PACKAGE_PROJECT:
				return getPackageProjectName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GeneralPackage.ARR_JAVA_PACKAGE__SPECIAL_PACKAGE:
				setSpecialPackage((Boolean)newValue);
				return;
			case GeneralPackage.ARR_JAVA_PACKAGE__JAVA_PACKAGE:
				setJavaPackage((JavaPackage) newValue);
				return;
			case GeneralPackage.ARR_JAVA_PACKAGE__PACKAGE_PROJECT:
				setPackageProjectName((String) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case GeneralPackage.ARR_JAVA_PACKAGE__SPECIAL_PACKAGE:
				setSpecialPackage(SPECIAL_PACKAGE_EDEFAULT);
				return;
			case GeneralPackage.ARR_JAVA_PACKAGE__JAVA_PACKAGE:
				setJavaPackage((JavaPackage) JAVA_PACKAGE_EDEFAULT);
				return;
			case GeneralPackage.ARR_JAVA_PACKAGE__PACKAGE_PROJECT:
				setPackageProjectName((String) PACKAGE_PROJECT_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GeneralPackage.ARR_JAVA_PACKAGE__SPECIAL_PACKAGE:
				return specialPackage != SPECIAL_PACKAGE_EDEFAULT;
			case GeneralPackage.ARR_JAVA_PACKAGE__JAVA_PACKAGE:
				return JAVA_PACKAGE_EDEFAULT == null ? javaPackage != null : !JAVA_PACKAGE_EDEFAULT.equals(javaPackage);
			case GeneralPackage.ARR_JAVA_PACKAGE__PACKAGE_PROJECT:
				return PACKAGE_PROJECT_EDEFAULT == null ? packageProjectName != null : !PACKAGE_PROJECT_EDEFAULT.equals(packageProjectName);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (specialPackage: ");
		result.append(specialPackage);
		result.append(", JavaPackage: ");
		result.append(javaPackage);
		result.append(", packageProjectName: ");
		result.append(packageProjectName);
		result.append(')');
		return result.toString();
	}
	

} //ARRJavaPackageImpl
