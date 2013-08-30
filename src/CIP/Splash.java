package CIP;

import java.awt.*;
import java.awt.event.*;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Splash extends Frame implements ActionListener {
//    static void renderSplashFrame(Graphics2D g, int frame) {
//        ///final String[] comps = {"foo", "bar", "baz"};
//        //g.setComposite(AlphaComposite.Clear);
//        //g.fillRect(120,140,200,40);
//        //g.setPaintMode();
//        //g.setColor(Color.BLACK);
//        //g.drawString("Loading "+comps[(frame/5)%3]+"...", 120, 150);
//    }
    public Splash() {
//        super("SplashScreen demo");
//        setSize(300, 200);
//        setLayout(new BorderLayout());
//        Menu m1 = new Menu("File");
//        MenuItem mi1 = new MenuItem("Exit");
//        m1.add(mi1);
//        mi1.addActionListener(this);
//        this.addWindowListener(closeWindow);
//
//        MenuBar mb = new MenuBar();
//        setMenuBar(mb);
//        mb.add(m1);
        final SplashScreen splash = SplashScreen.getSplashScreen();
        if (splash == null) {
            System.out.println("SplashScreen.getSplashScreen() returned null");
            return;
        }
        Graphics2D g = splash.createGraphics();
        if (g == null) {
            System.out.println("g is null");
            return;
        }
        
        //renderSplashFrame(g, 0);
        splash.update();
        try {
            Thread.sleep(3000);
        }
        catch(InterruptedException e) {
        }
        splash.close();
        
        NimbusLookAndFeel skin = new NimbusLookAndFeel();
        
        try {
            UIManager.setLookAndFeel(skin);
            Main m = new Main();
            SwingUtilities.updateComponentTreeUI(m);
            m.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void actionPerformed(ActionEvent ae) {
        System.exit(0);
    }
    
    private static WindowListener closeWindow = new WindowAdapter(){
        public void windowClosing(WindowEvent e){
            e.getWindow().dispose();
        }
    };
    
    public static void main (String args[]) {
        Splash test = new Splash();
    }
}
