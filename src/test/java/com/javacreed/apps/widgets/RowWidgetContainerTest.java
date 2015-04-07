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

import org.junit.Assert;
import org.junit.Test;

import com.javacreed.apps.widgets.model.BlankWidget;
import com.javacreed.apps.widgets.model.RowWidgetContainer;

public class RowWidgetContainerTest {

  @Test
  public void testRenderEmpty() {
    final RowWidgetContainer container = new RowWidgetContainer();

    final StringBuilder render = new StringBuilder();
    container.render(render);
    Assert.assertEquals("", render.toString());
  }

  @Test
  public void testRenderMultiple() {
    final RowWidgetContainer container = new RowWidgetContainer();
    container.addWidget(new BlankWidget());
    container.addWidget(new BlankWidget());
    container.addWidget(new BlankWidget());

    final StringBuilder render = new StringBuilder();
    container.render(render);
    Assert.assertEquals("<table><tbody><tr><td></td></tr><tr><td></td></tr><tr><td></td></tr></tbody></table>",
        render.toString());
  }

  @Test
  public void testRenderSingle() {
    final RowWidgetContainer container = new RowWidgetContainer();
    container.addWidget(new BlankWidget());

    final StringBuilder render = new StringBuilder();
    container.render(render);
    Assert.assertEquals("<table><tbody><tr><td></td></tr></tbody></table>", render.toString());
  }

}
