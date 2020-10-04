package com.c2.hospital.covid19web.controller;

import com.c2.hospital.covid19web.model.AdmissionsModel;
import com.c2.hospital.covid19web.service.AdmissionsService;
import com.c2.hospital.covid19web.service.PatientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Calendar;

@RequestMapping(value = "admissions")
@Controller
public class AdmissionController {

	@Autowired
	PatientsService patientsService;

	@Autowired
	AdmissionsService admissionsService;

	private Model fillModel(Model model)
	{
		try {
			model.addAttribute("patientsList", patientsService.getList());
		} catch (Exception e) {
			model.addAttribute("patientsList", null);
		}
		try {
			model.addAttribute("servicesList", admissionsService.getServiceList());
		} catch (Exception e) {
			model.addAttribute("servicesList", null);
		}
		try {
			model.addAttribute("roomTypeList", admissionsService.getRoomTypeList());
		} catch (Exception e) {
			model.addAttribute("roomTypeList", null);
		}
		try {
			model.addAttribute("roomClassesList", admissionsService.getRoomClassesList());
		} catch (Exception e) {
			model.addAttribute("roomClassesList", null);
		}
		try {
			model.addAttribute("floorList", admissionsService.getFloorList());
		} catch (Exception e) {
			model.addAttribute("floorList", null);
		}
		return model;
	}

	@GetMapping(value = "/add")
	public String addAdmissions(Model model) {
		model.addAttribute("pageTitle", "Admissions | Add");
		fillModel(model);
		AdmissionsModel admission = new AdmissionsModel();
		admission.setRoomClassId(3);
		admission.setServiceDate(Calendar.getInstance().getTime());
		model.addAttribute("admission", admission);
		return "admissions/edit-admissions";
	}

	@GetMapping(value = "/edit")
	public String editAdmissions(Model model) {
		model.addAttribute("pageTitle", "Admissions | Add");
		fillModel(model);
		return "admissions/edit-admissions";
	}

	@PostMapping(value = "/update")
	public String update(@Valid @ModelAttribute AdmissionsModel admission, RedirectAttributes redirectAttr, BindingResult result)
	{
		String msg = "";
		redirectAttr.addFlashAttribute("status", "error");
		try {
			if (admission != null) {
				if (result.hasErrors()) {
					FieldError error = null;
					for (Object obj : result.getAllErrors()) {
						error = (FieldError) obj;
						msg += error.getDefaultMessage();
					}
				}
				if (msg.length() == 0) {
					admission = admissionsService.save(admission);
					redirectAttr.addFlashAttribute("status", "success");
					redirectAttr.addFlashAttribute("message", "Admission details is Successfully added");
					if(null != admission.getAdmissionServiceId())
					{
						return "redirect:/patients/history/"+admission.getProfileId();
					}
					else
					{
						redirectAttr.addFlashAttribute("admission", admission);
						redirectAttr.addFlashAttribute("message", "Admission Creation failed for unknown reason, Please check with Administrator");
					}
				} else {
					redirectAttr.addFlashAttribute("admission", admission);
					redirectAttr.addFlashAttribute("message", msg);
				}
			}
			else {
				redirectAttr.addFlashAttribute("admission", admission);
				redirectAttr.addFlashAttribute("message", "No reference was found");
			}
		} catch (Exception e) {
			redirectAttr.addFlashAttribute("admission", admission);
			if(!StringUtils.isEmpty(e.getMessage()))
			{
				redirectAttr.addFlashAttribute("message", e.getMessage());
			}
			else
			{
				redirectAttr.addFlashAttribute("message", e);
			}
			e.printStackTrace();
		}
		return "redirect:/admissions/edit/";
	}
}
