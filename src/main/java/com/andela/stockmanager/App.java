package com.andela.stockmanager;

/**
 * The exercise;
 * 
 *  Write a command line application to manage products
 *  Each product is assigned to a warehouse. A product can be added or deleted.
 *  All products can be listed, when listing products we should display the warehouse name.
 *  The user must be authenticated before using the application.
 *  Entities should be persisted using hibernate.
 *  Use as much as possible Java design, encapsulation inheritance, interfaces....
 *  Use at least one new library you have not used before.
 */
public class App 
{
	   public static void main( String[] args )
    {
        new Bootstrap().init();
    }
    
  
    
}
