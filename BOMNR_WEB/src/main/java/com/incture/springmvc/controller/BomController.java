package com.incture.springmvc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.incture.bomnr.configuration.AppConfig;
import com.incture.bomnr.dto.BaseDto;
import com.incture.bomnr.dto.BomCommentsDto;
import com.incture.bomnr.dto.BomHeaderDto;
import com.incture.bomnr.dto.BomItemsDto;
import com.incture.bomnr.dto.ResponseDto;

import com.incture.bomnr.service.BomHeaderServiceLocal;

import com.incture.springmvc.domain.Message;

@RestController
public class BomController {
	AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	// EmployeeService es = (EmployeeService)
	// context.getBean("employeeService");
	BomHeaderServiceLocal bomservice = (BomHeaderServiceLocal) context.getBean("bomheaderservice");

	@RequestMapping("/")
	public String welcome() {// Welcome page, non-rest
		return "Welcome to RestTemplate Example.";
	}

	@RequestMapping("/hello/{player}")
	public Message message(@PathVariable String player) {// REST Endpoint.

		Message msg = new Message(player, "Hello " + player);
		return msg;
	}

	@RequestMapping("/bom/structure")
	public BomHeaderDto structureBom() {
		List<BomCommentsDto> comlist = new ArrayList<BomCommentsDto>();
		List<BomItemsDto> itemlist = new ArrayList<BomItemsDto>();
		BomCommentsDto com = new BomCommentsDto();
		com.setComCreatedBy("hella");
		com.setComCreatedOn(new Date());

		com.setComComment("testing");
		BomCommentsDto com1 = new BomCommentsDto();
		com1.setComCreatedBy("hell");
		com1.setComCreatedOn(new Date());

		com1.setComComment("binding");

		comlist.add(com);
		comlist.add(com1);

		BomItemsDto item1 = new BomItemsDto(); // item1.setBOM_S_Number("3");
		item1.setBomCompCode("inc");
		item1.setBomCompDes("Sap");
		item1.setBomQty("20");
		item1.setBomUom("uom");
		item1.setBomItemCat("hgg");
		item1.setBomText("avcs");
		item1.setBomManufacturer("halwa");
		item1.setBomSortString("avaba");
		item1.setBomStorageLoc("loaa");
		BomItemsDto item12 = new BomItemsDto();
		item12.setBomCompCode("inc");
		item12.setBomCompDes("Sap");
		item12.setBomQty("20");
		item12.setBomUom("uom");
		item12.setBomItemCat("hgg");
		item12.setBomText("avcs");
		item12.setBomManufacturer("halwa");
		item12.setBomSortString("avaba");
		item12.setBomStorageLoc("loaa"); // item2.setbomS_Number("2");

		itemlist.add(item1);
		itemlist.add(item12);

		BomHeaderDto head = new BomHeaderDto();

		head.setBomRefMaterialCode("23");
		head.setBomRefALtBOM("232");
		head.setBomAltBOM("ALT23");
		head.setBomBaseQty("23");
		head.setBomMaterialCode("heala");
		head.setBomAltText("haha");
		head.setBomBaseUom("uom");
		head.setBomPlantCode("ada");
		head.setBomRefALtBOM("alt");
		head.setComments(comlist);
		head.setItems(itemlist);

		return head;

	}

	@RequestMapping(value = "/bom", method = RequestMethod.POST)
	public ResponseDto createBom(@RequestBody BomHeaderDto Dto) {
		return bomservice.createBom(Dto);
	}

	@RequestMapping("/bom/{requestNo}")
	public BaseDto findById(@PathVariable String requestNo) {
		return bomservice.findBom(requestNo);
	}

	@RequestMapping(value = "/bom/remove/{requestNo}", method = RequestMethod.DELETE)
	public ResponseDto deleteDto(@PathVariable String requestNo) {
		return bomservice.deleteBom(requestNo);

	}

	@RequestMapping("/bom/all")
	public List<BomHeaderDto> findAllBom() {
		return bomservice.findAllBom();

	}

	@RequestMapping(value = "/bom/update", method = RequestMethod.PUT)
	public ResponseDto updateBom(@RequestBody BomHeaderDto Dto) {
		return bomservice.updateBom(Dto);
	}
	/*
	 * @RequestMapping("/employee/all") public List<Employee> findAll() { return
	 * es.findAllEmployees();
	 * 
	 * }
	 * 
	 * @RequestMapping("/employee/data") public Employee findData() { Employee
	 * employee1 = new Employee(); employee1.setName("heerra");
	 * employee1.setJoiningDate(new LocalDate(2018, 1, 10));
	 * employee1.setSalary(new BigDecimal(100123));
	 * employee1.setSsn("ssn000343"); es.saveEmployee(employee1); return
	 * employee1;
	 * 
	 * }
	 * 
	 * @RequestMapping(value = "/employee/save", method = RequestMethod.POST)
	 * public String Save(@PathVariable Employee employee) { if
	 * (es.saveEmployee(employee)) return "Successfully Saved!"; else return
	 * "failed";
	 * 
	 * }
	 * 
	 * 
	 * @RequestMapping(value = "/comments/save", method = RequestMethod.GET)
	 * public String Save( ) { BomCommentsDo com= new BomCommentsDo();
	 * com.setComCreatedBy("lucky");
	 * 
	 * com.setComCreatedOn(new Date(2017,12,2)); if(es.saveBOMComment(com));
	 * return com.toString();
	 * 
	 * 
	 * }
	 */

}
