package sample;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertion {
      
	  @Test
	  public void add() {
	// static methods	  
		   String a = "abc";
		   String b = "abc";
		   String c = "xyz";
		   
		   Assert.assertEquals(a,b);
		   Assert.assertNotEquals(a,c);
		   
		   boolean status1 = true;
		   boolean status2 = false;
		   Assert.assertTrue(status1);
		   Assert.assertFalse(status2);
		   
		   Object obj = null;
		   Object obj1 = new Object();
		   Assert.assertNull(obj);
		   Assert.assertNotNull(obj1);
		   
     // non-static methods
		   SoftAssert sa = new SoftAssert();
		      
		      sa.assertEquals(a,b);
		      sa.assertNotEquals(a,c);
		      
		      sa.assertTrue(status1);
		      sa.assertFalse(status2);
		      
		      sa.assertNull(obj1);
		      sa.assertNotNull(obj1);
		      
		   
		   
		   
	  }
}
