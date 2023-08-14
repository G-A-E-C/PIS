package componentes.controls;

import java.awt.Color;
import javax.swing.JPanel;

public class PanelBallot extends JPanel {

    public PanelBallot() {
        setBackground(Color.WHITE);
        setLayout(new Layout(Layout.LEFT, 10, 10));
    }
}
