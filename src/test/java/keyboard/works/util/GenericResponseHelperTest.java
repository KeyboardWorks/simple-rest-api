package keyboard.works.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import keyboard.works.entity.Product;
import keyboard.works.entity.response.ProductResponse;

@SpringBootTest
public class GenericResponseHelperTest {
	
	@Test
	public void createResponse() {
		
		Product product = Product.builder()
				.code("code")
				.name("name")
				.price(new BigDecimal(10_000L))
				.build();
		
		ProductResponse productResponse = GenericResponseHelper.createResponse(ProductResponse.class, product);
		
		assertNotNull(productResponse);
		assertEquals("code", productResponse.getCode());
		assertEquals("name", productResponse.getName());
		assertEquals(new BigDecimal(10_000L), productResponse.getPrice());
	}
	
	@Test
	public void createResponses() {
		
		List<Product> products = new LinkedList<>();
		
		Product product1 = Product.builder()
				.code("code1")
				.name("name1")
				.price(new BigDecimal(10_000L))
				.build();
		
		Product product2 = Product.builder()
				.code("code2")
				.name("name2")
				.price(new BigDecimal(20_000L))
				.build();
		
		products.add(product1);
		products.add(product2);
		
		List<ProductResponse> responses = GenericResponseHelper.createResponses(ProductResponse.class, products);
		
		assertNotNull(responses);
		assertEquals(2, responses.size());
		
	}
	
	@Test
	public void createResponseThrowException() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			GenericResponseHelper.createResponse(ProductResponse.class, null);
		});
		
	}
	
}
