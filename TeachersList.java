
package university.management.system;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static university.management.system.UniversityManagementSystem.st;


public class TeachersList extends UniversityManagementSystem{
    
    public TeachersList() throws SQLException
    {
        JTable aTable=new JTable();
    // TableModel definition
String[] tableColumnsName = {"fame","lname","gender","Mail","Phone","Address","ID","Cnic","Qualification","Subject Alloted","Salary"}; 
DefaultTableModel aModel = (DefaultTableModel) aTable.getModel();
aModel.setColumnIdentifiers(tableColumnsName);

// the query
ResultSet rs = 
   st.executeQuery("select Tfname,Tlname,Tgender,Tmail,Tphone,Taddress,Tid,Tcnic,Tqua,Tsub,Tsalary from Teacher;");

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

        
        JFrame listofteachersframe=new JFrame("List Of Teachers");
        listofteachersframe.setBounds(0,0,1400,700);
        ImageIcon ii=new ImageIcon("E:\\eidulfitr\\d1.png");
        listofteachersframe.setIconImage(ii.getImage());
        JScrollPane scp=new JScrollPane(aTable);
        listofteachersframe.add(scp);
        listofteachersframe.setVisible(true);
       
    }
}
