
package university.management.system;
import java.sql.SQLException;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
//import javax.swing.table.JTableHeader;
//import net.proteanit.sql.DbUtils;

public class ListOfStudents extends UniversityManagementSystem{
//Object fname,lname,gender,mail,phone,address,rollno,cnic,inter,metric,department; 

    ListOfStudents() throws SQLException
    {
        JTable aTable=new JTable();
    // TableModel definition
String[] tableColumnsName = {"fame","lname","gender","Mail","Phone","Address","Roll No.","Cnic","Inter","Metric","Department"}; 
DefaultTableModel aModel = (DefaultTableModel) aTable.getModel();
aModel.setColumnIdentifiers(tableColumnsName);

// the query
ResultSet rs = 
   st.executeQuery("select Sfname,Slname,Sgender,Smail,Sphone,Saddress,Sroll,Scnic,Sinter,Smetric,Sdepartment from Admission;");

// Loop through the ResultSet and transfer in the Model
java.sql.ResultSetMetaData rsmd = rs.getMetaData();
int colNo = rsmd.getColumnCount();
while(rs.next()){
 Object[] objects = new Object[colNo];
 // tanks to umit ozkan for the bug fix!
 for(int i=0;i<colNo;i++){
  objects[i]=rs.getObject(i+1);
  }
 aModel.addRow(objects);
}
aTable.setFont(new Font("",Font.BOLD,15));
aTable.setEnabled(false);
aTable.setModel(aModel);

        
        JFrame listofstudentsframe=new JFrame("List Of Students");
        listofstudentsframe.setBounds(0,0,1400,700);
        ImageIcon ii=new ImageIcon("E:\\eidulfitr\\d1.png");
        listofstudentsframe.setIconImage(ii.getImage());
        JScrollPane scp=new JScrollPane(aTable);
        listofstudentsframe.add(scp);
        listofstudentsframe.setVisible(true);
       
    }
    
}


