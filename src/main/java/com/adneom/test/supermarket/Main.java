package com.adneom.test.supermarket;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.adneom.test.supermarket.products.*;

public class Main {

	public static void main(String[] args) {
		initializeScreen();
		Basket basket = new Basket();
		fillBasket(basket);
		printBasketPrice(basket);
	}

	/**
	 * affiche le prix totale du panier
	 * 
	 * @param basket
	 */
	private static void printBasketPrice(Basket basket) {
		System.out.println("Montant � payer: " + basket.calculateTotalPrice());
	}

	/**
	 * consomme de l'entr�e standard pour alimenter le panier
	 * 
	 * @param basket
	 */
	private static void fillBasket(Basket basket) {
		try (Scanner scan = new Scanner(System.in)) {
			int i = 1;
			while (true) {
				basket.addProduct(readProduct(scan, i));
				System.out.println("Utiliser la touche / pour passer au produit suivant et # pour finir la saisie");
				String input = scan.next();
				if (input.matches("/")) {
					i++;
					continue;
				} else if (input.matches("#")) {
					break;
				} else {
					System.err.println("Votre saisie n'est pas correcte. HINT: les valeurs acc�pt�es sont / et #");
				}
			}
		}
	}

	/**
	 * affiche le guide de l'application
	 * 
	 */
	private static void initializeScreen() {
		System.out.println("Bienvenue dans le gestionaire du magasin!");
		System.out.println("Veuillez saisir les produits � ajouter au panier");
		System.out.println("Pour chaque produit, entrez son nom, son prix unitaire et la quantit�");
		System.out.println("C'est parti !!");
	}

	/**
	 * consomme de l'entr�e standard pour alimenter un produit
	 * 
	 * @param scan
	 * @param i
	 * @return
	 */
	private static Product readProduct(Scanner scan, int i) {
		System.out.println("Saisie de l'article num�ro " + i);
		int productType = readProductType(scan);
		String productName = readProductName(scan);
		float productPrice = readProductPrice(scan);
		int productQuantity = readProductQuantiy(scan);
		return createProduct(productType, productName, productPrice, productQuantity);
	}

	/**
	 * cr�e une instance selon le type de produit choisie auparavant
	 * 
	 * @param productType
	 * @param productName
	 * @param productPrice
	 * @param productQuantity
	 * @return
	 */
	private static Product createProduct(int productType, String productName, float productPrice, int productQuantity) {
		switch (productType) {
		case 1:
			return new Apple(productName, productPrice, productQuantity);
		case 2:
			return new Orange(productName, productPrice, productQuantity);
		case 3:
			return new Watermelon(productName, productPrice, productQuantity);
		default:
			throw new IllegalArgumentException("Valeur inattendue");
		}
	}

	/**
	 * consomme de l'entr�e standard pour savoir le type du produit
	 * 
	 * @param scan
	 * @return
	 */
	private static int readProductType(Scanner scan) {
		System.out.println("Tapez 1 pour s�lectionner Pomme, 2 pour Orange, 3 pour past�que");
		while (true) {
			try {
				int input = scan.nextInt();
				if (input >= 1 && input <= 3) {
					return input;
				} else {
					System.err.println(
							"l'élément saisie n'est pas accépté !. HINT: la valeur doit �tre entre 1 et 3");
				}
			} catch (InputMismatchException e) {
				System.err.println("l'élément saisie n'est pas accépté !");
			}
		}
	}

	/**
	 * consomme de l'entr�e standard pour savoir le prix unitaire du produit
	 * 
	 * @param scan
	 * @return
	 */
	private static float readProductPrice(Scanner scan) {
		System.out.println("Saisissez le prix unitaire du produit:");
		while (true) {
			try {
				return scan.nextFloat();
			} catch (InputMismatchException e) {
				System.err.println("l'élément saisie n'est pas accépté !");
			}
		}
	}

	/**
	 * consomme de l'entr�e standard pour savoir la quantit� du produit
	 * 
	 * @param scan
	 * @return
	 */
	private static int readProductQuantiy(Scanner scan) {
		System.out.println("Saisissez la quantit� du produit:");
		while (true) {
			try {
				return scan.nextInt();
			} catch (InputMismatchException e) {
				System.err.println("l'élément saisie n'est pas accépté !");
			}
		}
	}

	/**
	 * consomme de l'entr�e standard pour savoir le nom du produit
	 * 
	 * @param scan
	 * @return
	 */
	private static String readProductName(Scanner scan) {
		System.out.println("Saisissez le nom du produit:");
		while (true) {
			try {
				return scan.next();
			} catch (InputMismatchException e) {
				System.err.println("l'élément saisie n'est pas accépté !");
			}
		}
	}

}
