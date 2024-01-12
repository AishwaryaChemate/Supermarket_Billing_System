import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-customer',
  templateUrl: './add-customer.component.html',
  styleUrl: './add-customer.component.css'
})
export class AddCustomerComponent implements OnInit {

  customer: Customer=new Customer();

  constructor(private customerService:CustomerService, private router:Router){}

  ngOnInit(): void {
  }

  saveCustomer()
  {
    this.customerService.createCustomer(this.customer).subscribe(data=>
      {
        console.log(data);
        this.goToCustomerList();
      },
      error => console.log(error));
  }

  onSubmit()
  {
    console.log(this.customer);
    this.saveCustomer();
      
  }

  goToCustomerList()
  {
    this.router.navigate([`/customers`]);
  }
}
