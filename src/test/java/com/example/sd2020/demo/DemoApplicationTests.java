package com.example.sd2020.demo;

import com.example.sd2020.demo.arch.FacadeSample;
import com.example.sd2020.demo.arch.SampleOperations;
import com.example.sd2020.demo.entity.Client;
import com.example.sd2020.demo.entity.Echipament;
import com.example.sd2020.demo.service.ClientService;
import com.example.sd2020.demo.service.EchipamentService;
import com.example.sd2020.demo.service.MonitorService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class DemoApplicationTests {

	ClientService clientservice=new ClientService();
	EchipamentService echipamentservice=new EchipamentService();
	MonitorService monitorservice=new MonitorService();
	@Mock
	SampleOperations sampleOperations;
	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	private FacadeSample facadeSample;

	@Before
	public void init() {
		facadeSample = new FacadeSample(sampleOperations);
	}

	@Test
	public void testSample() {
		facadeSample.retrieveList();
		verify(sampleOperations).getList();
	}

	@Test
	public void testSampleAssert() {
		List<Integer> expectedList = new ArrayList<>();
		expectedList.add(2);
		expectedList.add(4);
		expectedList.add(5);

		when(sampleOperations.getList()).thenReturn(expectedList);
		List<Integer> currentList = facadeSample.retrieveList();
		assertEquals(expectedList, currentList);
	}
    /*
	@Test
	public void testFindClientById(){
		when(sampleOperations.FindClientById("6")).thenReturn(clientservice.findById("6"));
		assertEquals("Ioan",facadeSample.findClient("6").getNume());
		verify(sampleOperations).FindClientById("6");
	}
     */

    //Asa ar trebui facute toate testele? Ca nu am inteles prea bine....
	@Test
	public void testFindClientById(){
		when(sampleOperations.FindClientById("6")).thenReturn(new Client("Ioan","Ioan@yahoo.com",false,"incepator",true));
		assertEquals("Ioan",facadeSample.findClient("6").getNume());
		verify(sampleOperations).FindClientById("6");
	}
    //Stiu ca ai spus ca nu e corect in felul urmator:
	//Daca e corect cel de sus, asa o sa fac la toate.
	@Test
	public void testFindEchipamentById(){
		when(sampleOperations.FindEchipamentById("33")).thenReturn(echipamentservice.findById("33"));
		assertEquals("Head",facadeSample.findEchipament("33").getNume());
		verify(sampleOperations).FindEchipamentById("33");
	}

	@Test
	public void testFindMonitorById(){
		when(sampleOperations.FindMonitorById("35")).thenReturn(monitorservice.findById("35"));
		assertEquals("Iancu",facadeSample.findMonitor("35").getNume());
		verify(sampleOperations).FindMonitorById("35");
	}


}
