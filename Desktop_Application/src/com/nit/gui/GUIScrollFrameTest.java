package com.nit.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GUIScrollFrameTest extends JFrame implements ActionListener, WindowListener {
  
	private static final String GET_STUDENT_QUERY="SELECT SNO, SNAME, SADD, AVG FROM STUDENT";
	
   private JLabel lsno,lsname,laddrs,lavg;
   private JTextField tsno,tsname,taddrs,tavg;
   private JButton bFirst,bLast,bPrevious,bNext;
   private Connection con;
   private PreparedStatement ps;
   private ResultSet rs;
   
	public GUIScrollFrameTest() {
	  System.out.println("GUIScrollFrameTest:: 0-param constructor start");
	   setTitle("GUIFrontEnd-Scroll Frame");
	   setSize(250, 250);
	   setLayout(new FlowLayout());
	   
	   //add comps
	   lsno = new JLabel("Student no:");
	   add(lsno);
	   tsno = new JTextField(10);
	   add(tsno);
	   
	   lsname = new JLabel("Student name:");
	   add(lsname);
	   tsname = new JTextField(10);
	   add(tsname);
	   
	    laddrs = new JLabel("Student add:");
	   add(laddrs);
	    taddrs = new JTextField(10);
	   add(taddrs);
	   
	    lavg = new JLabel("Student avg:");
	   add(lavg);
	    tavg = new JTextField(10);
	   add(tavg);
	   
	    bFirst = new JButton("First");
	    bNext = new JButton("Next");
	    bPrevious = new JButton("Previous");
	    bLast = new JButton("Last");
	   add(bFirst); add(bNext); add(bPrevious); add(bLast);
	   
	   //register and activate ActionListener for all the 4 buttons
	   bFirst.addActionListener(this);
	   bNext.addActionListener(this);
	   bPrevious.addActionListener(this);
	   bLast.addActionListener(this);
	   
	   //add WindowListener to frame
	   this.addWindowListener(this);
	   
	   //disable editing on text boxes
	   tsno.setEditable(false);
	   tsname.setEditable(false);
	   taddrs.setEditable(false);
	   tavg.setEditable(false);
	   
	   setVisible(true);
	   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//the closing of frame window will terminates 
	                                                   //application flow
	   System.out.println("GUIScrollFrameTest:: 0-param constructor end");
	   
	   initializeJDBC();
   }                
	
	private void initializeJDBC() {
				
		try {
			
			//establish the connection 
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
			//create PreparedStatement obj
			PreparedStatement ps = con.prepareStatement(GET_STUDENT_QUERY, 
					                                    ResultSet.TYPE_SCROLL_INSENSITIVE, 
					                                    ResultSet.CONCUR_UPDATABLE);
			//prepare scrollable RS obj
			rs = ps.executeQuery();
		}//try
		catch (SQLException se) {
			se.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("GUIScrollFrameTest.main() start");
		new GUIScrollFrameTest(); //anonymous object
		System.out.println("end of main method");
	}


	@Override
	public void actionPerformed(ActionEvent ae) {
		System.out.println("GUIScrollFrameTest.actionPerformed()");
		
		boolean flag = false;
		if(ae.getSource()==bFirst) {
			System.out.println("First button is clicked");
			try {
				rs.first();
				flag = true;
				
			} 
			catch (SQLException se) {
				se.printStackTrace();
			}
			
		}
		else if (ae.getSource()==bNext) {
			System.out.println("Next button is clicked");
		          try {
		        	  if(!rs.isLast()) {
		        		  rs.next();
		        		  flag = true;
		        	  }
		          } catch (SQLException se) {
		        	  se.printStackTrace();
		          }
			
		}
		else if(ae.getSource()==bPrevious) {
			System.out.println("Previous button is clicked");
	           try {
	        	   if (!rs.isFirst()) {
	        		   rs.previous();
	        		   flag = true;
	        	   }
	           } 
	           catch (SQLException se) {
	        	   se.printStackTrace();
	           }
						
		}
		else {
			System.out.println("Last button is clicked");
			try {
				rs.last();
				flag = true;
			}
			catch (SQLException se) {
				se.printStackTrace();
			}
		}//else
		
		if (flag==true) {
			try {
	
			tsno.setText(rs.getString(1));
			tsname.setText(rs.getString(2));
			taddrs.setText(rs.getString(3));
			tavg.setText(rs.getString(4));
			}
			catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("GUIScrollFrameTest.windowClosing()");
		try {
			if(rs!=null)
				rs.close();
		}
		catch (SQLException se) {
			se.printStackTrace();
		}
		try {
			if(ps!=null)
				ps.close();
		}
		catch (SQLException se) {
			se.printStackTrace();
		}
		try {
			if(con!=null)
				con.close();
			System.out.println("GUIScrollFrameTest.windowClosing():: JDBC CON IS CLOSED");
		}
		catch (SQLException se) {
			se.printStackTrace();
		}
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}











