package food.main;

import food.model.FoodOrder;
import food.model.RegularOrder;
import food.model.PremiumOrder;
import food.utility.OrderUtility;

public class Main {

    public static void main(String[] args) {

        FoodOrder[] orders = new FoodOrder[6];

        orders[0] = new RegularOrder(101, "Rahul", 1000);
        orders[1] = new PremiumOrder(102, "Priya", 2000);
        orders[2] = new RegularOrder(103, "Aman", 1500);
        orders[3] = new PremiumOrder(104, "Sneha", 2500);
        orders[4] = new RegularOrder(105, "Rohan", 800);
        orders[5] = new PremiumOrder(106, "Ananya", 3000);

        for (FoodOrder order : orders) {

            if (!OrderUtility.validateAmount(order.getAmount())) {
                System.out.println("Invalid amount for Order ID: "
                        + order.getOrderId());
                continue;
            }

            if (!OrderUtility.validateCustomerName(order.getCustomerName())) {
                System.out.println("Invalid customer name for Order ID: "
                        + order.getOrderId());
                continue;
            }

            OrderUtility.generateOrderSummary(order);
        }

        FoodOrder.displayTotalOrders();
    }
}