package com.mms.test;

import static org.junit.Assert.fail;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mms.domain.Department;
import com.mms.domain.Device;
import com.mms.domain.Domain;
import com.mms.domain.Employee;
import com.mms.domain.Meeting;
import com.mms.domain.MeetingRoom;
import com.mms.enumeration.State;
import com.mms.enumeration.Time;

public class DomainTest {

	private SessionFactory sessionFactory;
	private Session session;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		Configuration configuration = new Configuration().configure(new File(this.getClass().getClassLoader()
				.getResource("testconfig/hibernate.cfg.xml").getFile()));
		sessionFactory = configuration.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build());
		try {
			session = sessionFactory.getCurrentSession();
			if (!session.isOpen()) {
				session = sessionFactory.openSession();
			}
		} catch (Exception e) {
			session = sessionFactory.openSession();
		}
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLoad() {
		fail("Not yet implemented");
	}

	@Test
	public void testSave() {
		session.beginTransaction();
		// Department department = new Department();
		// department.setName("新闻部");
		// department.setEmployees(new ArrayList<Employee>());
		// Employee employee = new Employee();
		// employee.setName("卓嘉俊");
		// employee.setEmail("984408770@qq.com");
		// employee.setRole(Role.Admin);
		// employee.setPassword("123123");
		// employee.setPhone(((Integer) 123456).longValue());
		// employee.setUsername("z");
		// employee.setDepartment((Department)
		// session.load("com.mms.domain.Department", 1));
		// MeetingRoom meetingRoom = new MeetingRoom();
		// meetingRoom.setAddress("垃圾堆");
		// meetingRoom.setMaxCount(100);
		// Device device = new Device();
		// device.setName("全息投影仪");
		// device.setCount(100);
		// device.setLeisure(100);
		Meeting meeting = new Meeting();
		meeting.setDate(new Date());
		meeting.setTime(Time.Dusk);
		meeting.setInfo("asd");
		meeting.setState(State.Allow);
		meeting.setRecord("zxc");
		meeting.setHostEmployee((Employee) session.load(Employee.class, 1));
		meeting.setTopic("asd");
		List<Employee> employees = new ArrayList<Employee>();
		meeting.setEmployees(employees);
		List<Device> devices = new ArrayList<Device>();
		meeting.setDevices(devices);
		meeting.setCount(meeting.getEmployees().size());
		meeting.setMeetingRoom((MeetingRoom) session.load(MeetingRoom.class, 1));
		session.save(meeting);
		System.out.println(meeting.getId());
		session.getTransaction().commit();
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		Employee employee = (Employee) session.load(Employee.class, 1);
		// employee.setPhone(((Integer) 12345678).longValue());
		// employee.setUsername("z");
		Department department = new Department();
		// Department department = (Department) session.load(Department.class,
		// 2);
		department.setId(1);
		// department.setName("垃圾部111");
		employee.setDepartment(department);
		// employee.getDepartment().setName("垃圾部11");
		// Department department = (Department) session.load(Department.class,
		// 1);
		// Employee employee = new Employee();
		// department.setId(1);
		// department.setName("餐饮部6");

		// employee.setName("卓嘉俊");
		// employee.setEmail("984408770@qq.com");
		// employee.setRole(Role.Admin);
		// employee.setPassword("123123");
		// employee.setPhone(((Integer) 123456).longValue());
		// employee.setUsername("zzz");
		// employee.setDepartment(department);
		// department.getEmployees().get(0).setPhone(((Integer)
		// 10900).longValue());
		// department.getEmployees().add(employee);

		session.merge(employee);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testList() {
		session.beginTransaction();
		for (Domain d : (List<Domain>) session.createQuery("from " + Department.class.getName()).list()) {
			System.out.println(d.format());
		}
		session.getTransaction().commit();
	}
}
