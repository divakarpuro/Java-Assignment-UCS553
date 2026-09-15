import java.util.ArrayList;
import java.util.Scanner;



class ShoppingException extends Exception {

    ShoppingException(String message) {
        super(message);
    }
}



class ProductNotFoundException extends ShoppingException {

    ProductNotFoundException(String message) {
        super(message);
    }
}



class ProductAlreadyInCartException extends ShoppingException {

    ProductAlreadyInCartException(String message) {
        super(message);
    }
}



class InvalidQuantityException extends ShoppingException {

    InvalidQuantityException(String message) {
        super(message);
    }
}



class CartEmptyException extends ShoppingException {

    CartEmptyException(String message) {
        super(message);
    }
}


class PaymentFailedException extends ShoppingException {

    PaymentFailedException(String message) {
        super(message);
    }
}


class Product {

    int id;
    String name;
    double price;

    Product(int id, String name, double price) {

        this.id = id;
        this.name = name;
        this.price = price;
    }

    void displayProduct() {

        System.out.println(
                id + " - " + name + " - Rs. " + price
        );
    }
}



public class ShoppingCartApplication {

    static ArrayList<Product> cart = new ArrayList<>();


    static Product[] products = {

            new Product(1, "Laptop", 50000),

            new Product(2, "Mobile", 20000),

            new Product(3, "Headphones", 2000),

            new Product(4, "Keyboard", 1500)
    };



    static Product searchProduct(int productId)
            throws ProductNotFoundException {

        for (Product product : products) {

            if (product.id == productId) {

                return product;
            }
        }

        throw new ProductNotFoundException(
                "Product with ID " + productId + " not found"
        );
    }

    static void addToCart(int productId, int quantity)
            throws ProductNotFoundException,
                   InvalidQuantityException,
                   ProductAlreadyInCartException {

        if (quantity <= 0) {

            throw new InvalidQuantityException(
                    "Quantity must be greater than zero"
            );
        }


        Product product = searchProduct(productId);


        for (Product cartProduct : cart) {

            if (cartProduct.id == productId) {

                throw new ProductAlreadyInCartException(
                        "Product is already present in cart"
                );
            }
        }


        for (int i = 0; i < quantity; i++) {

            cart.add(product);
        }


        System.out.println(
                product.name + " added to cart successfully"
        );
    }


    static void removeFromCart(int productId)
            throws ProductNotFoundException {

        Product productToRemove = null;


        for (Product product : cart) {

            if (product.id == productId) {

                productToRemove = product;

                break;
            }
        }


        if (productToRemove == null) {

            throw new ProductNotFoundException(
                    "Product is not present in cart"
            );
        }


        cart.remove(productToRemove);


        System.out.println(
                productToRemove.name + " removed from cart"
        );
    }



    static void displayCart() {

        if (cart.isEmpty()) {

            System.out.println("Cart is empty");

            return;
        }


        System.out.println("\n----- Your Cart -----");


        for (Product product : cart) {

            product.displayProduct();
        }


        System.out.println(
                "Total amount: Rs. " + calculateTotal()
        );
    }



    static double calculateTotal() {

        double total = 0;


        for (Product product : cart) {

            total = total + product.price;
        }


        return total;
    }



    static void makePayment(double amount)
            throws CartEmptyException,
                   PaymentFailedException {

        if (cart.isEmpty()) {

            throw new CartEmptyException(
                    "Cannot make payment because cart is empty"
            );
        }


        double total = calculateTotal();


        if (amount < total) {

            throw new PaymentFailedException(
                    "Payment failed: insufficient amount"
            );
        }


        System.out.println(
                "Payment successful"
        );

        System.out.println(
                "Amount paid: Rs. " + amount
        );

        System.out.println(
                "Change returned: Rs. " + (amount - total)
        );


        cart.clear();
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        try {

            System.out.println("----- Available Products -----");


            for (Product product : products) {

                product.displayProduct();
            }


            System.out.print("\nEnter product ID to add: ");

            int productId = Integer.parseInt(
                    sc.nextLine()
            );


            System.out.print("Enter quantity: ");

            int quantity = Integer.parseInt(
                    sc.nextLine()
            );


            addToCart(productId, quantity);


            displayCart();


            System.out.print(
                    "\nEnter product ID to remove: "
            );

            int removeId = Integer.parseInt(
                    sc.nextLine()
            );


            removeFromCart(removeId);


            displayCart();


            System.out.print(
                    "\nEnter payment amount: Rs. "
            );

            double payment = Double.parseDouble(
                    sc.nextLine()
            );


            makePayment(payment);
        }


        catch (NumberFormatException e) {

            System.out.println(
                    "Error: Please enter valid numeric input"
            );
        }


        catch (ProductNotFoundException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }


        catch (InvalidQuantityException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }


        catch (ProductAlreadyInCartException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }


        catch (CartEmptyException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }


        catch (PaymentFailedException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }


        finally {

            sc.close();

            System.out.println(
                    "Shopping cart application completed"
            );
        }
    }
}