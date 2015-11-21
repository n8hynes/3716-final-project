package MunSocMan;

import java.awt.EventQueue;

public class MunSocMan {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MunSocManFrame frame = new MunSocManFrame();
                    frame.setVisible(true);
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
