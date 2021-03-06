/*
 * #%L
 * Bulk Mail Java Application
 * $Id:$
 * $HeadURL:$
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
package com.javacreed.apps.mail;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class ComposerFileFilter extends FileFilter {

  public static final FileFilter INSTANCE = new ComposerFileFilter();

  @Override
  public boolean accept(final File f) {
    return f.getName().endsWith(".composer");
  }

  @Override
  public String getDescription() {
    return "Composer files";
  }
}
