package dubowen.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import dubowen.dao.BookTypeDao;
import dubowen.model.BookType;
import dubowen.util.Dbutil;
import dubowen.util.StringUtil;

public class BookTypeAddInterFrm extends JInternalFrame {
	
	private JTextField bookTypeNameTxt;
	private JTextField bookTypeDescTxt;

	private Dbutil dbUtil=new Dbutil();
	private BookTypeDao bookTypeDao=new BookTypeDao();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeAddInterFrm frame = new BookTypeAddInterFrm();
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
	public BookTypeAddInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
		setBounds(100, 100, 450, 300);
		
		JLabel label = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0\uFF1A");
		
		JLabel label_1 = new JLabel("\u56FE\u4E66\u7C7B\u522B\u63CF\u8FF0\uFF1A");
		
		bookTypeNameTxt = new JTextField();
		bookTypeNameTxt.setColumns(10);
		
		bookTypeDescTxt = new JTextField();
		bookTypeDescTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u91CD\u7F6E");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(BookTypeAddInterFrm.class.getResource("/images/reset.png")));
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeAddActionPerformed(e);
				
			}
		});
		button.setIcon(new ImageIcon(BookTypeAddInterFrm.class.getResource("/images/add.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(83)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label)
							.addGap(18)
							.addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(button)
									.addGap(25))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_1)
									.addGap(18)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(118)
									.addComponent(btnNewButton))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(bookTypeDescTxt, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(54, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(68)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(bookTypeDescTxt, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(button))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

		//设置文本域边框
		bookTypeDescTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));
	}
	
	/**
	 * 图书类别添加事件处理
	 * @param e
	 */
	private void bookTypeAddActionPerformed(ActionEvent evt) {
		String bookTypeName=this.bookTypeNameTxt.getText();
		String bookTypeDesc=this.bookTypeDescTxt.getText();
		if(StringUtil.isEmpty(bookTypeName)) {
			JOptionPane.showMessageDialog(null,"图书类别名称不能为空!");
			return;
		}
		BookType bookType=new BookType(bookTypeName,bookTypeDesc);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int n=bookTypeDao.add(con, bookType);
			if(n==1) {
				JOptionPane.showMessageDialog(null, "图书类别添加成功！");
				resetValue();
			}
			else {
				JOptionPane.showMessageDialog(null, "图书类别添加失败！");
			}
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "图书类别添加失败！");
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 重置事件处理
	 * @param e
	 */
	private void resetValueActionPerformed(ActionEvent e) {
		this.resetValue();
	}

	/**
	 * 重置表单
	 */
	private void resetValue() {
	this.bookTypeNameTxt.setText("");
	this.bookTypeDescTxt.setText("");
	}
}
