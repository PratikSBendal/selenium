package Flyrobe_block_logic;

import java.io.IOException;

import org.testng.annotations.Test;

import Flyrobe.Flyrobe_login;
import Flyrobe.Flyrobe_together_order;

public class Run_Test_block_logic extends Flyrobe_config{
	@Test
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		login log=new login();
Flyrobe_config config=new Flyrobe_config();
Block_logic_Parent blocklogic= new Block_logic_Parent();
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
log.chooiselogin(null);
date.manualdate();
date.genderselecthome();
list.listpage();
detail.detailsmanualdatepage();
cart.cart();
checkout.checkout();
blocklogic.logic();
config.escalation();

}
	
}