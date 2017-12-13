package com.app.howtocook;

import com.app.app.HowtocookApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class HowtocookApplicationTests {

	@Autowired
	HowtocookApplication howtocookApplication;

	@Test
	public void contextLoads() {
		System.out.print( "!\n\n\n\n\n\n\n!!!!!!!!!!!!!!!!!" + howtocookApplication.toString() );
	}

}
