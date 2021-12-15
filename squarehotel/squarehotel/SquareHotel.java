package squarehotel;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

import dao.CartDao;
import dao.CartDaoCollectionImpl;
import dao.CartEmptyException;
import dao.MenuItemDao;
import dao.MenuItemDaoCollectionImpl;
import model.MenuItem;

public class SquareHotel {
	private static boolean isAdmin;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		logo();
		div();
		
		isAdmin = pickMode();
		
		if (isAdmin)
			adminMode();
		else
			clientMode();
	}
	
	
	
	private static void adminMode() {
		MenuItemDao menu = new MenuItemDaoCollectionImpl();
		System.out.println("Admin mode");
		div();
		adminOptions();
		
		String input, input2;
		
		do {
			div();
			Scanner sc = new Scanner(System.in);
			input = sc.nextLine();
			
			switch (input) {
				case "1":
					for (MenuItem item: menu.getMenuItemListAdmin()) {
						syso(item.toString());
					}
					break;
				case "2":
					for (MenuItem item: menu.getMenuItemListCostumer()) {
						if(item.isActive())
							syso(item.toString());
					}
					break;
				case "3":
					Scanner scan = new Scanner(System.in);
					input2 = scan.nextLine();
					try {
						menu.addMenuItem(new MenuItem(input2));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case "4":
					Scanner scan2 = new Scanner(System.in);
					input2 = scan2.nextLine();
					try {
						menu.modifyMenuItem(new MenuItem(input2));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case "5":
					Scanner scan3 = new Scanner(System.in);
					input2 = scan3.nextLine();
					menu.deleteItem(Long.parseLong(input2));
					break;
			}
			
		} while(Integer.parseInt(input) != 0);
		
		syso("Bye!");
	}
	
	private static void clientMode() {
		MenuItemDao menu = new MenuItemDaoCollectionImpl();
		CartDao cart = new CartDaoCollectionImpl();
		
		System.out.println("Client mode");
		div();
		clientOptions();
		div();
		
		String input;
		
		do {
			try {
				clientHeader(cart.getAllCartItems(1).size(), cart.getCart(1).getTotal());
			} catch (CartEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			div();
			Scanner sc = new Scanner(System.in);
			input = sc.nextLine();
			
			switch (input) {
				case "1":
					for (MenuItem item: menu.getMenuItemListCostumer()) {
						syso(item.toString());
					}
					div();
					break;
				case "2":
					Scanner scan = new Scanner(System.in);
					input = scan.nextLine();
					cart.addCartItem(1, Long.parseLong(input));
					break;
			}
			
		} while(Integer.parseInt(input) != 0);
		
		syso("Bye!");
	}
	
	private static boolean pickMode() {
		System.out.println("type    |   action");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("1       |   Admin mode");
		System.out.println("2       |   Client mode");
		System.out.println("----------------------------------------------------------------------------");
		Scanner sc = new Scanner(System.in);
		int op = sc.nextInt();
		if (op == 1) {
			return true;
		}
		return false;
	}
	
	private static void logo() {
		System.out.println("  __        __   _ _                            _          ");
		System.out.println(" \\ \\      / /__| | | ___ ___  _ __ ___   ___  | |_ ___     ");
		System.out.println("  \\ \\ /\\ / / _ \\ | |/ __/ _ \\| '_ ` _ \\ / _ \\ | __/ _ \\    ");
		System.out.println("   \\ V  V /  __/ | | (_| (_) | | | | | |  __/ | || (_) |   ");
		System.out.println("  ____/\\_/ \\___|_|_|\\___\\___/|_| |_| __|\\___|  \\__\\___/  _ ");
		System.out.println(" / ___|  __ _ _   _  __ _ _ __ ___  | | | | ___ | |_ ___| |");
		System.out.println(" \\___ \\ / _` | | | |/ _` | '__/ _ \\ | |_| |/ _ \\| __/ _ \\ |");
		System.out.println("  ___) | (_| | |_| | (_| | | |  __/ |  _  | (_) | ||  __/ |");
		System.out.println(" |____/ \\__, |\\__,_|\\__,_|_|  \\___| |_| |_|\\___/ \\__\\___|_|");
		System.out.println("           |_|                                             ");
		System.out.println("The best services                                       ★★");
	}
	
	private static void div() {
		System.out.println("----------------------------------------------------------------------------");
	}
	
	private static void mode() {
		System.out.println(
				isAdmin ? "Admin" : "Client" + " mode"
		);
	}
	
	private static void clientHeader(int numberItems, double price) {
		System.out.printf("                                           cart: (%s)  $ %s\n", numberItems, price);
	}
	
	private static void clientOptions() {
		System.out.println("0       |   Exit");
		System.out.println("1       |   list all items");
		System.out.println("2       |   add item");
		System.out.println("3       |   delete item");
		System.out.println("4       |   finish cart");
	}
	
	private static void adminOptions() {
		System.out.println("type    |   action");
		div();
		System.out.println("0       |   exit");
		System.out.println("1       |   list all items");
		System.out.println("2       |   list all active item");
		System.out.println("3       |   insert new item");
		System.out.println("4       |   edit item");
		System.out.println("5       |   delete item");
	}
	
	private static void syso(String arg0) {
		System.out.println(arg0);
	}

}
