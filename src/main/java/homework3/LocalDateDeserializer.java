package homework3;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

class LocalDateDeserializer implements JsonDeserializer<LocalDate> {
	@Override
	public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		return LocalDate.parse(json.getAsString(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}
	static LocalDate parseStringToDate(String text) {
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd.MM.yy");
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("dd/MM/yy");
		DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		try {
			return LocalDate.parse(text, formatter1);
		} catch (DateTimeParseException e1) {
			try {
				return LocalDate.parse(text, formatter2);
			} catch (DateTimeParseException e2) {
				try {
					return LocalDate.parse(text, formatter3);
				} catch (DateTimeParseException e3) {
					try {
						return LocalDate.parse(text, formatter4);
					} catch (DateTimeParseException e4) {
						e4.printStackTrace();
					}
				}
			}
		}
		return null;
	}
}
