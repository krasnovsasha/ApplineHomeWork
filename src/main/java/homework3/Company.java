package homework3;

import java.time.LocalDate;
import java.util.ArrayList;

class Company {
	private int id;
	private String code;
	private String name_full;
	private String name_short;
	private long inn;
	private Company_type company_type;
	private long ogrn;
	private LocalDate egrul_date;
	private Country country;
	private String fio_head;
	private String address;
	private String phone;
	private String e_mail;
	private String www;
	private boolean is_resident;
	private ArrayList<Security> securities;

	public ArrayList<Security> getSecurities() {
		return securities;
	}

	@Override
	public String toString() {
		return name_short + " - " + egrul_date;
	}

	class Company_type {
		private int id;
		private String name_short;
		private String name_full;

		@Override
		public String toString() {
			return id + " " + name_short + " " + name_full;
		}
	}

	class Country {
		private int id;
		private String code;
		private String name;
	}

	class Security {
		private int id;
		private String code;
		private String name_full;
		private String cfi;
		private LocalDate date_to;
		private LocalDate state_reg_date;
		private State state;
		private Currency currency;

		public LocalDate getDate_to() {
			return date_to;
		}

		@Override
		public String toString() {
			return code + " " + date_to + " " + name_full;
		}
	}

	class State {
		private int id;
		private String name;
	}

	class Currency {
		private int id;
		private String code;
		private String nameShort;
		private String nameFull;
	}
}
