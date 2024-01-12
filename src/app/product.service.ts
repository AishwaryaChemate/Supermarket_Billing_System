import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from './product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseURL="http://localhost:8080/api/sbs/products";
  private getProductbyName="http://localhost:8080/api/sbs/products/getProductName";

  constructor(private httpClient:HttpClient) { }

  createProduct(product:Product):Observable<Object>
  {
    return this.httpClient.post(`${this.baseURL}`, product)
  }

  getProductList():Observable<Product[]>
  {
    return this.httpClient.get<Product[]>(`${this.baseURL}`)
  }

  getProductById(productId:number):Observable<Product>
  {
    return this.httpClient.get<Product>(`${this.baseURL}/${productId}`)
  }
  
  updateProduct(product:Product, productId:number):Observable<Object>
  {
    return this.httpClient.put(`${this.baseURL}/${productId}`, product)
  }

  deleteProduct(productId:number):Observable<Object>
  {
    return this.httpClient.delete(`${this.baseURL}/${productId}`)
  }

  getProductByName(productName:String):Observable<Product>
  {
    return this.httpClient.get<Product>(`${this.getProductbyName}/${productName}`)
  }

}
