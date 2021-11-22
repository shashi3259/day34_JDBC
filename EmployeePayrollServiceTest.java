package com.bridgelab.jdbcTest;

import com.bridgelab.jdbc.*;

import java.util.List;

import org.junit.Test;

import com.bridgelab.jdbc.EmployeePayrollDBService;

import junit.framework.Assert;
import com.bridgelab.jdbcTest.*;
public class EmployeePayrollServiceTest {
	
	/*
	EmployeePayrollService employeePayrollService;
	employeePayrollService = new EmployeePayrollService(Arrays.asList(arrayOfEmps));
	employeePayrollService.writeEmployeePayrollData(FILE_IO);
	employeePayrollService.printData(FILE_IO);
	long entries = employeePayrollService.countEntries(FILE_IO);
	Assert.assertEquals(3, entries);
	*/
	
	@Test
	public void givenEmployeePayrollInDB_WhenRetrived_ShouldMatchEmployeeCount() {
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		List<EmployeePayrollData> employeePayrollData = employeePayrollService.readEmployeePayrollData(DB_IO);
		Assert.assertEquals(4, employeePayrollData.size());
	}
	
	
	@Test
	public void givenNewSalaryForEmployee_WhenUpdated_ShouldSynWithDB() {
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		List<EmployeePayrollData> employeePayrollData = employeePayrollService.readData(DB_IO);
		employeePayrollService.updateEmployeeSalary("Terisa", 300000.0);
		boolean result = employeePayrollService.checkEmployeePayrollnSyncWithDB("Terisa");
		Assert.assertTrue(result);
		
	}

}
