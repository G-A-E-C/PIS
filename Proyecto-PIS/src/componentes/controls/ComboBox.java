package componentes.controls;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

public class ComboBox extends BasicComboBoxUI {

    @Override
    public void installUI(JComponent jc) {
        super.installUI(jc);
        Border border = new Border();
        JTextField txt = (JTextField) comboBox.getEditor().getEditorComponent();
        txt.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent fe) {
                border.setColor(new Color(128, 189, 255));
            }

            @Override
            public void focusLost(FocusEvent fe) {
                border.setColor(new Color(206, 212, 218));
            }
        });
        comboBox.addPopupMenuListener(new PopupMenuListener() {
            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent pme) {
                arrowButton.setBackground(new Color(255, 255, 255));
            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent pme) {
                arrowButton.setBackground(new Color(255, 255, 255));
            }

            @Override
            public void popupMenuCanceled(PopupMenuEvent pme) {
                arrowButton.setBackground(new Color(255, 255, 255));
            }
        });

            txt.setSelectionColor(new Color(199,231,233));
        txt.setBorder(new EmptyBorder(0, 4, 0, 4));
        comboBox.setBackground(Color.WHITE);
        comboBox.setBorder(border);
    }
    
    /*@Override
    public void installUI(JComponent jc) {
        super.installUI(jc);
        JTextField txt = (JTextField) comboBox.getEditor().getEditorComponent();
        txt.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent fe) {
                comboBox.setBorder(new RoundBorder(15, new Color(128, 189, 255)));
            }

            @Override
            public void focusLost(FocusEvent fe) {
                comboBox.setBorder(new RoundBorder(15, new Color(206, 212, 218)));
            }
        });
        comboBox.setOpaque(false);
        comboBox.setBorder(new RoundBorder(15, new Color(206, 212, 218)));
    }*/

    @Override
    protected JButton createArrowButton() {
        return new ArrowButton();
    }

    @Override
    protected ComboPopup createPopup() {
        return new ComboBoxPopup(comboBox);
    }

    @Override
    protected ListCellRenderer createRenderer() {
        return new ListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList jlist, Object e, int i, boolean bln, boolean bln1) {
                String text = e == null ? "" : e.toString();
                JLabel label = new JLabel(text);
                label.setFont(comboBox.getFont());
                if (i >= 0) {
                    label.setBorder(new EmptyBorder(5, 8, 5, 8));
                } else {
                    label.setBorder(null);
                }
                if (bln) {
                    label.setOpaque(true);
                    label.setBackground(new Color(240, 240, 240));
                    label.setForeground(new Color(17, 155, 215));
                }
                return label;
            }
        };
    }

    @Override
    public void paintCurrentValueBackground(Graphics grphcs, Rectangle rctngl, boolean bln) {
    }

    /*public class ComboBoxPopup extends BasicComboPopup {

        public ComboBoxPopup(JComboBox combo) {
            super(combo);
            setBorder(new RoundBorder(15, new Color(206, 212, 218)));
        }

        @Override
        protected JScrollPane createScroller() {
            JScrollPane scroll = super.createScroller();
            list.setBackground(Color.WHITE);
            ScrollBar sb = new ScrollBar();
            sb.setPreferredSize(new Dimension(12, 70));
            scroll.setVerticalScrollBar(sb);
            ScrollBar sbH = new ScrollBar();
            sbH.setOrientation(JScrollBar.HORIZONTAL);
            scroll.setHorizontalScrollBar(sbH);
            scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            return scroll;
        }
    }*/

    private class ComboBoxPopup extends BasicComboPopup {

        public ComboBoxPopup(JComboBox combo) {
            super(combo);
            setBorder(new Border(1));
        }

        @Override
        protected JScrollPane createScroller() {
            JScrollPane scroll = super.createScroller();
            list.setBackground(Color.WHITE);
            ScrollBar sb = new ScrollBar();
            sb.setPreferredSize(new Dimension(12, 70));
            scroll.setVerticalScrollBar(sb);
            ScrollBar sbH = new ScrollBar();
            sbH.setOrientation(JScrollBar.HORIZONTAL);
            scroll.setHorizontalScrollBar(sbH);
            scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            return scroll;
        }
    }
    
    private class ArrowButton extends JButton {

        public ArrowButton() {
            setContentAreaFilled(false);
            setBorder(new EmptyBorder(5, 5, 5, 5));
            setBackground(new Color(255, 255, 255));
        }

        @Override
        public void paint(Graphics grphcs) {
            super.paint(grphcs);
            Graphics2D g2 = (Graphics2D) grphcs.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            int width = getWidth();
            int height = getHeight();
            int sizeX = 12;
            int sizeY = 8;
            int x = (width - sizeX) / 2;
            int y = (height - sizeY) / 2;
            int px[] = {x, x + sizeX, x + sizeX / 2};
            int py[] = {y, y, y + sizeY};
            g2.setColor(getBackground());
            g2.fillPolygon(px, py, px.length);
            g2.dispose();
        }
    }

    /*private class RoundBorder extends AbstractBorder {

        private final int radius;
        private final Color color;

        public RoundBorder(int radius, Color color) {
            this.radius = radius;
            this.color = color;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            if (c.isFocusOwner()) {
                g2.setColor(new Color(128, 189, 255));
            } else {
                g2.setColor(new Color(206, 212, 218));
            }
            g2.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
            g2.dispose();
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(4, 8, 4, 8); // Ajusta estos valores según sea necesario
        }

        @Override
        public Insets getBorderInsets(Component c, Insets insets) {
            insets.left = 8;
            insets.top = 4;
            insets.right = 8;
            insets.bottom = 4;
            return insets;
        }
    }*/

    private class Border extends EmptyBorder {

        public Color getFocusColor() {
            return focusColor;
        }

        public void setFocusColor(Color focusColor) {
            this.focusColor = focusColor;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        private Color focusColor = new Color(199,231,233);
        private Color color = new Color(199,231,233);

        public Border(int border) {
            super(border, border, border, border);
        }

        public Border() {
            this(5);
        }

        @Override
        public void paintBorder(Component cmpnt, Graphics grphcs, int x, int y, int width, int height) {
            Graphics2D g2 = (Graphics2D) grphcs.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            if (cmpnt.isFocusOwner()) {
                g2.setColor(focusColor);
            } else {
                g2.setColor(color);
            }
            //g2.fill(new RoundRectangle2D.Double(0, 0, width, height, 10, 10));
            //g2.drawRoundRect(x, y, width , height , 10, 10);
            
            g2.drawRect(x, y, width - 1, height - 1);
            
            g2.dispose();
        }
    }
}
