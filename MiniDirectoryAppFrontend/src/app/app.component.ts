import { Component, OnInit } from '@angular/core';
import { Item } from './models/item';
import { ItemService } from './services/item.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './app.component.html'
})
export class AppComponent implements OnInit {

  name = '';
  category = '';
  searchText = '';

  items: Item[] = [];

  nameError = '';

  constructor(private itemService: ItemService) { }

  ngOnInit(): void {
    this.loadItems();
  }

  addItem() {

    this.nameError = '';

    const item: Item = {
      name: this.name,
      category: this.category
    };

    this.itemService.create(item)
      .subscribe({
        next: () => {
          this.name = '';
          this.category = '';
          this.loadItems();
        },
        error: (err) => {
          if (err.status === 400 && err.error) {
            this.nameError = err.error.name;
          }
        }
      });
  }

  search() {

    this.itemService
      .search(this.searchText)
      .subscribe(data => {
        this.items = data;
      });
  }

  loadItems() {

    this.itemService
      .getAll()
      .subscribe(data => {
        this.items = data;
      });
  }
}