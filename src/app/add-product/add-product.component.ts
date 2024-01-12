import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ProductService } from '../product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrl: './add-product.component.css'
})
export class AddProductComponent implements OnInit{

  product: Product=new Product();

  constructor(private productService:ProductService, private router:Router){}

  ngOnInit(): void {
  }

  saveProduct()
  {
    this.productService.createProduct(this.product).subscribe(data=>
      {
        console.log(data);
        this.goToProductList();
      },
      error => console.log(error)
      );
  }

  goToProductList()
  {
    this.router.navigate([`/products`]);
  }

  onSubmit()
  {
    this.saveProduct();
  }
}
