package org.stepDefs;

import org.test.BaseClass;
import org.test.POM;

import cucumber.api.java.en.When;

public class StepDefinition extends BaseClass {
	
	public POM p;
	
	@When("I am going to enter {string} nd {string}")
	public void i_am_going_to_enter_nd(String s1, String s2) {
		
		 p=new POM();
		
		sendK(p.getUserName(), s1);
		sendK(p.getPassWord(), s2);
	   
	}

	@When("I will click the login button")
	public void i_will_click_the_login_button() {
	    
		 buttonCl(p.getLoginBut());
	}



}
