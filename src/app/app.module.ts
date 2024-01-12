import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddCustomerComponent } from './add-customer/add-customer.component';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { UpdateCustomerComponent } from './update-customer/update-customer.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AddProductComponent } from './add-product/add-product.component';
import { ProductDetailsComponent } from './product-details/product-details.component';
import { ProductListComponent } from './product-list/product-list.component';
import { UpdateProductComponent } from './update-product/update-product.component';
import { CustomerDetailsComponent } from './customer-details/customer-details.component';

@NgModule({
  declarations: [
    AppComponent,
    AddCustomerComponent,
    CustomerDetailsComponent,
    CustomerListComponent,
    UpdateCustomerComponent,
    AddProductComponent,
    ProductDetailsComponent,
    ProductListComponent,
    UpdateProductComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
