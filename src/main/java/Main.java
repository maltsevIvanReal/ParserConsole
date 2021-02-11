import com.google.gson.Gson;
import models.JsonArray;
import services.ServiceJson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Main {
	public static void main(String[] args) {

//		Gson gsonPrint = new GsonBuilder().setPrettyPrinting().create();
		Gson gson = new Gson();
		JsonArray jsonArray;
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader("input.json"));
			jsonArray = gson.fromJson(br, JsonArray.class);

			if (jsonArray != null) {
				ServiceJson.parseJson(jsonArray.criterias);
			}

		} catch (Exception e) {
			System.out.println("Ошибка. Некорректные данные Json-файла. Подробнее: " + e.getMessage());
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}


//		System.out.println(ServiceJson.userLastName);
//
//		System.out.println(ServiceJson.productType);
//
//		System.out.println(ServiceJson.minMaxExpenses);
//
//		System.out.println(ServiceJson.badCustomers);
//
//		ServiceJson.getCustomersByLastName(ServiceJson.userLastName);


//		String json = gsonPrint.toJson(object);


	}
}
