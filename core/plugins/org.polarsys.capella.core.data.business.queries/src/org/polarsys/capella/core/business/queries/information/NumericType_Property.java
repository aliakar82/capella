/*******************************************************************************
 * Copyright (c) 2006, 2020 THALES GLOBAL SERVICES.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.core.business.queries.information;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.polarsys.capella.common.queries.interpretor.QueryInterpretor;
import org.polarsys.capella.common.queries.queryContext.QueryContext;
import org.polarsys.capella.core.business.abstractqueries.CapellaElement_CurrentAndHigherLevelsQuery;
import org.polarsys.capella.core.business.abstractqueries.helpers.CapellaElementsHelperForBusinessQueries;
import org.polarsys.capella.core.business.queries.IBusinessQuery;
import org.polarsys.capella.core.business.queries.QueryConstants;
import org.polarsys.capella.core.data.capellacore.CapellacorePackage;
import org.polarsys.capella.core.data.information.datatype.DatatypePackage;

/**
 * @deprecated now the properties are directly returned in the explicit business queries
 * This query allows to get the properties corresponding to the current numeric type.
 * @see CapellaElementsHelperForBusinessQueries
 */
@Deprecated
public class NumericType_Property extends CapellaElement_CurrentAndHigherLevelsQuery implements IBusinessQuery {
	/**
	 * @see org.polarsys.capella.core.business.queries.capellacore.IBusinessQuery#getEClass()
	 */
	@Override
	public EClass getEClass() {
		return DatatypePackage.Literals.NUMERIC_TYPE;
	}

	/**
	 * @see org.polarsys.capella.core.business.queries.capellacore.IBusinessQuery#getEStructuralFeatures()
	 */
	@Override
	public List<EReference> getEStructuralFeatures() {
		return Collections.singletonList(CapellacorePackage.Literals.CLASSIFIER__OWNED_FEATURES);
	}

	@Override
	public List<EObject> getAvailableElements(EObject element) {
		QueryContext context = new QueryContext();
		context.putValue(QueryConstants.ECLASS_PARAMETER, getEClass());
		return QueryInterpretor.executeQuery(QueryConstants.GET_AVAILABLE__NUMERIC_TYPE__PROPERTY, element, context);
	}

	@Override
	public List<EObject> getCurrentElements(EObject element, boolean onlyGenerated) {
		QueryContext context = new QueryContext();
		context.putValue(QueryConstants.ECLASS_PARAMETER, getEClass());
		return QueryInterpretor.executeQuery(QueryConstants.GET_CURRENT__NUMERIC_TYPE__PROPERTY, element, context);
	}
}
