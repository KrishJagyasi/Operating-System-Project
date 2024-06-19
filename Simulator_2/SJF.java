package ClassFiles;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.util.*;

class Process {
    int id;
    int arrivalTime;
    int burstTime;
    int finishTime;
    int turnaroundTime;
    int waitingTime;

    public Process(int id, int arrivalTime, int burstTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }
}

public class SJF {
    JFrame sjf_frame;
    JLabel pid_label , arrival_label , burst_label , gantt_chart_label , start_process_label , average_tat_label , average_wt_label;
    JButton add_btn , update_btn , delete_btn , simulate_btn;
    JTextField pid_field , arrival_field , burst_field;
    JTable process_table;
    DefaultTableModel tm;
    JPanel table_panel;
    LinkedList<JLabel> gantt_chart_labels;

    int new_row_pos = 0;
    
    public SJF(){
        sjf_frame = new JFrame("SJF Scheduling Algorithm");
        sjf_frame.setSize(1200 , 750);
		sjf_frame.setIconImage(new ImageIcon("Images/cpu_icon.png").getImage());
		sjf_frame.setLocationRelativeTo(null);
        sjf_frame.setLayout(null);
		sjf_frame.setResizable(false);
		sjf_frame.setVisible(true);

        pid_label = new JLabel("Process ID:");
        arrival_label = new JLabel("Arrival time:");
        burst_label = new JLabel("Burst time:");
        pid_label.setBounds(100 , 30 , 150 , 40);
        pid_label.setFont(new Font("Berlin Sans FB Demi" , Font.PLAIN , 20));
        arrival_label.setBounds(300 , 30 , 150 , 40);
        arrival_label.setFont(new Font("Berlin Sans FB Demi" , Font.PLAIN , 20));
        burst_label.setBounds(500 , 30 , 150 , 40);
        burst_label.setFont(new Font("Berlin Sans FB Demi" , Font.PLAIN , 20));

        pid_field = new JTextField();
        pid_field.setBounds(100 , 65 , 100 , 25);
        pid_field.setFont(new Font("Sans Serif" , Font.BOLD , 14));

        arrival_field = new JTextField();
        arrival_field.setBounds(300 , 65 , 100 , 25);
        arrival_field.setFont(new Font("Sans Serif" , Font.BOLD , 14));

        burst_field = new JTextField();
        burst_field.setBounds(500 , 65 , 100 , 25);
        burst_field.setFont(new Font("Sans Serif" , Font.BOLD , 14));

        add_btn = new JButton("Add");
        add_btn.setBounds(700 , 45 , 100 , 40);
        add_btn.setForeground(Color.WHITE);
		add_btn.setBackground(new Color(0x5b5b5b));
		add_btn.setFont(new Font("Berlin Sans FB Demi" , Font.PLAIN , 20));
		add_btn.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		add_btn.setFocusable(false);

        update_btn = new JButton("Update");
        update_btn.setBounds(850 , 45 , 100 , 40);
        update_btn.setForeground(Color.WHITE);
		update_btn.setBackground(new Color(0x5b5b5b));
		update_btn.setFont(new Font("Berlin Sans FB Demi" , Font.PLAIN , 20));
		update_btn.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		update_btn.setFocusable(false);

        delete_btn = new JButton("Delete");
        delete_btn.setBounds(1000 , 45 , 100 , 40);
        delete_btn.setForeground(Color.WHITE);
		delete_btn.setBackground(new Color(0x5b5b5b));
		delete_btn.setFont(new Font("Berlin Sans FB Demi" , Font.PLAIN , 20));
		delete_btn.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		delete_btn.setFocusable(false);

        simulate_btn = new JButton("Simulate");
        simulate_btn.setBounds(525 , 350 , 150 , 40);
        simulate_btn.setForeground(Color.WHITE);
		simulate_btn.setBackground(new Color(0x5b5b5b));
		simulate_btn.setFont(new Font("Berlin Sans FB Demi" , Font.PLAIN , 20));
		simulate_btn.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		simulate_btn.setFocusable(false);

        gantt_chart_label = new JLabel("Gantt Chart:");
        gantt_chart_label.setBounds(100 , 400 , 150 , 30);
        gantt_chart_label.setFont(new Font("Berlin Sans FB Demi" , Font.PLAIN , 25));
        gantt_chart_label.setVisible(false);

        gantt_chart_labels = new LinkedList<>();

        start_process_label = new JLabel();
        start_process_label.setBounds(85 , 500 , 30 , 20);
        start_process_label.setFont(new Font("Sans Serif" , Font.BOLD , 12));
        start_process_label.setHorizontalAlignment(SwingConstants.CENTER);
        start_process_label.setVerticalAlignment(SwingConstants.CENTER);
        start_process_label.setForeground(Color.BLACK);
        start_process_label.setVisible(false);

        average_tat_label = new JLabel();
        average_tat_label.setBounds(100 , 560 , 300 , 30);
        average_tat_label.setFont(new Font("Dialog" , Font.BOLD , 16));

        average_wt_label = new JLabel();
        average_wt_label.setBounds(100 , 590 , 300 , 30);
        average_wt_label.setFont(new Font("Dialog" , Font.BOLD , 16));

        Object data[][] = {};
        String column_name[] = {"Process" , "Arrival time" , "Burst time" , "Finish time" , "Turnaround time" , "Waiting time"};

        tm = new DefaultTableModel(data , column_name);
        process_table = new JTable(tm);
        process_table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        for(int i=0 ; i<6 ; i++){
            process_table.getColumnModel().getColumn(i).setPreferredWidth(133);
        }
        process_table.getTableHeader().setFont(new Font("Berlin Sans FB Demi" , Font.PLAIN , 16));
        process_table.getTableHeader().setPreferredSize(new Dimension(133 , 35));
        process_table.setFont(new Font("Sans Serif" , Font.BOLD , 14));
        process_table.setRowHeight(22);
        process_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        table_panel = new JPanel();
        table_panel.setBounds(200 , 130 , 801 , 205);
        JScrollPane table_pane = new JScrollPane(process_table);
        table_pane.setPreferredSize(new Dimension(801, 200));
        table_panel.add(table_pane);

        process_table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedRow = process_table.getSelectedRow();
                if (selectedRow != -1) {
                    pid_field.setText(String.valueOf(process_table.getValueAt(selectedRow, 0)));
                    arrival_field.setText(String.valueOf(process_table.getValueAt(selectedRow, 1)));
                    burst_field.setText(String.valueOf(process_table.getValueAt(selectedRow, 2)));
                }
            }
        });

        add_btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(!pid_field.getText().trim().isEmpty() && !arrival_field.getText().trim().isEmpty() && !burst_field.getText().trim().isEmpty()){
                    int pid = Integer.parseInt(pid_field.getText().toString());
                    int arr_time = Integer.parseInt(arrival_field.getText().toString());
                    int burst_time = Integer.parseInt(burst_field.getText().toString());

                    tm.insertRow(new_row_pos , new Object [] {pid , arr_time , burst_time});
                    new_row_pos++;
                    pid_field.setText(null);
                    arrival_field.setText(null);
                    burst_field.setText(null);
                }else{
                    JOptionPane.showMessageDialog(sjf_frame , "All fields are mandatory.");
                }
            }
        });

        update_btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int selectedRow = process_table.getSelectedRow();
                if(selectedRow != -1){
                    if(!pid_field.getText().trim().isEmpty() && !arrival_field.getText().trim().isEmpty() && !burst_field.getText().trim().isEmpty()){
                        int pid = Integer.parseInt(pid_field.getText().toString());
                        int arr_time = Integer.parseInt(arrival_field.getText().toString());
                        int burst_time = Integer.parseInt(burst_field.getText().toString());

                        tm.setValueAt(pid, selectedRow, 0);
                        tm.setValueAt(arr_time, selectedRow, 1);
                        tm.setValueAt(burst_time, selectedRow, 2);

                        pid_field.setText(null);
                        arrival_field.setText(null);
                        burst_field.setText(null);
                    }else{
                        JOptionPane.showMessageDialog(sjf_frame , "All fields are mandatory.");
                    }
                }else{
                    JOptionPane.showMessageDialog(sjf_frame , "Please select a row to update.");
                }
            }
        });

        delete_btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int selectedRow = process_table.getSelectedRow();
                if(selectedRow != -1){
                    tm.removeRow(selectedRow);
                    new_row_pos--;
                }else{
                    JOptionPane.showMessageDialog(sjf_frame , "Please select a row to delete.");
                }
            }
        });

        simulate_btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(new_row_pos != 0){
                    Process[] processes = new Process[new_row_pos];
                    for(int i=0 ; i<new_row_pos ; i++){
                        processes[i] = new Process(
                            Integer.parseInt(process_table.getValueAt(i, 0).toString()),
                            Integer.parseInt(process_table.getValueAt(i, 1).toString()),
                            Integer.parseInt(process_table.getValueAt(i, 2).toString())
                            );
                    }

                    Arrays.sort(processes, new Comparator<Process>() {
                        @Override
                        public int compare(Process p1, Process p2) {
                            return Integer.compare(p1.arrivalTime, p2.arrivalTime);
                        }
                    });
                    gantt_chart_label.setVisible(true);
                    start_process_label.setVisible(true);
                    calculateTimes(processes);
                    drawGanttChart(processes);
                }else{
                    JOptionPane.showMessageDialog(sjf_frame , "No processes to simulate.");
                }
            }
        });

        sjf_frame.add(table_panel);
        sjf_frame.add(pid_label);
        sjf_frame.add(arrival_label);
        sjf_frame.add(burst_label); 
        sjf_frame.add(pid_field);
        sjf_frame.add(arrival_field);
        sjf_frame.add(burst_field);
        sjf_frame.add(add_btn);
        sjf_frame.add(update_btn);
        sjf_frame.add(delete_btn);
        sjf_frame.add(simulate_btn);
        sjf_frame.add(gantt_chart_label);
        sjf_frame.add(average_tat_label);
        sjf_frame.add(average_wt_label);
        sjf_frame.add(start_process_label);
    }

    private void calculateTimes(Process[] processes) {
        boolean[] completed = new boolean[processes.length];
        int currentTime = 0;
        int completedProcesses = 0;
        Arrays.fill(completed, false);

        while (completedProcesses < processes.length) {
            int shortestJob = -1;
            int shortestTime = Integer.MAX_VALUE;

            for (int i = 0; i < processes.length; i++) {
                if (!completed[i] && processes[i].arrivalTime <= currentTime && processes[i].burstTime < shortestTime) {
                    shortestTime = processes[i].burstTime;
                    shortestJob = i;
                }
            }

            if (shortestJob == -1) {
                currentTime++;
            } else {
                Process currentProcess = processes[shortestJob];
                currentProcess.finishTime = currentTime + currentProcess.burstTime;
                currentProcess.turnaroundTime = currentProcess.finishTime - currentProcess.arrivalTime;
                currentProcess.waitingTime = currentProcess.turnaroundTime - currentProcess.burstTime;

                completed[shortestJob] = true;
                currentTime += currentProcess.burstTime;
                completedProcesses++;
            }
        }

        for (int i = 0; i < processes.length; i++) {
            tm.setValueAt(processes[i].id, i, 0);
            tm.setValueAt(processes[i].arrivalTime, i, 1);
            tm.setValueAt(processes[i].burstTime, i, 2);
            tm.setValueAt(processes[i].finishTime, i, 3);
            tm.setValueAt(processes[i].turnaroundTime, i, 4);
            tm.setValueAt(processes[i].waitingTime, i, 5);
        }
    }

    private void drawGanttChart(Process processes[]){
        if (processes.length > 0) {
            for (JLabel label : gantt_chart_labels) {
                sjf_frame.remove(label);
            }
            gantt_chart_labels.clear();

            int total_burst_time = 0 , label_start_pos = 100;
            double multiplier = 60;
            for(Process process : processes){
                total_burst_time += process.burstTime;
            }

            if(total_burst_time > 15){
                multiplier = 30;
            }
            if(total_burst_time > 30){
                multiplier = 15;
            }
            if(total_burst_time > 60){
                multiplier = 8;
            }
            if(total_burst_time > 125){
                multiplier = 4;
            }
            if(total_burst_time > 250){
                multiplier = 2;
            }
            if(total_burst_time > 500){
                multiplier = 1;
            }
            if(total_burst_time > 1000){
                multiplier = 0.5;
            }

            start_process_label.setText(String.valueOf(processes[0].arrivalTime));
            
            Arrays.sort(processes, new Comparator<Process>() {
                @Override
                public int compare(Process p1, Process p2) {
                    return Integer.compare(p1.finishTime, p2.finishTime);
                }
            });

            for(int i=0 ; i<processes.length ; i++){
                String pname = "P" + processes[i].id;
                JLabel label = new JLabel(pname);
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setVerticalAlignment(SwingConstants.CENTER);
                label.setBounds(label_start_pos , 450 , (int) Math.round(multiplier*processes[i].burstTime) , 50);
                label.setFont(new Font("Sans Serif" , Font.BOLD , 14));
                label.setForeground(Color.WHITE);
                label.setBackground(getRandomColor());
                label.setOpaque(true);
                gantt_chart_labels.add(label);

                JLabel label_finish_time = new JLabel(processes[i].finishTime + "");
                label_finish_time.setHorizontalAlignment(SwingConstants.CENTER);
                label_finish_time.setVerticalAlignment(SwingConstants.CENTER);
                label_finish_time.setBounds(label_start_pos + (int) Math.round(multiplier*processes[i].burstTime) - 15 , 500 , 30 , 20);
                label_finish_time.setFont(new Font("Sans Serif" , Font.BOLD , 12));
                label_finish_time.setForeground(Color.BLACK);
                label_finish_time.setOpaque(true);
                gantt_chart_labels.add(label_finish_time);

                label_start_pos += (int) Math.round(multiplier*processes[i].burstTime);
                sjf_frame.add(label);
                sjf_frame.add(label_finish_time);
            }
            sjf_frame.repaint();

            calculateAverageTimes(processes);
        }
    }

    private void calculateAverageTimes(Process processes[]){
        double average_tat = 0 , average_wt = 0;
        for(Process process : processes){
            average_tat += process.turnaroundTime;
            average_wt += process.waitingTime;
        }
        average_tat /= processes.length;
        average_wt /= processes.length;

        average_tat_label.setText("Average Turn Around Time: " + String.format("%.2f", average_tat));
        average_wt_label.setText("Average Waiting Time: " + String.format("%.2f", average_wt));
    }

    private Color getRandomColor() {
        int minBrightness = 64;

        int r = (int) (Math.random() * (256 - minBrightness));
        int g = (int) (Math.random() * (256 - minBrightness));
        int b = (int) (Math.random() * (256 - minBrightness));
    
        return new Color(r, g, b);
    }
}
