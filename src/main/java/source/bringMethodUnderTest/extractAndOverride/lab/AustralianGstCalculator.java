package source.bringMethodUnderTest.extractAndOverride.lab;

import java.math.BigDecimal;
import java.sql.SQLException;

public class AustralianGstCalculator {
	
    public BigDecimal calcGst(Invoice invoice) throws Exception {
        BigDecimal gstAmount = BigDecimal.ZERO;

        // TODO: The line subtotal and GST amounts should be rounded 
        // to 2 decimal places at the line level.
        for (InvoiceLine line : invoice.getLines()) {
            BigDecimal subtotal = line.getProduct().getUnitPrice().multiply(new BigDecimal(line.getQuantity()));

            BigDecimal gstRate = getGstRate(line.getProduct());
            if (gstRate == null) {
                throw new Exception("Unable to look up applicable GST rate for product '" + line.getProduct().getName() + "'");
            }

            gstAmount = gstAmount.add(gstRate.multiply(subtotal));
        }

        return gstAmount;
    }
    
    
    protected BigDecimal getGstRate(Product product) throws SQLException {
    	
    	return GstProductSelector.selectGstRate(product);
    }
}
