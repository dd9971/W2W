import { Component, signal } from '@angular/core';

@Component({
  selector: 'app-task',
  standalone: true,
  imports: [],
  templateUrl: './task.html',
  styleUrl: './task.css'
})
export class TaskComponent {
  syncInProgress = signal(false);

  startInventorySync() {
    console.log('Inventory synchronization started');
    this.syncInProgress.set(true);

    setTimeout(() => {
      this.syncInProgress.set(false);
      console.log('Inventory synchronization finished');
    }, 3000);
  }
}
