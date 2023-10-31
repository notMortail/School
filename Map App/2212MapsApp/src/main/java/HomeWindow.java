import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class HomeWindow extends JFrame implements ActionListener, WindowListener {
    Container container = new Container();
    Homepage homepage = new Homepage();

    HomeWindow() throws IOException, InterruptedException {
        container.setLayout(null);
        this.setContentPane(homepage);
        this.setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
        addEvents();
    }

    public void addEvents(){
        homepage.middlesex.addActionListener(this);
        homepage.thompson.addActionListener(this);
        homepage.westminster.addActionListener(this);
        homepage.cmbMap.addActionListener(this);
        homepage.help.addActionListener(this);
        this.addWindowListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == homepage.middlesex || homepage.cmbMap.getSelectedIndex() == 1){
            new MapFrameUI("Middlesex College").setVisible(true);
            this.dispose();
        } else if (e.getSource() == homepage.thompson || homepage.cmbMap.getSelectedIndex() == 2){
            new MapFrameUI("Thompson Engineering Building").setVisible(true);
            this.dispose();
        } else if (e.getSource() == homepage.westminster || homepage.cmbMap.getSelectedIndex() == 3){
            new MapFrameUI("Westminster Hall").setVisible(true);
            this.dispose();
        } else if (e.getSource() == homepage.help){
            HelpMenu help = new HelpMenu();
            help.setVisible(true);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    public void windowClosing(WindowEvent e){
        AccountManager.LogOut();
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
