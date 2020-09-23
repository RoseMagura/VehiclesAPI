package com.udacity.pricing;

import com.udacity.pricing.api.PricingController;
import com.udacity.pricing.domain.price.Price;
import com.udacity.pricing.domain.price.PriceRepository;
import com.udacity.pricing.service.PricingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.*;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.iterableWithSize;


@RunWith(SpringRunner.class)
@WebMvcTest(PricingController.class)
public class PricingServiceApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	PricingService pricingService;

	@MockBean
	PriceRepository priceRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testServerRunning() {
	}

	@Test
	public void testSetupRepository() {
		System.out.println(priceRepository.findAll());
		Iterable<Price> prices = priceRepository.findAll();
		assertEquals(prices, iterableWithSize(0));
//		assertNotNull(prices.iterator().next().getVehicleId());
	}

	@Test
	public void testGetPriceById() throws Exception {
		mockMvc.perform(get("/services/price/1"))
				.andExpect(status().isOk());
//				.andExpect(content().string())
	}
}
