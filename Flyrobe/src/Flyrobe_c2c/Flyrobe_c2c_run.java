package Flyrobe_c2c;

import java.io.IOException;

import org.testng.annotations.Test;

public class Flyrobe_c2c_run extends Flyrobe_C2C{
@Test
	public static void main(String[] args) throws IOException, InterruptedException {
	Flyrobe_C2C c2c=new Flyrobe_C2C();
		Flyrobe_c2c_ofs ofs=new Flyrobe_c2c_ofs();
c2c.c2c_launch();
c2c.c2c_enterdata();
ofs.flyrobeofs();
c2c.c2cexit();		
	}


}
