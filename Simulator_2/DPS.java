package ClassFiles;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import java.util.Timer;

public class DPS extends JFrame {
	private JPanel contentPane;
	private ArrayList<JLabel> forkLabelList = new ArrayList<>();
	private ArrayList<JLabel> philosopherLabelList = new ArrayList<>();
	private ArrayList<JProgressBar> progressBars = new ArrayList<>();
	private ArrayList<JLabel> zzzList = new ArrayList<>();
	private ArrayList<JLabel> finishedList = new ArrayList<>();
	private DiningApp diningApp;

	public DPS() {
		setTitle("Dining Philosopher with Semaphore");
		diningApp = new DiningApp();
        
        setVisible(true);
		
		setSize(969, 660);
        setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblPhilosopher_1 = new JLabel("Philosopher 1");
		lblPhilosopher_1.setOpaque(true);
		lblPhilosopher_1.setForeground(Color.WHITE);
		lblPhilosopher_1.setBackground(Color.BLACK);
		lblPhilosopher_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhilosopher_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPhilosopher_1.setBounds(543, 206, 115, 70);
		philosopherLabelList.add(lblPhilosopher_1);
		contentPane.add(lblPhilosopher_1);
		
		JLabel lblPhilosopher_2 = new JLabel("Philosopher 2");
		lblPhilosopher_2.setOpaque(true);
		lblPhilosopher_2.setForeground(Color.WHITE);
		lblPhilosopher_2.setBackground(Color.BLACK);
		lblPhilosopher_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhilosopher_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPhilosopher_2.setBounds(590, 402, 115, 70);
		philosopherLabelList.add(lblPhilosopher_2);
		contentPane.add(lblPhilosopher_2);
		
		JLabel lblPhilosopher_3 = new JLabel("Philosopher 3");
		lblPhilosopher_3.setOpaque(true);
		lblPhilosopher_3.setForeground(Color.WHITE);
		lblPhilosopher_3.setBackground(Color.BLACK);
		lblPhilosopher_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhilosopher_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPhilosopher_3.setBounds(410, 501, 115, 71);
		philosopherLabelList.add(lblPhilosopher_3);
		contentPane.add(lblPhilosopher_3);
		
		JLabel lblPhilosopher_4 = new JLabel("Philosopher 4");
		lblPhilosopher_4.setOpaque(true);
		lblPhilosopher_4.setForeground(Color.WHITE);
		lblPhilosopher_4.setBackground(Color.BLACK);
		lblPhilosopher_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhilosopher_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPhilosopher_4.setBounds(213, 402, 115, 70);
		philosopherLabelList.add(lblPhilosopher_4);
		contentPane.add(lblPhilosopher_4);
		
		JLabel lblPhilosopher = new JLabel("Philosopher 5");
		lblPhilosopher.setOpaque(true);
		lblPhilosopher.setBackground(Color.BLACK);
		lblPhilosopher.setForeground(Color.WHITE);
		lblPhilosopher.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhilosopher.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPhilosopher.setBounds(257, 206, 115, 70);
		philosopherLabelList.add(lblPhilosopher);
		contentPane.add(lblPhilosopher);
		
		JLabel lblFork_1 = new JLabel("fork 1");
		lblFork_1.setBackground(new Color(205, 92, 92));
		lblFork_1.setOpaque(true);
		lblFork_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblFork_1.setBounds(571, 310, 66, 27);
		forkLabelList.add(lblFork_1);
		contentPane.add(lblFork_1);
		
		JLabel lblFork_2 = new JLabel("fork 2");
		lblFork_2.setBackground(new Color(205, 92, 92));
		lblFork_2.setOpaque(true);
		lblFork_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblFork_2.setBounds(504, 463, 66, 27);
		forkLabelList.add(lblFork_2);
		contentPane.add(lblFork_2);
		
		JLabel lblFork_3 = new JLabel("fork 3");
		lblFork_3.setBackground(new Color(205, 92, 92));
		lblFork_3.setOpaque(true);
		lblFork_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblFork_3.setBounds(346, 463, 66, 27);
		forkLabelList.add(lblFork_3);
		contentPane.add(lblFork_3);
		
		JLabel lblFork_4 = new JLabel("fork 4");
		lblFork_4.setBackground(new Color(205, 92, 92));
		lblFork_4.setOpaque(true);
		lblFork_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblFork_4.setBounds(306, 316, 66, 27);
		forkLabelList.add(lblFork_4);
		contentPane.add(lblFork_4);
		
		JLabel lblFork_5 = new JLabel("fork 5");
		lblFork_5.setBackground(new Color(205, 92, 92));
		lblFork_5.setOpaque(true);
		lblFork_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblFork_5.setBounds(425, 228, 66, 27);
		forkLabelList.add(lblFork_5);
		contentPane.add(lblFork_5);
		
		JProgressBar progressBar_1 = new JProgressBar();
		progressBar_1.setMaximum(50);
		progressBar_1.setBounds(630, 173, 146, 22);
		progressBars.add(progressBar_1);
		contentPane.add(progressBar_1);
		
		JProgressBar progressBar_2 = new JProgressBar();
		progressBar_2.setMaximum(50);
		progressBar_2.setBounds(630, 369, 146, 22);
		progressBars.add(progressBar_2);
		contentPane.add(progressBar_2);
		
		JProgressBar progressBar_3 = new JProgressBar();
		progressBar_3.setMaximum(50);
		progressBar_3.setBounds(397, 583, 146, 22);
		progressBars.add(progressBar_3);
		contentPane.add(progressBar_3);
		
		JProgressBar progressBar_4 = new JProgressBar();
		progressBar_4.setMaximum(50);
		progressBar_4.setBounds(102, 369, 146, 22);
		progressBars.add(progressBar_4);
		contentPane.add(progressBar_4);
		
		JProgressBar progressBar_5 = new JProgressBar();
		progressBar_5.setMaximum(50);
		progressBar_5.setBounds(158, 173, 146, 22);
		progressBars.add(progressBar_5);
		contentPane.add(progressBar_5);
		
		JTextArea txtrObserveTheDining = new JTextArea();
		txtrObserveTheDining.setEditable(false);
		txtrObserveTheDining.setFont(new Font("Dialog", Font.BOLD, 13));
		txtrObserveTheDining.setLineWrap(true);
        txtrObserveTheDining.setFocusable(false);
		txtrObserveTheDining.setText("- 5 philosophers sit on a table.\r\n- There are only 5 forks on the table.\r\n- They are all hungry & want to eat.\r\n- They can only eat when the fork to the left & right of them are both available.\r\n- After eating for a period, they then take a quick snooze before trying to eat again.\r\n- Using the sychronized key word to check if a Fork is available or not.");
		txtrObserveTheDining.setBounds(40, 11, 843, 141);
		contentPane.add(txtrObserveTheDining);
		
		JLabel lblZzz1 = new JLabel("zzz...");
		lblZzz1.setVisible(false);
		lblZzz1.setBounds(668, 206, 46, 14);
		zzzList.add(lblZzz1);
		contentPane.add(lblZzz1);
		
		JLabel lblZzz2 = new JLabel("zzz...");
		lblZzz2.setVisible(false);
		lblZzz2.setBounds(715, 402, 46, 14);
		zzzList.add(lblZzz2);
		contentPane.add(lblZzz2);
		
		JLabel lblZzz3 = new JLabel("zzz...");
		lblZzz3.setVisible(false);
		lblZzz3.setBounds(535, 501, 46, 14);
		zzzList.add(lblZzz3);
		contentPane.add(lblZzz3);
		
		JLabel lblZzz4 = new JLabel("zzz...");
		lblZzz4.setVisible(false);
		lblZzz4.setBounds(337, 402, 46, 14);
		zzzList.add(lblZzz4);
		contentPane.add(lblZzz4);
		
		JLabel lblZzz5 = new JLabel("zzz...");
		lblZzz5.setVisible(false);
		lblZzz5.setBounds(382, 206, 46, 14);
		zzzList.add(lblZzz5);
		contentPane.add(lblZzz5);
		
		JLabel lblFinishedEating1 = new JLabel("Finished eating.");
		lblFinishedEating1.setOpaque(true);
		lblFinishedEating1.setVisible(false);
		lblFinishedEating1.setBackground(new Color(255, 20, 147));
		lblFinishedEating1.setBounds(668, 235, 108, 20);
		finishedList.add(lblFinishedEating1);
		contentPane.add(lblFinishedEating1);
		
		JLabel lblFinishedEating2 = new JLabel("Finished eating.");
		lblFinishedEating2.setOpaque(true);
		lblFinishedEating2.setVisible(false);
		lblFinishedEating2.setBackground(new Color(255, 20, 147));
		lblFinishedEating2.setBounds(712, 431, 108, 20);
		finishedList.add(lblFinishedEating2);
		contentPane.add(lblFinishedEating2);
		
		JLabel lblFinishedEating3 = new JLabel("Finished eating.");
		lblFinishedEating3.setOpaque(true);
		lblFinishedEating3.setVisible(false);
		lblFinishedEating3.setBackground(new Color(255, 20, 147));
		lblFinishedEating3.setBounds(529, 530, 108, 20);
		finishedList.add(lblFinishedEating3);
		contentPane.add(lblFinishedEating3);
		
		JLabel lblFinishedEating4 = new JLabel("Finished eating.");
		lblFinishedEating4.setOpaque(true);
		lblFinishedEating4.setVisible(false);
		lblFinishedEating4.setBackground(new Color(255, 20, 147));
		lblFinishedEating4.setBounds(102, 431, 108, 20);
		finishedList.add(lblFinishedEating4);
		contentPane.add(lblFinishedEating4);
		
		JLabel lblFinishedEating5 = new JLabel("Finished eating.");
		lblFinishedEating5.setOpaque(true);
		lblFinishedEating5.setVisible(false);
		lblFinishedEating5.setBackground(new Color(255, 20, 147));
		lblFinishedEating5.setBounds(139, 235, 108, 20);
		finishedList.add(lblFinishedEating5);
		contentPane.add(lblFinishedEating5);
		
		startDining();
	}

	private void startDining() {
		diningApp.start();
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				for(Philosopher philosopher : diningApp.getPhilosophers()){
					if(!philosopher.isFinished()){
						updateGui();
					}
					else {
						timeForBed(philosopher);
					}
				}
			}
		}, 2000, 1000);
	}

	protected void timeForBed(Philosopher philosopher) {
		switch (philosopher.getName()) {
		case "Philosopher: 1":
			finishedList.get(0).setVisible(true);
			break;
		case "Philosopher: 2":
			finishedList.get(1).setVisible(true);
			break;
		case "Philosopher: 3":
			finishedList.get(2).setVisible(true);
			break;
		case "Philosopher: 4":
			finishedList.get(3).setVisible(true);
			break;
		case "Philosopher: 5":
			finishedList.get(4).setVisible(true);
			break;
		default:
			break;
		}
	}

	private void updateGui() {
		int philosopherCounter = 0;
		for(Philosopher philosopher : diningApp.getPhilosophers()){
			progressBars.get(philosopherCounter).setValue(philosopher.getAmountEaten());
			++philosopherCounter;
		}
		setPhilosopherColour();
		checkIfSnoozing();
	}

	private void checkIfSnoozing() {
		for(Philosopher philosopher : diningApp.getPhilosophers()){
			if(philosopher.isSnoozing()){
				putToSleep(philosopher);
			}else {
				wakeUp(philosopher);
			}
		}
	}

	private void wakeUp(Philosopher philosopher) {
		switch (philosopher.getName()) {
		case "Philosopher: 1":
			zzzList.get(0).setVisible(false);
			break;
		case "Philosopher: 2":
			zzzList.get(1).setVisible(false);
			break;
		case "Philosopher: 3":
			zzzList.get(2).setVisible(false);
			break;
		case "Philosopher: 4":
			zzzList.get(3).setVisible(false);
			break;
		case "Philosopher: 5":
			zzzList.get(4).setVisible(false);
			break;
		default:
			break;
		}
	}

	private void putToSleep(Philosopher philosopher) {
		switch (philosopher.getName()) {
		case "Philosopher: 1":
			zzzList.get(0).setVisible(true);
			break;
		case "Philosopher: 2":
			zzzList.get(1).setVisible(true);
			break;
		case "Philosopher: 3":
			zzzList.get(2).setVisible(true);
			break;
		case "Philosopher: 4":
			zzzList.get(3).setVisible(true);
			break;
		case "Philosopher: 5":
			zzzList.get(4).setVisible(true);
			break;
		default:
			break;
		}
	}

	private void setPhilosopherColour() {
		for(Philosopher philosopher : diningApp.getPhilosophers()){
			if(philosopher.isEating()){
				changeColourToGreen(philosopher);
			}else {
				changeColourToBlack(philosopher);
			}
		}
	}

	private void changeColourToBlack(Philosopher philosopher) {
		switch (philosopher.getName()) {
		case "Philosopher: 1":
			philosopherLabelList.get(0).setBackground(Color.BLACK);
			break;
		case "Philosopher: 2":
			philosopherLabelList.get(1).setBackground(Color.BLACK);
			break;
		case "Philosopher: 3":
			philosopherLabelList.get(2).setBackground(Color.BLACK);
			break;
		case "Philosopher: 4":
			philosopherLabelList.get(3).setBackground(Color.BLACK);
			break;
		case "Philosopher: 5":
			philosopherLabelList.get(4).setBackground(Color.BLACK);
			break;
		default:
			break;
		}
	}

	private void changeColourToGreen(Philosopher philosopher) {
		switch (philosopher.getName()) {
		case "Philosopher: 1":
			philosopherLabelList.get(0).setBackground(Color.GREEN);
			break;
		case "Philosopher: 2":
			philosopherLabelList.get(1).setBackground(Color.GREEN);
			break;
		case "Philosopher: 3":
			philosopherLabelList.get(2).setBackground(Color.GREEN);
			break;
		case "Philosopher: 4":
			philosopherLabelList.get(3).setBackground(Color.GREEN);
			break;
		case "Philosopher: 5":
			philosopherLabelList.get(4).setBackground(Color.GREEN);
			break;
		default:
			break;
		}
	}
}

class DiningApp {
	private DiningTable diningTable;
	private ArrayList<Fork> forkList;
	private ArrayList<Philosopher> philosophers;
	
	public void start() {
		diningTable = new DiningTable();
		forkList = diningTable.getForks();
		philosophers = diningTable.getDiners();
		addForks();
		// System.out.println(forkList);
		addDiners();
		// System.out.println(philosophers);
		startDining();
	}

	private void startDining() {
		Thread diner1 = new Thread(philosophers.get(0));
		Thread diner2 = new Thread(philosophers.get(1));
		Thread diner3 = new Thread(philosophers.get(2));
		Thread diner4 = new Thread(philosophers.get(3));
		Thread diner5 = new Thread(philosophers.get(4));
		diner1.start();
		diner2.start();
		diner3.start();
		diner4.start();
		diner5.start();
	}

	private void addDiners() {
		int rightFork = 4;
		for(int i = 0; i < 5; ++i){
			if(i == 1){
				rightFork = 0;
			}else if (i == 2) {
				rightFork = 1;
			}else if (i == 3) {
				rightFork = 2;
			}else if (i == 4) {
				rightFork = 3;
			}
			philosophers.add(new Philosopher(i + 1, forkList.get(i), forkList.get(rightFork)));
		}
	}

	private void addForks() {
		for(int i = 0; i < 5; ++i){
			forkList.add(new Fork(i + 1));
		}
	}

	public ArrayList<Philosopher> getPhilosophers() {
		return philosophers;
	}

	public void setPhilosophers(ArrayList<Philosopher> philosophers) {
		this.philosophers = philosophers;
	}

	public ArrayList<Fork> getForkList() {
		return forkList;
	}

	public void setForkList(ArrayList<Fork> forkList) {
		this.forkList = forkList;
	}	
}

class DiningTable {
	private ArrayList<Philosopher> diners = new ArrayList<>();
	private ArrayList<Fork> forks = new ArrayList<>();
	
	public ArrayList<Philosopher> getDiners() {
		return diners;
	}
	public void setDiners(ArrayList<Philosopher> diners) {
		this.diners = diners;
	}
	public ArrayList<Fork> getForks() {
		return forks;
	}
	public void setForks(ArrayList<Fork> forks) {
		this.forks = forks;
	}
}

class Fork {
	private boolean isAvailable = true;
	private int id;

	public Fork(int id) {
		super();
		this.id = id;
	}

	public synchronized boolean isAvailable() {
		return isAvailable;
	}

	public synchronized void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	public String toString(){
		return id + "";
	}
}

class Philosopher implements Runnable{
	private boolean isEating;
	private boolean hasLeftFork;
	private boolean hasRightFork;
	private int amountEaten;
	private boolean isFinished;
	private boolean isSnoozing;
	private String name;
	private ArrayList<Fork> forks = new ArrayList<>();
	
	public Philosopher(int name, Fork leftFork, Fork rightFork) {
		super();
		this.name = "Philosopher: " + name;
		forks.add(leftFork);
		forks.add(rightFork);
	}

	public synchronized boolean isSnoozing() {
		return isSnoozing;
	}

	public synchronized void setSnoozing(boolean isSnoozing) {
		this.isSnoozing = isSnoozing;
	}

	public synchronized boolean isEating() {
		return isEating;
	}

	public synchronized void setEating(boolean isEating) {
		this.isEating = isEating;
	}

	public synchronized boolean hasLeftFork() {
		return hasLeftFork;
	}

	public synchronized boolean isFinished() {
		return isFinished;
	}

	public synchronized void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}

	public synchronized void hasLeftFork(boolean hasLeftFork) {
		this.hasLeftFork = hasLeftFork;
	}
	
	public synchronized boolean hasRightFork() {
		return hasRightFork;
	}

	public synchronized void hasRightFork(boolean hasRightFork) {
		this.hasRightFork = hasRightFork;
	}

	public int getAmountEaten() {
		return amountEaten;
	}

	public void setAmountEaten(int amountEaten) {
		this.amountEaten = amountEaten;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		while (amountEaten < 51) {
			checkIfLeftForkAvailable();
			if(hasLeftFork)checkIfRightForkAvailable();
			if (hasLeftFork && hasRightFork) {
				isEating = true;
				startEating();
			} else{
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		isFinished = true;
	}

	private void startEating() {
		for(int i = 0; i < 10; ++i){
			++amountEaten;
			// System.out.println(this.name + " is now eating, amount is now: " + amountEaten);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for(Fork fork : forks){
			fork.setAvailable(true);
		}
		isEating = false;
		try {
			isSnoozing = true;
			Thread.sleep(5000);
			isSnoozing = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void checkIfRightForkAvailable() {
		// System.out.println(this.name + " checking if right fork available");
		if(forks.get(1).isAvailable()){
			hasRightFork = true;
			forks.get(1).setAvailable(false);
			// System.out.println(this.name + "right fork is available & now setting it to: " + forks.get(1).isAvailable());
			return;
		}
		// System.out.println(this.name + "right fork was not available & status is: " + forks.get(1).isAvailable());
		forks.get(0).setAvailable(true);
		hasRightFork = false;
		hasLeftFork = false;
	}

	private void checkIfLeftForkAvailable() {
		// System.out.println(this.name + " checking if left fork available");
		if(forks.get(0).isAvailable()){
			hasLeftFork = true;
			forks.get(0).setAvailable(false);
			// System.out.println(this.name + ": left fork is available & now setting it to: " + forks.get(0).isAvailable());
			return;
		}
		// System.out.println(this.name + ": left fork was not available & status is: " + forks.get(0).isAvailable());
		hasLeftFork = false;
	}
	
	public String toString(){
		return name + " has forks " + forks;
	}
}