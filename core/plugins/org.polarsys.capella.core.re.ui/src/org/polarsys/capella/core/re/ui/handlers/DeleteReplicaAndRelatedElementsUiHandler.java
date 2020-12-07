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
package org.polarsys.capella.core.re.ui.handlers;

import java.util.Collection;

import org.eclipse.core.runtime.IProgressMonitor;
import org.polarsys.capella.common.ef.command.ICommand;

public class DeleteReplicaAndRelatedElementsUiHandler extends org.polarsys.capella.core.re.handlers.DeleteReplicaAndRelatedElementsHandler {

	  @Override
	  protected ICommand createCommand(Collection<?> selection, IProgressMonitor progressMonitor) {
	    return new org.polarsys.capella.core.re.commands.DeleteReplicaAndRelatedElementsCommand(selection, progressMonitor) {
	      @Override
	      protected boolean isHeadless() {
	        return false;
	      }
	    };
	  }
}
