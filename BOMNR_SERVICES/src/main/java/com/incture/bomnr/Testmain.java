package com.incture.bomnr;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.incture.bomnr.configuration.AppConfig;
import com.incture.bomnr.dto.BomCommentsDto;
import com.incture.bomnr.dto.BomHeaderDto;
import com.incture.bomnr.dto.BomItemsDto;
import com.incture.bomnr.entity.BomCommentsDo;
import com.incture.bomnr.entity.BomHeaderDo;
import com.incture.bomnr.entity.BomItemsDo;
import com.incture.bomnr.service.BomHeaderService;
import com.incture.bomnr.service.BomHeaderServiceLocal;


public class Testmain {
	private static SessionFactory sessionFactory;

	protected static Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public static void main(String[] args) {

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		//EmployeeService es = (EmployeeService) context.getBean("employeeService");
	    BomHeaderServiceLocal bomservice=(BomHeaderServiceLocal)context.getBean("bomheaderservice");
		
	  List<BomHeaderDto> st=bomservice.findAllBom();
	  
		
		
		
		
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
		bomservice.createBom(head);
		context.close();
		/*List<RecipeCommentsDo> comlist = new ArrayList<RecipeCommentsDo>();
		List<RecipeItemsDo> itemlist = new ArrayList<RecipeItemsDo>();
		RecipeCommentsDo com = new RecipeCommentsDo();
		com.setrComCreatedBy("hella");
		com.setrComCreatedOn(new Date());

		com.setrComComment("testing");
		RecipeCommentsDo com1 = new RecipeCommentsDo();
		com1.setrComCreatedBy("hell");
		com1.setrComCreatedOn(new Date());

		com1.setrComComment("binding");

		comlist.add(com);
		comlist.add(com1);

		RecipeItemsDo item1 = new RecipeItemsDo(); // item1.setBOM_S_Number("3");
		item1.setRecipeResource("rec1");
		item1.setRecipeResourceDes("one");
		item1.setRecipeQty("10");
		item1.setRecipeUom("uom1");
		item1.setRecipeOperationDes("oanaa");
		item1.setRecipeStd1("1");
		item1.setRecipeStd2("2");
		item1.setRecipeStd3("3");
		item1.setRecipeStd4("4");
		item1.setRecipeStd5("5	");
		item1.setRecipeStd6("6");

		RecipeItemsDo item12 = new RecipeItemsDo(); // item1.setBOM_S_Number("3");
		item12.setRecipeResource("rec1");
		item12.setRecipeResourceDes("one");
		item12.setRecipeQty("10");
		item12.setRecipeUom("uom1");
		item12.setRecipeOperationDes("oanaa");
		item12.setRecipeStd1("1");
		item12.setRecipeStd2("2");
		item12.setRecipeStd3("3");
		item12.setRecipeStd4("4");
		item12.setRecipeStd5("5	");
		item12.setRecipeStd6("6"); // item2.setbomS_Number("2");

		itemlist.add(item1);
		itemlist.add(item12);

		RecipeHeaderDo head = new RecipeHeaderDo();

		head.setRecipeRefMaterialCode("23");
		head.setRecipeRefAltBOM("232");
		head.setRecipeAltBOM("ALT23");
		head.setRecipeBaseQty("23");
		head.setRecipeMaterialCode("heala");
		head.setRecipeAltText("haha");
		head.setRecipeBaseUom("uom");
		head.setRecipePlantCode("ada");
		head.setRecipeRefAltBOM("alt");
		head.setComments(comlist);
		head.setItems(itemlist);
		es.saveRecipeHeader(head);*/
		context.close();
	}

}
