package com.incture.springmvc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.incture.bomnr.dto.RemoveMultipeDto;
import com.incture.bomnr.dto.ResponseDto;

import com.incture.bomnr.service.BomHeaderServiceLocal;

import com.incture.springmvc.domain.Message;

@RestController
public class BomController {
	AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	// EmployeeService es = (EmployeeService)
	// context.getBean("employeeService");
	private static final Logger LOGGER = LoggerFactory.getLogger(BomController.class);

	BomHeaderServiceLocal bomservice = (BomHeaderServiceLocal) context.getBean("bomheaderservice");

	// check rest
	@RequestMapping("/")
	public String welcome() {// Welcome page, non-rest
		return "Welcome to RestTemplate Example.";
	}

	// check
	@RequestMapping("/hello/{x}")
	public Message message(@PathVariable String x) {// REST Endpoint.

		Message msg = new Message(x, "Hello " + x);
		return msg;
	}

	// show the structure of the bom
	@RequestMapping("/bom/structure")
	public BomHeaderDto structureBom() {
		LOGGER.info("Inside bom Structure");
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
		head.setBomCreatedBy("SYSTEM");
		head.setBomCreatedOn(new Date());
		head.setBomUpdateddBy("SYSTEM");
		head.setBomUpdatedOn(new Date());
		return head;

	}

	// create bom
	@RequestMapping(value = "/bom", method = RequestMethod.POST)
	public ResponseDto createBom(@RequestBody BomHeaderDto Dto) {
		LOGGER.info("Inside bom creation");
		return bomservice.createBom(Dto);
	}

	// find single by request Id
	@RequestMapping("/bom/{requestNo}")
	public BaseDto findById(@PathVariable String requestNo) {
		LOGGER.info("Inside Find By Id");
		return bomservice.findBom(requestNo);
	}

	// remove single by request Id
	@RequestMapping(value = "/bom/remove/{requestNo}", method = RequestMethod.DELETE)
	public ResponseDto deleteDto(@PathVariable String requestNo) {
		LOGGER.info("Inside Delete Single bom header function");
		return bomservice.deleteBom(requestNo);

	}

	// show all
	@RequestMapping("/bom/all")
	public List<BomHeaderDto> findAllBom() {
		LOGGER.info("Inside return all boms ");
		return bomservice.findAllBom();

	}

	// update
	@RequestMapping(value = "/bom/update", method = RequestMethod.PUT)
	public ResponseDto updateBom(@RequestBody BomHeaderDto Dto) {
		LOGGER.info("Inside updateBom");
		return bomservice.updateBom(Dto);
	}

	// multiple deletion
	@RequestMapping(value = "/bom/remove", method = RequestMethod.DELETE)
	public ResponseDto deleteDto(@RequestBody RemoveMultipeDto dto) {
		LOGGER.info("Inside multiple remove");
		return bomservice.deleteMultipeBom(dto);

	}

	// structure for deletion dto
	@RequestMapping(value = "/bom/remove/structure")
	public RemoveMultipeDto deleteDtoStructure() {
		LOGGER.info("Inside bom deletion dto  Structure returniing function");
		RemoveMultipeDto rem = new RemoveMultipeDto();
		List<String> str = new ArrayList<String>();
		str.add("BOM00000001");
		str.add("BOM00000002");
		rem.setReqNumbers(str);
		return rem;

	}

}
