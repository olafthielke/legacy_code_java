package tests.bringMethodUnderTest.extractAndOverride.lab;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import org.junit.Test;
import org.hamcrest.Matchers;
import static org.hamcrest.MatcherAssert.assertThat;

import source.bringMethodUnderTest.extractAndOverride.lab.*;

public class AustralianGstCalculatorTests {

	@Test
	public void calcGst_for_empty_invoice() throws Exception {
		
		Invoice invoice = new Invoice();
		AustralianGstCalculator calc = new AustralianGstCalculator();
		BigDecimal gst = calc.calcGst(invoice);
		assertEquals(gst, BigDecimal.ZERO);
	}
	
	@Test
	public void calcGst_for_one_line_invoice() throws Exception {
		Product apple = new Product("Apple", new BigDecimal(0.35));
		InvoiceLine line = new InvoiceLine(apple, 3);
		ArrayList<InvoiceLine> lines = new ArrayList<InvoiceLine>();
		lines.add(line);
		Invoice invoice = new Invoice(lines);
		
		AustralianGstCalculator calc = new AustralianGstCalculator();
		BigDecimal gst = calc.calcGst(invoice);
		
        assertThat(gst, Matchers.closeTo(new BigDecimal(0.105), new BigDecimal(0.00000001)));
	}
}
