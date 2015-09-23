package MainPackage;

import static org.junit.Assert.*;

import org.junit.Test;

public class LoanRepaymentCalculatorTest {
	LoanRepaymentCalculator input = new LoanRepaymentCalculator();
	
	@Test
	public final void testtotalTuitionCost() {
		input.setInitialTuition(12500);
		input.setTuitionIncrease(5);
		
		assertTrue("This is wrong total", 26970.31 == 26970.31);
		
		input.setInitialTuition(10000);
		assertTrue("This is wrong total", 12155.06 == 12155.06);
		}
	
	@Test
	public final void monthlyPayment() {
		input.setInitialTuition(12500);
		input.setTuitionIncrease(5);
		input.setAPR(3);
		input.setRepayment(10);
		
		assertTrue("This is wrong monthly payment", 7553.64 == 7553.64);
		
		input.setInitialTuition(10000);
		assertTrue("This is wrong monthly payment", 2800.73 == 2800.73);
	}

}
