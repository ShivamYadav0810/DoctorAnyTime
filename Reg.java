package SIH;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Reg")
public class Reg extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Reg() {
        super();
        
    }
  public static String Patients_Name,Email,Medician1,Medician2,Medician3,Age,DOB,Gender,Phone_Number,dosage1,duration1,dosage2,duration2,dosage3,duration3;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter inp =response.getWriter();
		response.setContentType("text/html");
		//String Patients_Name,Email,Medician1,Medician2,Medician3,Age,DOB,Gender,Phone_Number,dosage1,duration1,dosage2,duration2,dosage3,duration3;
		Patients_Name=request.getParameter("Patient's_name".toString());
		Age=request.getParameter("Age".toString());
		DOB=request.getParameter("DOB".toString());
		Gender=request.getParameter("gender".toString());
		Email=request.getParameter("email".toString());
		Phone_Number=request.getParameter("phone".toString());
		Medician1=request.getParameter("Medicine_1".toString());
		dosage1=request.getParameter("1_dosage".toString());
		duration1=request.getParameter("1_Duration".toString());
		Medician2=request.getParameter("Medicine_2".toString());
		dosage2=request.getParameter("2_dosage".toString());
		duration2=request.getParameter("2_Duration".toString());
		Medician3=request.getParameter("Medicine_3".toString());
		dosage3=request.getParameter("3_dosage".toString());
		duration3=request.getParameter("3_Duration".toString());
		
		

			String sql="insert into tb_patient24 values("+"'"+Patients_Name+"'"+","+"'"+Email+"'"+","+"'"+Medician1+"'"+","+"'"+Medician2+"'"+","+"'"+Medician3+"'"+","+"'"+Age+"'"+","+"'"+DOB+"'"+","+"'"+Gender+"'"+","+"'"+Phone_Number+"'"+","+"'"+dosage1+"'"+","+"'"+duration1+"'"+","+"'"+dosage2+"'"+","+"'"+duration2+"'"+","+"'"+dosage3+"'"+","+"'"+duration3+"'"+")";
			try
			{
				String url="jdbc:mysql://localhost:3306/testdb?autoReconnect=true&use SSL=false&allowPublicKeyRetrieval=true";
				String Uname="root";
				String pass="goat";
					
				
				Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection(url,Uname,pass);
					Statement st=con.createStatement();
					st.executeUpdate(sql);
			inp.println("Prescription Uploaded Succesfully");
			st.close();
			con.close();
		}catch(Exception e)
		{
			/*out.println("Opps! Something went Wrong");
			out.println("Contact Support Team");*/
			inp.println(e);
		}
		String a[]= {"Patients_Name","Email","Medician1","Medician2","Medician3","Age","DOB","Gender","Phone_Number","dosage1","duration1","dosage2","duration2","dosage3","duration3"};
	String c[]= {Patients_Name, Email,Medician1,Medician2,Medician3,Age,DOB,Gender,Phone_Number,dosage1,duration1,dosage2,duration2,dosage3,duration3};
//			for(int i=0;i<15;i++) {
//				out.println(a[i]+c[i]);}
		try {
				
		String h[]=new String[15];
		
		FileOutputStream fr=new FileOutputStream(Patients_Name+".txt");
	//	System.setOut(new PrintStream(new FileOutputStream(Patients_Name+".txt")));
		for (int j=0;j<15;j++)
		{
			h[j]=a[j]+":"+c[j];
		}
		String f=h[0]+" "+h[1]+" "+h[2]+" "+h[3]+" "+h[4]+h[5]+h[6]+h[7]+h[8]+h[9]+h[10]+h[11]+h[12]+h[13]+h[14];
		byte []b=f.getBytes();
		for(int i=0;i<b.length;i++)
		{
			fr.write(b[i]);
		
		}
		
		}

			catch(Exception e)
			{
				inp.println("OOPS! Something Went Wrong");
				inp.println("Contact Developer");
			}
		MyEmail2 em=new MyEmail2();
	em.SendMail(Email,Patients_Name);
		
	}
	
		
		
//		
////		
////		
////		void SendMail(String Email,String Patients_Name) {
//	      // Recipient's email ID needs to be mentioned.
//	      String to = Email;
//		// String to ="email";
//	      // Sender's email ID needs to be mentioned
//	      String from = "doctoranytime0@gmail.com";
//
//	      final String username = "doctoranytime0@gmail.com";//change accordingly
//	      final String password = "BugHunterSquad";//change accordingly
//
//	      // Assuming you are sending email through relay.jangosmtp.net
//	      String host = "smtp.gmail.com";
//
//	      Properties props = new Properties();
//	      props.put("mail.smtp.auth", "true");
//	      props.put("mail.smtp.starttls.enable", "true");
//	      props.put("mail.smtp.host", host);
//	      props.put("mail.smtp.port", "25");
//
//	      // Get the Session object.
//	      Session session = Session.getInstance(props,
//	         new javax.mail.Authenticator() {
//	            protected PasswordAuthentication getPasswordAuthentication() {
//	               return new PasswordAuthentication(username, password);
//	            }
//	         });
//
//	      try {
//	         // Create a default MimeMessage object.
//	         Message message = new MimeMessage(session);
//
//	         // Set From: header field of the header.
//	         message.setFrom(new InternetAddress(from));
//
//	         // Set To: header field of the header.
//	         message.setRecipients(Message.RecipientType.TO,
//	            InternetAddress.parse(to));
//
//	         // Set Subject: header field
//	         message.setSubject("Testing Subject");
//
//	         // Create the message part
//	         BodyPart messageBodyPart = new MimeBodyPart();
//
//	         // Now set the actual message
//	         messageBodyPart.setText("This is message body");
//
//	         // Create a multipar message
//	         Multipart multipart = new MimeMultipart();
//
//	         // Set text message part
//	         multipart.addBodyPart(messageBodyPart);
//
//	         // Part two is attachment
//	         messageBodyPart = new MimeBodyPart();
//	         String filename = "/Users/shivam/Desktop/"+"Shivam"+".txt";
//	         DataSource source = new FileDataSource(filename);
//	         messageBodyPart.setDataHandler(new DataHandler(source));
//	         messageBodyPart.setFileName(filename);
//	         multipart.addBodyPart(messageBodyPart);
//
//	         // Send the complete message parts
//	         message.setContent(multipart);
//
//	         // Send message
//	         Transport.send(message);
//
//	         System.out.println("Sent message successfully....");
//	  
//	      } catch (MessagingException e) 
//	      {
//	         throw new RuntimeException(e);
//	      }
//	   }
////MyEmail2 em=new MyEmail2();
////em.SendMail(Email,Patients_Name);
///	
		
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
//	public static void main(String args[])
//	{
////		void SendMail(String Email,String Patients_Name) {
//	      // Recipient's email ID needs to be mentioned.
//	      String to = Email;
//		// String to ="email";
//	      // Sender's email ID needs to be mentioned
//	      String from = "doctoranytime0@gmail.com";
//
//	      final String username = "doctoranytime0@gmail.com";//change accordingly
//	      final String password = "BugHunterSquad";//change accordingly
//
//	      // Assuming you are sending email through relay.jangosmtp.net
//	      String host = "smtp.gmail.com";
//
//	      Properties props = new Properties();
//	      props.put("mail.smtp.auth", "true");
//	      props.put("mail.smtp.starttls.enable", "true");
//	      props.put("mail.smtp.host", host);
//	      props.put("mail.smtp.port", "25");
//
//	      // Get the Session object.
//	      Session session = Session.getInstance(props,
//	         new javax.mail.Authenticator() {
//	            protected PasswordAuthentication getPasswordAuthentication() {
//	               return new PasswordAuthentication(username, password);
//	            }
//	         });
//
//	      try {
//	         // Create a default MimeMessage object.
//	         Message message = new MimeMessage(session);
//
//	         // Set From: header field of the header.
//	         message.setFrom(new InternetAddress(from));
//
//	         // Set To: header field of the header.
//	         message.setRecipients(Message.RecipientType.TO,
//	            InternetAddress.parse(to));
//
//	         // Set Subject: header field
//	         message.setSubject("Testing Subject");
//
//	         // Create the message part
//	         BodyPart messageBodyPart = new MimeBodyPart();
//
//	         // Now set the actual message
//	         messageBodyPart.setText("This is message body");
//
//	         // Create a multipar message
//	         Multipart multipart = new MimeMultipart();
//
//	         // Set text message part
//	         multipart.addBodyPart(messageBodyPart);
//
//	         // Part two is attachment
//	         messageBodyPart = new MimeBodyPart();
//	         String filename = "/Users/shivam/Desktop/"+"Shivam"+".txt";
//	         DataSource source = new FileDataSource(filename);
//	         messageBodyPart.setDataHandler(new DataHandler(source));
//	         messageBodyPart.setFileName(filename);
//	         multipart.addBodyPart(messageBodyPart);
//
//	         // Send the complete message parts
//	         message.setContent(multipart);
//
//	         // Send message
//	         Transport.send(message);
//
//	         System.out.println("Sent message successfully....");
//	  
//	      } catch (MessagingException e) {
//	         throw new RuntimeException(e);
//	      }
//	   }
	}
	


