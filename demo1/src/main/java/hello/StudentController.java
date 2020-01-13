package hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController {

	@Autowired
	StdDao dao;
	 Student newk = new Student();
	 
	@RequestMapping("/stdForm")
	public String showForm(Model model) {
		model.addAttribute("command", newk);
		return "StudentForm";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(@ModelAttribute("std") Student std) {
		dao.save(std);
		return "redirect:/viewStd";
	}
	
	@RequestMapping("/viewStd")
	public String viewStd(Model model) {
		List <Student> list = dao.getStudents();
		model.addAttribute("list", list);
		return "ViewStd";
	}
	
	@RequestMapping(value="/editStd/{stdId}")
	public String editStd(@PathVariable String stdId, Model model) {
		Student std = dao.getStudentById(stdId);
		model.addAttribute("command", std);
		return "StdEditForm";
	}
	
	@RequestMapping(value="/editSave", method=RequestMethod.POST)
	public String editSave(@ModelAttribute("std") Student std) {
		dao.update(std);
		return "redirect:/viewStd";
	}
	
	@RequestMapping(value="/deleteStd/{stdId}", method=RequestMethod.POST)
	public String deleteStd(@PathVariable String stdId) {
		dao.delete(stdId);
		return "redirect:/viewStd";
	}
	
}
