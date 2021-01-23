package com.accolite.demo.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.demo.model.Item;
import com.accolite.demo.service.OrderService;

@RestController
@RequestMapping("/order/")
public class OrderController {
	
	@Autowired
	OrderService os;
	
	@PostMapping("/create/{orderid}")
	public ResponseEntity<String> createOrder(@PathVariable("orderid") Integer orderId)
	{
		String res=os.CreateOrder(orderId);
		return ResponseEntity.ok(res);
	}
	@PostMapping("/item/add/{orderid}")
	public ResponseEntity<String> addItem(@PathVariable("orderid") Integer orderId,@RequestBody Item item)
	{
		String res=os.addItem(orderId, item);
		return ResponseEntity.ok(res);
	}
	@GetMapping("item/get/{orderid}")
	public ResponseEntity<Map<Integer, Item>> getItems(@PathVariable("orderid") Integer orderId)
	{
		Map<Integer, Item> res=os.getItem(orderId);
		return ResponseEntity.ok(res);
	}
	@DeleteMapping("/item/delete/{orderid}/{itemId}")
	public ResponseEntity<String> deleteItem(@PathVariable("orderid") Integer orderId,@PathVariable("itemId") Integer itemId)
	{
//		Map<Integer, Item> res=os.getItem(orderId);
		String res = os.deleteItem(orderId, itemId);
        return ResponseEntity.ok(res);
	}
	@PutMapping("/item/update/{orderid}")
	public ResponseEntity<String> updateItem(@PathVariable("orderid") Integer orderId,@RequestBody Item item)
	{
//		Map<Integer, Item> res=os.getItem(orderId);
		String res = os.updateItem(orderId,item);
        return ResponseEntity.ok(res);
	}
}
