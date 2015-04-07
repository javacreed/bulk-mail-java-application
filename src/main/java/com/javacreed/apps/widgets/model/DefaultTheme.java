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

import java.util.Objects;

import com.javacreed.apps.widgets.renderers.DefaultThemeRenderer;

public class DefaultTheme extends AbstractTheme {

  private PageTemplate template = new BlankPageTemplate();

  public DefaultTheme() {
    this(600);
  }

  public DefaultTheme(final int width) {
    super(width);
  }

  @Override
  public DefaultThemeRenderer createUi() {
    final DefaultThemeRenderer renderer = new DefaultThemeRenderer(this);
    return renderer;
  }

  public PageTemplate getTemplate() {
    return template;
  }

  @Override
  public void render(final StringBuilder render) {
    // TODO: read from template
    render.append("<html><head>" + "<style>" + " body {" + "  background-color: #b0c4de;" + " }" + " #content {"
        + "  width: " + getWidth() + "px;" + "  margin-left: auto;" + "  margin-right: auto;"
        + "  background-color: #ffffff;" + " }" + "</style>");
    render.append("</head><body><div id='content'>");
    template.render(render);
    render.append("</div></body></html>");
  }

  public void setTemplate(final PageTemplate template) {
    this.template = Objects.requireNonNull(template);
  }
}
