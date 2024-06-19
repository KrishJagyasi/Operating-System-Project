package ClassFiles;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class OS_Sim{
	JFrame intro_frame;
	JLabel image_label , title_label , intro_label_1 , intro_label_2 , select_algo_label;
	JRadioButton sjf_rb , dps_rb , cld_algo_rb , fifo_pr_algo_rb;
	ButtonGroup rb_group;
	JButton letsgo_btn;
	ImageIcon image_icon;

	private OS_Sim(){
		intro_frame = new JFrame("CPU Processes Scheduling Simulator");
		intro_frame.setSize(1200 , 750);
		intro_frame.setIconImage(new ImageIcon("Images/cpu_icon.png").getImage());
		intro_frame.setLocationRelativeTo(null);
		intro_frame.setLayout(null);
		intro_frame.setResizable(false);
		intro_frame.setVisible(true);
		intro_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		image_icon = new ImageIcon("Images/robot_cartoon_1.png");
        		image_label = new JLabel(image_icon);
		image_label.setBounds(100, 100, image_icon.getIconWidth(), image_icon.getIconHeight());

		title_label = new JLabel("CPU Scheduling Simulator");
		title_label.setBounds(450 , 0 , 750 , 150);
		title_label.setForeground(new Color(0x3c3c3c));
		title_label.setFont(new Font("Berlin Sans FB Demi" , Font.PLAIN , 60));

		intro_label_1 = new JLabel("Welcome to Process Scheduling Simulator,");
		intro_label_1.setBounds(625 , 150 , 425 , 25);
		intro_label_1.setForeground(new Color(0x5b5b5b));
		intro_label_1.setFont(new Font("Berlin Sans FB Demi" , Font.PLAIN , 20));

		intro_label_2 = new JLabel("Simulate the processes using various algorithms.");
		intro_label_2.setBounds(600 , 175 , 500 , 25);
		intro_label_2.setForeground(new Color(0x5b5b5b));
		intro_label_2.setFont(new Font("Berlin Sans FB Demi" , Font.PLAIN , 20));

		select_algo_label = new JLabel("Select Algorithm:");
		select_algo_label.setBounds(675 , 265 , 500 , 35);
		select_algo_label.setForeground(new Color(0x4d4d4d));
		select_algo_label.setFont(new Font("Berlin Sans FB Demi" , Font.PLAIN , 30));

		sjf_rb = new JRadioButton("Shortest Job First (SJF)");
		sjf_rb.setBounds(670 , 310 , 505 , 20);
		sjf_rb.setForeground(new Color(0x5b5b5b));
		sjf_rb.setFont(new Font("Berlin Sans FB Demi" , Font.PLAIN , 20));
		sjf_rb.setFocusable(false);

		dps_rb = new JRadioButton("Dining Philosopher with Semaphore");
		dps_rb.setBounds(670 , 335 , 505 , 20);
		dps_rb.setForeground(new Color(0x5b5b5b));
		dps_rb.setFont(new Font("Berlin Sans FB Demi" , Font.PLAIN , 20));
		dps_rb.setFocusable(false);

		cld_algo_rb = new JRadioButton("C-Look Disk Algorithm");
		cld_algo_rb.setBounds(670 , 360 , 505 , 20);
		cld_algo_rb.setForeground(new Color(0x5b5b5b));
		cld_algo_rb.setFont(new Font("Berlin Sans FB Demi" , Font.PLAIN , 20));
		cld_algo_rb.setFocusable(false);

		fifo_pr_algo_rb = new JRadioButton("First-in First-out Page Replacement");
		fifo_pr_algo_rb.setBounds(670 , 385 , 505 , 20);
		fifo_pr_algo_rb.setForeground(new Color(0x5b5b5b));
		fifo_pr_algo_rb.setFont(new Font("Berlin Sans FB Demi" , Font.PLAIN , 20));
		fifo_pr_algo_rb.setFocusable(false);

		rb_group = new ButtonGroup();
		rb_group.add(sjf_rb);
		rb_group.add(dps_rb);
		rb_group.add(cld_algo_rb);
		rb_group.add(fifo_pr_algo_rb);

		letsgo_btn = new JButton("Let's Go");
		letsgo_btn.setBounds(700 , 450 , 160 , 35);
		letsgo_btn.setForeground(Color.WHITE);
		letsgo_btn.setBackground(new Color(0x5b5b5b));
		letsgo_btn.setFont(new Font("Berlin Sans FB Demi" , Font.PLAIN , 20));
		letsgo_btn.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		letsgo_btn.setFocusable(false);
		
		letsgo_btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(sjf_rb.isSelected()){
					SwingUtilities.invokeLater(new Runnable() {
						public void run(){
							new SJF();
						}
					});
				}else if(dps_rb.isSelected()){
					SwingUtilities.invokeLater(new Runnable() {
						public void run(){
							new DPS();
						}
					});
				}else if(cld_algo_rb.isSelected()){
					SwingUtilities.invokeLater(new Runnable() {
						public void run(){
							new CLD();
						}
					});
				}else if(fifo_pr_algo_rb.isSelected()){
					SwingUtilities.invokeLater(new Runnable() {
						public void run(){
							new FIFO();
						}
					});
				}else{
					JOptionPane.showMessageDialog(intro_frame , "Please select an Algorithm.");
				}
			}
		});

		intro_frame.add(image_label);
		intro_frame.add(title_label);
		intro_frame.add(intro_label_1);	
		intro_frame.add(intro_label_2);
		intro_frame.add(select_algo_label);
		intro_frame.add(sjf_rb);
		intro_frame.add(dps_rb);
		intro_frame.add(cld_algo_rb);
		intro_frame.add(fifo_pr_algo_rb);
		intro_frame.add(letsgo_btn);
	}

	public static void main(String [] args){
		SwingUtilities.invokeLater(new Runnable() {
        			public void run() {
            			new OS_Sim();
        			}
    		});
	}
}