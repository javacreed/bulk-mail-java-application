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

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JFileChooser;

import com.javacreed.apps.widgets.model.ImageVisualWidget;

public class ImageVisualRenderer extends AbstractRenderer<ImageVisualWidget> {

  private static final long serialVersionUID = -4045567511688072669L;

  public ImageVisualRenderer(final ImageVisualWidget model) {
    super(model);
  }

  public void init() {
    addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(final MouseEvent e) {
        model.onBrowse();
      }
    });

    setTransferHandler(model.getImageDropTransferHandler());
  }

  @Override
  protected void paintComponent(final Graphics g) {
    super.paintComponent(g);

    final Graphics2D g2d = (Graphics2D) g.create();
    g2d.drawImage(model.getImage(), model.getImageX(), model.getImageY(), null);
  }

  public File showOpenFileChooser(final File selectedFile, final File directory) {
    final JFileChooser fileChooser = new JFileChooser(directory);
    fileChooser.setSelectedFile(selectedFile);
    fileChooser.setFileFilter(new ImagesFileFilter());
    if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
      return fileChooser.getSelectedFile();
    }

    return null;
  }

}
