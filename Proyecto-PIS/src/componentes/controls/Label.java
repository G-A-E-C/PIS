package componentes.controls;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Label extends JLabel{
    
    public Label(){
        setFont(new Font("Microsoft JhengHei Ui", Font.PLAIN, 14));
        setForeground(new Color(112,115,130));
        setHorizontalAlignment(SwingConstants.CENTER);
    }
}
