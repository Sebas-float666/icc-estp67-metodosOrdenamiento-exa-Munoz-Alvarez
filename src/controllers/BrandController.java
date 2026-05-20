package controllers;

import models.Brand;

public class BrandController {
  public Brand[] sortBubbleDesc(Brand[] brands) {
    for (int i = 0; i < brands.length - 1; i++) {
      boolean swapped = false;
      for (int j = 0; j < brands.length - 1 - i; j++) {
        if (brands[j].getTotalValidYears() < brands[j + 1].getTotalValidYears()) {
          Brand temp = brands[j];
          brands[j] = brands[j + 1];
          brands[j + 1] = temp;

           swapped = true;
        }

      }
      if(!swapped){
        break;
      }
    }
    return brands;

  }

  public Brand binarySearchByValidYears(Brand[] brands,int validYears,boolean isAscending){
    int left =0;
    int rigth= brands.length-1;

    while(left <= rigth){
      int mid=(rigth +rigth)/2;
      int current =brands[mid].getTotalValidYears();

      if (current == validYears){
        return brands[mid];
      }
      if (isAscending){
        if (validYears<current){
          rigth =mid - 1; 
        }else{
          left=mid+1;
        }
      }else{
        if (validYears>current){
          rigth =mid - 1; 
        }else{
          left=mid+1;
        }
      }
    }
    return null;
    
  }
}
