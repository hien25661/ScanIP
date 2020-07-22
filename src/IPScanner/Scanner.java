package IPScanner;

import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
//import sun.awt.windows.ThemeReader;
import PortScanner.*;
import com.sun.media.ui.MessageBox;

public class Scanner extends javax.swing.JFrame {

    int num_Thread;
    Thread[] th;
    public JTable table;
    long tong = 0;
    int running = 0;
    byte f1, f2, f3, f4;
    byte t1, t2, t3, t4;
    Vector tableTittle = new Vector();
    Vector tableData = new Vector();
    Thread clock;
    int time = 0;
    Semaphore sema;

    public Scanner() {
        initComponents();
        tableTittle.add("Address");
        tableTittle.add("Name");
        tableTittle.add("Status");
        table = new JTable();
        table.setModel(new DefaultTableModel(tableData, tableTittle));
        table.setEnabled(false);
        jScrollPane2.setViewportView(table);

        ta1.setBackground(Color.BLACK);
        ta1.setForeground(Color.YELLOW);
        try {
            InetAddress add = InetAddress.getLocalHost();
            lblIP_localhost.setText(add.getHostAddress());
            String address = add.getHostAddress();
            StringTokenizer token = new StringTokenizer(address, ".");
            String[] ip = new String[4];
            int i = 0;
            for (i = 0; i <= ip.length - 1; i++) {
                ip[i] = token.nextToken();
            }

            txt_IPNet1.setText(ip[0]);
            txtIPNET2.setText(ip[0]);
            txtf2.setText(ip[1]);
            txtt2.setText(ip[1]);
            txtf3.setText(ip[2]);
            txtt3.setText(ip[2]);
            txt_IPNet1.setEditable(false);
            txtIPNET2.setEditable(false);
            txtf2.setEditable(false);
            txtt2.setEditable(false);
            txtf3.setEditable(false);
            txtt3.setEditable(false);
        } catch (UnknownHostException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi");
            return;
        }
        txt_IP_Start.requestFocus();
        bar.setStringPainted(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        thongbao1 = new javax.swing.JDialog();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        jlbTitle = new javax.swing.JLabel();
        lblIP_localhost = new javax.swing.JLabel();
        lbl_Address = new javax.swing.JLabel();
        rdio_ScanAll = new javax.swing.JRadioButton();
        lbl_IP_From = new javax.swing.JLabel();
        txt_IPNet1 = new javax.swing.JTextField();
        txt_IP_Start = new javax.swing.JTextField();
        lbl_ip_to = new javax.swing.JLabel();
        txtIPNET2 = new javax.swing.JTextField();
        txt_IP_END = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNum_Thread = new javax.swing.JTextField();
        btn_Start = new javax.swing.JButton();
        btb_Stop = new javax.swing.JButton();
        btb_Close = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txt_Alive = new javax.swing.JTextField();
        rdio_ScanAll1 = new javax.swing.JRadioButton();
        ta1 = new java.awt.TextArea();
        jLabel6 = new javax.swing.JLabel();
        txt_TimeR = new javax.swing.JTextField();
        txtf2 = new javax.swing.JTextField();
        txtf3 = new javax.swing.JTextField();
        txtt2 = new javax.swing.JTextField();
        txtt3 = new javax.swing.JTextField();
        bar = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        lblState = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLabel3 = new javax.swing.JLabel();
        txtAccess = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        thongbao1.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        thongbao1.setTitle("Thông tin chương trình");
        thongbao1.setBackground(new java.awt.Color(153, 204, 0));
        thongbao1.setIconImage(null);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Xây dựng chương trình MultiThread scan ip mạng LAN");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("GVHD: NGUYỄN VĂN NGUYÊN");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("SVTH: NGUYỄN VĂN HIỀN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(134, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 0, 102));
        jLabel8.setText("DA LTM");

        javax.swing.GroupLayout thongbao1Layout = new javax.swing.GroupLayout(thongbao1.getContentPane());
        thongbao1.getContentPane().setLayout(thongbao1Layout);
        thongbao1Layout.setHorizontalGroup(
                thongbao1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(thongbao1Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(thongbao1Layout.createSequentialGroup()
                                .addGroup(thongbao1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(thongbao1Layout.createSequentialGroup()
                                                .addGap(129, 129, 129)
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(thongbao1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        thongbao1Layout.setVerticalGroup(
                thongbao1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(thongbao1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(24, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Scan IP");
        setResizable(false);

        jXPanel1.setBackground(new java.awt.Color(0, 255, 255));
        jXPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jlbTitle.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jlbTitle.setForeground(new java.awt.Color(102, 102, 0));
        jlbTitle.setText("PROGRAM SCAN IP");
        jlbTitle.setName("jlbTitle");

        lblIP_localhost.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblIP_localhost.setText("Your IP Address ");

        lbl_Address.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_Address.setText("Your IP Address: ");

        rdio_ScanAll.setBackground(new java.awt.Color(0, 255, 255));
        buttonGroup1.add(rdio_ScanAll);
        rdio_ScanAll.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rdio_ScanAll.setSelected(true);
        rdio_ScanAll.setText("Scan All");
        rdio_ScanAll.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rdio_ScanAllStateChanged(evt);
            }
        });

        lbl_IP_From.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbl_IP_From.setText("From:");

        txt_IPNet1.setBackground(new java.awt.Color(102, 255, 102));
        txt_IPNet1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txt_IPNet1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txt_IP_Start.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_IP_Start.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lbl_ip_to.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbl_ip_to.setText("To:");

        txtIPNET2.setBackground(new java.awt.Color(102, 255, 102));
        txtIPNET2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txtIPNET2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txt_IP_END.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_IP_END.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Number of Thread: ");

        btn_Start.setText("START");
        btn_Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_StartActionPerformed(evt);
            }
        });

        btb_Stop.setText("STOP");
        btb_Stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btb_StopActionPerformed(evt);
            }
        });

        btb_Close.setText("CLOSE");
        btb_Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btb_CloseActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Alive");

        txt_Alive.setEditable(false);
        txt_Alive.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txt_Alive.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        rdio_ScanAll1.setBackground(new java.awt.Color(0, 255, 255));
        buttonGroup1.add(rdio_ScanAll1);
        rdio_ScanAll1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rdio_ScanAll1.setText("Scan Range");

        ta1.setEditable(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Time");

        txt_TimeR.setEditable(false);
        txt_TimeR.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        txt_TimeR.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtf2.setBackground(new java.awt.Color(102, 255, 102));
        txtf2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txtf2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtf3.setBackground(new java.awt.Color(102, 255, 102));
        txtf3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txtf3.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtt2.setBackground(new java.awt.Color(102, 255, 102));
        txtt2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txtt2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtt3.setBackground(new java.awt.Color(102, 255, 102));
        txtt3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txtt3.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        bar.setForeground(new java.awt.Color(0, 204, 51));

        jLabel1.setText("state: ");

        lblState.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblState.setText("Non");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Limit Thread Access :");

        javax.swing.GroupLayout jXPanel1Layout = new javax.swing.GroupLayout(jXPanel1);
        jXPanel1.setLayout(jXPanel1Layout);
        jXPanel1Layout.setHorizontalGroup(
                jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jXPanel1Layout.createSequentialGroup()
                                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jXPanel1Layout.createSequentialGroup()
                                                .addGap(162, 162, 162)
                                                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jXPanel1Layout.createSequentialGroup()
                                                                .addComponent(jlbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(jXPanel1Layout.createSequentialGroup()
                                                                .addGap(10, 10, 10)
                                                                .addComponent(lbl_Address)
                                                                .addGap(22, 22, 22)
                                                                .addComponent(lblIP_localhost)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jLabel1)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(lblState))))
                                        .addGroup(jXPanel1Layout.createSequentialGroup()
                                                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jXPanel1Layout.createSequentialGroup()
                                                                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jXPanel1Layout.createSequentialGroup()
                                                                                .addContainerGap()
                                                                                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(lbl_IP_From)
                                                                                        .addComponent(lbl_ip_to))
                                                                                .addGap(18, 18, 18)
                                                                                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                        .addGroup(jXPanel1Layout.createSequentialGroup()
                                                                                                .addComponent(txtIPNET2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                .addComponent(txtt2))
                                                                                        .addGroup(jXPanel1Layout.createSequentialGroup()
                                                                                                .addComponent(txt_IPNet1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                .addComponent(txtf2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(jXPanel1Layout.createSequentialGroup()
                                                                                                .addComponent(txtf3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                .addComponent(txt_IP_Start, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                        .addGroup(jXPanel1Layout.createSequentialGroup()
                                                                                                .addComponent(txtt3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                .addComponent(txt_IP_END, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                        .addGroup(jXPanel1Layout.createSequentialGroup()
                                                                                .addGap(33, 33, 33)
                                                                                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jLabel2)
                                                                                        .addComponent(jLabel3))
                                                                                .addGap(18, 18, 18)
                                                                                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(txtNum_Thread, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(txtAccess, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                        .addGroup(jXPanel1Layout.createSequentialGroup()
                                                                                .addGap(39, 39, 39)
                                                                                .addComponent(rdio_ScanAll)
                                                                                .addGap(39, 39, 39)
                                                                                .addComponent(rdio_ScanAll1))
                                                                        .addGroup(jXPanel1Layout.createSequentialGroup()
                                                                                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                                        .addGroup(jXPanel1Layout.createSequentialGroup()
                                                                                                .addContainerGap()
                                                                                                .addComponent(btn_Start, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(btb_Stop, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jXPanel1Layout.createSequentialGroup()
                                                                                                .addGap(21, 21, 21)
                                                                                                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                        .addComponent(jLabel5)
                                                                                                        .addComponent(jLabel6))
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                                        .addComponent(txt_TimeR, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                                                                                        .addComponent(txt_Alive))
                                                                                                .addGap(49, 49, 49)))
                                                                                .addComponent(btb_Close, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(jXPanel1Layout.createSequentialGroup()
                                                                                .addContainerGap()
                                                                                .addComponent(ta1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel1Layout.createSequentialGroup()
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(bar, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                                                        .addComponent(jScrollPane2))))
                                .addContainerGap())
        );
        jXPanel1Layout.setVerticalGroup(
                jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jXPanel1Layout.createSequentialGroup()
                                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jXPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jlbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jLabel1)
                                                                .addComponent(lblState))
                                                        .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(lbl_Address, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(lblIP_localhost, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(7, 7, 7)
                                                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(rdio_ScanAll)
                                                        .addComponent(rdio_ScanAll1))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(lbl_IP_From, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(txt_IPNet1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(txtf2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(txtf3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(txt_IP_Start, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lbl_ip_to, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtIPNET2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtt2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtt3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txt_IP_END, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtNum_Thread, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(9, 9, 9)
                                                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtAccess, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(ta1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btn_Start, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btb_Stop, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btb_Close, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jXPanel1Layout.createSequentialGroup()
                                                .addGap(107, 107, 107)
                                                .addComponent(jScrollPane2)))
                                .addGap(18, 18, 18)
                                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jXPanel1Layout.createSequentialGroup()
                                                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txt_Alive, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel5))
                                                .addGap(18, 18, 18)
                                                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel6)
                                                        .addComponent(txt_TimeR, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(bar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24))
        );

        jMenu1.setText("Chức năng khác");

        jMenuItem1.setText("Quét Cổng");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator3);

        jMenuItem2.setText("Thoát");
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Giúp đở");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jXPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jXPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        new Scanner().show();
    }

    private void btn_StartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_StartActionPerformed
        try {
            stopScan();
            int limit = Integer.parseInt(txtAccess.getText().trim());
            sema = new Semaphore(limit, true);
            time = 0;
            ta1.setText("");
            tong = 0;
            running = 0;
            bar.setValue(0);
            txt_TimeR.setText("");
            DefaultTableModel model1 = new DefaultTableModel(tableData, tableTittle);
            for (int i = model1.getRowCount() - 1; i >= 0; i--) {
                model1.removeRow(i);
            }
            table.setModel(model1);
            num_Thread = Integer.parseInt(txtNum_Thread.getText());
        } catch (Exception ex1) {
            JOptionPane.showMessageDialog(null, "Nhập thiếu thông tin");
            return;
        }
        th = new Thread[num_Thread];
        bar.setMaximum(num_Thread);
        lblState.setText("Scanning...");
        int h = 0;
        int start = Integer.parseInt(txt_IP_Start.getText());
        int end = Integer.parseInt(txt_IP_END.getText());
        int range = end - start + 1;
        if (num_Thread > range) {
            num_Thread = range;
        }
        try {
            int j = start;
            h = (int) (range / num_Thread);
            for (int i = 0; i < num_Thread; i++) {
                th[i] = new Thread(new Thread2(sema, j, j + h - 1, i));
                j = j + h;
                th[i].start();

            }
            // Thread.sleep(200);
        } catch (Exception ex) {
            Logger.getLogger(Scanner.class.getName()).log(Level.SEVERE, null, ex);
        }
        clock = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    try {
                        txt_TimeR.setText(Integer.toString(time) + " s");
                        time++;
                        Thread.sleep(1000);
                    } catch (Exception ex2) {
                    }
                }
            }
        });
        clock.start();
    }//GEN-LAST:event_btn_StartActionPerformed

    private void btb_StopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btb_StopActionPerformed
        lblState.setText("Stopped");
        try {
            stopScan();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error");
            return;
        }
    }//GEN-LAST:event_btb_StopActionPerformed

    private void stopScan() throws Exception {
        if(clock!=null) {
            clock.stop();
        }
        num_Thread = Integer.parseInt(txtNum_Thread.getText());
        if(th == null) return;
        for (int i = 0; i < th.length; i++) {
            if (th[i] !=null && th[i].isAlive() == true) {
                th[i].stop();
                bar.setValue(bar.getValue() - 1);
                System.out.println("Ket thuc :" + th[i].getName());
                ta1.append("Thread  " + i + "   Finished \n");
            } else {
                System.out.println(th[i].getName() + " da chet");
            }
        }

    }

    private void rdio_ScanAllStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rdio_ScanAllStateChanged
        if (rdio_ScanAll.isSelected() == true) {
            txt_IP_Start.setEnabled(false);
            txt_IP_END.setEnabled(false);
            txt_IP_Start.setText("1");
            txt_IP_END.setText("254");
        } else {
            txt_IP_Start.setEnabled(true);
            txt_IP_END.setEnabled(true);
            txt_IP_Start.requestFocus();
        }
    }//GEN-LAST:event_rdio_ScanAllStateChanged

    private void btb_CloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btb_CloseActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btb_CloseActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Main s = new Main();

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        thongbao1.show();
    }//GEN-LAST:event_jMenu2MouseClicked

    class Thread2 implements Runnable {

        Semaphore sema;
        int i_start, i_end;
        Vector data = new Vector(), title = new Vector();
        int index;

        public Thread2(Semaphore sema, int i_start, int i_end, int index) {
            this.sema = sema;
            this.i_start = i_start;
            this.i_end = i_end;
            this.index = index;
        }

        public boolean PingIP1(String ip) {
            // int[] port = {21, 23, 25, 80,110, 135, 139, 143};
            int[] port = {80};
            for (int i = 0; i < port.length; ++i) {
                try {
                    Socket soc = new Socket(ip, port[i]);
                    soc.close();
                    return true;
                } catch (Exception e) {
                }
            }
            return false;
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
                time += inputLine;
                inputLine = in.readLine();
            }
            if (time.contains("TTL")) {
                return true;
            }
            return false;
        }

        public void run() {
            ScanIPR();
        }

        public void ScanIPR() {
            int numberOfThread = num_Thread;
            try {
                sema.acquire();
                long begin = Calendar.getInstance().getTimeInMillis();
                int a = Integer.parseInt(txt_IPNet1.getText());
                int b = Integer.parseInt(txtf2.getText());
                int c = Integer.parseInt(txtf3.getText());
                byte[] ip = {(byte) a, (byte) b, (byte) c, (byte) 0};
                long sumOfTime = 0;

                ta1.append("Thread " + index + " start\n");
                for (int i = i_start; i <= i_end; i++) {
                    ip[3] = (byte) i;
                    try {

                        String strip = txt_IPNet1.getText() + "." + txtf2.getText() + "." + txtf3.getText() + "." + Integer.toString(i);
                        InetAddress inet = InetAddress.getByName(strip);
                        InetAddress address = InetAddress.getByAddress(ip);
                        Vector record = new Vector();
                        if ((PingIP(strip) == true) /*
                         * || (!address.getHostAddress().equals(
                         * address.getHostName()))
                         */) {
                            System.out.println(inet.getHostAddress() + ": " + inet.getHostName());
                            running++;
                            txt_Alive.setText(Integer.toString(running));

                            record.add(inet.getHostAddress());
                            record.add(inet.getHostName());
                            record.add("alive");
                            tableData.add(record);
                            table.setModel(new DefaultTableModel(tableData, tableTittle));
                            jScrollPane2.setViewportView(table);
                            Thread.sleep(1);
                        }


                    } catch (UnknownHostException e) {
                        System.err.println("Host khong ton tai");
                    } catch (IOException e) {
                        System.err.println("Error in reaching the Host");
                    }
                }
                long end = Calendar.getInstance().getTimeInMillis();
                sumOfTime += (end-begin);
                ta1.append("Thread  " + index + "   Finished ----- Time: " + ((end - begin)) + " ms\n");
                tong = (end - begin);
                bar.setValue(bar.getValue() + 1);
                num_Thread--;
                if (bar.getValue() == bar.getMaximum()) {
                    clock.stop();
                    JOptionPane.showMessageDialog(null, "Scan Completed ~ Time: "+ Scanner.round((double)sumOfTime/numberOfThread,2));
                    lblState.setText("Complete!");
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Scanner.class.getName()).log(Level.SEVERE, null, ex);
            }
            sema.release();

        }
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar bar;
    private javax.swing.JButton btb_Close;
    private javax.swing.JButton btb_Stop;
    private javax.swing.JButton btn_Start;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private javax.swing.JLabel jlbTitle;
    private javax.swing.JLabel lblIP_localhost;
    private javax.swing.JLabel lblState;
    private javax.swing.JLabel lbl_Address;
    private javax.swing.JLabel lbl_IP_From;
    private javax.swing.JLabel lbl_ip_to;
    private javax.swing.JRadioButton rdio_ScanAll;
    private javax.swing.JRadioButton rdio_ScanAll1;
    private java.awt.TextArea ta1;
    private javax.swing.JDialog thongbao1;
    private javax.swing.JTextField txtAccess;
    public javax.swing.JTextField txtIPNET2;
    private javax.swing.JTextField txtNum_Thread;
    public javax.swing.JTextField txt_Alive;
    public javax.swing.JTextField txt_IPNet1;
    private javax.swing.JTextField txt_IP_END;
    private javax.swing.JTextField txt_IP_Start;
    public javax.swing.JTextField txt_TimeR;
    public javax.swing.JTextField txtf2;
    public javax.swing.JTextField txtf3;
    public javax.swing.JTextField txtt2;
    public javax.swing.JTextField txtt3;
    // End of variables declaration//GEN-END:variables
}
