/**
 */
package arr.general.impl;

import arr.general.ARRJavaPackage;
import arr.general.ArchitecturalDependency;
import arr.general.GeneralPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Architectural Dependency</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link arr.general.impl.ArchitecturalDependencyImpl#getId <em>Id</em>}</li>
 *   <li>{@link arr.general.impl.ArchitecturalDependencyImpl#getSupport <em>Support</em>}</li>
 *   <li>{@link arr.general.impl.ArchitecturalDependencyImpl#getSource <em>Source</em>}</li>
 *   <li>{@link arr.general.impl.ArchitecturalDependencyImpl#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ArchitecturalDependencyImpl extends MinimalEObjectImpl.Container implements ArchitecturalDependency {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final int ID_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected int id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getSupport() <em>Support</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSupport()
	 * @generated
	 * @ordered
	 */
	protected static final double SUPPORT_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getSupport() <em>Support</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSupport()
	 * @generated
	 * @ordered
	 */
	protected double support = SUPPORT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected ARRJavaPackage source;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected ARRJavaPackage target;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArchitecturalDependencyImpl(ARRJavaPackage source, ARRJavaPackage target, double sup, int identifier) {
		super();
		this.source = source;
		this.target = target;
		this.support = sup;
		this.id = identifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneralPackage.Literals.ARCHITECTURAL_DEPENDENCY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(int newId) {
		int oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.ARCHITECTURAL_DEPENDENCY__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getSupport() {
		return support;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSupport(double newSupport) {
		double oldSupport = support;
		support = newSupport;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.ARCHITECTURAL_DEPENDENCY__SUPPORT, oldSupport, support));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ARRJavaPackage getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (ARRJavaPackage)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneralPackage.ARCHITECTURAL_DEPENDENCY__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ARRJavaPackage basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(ARRJavaPackage newSource) {
		ARRJavaPackage oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.ARCHITECTURAL_DEPENDENCY__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ARRJavaPackage getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (ARRJavaPackage)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneralPackage.ARCHITECTURAL_DEPENDENCY__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ARRJavaPackage basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(ARRJavaPackage newTarget) {
		ARRJavaPackage oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneralPackage.ARCHITECTURAL_DEPENDENCY__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GeneralPackage.ARCHITECTURAL_DEPENDENCY__ID:
				return getId();
			case GeneralPackage.ARCHITECTURAL_DEPENDENCY__SUPPORT:
				return getSupport();
			case GeneralPackage.ARCHITECTURAL_DEPENDENCY__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case GeneralPackage.ARCHITECTURAL_DEPENDENCY__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
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
			case GeneralPackage.ARCHITECTURAL_DEPENDENCY__ID:
				setId((Integer)newValue);
				return;
			case GeneralPackage.ARCHITECTURAL_DEPENDENCY__SUPPORT:
				setSupport((Double)newValue);
				return;
			case GeneralPackage.ARCHITECTURAL_DEPENDENCY__SOURCE:
				setSource((ARRJavaPackage)newValue);
				return;
			case GeneralPackage.ARCHITECTURAL_DEPENDENCY__TARGET:
				setTarget((ARRJavaPackage)newValue);
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
			case GeneralPackage.ARCHITECTURAL_DEPENDENCY__ID:
				setId(ID_EDEFAULT);
				return;
			case GeneralPackage.ARCHITECTURAL_DEPENDENCY__SUPPORT:
				setSupport(SUPPORT_EDEFAULT);
				return;
			case GeneralPackage.ARCHITECTURAL_DEPENDENCY__SOURCE:
				setSource((ARRJavaPackage)null);
				return;
			case GeneralPackage.ARCHITECTURAL_DEPENDENCY__TARGET:
				setTarget((ARRJavaPackage)null);
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
			case GeneralPackage.ARCHITECTURAL_DEPENDENCY__ID:
				return id != ID_EDEFAULT;
			case GeneralPackage.ARCHITECTURAL_DEPENDENCY__SUPPORT:
				return support != SUPPORT_EDEFAULT;
			case GeneralPackage.ARCHITECTURAL_DEPENDENCY__SOURCE:
				return source != null;
			case GeneralPackage.ARCHITECTURAL_DEPENDENCY__TARGET:
				return target != null;
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
		result.append(" (id: ");
		result.append(id);
		result.append(", support: ");
		result.append(support);
		result.append(')');
		return result.toString();
	}

} //ArchitecturalDependencyImpl
