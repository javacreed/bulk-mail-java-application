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

import javax.swing.JComponent;

import org.junit.Test;

import com.javacreed.apps.widgets.model.DefaultTheme;
import com.javacreed.apps.widgets.model.PageTemplate;

public class WidgetTest {

  @Test
  public void test() {
    final DefaultTheme theme = new DefaultTheme(500);
    theme.setTemplate(new PageTemplate() {
      @Override
      public JComponent createUi() {
        return null;
      }

      @Override
      public void render(final StringBuilder render) {
        render.append("Hello");
      }
    });

    final StringBuilder render = new StringBuilder();
    theme.render(render);

    System.out.println(render);
  }

}
