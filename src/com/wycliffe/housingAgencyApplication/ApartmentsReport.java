package com.wycliffe.housingAgencyApplication;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.util.Date;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
/**
 *
 * @author Wycliffe.Ochieng
 */
public class ApartmentsReport  {
    String SQLPayments = "select * from apartments";
    ResultSet rsRpt;
    Statement stRpt;
    String filename = new SimpleDateFormat("yyyyMMddHHmm'.pdf'").format(new Date());
    String currency="Kes.", FileBaseName="Apartments", agent="Brightercom";
    Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
    
    
    public void apartmentsReports() throws FileNotFoundException, DocumentException, IOException{
    try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/housing?useSSL=true","root","prof1989*");
        stRpt = conn.createStatement(rsRpt.TYPE_SCROLL_SENSITIVE, rsRpt.CONCUR_UPDATABLE);
        rsRpt = stRpt.executeQuery(SQLPayments);
        
        ResultSetMetaData rsmd = rsRpt.getMetaData();
        int columnCount = rsmd.getColumnCount();
        rsRpt.first();
        Document pdf = new Document(PageSize.A4.rotate());
        
       PdfWriter.getInstance(pdf,new FileOutputStream("E:\\prof\\"+FileBaseName+filename));
       Image img = Image.getInstance("E:\\Wycliffe\\Apps\\JAVA_Projects\\HousingAgencyApp\\src\\payrollsystem\\brighter5.JPG");
        img.setWidthPercentage(100);
        img.scaleToFit(770f, 112f);
       
       
       
       
       PdfPTable printTable = new PdfPTable(7);
       
       
        printTable.setWidthPercentage(100);
        Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);

            printTable.addCell("Apartment ID");
            printTable.addCell("Apartment Name");
            printTable.addCell("Apartment Agent");
            printTable.addCell("Location Name");
            printTable.addCell("Number of Rooms");
            printTable.addCell("Status");
            printTable.addCell("Owner's A/c No");
            
            
            printTable.setHeaderRows(1);
            pdf.open();
        
            System.out.println(columnCount);
            pdf.open();
            Paragraph pg =new Paragraph("",boldFont);
            Date date =new Date();
            String sDate = date.toString();
            pg.add("Apartments Report"+"\n"+sDate+"\n");
            pg.setAlignment(Element.ALIGN_CENTER);
            pdf.add(pg);
        
            Paragraph pgLogo =new Paragraph("",boldFont);//Start of second paragraph
            pgLogo.setAlignment(Element.ALIGN_CENTER);
            pgLogo.add(img);
            pgLogo.add(" ");
            pdf.add(pgLogo);//End of second paragraph
        do
        {
                    printTable.addCell(rsRpt.getString("apartment_id"));
                    printTable.addCell(rsRpt.getString("apartment_name"));
                    printTable.addCell(agent+": "+rsRpt.getString("agent_id"));
                    printTable.addCell(rsRpt.getString("location_id"));
                    printTable.addCell(rsRpt.getString("rooms"));
                    printTable.addCell(rsRpt.getString("status"));              
                    printTable.addCell(rsRpt.getString("owner_id"));
                    
        }while(rsRpt.next());
        pdf.add(printTable);
        Font boldFont1 = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLD);
        Paragraph pgCom =new Paragraph("",boldFont1);
        pgCom.add(" ");
        pgCom.add("Prepared By : Isaac Watari Ngigi on: "+sDate+"\n"); 		
        pgCom.add("");
        pgCom.add("___________________________________________________________________________");
        pgCom.add("___________________________________________________________________________");
        pgCom.setAlignment(Element.ALIGN_BOTTOM);
        pdf.add(pgCom);//add third paragraph
        
        pdf.close();
        
        if(Desktop.isDesktopSupported()){
            
           File report = new File("E:/prof/"+FileBaseName+filename);
            Desktop.getDesktop().open(report);
        }
        }   
    catch(ClassNotFoundException | SQLException e){
         JOptionPane.showMessageDialog(null, "Something went wrong.Please try again!","Reports",JOptionPane.INFORMATION_MESSAGE);
    }
      
    }
 
    public static void main(String[] args) throws FileNotFoundException, DocumentException , IOException{
        ApartmentsReport Obj =  new ApartmentsReport();
        Obj.apartmentsReports();
    }    
}
