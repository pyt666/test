/**
 * 
 */
package test.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


/**
 * @author pyt
 *
 */
class testSpring {

	@Test
	void test() {
		ApplicationContext factory = new FileSystemXmlApplicationContext("D:/workspace/test/src/Beans.xml");
		HelloWorld obj = (HelloWorld) factory.getBean("helloWorld");		
		obj.getUser();
		obj.getMessage();
	}

}
