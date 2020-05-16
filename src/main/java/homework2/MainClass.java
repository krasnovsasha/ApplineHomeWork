package homework2;

import java.io.*;
import java.util.*;

/*		Домашнее задание No2
		На входе имеется файл, заполненный словами. Необходимо считать все
		слова из файла, отсортировать их в алфавитном порядке и вывести на экран.
		Посчитать, сколько раз встречается в файле каждое из слов и вывести статистику
		на экран.
		Найти слово, встречающееся максимальное число раз в файле и его частоту и
		вывести на экран.
		Замечания:
		Предусмотреть ввод пользователем пути к файлу, как абсолютного, так и
		относительного.
		В случае нескольких слов с максимальной частотой выводить необходимо
		все.
		Предусмотреть, что слова могут быть разделены не только пробелами, но и
		знаками препинания, табуляции и переноса строки, все эти символы не
		должны учитываться.
		Допускается только один полный обход файла.
*/
public class MainClass {
	public static void main(String[] args) {
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br2 = null;
		StringBuilder sb = new StringBuilder();
		try {
			String userInput = br1.readLine();
			String[] str = userInput.split("[\\\\/]");
			File inFile = new File(str[str.length - 1]);
			br2 = new BufferedReader(new FileReader(inFile));
			while (br2.ready()) {
				sb.append(br2.readLine()).append(" ");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br1.close();
				assert br2 != null;
				br2.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		String[] words = sb.toString().replaceAll("\\p{Punct}", " ").split("\\s+");
		ArrayList<String> arrList = new ArrayList<>(Arrays.asList(words));
		Collections.sort(arrList);
		arrList.forEach(System.out::println);
		TreeMap<String, Integer> tm = new TreeMap<>();
		for (String s : arrList) {
			tm.put(s, tm.getOrDefault(s, 0) + 1);
		}
		int count = 0;
		for (Map.Entry<String, Integer> pair : tm.entrySet()) {
			System.out.println(pair.getKey() + " - " + pair.getValue());
			if (count < pair.getValue()) count = pair.getValue();
		}
		for (Map.Entry<String, Integer> pair : tm.entrySet()) {
			if (pair.getValue() == count) System.out.println(pair.getKey() + " - " + count);
		}
	}
}
