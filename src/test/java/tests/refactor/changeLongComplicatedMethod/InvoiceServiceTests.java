package tests.refactor.changeLongComplicatedMethod;

import org.hamcrest.Matchers;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;

import source.refactor.changeLongComplicatedMethod.DbInvoiceLine;
import source.refactor.changeLongComplicatedMethod.InvoiceService;
import source.refactor.changeLongComplicatedMethod.SqlProduct;

public class InvoiceServiceTests {

	@Test
	public void test_calcSubtotal_for_no_products() {
		
		DbInvoiceLine line = new DbInvoiceLine();
		line.setInvoiceLineId(0);
		line.setSKU("ABC123");
		line.setQuantity(7);
		line.setProductId(13);
		line.setProductName("Apple");
		
		List<SqlProduct> products = new ArrayList<SqlProduct>();
		
		BigDecimal subtotal = InvoiceService.calcSubtotal(line, products);
		
		assertEquals(subtotal, BigDecimal.ZERO);
	}
	
	@Test
	public void test_calcSubtotal_for_apple() {
		
		DbInvoiceLine line = new DbInvoiceLine();
		line.setInvoiceLineId(0);
		line.setSKU("ABC123");
		line.setQuantity(7);
		line.setProductId(13);
		line.setProductName("Apple");
		
		List<SqlProduct> products = new ArrayList<SqlProduct>();
		SqlProduct product = new SqlProduct();
		product.setId(13);
		product.setName("Apple");
		product.setSKU("ABC123");
		product.setUnitPrice(new BigDecimal(1.35));
		products.add(product);
		
		BigDecimal subtotal = InvoiceService.calcSubtotal(line, products);
		
		org.hamcrest.MatcherAssert.assertThat(new BigDecimal(9.45), Matchers.closeTo(subtotal, new BigDecimal(0.000001)));
	}
}
