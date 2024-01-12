import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-customer-details',
  templateUrl: './customer-details.component.html',
  styleUrl: './customer-details.component.css'
})
export class CustomerDetailsComponent implements OnInit{

  customerId!:number;
  customer!:Customer;

  constructor(private customerService: CustomerService, private route:ActivatedRoute, private router:Router)
  {

  }

  ngOnInit(): void 
  {
    this.customerId=this.route.snapshot.params['customerId'];

    this.customer=new Customer();  

    this.customerService.getCustomerById(this.customerId).subscribe(data=>
      {
        this.customer=data;
      }
    );
  }

  list()
  {
    this.router.navigate([`customers`]);
  }

}
