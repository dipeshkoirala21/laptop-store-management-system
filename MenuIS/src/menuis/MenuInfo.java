/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menuis;

/**
 *
 * @author Nilej, Dipesh, Niku, Ganesh
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class MenuInfo implements ActionListener {
    
    private JFrame frame;
    private JLabel Serial,modelName,brandName,vat,price,search,status;
    private JTextField txtSerial,txtModelName,txtVat,txtPrice,txtSearch;
    private JButton btnInsert, btnClear, btnClearTable, btnView,btnSearch,btnExit;
    private JComboBox brand,categorycombo;
    private JTable info;
    private JRadioButton highEnd,lowEnd,normal,available,notAvail;
    private JPanel panel,left,right,left2;
    private  int tablecounter=0;
    private JMenuBar menu;
    public static ArrayList<MenuDetails> list;  

    public MenuInfo()
    {
        /*this is the constructor method. this initializes the array list created from MenuDetails class 
        this method is responsible for creating the layout and components of the GUI*/
        list = new ArrayList <MenuDetails>();
        
        frame = new JFrame ("Hamro Laptop Store");
        Container panel = frame.getContentPane();
        panel.setBackground(new java.awt.Color(95, 112, 117));
        panel.setLayout(null);
        
        JPanel mainPanel = new JPanel();
                panel.add(mainPanel);
                mainPanel.setBackground(new java.awt.Color(97,212,195));
                mainPanel.setLayout(null);
                mainPanel.setBounds(0,0,420,700);
                
        JPanel panel1 = new JPanel();
                mainPanel.add(panel1);
                panel1.setBackground(new java.awt.Color(97,212,195));
                panel1.setLayout(null);
                panel1.setBounds(10,150,400,500);
        
        menu = new JMenuBar();
        frame.setJMenuBar (menu);
        
         JMenu fileMenu = new JMenu ("File");
        menu.add(fileMenu);
       
         ImageIcon iconLogo3 = new ImageIcon("Images/Open.png");
        JMenuItem openItem = new JMenuItem("Open");
        openItem.setIcon(iconLogo3);
        fileMenu.add(openItem);
        openItem.addActionListener(this);
        
        ImageIcon iconLogo4 = new ImageIcon("Images/exit.png");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setIcon(iconLogo4);
        fileMenu.add(exitItem);
        exitItem.addActionListener(this);
        
        JMenu helpMenu = new JMenu ("Help");
        menu.add(helpMenu);
        
        ImageIcon iconLogo5 = new ImageIcon("Images/About.png");
        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.setIcon(iconLogo5);
        helpMenu.add(aboutItem);
        aboutItem.addActionListener(this);
        
        ImageIcon iconLogo6 = new ImageIcon("Images/userguide.png");
        JMenuItem helpItem = new JMenuItem("User Guide");
        helpItem.setIcon(iconLogo6);
        helpMenu.add(helpItem);
        helpItem.addActionListener(this);
        
        ImageIcon iconLogo = new ImageIcon("Images/Logo.png");
        JLabel lblLogo = new JLabel();
        lblLogo.setIcon(iconLogo);
        lblLogo.setBounds(0,10,400,120);
        mainPanel.add(lblLogo);
        
        ImageIcon iconLogo2 = new ImageIcon("Images/Logo2.png");
        JLabel lblLogo2 = new JLabel();
        lblLogo2.setIcon(iconLogo2);
        lblLogo2.setBounds(430,10,900,120);
        panel.add(lblLogo2);
        
        search = new JLabel("Search By Price :");
        search.setBounds(600,150, 170, 40);
        search.setForeground(Color.white);
        search.setFont(new Font("Segoe Script", Font.BOLD, 18));
        panel.add(search);
        
        txtSearch = new JTextField();
        txtSearch.setBounds(800,150,300,40);
        txtSearch.setForeground(new java.awt.Color(51,0, 51));
        txtSearch.setFont(new Font("Segoe Script", Font.PLAIN, 14));
        panel.add(txtSearch);
        
       ImageIcon search = new ImageIcon("Images/search.png");
        btnSearch = new JButton("Search");
        btnSearch.setIcon(search);
        btnSearch.setBounds(1150,150,140,40);
        btnSearch.setForeground(new java.awt.Color(51,0, 51));
        btnSearch.setFont(new Font("Segoe Script", Font.PLAIN, 18));
        panel.add(btnSearch);
        btnSearch.addActionListener(this);
        
        left = new JPanel();
        left.setLayout(null);
        left.setBorder (BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder (),
                "Define Laptop Info",TitledBorder.CENTER,TitledBorder.TOP,
                new java.awt.Font("Segoe Script", 1, 20), new java.awt.Color(0,0,0)));
        left.setBackground(new java.awt.Color(97,212,195));
        left.setBounds(0,0,400,500);
        panel1.add(left);
        
        Serial = new JLabel ("Serial Number");
        Serial.setBounds (20,40,140,40);
        Serial.setForeground(new java.awt.Color(51,0, 51));
        Serial.setFont(new Font("Segoe Script", Font.PLAIN, 16));
        left.add(Serial);
        
        txtSerial = new JTextField();
        txtSerial.setBounds(170,40,180,40);
        txtSerial.setEnabled(false);
        txtSerial.setText("1");
        left.add(txtSerial);
        
        modelName = new JLabel ("Model Name");
        modelName.setBounds(20, 90, 140, 40);
        modelName.setForeground(new java.awt.Color(51,0, 51));
        modelName.setFont(new Font("Segoe Script", Font.PLAIN, 16));
        left.add(modelName);
        
        txtModelName = new JTextField();
        txtModelName.setBounds(170,90,180,40);
        left.add(txtModelName);
        
        brandName = new JLabel("Brand Name"); 
        brandName.setBounds(20,140,140,40);
        brandName.setForeground(new java.awt.Color(51,0, 51));
        brandName.setFont(new Font("Segoe Script", Font.PLAIN, 16));
        left.add(brandName);
        
        brand = new JComboBox();
        brand.addItem("DELL");
        brand.addItem("LENOVO");
        brand.addItem("HP");
        brand.addItem("ASUS");
        brand.addItem("ACER");
        brand.addItem("MSI");
        brand.addItem("TOSHIBA");
        
        brand.setBounds (170,140,180,40);
        brand.setForeground(new java.awt.Color(51,0, 51));
        brand.setFont(new Font("Segoe Script", Font.PLAIN, 16));
        left.add(brand);
        
        left2 = new JPanel();
        left2.setBounds(30,195,330,70);
        left2.setLayout(new FlowLayout());
        left2.setBorder (BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder (),
                "Category",TitledBorder.CENTER,TitledBorder.TOP ,
                new java.awt.Font("Segoe Script", 1, 15), new java.awt.Color(0,0,0)));
        left2.setBackground(new java.awt.Color(97,212,195));
        left.add(left2);
        
        lowEnd = new JRadioButton ("Low End");
        lowEnd.setSelected(true);
        lowEnd.setBackground(new java.awt.Color(97,212,195));
        lowEnd.setForeground(new java.awt.Color(51,0, 51));
        lowEnd.setFont(new Font("Segoe Script", Font.PLAIN, 16));
        left2.add(lowEnd);
        
        normal = new JRadioButton ("Normal");
        normal.setBackground(new java.awt.Color(97,212,195));
        normal.setForeground(new java.awt.Color(51,0, 51));
        normal.setFont(new Font("Segoe Script", Font.PLAIN, 16));
        left2.add(normal);
        
        highEnd = new JRadioButton ("High End");
        highEnd.setBackground(new java.awt.Color(97,212,195));
        highEnd.setForeground(new java.awt.Color(51,0, 51));
        highEnd.setFont(new Font("Segoe Script", Font.PLAIN, 16));
        left2.add(highEnd);
        
        ButtonGroup categoryGroup = new ButtonGroup();
                categoryGroup.add(lowEnd);
                categoryGroup.add(normal);
                categoryGroup.add(highEnd);
        
        
        vat = new JLabel("VAT (0-20)");
        vat.setBounds(20,275,180,40);
        vat.setForeground(new java.awt.Color(51,0, 51));
        vat.setFont(new Font("Segoe Script", Font.PLAIN, 16));
        left.add(vat);
        
        txtVat = new JTextField();
        txtVat.setBounds(170,275,180,40);
        left.add(txtVat);
        
        price = new JLabel("Price");
        price.setBounds(20,325,140,40);
        price.setForeground(new java.awt.Color(51,0, 51));
        price.setFont(new Font("Segoe Script", Font.PLAIN, 16));
        left.add(price);
        
        txtPrice = new JTextField();
        txtPrice.setBounds(170,325,180,40);
        left.add(txtPrice);
        
        status = new JLabel ("Staus");
        status.setBounds(20,370,140,40);
        status.setForeground(new java.awt.Color(51,0, 51));
        status.setFont(new Font("Segoe Script", Font.PLAIN, 16));
        left.add(status);
        
        available = new JRadioButton("Available");
        available.setSelected(true);
        available.setBounds(130,370,100,40);
        available.setBackground(new java.awt.Color(97,212,195));
        available.setForeground(new java.awt.Color(51,0, 51));
        available.setFont(new Font("Segoe Script", Font.PLAIN, 14));
        left.add(available);
        
        notAvail = new JRadioButton("Not Available");
        notAvail.setBounds(240,370,140,40);
        notAvail.setBackground(new java.awt.Color(97,212,195));
        notAvail.setForeground(new java.awt.Color(51,0, 51));
        notAvail.setFont(new Font("Segoe Script", Font.PLAIN, 14));
        left.add(notAvail);
        
        ButtonGroup statusGroup = new ButtonGroup();
        statusGroup.add(available);
        statusGroup.add(notAvail);
        
        ImageIcon insrt = new ImageIcon("Images/insert.png");
        btnInsert = new JButton ("Insert");
        btnInsert.setIcon(insrt);
        btnInsert.setBounds(25,445,140,40);
        btnInsert.setForeground(new java.awt.Color(51,0, 51));
        btnInsert.setFont(new Font("Segoe Script", Font.PLAIN, 18));
        left.add(btnInsert);
        btnInsert.addActionListener(this);
        
        ImageIcon clear = new ImageIcon("Images/clear.png");
        btnClear = new JButton ("Clear");
        btnClear.setIcon(clear);
        btnClear.setBounds(230,445,140,40);
        btnClear.setForeground(new java.awt.Color(51,0, 51));
        btnClear.setFont(new Font("Segoe Script", Font.PLAIN, 18));
        left.add(btnClear);
        btnClear.addActionListener(this); 
        
        right = new JPanel();
        right.setBounds (430,200,900,450);
        right.setBackground(new java.awt.Color(95, 112, 117));
        right.setLayout(null);
        right.setBorder (BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder (),
                "Laptop Details",TitledBorder.CENTER,TitledBorder.TOP, 
                new java.awt.Font("Segoe Script", 1, 20), new java.awt.Color(255, 255, 255)));

        panel.add(right);
        
        String data[][] = new String [18][6];
        String tableHeader[] = {"SerialNumber","Model Number","BrandName","Category","Price","Status"};
        info = new JTable(data,tableHeader);
        JScrollPane sp = new JScrollPane(info,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp.setBounds(10,30,880,300);
        right.add(sp);
        
        ImageIcon catView = new ImageIcon("Images/view.png");
        btnView = new JButton("Category View");
        btnView.setIcon(catView);
        btnView.setBounds(200,350,180,40);
        btnView.setForeground(new java.awt.Color(51,0, 51));
        btnView.setFont(new Font("Segoe Script", Font.PLAIN, 14));
        right.add(btnView);
        btnView.addActionListener(this);
        
        categorycombo = new JComboBox();
        categorycombo.addItem("High End");
        categorycombo.addItem("Normal");
        categorycombo.addItem("Low End");
        
        categorycombo.setBounds(40,350,140,40);
        categorycombo.setForeground(new java.awt.Color(51,0, 51));
        categorycombo.setFont(new Font("Segoe Script", Font.PLAIN, 16));
        right.add(categorycombo);
        
        ImageIcon clrTable = new ImageIcon("Images/clear.png");
        btnClearTable = new JButton("Clear Table");
        btnClearTable.setIcon(clrTable);
        btnClearTable.setBounds(740,350,150,40);
        btnClearTable.setForeground(new java.awt.Color(51,0, 51));
        btnClearTable.setFont(new Font("Segoe Script", Font.PLAIN, 14));
        right.add(btnClearTable);
        btnClearTable.addActionListener(this);
        
        ImageIcon exit = new ImageIcon("Images/close.png");
        btnExit = new JButton("Exit");
        btnExit.setIcon(exit);
        btnExit.setBounds(750,400,140,40);
        btnExit.setForeground(new java.awt.Color(51,0, 51));
        btnExit.setFont(new Font("Segoe Script", Font.PLAIN, 18));
        right.add(btnExit);
        btnExit.addActionListener(this);
        
       
        frame.setSize(1366,760);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        
        
    }
    
   
    public String getCategory()
    {/*this method is used to get the category from radio button group
        it stored the selected button in form of string.*/
        if(highEnd.isSelected())
        {
            return highEnd.getText();
        }
        else if(normal.isSelected())
        {
          return normal.getText();  
         }
        else
        {
            return lowEnd.getText();
        }
    }
    
    public String getStatus()
    {/*this method is used to get the availibility status from radio button group
        it stored the selected button in form of string.*/
        if(available.isSelected())
        {
            return available.getText();
        }
        else
        {
            return notAvail.getText();
        }
            
    }
    
    public void onClickOfExitButton()
    {// terminates the program when exit button is clicked
        System.exit(0);
    }
    public void onClickOfInsertButton()
    {/*this button retrieves the data entered by user in left panel of the GUI 
        which includes modelname,brand,category,price,vat,status
        then the values are added in the table as well as arraylist*/
                String serial = txtSerial.getText();
                String model = txtModelName.getText();
                String selectedBrand = (String) brand.getSelectedItem();
                String vat = txtVat.getText();
                String price = txtPrice.getText();
                String category = this.getCategory();
                String status = this.getStatus();
                

                if(model !=null && !model.equals("") && vat != null && !vat.equals("") && price!=null && !price.equals(""))
                {
                    try{
                    int intvat = Integer.parseInt(vat);
                    int intprice = Integer.parseInt(price);
                    double dvat = (double) intvat;
                    double dprice = (double) intprice;
                    double tprice = 0;
                    int serialcounter;
                    String totalprice = "";
                    boolean stat ;
                    if(status == "Available"){
                        stat = true;
                    }
                    else{
                        stat=false;
                    }
                    
                    
                    if (intvat <=20 && intvat >=0){
                        tablecounter ++;
                        int row = tablecounter-1;
                        serialcounter = tablecounter +1;
                        String scount = Integer.toString(serialcounter);
                        tprice = dprice + ((dvat/100)*dprice);
                        totalprice = Double.toString(tprice);
                        
                        info.setValueAt(serial,row,0);
                        info.setValueAt(model,row,1);
                        info.setValueAt(selectedBrand,row,2);
                        info.setValueAt(category,row,3);
                        info.setValueAt(totalprice,row,4);
                        info.setValueAt(status,row,5);
                        
                        txtSerial.setText(scount);
                        intprice = (int) tprice;
                        MenuDetails details = new MenuDetails (serial,model,category,selectedBrand,intvat,intprice,stat);
                        list.add(details);
                        //pricelist.add(intprice);
                    }
                    else {
                        JOptionPane.showMessageDialog(frame, "Error Message\n Enter Vat in range (0-20)", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }catch(NumberFormatException e){
                     JOptionPane.showMessageDialog(frame, "Error Message\n Please enter valid number \n For VAT: Decimals not allowed.",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }  
                else{
                    JOptionPane.showMessageDialog(frame, "Error Message\n Do not leave field blank!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                
            
            
    }
    public void onClickOfClearButton(){
        //clears the fields in left panel of gui where user enters laptop details
            
            txtModelName.setText("");
            txtVat.setText("");
            txtPrice.setText("");
            lowEnd.setSelected(true);
    }
    public void onClickOfClearTableButton(){
        // clears the values in table which is on right side of GUI
          tablecounter = 0;
            for(int index=0; index<20; index++)
            {
                info.setValueAt("", index, 0);
                info.setValueAt("", index, 1);
                info.setValueAt("", index, 2);
                info.setValueAt("", index, 3);
                info.setValueAt("", index, 4);
                info.setValueAt("", index, 5);
            }
     }
    public void onClickOfCategoryViewButton(){
        /*this method is used to view products based on category. this method checks the category selected by user
        then it compares the data in arraylist and displays models with the selected brand*/
        int itemcounter = 0;
            String msg = ",";
            String a = " ";
                String selectedCat = (String) categorycombo.getSelectedItem();
                
                if (selectedCat =="High End")
                {
                    for (MenuDetails d : list)
                    {
                        String categ = d.getCategory();
                        boolean avail = d.getStatus();
                        if(categ==selectedCat){
                            if (avail == true){
                                itemcounter++;
                                a = a+d.getBrand()+": "+d.getModelName()+msg+"\n" ; 
                            }
                        }
                    }
                }
                else if(selectedCat == "Normal"){
                    for (MenuDetails d : list)
                    {
                        String categ = d.getCategory();
                        boolean avail = d.getStatus();
                        if(categ==selectedCat){
                            if (avail == true){
                            itemcounter++;
                             a = a+d.getBrand()+": "+d.getModelName()+msg+"\n" ; 
                            }
                        }
                    }
                }
                else if(selectedCat == "Low End"){
                    for (MenuDetails d : list)
                    {
                        String categ = d.getCategory();
                        boolean avail = d.getStatus();
                        if(categ==selectedCat){
                            if (avail == true){
                            itemcounter++;
                             a = a+d.getBrand()+": "+d.getModelName()+msg+"\n" ; 
                            }
                        }
                    }
                }
                String num = Integer.toString(itemcounter);
                String aa = a.substring(0, a.length() - 2);
                
                JOptionPane.showMessageDialog(null,"There are " + num +" " + selectedCat
                 + " models available. \n" + aa + ".");
        }
    public void onClickOfOpenButton(){
        //opens a sample file
         try{
            Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler "+"Docs\\code.docx");
            }
            catch (Exception e)
            {
            JOptionPane.showMessageDialog(null, "Error");
            }
    }
     public void onClickOfAboutButton(){
         //opens aboutus pop up
            JOptionPane.showMessageDialog(frame, "HAMRO LAPTOP STORE \n Version :1.0 \n Developed by : Dipesh Koirala, Ganesh Oli,Niku Thapa,Nilej Sthapit"
             + "\n Designed by :Dipesh Koirala, Ganesh Oli,Niku Thapa,Nilej Sthapit ","About",JOptionPane.INFORMATION_MESSAGE);
            }
     public void onClickOfUserGuideButton(){
         //opens user guidefile
         try{
            Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler "+"Docs\\help.pdf");
            }
            catch (Exception e)
            {
            JOptionPane.showMessageDialog(null, "Error");
            }
     }
     
     public void onClickOfSearchButton(){
         /*this method is used to search a product based on price
         it retieves the price entered by user then searches the array list to find 
         product with the price entered by user. */
         try {
                   String searched = txtSearch.getText();
                   if(searched != null && searched != "" && !searched.isEmpty()){
                       int keyprice = Integer.parseInt(searched); // get the search keyword
                        MenuDetails.sort(list);
                       
                        int low = 0;

                        int high = list.size() - 1;
                       
                        int searchResult = MenuDetails.binarySearch(list, low, high, keyprice);
                        
                        if (searchResult == -1){
                            txtSearch.setText("");
                            JOptionPane.showMessageDialog(frame, "No products have the price that you have entered.");
                       
                        }
                        else{
                            txtSearch.setText("");
                            boolean avab = list.get(searchResult).getStatus();
                            String Savab;
                            if (avab == true){
                                Savab = "Available";
                            }
                            else{
                             Savab = "Not Available";
                            }
                            JOptionPane.showMessageDialog(frame,"Serial No.: "+list.get(searchResult).getSerialNo()
                                    +"\nBrand: "+list.get(searchResult).getBrand()+"\nCategory: "+
                                    list.get(searchResult).getCategory()+"\nModel Name: "+list.get(searchResult).getModelName()
                                    +"\n Availability:"+Savab,
                                    "Available laptop",JOptionPane.INFORMATION_MESSAGE);
                        }                   
                   }
               
                    else{
                            JOptionPane.showMessageDialog(frame, "Error Message\n do not leave field blank!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
               }
               catch(Exception e){
                   JOptionPane.showMessageDialog(frame, "Enter a valid number.", "ERROR", JOptionPane.ERROR_MESSAGE);
               }
     }
   
    public void actionPerformed(ActionEvent ae)
    {//calls methods based on button clicked.
        String action = ae.getActionCommand();
        if (action.equals("Exit"))
        {
            this.onClickOfExitButton();
        }
        
        else if(action.equals("Insert"))
        {
           this.onClickOfInsertButton();
        }    
        else if (action.equals("Clear"))
        {
           this.onClickOfClearButton();
        }
        else if (action.equals("Clear Table"))
        {   
           this.onClickOfClearTableButton();
        }
        else if (action.equals("Category View"))
        {   
           this.onClickOfCategoryViewButton();
        }
        else if (action.equals("Open"))
        {
           this.onClickOfOpenButton();
        }
        else if (action.equals("About"))
        {
            this.onClickOfAboutButton();
        }
        else if (action.equals("Search"))
        {
            this.onClickOfSearchButton();
	 }
        else if (action.equals("User Guide"))
        {
            this.onClickOfUserGuideButton();
	 }
    }
   
    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } 
        catch (Exception e) {
            // If Nimbus is not available, fall back to cross-platform
            try {
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            } catch (Exception ex) {

            }
        }
        new MenuInfo();
    }
    
}
