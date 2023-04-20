import java.util.*;
import java.io.*;

class Shopping {
    private final ArrayList<String> categories = new ArrayList<String>();
    private final ArrayList<ArrayList<String>> products = new ArrayList<ArrayList<String>>();
    public Shopping () { }

    public void addProduct(String category, String product) {
        int index = this.categories.indexOf(category);

        /*if category does not exist, create new one*/
        if (index == -1) {
            addCategory(category);
            index = this.categories.indexOf(category);
        }

        this.products.get(index).add(product);
    }

    public void deleteProduct(String category, String product) {
        if (categoryExists(category)) {
            int index = this.categories.indexOf(category);
            this.products.get(index).remove(product);
        }
    }

    public void clearTheShoppingList() {
        this.products.clear();
        this.categories.clear();
    }

    public void addCategory(String category) {
        if (!categoryExists(category)) {
            this.categories.add(category);
            this.products.add(new ArrayList<String>());
        }
    }

    public int getCategoriesSize() {
        return this.categories.size();
    }

    public int getProductsSize(String category) {
        if (categoryExists(category)) {
            int index = this.categories.indexOf(category);
            return this.products.get(index).size();
        }

        return -1;
    }

    public boolean categoryExists(String category) {
        return this.categories.contains(category);
    }

    public void printAllProductsFrom(String category) {
        if (categoryExists(category)) {
            int index = this.categories.indexOf(category);
            System.out.format("%s: ", category);

            for (int i = 0; i < this.products.get(index).size(); i++) {
                if (i != this.products.get(index).size() - 1) {
                    System.out.format("%s; ", this.products.get(index).get(i));
                } else {
                    System.out.format("%s\n", this.products.get(index).get(i));
                }
            }
        }
    }

    public void printAllCategories() {
        for (int i = 0; i < this.categories.size(); i++) {
            if (i != this.categories.size() - 1) {
                System.out.format("%s, ", this.categories.get(i));
            } else {
                System.out.format("%s\n", this.categories.get(i));
            }
        }
    }

    public void printAllProducts() {
        for (String category : this.categories) {
            this.printAllProductsFrom(category);
        }
    }

    public String saveTheShoppingList() {
        String list = "";
        for (int i = 0; i < this.categories.size(); i++) {
            list = list.concat(this.categories.get(i) + ": ");

            for (int j = 0; j < this.products.get(i).size(); j++) {
                if (j != this.products.get(i).size() - 1) {
                    list = list.concat(this.products.get(i).get(j) + "; ");
                } else {
                    list = list.concat(this.products.get(i).get(j));
                }
            }

            if (i != this.categories.size() - 1) {
                list = list.concat("\n");
            }
        }

        return list;
    }
}

public class Main {
    public static void main(String[] args) {
        Shopping shop = new Shopping();

        try {
            Scanner file = new Scanner(new File("zakupy.txt"));
            Scanner sc = new Scanner(System.in);

            String line = "";
            int choice = 0;
            String category = "", product = "";

            while (file.hasNextLine()) {
                line = file.nextLine();

                /*splitting the line in two parts - category and products*/
                String[] result = line.split(":");

                /*splitting products*/
                String[] products = result[1].split(";");

                /*adding categories*/
                for (String prod : products) {
                    prod = prod.trim();
                    shop.addProduct(result[0], prod);
                }
            }

            System.out.println("1. Add a product to the shopping list");
            System.out.println("2. Display all products from the shopping list");
            System.out.println("3. Display all products from a category");
            System.out.println("4. Delete all the products from the shopping list");
            System.out.println("5. Delete a the products from a category");
            System.out.println("6. Save the shopping list");

            do {
                System.out.println("Choose an option:");

                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1 -> {
                        shop.printAllCategories();
                        System.out.println("Enter the exact name of the category:");
                        category = sc.next();
                        sc.nextLine();
                        if (!shop.categoryExists(category)) {
                            System.out.println("Category does not exist");
                        } else {
                            shop.printAllProductsFrom(category);
                            System.out.println("Enter the product name to add to the category:");
                            product = sc.next();
                            sc.nextLine();

                            shop.addProduct(category, product);
                            System.out.println("Product added to the list successfully");
                        }
                    }
                    case 2 -> {
                        if (shop.getCategoriesSize() == 0) {
                            System.out.println("The list is empty");
                        } else {
                            shop.printAllProducts();
                        }
                    }
                    case 3 -> {
                        shop.printAllCategories();
                        System.out.println("Enter the exact name of the category:");
                        category = sc.next();
                        sc.nextLine();

                        if (shop.getProductsSize(category) == -1) {
                            System.out.println("Category does not exist");
                        } else if (shop.getProductsSize(category) == 0) {
                            System.out.println("The category is empty");
                        } else {
                            shop.printAllProductsFrom(category);
                        }
                    }
                    case 4 -> {
                        shop.clearTheShoppingList();
                        System.out.println("All the products deleted successfully");
                    }
                    case 5 -> {
                        shop.printAllCategories();
                        System.out.println("Enter the exact name of the category:");
                        category = sc.next();
                        sc.nextLine();

                        if (shop.getProductsSize(category) == -1) {
                            System.out.println("Category does not exist");
                        } else if (shop.getProductsSize(category) == 0) {
                            System.out.println("Category is empty");
                        } else {
                            shop.printAllProductsFrom(category);
                            System.out.println("Enter the product name to delete it from the category:");
                            product = sc.next();
                            sc.nextLine();

                            shop.deleteProduct(category, product);
                            System.out.println("Product deleted from the list successfully");
                        }
                    }
                    case 6 -> {
                        String list = shop.saveTheShoppingList();
                        FileWriter fw = new FileWriter(new File("zakupy.txt"), false);
                        fw.write(list);
                        fw.close();
                    }
                    default -> System.out.println("Incorrect input data");
                }
            } while (choice != 6);

            sc.close();
            file.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Incorrect input");
        }
    }
}