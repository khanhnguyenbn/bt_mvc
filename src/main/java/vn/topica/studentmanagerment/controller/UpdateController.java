package vn.topica.studentmanagerment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.topica.studentmanagerment.constant.Constant;
import vn.topica.studentmanagerment.model.Student;
import vn.topica.studentmanagerment.service.StudentService;

/**
 * Servlet implementation class UpdateController
 */

public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private StudentService studentService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	

	public UpdateController() {
		studentService = new StudentService();
	}
	
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int yearOfBirth = Integer.parseInt(request.getParameter("yearOfBirth"));
		String gender = request.getParameter("gender");
		String dateAdmission = request.getParameter("dateAdmission");
		
		Student student = new Student(id, name, yearOfBirth, gender, dateAdmission);
		studentService.updateStudent(student);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Home");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		processRequest(request, response);
	}

}
