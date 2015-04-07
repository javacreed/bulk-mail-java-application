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
package com.javacreed.apps.widgets;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.javacreed.apps.widgets.model.ColumnedPageTemplate;
import com.javacreed.apps.widgets.model.DefaultTheme;
import com.javacreed.apps.widgets.model.ImageVisualWidget;
import com.javacreed.apps.widgets.model.WidgetContainer;

public class Main {

  public static void main(final String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        final ColumnedPageTemplate pageTemplate = new ColumnedPageTemplate();
        final WidgetContainer widgetContainer = pageTemplate.getWidgetContainer(0);
        widgetContainer.addWidget(new ImageVisualWidget());

        final DefaultTheme theme = new DefaultTheme();
        theme.setTemplate(pageTemplate);

        final JFrame frame = new JFrame("Demo Editor");
        frame.setContentPane(theme.createUi());
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
      }
    });
  }
}
