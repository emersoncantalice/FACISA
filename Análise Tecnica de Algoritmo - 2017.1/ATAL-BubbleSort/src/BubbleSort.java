import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BubbleSort {

	public static void main(String[] args) {

		if (args.length > 0 && args.length < 3) {

			File file = new File(args[0]);
			Scanner reader = null;
			try {
				reader = new Scanner(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				System.out.println("Error read file!");
				System.exit(0);
			}
			List<Integer> listValues = readFile(reader);

			if (args[1].equals("bs")) {
				BigDecimal init = new BigDecimal(System.currentTimeMillis());
				bubbleSort(listValues);
				BigDecimal end = new BigDecimal(System.currentTimeMillis());
				printValuesSorted(listValues, (end.subtract(init)));
			} else if (args[1].equals("bs_melhorado")) {
				BigDecimal init = new BigDecimal(System.currentTimeMillis());
				bubbleSortBest(listValues);
				BigDecimal end = new BigDecimal(System.currentTimeMillis());
				printValuesSorted(listValues, (end.subtract(init)));
			} else {
				System.out.println("Invalid sort type.");
			}

		} else {
			System.out.println("Arguments invalid.");
		}

	}

	private static List<Integer> readFile(Scanner reader) {
		// variavel que armazenara as linhas do arquivo
		String linesFile = new String();
		List<Integer> listValues = new ArrayList<Integer>();
		Integer value;
		while (reader.hasNext()) {
			linesFile = reader.nextLine();
			String[] values = linesFile.split(",");
			for (String valor : values) {
				listValues.add(value = new Integer(valor));
			}
		}

		return listValues;
	}

	private static void printValuesSorted(List<Integer> listValues,
			BigDecimal duration) {
		for (Integer valueSorted : listValues) {
			System.out.println(valueSorted + " ");
		}
		System.out.println("Duration: " + duration);
	}

	private static void bubbleSort(List<Integer> listValues) {
		for (int n = 1; n < listValues.size(); n++) {
			for (int i = 0; i < listValues.size() - 1; i++) {
				if (listValues.get(i) > listValues.get(i + 1)) {
					int aux = listValues.get(i);
					listValues.set(i, listValues.get(i + 1));
					listValues.set(i + 1, aux);
				}
			}
		}
	}

	private static void bubbleSortBest(List<Integer> listValues) {
		for (int n = 1; n < listValues.size(); n++) {
			for (int i = listValues.size() - 1; i >= n; i--) {
				if (listValues.get(i) > listValues.get(i + 1)) {
					int aux = listValues.get(i);
					listValues.set(i, listValues.get(i + 1));
					listValues.set(i + 1, aux);
				}
			}
		}
	}

}
