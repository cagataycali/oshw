/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg14253019;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo 
{ 
	public static void main(String args[]) throws InterruptedException 
	{ 
		// creating a Semaphore object 
		// with number of permits 1 
		Semaphore sem = new Semaphore(2); 
		
		// creating two threads with name A and B 
		// Note that thread A will increment the count 
		// and thread B will decrement the count 
		Demo mt1 = new Demo(sem, "A"); 
		Demo mt2 = new Demo(sem, "B"); 
		
		// stating threads A and B 
		mt1.start(); 
		mt2.start(); 
		
		// waiting for threads A and B 
		mt1.join(); 
		mt2.join(); 
		
		// count will always remain 0 after 
		// both threads will complete their execution 
		System.out.println("count: " + Shared.count); 
	} 
} 
