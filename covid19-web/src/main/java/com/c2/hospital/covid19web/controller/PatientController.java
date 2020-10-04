package com.c2.hospital.covid19web.controller;

import com.c2.hospital.covid19web.model.PatientsModel;
import com.c2.hospital.covid19web.service.PatientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping(value = "patients")
@Controller
public class PatientController {

	@Autowired
	PatientsService patientsService;

	@GetMapping(value = "/add")
	public String addPatients(Model model) {
		model.addAttribute("pageTitle", "Patients | Add");
		PatientsModel patientsModel = new PatientsModel();
		patientsModel.setBirthdate(new Date());
		model.addAttribute("patient", patientsModel);
		return "patients/edit-patients";
	}

	@GetMapping(value = {"view", "/"})
	public String list(Model model) {
		model.addAttribute("pageTitle", "Patients | View");
		try
		{
			model.addAttribute("patientList", patientsService.getList());
		} catch (Exception e)
		{
			model.addAttribute("patientList", null);
			e.printStackTrace();
		}
		return "patients/view-patients";
	}

	@GetMapping(value = "/{searchBy}")
	public String list(@PathVariable String searchBy, Model model) {
		model.addAttribute("pageTitle", "Patients | View");
		try
		{
			List<PatientsModel> patientsList = patientsService.getList();
			patientsList = patientsList.stream().filter(patientsModel -> {
				return (patientsModel.getFirstName()+" "+patientsModel.getMiddleName()+" "+patientsModel.getLastName()+" "+patientsModel.getId()).toUpperCase().contains(searchBy.toUpperCase())
						|| (patientsModel.getFirstName()+" "+patientsModel.getLastName()+" "+patientsModel.getId()).toUpperCase().contains(searchBy.toUpperCase()) ;
			}).collect(Collectors.toList());
			model.addAttribute("patientList", patientsList);
		} catch (Exception e)
		{
			model.addAttribute("patientList", null);
			e.printStackTrace();
		}
		return "patients/view-patients";
	}


	@PostMapping(value = "/")
	public String search(@Valid @ModelAttribute PatientsModel patient, RedirectAttributes redirectAttr, BindingResult result)
	{
		return "redirect:/patients/"+patient.getSearchBy();
	}

	@GetMapping(value = "history/{patientId}")
	public String history(@PathVariable Integer patientId, Model model) {
		model.addAttribute("pageTitle", "Patients | View");
		try
		{
			model.addAttribute("patient", patientsService.getPatientHistory(patientId));
		} catch (Exception e)
		{
			model.addAttribute("patient", new ArrayList<PatientsModel>());
			e.printStackTrace();
		}
		return "patients/history-patients";
	}

	@GetMapping(value = "/edit/{patientId}")
	public String edit(@PathVariable Integer patientId, Model model, RedirectAttributes redirectAttr) {
		model.addAttribute("pageTitle", "Patients | Update");
		try {
			if (patientId > 0) {
				PatientsModel patient = patientsService.findById(patientId);
				if (patient != null) {
					model.addAttribute("patient", patient);
				} else {
					redirectAttr.addFlashAttribute("message", "No patient was matched");
					return "redirect:/patients/view";
				}
			} else {
				redirectAttr.addFlashAttribute("message", "No reference was found");
				return "redirect:/patients/view";
			}
		} catch (Exception e) {
			redirectAttr.addFlashAttribute("message", e);
			e.printStackTrace();
		}
		return "patients/edit-patients";
	}

	@PostMapping(value = "/update")
	public String update(@Valid @ModelAttribute PatientsModel patient, RedirectAttributes redirectAttr, BindingResult result)
	{
		String msg = "";
		redirectAttr.addFlashAttribute("status", "error");
		try {
			if (patient != null && patient.getId() > 0) {
				if (result.hasErrors()) {
					FieldError error = null;
					for (Object obj : result.getAllErrors()) {
						error = (FieldError) obj;
						msg += error.getDefaultMessage();
					}
				}
				if (msg.length() == 0) {
					PatientsModel oldModel = patientsService.findById(patient.getId());
					patientsService.save(patient);
					redirectAttr.addFlashAttribute("status", "success");
					redirectAttr.addFlashAttribute("message", "Patient Info Successfully updated");
					return "redirect:/patients/view";
				} else {
					redirectAttr.addFlashAttribute("message", msg);
					return "redirect:/patients/edit/" + patient.getId();
				}
			} else if(patient.getId() == 0){
				if (result.hasErrors()) {
					FieldError error = null;
					for (Object obj : result.getAllErrors()) {
						error = (FieldError) obj;
						msg += error.getDefaultMessage();
					}
				}
				if (msg.length() == 0) {
					patientsService.saveNew(patient);
					redirectAttr.addFlashAttribute("status", "success");
					redirectAttr.addFlashAttribute("message", "Patient Info Successfully updated");
					return "redirect:/patients/view";
				} else {
					redirectAttr.addFlashAttribute("message", msg);
					return "redirect:/patients/edit/" + patient.getId();
				}

			}else{
				redirectAttr.addFlashAttribute("message", "No reference was found");
			}
		} catch (Exception e) {
			redirectAttr.addFlashAttribute("message", e);
			e.printStackTrace();
		}
		return "redirect:/patients/view";
	}

	@GetMapping(value = "/delete/{patientId}")
	public String delete(@PathVariable Integer patientId, RedirectAttributes redirectAttr)
	{
		if (patientId != 0) {
			try {
				patientsService.deleteById(patientId);
				redirectAttr.addFlashAttribute("status", "success");
				redirectAttr.addFlashAttribute("message", "Patient Information successfully deleted");
			} catch (Exception e) {
				redirectAttr.addFlashAttribute("message", e);
			}
		}
		return "redirect:/patients/view";
	}
}
