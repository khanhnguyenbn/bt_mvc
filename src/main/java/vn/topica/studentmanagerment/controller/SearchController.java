package vn.topica.studentmanagerment.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.topica.studentmanagerment.model.Student;
import vn.topica.studentmanagerment.service.StudentService;

/**
 * Servlet implementation class SearchController
 */


public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private StudentService studentService;
    
    public SearchController() {
       studentService = new StudentService();
    }
    
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	request.setCharacterEncoding("UTF-8");
    	String nameKey = request.getParameter("nameKey");
    	Map<Integer, Student> studentMap = studentService.searchByName(nameKey);
    	request.setAttribute("studentMap", studentMap);
    	
    	RequestDispatcher  dispatcher = request.getRequestDispatcher("view/home.jsp");
    	dispatcher.forward(request, response);
	}
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
