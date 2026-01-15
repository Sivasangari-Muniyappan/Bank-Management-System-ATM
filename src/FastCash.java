import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;
import java.sql.ResultSet;

public class FastCash extends JFrame implements ActionListener {
    JButton amt1,amt2,amt3,amt4,amt5,amt6,back;
    String pinnumber;

    FastCash(String pinnumber)
    {
        this.pinnumber=pinnumber;
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/ATM.jpeg"));
        Image i2=i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text=new JLabel("Select Withdraw Amount");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        amt1=new JButton("RS.100");
        amt1.setBounds(170,415,150,30);
        amt1.addActionListener(this);
        image.add(amt1);

        amt2=new JButton("RS.500");
        amt2.setBounds(355,415,150,30);
        amt2.addActionListener(this);
        image.add(amt2);

        amt3=new JButton("RS.1000");
        amt3.setBounds(170,450,150,30);
        amt3.addActionListener(this);
        image.add(amt3);

        amt4=new JButton("RS.2000");
        amt4.setBounds(355,450,150,30);
        amt4.addActionListener(this);
        image.add(amt4);

        amt5=new JButton("RS.5000");
        amt5.setBounds(170,485,150,30);
        amt5.addActionListener(this);
        image.add(amt5);

        amt6=new JButton("RS.10000");
        amt6.setBounds(355,485,150,30);
        amt6.addActionListener(this);
        image.add(amt6);

        back=new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);



        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public static void main(String[] args) {
        new FastCash("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back)
        {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        } else
        {
            String amount=((JButton)e.getSource()).getText().substring(3);
            Conn c=new Conn();
            try
            {
                ResultSet rs=c.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
                int balance=0;
                while (rs.next())
                {
                    if(rs.getString("type").equals("Deposit"))
                    {
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }
                    else
                    {
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }
                }
                if (e.getSource()!=back && balance<Integer.parseInt(amount))
                {
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                Date date=new Date();
                String query="insert into bank values('"+ pinnumber +"','"+date+"','withdrawl','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs"+amount+" Debited Successfully");
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
            } catch (Exception ae)
            {
                System.out.println(ae);
            }
        }

    }
}
