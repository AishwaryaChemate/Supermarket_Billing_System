import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ProductService } from '../product.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrl: './product-details.component.css'
})
export class ProductDetailsComponent implements OnInit{

  productId!:number;
  product!:Product;

  constructor(private productService: ProductService, private route:ActivatedRoute, private router:Router)
  {

  }

  ngOnInit(): void 
  {
    this.productId=this.route.snapshot.params['productId'];

    this.product=new Product();  

    this.productService.getProductById(this.productId).subscribe(data=>
      {
        this.product=data;
      }
    );
  }

  list()
  {
    this.router.navigate([`products`]);
  }
}
