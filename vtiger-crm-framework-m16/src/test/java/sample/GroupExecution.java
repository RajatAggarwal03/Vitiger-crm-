package sample;

import org.testng.annotations.Test;

public class GroupExecution {
	@Test(groups = {"smoke","regression"})
	public void add() {
		System.out.println("Add ran");
	}

	@Test(groups = {"smoke","regression","adhoc"})
	public void sub() {
		System.out.println("Sub ran");
	}

	@Test(groups = "regression")
	public void mul() {
		System.out.println("Mul ran");
	}
	
	@Test(groups = "regression")
	public void div() {
		System.out.println("Div ran");
	}
}
