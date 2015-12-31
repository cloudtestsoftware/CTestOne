package com.testmax.myapp.test;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import com.testmax.handler.SeleniumBaseHandler;
import com.testmax.track.BaseTrack;

public class MyPage extends BaseTrack{
	
	
	public void setSeleniumRunner(SeleniumBaseHandler handler){
		 this.handler=handler;
		 this.driver=this.handler.getDriver();
	 }

	/*
	 * 
	 * This example shows you how to write java code for the below tag under <taglib name="apigee-injector"> for element  <deleteAPI> 
	<tag description="Click API Name=@apiname" classname="api-name"  havingTag="span" havingText="@apiname" type="text"  timeout="3000" method="click"></tag> 
	*/
	protected boolean deleteApi(){
		
		List<WebElement> elms=null;
		String apiname=this.handler.getDeclaredVariable("apiname");
		
		try{
			this.setImpilicitTimeInMiliSec(5000);
			
			 elms=this.driver.findElement(By.className("api-name")).findElements(By.tagName("span"));	
			
			 for(WebElement elm:elms){
							
				 try{
					
					 if(elm.getText()!=null&&elm.getText().contains(apiname)){
						 elm.click();
						 Thread.sleep(500);						 
					 }
				 }catch(Exception e){
					
				 }
			 }
			 return true;
		}catch(Exception e){}
		
		return false;
		
	}
	/*
	 * This example shows how you can write any injector that not required any browser action but may need to manipulate data or do something else
	 */
	protected void getApiInfo(){
		String apiname=this.handler.getDeclaredVariable("apiname");
		String basepath=this.handler.getDeclaredVariable("basepath");
		String endpoint=this.handler.getDeclaredVariable("endpoint");
		this.handler.printMessage("*****Deleted ApiName="+apiname +" , basepath="+basepath+" , endpoint="+endpoint);
	}
	
	/*
	 * This example shows how you can write any injector that not required any browser action but may need to manipulate data or do something else
	 */
	protected void modifyApiInfo(){
		String apiname=this.handler.getDeclaredVariable("apiname");
		String basepath=this.handler.getDeclaredVariable("basepath");
		String endpoint=this.handler.getDeclaredVariable("endpoint");
		handler.getVarMap().put("apiname", apiname+"-Modifying");
		this.handler.printMessage("*****Modified Old ApiName="+apiname + " with new Api Name="+apiname+"-Modifying" +" , basepath="+basepath+" , endpoint="+endpoint);
	}
	
}
