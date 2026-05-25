import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Item } from '../models/item';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  private apiUrl = 'https://mini-item-directory.onrender.com';

  constructor(private http: HttpClient) { }

  create(item: Item): Observable<Item> {
    return this.http.post<Item>(this.apiUrl, item);
  }

  getAll(): Observable<Item[]> {
    return this.http.get<Item[]>(this.apiUrl);
  }

  search(q: string): Observable<Item[]> {
    return this.http.get<Item[]>(
      `${this.apiUrl}?q=${q}`
    );
  }
}