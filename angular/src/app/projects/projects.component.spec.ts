import { TestBed, inject } from '@angular/core/testing';
import { HttpEvent, HttpEventType } from '@angular/common/http';

import {
  HttpClientTestingModule,
  HttpTestingController
} from '@angular/common/http/testing';

import { Im3wsService } from '../services/im3ws.service';

describe('ProjectService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [Im3wsService]
    });
  });

  it(
    'should get projects',
    inject(
      [HttpTestingController, Im3wsService],
      (httpMock: HttpTestingController, projectService: Im3wsService) => {
        const mockProjects = [
          { id: 1, name: 'Prueba Spring'}
        ];

        /*projectService.getProjects$().subscribe(value)
        projectService.getProjects$().subscribe((event: HttpEvent<any>) => {
          switch (event.type) {
            case HttpEventType.Response:
              expect(event.body).toEqual(mockProjects);
          }
        });*/

        const mockReq = httpMock.expectOne(projectService.urlProject);

        expect(mockReq.cancelled).toBeFalsy();
        expect(mockReq.request.responseType).toEqual('json');
        mockReq.flush(mockProjects);

        httpMock.verify();
      }
    )
  );
});

/* TO-DO Hacer este test */
