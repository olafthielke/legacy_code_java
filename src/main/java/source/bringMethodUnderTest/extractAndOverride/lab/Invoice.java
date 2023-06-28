package source.bringMethodUnderTest.extractAndOverride.lab;

import java.util.ArrayList;
import java.util.List;


public class Invoice {
    private List<InvoiceLine> lines = new ArrayList<>();

    public Invoice() {
    }
    
    public Invoice(List<InvoiceLine> lines) {
    	this.lines.addAll(lines);
    }
    
    
    public List<InvoiceLine> getLines() {
        return lines;
    }

    public void setLines(List<InvoiceLine> lines) {
    	this.lines.addAll(lines);
    }
}
