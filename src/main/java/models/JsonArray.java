package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JsonArray {
	@SerializedName("criterias")
	@Expose
	public List<Criteria> criterias = null;
}
