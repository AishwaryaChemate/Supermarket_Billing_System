import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddCustomerComponent } from './add-customer/add-customer.component';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { CustomerDetailsComponent } from './customer-details/customer-details.component';
import { UpdateCustomerComponent } from './update-customer/update-customer.component';
import { AddProductComponent } from './add-product/add-product.component';
import { ProductListComponent } from './product-list/product-list.component';
import { ProductDetailsComponent } from './product-details/product-details.component';
import { UpdateProductComponent } from './update-product/update-product.component';

const routes: Routes = [
  {
    path:'add-customer', component:AddCustomerComponent
  },
  {
    path:'customers', component:CustomerListComponent
  },
  {
    path:'customer-details/:customerId', component:CustomerDetailsComponent
  },
  {
    path:'update-customer/:customerId', component:UpdateCustomerComponent
  },
  {
    path:'', redirectTo:'customers', pathMatch:'full'
  },

  {
    path:'add-product', component:AddProductComponent
  },
  {
    path:'products', component:ProductListComponent
  },
  {
    path:'product-details/:productId', component:ProductDetailsComponent
  },
  {
    path:'update-product/:productId', component:UpdateProductComponent
  },
  {
    path:'', redirectTo:'products', pathMatch:'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
