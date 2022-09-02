package CTRL;

import java.awt.FlowLayout;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class test1 {

	public static void main(String[] args) {
		customerCTRL cus = new customerCTRL();
		String a = cus.customer();
		System.out.println(a);
		String b = cus.dialogue();
		System.out.println(b);
		JFrame jframe = new JFrame();
		JLabel jLabel = new JLabel();
		jframe.setLayout(new FlowLayout());
		jframe.setBounds(0, 0, 170, 100);

		jframe.add(jLabel);
		jframe.setVisible(true);

		Timer timer = new Timer();

		timer.scheduleAtFixedRate(new TimerTask() {
			int i = 5;

			public void run() {
				jLabel.setText(a+ " : " + i);
				i--;

				if (i < 0) {
					timer.cancel();
					jLabel.setText("이집 별로네...");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
					System.out.println("이집 별로네...");
					jframe.setVisible(false);
					
				}
			}
		}, 0, 1000);
		
	}

}
