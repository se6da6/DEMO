package view;

import javax.swing.JButton;//ayrica sadece import javax.swing.* yazabilirsin hepsi iicin
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.DataModel;

import java.awt.*;

public class MainFrame extends JFrame {

    private Container contentPane;
    private JTable table = new JTable();
    private JPanel titlePanel = new JPanel();
    private JPanel mainPanel = new JPanel();
    private JPanel controlPanel = new JPanel();
    private JLabel lb1Title = new JLabel("Comp305");
    private JButton btnUpdate = new JButton("Update");

    private JScrollPane scrollPane;

    public MainFrame(String title)
    {
        setTitle(title);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initLayout();
    }

    private void initLayout()
    {
        contentPane = this.getContentPane();
        //TitleBar
        contentPane.add(titlePanel, "North");
        titlePanel.add(lb1Title);
        String fontName = lb1Title.getFont().getFontName();
        lb1Title.setFont(new Font(fontName,0,24 ));


        //Main Panel
        mainPanel.setBackground(new Color(0xFF5733));
        contentPane.add(mainPanel, "Center");
        String [] headers = {"Column 1", "Column 2", "Column 3","Column 4" };

        table = new JTable(new DefaultTableModel(DataModel.getData(), headers));
        scrollPane = new JScrollPane(table);
        mainPanel.add(scrollPane);

        btnUpdate.addActionListener(
            event ->{
                table.setModel(new DefaultTableModel(DataModel.getData(), headers));
            }
        );

        //Control Panel
        controlPanel.add(btnUpdate);
        contentPane.add(controlPanel, "South");

        pack();//resize the window automatically

    }
    
    
}
