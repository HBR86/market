package com.adneom.test.supermarket;

import java.util.Scanner;

import com.adneom.test.supermarket.commons.Basket;
import com.adneom.test.supermarket.commons.Product;
import com.adneom.test.supermarket.input.DataReader;
import com.adneom.test.supermarket.products.Apple;
import com.adneom.test.supermarket.products.Orange;
import com.adneom.test.supermarket.products.Watermelon;

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
		System.out.println("Montant à payer: " + basket.calculateTotalPrice());
	}

	/**
	 * consomme de l'entrée standard pour alimenter le panier
	 * 
	 * @param basket
	 */
	private static void fillBasket(Basket basket) {
		try (Scanner scan = new Scanner(System.in)) {
			int i = 1;
			while (true) {
				basket.addProduct(readProduct(scan, i));
				String input = DataReader.readNextAction(scan);
				if (input.matches("/")) {
					i++;
					continue;
				} else if (input.matches("#")) {
					return;
				} else {
					System.err.println("Votre saisie n'est pas correcte. HINT: les valeurs accéptées sont / et #");
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
		System.out.println("Veuillez saisir les produits à ajouter au panier");
		System.out.println("Pour chaque produit, entrez son nom, son prix unitaire et la quantité");
		System.out.println("C'est parti !!");
	}

	/**
	 * consomme de l'entrée standard pour alimenter un produit
	 * 
	 * @param scan
	 * @param i
	 * @return
	 */
	private static Product readProduct(Scanner scan, int i) {
		System.out.println("Saisie de l'article numéro " + i);
		int productType = DataReader.readProductType(scan);
		String productName = DataReader.readProductName(scan);
		float productPrice = DataReader.readProductPrice(scan);
		int productQuantity = DataReader.readProductQuantiy(scan);
		return createProduct(productType, productName, productPrice, productQuantity);
	}

	/**
	 * crée une instance selon le type de produit choisie auparavant
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

}
