import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {


    String pinnumber;

    MiniStatement(String pinnumber)
    {
        this.pinnumber=pinnumber;
        setTitle("Mini Statement");
        setLayout(null);

        JLabel mini=new JLabel();
        add(mini);

        JLabel bank=new JLabel("INDIAN BANK");
        bank.setBounds(150,20,100,20);
        add(bank);

        JLabel card=new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel balance= new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);


        try
        {
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select * from login where Pin='"+pinnumber+"'");
            while (rs.next())
            {
                card.setText("Card Number: "+ rs.getString("Card_Number").substring(0,4)+"-XXXX-XXXX"+rs.getString("Card_Number").substring(12));
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        try
        {
            Conn conn=new Conn();
            int bal=0;
            ResultSet rs=conn.s.executeQuery("select * from bank where Pin='"+pinnumber+"'");
            while (rs.next())
            {
                mini.setText(mini.getText()+"<html>"+rs.getString("Date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("Type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("Amount")+"<br><br><br><html>");
                if(rs.getString("type").equals("Deposit"))
                {
                    bal+=Integer.parseInt(rs.getString("amount"));
                }
                else
                {
                    bal-=Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your Current Account Balance is RS "+bal);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        mini.setBounds(20,140,400,200);

        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        //setUndecorated(true);
        setVisible(true);
    }
    public static void main(String[] args) {
        new MiniStatement("");
    }

}
