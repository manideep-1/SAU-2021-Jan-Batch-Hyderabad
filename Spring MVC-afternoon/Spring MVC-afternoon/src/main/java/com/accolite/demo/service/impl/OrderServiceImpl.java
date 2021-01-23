package com.accolite.demo.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.accolite.demo.model.Item;
import com.accolite.demo.model.Order;
import com.accolite.demo.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	Map<Integer,Order> hm=new HashMap<Integer,Order>();
	
	
	public boolean isOrderPresent(Integer orderId) {
		if(hm.containsKey(orderId))
			return true;
		return false;
	}
	@Override
	public String CreateOrder(Integer orderId) {
		Order o=new Order();
		o.setOrderId(orderId);
		hm.put(orderId, o);
		return "Order Created with order Id: "+o.getOrderId();
		
	}

	@Override
	public String addItem(Integer orderId, Item item) {
//		System.out.println(orderId+" "+hm.containsKey(orderId));
//		for(int i=0;i<hm.size();i++) {
//			System.out.println(hm.get(orderId));
//		}
		if(isOrderPresent(orderId))
		{
			
			hm.get(orderId).getitems().put(item.getItemId(), item);
			System.out.println(hm.get(orderId));
			return "Item Added successfully orderId in "+orderId+" with itemId: "+item.getItemId();
		}
		return "Order not created please create and add items";
	}
	@Override
	public Map<Integer, Item> getItem(Integer orderId) {
		return hm.get(orderId).getitems();
//		return null;
	}
	public boolean isItemPresent(Integer orderId,Integer itemId) {
		if(hm.get(orderId).getitems().containsKey(itemId))
			return true;
		return false;
	}
	@Override
	public String deleteItem(Integer orderId, Integer itemId) {
		// TODO Auto-generated method stub
		if(!isOrderPresent(orderId))	return "order id not present";
		else if(!isItemPresent(orderId,itemId)) return "order present but item not present";
		hm.get(orderId).getitems().remove(itemId);
		return "deleted successfully";
	}
	@Override
	public String updateItem(Integer orderId,Item item) {
		// TODO Auto-generated method stub
		Integer itemId=item.getItemId();
		if(!isOrderPresent(orderId)) {
			return "Order not present with order id:"+" "+orderId;			
		}
		else if(!isItemPresent(orderId,itemId))
		{
			return "Order id present but Item id not present";
		}
		hm.get(orderId).getitems().put(itemId,item);
//		return null;
		return "updated item successfully";
	}

}
