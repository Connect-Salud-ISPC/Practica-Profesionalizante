import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  private products: any[] = [
    { name: 'Basico', price: 1000, image: '../assts/img/Basico.png'},
    { name: 'Estandar', price: 2000, image: '../assets/img/Estandar.png' },
    { name: 'Plus', price: 3500, image: '../assets/img/Plus.png' },
    { name: 'Premiun', price: 5000, image: '../assets/img/Premiun.png' },
    { name: 'Corporativo', price: 8500, image: '../assets/img/Corporativo.png' },
  ];
  

  constructor() { }

  getProducts(): any[] {
    return this.products;
  }
  removeProduct(product: any) {
    const index = this.products.indexOf(product);
    if (index !== -1) {
      this.products.splice(index, 1);
    }
    
  }

}


