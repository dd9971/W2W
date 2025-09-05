import { ComponentFixture, TestBed } from '@angular/core/testing';
import { TaskComponent } from './task.component';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

describe('TaskComponent', () => {
  let fixture: ComponentFixture<TaskComponent>;
  let component: TaskComponent;
  let httpMock: HttpTestingController;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TaskComponent, HttpClientTestingModule],
    }).compileComponents();

    fixture = TestBed.createComponent(TaskComponent);
    component = fixture.componentInstance;
    httpMock = TestBed.inject(HttpTestingController);
    fixture.detectChanges();
  });

  afterEach(() => {
    httpMock.verify(); // upewnia się, że nie ma otwartych requestów
  });

  it('should send synchronization request when button clicked', () => {
    const button: HTMLButtonElement = fixture.nativeElement.querySelector('button')!;

    // 1. Kliknięcie przycisku
    button.click();
    fixture.detectChanges();

    // 2. Sprawdź, że sygnał zmienił się na true
    expect(component.syncInProgress()).toBeTrue();

    // 3. Sprawdź, że poszedł request HTTP
    const req = httpMock.expectOne('/api/inventory/sync');
    expect(req.request.method).toBe('POST');

    // 4. Symuluj odpowiedź backendu
    req.flush({});

    // 5. Po odpowiedzi sygnał powinien wrócić na false
    expect(component.syncInProgress()).toBeFalse();
  });
});
