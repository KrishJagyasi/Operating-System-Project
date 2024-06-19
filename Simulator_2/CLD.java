package ClassFiles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import javax.swing.Timer;

public class CLD extends JFrame {
    private JPanel diskPanel, animationPanel;
    private JTextField headPositionField, requestsField;
    private JButton submitButton, animateButton;
    private JTextArea sequenceArea;
    private int diskSize = 1000; // Disk size (track count)
    private int headPosition = 0; // Initial head position
    private List<Integer> requests = new ArrayList<>();
    private List<Integer> servedSequence = new ArrayList<>();

    public CLD() {
        setTitle("C-LOOK Disk Scheduling");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create UI components
        diskPanel = new DiskPanel();
        animationPanel = new JPanel();

        headPositionField = new JTextField();
        requestsField = new JTextField();
        submitButton = new JButton("Submit");
        animateButton = new JButton("Animate");
        animateButton.setEnabled(false);
        sequenceArea = new JTextArea(5, 20);
        sequenceArea.setEditable(false);

        // Add components to the frame
        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.add(new JLabel("Initial Head Position:"));
        inputPanel.add(headPositionField);
        inputPanel.add(new JLabel("Disk Requests:"));
        inputPanel.add(requestsField);
        inputPanel.add(new JLabel());
        inputPanel.add(submitButton);
        inputPanel.add(new JLabel());
        inputPanel.add(animateButton);

        add(diskPanel, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.WEST);
        add(new JScrollPane(sequenceArea), BorderLayout.SOUTH);
        add(animationPanel, BorderLayout.EAST);

        submitButton.addActionListener(new SubmitButtonListener());
        animateButton.addActionListener(new AnimateButtonListener());

        setVisible(true);
    }

    private class DiskPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawDisk(g);
            drawRequests(g);
            drawHeadPosition(g);
        }

        private void drawDisk(Graphics g) {
            int centerX = getWidth() / 2;
            int centerY = getHeight() / 2;
            int radius = Math.min(centerX, centerY) - 50;

            g.setColor(Color.LIGHT_GRAY);
            g.fillOval(centerX - radius, centerY - radius, radius * 2, radius * 2);
        }

        private void drawRequests(Graphics g) {
            int centerX = getWidth() / 2;
            int centerY = getHeight() / 2;
            int radius = Math.min(centerX, centerY) - 50;

            g.setColor(Color.RED);
            for (int request : requests) {
                double angle = (2 * Math.PI * request) / diskSize;
                int x = centerX + (int) (radius * Math.cos(angle));
                int y = centerY + (int) (radius * Math.sin(angle));
                g.fillOval(x - 5, y - 5, 10, 10);
            }
        }

        private void drawHeadPosition(Graphics g) {
            int centerX = getWidth() / 2;
            int centerY = getHeight() / 2;
            int radius = Math.min(centerX, centerY) - 50;

            double angle = (2 * Math.PI * headPosition) / diskSize;
            int x = centerX + (int) (radius * Math.cos(angle));
            int y = centerY + (int) (radius * Math.sin(angle));

            g.setColor(Color.GREEN);
            g.fillOval(x - 10, y - 10, 20, 20);
        }
    }

    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Submit button clicked");
            try {
                headPosition = Integer.parseInt(headPositionField.getText());
                String[] requestsArray = requestsField.getText().split(",");
                requests.clear();
                for (String req : requestsArray) {
                    int reqInt = Integer.parseInt(req.trim());
                    if (reqInt >= 0 && reqInt < diskSize) {
                        requests.add(reqInt);
                    } else {
                        JOptionPane.showMessageDialog(CLD.this, "Invalid request: " + reqInt + ". Requests must be between 0 and " + (diskSize - 1) + ".", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
                performCLookScheduling();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(CLD.this, "Invalid input. Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
                animateButton.setEnabled(false);
            }
        }
    }

    private void performCLookScheduling() {
        List<Integer> sortedRequests = new ArrayList<>(requests);
        sortedRequests.add(headPosition); // Add initial head position to requests
        Collections.sort(sortedRequests);
    
        int minIndex = sortedRequests.indexOf(headPosition);
    
        List<Integer> leftList = new ArrayList<>(sortedRequests.subList(0, minIndex));
        List<Integer> rightList = new ArrayList<>(sortedRequests.subList(minIndex + 1, sortedRequests.size())); // Exclude initial head position
    
        servedSequence.clear();
        servedSequence.add(headPosition); // Add initial head position as the starting point
        servedSequence.addAll(rightList);
        servedSequence.addAll(leftList);
    
        displaySequence();
        animateButton.setEnabled(true);
    
        // Draw timeline and connecting lines in animation panel
        drawTimeline();
    }    

    private void drawTimeline() {
        animationPanel.removeAll();
        animationPanel.setLayout(new GridLayout(0, 1));

        int previousTrack = headPosition;
        for (int track : servedSequence) {
            JPanel rowPanel = new JPanel(new BorderLayout());
            JLabel label = new JLabel("Track " + track);
            label.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
            rowPanel.add(label, BorderLayout.WEST);

            if (track != headPosition) {
                JPanel linePanel = new JPanel() {
                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        g.setColor(Color.BLACK);
                        g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
                    }
                };
                Dimension size = new Dimension(50, 2);
                linePanel.setPreferredSize(size);
                linePanel.setMinimumSize(size);
                linePanel.setMaximumSize(size);
                rowPanel.add(linePanel, BorderLayout.CENTER);

                // Draw arrow
                if (track > previousTrack) {
                    JLabel arrowLabel = new JLabel(">");
                    arrowLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
                    rowPanel.add(arrowLabel, BorderLayout.EAST);
                } else {
                    JLabel arrowLabel = new JLabel("<");
                    arrowLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
                    rowPanel.add(arrowLabel, BorderLayout.EAST);
                }
            }

            animationPanel.add(rowPanel);
            previousTrack = track;
        }

        animationPanel.revalidate();
        animationPanel.repaint();
    }

    private void displaySequence() {
        StringBuilder sequenceBuilder = new StringBuilder("Sequence: ");
        for (int request : servedSequence) {
            sequenceBuilder.append(request).append(" -> ");
        }
        sequenceBuilder.delete(sequenceBuilder.length() - 4, sequenceBuilder.length());
        sequenceArea.setText(sequenceBuilder.toString());
    }

    private class AnimateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            animateHeadMovement();
        }
    }

    private void animateHeadMovement() {
        Timer timer = new Timer(500, new ActionListener() {
            int step = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (step < servedSequence.size()) {
                    headPosition = servedSequence.get(step);
                    diskPanel.repaint(); // Trigger repaint of DiskPanel
                    drawTimeline(); // Update timeline
                    step++;
                } else {
                    ((Timer) e.getSource()).stop();
                    animateButton.setEnabled(false);
                    headPositionField.setText("");
                    requestsField.setText("");
                }
            }
        });
        timer.start();
    }
}
//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(CLD::new);
//     }
// }