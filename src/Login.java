import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JButton signin,signup,clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login()
    {
        setTitle("AUTOMATED TELLER MACHINE");

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/LOGO.png"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);

        JLabel txt=new JLabel("WELCOME TO ATM");
        txt.setFont(new Font("Osward",Font.BOLD,38));
        txt.setBounds(200,40,400,40);
        add(txt);

        JLabel cardno=new JLabel("CARD NO:");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(120,150,150,40);
        add(cardno);
        cardTextField=new JTextField();
        cardTextField.setBounds(300,160,230,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);

        JLabel pin=new JLabel("PIN NO:");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120,220,150,40);
        add(pin);
        pinTextField=new JPasswordField();
        pinTextField.setBounds(300,230,230,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);

        signin=new JButton("SIGN IN");
        signin.setBounds(300,300,100,30);
        signin.setBackground(Color.BLACK);
        signin.setForeground(Color.WHITE);
        signin.addActionListener(this);
        add(signin);

        clear=new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup=new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.WHITE);

        setSize(800,480);
        setLayout(null);
        setVisible(true);
        setLocation(350,200);

    }
    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== signin)
        {
            Conn conn=new Conn();
            String cardnumber=cardTextField.getText();
            String pinnumber=pinTextField.getText();
            String query="select * from login where Card_Number='"+cardnumber+"' and Pin='"+pinnumber+"'";
            try {
                ResultSet rs= conn.s.executeQuery(query);
                if (rs.next())
                {
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");

                }
            }
            catch (Exception ae)
            {
                System.out.println(ae);
            }
        }
        else if (e.getSource()==clear)
        {
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if (e.getSource()==signup)
        {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
}
