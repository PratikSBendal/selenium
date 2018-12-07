package Flyrobe;

import java.io.IOException;

import org.testng.annotations.Test;

public class Run_Test extends Flyrobe_config{
	@Test
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		login log=new login();
Flyrobe_config config=new Flyrobe_config();
Flyrobe_login login=new Flyrobe_login();
Date_select date=new Date_select();
Flyrobe_cart cart=new Flyrobe_cart();
Flyrobe_checkout checkout=new Flyrobe_checkout();
Flyrobe_together_order together=new Flyrobe_together_order();
Flyrobe_listPage list=new Flyrobe_listPage();
Flyrobe_details detail=new Flyrobe_details();
//Flyrobe_cart cart=new Flyrobe_cart();
//Flyrobe_checkout checkout=new Flyrobe_checkout();
config.pageload();
//log.chooiselogin(null);
log.chooiselogin(null);
date.autodate();
//date.manualdate();
date.genderselecthome();
list.listpage();;
//driver.navigate().refresh();
//detail.detailsmanualdatepage();
//detail.detailspagemenautodate();
detail.detailsautodatepage();
//together.menshop();

cart.cart();
checkout.checkout();
config.escalation();

}
	
}