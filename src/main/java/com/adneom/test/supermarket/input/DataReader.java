package com.adneom.test.supermarket.input;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public final class DataReader {

	private static final String NEXT_ACTION_PATTERN = "[/,#]";
	private static final String PRODUCT_PATTERN = "[1-3]";

	private DataReader() {

	}

	/**
	 * consomme de l'entrée standard pour savoir si on va saisir un autre
	 * produit ou on affiche prix total
	 * 
	 * @param scan
	 * @return / ou #
	 */
	public static String readNextAction(Scanner scan) {
		System.out.println("Utiliser la touche / pour passer au produit suivant et # pour finir la saisie");
		if (!scan.hasNext(Pattern.compile(NEXT_ACTION_PATTERN))) {
			scan.nextLine();
			while (scan.hasNext()) {
				if (scan.hasNext(Pattern.compile(NEXT_ACTION_PATTERN))) {
					break;
				}
				printWrongElementError();
				scan.nextLine();
			}
		}
		String input = scan.next();
		return input;

	}

	private static void printWrongElementError() {
		System.err.println("l'élément saisie n'est pas accépté !");
	}

	/**
	 * consomme de l'entrée standard pour savoir le type du produit
	 * 
	 * @param scan
	 * @return product type
	 */
	public static int readProductType(Scanner scan) {
		System.out.println("Tapez 1 pour sélectionner Pomme, 2 pour Orange, 3 pour pastèque");
		if (!scan.hasNext(Pattern.compile(PRODUCT_PATTERN))) {
			scan.nextLine();
			while (scan.hasNext()) {
				if (scan.hasNext(Pattern.compile(PRODUCT_PATTERN))) {
					break;
				}
				printWrongElementError();
				scan.nextLine();
			}
		}
		return scan.nextInt();
	}

	/**
	 * consomme de l'entrée standard pour savoir le prix unitaire du produit
	 * 
	 * @param scan
	 * @return product Price
	 */
	public static float readProductPrice(Scanner scan) {
		System.out.println("Saisissez le prix unitaire du produit:");
		if (!scan.hasNextFloat()) {
			scan.nextLine();
			while (scan.hasNext()) {
				if (scan.hasNextFloat()) {
					break;
				}
				printWrongElementError();
				scan.nextLine();
			}
		}
		return scan.nextFloat();
	}

	/**
	 * consomme de l'entrée standard pour savoir la quantité du produit
	 * 
	 * @param scan
	 * @return product quantity
	 */
	public static int readProductQuantiy(Scanner scan) {
		System.out.println("Saisissez la quantité du produit:");
		if (!scan.hasNextInt()) {
			scan.nextLine();
			while (scan.hasNext()) {
				if (scan.hasNextInt()) {
					break;
				}
				printWrongElementError();
				scan.nextLine();
			}
		}
		return scan.nextInt();
	}

	/**
	 * consomme de l'entrée standard pour savoir le nom du produit
	 * 
	 * @param scan
	 * @return product name
	 */
	public static String readProductName(Scanner scan) {
		System.out.println("Saisissez le nom du produit:");
		while (true) {
			try {
				return scan.next();
			} catch (InputMismatchException e) {
				printWrongElementError();
			}
		}
	}

}
