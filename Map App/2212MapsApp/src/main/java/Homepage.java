import com.fasterxml.jackson.core.JsonParser;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.*;

public class Homepage extends JPanel {
    public JComboBox cmbMap;
    private JPanel pnlMain;
    private JPanel pnlImage;
    private BufferedImage bufferedImage = null;
    public JButton middlesex;
    public JButton thompson;
    public JButton westminster;
    public JButton help;
    private Weather weatherResponse = new Weather();
    private ObjectMapper mapper = new ObjectMapper();



    public Homepage() throws IOException, InterruptedException {
        final String dir = System.getProperty("user.dir");
        File file = new File(dir + "\\src\\main\\java\\Assets\\Maps\\Campus.png");

        JPanel canvas;
        try {
            bufferedImage = ImageIO.read(file);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        canvas = new JPanel() {
            private static final long serialVersionUID = 1L;

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(bufferedImage, 0, 0, null);
            }
        };

        canvas.setLayout(null);

        //Marker for Middlesex College
        middlesex = new JButton(new ImageIcon(dir + "\\src\\main\\java\\Assets\\Icons\\pin.png"));
        middlesex.setBounds(1860, 1650, 32, 32);
        middlesex.setOpaque(false);
        middlesex.setContentAreaFilled(false);
        middlesex.setBorderPainted(false);

        //Marker for Thomson Hall
        thompson = new JButton(new ImageIcon(dir + "\\src\\main\\java\\Assets\\Icons\\pin.png"));
        thompson.setBounds(1020, 2180, 32, 32);
        thompson.setOpaque(false);
        thompson.setContentAreaFilled(false);
        thompson.setBorderPainted(false);

        //Marker for Westminster Hall
        westminster = new JButton(new ImageIcon(dir + "\\src\\main\\java\\Assets\\Icons\\pin.png"));
        westminster.setBounds(1810, 650, 32, 32);
        westminster.setOpaque(false);
        westminster.setContentAreaFilled(false);
        westminster.setBorderPainted(false);

        canvas.add(middlesex);
        canvas.add(thompson);
        canvas.add(westminster);
        canvas.setPreferredSize(new Dimension(bufferedImage.getWidth(), bufferedImage.getHeight()));
        JScrollPane sp = new JScrollPane(canvas);
        setLayout(new BorderLayout());
        add(sp, BorderLayout.CENTER);

        String building[] = {"Select Building", "Middlesex College", "Thomson Engineering Building", "Westminster Hall"};
        cmbMap = new JComboBox(building);
        cmbMap.setBounds(5, 5,200,20);
        cmbMap.setLayout(null);
        cmbMap.setSize(200,20);
        cmbMap.setVisible(true);

        canvas.add(cmbMap);

        help = new JButton();
        help.setBounds(215,5,125,20);
        help.setText("Help");
        help.setVisible(true);
        canvas.add(help);

        readWeather();
        JLabel weather = new JLabel("Temp: " + weatherResponse.getTemperature() + "\u00B0C");
        weather.setOpaque(true);
        weather.setBackground(Color.gray);

        JPanel bottom = new JPanel(new BorderLayout());
        bottom.add(weather, BorderLayout.LINE_END);
        JPanel weatherPanel = new JPanel(new BorderLayout());
        weatherPanel.add(bottom, BorderLayout.PAGE_END);

        canvas.add(weatherPanel);
    }


    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        pnlMain = new JPanel();
        pnlMain.setLayout(new BorderLayout(0, 0));
        cmbMap = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        cmbMap.setModel(defaultComboBoxModel1);
        pnlMain.add(cmbMap, BorderLayout.NORTH);
        final JScrollPane scrollPane1 = new JScrollPane();
        pnlMain.add(scrollPane1, BorderLayout.CENTER);
        pnlImage = new JPanel();
        pnlImage.setLayout(new BorderLayout(0, 0));
        scrollPane1.setViewportView(pnlImage);
    }

    void readWeather() throws IOException {
        //weatherResponse = mapper.readValue(weatherResponse.getResponse(), Weather.class);
    }
}
