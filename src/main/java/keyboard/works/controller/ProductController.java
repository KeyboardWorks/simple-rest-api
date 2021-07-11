package keyboard.works.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import keyboard.works.entity.Product;
import keyboard.works.entity.request.ProductRequest;
import keyboard.works.entity.response.ProductResponse;
import keyboard.works.service.ProductService;
import keyboard.works.util.GenericResponseHelper;

@RestController
@RequestMapping(
		path = "/products",
		produces = MediaType.APPLICATION_JSON_VALUE
)
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping
	public List<ProductResponse> getProducts() {
		return GenericResponseHelper.createResponses(ProductResponse.class, productService.getProducts());
	}
	
	@GetMapping(path = "{id}")
	public ProductResponse getProduct(@PathVariable(name = "id") String id) {
		Product product = productService.getProduct(id);
		return GenericResponseHelper.createResponse(ProductResponse.class, product);
	}
	
	@PostMapping
	public ProductResponse createProduct(@RequestBody ProductRequest productRequest) {
		Product product = productService.createProduct(productRequest);
		return GenericResponseHelper.createResponse(ProductResponse.class, product);
	}
	
	@PutMapping(path = "{id}")
	public ProductResponse updateProduct(@PathVariable(name = "id") @RequestBody ProductRequest productRequest) {
		Product product = productService.createProduct(productRequest);
		return GenericResponseHelper.createResponse(ProductResponse.class, product);
	}
	
	@DeleteMapping(path = "{id}")
	public void deleteProduct(@PathVariable(name="id")String id) {
		productService.deleteProduct(id);
	}
	
}
