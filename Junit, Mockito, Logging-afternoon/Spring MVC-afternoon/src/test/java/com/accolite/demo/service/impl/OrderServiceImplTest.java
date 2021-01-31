package com.accolite.demo.service.impl;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

//import com.accolite.auspringmvc.implement.add;
//import com.accolite.auspringmvc.implement.please;
import com.accolite.demo.model.Item;
import com.accolite.demo.model.Order;
import com.accolite.demo.service.OrderService;





class OrderServiceImplTest {

//	@Mock
//	com.accolite.demo.model.Order order;
//	@Mock
//    com.accolite.demo.model.Item item;
//	@InjectMocks
//    OrderServiceImpl orderService;
	Order order = new Order();
    Item item = new Item();
    OrderService orderService = new OrderServiceImpl();
	@Test
    void createOrder() {
        int id = 1;
        String res = orderService.CreateOrder(id);
        Assertions.assertEquals(res, "Order Created with order Id: "+id);
    }
	 @Test
     void addItem() {
         int id = 1; item.setItemId(1);
         item.setItemName("iphone");
         item.setQuantity(12);
         String res1 = orderService.addItem(id, item);
         
         Assertions.assertEquals(res1, "Order not created please create and add items");

         String rest = orderService.CreateOrder(id);
         
         String res2 = orderService.addItem(id, item);
         Assertions.assertEquals(res2, "Item Added successfully orderId in "+id+" with itemId: "+item.getItemId());
     }
//	 @Test
//     void deleteItem() {
//         int id = 1; item.setItemId(1); item.setItemName("iphone"); item.setQuantity(15);
//         String res1 = orderService.deleteItem(id, item.getItemId());
//
//         String rest = orderService.CreateOrder(id);
//         String res2 = orderService.deleteItem(id, item.getItemId());
//
//         rest = orderService.addItem(id, item);
//         String res3 = orderService.deleteItem(id, item.getItemId());
//
//         Assertions.assertEquals(res1, "Order id "+id+" doesn't exist");
//         Assertions.assertEquals(res2, "Item id "+item.getItemId()+" doesn't exist is order id : "+id);
//         Assertions.assertEquals(res3, "Item id "+item.getItemId()+" deleted from order id : "+id);
//     }
    

}
