package homework3;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.*;

public class MainClass {
	public static void main(String[] args) throws FileNotFoundException {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateDeserializer());
		Gson gson = gsonBuilder.create();
		ArrayList<Company> companies;
		companies = gson.fromJson(new FileReader("test.json"), new TypeToken<List<Company>>() {
		}.getType());
		System.err.println("Вывести все имеющиеся компании в формате" +
				" «Краткое название» – «Дата основания 17/01/98»\n");
		companies.forEach(System.out::println);
		System.out.println();
		System.err.println("Вывести все ценные бумаги " +
				"(их код, дату истечения и полное название организации-владельца),\n"
				+ "которые просрочены на текущий день, " +
				"а также посчитать суммарное число всех таких бумаг :\n");
		companies.forEach((s) -> s.getSecurities().stream()
				.filter((d) -> d.getDate_to().isBefore(LocalDate.now()))
				.forEach(System.out::println));
		ArrayList<ArrayList<Company.Security>> sec = new ArrayList<>();
		for (Company c : companies) {
			sec.add(c.getSecurities());
		}
		int count = 0;
		for (ArrayList<Company.Security> s : sec) {
			for (Company.Security s1 : s) {
				if (s1.getDate_to().isBefore(LocalDate.now())) {
					count++;
				}
			}
		}
		System.out.println("Количество аннулированных ценных бумаг : " + count);
		System.out.println();
		System.err.println("Названия и даты создания всех организаций, основанных после введенной даты :\n");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		companies.stream().filter((c) -> c.getEgrul_date()
						.isAfter(LocalDateDeserializer.parseStringToDate("05.05.2005")))
						.forEach(System.out::println);
		System.out.println();
		String userInput = "USD";
		System.err.println("ID и коды ценных бумаг, использующих заданную валюту " + userInput);
		System.out.println();
		companies.forEach((c)->c.getSecurities()
				.stream().filter((security)->security.getCurrency().getCode().equals(userInput))
				.forEach((secur)->System.out.println(secur.getId() + " " + secur.getCode())));
	}
}
