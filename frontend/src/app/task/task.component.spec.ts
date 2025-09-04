import { ComponentFixture, TestBed } from '@angular/core/testing';
import { TaskComponent } from './task.component';

describe('TaskComponent', () => {
  let fixture: ComponentFixture<TaskComponent>;
  let component: TaskComponent;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TaskComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(TaskComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
