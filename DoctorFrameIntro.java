package DoctorFrame;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Entity.*;

public class DoctorFrameIntro extends JFrame implements ActionListener, MouseListener {
    ImageIcon img;
    JLabel id, name, insert, search, imgLabel;
    JTextField idField, nameField, insertField, searchField;
    JButton insertBtn, insertCancelBtn, searchBtn, exitBtn;
    JPanel loginPanel, imagePanel;
    Color lightBlue = new Color(180, 220, 250);
    Font fieldFont = new Font("Cambria", Font.PLAIN, 12);
    Font buttonFont = new Font("Cambria", Font.BOLD, 12);

    // Define the data file name
    private static final String DATA_FILE = "DoctorData.txt";

    public DoctorFrameIntro() {
        super("Doctor Management System");
        setSize(700, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // Image Panel
        img = new ImageIcon("Doc3.jpg");
        Image dimg = img.getImage().getScaledInstance(300, 450, Image.SCALE_SMOOTH);
        img = new ImageIcon(dimg);
        imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, 300, 450);
        add(imgLabel);

        // Login Panel
        loginPanel = new JPanel();
        loginPanel.setLayout(null);
        loginPanel.setBackground(lightBlue);
        loginPanel.setBounds(300, 0, 400, 450);
        this.add(loginPanel);

        id = new JLabel("Doctor's ID:");
        id.setBounds(30, 20, 100, 20);
        loginPanel.add(id);

        idField = new JTextField();
        idField.setFont(fieldFont);
        idField.setBounds(140, 20, 200, 20);
        loginPanel.add(idField);

        name = new JLabel("Doctor's Name:");
        name.setBounds(30, 50, 100, 20);
        loginPanel.add(name);

        nameField = new JTextField();
        nameField.setFont(fieldFont);
        nameField.setBounds(140, 50, 200, 20);
        loginPanel.add(nameField);

        insert = new JLabel("Insert Your Data:");
        insert.setBounds(30, 80, 100, 20);
        loginPanel.add(insert);

        insertField = new JTextField();
        insertField.setFont(fieldFont);
        insertField.setBounds(140, 80, 200, 20);
        loginPanel.add(insertField);

        insertBtn = new JButton("Insert");
        insertBtn.setFont(buttonFont);
        insertBtn.setBounds(140, 110, 90, 25);
        insertBtn.addActionListener(this);
        loginPanel.add(insertBtn);

        insertCancelBtn = new JButton("Cancel");
        insertCancelBtn.setFont(buttonFont);
        insertCancelBtn.setBounds(250, 110, 90, 25);
        insertCancelBtn.addActionListener(this);
        loginPanel.add(insertCancelBtn);

        search = new JLabel("Search Your Data:");
        search.setBounds(30, 150, 120, 20);
        loginPanel.add(search);

        searchField = new JTextField();
        searchField.setFont(fieldFont);
        searchField.setBounds(140, 150, 200, 20);
        loginPanel.add(searchField);

        searchBtn = new JButton("Search");
        searchBtn.setFont(buttonFont);
        searchBtn.setBounds(140, 180, 90, 25);
        searchBtn.addActionListener(this);
        loginPanel.add(searchBtn);

        exitBtn = new JButton("Exit");
        exitBtn.setFont(buttonFont);
        exitBtn.setBounds(250, 180, 90, 25);
        exitBtn.addActionListener(this);
        loginPanel.add(exitBtn);

        
    }

    public void mouseClicked(MouseEvent me){}
    public void mousePressed(MouseEvent me){}
    public void mouseReleased(MouseEvent me){}
    public void mouseEntered(MouseEvent me)
    {
        if(me.getSource()==searchBtn)
        {
            searchBtn.setBackground(Color.BLUE);
            searchBtn.setForeground(Color.WHITE);
        }
        else if(me.getSource()==insertBtn)
        {
            insertBtn.setBackground(Color.RED);
            insertBtn.setForeground(Color.WHITE);
        }
    }
    public void mouseExited(MouseEvent me)
    {
        if(me.getSource()==searchBtn)
        {
            searchBtn.setBackground(null);
            searchBtn.setForeground(Color.BLACK);
        }
        else if(me.getSource()==insertBtn)
        {
            insertBtn.setBackground(null);
            insertBtn.setForeground(Color.BLACK);
        }
    }
     
    public void actionPerformed(ActionEvent ae) {
        String id = idField.getText();
        String name = nameField.getText();
        String command = ae.getActionCommand();

        if (ae.getSource() == insertBtn) {
                Doctor d = new Doctor(id,name);
                d.insertDoctor();
                idField.setText("");
                nameField.setText("");
                JOptionPane.showMessageDialog(null, "Doctor Added");
               
        }else if (ae.getSource() == insertCancelBtn) {
            idField.setText("");
            nameField.setText("");
            insertField.setText("");
            searchField.setText("");
        }
         
             else if (ae.getSource() == searchBtn) {
                Doctor d=new Doctor();
                 if(d.getDoctor(id,name)==true){
                    JOptionPane.showMessageDialog(null, "Doctor Found");
                } else {
                    JOptionPane.showMessageDialog(null, "Doctor not Found");
                }
            }
            else if(exitBtn.getText().equals(command)) {
                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }else if(confirm==JOptionPane.NO_OPTION) {
                    //dispose();
                }
                else{}
            }
        }
    }