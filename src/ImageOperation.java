import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
//-----------------------------------------------------------------------------------
public class ImageOperation {
    public static void operate(int key)
    {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);			        // Select file to open
        File file = fileChooser.getSelectedFile();
        try
        {
            FileInputStream fis = new FileInputStream(file);
            
            byte[] data = new byte[fis.available()];
            fis.read(data);
            int i=0;
            for(byte b:data)
            {
                data[i] = (byte)(b^key);
                i++;
            }
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null,"Done !!");

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
//-----------------------------------------------------------------------------------
    public static void main(String[] args) {
        System.out.println("- Welcome to, -Image Vault- !!");
//-----------------------------------------------------------------------------------
        //Creating Frame
        JFrame jframe = new JFrame();
        jframe.setTitle("|- Image Vault -|");
        jframe.setSize(320,200);
        jframe.setResizable(false);
        jframe.setLocationRelativeTo(null);  				     // Center aligned
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // To close window
        //--//Logo
        ImageIcon image = new ImageIcon("lock.png");
        jframe.setIconImage(image.getImage());
        //--//Background
        //jframe.getContentPane().setBackground(Color.gray);
        jframe.getContentPane().setBackground(new Color(30,30,30));
//-----------------------------------------------------------------------------------
        //Creating Label(Display)
        JLabel jlabel = new JLabel();
        jlabel.setText("-> First Enter The Pin : ");
        jlabel.setForeground(Color.white);
        jlabel.setFont(new Font ("courier new",Font.PLAIN,20));
//-----------------------------------------------------------------------------------
        //Creating button
        JButton jbutton=new JButton();
        jbutton.setText("Click to select an Image");
        jbutton.setFocusable(false);				   //Removes the irritating box
        jbutton.setForeground(Color.black);
        jbutton.setBackground(Color.gray);
        Font font=new Font("Sans-serif",Font.BOLD,20);
        jbutton.setFont(font);
        jbutton.setBorder(BorderFactory.createEtchedBorder());         //Border
        //jbutton.setEnabled(false);				                   //To disable
//-----------------------------------------------------------------------------------
        //Creating text field
        JTextField textField=new JTextField(10);
        textField.setFont(font);    
//-----------------------------------------------------------------------------------  
        jbutton.addActionListener(e->{
            System.out.println("Processing....");
            String text=textField.getText();
            int temp=Integer.parseInt(text);
            operate(temp);
        });
//-----------------------------------------------------------------------------------
        jframe.setLayout(new FlowLayout());
        jframe.add(jlabel);
        jframe.add(textField);
        jframe.add(jbutton);
        jframe.setVisible(true);   
    }
}