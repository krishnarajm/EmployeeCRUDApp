import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

export class Employee{
  constructor(
    public id:string,
    public name:string,
    public designation:string,
    public client:string,
  ) {}
  
}

@Injectable({
  providedIn: 'root'
})
export class HttpClientService {

  constructor(private httpClient:HttpClient) { 
     }

  getEmployees() {
    return this.httpClient.get<Employee[]>('http://localhost:8086/rest/employees');
  }

  public deleteEmployee(employee) {
    return this.httpClient.delete<Employee>("http://localhost:8086/rest/employees" + "/"+ employee.id);
  }

  public createEmployee(employee) {
    return this.httpClient.post<Employee>("http://localhost:8086/rest/employees", employee);
  }
 
}
