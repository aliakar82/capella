/*******************************************************************************
 * Copyright (c) 2016 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.core.transition.common.handlers.merge;

import org.eclipse.emf.diffmerge.api.diff.IDifference;
import org.eclipse.emf.diffmerge.api.diff.IElementPresence;
import org.eclipse.emf.validation.model.CategoryManager;
import org.eclipse.swt.graphics.Image;

public interface ICategoryItem {

  /**
   * Return whether the given difference belongs to this category in the context of the given diff node
   * 
   * @param difference
   *          a non-null difference
   * @param node_p
   *          a non-null diff node
   */
  boolean covers(IDifference difference);

  /**
   * Return a user-friendly description for this category in the context of the given diff node
   * 
   * @return a potentially null string
   */
  String getDescription();

  /**
   * Return an optional image for this category in the context of the given diff node. The image must not be owned by
   * the category.
   * 
   * @param node_p
   *          a non-null diff node
   * @return a potentially null image
   */
  Image getImage();

  /**
   * Return a user-friendly name for this category in the context of the given diff node
   * 
   * @param node_p
   *          a non-null diff node
   * @return a non-null string
   */
  String getText();

  /**
   * Return whether this category is currently active
   */
  boolean isActive();

  /**
   * Return whether this category is applicable to the given diff node
   * 
   * @param node_p
   *          a non-null object
   */
  boolean isApplicable();

  /**
   * Return whether this category is in focus mode, that is, differences that do not belong to it are filtered out. In
   * the opposite case, differences that belong to the category are filtered out.
   */
  boolean isInFocusMode();

  /**
   * Return whether this category can be modified by the user
   */
  boolean isModifiable();

  /**
   * Return whether this category is visible as such in the UI
   */
  boolean isVisible();

  /**
   * Return whether the category may cover differences that are pending for the user
   * 
   * @see CategoryManager#isPending(IDifference)
   */
  boolean mayCoverPendingDifferences();

  /**
   * Set whether this category is currently active
   * 
   * @param active
   *          whether it is active
   */
  void setActive(boolean active);

  /**
   * Set whether this category is in focus mode
   * 
   * @param inFocusMode
   *          whetehr it is in focus mode
   * @see IDifferenceCategory#isInFocusMode()
   */
  void setInFocusMode(boolean inFocusMode);

  /**
   * Set whether this category can be modified by the user
   *
   * @param modifiable
   *          whether it is modifiable
   */
  void setModifiable(boolean modifiable);

  /**
   * Set whether this category is visible
   * 
   * @param visible
   *          whether it is visible
   */
  void setVisible(boolean visible);

  /**
   * Modify required and implied dependencies for the given difference
   */
  public void setDependencies(IElementPresence difference);
}
