import { Component, signal } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-task',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './task.html',
  styleUrls: ['./task.css'],
})
export class TaskComponent {
  syncInProgress = signal(false);

  constructor(private http: HttpClient) {}

  startInventorySync() {
    this.syncInProgress.set(true);
    this.http.post('/api/inventory/sync', {}).subscribe({
      next: () => this.syncInProgress.set(false),
      error: () => this.syncInProgress.set(false),
    });
  }
}
