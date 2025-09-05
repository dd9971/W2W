import { Component } from '@angular/core';
import { TestBed } from '@angular/core/testing';
import { App } from './app';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-task',
  standalone: true,
  template: ''
})
class TaskStub {}

describe('App', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [App],
    })
      .overrideComponent(App, {
        set: {
          imports: [TaskStub, RouterOutlet],
        },
      })
      .compileComponents();
  });

  it('should create the app', () => {
    const fixture = TestBed.createComponent(App);
    expect(fixture.componentInstance).toBeTruthy();
  });
});
