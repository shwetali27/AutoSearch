package com.bridgelabz.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

@Controller
public class AjaxController {
	List<Employee> data = new ArrayList<Employee>();

	AjaxController() {
		System.out.println("Inside constructor");
		// init data for testing
		data.add(new Employee(1, "John Doe"));
		data.add(new Employee(2, "John"));
		data.add(new Employee(2, "John1"));
		data.add(new Employee(2, "Johny"));
		data.add(new Employee(3, "Tony"));
		data.add(new Employee(4, "Sony"));
		data.add(new Employee(5, "Pony"));
		data.add(new Employee(6, "shython"));
		data.add(new Employee(7, "fug-it"));
		data.add(new Employee(8, "java"));

	}

	@RequestMapping(value = "/autoComp", method = RequestMethod.GET)
	public ModelAndView getPages() {
		System.out.println("Inside getPages");
		ModelAndView model = new ModelAndView("autoComp");
		return model;
	}

	@RequestMapping(value = "/getEmployees", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody void getEmployees(HttpServletResponse response, HttpServletRequest request) {

		String term = request.getParameter("term");
		System.out.println("term" + term);
		System.out.println("Inside getEmp");

		response.setContentType("application/json");
		try {

			String searchList = new Gson().toJson(simulateSearchResult(term));

			System.out.println("search List::-" + searchList);
			response.getWriter().write(searchList);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	
	/*@RequestMapping(value = "/getEmployees", method = RequestMethod.POST)
	public void getEmployees(@RequestParam String term, HttpServletResponse response) {
		System.out.println("Term entered is");
		try {
			response.setContentType("application/json");
			
			String g = new Gson().toJson(simulateSearchResult(term));
			
			response.getWriter().write(g);
		} catch (IOException e) {
			e.printStackTrace();
		}
 
	}*/
	private List<String> simulateSearchResult(String empName) {

		List<String> result = new ArrayList<String>();

		System.out.println("empName" + empName);
		// iterate a list and filter by tagName
		for (Employee emp : data) {
			if (emp.getEmpName().toLowerCase().contains(empName.toLowerCase())) {
				System.out.println("**");
				result.add(emp.empName);
			}
		}

		System.out.println(result);
		return result;
	}

}