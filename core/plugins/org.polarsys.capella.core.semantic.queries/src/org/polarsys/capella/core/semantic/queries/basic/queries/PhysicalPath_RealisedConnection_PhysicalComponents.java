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

import org.polarsys.capella.core.data.fa.ComponentExchange;
import org.polarsys.capella.common.helpers.query.IQuery;

/**
 */
public class PhysicalPath_RealisedConnection_PhysicalComponents implements IQuery {
  /**
   * @see org.polarsys.capella.common.helpers.query.IQuery#compute(java.lang.Object)
   */
  public List<Object> compute(Object object) {
    List<Object> result = new ArrayList<Object>(0);
    // Check expected type.
    if (object instanceof ComponentExchange) {
      ComponentExchange componentExchange = (ComponentExchange) object;
      if (componentExchange.getSource()!=null && componentExchange.getSource().eContainer()!=null)
        result.add(componentExchange.getSource().eContainer());
      if (componentExchange.getTarget()!=null && componentExchange.getTarget().eContainer()!=null)
        result.add(componentExchange.getTarget().eContainer());
    }
    return result;
  }
}
