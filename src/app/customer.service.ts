import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from './customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private baseURL="http://localhost:8080/api/sbs/customers";
  private getByName="http://localhost:8080/api/sbs/customers/byFirstname";
  private getByMobileno="http://localhost:8080/api/sbs/customers/bymobileno";

  constructor(private httpClient:HttpClient) { }

  createCustomer(customer:Customer):Observable<Object>{

    return this.httpClient.post(`${this.baseURL}`,customer);
  }
  getCustomerList():Observable<Customer[]>{

    return this.httpClient.get<Customer[]>(`${this.baseURL}`);
  }

  getCustomerById(customerId:number):Observable<Customer>{

    return this.httpClient.get<Customer>(`${this.baseURL}/${customerId}`);
  }

  deleteCustomer(customerId:number):Observable<Object>{

    return this.httpClient.delete(`${this.baseURL}/${customerId}`);
  }

  updateCustomer(customer:Customer, customerId:number):Observable<Object>{

    return this.httpClient.put(`${this.baseURL}/${customerId}`,customer);
  }

  getCustomerByName(firstName:String):Observable<Customer>{

    return this.httpClient.get<Customer>(`${this.getByName}/${firstName}`)
  }

  getCustomerByMobileno(mobileno:number):Observable<Customer>{

    return this.httpClient.get<Customer>(`${this.getByMobileno}/${mobileno}`);
  }
}
