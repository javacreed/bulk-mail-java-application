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
package com.javacreed.apps.widgets.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

import com.javacreed.apps.widgets.renderers.ColumnedPageTemplateRenderer;

public class ColumnedPageTemplate extends AbstractPageTemplate {

  private final List<ColumnWidgetContainer> columns;

  public ColumnedPageTemplate() {
    this(1);
  }

  public ColumnedPageTemplate(final int columns) {
    this.columns = new ArrayList<>(columns);
    for (int i = 0; i < columns; i++) {
      this.columns.add(new ColumnWidgetContainer());
    }
  }

  @Override
  public JComponent createUi() {
    final ColumnedPageTemplateRenderer renderer = new ColumnedPageTemplateRenderer(this);
    return renderer;
  }

  public int getColumnCount() {
    return columns.size();
  }

  public ColumnWidgetContainer getWidgetContainer(final int column) {
    return columns.get(column);
  }

  @Override
  public void render(final StringBuilder render) {
    render.append("<table><tbody>");
    for (int i = 0, size = columns.size(); i < size; i++) {
      render.append("<tr><td>");
      columns.get(i).render(render);
      render.append("</tr></td>");
    }
    render.append("</tbody></table>");
  }
}
