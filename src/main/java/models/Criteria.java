package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Criteria {
	@SerializedName("lastName")
	@Expose
	public String lastName;
	@SerializedName("productName")
	@Expose
	public String productName;
	@SerializedName("minTimes")
	@Expose
	public Integer minTimes;
	@SerializedName("minExpenses")
	@Expose
	public Integer minExpenses;
	@SerializedName("maxExpenses")
	@Expose
	public Integer maxExpenses;
	@SerializedName("badCustomers")
	@Expose
	public Integer badCustomers;
}
