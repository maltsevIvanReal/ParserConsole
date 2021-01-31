import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.JsonArray;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
	public static void main(String[] args) {


		Gson gsonPrint = new GsonBuilder().setPrettyPrinting().create();
		Gson gson = new Gson();
		JsonArray object = null;

		try {
			object = gson.fromJson(new FileReader("input.json"), JsonArray.class);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		String json = gsonPrint.toJson(object);

	}
}
