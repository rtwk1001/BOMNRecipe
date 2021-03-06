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

import com.incture.bomnr.dto.RecipeCommentsDto;
import com.incture.bomnr.dto.RecipeHeaderDto;
import com.incture.bomnr.dto.RecipeItemsDto;
import com.incture.bomnr.dto.RemoveMultipeDto;
import com.incture.bomnr.dto.ResponseDto;

import com.incture.bomnr.service.RecipeHeaderServiceLocal;

@RestController
public class RecipeController {
	AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	RecipeHeaderServiceLocal recipeService = (RecipeHeaderServiceLocal) context.getBean("recipeheaderservice");
	private static final Logger LOGGER = LoggerFactory.getLogger(RecipeController.class);

	@RequestMapping("/recipe/structure")
	public RecipeHeaderDto structureRecipe() {
		LOGGER.info("Inside Recipe Structure showing function");
		List<RecipeCommentsDto> comlist = new ArrayList<RecipeCommentsDto>();
		List<RecipeItemsDto> itemlist = new ArrayList<RecipeItemsDto>();
		RecipeCommentsDto com = new RecipeCommentsDto();
		com.setrComCreatedBy("ritwik");
		com.setrComCreatedOn(new Date());

		com.setrComComment("kuchbhi");
		RecipeCommentsDto com1 = new RecipeCommentsDto();
		com1.setrComCreatedBy("lucky");
		com1.setrComCreatedOn(new Date());

		com1.setrComComment("dukdudk");

		comlist.add(com);
		comlist.add(com1);

		RecipeItemsDto item1 = new RecipeItemsDto(); // item1.setBOM_S_Number("3");
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

		RecipeItemsDto item12 = new RecipeItemsDto(); // item1.setBOM_S_Number("3");
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

		RecipeHeaderDto head = new RecipeHeaderDto();

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
		head.setRecipeCreatedBy("SYSTEM");
		head.setRecipeCreatedOn(new Date());
		head.setRecipeUpdateddBy("SYSTEM");
		head.setRecipeUpdatedOn(new Date());
		// recipeService.createRecipe(head);
		/* context.close(); */

		return head;
	}

	// Create
	@RequestMapping(value = "/recipe", method = RequestMethod.POST)
	public ResponseDto CreateRecipe(@RequestBody RecipeHeaderDto dto) {
		LOGGER.info("Inside Recipe create");
		return recipeService.createRecipe(dto);
	}

	// Find by Id
	@RequestMapping(value = "/recipe/{requestNo}", method = RequestMethod.GET)
	public BaseDto findById(@PathVariable String requestNo) {
		LOGGER.info("Inside Recipe get by id");
		return recipeService.findById(requestNo);
	}

	// Delete
	@RequestMapping(value = "/recipe/remove/{requestNo}", method = RequestMethod.DELETE)
	public ResponseDto deleteDto(@PathVariable String requestNo) {
		LOGGER.info("Inside Recipe remove by id");
		return recipeService.deleteRecipe(requestNo);

	}

	// Find All
	@RequestMapping(value = "/recipe/all", method = RequestMethod.GET)
	public List<RecipeHeaderDto> findAllBom() {
		LOGGER.info("Inside Recipe get all");
		return recipeService.findAllRecipies();

	}

	// Update
	@RequestMapping(value = "/recipe/update", method = RequestMethod.PUT)
	public ResponseDto updateRecipe(@RequestBody RecipeHeaderDto Dto) {
		LOGGER.info("Inside Recipe Update function");
		return recipeService.updateRecipe(Dto);
	}

	// Delete Multipe
	@RequestMapping(value = "/recipe/remove", method = RequestMethod.DELETE)
	public ResponseDto deleteDto(@RequestBody RemoveMultipeDto dto) {
		LOGGER.info("Inside Recipe multiple deletion");
		return recipeService.deleteMultipeRecipe(dto);

	}

}