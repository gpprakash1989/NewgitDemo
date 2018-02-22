package com.Tecksystem.country.Testcases;

import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class FilloApiTestExcel {

String strQuery;


	@Test
	public void FilloTest() throws FilloException{
		Fillo fillo	=new Fillo();
		Connection connection =fillo.getConnection("E://FDrive//Workspace_prog//TeckSystem_CountryPJ//ExcelFold//Petrol_Lokesh.xlsx");

		System.out.println("Your connectoin string "+connection);
		
		strQuery= "Select * from Sheet1 where Sequence=135";
		//strQuery = "Select CAST(FromDate AS DATE) AS Notes from Sheet1";

		//String strQuery="Select * from Sheet1  where Sequence != 135";	

		Recordset recordset = connection.executeQuery(strQuery);
		
		System.out.println("recordset---------"+recordset);
		System.out.println("Recordset values"+recordset.toString().getBytes());
		while(recordset.next()){
			System.out.println(recordset.getField(1).value());
		}

		recordset.close();
		connection.close();
	}


}



