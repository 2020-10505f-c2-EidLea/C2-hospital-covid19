package com.c2.hospital.covid19web.controller;

import com.c2.hospital.covid19web.model.CoronaCountryModel;
import com.c2.hospital.covid19web.service.Covid19Utils;
import com.c2.hospital.covid19web.service.impl.CoronaVirusDataImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

	@Autowired
	CoronaVirusDataImpl coronaVirusData;

	@GetMapping(value = {"/"})
	public String list(Model model) {
		model.addAttribute("pageTitle", "Covid19");
		try {
			Map<String, CoronaCountryModel> dataMap = coronaVirusData.countryDataMap;
			if (dataMap.isEmpty())
			{
				coronaVirusData.setData(Covid19Utils.VIRUS_DATA_URL);
				coronaVirusData.setDeathData(Covid19Utils.DEATH_DATA_URL);
				coronaVirusData.setCountryDataMap();
				dataMap = coronaVirusData.getCountryDataMap();
				if(dataMap.isEmpty())
				{
					model.addAttribute("noInternet", "No Internet Connection");
				}
			}
			List<CoronaCountryModel> countryStats = new ArrayList<>();
			dataMap.entrySet().forEach(e-> countryStats.add(e.getValue()));
			model.addAttribute("locationsStats", countryStats);

			int totalReportedCases = dataMap.entrySet().stream().mapToInt(stat -> stat.getValue().getLatestCases()).sum();
			int totalNewCases = dataMap.entrySet().stream().mapToInt(stat -> stat.getValue().getDiffFromPrevDay()).sum();
			int totalDeaths = dataMap.entrySet().stream().mapToInt(stat -> stat.getValue().getDeath()).sum();
			int totalDeathsToday = dataMap.entrySet().stream().mapToInt(stat -> stat.getValue().getDeathDiffFromPrevDay()).sum();
			model.addAttribute("totalReportedCases", totalReportedCases);
			model.addAttribute("totalNewCases", totalNewCases);
			model.addAttribute("totalDeaths", totalDeaths);
			model.addAttribute("totalDeathsToday", totalDeathsToday);

			Map<String, CoronaCountryModel> arabicCountryDataMap = coronaVirusData.getArabicCountryDataMap();
			totalReportedCases = arabicCountryDataMap.entrySet().stream().mapToInt(stat -> stat.getValue().getLatestCases()).sum();
			totalNewCases = arabicCountryDataMap.entrySet().stream().mapToInt(stat -> stat.getValue().getDiffFromPrevDay()).sum();
			totalDeaths = arabicCountryDataMap.entrySet().stream().mapToInt(stat -> stat.getValue().getDeath()).sum();
			totalDeathsToday = arabicCountryDataMap.entrySet().stream().mapToInt(stat -> stat.getValue().getDeathDiffFromPrevDay()).sum();
			model.addAttribute("arabicReportedCases", totalReportedCases);
			model.addAttribute("arabicNewCases", totalNewCases);
			model.addAttribute("arabicDeaths", totalDeaths);
			model.addAttribute("arabicDeathsToday", totalDeathsToday);
			List<CoronaCountryModel> arabicStats = new ArrayList<>();
			arabicCountryDataMap.entrySet().forEach(e-> arabicStats.add(e.getValue()));
			model.addAttribute("arabicStats", arabicStats);

			CoronaCountryModel CoronaLebanonModel = dataMap.get("Lebanon");
			model.addAttribute("lebanonReportedCases", CoronaLebanonModel.getLatestCases());
			model.addAttribute("lebanonNewCases", CoronaLebanonModel.getDiffFromPrevDay());
			model.addAttribute("lebanonDeaths", CoronaLebanonModel.getDeath());
			model.addAttribute("lebanonDeathsToday", CoronaLebanonModel.getDeathDiffFromPrevDay());

			Calendar cal = Calendar.getInstance();
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			model.addAttribute("todayDate", dateFormat.format(cal.getTime()));
		}catch (Exception e){
			e.printStackTrace();
			model.addAttribute("noInternet", "No Internet Connection");
		}
		return "covid19";
	}
}
