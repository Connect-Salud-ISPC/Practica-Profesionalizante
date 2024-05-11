import { Component, Inject, OnInit } from '@angular/core';
import { CartService } from '../services/cart.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-carrito',
  templateUrl: './carrito.component.html',
  styleUrls: ['./carrito.component.css']
})
export class CarritoComponent implements OnInit {

  products: any[];

  constructor(private cartService: CartService, private httpclient: HttpClient) { }

  ngOnInit() {
    this.products = this.cartService.getProducts();
  }
  
  removeProduct(product: any) {
    this.cartService.removeProduct(product);
  }
  
  iniciarCompra() {
    const createPaymentUrl = 'https://apisconnect-bmm2.onrender.com/createpayment/'; // La URL de tu API en Django

    this.httpclient.post<any>(createPaymentUrl, {}).subscribe(response => {
      const paymentUrl = response.payment_url;
      window.open(paymentUrl, '_blank'); // Abrir en una nueva pestaña
      // O utilizar el enrutador de Angular
      // this.router.navigateByUrl(paymentUrl);
    });
  }
}
    


