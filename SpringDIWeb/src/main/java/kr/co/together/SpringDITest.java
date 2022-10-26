package kr.co.together;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

class Car {}
class Engine{}
class Door{}

public class SpringDITest {

	public static void main(String[] args) {
		ApplicationContext ac = new GenericXmlApplicationContext("config.xml");
		Car car = (Car) ac.getBean("car");				// byName 이름으로 찾음
		Car car2 = (Car) ac.getBean("car");
		Car car3 = ac.getBean("car", Car.class);
		Engine engine = (Engine) ac.getBean("engine");	// byName
		Door door = (Door) ac.getBean("door");			// byName
		
		System.out.println("car = " + car);
		System.out.println("car2 = " + car2);
		System.out.println("car3 = " + car3);			// singleton 객체의 인스턴스가 오직 1개만 생성
		System.out.println("engine = " + engine);
		System.out.println("door = " + door);
	}	
}
