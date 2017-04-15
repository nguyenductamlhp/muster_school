package com.ui;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.model.entity.Course;
import com.model.service.CourseService;
import com.model.service.UserService;

import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Muster extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// 	GLOBAL VARIABLES
	// variable for UI
	private JPanel contentPane;
	private JTable tableCourse;
	private JTextField txtUser;
	
	// Variable for process
	String userName = "";
	String passWord = "";
	

	// GET SERVICE
	CourseService courseService = new CourseService();
	UserService userService = new UserService();
	// ================= GET DATA ===============	
	// Get Table data
	private Object[][] getCourseTableData() {		
		List<Course> listAllCourse = courseService.getAllCourse();
		
		Object[][] objects = new Object[listAllCourse.size()][9];
		for (int i = 0; i < listAllCourse.size(); i++) {
			objects[i][0] = listAllCourse.get(i).getId();
			objects[i][1] = listAllCourse.get(i).getCode();
			objects[i][2] = listAllCourse.get(i).getTitle();
			objects[i][3] = listAllCourse.get(i).getStartDate();
			objects[i][4] = listAllCourse.get(i).getEndDate();
			objects[i][5] = listAllCourse.get(i).getWeekDay();
			objects[i][6] = listAllCourse.get(i).getStartTime();
			objects[i][7] = listAllCourse.get(i).getEndTime();
			objects[i][8] = "";
		}
		
		return objects;
	}

	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Muster frame = new Muster();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Muster() {
		LoginOptionPane loginOptionPane = new LoginOptionPane();
		userName = loginOptionPane.getUsername().getText();
		passWord = loginOptionPane.getPassword().getText();
		if (!userService.isLoginSuccess(userName, passWord)) {
			System.exit(0);
		}
		setBackground(Color.WHITE);
		setTitle("Muster School");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 681, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 496, 284);
		contentPane.add(scrollPane);
		
		tableCourse = new JTable();
		scrollPane.setViewportView(tableCourse);
		tableCourse.setModel(new DefaultTableModel(
			getCourseTableData(),
			new String[] {
				"ID", "Code", "Title", "Start Day", "End Day", "Week Day", "Start Time", "End Time", "Note"
			}
		));
		
		JButton btnAddCourse = new JButton("Add Course");
		btnAddCourse.setBounds(541, 14, 114, 23);
		contentPane.add(btnAddCourse);
		
		JButton btnImportStudent = new JButton("Import Student");
		btnImportStudent.setBounds(541, 70, 114, 23);
		contentPane.add(btnImportStudent);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(541, 129, 114, 23);
		contentPane.add(btnSave);
		
		JButton btnAttend = new JButton("Attend");
		btnAttend.setBounds(541, 190, 114, 23);
		contentPane.add(btnAttend);
		
		txtUser = new JTextField();
		txtUser.setEditable(false);
		txtUser.setBounds(10, 325, 176, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
	}
}
