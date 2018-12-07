package S_Ofs;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class Run_ofs extends Configuration_ofs
{
	
	@Test(priority=1)
	public void flow1() throws IOException, InterruptedException
	{
		fileinput1=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\Flyrobe\\src\\S_Ofs\\Flow\\flow1.txt");
		 obj = new Properties();
		 obj.load(fileinput1);
		 String orderid=obj.getProperty("OrderId");
		 String CCtab=obj.getProperty("CCtab");
		String feassign=obj.getProperty("FEA");
		String measured=obj.getProperty("Measured");
		String confrim=obj.getProperty("Confrimde");
		String alt=obj.getProperty("Alt");
		String iqc=obj.getProperty("Iqc");
		String pkd=obj.getProperty("Pkd");
		String dba=obj.getProperty("DBA");
		String dvd=obj.getProperty("DVD");
		String psd=obj.getProperty("PSD");
		String piup=obj.getProperty("PIUP");
		Configuration_ofs config=new Configuration_ofs();
		CCtab_ofs cc=new CCtab_ofs();
		OMtab_ofs om=new OMtab_ofs();
		config.Ofs_launch();
		cc.cctabdelivery(orderid,CCtab);
		om.feasign(orderid,feassign,measured,confrim);
		om.confrimorder(orderid,alt,iqc,pkd);
		om.om_logistic(orderid,dba,dvd);
		cc.cctab_pickup(orderid,psd);
		om.om_logistic_pickup(orderid,piup);
		Thread.sleep(2000);
		driver.close();
	}
	
	@Test(priority=2)
	public void flow2() throws IOException, InterruptedException
	{
		fileinput2=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\Flyrobe\\src\\S_Ofs\\Flow\\flow2.txt");
		 obj = new Properties();
		 obj.load(fileinput2);
		 String orderid=obj.getProperty("OrderId");
		 String CCtab=obj.getProperty("CCtab");
		 String feassign=obj.getProperty("FEA");
		 String measured=obj.getProperty("Measured");
		 String confrim=obj.getProperty("Confrimde");
		 String alt=obj.getProperty("Alt");
		 String iqc=obj.getProperty("Iqc");
		 String pkd=obj.getProperty("Pkd");
		 String dba=obj.getProperty("DBA");
		 String dvd=obj.getProperty("DVD");
		 String psd=obj.getProperty("PSD");
		String piup=obj.getProperty("PIUP");
		Configuration_ofs config=new Configuration_ofs();
		CCtab_ofs cc=new CCtab_ofs();
		OMtab_ofs om=new OMtab_ofs();
		config.Ofs_launch();
		cc.cctabdelivery(orderid,CCtab);
//		om.feasign(orderid,feassign,measured,confrim);
		om.confrimorder(orderid,alt,iqc,pkd);
		om.om_logistic(orderid,dba,dvd);
		cc.cctab_pickup(orderid,psd);
		om.om_logistic_pickup(orderid,piup);
		Thread.sleep(2000);
		driver.close();
	}
	
	
	
	
//	@Test
//	public void test()
//	{
//		System.out.println("Hello test");
//	}
//	@Test
//	public void test2()
//	{
//		System.out.println("Hello test 1");
//	}
	
	
//	
//	@Test(priority=1,description="Ofs_Launch")
//	public void config() throws IOException, InterruptedException
//	{
//		Configuration_ofs config=new Configuration_ofs();
//		config.Ofs_launch();
//	}
//	@Test(priority=2,description="CCtab_Launch")
//	public void cctabdelivery() throws IOException, InterruptedException
//	{
//		CCtab_ofs cc=new CCtab_ofs();
//		cc.cctabdelivery();
//	}
//	@Test(priority=3,description="Omtab_Feassgin_to_package")
//	public void Omtab_Feassgin_to_package() throws InterruptedException, IOException
//	{
//		OMtab_ofs om=new OMtab_ofs();
//		om.feasign();
//		om.confrimorder();
//		om.om_logistic();
//	}
//	@Test(priority=4,description="CCtab_pickup")
//	public void cctabpickup() throws IOException, InterruptedException
//	{
//		CCtab_ofs cc=new CCtab_ofs();
//		cc.cctab_pickup();
//	}
//	@Test(priority=4,description="CCtab_pickup")
//	public void om_logistic_pickup() throws IOException, InterruptedException
//	{
//		OMtab_ofs om=new OMtab_ofs();	
//		om.om_logistic_pickup();
//		Thread.sleep(2000);
//		driver.close();
//	}
//	
//	
//	
	
	
	
}
