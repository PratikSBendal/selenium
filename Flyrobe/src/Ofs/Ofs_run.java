package Ofs;

import java.io.IOException;

import org.testng.annotations.Test;

public class Ofs_run extends Ofs_config {
	
public static void main(String args[])throws IOException, InterruptedException 
{
	Ofs_config config=new Ofs_config();
	CC_tab cc=new CC_tab();
	Om_tab om=new Om_tab();
	int i=1;
	switch(i)
	{
	case 1:
    config.Ofs_launch();
	cc.cctabdelivery();
	om.feasign();
	om.confrimorder();
     om.om_logistic();
    cc.cctab_pickup();
	om.om_logistic_pickup();
	break;
	case 2:
		System.out.println("Hello");
		break;
	default:
		   System.out.println("Default ");
	     
	}	
	
}
}
