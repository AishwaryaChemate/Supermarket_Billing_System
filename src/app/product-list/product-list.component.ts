import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ProductService } from '../product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrl: './product-list.component.css'
})
export class ProductListComponent implements OnInit{

  products!:Product[];

  constructor(private productService:ProductService, private router: Router)
  {

  }

  ngOnInit(): void 
  {
    this.getProducts();
  }

  private getProducts()
  {
    this.productService.getProductList().subscribe(data=>
      {
        this.products=data;
      }
    );
  }

  productDetails(productId:number)
  {
    this.router.navigate(['product-details', productId])
  }

  updateProduct(productId:number)
  {
    this.router.navigate(['update-product', productId]);
  }

  deleteProduct(productId:number)
  {
    this.productService.deleteProduct(productId).subscribe(data=>
      {
        console.log(data);
        this.getProducts();
      }
    );
    
  }
}
