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

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JComponent;

public class BlankPane extends JComponent {
  public void init() {
    setBorder(BorderFactory.createDashedBorder(Color.DARK_GRAY, 2, 10, 5, true));
    setBackground(new Color(45, 22, 50));

    addMouseListener(new MouseAdapter() {
      @Override
      public void mouseEntered(final MouseEvent e) {
        setOpaque(true);
        repaint();
      }

      @Override
      public void mouseExited(final MouseEvent e) {
        setOpaque(false);
        repaint();
      }
    });
  }

  @Override
  protected void paintComponent(final Graphics g) {
    super.paintComponent(g);

    if (!isOpaque()) {
      final Graphics2D g2d = (Graphics2D) g.create();
      g2d.setColor(getBackground());
      g2d.fillRect(0, 0, getWidth(), getHeight());
    }
  }
}
