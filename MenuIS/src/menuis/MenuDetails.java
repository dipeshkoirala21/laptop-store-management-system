/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menuis;

import java.util.ArrayList;

/**
 *
 * @author Nilej, Dipesh, Niku, Ganesh
 */
public class MenuDetails {
    private String serialNo;
    private String modelName;
    private String category;
    private String brand;
    private int vat;
    private int price;
    private boolean status;
    
    
    public MenuDetails(String serial, String model, String cat, String brnd, int vatt, int prc, boolean stat)
    {/*Constructor which  initializes the attributes of class*/
        serialNo = serial;
        modelName = model;
        category = cat;
        brand = brnd;
        vat = vatt;
        price = prc;
        status = stat;
    }
    public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getVat() {
		return vat;
	}
	public void setVat(int vat) {
		this.vat = vat;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
       
    public static void sort(ArrayList<MenuDetails> list){
        /*method to arrange values in array list according to price */
        int max,i,j;
        
        MenuDetails temp;
        for(i=0; i < list.size()-1;i++){
            max = i;
            for(j=i+1;j<list.size();j++){
                 if(list.get(j).getPrice()<(list.get(max).getPrice()))
                {
                    max=j;
                }
            }
            temp = list.get(i);
            list.set(i, list.get(max));
            list.set(max, temp);
           
        }
    }
   
   
   public static int binarySearch(ArrayList<MenuDetails> list, int low, int high, int keyprice) {
       /*method to search the price entered by user*/
		if (low <= high) {
                    int mid = (low + high) / 2;
                        int midval = list.get(mid).getPrice();
                        
			if (midval == keyprice) {
                            return mid;
			} else if (midval > keyprice) {
                            return binarySearch(list, low, mid - 1, keyprice);
                        }
                        else{
                            return binarySearch(list, mid + 1, high, keyprice);
                        }
                }
                else{	
                    return -1;
                }
		
	} 
}
