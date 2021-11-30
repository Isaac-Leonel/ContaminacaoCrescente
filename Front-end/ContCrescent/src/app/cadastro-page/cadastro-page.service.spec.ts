import { TestBed } from '@angular/core/testing';

import { CadastroPageService } from './cadastro-page.service';

describe('CadastroPageService', () => {
  let service: CadastroPageService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CadastroPageService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
