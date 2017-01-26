package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Device;
import com.example.service.DeviceService;

@Controller
@RequestMapping("/device")
public class DeviceController {
	@Autowired
	private DeviceService deviceService;

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createPage() {
		return "create-device";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@ModelAttribute Device device) {
		deviceService.create(device);
		return "create-device";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView showDevice(@PathVariable(value = "id", required = true) Integer id) {
		Device device = deviceService.findById(id);
		return new ModelAndView("device", "device", device);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listDevices() {
		List<Device> listDevices = deviceService.findAll();
		return new ModelAndView("list-devices", "devices", listDevices);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public String updateDevice(@RequestParam(value = "light", required=false) Boolean turnLight,
			@RequestParam(value = "brightness", required=false) Integer brightness, @PathVariable("id") Integer id) {
		System.out.println("light: " + turnLight + " || brightness: " + brightness);
		Device device = deviceService.findById(id);
		if (turnLight != null)
			device.setTurnLight(turnLight);
		if (brightness != null)
			device.setBrightness(brightness);
		
		try {
			deviceService.update(device);
			return "success";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("greeting");
		return mav;
	}

}
