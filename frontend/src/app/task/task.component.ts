import { Component } from '@angular/core';

@Component({
  selector: 'app-task',
  standalone: true,
  templateUrl: './task.html',
  styleUrl: './task.css'
})
export class TaskComponent {
  tasks: Array<string> = [];

  constructor() {
    this.tasks.push('test_name');
  }

  addTask(name: string) {
    this.tasks.push(name);
  }
}
