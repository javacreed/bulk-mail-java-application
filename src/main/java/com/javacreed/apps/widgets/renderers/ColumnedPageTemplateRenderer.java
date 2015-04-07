/*
 * #%L
 * Bulk Mail Java Application
 * %%
 * Copyright (C) 2012 - 2015 Java Creed
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package com.javacreed.apps.widgets.renderers;

import java.awt.GridLayout;

import com.javacreed.apps.widgets.model.ColumnedPageTemplate;

public class ColumnedPageTemplateRenderer extends AbstractPageTemplateRenderer<ColumnedPageTemplate> {

  private static final long serialVersionUID = -7235357184774873034L;

  public ColumnedPageTemplateRenderer(final ColumnedPageTemplate model) {
    super(model);

    // TODO: the Spacing should come from the theme
    setLayout(new GridLayout(1, model.getColumnCount(), 5, 5));
    for (int i = 0, size = model.getColumnCount(); i < size; i++) {
      add(model.getWidgetContainer(i).createUi());
    }
  }

}
