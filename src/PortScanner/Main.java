package PortScanner;

import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main extends JFrame {

    private javax.swing.JPanel jContentPane = null;
    private JPanel inputPanel = null;
    private JPanel outputPanel = null;
    private JScrollPane jScrollPane = null;
    private JTextArea taOutput = null;
    private JButton btnClearOutput = null;
    private JTextField tfHost = null;
    private JButton btnScan = null;
    private JLabel lblHost = null;
    private JLabel lblStatus = null;
    private JButton btnStop = null;
    private JPanel hostPanel = null;
    private JPanel portPanel = null;
    private JPanel priorityPanel = null;
    private JLabel lblPriority = null;
    private JComboBox cbPriority = null;
    private JPanel controlPanel = null;
    private JTextField tfStartPort = null;
    private JTextField tfEndPort = null;
    private JLabel lblStartPort = null;
    private JLabel lblEndPort = null;
    private ServiceThread t;

    private JPanel getInputPanel() {
        if (inputPanel == null) {
            GridLayout gridLayout1 = new GridLayout();
            lblHost = new JLabel();
            inputPanel = new JPanel();
            inputPanel.setLayout(gridLayout1);
            lblHost.setText("Host name or IP Address:");
            gridLayout1.setRows(4);
            inputPanel.add(getHostPanel(), null);
            inputPanel.add(getPortPanel(), null);
            inputPanel.add(getPriorityPanel(), null);
            inputPanel.add(getControlPanel(), null);
        }
        return inputPanel;
    }

    private JPanel getOutputPanel() {
        if (outputPanel == null) {
            outputPanel = new JPanel();
            outputPanel.setLayout(new BorderLayout());
            outputPanel.add(getJScrollPane(), java.awt.BorderLayout.CENTER);
            outputPanel.add(getBtnClearOutput(), java.awt.BorderLayout.SOUTH);
        }
        return outputPanel;
    }

    private JScrollPane getJScrollPane() {
        if (jScrollPane == null) {
            jScrollPane = new JScrollPane();
            jScrollPane.setViewportView(getTaOutput());
        }
        return jScrollPane;
    }

    public JTextArea getTaOutput() {
        if (taOutput == null) {
            taOutput = new JTextArea();
            taOutput.setBackground(Color.BLACK);
            taOutput.setForeground(Color.YELLOW);
        }
        return taOutput;
    }

    private JTextField getTfHost() {
        if (tfHost == null) {
            tfHost = new JTextField();
            tfHost.setColumns(20);
            tfHost.setText("127.0.0.1");
            tfHost.setToolTipText("Nhập Host name hoặc địa chỉ IP");
        }
        return tfHost;
    }
    public boolean PingIP(String IP) throws IOException {

            //The command to execute
            String pingCmd = "ping " + IP;
            String time = "";
            //get the runtime to execute the command
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec(pingCmd);
            //Gets the inputstream to read the output of the command
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            //reads the outputs
            String inputLine = in.readLine();
            while ((inputLine != null)) {
                if (inputLine.contains("TTL")) {
                    return true;
                }
                time+=inputLine;
                inputLine = in.readLine();
            }
            if (time.contains("TTL")) {
                return true;
            }
            return false;
        }

    public JButton getBtnScan() {
        if (btnScan == null) {
            btnScan = new JButton();
            btnScan.setText("Scan");
            btnScan.setToolTipText("Start Scan");
            btnScan.addActionListener(new java.awt.event.ActionListener() {

                public void actionPerformed(java.awt.event.ActionEvent e) {
                    boolean hasError = false;
                    String msg = "";
                    int startPort = 0, endPort = 0;

                    btnScan.setEnabled(false);
                    btnStop.setEnabled(true);

                    if (tfHost.getText().trim().equals("")) {
                        msg = "Please input IP hoặc Hostname";
                        tfHost.grabFocus();
                        hasError = true;
                    } else {
                        try {
                            InetAddress addr = InetAddress.getByName(tfHost.getText());
                            if (!PingIP(addr.getHostAddress())) {
                                msg = "Host is Unreachable";
                                hasError = true;
                            }
                        } catch (UnknownHostException uhe) {
                            msg = "Unknown Host";
                            hasError = true;
                        } catch (IOException ioe) {
                        }
                    }

                    if (!hasError && tfStartPort.equals("")) {
                        msg = "Please input start port";
                        tfStartPort.grabFocus();
                        hasError = true;
                    }

                    if (!hasError && tfEndPort.equals("")) {
                        msg = "Please input end port";
                        tfEndPort.grabFocus();
                        hasError = true;
                    }

                    if (!hasError) {
                        try {
                            startPort = Integer.parseInt(tfStartPort.getText());
                            endPort = Integer.parseInt(tfEndPort.getText());

                            if (startPort < 0 || startPort > 65535) {
                                msg = "Please input Port from 0-65535";
                                tfStartPort.grabFocus();
                                hasError = true;
                            } else if (endPort < 0 || endPort > 65535) {
                                msg = "Please input Port 0-65535";
                                tfEndPort.grabFocus();
                                hasError = true;
                            } else if (startPort > endPort) {
                                msg = "End Port is invalid";
                                tfStartPort.grabFocus();
                                hasError = true;
                            }
                        } catch (NumberFormatException nfe) {
                            msg = "Input Data is invalid";
                            tfStartPort.grabFocus();
                            hasError = true;
                        }
                    }

                    if (!hasError) {
                        t = new ServiceThread(tfHost.getText(), startPort, endPort, Main.this);
                        int priority;
                        if (cbPriority.getSelectedIndex() == 0) {
                            priority = Thread.MIN_PRIORITY;
                        } else if (cbPriority.getSelectedIndex() == 1) {
                            priority = Thread.NORM_PRIORITY;
                        } else {
                            priority = Thread.MAX_PRIORITY;
                        }
                        t.setPriority(priority);
                        t.start();
                        lblStatus.setText("Scan Started");
                    }

                    if (hasError) {
                        JOptionPane.showMessageDialog(Main.this, msg, "Error", JOptionPane.ERROR_MESSAGE);
                        taOutput.setText("Input Validation Failed");
                        lblStatus.setText("Please fix the input data");
                        btnScan.setEnabled(true);
                        btnStop.setEnabled(false);
                    }
                }
            });
        }
        return btnScan;
    }

    public JButton getBtnStop() {
        if (btnStop == null) {
            btnStop = new JButton();
            btnStop.setText("Stop");
            btnStop.setMnemonic(java.awt.event.KeyEvent.VK_T);
            btnStop.setToolTipText("Stop Scan");
            btnStop.setEnabled(false);
            btnStop.addActionListener(new java.awt.event.ActionListener() {

                public void actionPerformed(java.awt.event.ActionEvent e) {
                    t.isStop = true;
                }
            });
        }
        return btnStop;
    }

    private JPanel getHostPanel() {
        if (hostPanel == null) {
            hostPanel = new JPanel();
            hostPanel.add(lblHost, null);
            hostPanel.add(getTfHost(), null);
        }
        return hostPanel;
    }

    private JPanel getPortPanel() {
        if (portPanel == null) {
            lblEndPort = new JLabel();
            lblStartPort = new JLabel();
            portPanel = new JPanel();
            lblStartPort.setText("Start Port:");
            portPanel.add(lblStartPort, null);
            lblEndPort.setText("End Port:");
            portPanel.add(getTfStartPort(), null);
            portPanel.add(lblEndPort, null);
            portPanel.add(getTfEndPort(), null);
        }
        return portPanel;
    }

    private JTextField getTfStartPort() {
        if (tfStartPort == null) {
            tfStartPort = new JTextField();
            tfStartPort.setColumns(5);
            tfStartPort.setText("0");
            tfStartPort.setToolTipText("Nhập start port");
        }
        return tfStartPort;
    }

    private JTextField getTfEndPort() {
        if (tfEndPort == null) {
            tfEndPort = new JTextField();
            tfEndPort.setColumns(5);
            tfEndPort.setToolTipText("Nhập end port");
            tfEndPort.setText("65535");
        }
        return tfEndPort;
    }

    private JPanel getPriorityPanel() {
        if (priorityPanel == null) {
            lblPriority = new JLabel();
            priorityPanel = new JPanel();
            lblPriority.setText("Priority:");
            priorityPanel.add(lblPriority, null);
            priorityPanel.add(getCbPriority(), null);
        }
        return priorityPanel;
    }

    private JComboBox getCbPriority() {
        if (cbPriority == null) {
            cbPriority = new JComboBox();
            cbPriority.setToolTipText("Chọn độ ưu tiên của Thread");
            cbPriority.addItem("Low");
            cbPriority.addItem("Normal");
            cbPriority.addItem("High");
        }
        return cbPriority;
    }

    private JButton getBtnClearOutput() {
        if (btnClearOutput == null) {
            btnClearOutput = new JButton();
            btnClearOutput.setToolTipText("Clear Output");
            btnClearOutput.setText("Clear");
            btnClearOutput.addActionListener(new java.awt.event.ActionListener() {

                public void actionPerformed(java.awt.event.ActionEvent e) {
                    try {
                        InetAddress addr = InetAddress.getLocalHost();
                        taOutput.setText("Local Host Name: " + addr.getHostName());
                        taOutput.append("\nLocal IP Address: " + addr.getHostAddress());
                    } catch (UnknownHostException uhe) {
                    }
                }
            });
        }
        return btnClearOutput;
    }

    public JLabel getLblStatus() {
        return lblStatus;
    }

    private JPanel getControlPanel() {
        if (controlPanel == null) {
            controlPanel = new JPanel();
            controlPanel.add(getBtnScan(), null);
            controlPanel.add(getBtnStop(), null);
        }
        return controlPanel;
    }

    public Main() {
        super();
        initialize();
    }

    private void initialize() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
        this.setTitle("Quét cổng");
        this.setSize(500, 400);
        this.setContentPane(getJContentPane());
        try {
            InetAddress addr = InetAddress.getLocalHost();
            taOutput.setText("Local Host Name: " + addr.getHostName());
            taOutput.append("\nLocal IP Address: " + addr.getHostAddress());
        } catch (UnknownHostException uhe) {
        }

        //Position application at the center of screen

        this.setVisible(true);
    }

    private javax.swing.JPanel getJContentPane() {
        if (jContentPane == null) {
            lblStatus = new JLabel();
            jContentPane = new javax.swing.JPanel();
            jContentPane.setLayout(new java.awt.BorderLayout());
            lblStatus.setText(" ");
            jContentPane.add(getInputPanel(), java.awt.BorderLayout.NORTH);
            jContentPane.add(getOutputPanel(), java.awt.BorderLayout.CENTER);
            jContentPane.add(lblStatus, java.awt.BorderLayout.SOUTH);
        }
        return jContentPane;
    }
}
