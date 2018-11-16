package com.stockreport;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;





public class CustomerInJson 
{
	Scanner scanner=new Scanner(System.in);
	 static JSONParser parser =new JSONParser();

	public CustomerInJson() {
		// TODO Auto-generated constructor stub
		CustomerDetail  c=new CustomerDetail();
		CustomerProductDetail c1=new CustomerProductDetail();
	System.out.println("enter ur id");
	c.setId(scanner.nextInt());
	System.out.println("enter ur name");
	c.setName(scanner.next());
	System.out.println("enter ur phone number");
	c.setNum(scanner.next());
	int product[]=new int[3];
	String name[]=new String[3];
	for (int i = 0; i < 3; i++)
	{
		product[i]=0;
		
	}
	
	c1.setProductShare(product);
	
	name=getStockName();
	c1.setProductName(name);
	ObjectMapper mapper=new ObjectMapper();
	String json="[",json1="[";
	
	try {
			File file=new File("/home/bridgelabz/stock/customerdetail.json");
			
			if(file.length()==0)
			{
						//System.out.println(c+" "+c1);
	        		 json=json+mapper.writeValueAsString(c)+"]";
	        		 json1=json1+mapper.writeValueAsString(c1)+"]";
			}
			else
			{
				//JSONArray a= (JSONArray) parser.parse(new FileReader("/home/bridgelabz/stock/customerdetail.json"));
				//System.out.println(a.size());
				Object obj = parser.parse(new FileReader("/home/bridgelabz/stock/customerdetail.json"));
				Object obj1 = parser.parse(new FileReader("/home/bridgelabz/stock/customerproductdetail.json"));
				JSONArray array=new JSONArray();
				JSONArray array2=new JSONArray();
				array=(JSONArray) obj;
				array2=(JSONArray) obj1;
				for (int i = 0; i < array.size(); i++)
				{
					
					if(i==0)
					{
						json=json+array.get(i)+",";
						json1=json1+array2.get(i)+",";
					}
					else
					{
						json=json+array.get(i)+",";
						json1=json1+array2.get(i)+",";
					}
				}
					json=json+mapper.writeValueAsString(c)+"]";
					json1=json1+mapper.writeValueAsString(c1)+"]";
					//System.out.println("hi");
					

			}}catch (IOException e1) {
				e1.printStackTrace();
} catch (ParseException e) {
	
	e.printStackTrace();
}
 try  {
	 	FileWriter file = new FileWriter("/home/bridgelabz/stock/customerdetail.json");
	 	FileWriter file1 = new FileWriter("/home/bridgelabz/stock/customerproductdetail.json");
        file.write(json);
        file1.write(json1);
        System.out.println();
        System.out.println("successfully added");
        file.flush();
        file1.flush();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
	private String[] getStockName() 
	{
		String pName[]=new String[3];
		JSONParser parser =new JSONParser();
		//ObjectMapper mapper=new ObjectMapper();
		JSONObject name[];
		Object o[];
		try {

			Object obj = parser.parse(new FileReader("/home/bridgelabz/stockmaintain.json"));
			//System.out.println(obj);
			JSONArray array=new JSONArray();
			array=(JSONArray) obj;
			//System.out.println(array.size());
			name=new JSONObject[array.size()];
			o=new Object[array.size()];
			
			JSONObject jsonObject[]=new JSONObject[array.size()];
			int j=1;
			for (int i = 0; i < array.size(); i++)
			{
				
				o[i]=array.get(i);

				jsonObject[i]=(JSONObject) o[i];
				
				//System.out.println(jsonObject[i]);
				String cat="Stock"+j;
				name[i] = (JSONObject) jsonObject[i].get(cat);
				j++;
				pName[i]=(String) name[i].get("StockName");
				
			}
		
		} catch (IOException | ParseException e) {
		
			e.printStackTrace();
		}
		return pName;
	}
	static void printCustomerDetail()
	{
		File file=new File("/home/bridgelabz/stock/customerdetail.json");
		if(file.length()==0)
		{
			System.out.println("there is no content in file");
			
		}
		else
		{
			ObjectMapper mapper=new ObjectMapper();
			try {

			Object obj = parser.parse(new FileReader("/home/bridgelabz/stock/customerdetail.json"));
			Object obj1=parser.parse(new FileReader("/home/bridgelabz/stock/customerproductdetail.json"));

			JSONArray array=new JSONArray();
			array=(JSONArray) obj;
			JSONArray array1=new JSONArray();
			array1=(JSONArray) obj1;
			
			
			for (int i = 0; i < array.size(); i++)
			{
				System.out.println();
				CustomerDetail c1=mapper.readValue(array.get(i).toString(), CustomerDetail.class);
				System.out.print(c1.getId()+" "+c1.getName()+" "+c1.getNum());
				CustomerProductDetail c2=mapper.readValue(array1.get(i).toString(), CustomerProductDetail.class);
					
					String name[]=c2.getProductName();
					int share[]=c2.getProductShare();
				
						System.out.print(" [");
						for (int j = 0; j < share.length; j++) 
						{
							System.out.print(share[j]+" ");
						}
							System.out.print("]");
							System.out.print(" [");
							for (int j = 0; j < name.length; j++) 
							{
								
								System.out.print(name[j]+" ");
							}
								System.out.print("]");
						}
								
					System.out.println();
			//	CustomerDetail c2=mapper.readValue(src, valueType)
			
			
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
}
