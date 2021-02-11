package services;

import DAO.DAO;
import lombok.Getter;
import models.Criteria;
import models.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class ServiceJson {

	public static List<String> userLastName = new ArrayList<>();
	public static Map<String, Integer> productType = new HashMap<>();
	public static Map<Integer, Integer> minMaxExpenses = new HashMap<>();
	public static List<Integer> badCustomers = new ArrayList<>();


	public static Map<String,String> fromDBUsers = new HashMap<>();





	public static int VALID = 1;
	public static int PRODUCT_NAME_INCORRECT = 2;
	public static int PRODUCT_TIMES_INCORRECT = 3;
	public static int MIN_EXPRESS_INCORRECT = 4;
	public static int MAX_EXPRESS_INCORRECT = 5;

	public static void getCustomersByLastName(List<String> usersLastNames) throws SQLException {
		if (usersLastNames.size() != 0) {
			DAO.getUsers(usersLastNames);
		}
	}

	public static void getCountOfProductBought(List<Map<String, Integer>> products) {

	}

	public static void getCustomersIntervalByShopping(List<HashMap<Integer, Integer>> minAndMax) {

	}

	public static void getBadCustomersByCount(Integer count) {

	}

	public static int isValidJson() {
		return 0;
	}

	public static void parseJson(List<Criteria> json) {

		if (json != null) {
			for (Criteria criteria : json) {

				if (isLastNameCriteria(criteria)) {
					userLastName.add(criteria.lastName);
				}
				if (isProductNameAndMinTimesCriteria(criteria)) {
					productType.put(criteria.productName, criteria.minTimes);
				}
				if (isMinMaxExpensesCriteria(criteria)) {
					minMaxExpenses.put(criteria.minExpenses, criteria.maxExpenses);
				}
				if (isBadCustomersCriteria(criteria)) {
					badCustomers.add(criteria.badCustomers);
				}

			}
		}

	}


	private static boolean isLastNameCriteria(Criteria criteria) {
		return criteria.lastName != null && criteria.productName == null && criteria.minTimes == null && criteria.minExpenses == null && criteria.maxExpenses == null && criteria.badCustomers == null;
	}

	private static boolean isProductNameAndMinTimesCriteria(Criteria criteria) {
		return criteria.lastName == null && criteria.productName != null && criteria.minTimes != null && criteria.minExpenses == null && criteria.maxExpenses == null && criteria.badCustomers == null;
	}

	private static boolean isMinMaxExpensesCriteria(Criteria criteria) {
		return criteria.lastName == null && criteria.productName == null && criteria.minTimes == null && criteria.minExpenses != null && criteria.maxExpenses != null && criteria.badCustomers == null;
	}

	private static boolean isBadCustomersCriteria(Criteria criteria) {
		return criteria.lastName == null && criteria.productName == null && criteria.minTimes == null && criteria.minExpenses == null && criteria.maxExpenses == null && criteria.badCustomers != null;
	}

}
