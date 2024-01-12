import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-customer',
  templateUrl: './update-customer.component.html',
  styleUrl: './update-customer.component.css'
})
export class UpdateCustomerComponent implements OnInit{

  customerId!:number;
  customer:Customer=new Customer();

  constructor(private customerService: CustomerService, private route: ActivatedRoute, private router: Router)
  {

  }

  ngOnInit(): void {
    
    this.customerId=this.route.snapshot.params['customerId'];

    this.customerService.getCustomerById(this.customerId).subscribe(data=>
      {
        this.customer=data;
      }, 
      error=>console.log(error));
  }

  onSubmit()
  {
    this.customerService.updateCustomer(this.customer, this.customerId).subscribe(data=>
      {
        this.goToCustomerList();
      }, 
      error=>console.log(error));
  }

  goToCustomerList()
  {
    this.router.navigate(['customers'])
  }
}
