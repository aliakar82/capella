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

package org.polarsys.capella.core.semantic.queries.basic.queries;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;

import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.core.data.requirement.RequirementsTrace;
import org.polarsys.capella.common.data.modellingcore.AbstractTrace;
import org.polarsys.capella.common.helpers.query.IQuery;

/**
 *
 */
public class CapellaElement_requirement implements IQuery {

	/**
	 * 
	 */
	public CapellaElement_requirement() {
    // do nothing
	}

	/** 
	 *  
	 * current.sourceTraces(select "Requirement")
	 * 
	 * @see org.polarsys.capella.common.helpers.query.IQuery#compute(java.lang.Object)
	 */
	public List<Object> compute(Object object) {
		List<Object> result = new ArrayList<Object>();
		if (object instanceof CapellaElement) {
			CapellaElement sf = (CapellaElement) object;
        	EList<AbstractTrace> traces = sf.getOutgoingTraces();
        	for (AbstractTrace trace : traces) {
        		if (trace instanceof RequirementsTrace)
        		{
        			RequirementsTrace rt = (RequirementsTrace) trace; 
        			result.add(rt.getTargetElement());
        		}
			}
		}
        return result;
	}
}
