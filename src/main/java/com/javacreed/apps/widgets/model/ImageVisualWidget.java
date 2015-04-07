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

import java.awt.Rectangle;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.TransferHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.javacreed.apps.widgets.renderers.ImageVisualRenderer;

public class ImageVisualWidget extends AbstractVisualWidget {

  private static final Logger LOGGER = LoggerFactory.getLogger(ImageVisualWidget.class);

  private BufferedImage image;
  private Rectangle imageBounds;

  private File directory;
  private File selectedFile;

  private ImageVisualRenderer view;

  @Override
  public JComponent createUi() {
    final ImageVisualRenderer renderer = new ImageVisualRenderer(this);
    return renderer;
  }

  public BufferedImage getImage() {
    return image;
  }

  public TransferHandler getImageDropTransferHandler() {
    return new TransferHandler() {
      @Override
      public boolean canImport(final TransferHandler.TransferSupport support) {
        return true;
      }

      @Override
      public boolean importData(final TransferHandler.TransferSupport support) {
        if (canImport(support)) {
          final Transferable t = support.getTransferable();
          final DataFlavor[] dataFlavors = t.getTransferDataFlavors();

          try {
            final java.util.List<File> list = (java.util.List<File>) t.getTransferData(DataFlavor.javaFileListFlavor);

            onLoadFromFile(list.get(0));
            return true;
          } catch (final Exception e) {
            ImageVisualWidget.LOGGER.error("Failed to load the dropped image", e);
            view.showError("Load Image", "Failed to load the dropped image");
          }
        }
        return false;
      }
    };
  }

  public int getImageX() {
    return imageBounds.x;
  }

  public int getImageY() {
    return imageBounds.y;
  }

  private BufferedImage loadDefault() throws IOException {
    return ImageIO.read(getClass().getResourceAsStream("/images/Blank Image.png"));
  }

  public void onBrowse() {
    final File file = view.showOpenFileChooser(selectedFile, directory);
    if (file == null) {
      return;
    }

    onLoadFromFile(file);
  }

  public void onLoadFromFile(final File file) {
    // TODO: check if the files exists and use specific error messages
    try {
      image = ImageIO.read(file);
      imageBounds = new Rectangle(0, 0, image.getWidth(), image.getHeight());
      selectedFile = file.getAbsoluteFile();
      directory = selectedFile.getParentFile();

      view.repaint();
    } catch (final IOException e) {
      ImageVisualWidget.LOGGER.error("Failed to load the selected image", e);
      view.showError("Load Image", "Failed to load the selected image");
    }
  }

  @Override
  public void render(final StringBuilder render) {}

  public void setView(final ImageVisualRenderer view) {
    this.view = Objects.requireNonNull(view);
    this.view.setModel(this);
  }
}
