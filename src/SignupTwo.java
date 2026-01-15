import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;


public class SignupTwo extends JFrame implements ActionListener {


    JTextField aadharTextField,panTextField;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion,occupation,category,income,qualification;
    String formno;
    SignupTwo(String formno)
    {
        this.formno=formno;
        setTitle("NEW ACCOUNT APPLICATION FORM- PAGE 2");

        JLabel additionalDetail =new JLabel("PAGE 2:ADDITIONAL DETAILS");
        additionalDetail.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetail.setBounds(225,80,400,30);
        add(additionalDetail);

        JLabel religionn =new JLabel("RELIGION:");
        religionn.setFont(new Font("Raleway",Font.BOLD,20));
        religionn.setBounds(100,140,200,30);
        add(religionn);
        String[] valRegion={"Hindu","Muslim","Christian","Other"};
        religion=new JComboBox<>(valRegion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel categoryy =new JLabel("CATEGORY:");
        categoryy.setFont(new Font("Raleway",Font.BOLD,20));
        categoryy.setBounds(100,190,200,30);
        add(categoryy);
        String[] valCategory={"General","OBC","BC","ST"};
        category=new JComboBox<>(valCategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);


        JLabel incomee =new JLabel("INCOME:");
        incomee.setFont(new Font("Raleway",Font.BOLD,20));
        incomee.setBounds(100,240,200,30);
        add(incomee);
        String[] incomeCategory={"Null","Above 60,000","Above 2,50,000","Above 5,00,000","Below 60,000"};
        income=new JComboBox<>(incomeCategory);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);


        JLabel qualificationn =new JLabel("QUALIFICATION:");
        qualificationn.setFont(new Font("Raleway",Font.BOLD,20));
        qualificationn.setBounds(100,290,200,30);
        add(qualificationn);
        String[] qualificationCategory={"Non-Graduate","Graduate","Post-Graduate","Doctorate"};
        qualification=new JComboBox<>(qualificationCategory);
        qualification.setBounds(300,290,400,30);
        qualification.setBackground(Color.WHITE);
        add(qualification);

        JLabel occupationn =new JLabel("OCCUPATION:");
        occupationn.setFont(new Font("Raleway",Font.BOLD,20));
        occupationn.setBounds(100,340,200,30);
        add(occupationn);
        String[] occupationCategory={"Salary Based","Self Employee","Student","Retired","Others"};
        occupation=new JComboBox<>(occupationCategory);
        occupation.setBounds(300,340,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);


        JLabel pann =new JLabel("PAN NUMBER");
        pann.setFont(new Font("Raleway",Font.BOLD,20));
        pann.setBounds(100,390,200,30);
        add(pann);
        panTextField=new JTextField();
        panTextField.setFont(new Font("Raleway",Font.BOLD,14));
        panTextField.setBounds(300,390,400,30);
        add(panTextField);

        JLabel aadharr =new JLabel("AADHAR NUMBER:");
        aadharr.setFont(new Font("Raleway",Font.BOLD,20));
        aadharr.setBounds(100,440,200,30);
        add(aadharr);
        aadharTextField=new JTextField();
        aadharTextField.setFont(new Font("Raleway",Font.BOLD,14));
        aadharTextField.setBounds(300,440,400,30);
        add(aadharTextField);

        JLabel citizenn =new JLabel("SENIOR CITIZEN:");
        citizenn.setFont(new Font("Raleway",Font.BOLD,20));
        citizenn.setBounds(100,490,200,30);
        add(citizenn);
        syes=new JRadioButton("YES");
        syes.setBounds(300,490,120,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        sno=new JRadioButton("NO");
        sno.setBounds(450,490,120,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        ButtonGroup seniorCitizenGroup= new ButtonGroup();
        seniorCitizenGroup.add(syes);
        seniorCitizenGroup.add(sno);

        JLabel existingg =new JLabel("EXISTING A/C:");
        existingg.setFont(new Font("Raleway",Font.BOLD,20));
        existingg.setBounds(100,540,200,30);
        add(existingg);
        eyes=new JRadioButton("YES");
        eyes.setBounds(300,540,120,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        eno=new JRadioButton("NO");
        eno.setBounds(450,540,120,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        ButtonGroup existingGroup= new ButtonGroup();
        existingGroup.add(eyes);
        existingGroup.add(eno);


        next=new JButton("NEXT");
        next.setForeground(Color.WHITE);
        next.setBackground(Color.BLACK);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);


        setSize(850,800);
        setLocation(350,10);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new SignupTwo("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       String sreligion = (String) religion.getSelectedItem();
       String scategory=(String) category.getSelectedItem();
       String sincome=(String) income.getSelectedItem();
       String squalification=(String) qualification.getSelectedItem();
       String soccupation=(String) occupation.getSelectedItem();
       String seniorcitizen=null;
        if(syes.isSelected())
        {
            seniorcitizen="YES";
        }
        else if(sno.isSelected())
        {
            seniorcitizen="NO";
        }
        String existingaccount=null;
        if(eyes.isSelected())
        {
            existingaccount="YES";
        }
        else if (eno.isSelected())
        {
            existingaccount="NO";
        }

        String span=panTextField.getText();
        String saadhar=aadharTextField.getText();

        try
        {
                Conn c=new Conn();
                String query="insert into signuptwo values( '"+formno+"','"+sreligion+"' ,'"+scategory+"' ,'"+sincome+"' ,'"+squalification+"' ,'"+soccupation+"' ,'"+span+"' ,'"+saadhar+"' ,'"+seniorcitizen+"' ,'"+existingaccount+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupThree(formno).setVisible(true);

        }
        catch (Exception ae)
        {
            System.out.println(ae);
        }
    }
}