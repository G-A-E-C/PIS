package componentes.controls;

import javax.swing.JComboBox;

public class Combo extends JComboBox<Object>{
    
    public Combo() {
        setUI(new ComboBox());
    }

}
