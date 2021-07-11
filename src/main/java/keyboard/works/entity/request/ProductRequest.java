package keyboard.works.entity.request;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {

	private String id;
	
	private String code;
	
	private String name;
	
	private BigDecimal price;
	
}
