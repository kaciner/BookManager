package dubowen.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;

public class InterFrm extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterFrm frame = new InterFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterFrm() {
		getContentPane().setBackground(Color.WHITE);
		
		JLabel label = new JLabel("\u675C\u535A\u95FB");
		label.setIcon(new ImageIcon(InterFrm.class.getResource("/images/user_16px_28326_easyicon.net.png")));
		
		JLabel label_1 = new JLabel("\u8F6F\u4EF616-5\u73ED");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(124)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addContainerGap(234, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(66)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(label)
					.addContainerGap(165, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		setIconifiable(true);
		setClosable(true);
		setTitle("\u4F5C\u8005\uFF1A\u675C\u535A\u95FB");
		setBounds(100, 100, 450, 300);

	}

}
