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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import com.javacreed.apps.widgets.model.DefaultTheme;
import com.javacreed.apps.widgets.model.PageTemplate;

public class DefaultThemeRenderer extends AbstractThemeRenderer<DefaultTheme> {

  private static final long serialVersionUID = 8820130656355547271L;

  private AbstractPageTemplateRenderer<? extends PageTemplate> pageTemplateRenderer;

  public DefaultThemeRenderer(final DefaultTheme model) {
    super(model);

    setLayout(new BorderLayout(5, 5));
    add(model.getTemplate().createUi());
  }

  @Override
  protected void paintComponent(final Graphics g) {
    super.paintComponent(g);

    final Graphics2D g2d = (Graphics2D) g.create();
    g2d.setColor(new Color(42, 42, 134));
    g2d.fillRect(0, 0, getWidth(), getHeight());
  }
}
